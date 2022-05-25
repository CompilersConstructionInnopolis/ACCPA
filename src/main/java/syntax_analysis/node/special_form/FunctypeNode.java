package syntax_analysis.node.special_form;

import syntax_analysis.node.AtomNode;
import syntax_analysis.node.ElementInterface;
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
//        if (PredefinedFunction.isKeyword(atom.name)) {
//            throw new RuntimeException("Can't reassign keyword: " + atom.name);
//        }
//        if (DefinedFunction.isDefinedFunction(atom.name)) {
//            throw new RuntimeException("There is a defined function: " + atom.name);
//        }
//        atom.value = element.evaluate();
//        AtomsTable.getInstance().addAtom(atom);
        return null;
    }

    @Override
    public NodeType getReturnType() {
        // todo
        return null;
    }

    @Override
    public String toString() {
        return "FunctypeNode{" +
                "atom=" + atom +
                ", atomType=" + atomType +
                '}';
    }
}
