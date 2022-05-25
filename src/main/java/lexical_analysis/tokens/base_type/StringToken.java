package lexical_analysis.tokens.base_type;

public class StringToken extends BaseTypeToken {
    public StringToken(int row, int column, String content) {
        super(row, column, content);
    }
}
