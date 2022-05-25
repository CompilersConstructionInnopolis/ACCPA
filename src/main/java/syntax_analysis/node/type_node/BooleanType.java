package syntax_analysis.node.type_node;

public class BooleanType implements NodeType{
    @Override
    public String toString() {
        return "Boolean";
    }

    @Override
    public boolean isEqualType(NodeType other) {
        return other instanceof BooleanType;
    }
}
