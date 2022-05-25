package syntax_analysis.node.type_node;

import lexical_analysis.tokens.Token;

public class ListType implements NodeType {
    public NodeType elementType;

    public Token token;

    public ListType(NodeType elementType) {
        this.elementType = elementType;
    }

    public ListType(NodeType elementType, Token token) {
        this.elementType = elementType;
        this.token = token;
    }

    @Override
    public String toString() {
        return "'(" + elementType + ")";
    }

    @Override
    public boolean isEqualType(NodeType other) {
        if (other instanceof ListType) {
            ListType otherList = (ListType) other;
//            if (elementType instanceof UnitType) {
//                return true;
//            }
//            if (otherList.elementType instanceof UnitType) {
//                return true;
//            }
            return elementType.isEqualType(otherList.elementType);
        }
        return false;
    }
}
