package Sorters;

import Comparators.PersonComparator;
import Main.Person;
import Main.PersonRepository;

public interface PersonSorter {

    public void sort(Person[] persons, PersonComparator comparator);
}
