package syntax_analysis.node.special_form;

import interpreter.AtomsTable;
import interpreter.FunctionsTable;
import lexical_analysis.tokens.Token;
import syntax_analysis.node.AtomNode;
import syntax_analysis.node.ElementInterface;
import syntax_analysis.node.FunctionAtom;
import syntax_analysis.node.type_node.FunctionType;
import syntax_analysis.node.type_node.ListOfTypes;
import syntax_analysis.node.type_node.NodeType;
import syntax_analysis.node.type_node.UnitType;

import java.util.List;

public class FuncNode implements ElementInterface {
    AtomNode functionName;
    ElementInterface argumentsList;
    ElementInterface functionBody;

    Token token;

    public FuncNode(AtomNode functionName, ElementInterface argumentsList, ElementInterface functionBody) {
        this.functionName = functionName;
        this.argumentsList = argumentsList;
        this.functionBody = functionBody;
    }

    public FuncNode(AtomNode functionName, ElementInterface argumentsList, ElementInterface functionBody, Token token) {
        this.functionName = functionName;
        this.argumentsList = argumentsList;
        this.functionBody = functionBody;
        this.token = token;
    }

    @Override
    public ElementInterface evaluate() {

        if (!FunctionAtom.checkFunctionArguments(argumentsList)) {
            throw new RuntimeException("The second argument should contain a number of atoms that represent " +
                    "the function parameters: " + argumentsList);
        }
//        if (FunctionsTable.getInstance().contains(functionName.name)) {
//            throw new RuntimeException("The function is already defined: " + functionName.name);
//        }
        if (AtomsTable.getInstance().contains(functionName.name)) {
            throw new RuntimeException("Can't name a function with already defined identifier name: " + functionName.name);
        }
        FunctionAtom function = new FunctionAtom(FunctionAtom.getListFunctionArguments(argumentsList), functionBody);
        functionName.value = function;

        FunctionType functionParametersType = (FunctionType) getType(function.arguments);
        if (FunctionsTable.getInstance().containsInCurrentContext(functionName.name)) {
            FunctionType functionType = (FunctionType) FunctionsTable.getInstance().getFunctionType(functionName.name);
            if (!functionType.isEqualType(functionParametersType)) {
                throw new RuntimeException("Trying to assign to atom <" + functionName.name + "> of type <" + functionType.toString() + "> the value of type <" + functionParametersType.toString() + ">");
            }
            functionParametersType = functionParametersType.inferTypes(functionType);
        }
        FunctionsTable.getInstance().addFunction(functionName.name, function, functionParametersType);
        return null;
    }

    private NodeType getType(List<AtomNode> args) {
        if (args.isEmpty()) {
            return new FunctionType(new UnitType(), new ListOfTypes(), functionBody.getReturnType());
        }
        ListOfTypes restArgs = new ListOfTypes();
        for (int i = 1; i < args.size(); i++) {
            restArgs.elements.add(args.get(i).getReturnType());
        }
        return new FunctionType(args.get(0).getReturnType(), restArgs, functionBody.getReturnType());
    }

    @Override
    public NodeType getReturnType() {
        return functionBody.getReturnType();
    }

    @Override
    public String toString() {
        return "FuncNode{" +
                "atom=" + functionName +
                ", list=" + argumentsList +
                ", element=" + functionBody +
                ", token=" + token +
                '}';
    }
}
