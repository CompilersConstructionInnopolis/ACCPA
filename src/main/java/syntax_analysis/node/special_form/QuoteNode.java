package syntax_analysis.node.special_form;

import lexical_analysis.tokens.Token;
import syntax_analysis.node.ElementInterface;
import syntax_analysis.node.type_node.NodeType;

public class QuoteNode implements ElementInterface {
    ElementInterface element;

    Token token;
    public QuoteNode(ElementInterface element) {
        this.element = element;
    }

    public QuoteNode(ElementInterface element, Token token) {
        this.element = element;
        this.token = token;
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
