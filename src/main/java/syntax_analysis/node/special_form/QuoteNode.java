package syntax_analysis.node.special_form;

import syntax_analysis.node.ElementInterface;
import syntax_analysis.node.type_node.NodeType;

public class QuoteNode implements ElementInterface {
    ElementInterface element;

    public QuoteNode(ElementInterface element) {
        this.element = element;
    }

    @Override
    public ElementInterface evaluate() {
        return element;
    }

    @Override
    public NodeType getReturnType() {
        // todo
        return null;
    }

    @Override
    public String toString() {
        return "Quote={" + element + '}';
    }
}
