package syntax_analysis.node.type_node;

import lexical_analysis.tokens.Token;

public class BooleanType implements NodeType{


    Token token;

    public BooleanType() {
    }

    public BooleanType(Token token) {
        this.token = token;
    }


    @Override
    public String toString() {
        return "Boolean";
    }

    @Override
    public boolean isEqualType(NodeType other) {
        return other == null || other instanceof AutoType || other instanceof AnyType || other instanceof BooleanType;
    }
}
