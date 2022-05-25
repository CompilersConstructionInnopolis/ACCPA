package syntax_analysis.node;

import lexical_analysis.tokens.Token;
import lexical_analysis.tokens.literal.*;
import syntax_analysis.node.type_node.*;

public class LiteralNode implements ElementInterface {
    public Integer integerValue;
    public Double doubleValue;
    public Boolean booleanValue;

    public Token token;
    public String stringValue;

    public LiteralNode() {
    }

    public LiteralNode(int value) {
        integerValue = value;
    }

    public LiteralNode(double value) {
        doubleValue = value;
    }

    public LiteralNode(boolean value) {
        booleanValue = value;
    }

    public LiteralNode(String value) {
        stringValue = value;
    }


    public LiteralNode(String value, Token token) {
        stringValue = value;
        this.token = token;
    }

    public LiteralNode(LiteralToken token) {
        String content = token.getContent();
        if (token instanceof IntegerNumberLiteralToken) {
            this.integerValue = Integer.valueOf(content);
        } else if (token instanceof RealNumberLiteralToken) {
            this.doubleValue = Double.valueOf(content);
        } else if (token instanceof BooleanLiteralToken) {
            this.booleanValue = Boolean.valueOf(content);
        } else if (token instanceof StringLiteralToken) {
            this.stringValue = content;
        }
        this.token = token;
    }

    public Object getValue() {
        if (integerValue != null) {
            return integerValue;
        }
        if (doubleValue != null) {
            return doubleValue;
        }
        if (booleanValue != null) {
            return booleanValue;
        }
        if (stringValue != null) {
            return stringValue;
        }
        throw new RuntimeException("Literal value is null");
    }

    @Override
    public String toString() {
        if (integerValue != null) {
            return integerValue.toString();
        }
        if (doubleValue != null) {
            return doubleValue.toString();
        }
        if (booleanValue != null) {
            return booleanValue.toString();
        }
        if (stringValue != null) {
            return stringValue;
        }
        throw new RuntimeException("Literal value is null");
    }

    @Override
    public ElementInterface evaluate() {
        return this;
    }

    @Override
    public NodeType getReturnType() {
        if (integerValue != null) {
            return new IntType();
        }
        if (doubleValue != null) {
            return new DoubleType();
        }
        if (booleanValue != null) {
            return new BooleanType();
        }
        if (stringValue != null) {
            return new StringType();
        }
        throw new RuntimeException("Literal value is null");
    }
}