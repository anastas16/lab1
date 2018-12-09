package Comparators;

import Main.Person;

import java.util.Comparator;

public class PersonByFIOComparator implements PersonComparator {
    @Override
    public int compare(Person p1, Person p2) {
        return p1.getFIO().compareTo(p2.getFIO());
    }
}
