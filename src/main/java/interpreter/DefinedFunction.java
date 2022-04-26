package interpreter;

import exceptions.FunctionTypeException;
import syntax_analysis.node.*;

import java.util.ArrayList;
import java.util.List;

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
        var parametersOfFunction = parameters.subList(1, parameters.size());
        var givenTypes = TypesTable.getInstance().getTypesTable().get(atom.name);
        if (givenTypes == null) {
            throw new FunctionTypeException("\nSpecify types for function \"" + atom.name + "\"", true);
        }
        var types = ((ListNode) givenTypes).elements;
        var temp = 0;
        for (var param : parametersOfFunction) {
            var eval_param = param.evaluate();
            var eval_param_type = eval_param.getClass().getSimpleName();
            var type = types.get(temp);
            if (eval_param_type.equals("LiteralNode")) {
                var value_of_param = ((LiteralNode) eval_param).getValue();
                if (type.toString().equals("int")) {
                    if (!(value_of_param instanceof Integer)) {
                        throw new FunctionTypeException(
                                "\nWrong type of parameter for function \"" + atom.name + "\"\nGiven \"" + eval_param +
                                        "\" but expected value of Integer type", true);
                    }
                } else if (type.toString().equals("double")) {
                    if (!(value_of_param instanceof Double)) {
                        throw new FunctionTypeException(
                                "\nWrong type of parameter for function \"" + atom.name + "\"\nGiven \"" + eval_param +
                                        "\" but expected value of Double type", true);
                    }
                } else if (type.toString().equals("boolean")) {
                    if (!(value_of_param instanceof Boolean)) {
                        throw new FunctionTypeException(
                                "\nWrong type of parameter for function \"" + atom.name + "\"\nGiven \"" + eval_param +
                                        "\" but expected value of Boolean type", true);
                    }
                } else {
                    throw new FunctionTypeException(
                            "\nWrong type of parameter for function \"" + atom.name + "\"\nGiven \"" + eval_param +
                                    "\" but expected value of List type", true);
                }
            } else if (eval_param_type.equals("ListNode")) {
                var value_of_param = ((ListNode) eval_param).elements;
                if (type.toString().equals("int")) {
                    throw new FunctionTypeException(
                            "\nWrong type of returned value for function \"" + atom.name + "\"\nGot \"" +
                                    value_of_param +
                                    "\" but expected integer type", true);
                }
                if (type.toString().equals("double")) {
                    throw new FunctionTypeException(
                            "\nWrong type of returned value for function \"" + atom.name + "\"\nGot \"" +
                                    value_of_param +
                                    "\" but expected double type", true);
                }
                if (type.toString().equals("boolean")) {
                    throw new FunctionTypeException(
                            "\nWrong type of returned value for function \"" + atom.name + "\"\nGot \"" +
                                    value_of_param +
                                    "\" but expected boolean type", true);
                }
                if (type.toString().equals("'(int)") ) {
                    for (var val : value_of_param) {
                        var e_value = ((LiteralNode) val).getValue();
                        if (!(e_value instanceof Integer)) {
                            throw new FunctionTypeException(
                                    "\nWrong type of parameter inside " + type + " for function \"" + atom.name +
                                            "\"\nGiven \"" + e_value +
                                            "\" but expected value of Integer type", true);
                        }
                    }
                } else if (type.toString().equals("'(double)")) {
                    for (var val : value_of_param) {
                        var e_value = ((LiteralNode) val).getValue();
                        if (!(e_value instanceof Double)) {
                            throw new FunctionTypeException(
                                    "\nWrong type of parameter inside " + type + " for function \"" + atom.name +
                                            "\"\nGiven \"" + e_value +
                                            "\" but expected value of Double type", true);
                        }
                    }
                } else if (type.toString().equals("'(boolean)")) {
                    for (var val : value_of_param) {
                        var e_value = ((LiteralNode) val).getValue();
                        if (!(e_value instanceof Boolean)) {
                            throw new FunctionTypeException(
                                    "\nWrong type of parameter inside " + type + " for function \"" + atom.name +
                                            "\"\nGiven \"" + e_value +
                                            "\" but expected value of Boolean type", true);
                        }
                    }
                }
            }
            temp += 1;
        }
        function.setParameters(parameters.subList(1, parameters.size()));
        var result = function.evaluate();
        var result_node_class = result.getClass().getSimpleName();
        var returnedType = types.get(temp);

        if (result_node_class.equals("LiteralNode")) {
            var resultLiteralNode = ((LiteralNode) result).getValue();
            if (returnedType.toString().equals("int")) {
                if (!(resultLiteralNode instanceof Integer)) {
                    throw new FunctionTypeException(
                            "\nWrong type of returned value for function \"" + atom.name + "\"\nGot \"" +
                                    resultLiteralNode +
                                    "\" but expected Integer type", true);
                }
            } else if (returnedType.toString().equals("double")) {
                if (!(resultLiteralNode instanceof Double)) {
                    throw new FunctionTypeException(
                            "\nWrong type of returned value for function \"" + atom.name + "\"\nGot \"" +
                                    resultLiteralNode +
                                    "\" but expected Double type", true);
                }
            } else if (returnedType.toString().equals("boolean")) {
                if (!(resultLiteralNode instanceof Boolean)) {
                    throw new FunctionTypeException(
                            "\nWrong type of returned value for function \"" + atom.name + "\"\nGot \"" +
                                    resultLiteralNode +
                                    "\" but expected Boolean type", true);
                }
            } else {
                throw new FunctionTypeException(
                        "\nWrong type of returned value for function \"" + atom.name + "\"\nGot \"" +
                                resultLiteralNode +
                                "\" but expected List type", true);
            }
        } else if (result_node_class.equals("ListNode")) {
            var resultLiteralNode = ((ListNode) result).elements;
            if (returnedType.toString().equals("int")) {
                throw new FunctionTypeException(
                        "\nWrong type of returned value for function \"" + atom.name + "\"\nGot \"" +
                                resultLiteralNode +
                                "\" but expected integer type", true);
            }
            if (returnedType.toString().equals("double")) {
                throw new FunctionTypeException(
                        "\nWrong type of returned value for function \"" + atom.name + "\"\nGot \"" +
                                resultLiteralNode +
                                "\" but expected double type", true);
            }
            if (returnedType.toString().equals("boolean")) {
                throw new FunctionTypeException(
                        "\nWrong type of returned value for function \"" + atom.name + "\"\nGot \"" +
                                resultLiteralNode +
                                "\" but expected boolean type", true);
            }

            if (returnedType.toString().equals("'(int)")) {
                for (var val : resultLiteralNode) {
                    if (val != null) {
                        Object e_value = null;
                        if (val instanceof LiteralNode) {
                            e_value = ((LiteralNode) val.evaluate()).getValue();
                        } else {
                            e_value = ((ListNode) val.evaluate()).elements;
                            e_value = ((ArrayList) e_value).get(0);
                            e_value = ((LiteralNode) e_value).getValue();
                        }
                        if (!(e_value instanceof Integer)) {
                            throw new FunctionTypeException(
                                    "\nWrong type of returned value for function \"" + atom.name + "\"\nGot \"" +
                                            e_value +
                                            "\" but expected List of integer type", true);
                        }
                    }
                }
            } else if (returnedType.toString().equals("'(double)") || returnedType.toString().equals("double")) {
                for (var val : resultLiteralNode) {
                    if (val != null) {
                        Object e_value = null;
                        if (val instanceof LiteralNode) {
                            e_value = ((LiteralNode) val.evaluate()).getValue();
                        } else {
                            e_value = ((ListNode) val.evaluate()).elements;
                            e_value = ((ArrayList) e_value).get(0);
                            e_value = ((LiteralNode) e_value).getValue();
                        }
                        if (!(e_value instanceof Double)) {
                            throw new FunctionTypeException(
                                    "\nWrong type of returned value for function \"" + atom.name + "\"\nGot \"" +
                                            e_value +
                                            "\" but expected List of double type", true);
                        }
                    }
                }
            } else if (returnedType.toString().equals("'(boolean)") || returnedType.toString().equals("boolean")) {
                for (var val : resultLiteralNode) {
                    if (val != null) {
                        Object e_value = null;
                        if (val instanceof LiteralNode) {
                            e_value = ((LiteralNode) val.evaluate()).getValue();
                        } else {
                            e_value = ((ListNode) val.evaluate()).elements;
                            e_value = ((ArrayList) e_value).get(0);
                            e_value = ((LiteralNode) e_value).getValue();
                        }
                        if (!(e_value instanceof Boolean)) {
                            throw new FunctionTypeException(
                                    "\nWrong type of returned value for function \"" + atom.name + "\"\nGot \"" +
                                            e_value +
                                            "\" but expected List of boolean type", true);
                        }
                    }
                }
            }
        }
        return result;
    }
}
