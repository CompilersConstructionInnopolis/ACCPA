package syntax_analysis.node.type_node;

import lexical_analysis.tokens.Token;

public class IntType implements NodeType{

    Token token;
    public IntType() {
    }

    public IntType(Token token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "Int";
    }

    @Override
    public boolean isEqualType(NodeType other) {
        return other instanceof IntType;
    }
}
