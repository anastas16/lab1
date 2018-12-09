package Sorters;

import Comparators.PersonComparator;
import Main.Person;
import Main.PersonRepository;

public class BubbleSorter implements PersonSorter{
    /**
     * Сортировка пузырьком
     * @param persons
     * @param comparator
     */
    @Override
    public void sort(Person[] persons, PersonComparator comparator) {
        boolean swapped;
        do
        {
            swapped = false;
            for (int i = 1; i < persons.length; i++)
                if (comparator.compare(persons[i - 1], persons[i]) > 0) {
                    Person temp = persons[i - 1];
                    persons[i - 1] = persons[i];
                    persons[i] = temp;
                    swapped = true;
                }
        } while (swapped != false);
    }
}
