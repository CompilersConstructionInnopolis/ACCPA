package syntax_analysis.node.type_node;

import lexical_analysis.tokens.Token;

public class AnyType implements NodeType{

    Token token;

    public AnyType() {
    }

    public AnyType(Token token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "Any";
    }

    @Override
    public boolean isEqualType(NodeType other) {
        return other instanceof AnyType;
    }
}
