package syntax_analysis.node;

import interpreter.DefinedFunction;
import interpreter.PredefinedFunction;
import syntax_analysis.node.type_node.NodeType;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class TupleNode implements ElementInterface {
    public List<ElementInterface> elements;

    public TupleNode(ElementInterface element1, ElementInterface element2, ListNode restElements) {
        elements = new ArrayList<>();
        elements.add(element1);
        elements.add(element2);
        elements.addAll(restElements.elements);
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
        // todo
        return null;
    }
}

