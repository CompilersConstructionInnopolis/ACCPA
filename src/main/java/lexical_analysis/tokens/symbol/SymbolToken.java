package lexical_analysis.tokens.symbol;

import lexical_analysis.tokens.Token;

public class SymbolToken extends Token {
    public SymbolToken(int row, int column, String content) {
        super(row, column, content);
    }
}
