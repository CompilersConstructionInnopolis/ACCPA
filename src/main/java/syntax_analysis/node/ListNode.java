package syntax_analysis.node;

import interpreter.DefinedFunction;
import interpreter.PredefinedFunction;
import syntax_analysis.node.type_node.ListType;
import syntax_analysis.node.type_node.NodeType;
import syntax_analysis.node.type_node.UnitType;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ListNode implements ElementInterface {
    public List<ElementInterface> elements;

    public ListNode() {
        elements = new ArrayList<>();
    }

    public ListNode(ElementInterface element) {
        elements = new ArrayList<>();
        elements.add(element);
    }

    public ListNode(List<ElementInterface> elements) {
        this.elements = new ArrayList<>();
        this.elements.addAll(elements);
    }

    public ListNode(ElementInterface element, ListNode list) {
        elements = new ArrayList<>();
        elements.add(element);
        elements.addAll(list.elements);
    }

    @Override
    public String toString() {
        return "'(" + elements.stream().filter(Objects::nonNull).map(Object::toString).collect(Collectors.joining(" ")) + ")";
    }

    @Override
    public ElementInterface evaluate() {
        PredefinedFunction predefinedFunction = new PredefinedFunction(elements);
        if (predefinedFunction.isPredefinedFunction()) {
            return predefinedFunction.performFunctionAction();
        }
        DefinedFunction definedFunction = new DefinedFunction(elements);
        if (definedFunction.isDefinedFunction()) {
            return definedFunction.performFunctionAction();
        }
        List<ElementInterface> evaluatedElements = new ArrayList<>();
        for (ElementInterface element : elements) {
            ElementInterface evaluatedElement = element.evaluate();
            evaluatedElements.add(evaluatedElement);
        }
        return new ListNode(evaluatedElements);
    }

    @Override
    public NodeType getReturnType() {
        PredefinedFunction predefinedFunction = new PredefinedFunction(elements);
        if (predefinedFunction.isPredefinedFunction()) {
            // todo return function type
            throw new RuntimeException("Not implemented in ListNode :(");
        }
        DefinedFunction definedFunction = new DefinedFunction(elements);
        if (definedFunction.isDefinedFunction()) {
            // todo return function type
            throw new RuntimeException("Not implemented in ListNode :(");
        }
        if (elements.isEmpty()) {
            return new ListType(new UnitType());
        }
        NodeType listType = elements.get(0).getReturnType();
        if (!elements.stream().map(ElementInterface::getReturnType).allMatch(type -> type.isEqualType(listType))) {
            throw new RuntimeException("List must be homogeneous");
        }
        return new ListType(listType);
    }
}
