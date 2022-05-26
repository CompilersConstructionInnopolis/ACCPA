package syntax_analysis.node.type_node;

import lexical_analysis.tokens.Token;

public class DoubleType implements NodeType{

    Token token;
    public DoubleType() {
    }

    public DoubleType(Token token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "Double";
    }

    @Override
    public boolean isEqualType(NodeType other) {
        return other == null || other instanceof AutoType || other instanceof AnyType ||  other instanceof DoubleType;
    }
}
