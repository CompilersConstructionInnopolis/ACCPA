package syntax_analysis.node.type_node;

import java.util.ArrayList;
import java.util.List;

public class ListOfTypes implements NodeType {
    public List<NodeType> elements;

    public ListOfTypes() {
        elements = new ArrayList<>();
    }

    public ListOfTypes(NodeType element, ListOfTypes list) {
        elements = new ArrayList<>();
        elements.add(element);
        elements.addAll(list.elements);
    }

    @Override
    public String toString() {
        return "ListOfTypes{" +
                "elements=" + elements +
                '}';
    }

    @Override
    public boolean isEqualType(NodeType other) {
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
