package syntax_analysis.node.special_form;

import lexical_analysis.tokens.Token;
import syntax_analysis.node.ElementInterface;
import syntax_analysis.node.LiteralNode;
import syntax_analysis.node.type_node.NodeType;

public
class CondNode implements ElementInterface {
    ElementInterface condition;
    ElementInterface trueAction;
    ElementInterface falseAction;

    Token token;

    public CondNode(ElementInterface condition, ElementInterface trueAction) {
        this.condition = condition;
        this.trueAction = trueAction;
        this.falseAction = null;
    }

    public CondNode(ElementInterface condition, ElementInterface trueAction, ElementInterface falseAction) {
        this.condition = condition;
        this.trueAction = trueAction;
        this.falseAction = falseAction;
    }

    public CondNode(ElementInterface condition, ElementInterface trueAction, Token token) {
        this.condition = condition;
        this.trueAction = trueAction;
        this.falseAction = null;
        this.token = token;
    }

    public CondNode(ElementInterface condition, ElementInterface trueAction, ElementInterface falseAction, Token token) {
        this.condition = condition;
        this.trueAction = trueAction;
        this.falseAction = falseAction;
        this.token = token;
    }

    @Override
    public ElementInterface evaluate() {
        ElementInterface conditionEvaluation = condition.evaluate();
        if ((conditionEvaluation instanceof LiteralNode) && ((LiteralNode) conditionEvaluation).booleanValue != null) {
            boolean conditionValue = ((LiteralNode) conditionEvaluation).booleanValue;
            if (conditionValue) {
                return this.trueAction.evaluate();
            }
            if (this.falseAction == null) {
                return new LiteralNode();
            }
            return this.falseAction.evaluate();
        }
        throw new RuntimeException("First element in 'cond' should be boolean, but given " + condition);
    }

    @Override
    public NodeType getReturnType() {
        // todo
        return null;
    }

    @Override
    public String toString() {
        return "CondNode{" +
                "condition=" + condition +
                ", trueAction=" + trueAction +
                ", falseAction=" + falseAction +
                '}';
    }
}