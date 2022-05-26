package syntax_analysis.node.type_node;

import lexical_analysis.tokens.Token;

import java.util.ArrayList;
import java.util.List;

public class ListOfTypes implements NodeType {
    public List<NodeType> elements;
    public Token token;

    public ListOfTypes() {
        elements = new ArrayList<>();
    }


    public ListOfTypes(NodeType element, ListOfTypes list) {
        elements = new ArrayList<>();
        elements.add(element);
        elements.addAll(list.elements);
    }

    public ListOfTypes(Token token) {
        elements = new ArrayList<>();
        this.token = token;
    }


    public ListOfTypes(NodeType element, ListOfTypes list, Token token) {
        elements = new ArrayList<>();
        elements.add(element);
        elements.addAll(list.elements);
        this.token = token;
    }

    @Override
    public String toString() {
        return "ListOfTypes{" +
                "elements=" + elements +
                '}';
    }

    @Override
    public boolean isEqualType(NodeType other) {
        if (other == null) {
            return true;
        }
        if (other instanceof ListOfTypes) {
            ListOfTypes otherList = (ListOfTypes) other;
            if (otherList.elements.size() == elements.size()) {
                for (int i = 0; i < elements.size(); i++) {
                    if (!elements.get(i).isEqualType(otherList.elements.get(i))) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }
}
