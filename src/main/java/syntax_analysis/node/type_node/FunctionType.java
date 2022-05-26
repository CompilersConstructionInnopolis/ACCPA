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

    @Override
    public String toString() {
        return "FunctionType{" +
                "argumentType=" + argumentType +
                ", returnType=" + returnType +
                '}';
    }

    @Override
    public boolean isEqualType(NodeType other) {
        if (other == null) {
            return true;
        }
        if (other instanceof FunctionType) {
            FunctionType otherFunction = (FunctionType) other;
            if (returnType == null || returnType.isEqualType(otherFunction.returnType)) {
                if (otherFunction.argumentType.size() == argumentType.size()) {
                    for (int i = 0; i < argumentType.size(); i++) {
                        NodeType arg = argumentType.get(i);
                        if (arg != null && (!argumentType.get(i).isEqualType(otherFunction.argumentType.get(i)))) {
                            return false;
                        }
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public FunctionType inferTypes(FunctionType other) {
        NodeType ret = inferType(this.returnType, other.returnType);
        List<NodeType> args = new ArrayList<>();
        for (int i = 0; i < this.argumentType.size(); i++) {
            args.add(inferType(this.argumentType.get(i), other.argumentType.get(i)));
        }
        if (args.isEmpty()) {
            return new FunctionType(new UnitType(), new ListOfTypes(), ret);
        }
        ListOfTypes restArgs = new ListOfTypes();
        for (int i = 1; i < args.size(); i++) {
            restArgs.elements.add(args.get(i));
        }
        return new FunctionType(args.get(0), restArgs, ret);
    }

    private NodeType inferType(NodeType type, NodeType other) {
        NodeType res = type;
        if (type == null) {
            res = other;
        } else if (type instanceof AnyType) {
            if (other != null) {
                res = other;
            }
        } else if (type instanceof NumType) {
            if (other != null && (other instanceof IntType || other instanceof DoubleType)) {
                res = other;
            }
        }
        if (res == null) {
            return new AnyType();
        }
        return res;
    }
}
