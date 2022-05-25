package syntax_analysis.node.special_form;

import interpreter.AtomsTable;
import interpreter.DefinedFunction;
import interpreter.PredefinedFunction;
import syntax_analysis.node.AtomNode;
import syntax_analysis.node.ElementInterface;
import syntax_analysis.node.type_node.*;

public class SetQNode implements ElementInterface {
    AtomNode atom;
    ElementInterface element;

    public SetQNode(AtomNode atom, ElementInterface element) {
        this.atom = atom;
        this.element = element;
    }

    @Override
    public ElementInterface evaluate() {
        if (PredefinedFunction.isKeyword(atom.name)) {
            throw new RuntimeException("Can't reassign keyword: " + atom.name);
        }
        if (DefinedFunction.isDefinedFunction(atom.name)) {
            throw new RuntimeException("There is a defined function: " + atom.name);
        }
        atom.value = element.evaluate();

        if (AtomsTable.getInstance().containsInCurrentContext(atom.name)) {
            atom.type = AtomsTable.getInstance().getAtomType(atom.name);
        }

        NodeType valueType = atom.value.getReturnType();
        if (atom.type == null || atom.type instanceof AutoType) {
            if (valueType == null) {
                throw new RuntimeException("Couldn't resolve atom's type");
            }
            atom.type = valueType;
        }
        if (!atom.type.isEqualType(valueType)) {
            throw new RuntimeException("Trying to assign to atom <" + atom.name + "> of type <" + atom.type.toString() + "> the value of type <" + valueType.toString() + ">");
        }
        checkValidAtomType();
        AtomsTable.getInstance().addAtom(atom);
        return null;
    }

    private void checkValidAtomType() {
        if (atom.type instanceof AnyType) {
            throw new RuntimeException("Atom " + atom.name + " can't be a type of 'Any'");
        }
        if (atom.type instanceof NumType) {
            throw new RuntimeException("Atom " + atom.name + " can't be a type of 'Num'");
        }
        if (atom.type instanceof UnitType) {
            throw new RuntimeException("Atom " + atom.name + " can't be a type of 'Unit'");
        }
        if (atom.type instanceof AutoType) {
            throw new RuntimeException("Atom " + atom.name + " can't be a type of 'Auto'");
        }
        if (atom.type instanceof ListOfTypes) {
            throw new RuntimeException("Atom " + atom.name + " can't be a type of 'List of several types'");
        }
    }

    @Override
    public NodeType getReturnType() {
        return new FunctionType(new AnyType(), new ListOfTypes(new AnyType(), new ListOfTypes()), new UnitType());
    }

    @Override
    public String toString() {
        return "SetQ{" +
                "atom=" + atom +
                ", element=" + element +
                '}';
    }
}
