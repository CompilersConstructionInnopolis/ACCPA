package syntax_analysis.node;

import interpreter.TypesTable;

public class FuncTypeNode implements ElementInterface {

    AtomNode functionName;
    ElementInterface argumentsTypesList;

    public FuncTypeNode(AtomNode functionName, ElementInterface argumentsTypesList) {
        this.functionName = functionName;
        this.argumentsTypesList = argumentsTypesList;
    }

    @Override
    public ElementInterface evaluate() {
        TypesTable.getInstance().addFunctionAndType(functionName, argumentsTypesList);
        return null;
    }
}
