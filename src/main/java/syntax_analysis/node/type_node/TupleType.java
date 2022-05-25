package syntax_analysis.node.type_node;

import lexical_analysis.tokens.Token;

import java.util.ArrayList;
import java.util.List;

public class TupleType implements NodeType {
    List<NodeType> elements;

    Token token;

    public TupleType(NodeType type1, NodeType type2, ListOfTypes restElements) {
        this.elements = new ArrayList<>();
        this.elements.add(type1);
        this.elements.add(type2);
        this.elements.addAll(restElements.elements);
    }

    public TupleType(NodeType type1, NodeType type2, ListOfTypes restElements, Token token) {
        this.elements = new ArrayList<>();
        this.elements.add(type1);
        this.elements.add(type2);
        this.elements.addAll(restElements.elements);
        this.token = token;
    }

    @Override
    public String toString() {
        return "TupleType{" +
                "elements=" + elements +
                '}';
    }

    @Override
    public boolean isEqualType(NodeType other) {
        if (other instanceof TupleType) {
            TupleType otherTuple = (TupleType) other;
            if (otherTuple.elements.size() == elements.size()) {
                for (int i = 0; i < elements.size(); i++) {
                    if (!elements.get(i).isEqualType(otherTuple.elements.get(i))) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }
}
