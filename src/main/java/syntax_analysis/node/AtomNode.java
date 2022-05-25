package syntax_analysis.node;

import interpreter.AtomsTable;
import interpreter.FunctionsTable;
import lexical_analysis.tokens.Token;
import syntax_analysis.node.type_node.NodeType;

public class AtomNode implements ElementInterface {
    public String name;
    public ElementInterface value;
    public NodeType type;
    public Token token;

    public AtomNode(String name,
                    ElementInterface value,
                    NodeType type) {
        this.name = name;
        this.value = value;
        this.type = type;
    }

    public AtomNode(Token token) {
        name = token.getContent();
        value = null;
        type = null;
        this.token = token;
    }

    public AtomNode(String name, ElementInterface value) {
        this.name = name;
        this.value = value;
    }

    public AtomNode(String name, ElementInterface value, Token token) {
        this.name = name;
        this.value = value;
        this.token = token;
    }


    @Override
    public ElementInterface evaluate() {
        if (AtomsTable.getInstance().contains(name)) {
            ElementInterface value = AtomsTable.getInstance().getAtomValue(name);
            if (value == null) {
                throw new RuntimeException("Atom '" + name + "' has no assigned value");
            }
            return value;
        }
        if (FunctionsTable.getInstance().contains(name)) {
            return FunctionsTable.getInstance().getFunctionValue(name);
        }
        throw new RuntimeException("Undefined atom: " + name);
    }

//    @Override
//    public List<NodeType> getArgumentType() {
////        if (type != null){
////            List<NodeType> args = new ArrayList<>();
////            args.add(type);
////            return args;
////        }
//        return null;
//    }

//    @Override
//    public void setArgumentType() {
//
//    }

    @Override
    public NodeType getReturnType() {
        return type;
    }

//    @Override
//    public void setReturnType(NodeType type) {
//
//    }


    @Override
    public String toString() {
        return name;
    }
}