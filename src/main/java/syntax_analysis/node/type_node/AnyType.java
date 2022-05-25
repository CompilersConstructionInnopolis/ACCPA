package syntax_analysis.node.type_node;

public class AnyType implements NodeType{

    @Override
    public String toString() {
        return "Any";
    }

    @Override
    public boolean isEqualType(NodeType other) {
        return other instanceof AnyType;
    }
}
