package syntax_analysis.node.type_node;

import lexical_analysis.tokens.Token;

public class StringType implements NodeType{

    Token token;

    public StringType() {
    }

    public StringType(Token token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "String";
    }

    @Override
    public boolean isEqualType(NodeType other) {
        return other == null || other instanceof AutoType || other instanceof AnyType ||  other instanceof StringType;
    }
}
