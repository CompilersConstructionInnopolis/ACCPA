package syntax_analysis.node.type_node;

public class AutoType implements NodeType{
    @Override
    public String toString() {
        return "Auto";
    }

    @Override
    public boolean isEqualType(NodeType other) {
        return other instanceof AutoType;
    }
}
