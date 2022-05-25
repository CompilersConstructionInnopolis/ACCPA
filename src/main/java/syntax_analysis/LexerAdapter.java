package syntax_analysis;

import lexical_analysis.Lexer;
import lexical_analysis.tokens.Token;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.List;

public class LexerAdapter implements Parser.Lexer {

    final private List<Token> tokens;
    private int currentTokenIndex;
    private Token currentToken;

    private final String RUNNABLE_PROGRAM_PATH = "code/run.txt";
    private File runnableFile = new File(RUNNABLE_PROGRAM_PATH);

    public LexerAdapter(FileReader fileReader) throws IOException {
        Lexer lexer = new Lexer(fileReader);
        lexer.tokenize();
        tokens = lexer.getTokens();
        currentTokenIndex = 0;
    }

    public List<Token> getTokens() {
        return tokens;
    }

    @Override
    public Token getLVal() {
        return currentToken;
    }

    @Override
    public int yylex() {
        if (currentTokenIndex == tokens.size()) {
            return YYEOF;
        }
        currentToken = tokens.get(currentTokenIndex++);
        String tokenName = currentToken.getClass().getSimpleName();
        int tokenCode = YYerror;
        try {
            Field field = Parser.Lexer.class.getDeclaredField(tokenName);
            tokenCode = (Integer) field.get(Parser.Lexer.class);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return tokenCode;
    }

    @Override
    public void yyerror(String msg) {
        if (currentToken == null) {
            runnableFile.delete();
            System.exit(1);
        }
        System.out.println("Syntax error!\n" + "At " + currentToken);
        runnableFile.delete();
        System.exit(1);
    }
}