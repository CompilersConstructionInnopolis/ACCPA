package interpreter;

import syntax_analysis.node.AtomNode;
import syntax_analysis.node.ElementInterface;
import syntax_analysis.node.type_node.AutoType;
import syntax_analysis.node.type_node.NodeType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AtomsTable {

    public class AtomValueType {
        ElementInterface value;
        NodeType type;

        public AtomValueType(ElementInterface value, NodeType type) {
            this.value = value;
            this.type = type;
        }
    }

    private static AtomsTable INSTANCE;
    private final List<HashMap<String, AtomValueType>> localContext;

    private AtomsTable() {
        this.localContext = new ArrayList<>();
        this.localContext.add(new HashMap<>());
    }

    public static AtomsTable getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new AtomsTable();
        }
        return INSTANCE;
    }

    public void resetContext() {
        INSTANCE = new AtomsTable();
    }

    public void introduceLocalContext() {
        this.localContext.add(new HashMap<>());
    }

    public void leaveLocalContext() {
        this.localContext.remove(this.localContext.size() - 1);
    }

    public void addAtom(AtomNode atom) {
        final HashMap<String, AtomValueType> atoms = localContext.get(localContext.size() - 1);

        if (atoms.containsKey(atom.name)) {

            atoms.put(atom.name, new AtomValueType(atom.value, atom.type));

//            AtomValueType atomValueType = atoms.get(atom.name);
//            if (atomValueType.type instanceof AutoType) {
//                atoms.put(atom.name, new AtomValueType(atom.value, atom.type));
//            } else if (atomValueType.type.isEqualType(atom.type)) {
//                atoms.put(atom.name, new AtomValueType(atom.value, atom.type));
//            } else {
//                throw new RuntimeException("Atom: '" + atom.name + "'. Atom's type was already defined as '" + atomValueType.type.toString() + "'. Trying to assign value of type " + atom.type);
//            }
        } else {
            atoms.put(atom.name, new AtomValueType(atom.value, atom.type));
        }
    }

    public void defineAtom(AtomNode atom, NodeType type) {
        final HashMap<String, AtomValueType> atoms = localContext.get(localContext.size() - 1);
        if (atoms.containsKey(atom.name)) {
            throw new RuntimeException("Atom's type was already defined. Atom: " + atom.name);
        }
        atoms.put(atom.name, new AtomValueType(atom.value, type));
    }

    public ElementInterface getAtomValue(String atomName) {
        if (PredefinedFunction.predefinedFunctionNames.contains(atomName)) {
            return new AtomNode(atomName, null);
        }
        for (int i = localContext.size() - 1; i >= 0; i--) {
            final HashMap<String, AtomValueType> atoms = localContext.get(i);
            if (atoms.containsKey(atomName)) {
                return atoms.get(atomName).value;
            }
        }
        throw new RuntimeException("Undefined atom: " + atomName);
    }

    public NodeType getAtomType(String atomName) {
//        if (PredefinedFunction.predefinedFunctionNames.contains(atomName)) {
//            return new AtomNode(atomName, null);
//        }
        for (int i = localContext.size() - 1; i >= 0; i--) {
            final HashMap<String, AtomValueType> atoms = localContext.get(i);
            if (atoms.containsKey(atomName)) {
                return atoms.get(atomName).type;
            }
        }
        throw new RuntimeException("Undefined atom: " + atomName);
    }

    public boolean contains(String atomName) {
        if (PredefinedFunction.predefinedFunctionNames.contains(atomName)) {
            return true;
        }
        for (int i = localContext.size() - 1; i >= 0; i--) {
            final HashMap<String, AtomValueType> atoms = localContext.get(i);
            if (atoms.containsKey(atomName)) {
                return true;
            }
        }
        return false;
    }

    public boolean containsInCurrentContext(String atomName) {
        if (PredefinedFunction.predefinedFunctionNames.contains(atomName)) {
            return true;
        }
        final HashMap<String, AtomValueType> atoms = localContext.get(localContext.size() - 1);
        return atoms.containsKey(atomName);
    }
}
