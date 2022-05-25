package syntax_analysis.node.special_form;

import interpreter.AtomsTable;
import interpreter.DefinedFunction;
import interpreter.PredefinedFunction;
import syntax_analysis.node.AtomNode;
import syntax_analysis.node.ElementInterface;
import syntax_analysis.node.ListNode;
import syntax_analysis.node.type_node.*;

public class DefineNode implements ElementInterface {
    AtomNode atom;
    NodeType atomType;

    public DefineNode(AtomNode atom, NodeType atomType) {
        this.atom = atom;
        this.atomType = atomType;
    }

    @Override
    public ElementInterface evaluate() {
        if (PredefinedFunction.isKeyword(atom.name)) {
            throw new RuntimeException("Can't reassign keyword: " + atom.name);
        }
        if (DefinedFunction.isDefinedFunction(atom.name)) {
            throw new RuntimeException("There is a defined function: " + atom.name);
        }
        checkValidAtomType();
        AtomsTable.getInstance().defineAtom(atom, atomType);
        return null;
    }

    @Override
    public NodeType getReturnType() {
        return new FunctionType(new AnyType(), new ListOfTypes(new AnyType(), new ListOfTypes()), new UnitType());
    }

    private void checkValidAtomType() {
        if (atomType instanceof AnyType) {
            throw new RuntimeException("Atom " + atom.name + " can't be a type of 'Any'");
        }
        if (atomType instanceof NumType) {
            throw new RuntimeException("Atom " + atom.name + " can't be a type of 'Num'");
        }
        if (atomType instanceof UnitType) {
            throw new RuntimeException("Atom " + atom.name + " can't be a type of 'Unit'");
        }
//        if (atomType instanceof ListType) {
//            ListType lst = (ListType) atomType;
//            if (lst.elementType
//            throw new RuntimeException("Atom " + atom.name + " can't be a type of 'Unit'");
//        }
    }

    @Override
    public String toString() {
        return "DefineNode{" +
                "atom=" + atom +
                ", atomType=" + atomType +
                '}';
    }
}
