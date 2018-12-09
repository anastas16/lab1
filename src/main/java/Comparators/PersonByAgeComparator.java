package Comparators;

import Main.Person;

import java.util.Comparator;

public class PersonByAgeComparator implements PersonComparator {
    @Override
    public int compare(Person p1, Person p2) {
        return p1.getAge().compareTo(p2.getAge()) ;
    }
}
