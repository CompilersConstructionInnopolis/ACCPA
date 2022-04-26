package interpreter;

import syntax_analysis.node.AtomNode;
import syntax_analysis.node.ElementInterface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TypesTable {

    private static TypesTable INSTANCE;
    private HashMap<String, ElementInterface> typesTable = new HashMap<>();
    private final List<HashMap<String, ElementInterface>> localContext;

    private TypesTable() {
        this.localContext = new ArrayList<>();
        this.localContext.add(new HashMap<>());
    }

    public static TypesTable getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new TypesTable();
        }
        return INSTANCE;
    }

    public void resetContext() {
        INSTANCE = new TypesTable();
    }

    public void introduceLocalContext() {
        this.localContext.add(new HashMap<>());
    }

    public void leaveLocalContext() {
        this.localContext.remove(this.localContext.size() - 1);
    }

    public void addFunctionAndType(AtomNode atom, ElementInterface argumentsTypesList) {
        typesTable.put(atom.name, argumentsTypesList);
    }

    public HashMap<String, ElementInterface> getTypesTable() {
        return typesTable;
    }
}
