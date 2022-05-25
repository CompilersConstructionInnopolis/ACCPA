package syntax_analysis.node.type_node;

import lexical_analysis.tokens.Token;

public class UnitType implements NodeType{

    Token token;

    public UnitType() {
    }

    public UnitType(Token token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "Unit";
    }

    @Override
    public boolean isEqualType(NodeType other) {
        return other instanceof UnitType;
    }
}
