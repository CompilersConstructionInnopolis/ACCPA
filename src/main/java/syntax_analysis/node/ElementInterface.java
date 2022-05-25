package syntax_analysis.node;

import syntax_analysis.node.type_node.NodeType;

import java.util.List;

public interface ElementInterface {
    ElementInterface evaluate();

//    List<NodeType> getArgumentType();
//
//    void setArgumentType(List<NodeType>);
//
    NodeType getReturnType();
//
//    void setReturnType(NodeType type);
}
