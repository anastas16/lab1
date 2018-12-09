package Sorters;

import Comparators.PersonComparator;
import Main.Person;
import org.apache.log4j.Logger;

public class BubbleSorter implements PersonSorter{
    private static final Logger log = Logger.getLogger(BubbleSorter.class);
    /**
     * Сортировка пузырьком
     * @param persons
     * @param comparator
     */
    @Override
    public void sort(Person[] persons, PersonComparator comparator) {
        log.info("Сортировка пузырьком");
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
