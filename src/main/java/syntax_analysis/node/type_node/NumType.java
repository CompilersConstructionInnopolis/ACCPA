package syntax_analysis.node.type_node;

public class NumType implements NodeType {
    @Override
    public String toString() {
        return "Num";
    }

    @Override
    public boolean isEqualType(NodeType other) {
        return other instanceof NumType || other instanceof IntType || other instanceof DoubleType;
    }
}
