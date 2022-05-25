package syntax_analysis.node.special_form;

import interpreter.AtomsTable;
import interpreter.FunctionsTable;
import syntax_analysis.node.AtomNode;
import syntax_analysis.node.ElementInterface;
import syntax_analysis.node.FunctionAtom;
import syntax_analysis.node.ListNode;
import syntax_analysis.node.type_node.NodeType;

public class ProgNode implements ElementInterface {
    ElementInterface arguments;
    ElementInterface elements;

    public ProgNode(ElementInterface arguments, ElementInterface elements) {
        this.arguments = arguments;
        this.elements = elements;
    }

    @Override
    public ElementInterface evaluate() {
        if (!FunctionAtom.checkFunctionArguments(arguments)) {
            throw new RuntimeException("The first parameter should be a list of atoms" +
                    "that represent the local context of the form." +
                    "Provided: " + arguments);
        }
        AtomsTable.getInstance().introduceLocalContext();
        FunctionsTable.getInstance().introduceLocalContext();

        for (AtomNode atom : FunctionAtom.getListFunctionArguments(arguments)) {
            AtomsTable.getInstance().addAtom(atom);
        }
        if (elements instanceof ListNode) {
            ElementInterface returnResult = null;
            for (ElementInterface element : ((ListNode) this.elements).elements) {
                returnResult = element.evaluate();
            }
            AtomsTable.getInstance().leaveLocalContext();
            FunctionsTable.getInstance().leaveLocalContext();
            return returnResult;
        } else {
            ElementInterface evaluatedElement = elements.evaluate();
            AtomsTable.getInstance().leaveLocalContext();
            FunctionsTable.getInstance().leaveLocalContext();
            return evaluatedElement;
        }
    }

    @Override
    public NodeType getReturnType() {
        // todo
        return null;
    }

    @Override
    public String toString() {
        return "ProgNode{" +
                "list=" + arguments +
                ", element=" + elements +
                '}';
    }
}
