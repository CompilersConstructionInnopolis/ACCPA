package syntax_analysis.node.type_node;

public class UnitType implements NodeType{
    @Override
    public String toString() {
        return "Unit";
    }

    @Override
    public boolean isEqualType(NodeType other) {
        return other instanceof UnitType;
    }
}
