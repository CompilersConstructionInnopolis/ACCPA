package syntax_analysis.node.special_form;

import interpreter.AtomsTable;
import interpreter.FunctionsTable;
import syntax_analysis.node.AtomNode;
import syntax_analysis.node.ElementInterface;
import syntax_analysis.node.type_node.AnyType;
import syntax_analysis.node.type_node.FunctionType;
import syntax_analysis.node.type_node.NodeType;

public class FunctypeNode implements ElementInterface {
    AtomNode atom;
    FunctionType atomType;

    public FunctypeNode(AtomNode atom, FunctionType atomType) {
        this.atom = atom;
        this.atomType = atomType;
    }

    @Override
    public ElementInterface evaluate() {
        if (FunctionsTable.getInstance().contains(atom.name)) {
            throw new RuntimeException("The function is already defined: " + atom.name);
        }
        if (AtomsTable.getInstance().contains(atom.name)) {
            throw new RuntimeException("Can't name a function with already defined identifier name: " + atom.name);
        }
        FunctionsTable.getInstance().defineFunction(atom.name, atomType);
        return null;
    }

    @Override
    public NodeType getReturnType() {
        // todo
        return new AnyType();
    }

    @Override
    public String toString() {
        return "FunctypeNode{" +
                "atom=" + atom +
                ", atomType=" + atomType +
                '}';
    }
}
