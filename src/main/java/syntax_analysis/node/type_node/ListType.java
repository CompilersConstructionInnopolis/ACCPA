package syntax_analysis.node.type_node;

public class ListType implements NodeType {
    public NodeType elementType;

    public ListType(NodeType elementType) {
        this.elementType = elementType;
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
