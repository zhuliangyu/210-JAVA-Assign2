package model;

import org.omg.CORBA.INTERNAL;

import java.util.ArrayList;
import java.util.List;

public class ListOfClowns {
    private List<Clown> clowns;

    // EFFECTS: constructs an empty list of clowns
    public ListOfClowns() {
        clowns = new ArrayList<>();
    }

    //TODO: Implement this method
    //MODIFIES: this
    //EFFECTS:  creates a new clown, (standing if isStanding is true, sittting otherwise),
    // and adds that clown to the list of clowns
    public void addClown(boolean isStanding) {
        // stub
        Clown c = new Clown(isStanding);
        clowns.add(c);
    }

    //TODO: Implement this method
    //EFFECTS:  returns true if every clown is standing, false otherwise
    public boolean allClownsStanding() {

        boolean flag = true;

        for (Clown clown : clowns) {
            if (!clown.getIsStanding()) {
                flag = false;
            }
        }
        return flag;
    }

    //TODO: Implement this method
    //MODIFIES: this
    //EFFECTS:  if position is valid (there is a clown at the specified position),
    //          flips the clown at the given position (along with its neighbours);
    //          otherwise has no effect.
    //          NOTE: first clown in list is at position 0.
    public void flip(int position) {
        // stub
        int sizeOfClown = clowns.size();


        if (position >= 0 && position < sizeOfClown) {

            if (sizeOfClown == 1) {
                clowns.get(position).flip();
            } else {
                if (position == 0) {
                    clowns.get(position).flip();
                    clowns.get(position + 1).flip();
                } else if (position == sizeOfClown - 1) {
                    clowns.get(position).flip();
                    clowns.get(position - 1).flip();
                } else {
                    clowns.get(position).flip();
                    clowns.get(position + 1).flip();
                    clowns.get(position - 1).flip();
                }
            }
        }


    }

    //TODO: Implement this method
    //EFFECTS:  if position is valid (there is a clown at the specified position),
    //          returns true if the clown at that position is standing, false otherwise;
    //          returns false if the position is not valid.
    //          NOTE: first clown in list is at position 0.
    public boolean isClownStanding(int position) {
//        return false;  // stub
        int sizeOfClown = clowns.size();

        if (position >= 0 && position < sizeOfClown) {
            return clowns.get(position).getIsStanding();
        } else {
            return false;
        }
    }

    //Do not modify this method
    //EFFECTS: returns a string representing the state of the clowns in this list
    public String toString() {
        StringBuffer sb = new StringBuffer();
        for (Clown c : clowns) {
            if (c.getIsStanding()) {
                sb.append("  UP  ");
            } else {
                sb.append(" DOWN ");
            }
        }
        return sb.toString();
    }
}