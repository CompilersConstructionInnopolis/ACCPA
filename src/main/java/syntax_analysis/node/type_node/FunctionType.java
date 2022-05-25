package syntax_analysis.node.type_node;

import lexical_analysis.tokens.Token;

import java.util.ArrayList;
import java.util.List;

public class FunctionType implements NodeType {
    public List<NodeType> argumentType;
    public NodeType returnType;

    public Token token;

    public FunctionType(NodeType arg, ListOfTypes restArgs, NodeType returnType) {
        this.argumentType = new ArrayList<>();
        this.argumentType.add(arg);
        this.argumentType.addAll(restArgs.elements);
        this.returnType = returnType;
    }

    public FunctionType(NodeType arg, ListOfTypes restArgs, NodeType returnType, Token token) {
        this.argumentType = new ArrayList<>();
        this.argumentType.add(arg);
        this.argumentType.addAll(restArgs.elements);
        this.returnType = returnType;
        this.token = token;
    }

    public boolean isEqualType(FunctionType other) {
        return true;
    }

    @Override
    public String toString() {
        return "FunctionType{" +
                "argumentType=" + argumentType +
                ", returnType=" + returnType +
                '}';
    }

    @Override
    public boolean isEqualType(NodeType other) {
        if (other instanceof FunctionType) {
            FunctionType otherFunction = (FunctionType) other;
            if (returnType.isEqualType(otherFunction.returnType)) {
                if (otherFunction.argumentType.size() == argumentType.size()) {
                    for (int i = 0; i < argumentType.size(); i++) {
                        if (!argumentType.get(i).isEqualType(otherFunction.argumentType.get(i))) {
                            return false;
                        }
                    }
                    return true;
                }
            }
        }
        return false;
    }
}
