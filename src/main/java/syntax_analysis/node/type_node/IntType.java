package syntax_analysis.node.type_node;

public class IntType implements NodeType{

    @Override
    public String toString() {
        return "Int";
    }

    @Override
    public boolean isEqualType(NodeType other) {
        return other instanceof IntType;
    }
}
