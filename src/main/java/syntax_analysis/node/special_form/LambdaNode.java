package syntax_analysis.node.special_form;

import lexical_analysis.tokens.Token;
import syntax_analysis.node.ElementInterface;
import syntax_analysis.node.FunctionAtom;
import syntax_analysis.node.type_node.NodeType;

public class LambdaNode implements ElementInterface {
    ElementInterface argumentsList;
    ElementInterface functionBody;

    Token token;

    public LambdaNode(ElementInterface argumentsList, ElementInterface functionBody) {
        this.argumentsList = argumentsList;
        this.functionBody = functionBody;
    }

    public LambdaNode(ElementInterface argumentsList, ElementInterface functionBody, Token token) {
        this.argumentsList = argumentsList;
        this.functionBody = functionBody;
        this.token = token;
    }

    @Override
    public ElementInterface evaluate() {
        if (!FunctionAtom.checkFunctionArguments(argumentsList)) {
            throw new RuntimeException("The first argument should contain a number of atoms that represent " +
                    "the lambda parameters: " + argumentsList);
        }
        return new FunctionAtom(FunctionAtom.getListFunctionArguments(argumentsList), functionBody);
    }

    @Override
    public NodeType getReturnType() {
        // todo
        return null;
    }

    @Override
    public String toString() {
        return "LambdaNode{" +
                "list=" + argumentsList +
                ", element=" + functionBody +
                '}';
    }
}
