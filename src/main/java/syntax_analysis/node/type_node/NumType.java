package syntax_analysis.node.type_node;

import lexical_analysis.tokens.Token;

public class NumType implements NodeType {

    Token token;

    public NumType() {
    }

    public NumType(Token token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "Num";
    }

    @Override
    public boolean isEqualType(NodeType other) {
        return other instanceof NumType || other instanceof IntType || other instanceof DoubleType;
    }
}
