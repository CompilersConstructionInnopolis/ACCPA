package syntax_analysis.node.type_node;

public class StringType implements NodeType{
    @Override
    public String toString() {
        return "String";
    }

    @Override
    public boolean isEqualType(NodeType other) {
        return other instanceof StringType;
    }
}
