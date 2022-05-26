package interpreter;

import syntax_analysis.node.ElementInterface;
import syntax_analysis.node.FunctionAtom;
import syntax_analysis.node.type_node.FunctionType;
import syntax_analysis.node.type_node.NodeType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FunctionsTable {

    public class FunctionValueType {
        ElementInterface value;
        NodeType type;

        public FunctionValueType(ElementInterface value, NodeType type) {
            this.value = value;
            this.type = type;
        }
    }

    private static FunctionsTable INSTANCE;
    private final List<HashMap<String, FunctionValueType>> localContext;

    private FunctionsTable() {
        this.localContext = new ArrayList<>();
        this.localContext.add(new HashMap<>());
    }

    public static FunctionsTable getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new FunctionsTable();
        }
        return INSTANCE;
    }

    public void resetTable() {
        INSTANCE = new FunctionsTable();
    }

    public void introduceLocalContext() {
        this.localContext.add(new HashMap<>());
    }

    public void leaveLocalContext() {
        this.localContext.remove(this.localContext.size() - 1);
    }


    public void addFunction(String atomName, FunctionAtom function, NodeType type) {
        final HashMap<String, FunctionValueType> functions = localContext.get(localContext.size() - 1);
        functions.put(atomName, new FunctionValueType(function, type));
    }

    public void defineFunction(String functionName, FunctionType functionType) {
        final HashMap<String, FunctionValueType> functions = localContext.get(localContext.size() - 1);
        if (functions.containsKey(functionName)) {
            throw new RuntimeException("Function's type was already defined. Function: " + functionName);
        }
        functions.put(functionName, new FunctionValueType(null, functionType));
    }

    public FunctionAtom getFunctionValue(String atomName) {
        for (int i = localContext.size() - 1; i >= 0; i--) {
            final HashMap<String, FunctionValueType> functions = localContext.get(i);
            if (functions.containsKey(atomName)) {
                return (FunctionAtom) functions.get(atomName).value;
            }
        }
        throw new RuntimeException("Undefined function: " + atomName);
    }

    public NodeType getFunctionType(String atomName) {
        for (int i = localContext.size() - 1; i >= 0; i--) {
            final HashMap<String, FunctionValueType> functions = localContext.get(i);
            if (functions.containsKey(atomName)) {
                return functions.get(atomName).type;
            }
        }
        throw new RuntimeException("Undefined function: " + atomName);
    }

    public boolean contains(String atomName) {
        for (int i = localContext.size() - 1; i >= 0; i--) {
            final HashMap<String, FunctionValueType> atoms = localContext.get(i);
            if (atoms.containsKey(atomName)) {
                return true;
            }
        }
        return false;
    }

    public boolean containsInCurrentContext(String atomName) {
        final HashMap<String, FunctionValueType> atoms = localContext.get(localContext.size() - 1);
        return atoms.containsKey(atomName);
    }
}