package interpreter;

import syntax_analysis.node.AtomNode;
import syntax_analysis.node.ElementInterface;
import syntax_analysis.node.FunctionAtom;
import syntax_analysis.node.type_node.FunctionType;
import syntax_analysis.node.type_node.ListOfTypes;
import syntax_analysis.node.type_node.NodeType;
import syntax_analysis.node.type_node.UnitType;

import java.util.List;
import java.util.stream.Collectors;

public class DefinedFunction {

    List<ElementInterface> parameters;

    public DefinedFunction(List<ElementInterface> parameters) {
        this.parameters = parameters;
    }

    public static boolean isDefinedFunction(String functionName) {
        return FunctionsTable.getInstance().contains(functionName);
    }

    public static boolean isDefinedFunction(ElementInterface element) {
        try {
            AtomNode atom = (AtomNode) element;
            return FunctionsTable.getInstance().contains(atom.name)
                    || (AtomsTable.getInstance().getAtomValue(atom.name) instanceof FunctionAtom);
        } catch (ClassCastException | IndexOutOfBoundsException e) {
            return false;
        }
    }

    public boolean isDefinedFunction() {
        if (parameters.isEmpty()) {
            return false;
        }
        return isDefinedFunction(parameters.get(0));
    }

    public ElementInterface performFunctionAction() {
        AtomNode atom = (AtomNode) parameters.get(0);
        FunctionAtom function;
        if (FunctionsTable.getInstance().contains(atom.name)) {
            function = FunctionsTable.getInstance().getFunctionValue(atom.name);
        } else if (AtomsTable.getInstance().getAtomValue(atom.name) instanceof FunctionAtom) {
            function = (FunctionAtom) AtomsTable.getInstance().getAtomValue(atom.name);
        } else {
            throw new RuntimeException(atom + " is not a function");
        }

        FunctionType functionType = (FunctionType) FunctionsTable.getInstance().getFunctionType(atom.name);
        if (functionType.argumentType.size() != parameters.size() - 1) {
            if (!(functionType.argumentType.size() == 1 && parameters.size() == 1 && functionType.argumentType.get(0) instanceof UnitType)) {
                throw new RuntimeException("For function " + atom.name + ". Required number of parameters: " + functionType.argumentType.size() + ". Provided: " + (parameters.size() - 1));
            }
        }

        function.setParameters(parameters.subList(1, parameters.size()));
        FunctionType type = getType(function.body.getReturnType());
        if (!functionType.isEqualType(type)) {
            throw new RuntimeException("Trying to assign to atom <" + atom.name + "> of type <" + functionType.toString() + "> the value of type <" + type.toString() + ">");
        }

        return function.evaluate();
    }

    private FunctionType getType(NodeType returnType) {
        List<NodeType> args = parameters.subList(1, parameters.size()).stream().map(ElementInterface::getReturnType).collect(Collectors.toList());
        ListOfTypes restArgs = new ListOfTypes();
        for (int i = 1; i < args.size(); i++) {
            restArgs.elements.add(args.get(i));
        }
        if (args.isEmpty()){
            return new FunctionType(new UnitType(), new ListOfTypes(), returnType);
        }
        return new FunctionType(args.get(0), restArgs, returnType);
    }
}
