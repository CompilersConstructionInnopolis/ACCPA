package syntax_analysis.node.type_node;

public class DoubleType implements NodeType{
    @Override
    public String toString() {
        return "Double";
    }

    @Override
    public boolean isEqualType(NodeType other) {
        return other instanceof DoubleType;
    }
}
