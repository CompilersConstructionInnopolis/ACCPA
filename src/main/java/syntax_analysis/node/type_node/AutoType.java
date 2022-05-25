package syntax_analysis.node.type_node;

import lexical_analysis.tokens.Token;

public class AutoType implements NodeType{

    Token token;
    public AutoType() {
    }

    public AutoType(Token token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "Auto";
    }

    @Override
    public boolean isEqualType(NodeType other) {
        return other instanceof AutoType;
    }
}
