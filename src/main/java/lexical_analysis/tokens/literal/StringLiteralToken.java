package lexical_analysis.tokens.literal;

public class StringLiteralToken extends LiteralToken {
    public StringLiteralToken(int row, int column, String content) {
        super(row, column, content);
    }
}
