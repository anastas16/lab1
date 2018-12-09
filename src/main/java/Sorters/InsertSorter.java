package Sorters;

import Comparators.PersonComparator;
import Main.Person;
import Main.PersonRepository;

public class InsertSorter implements PersonSorter{
    /**
     * Сортировка вставками
     * @param persons
     * @param comparator
     */
    public void sort(Person[] persons, PersonComparator comparator)
    {
        int sortedRangeEndIndex = 1;

        while (sortedRangeEndIndex < persons.length)
        {
            if (comparator.compare(persons[sortedRangeEndIndex], persons[sortedRangeEndIndex - 1]) < 0)
            {
                int insertIndex = findInsertionIndex(persons, persons[sortedRangeEndIndex], comparator);
                Insert(persons, insertIndex, sortedRangeEndIndex);
            }

            sortedRangeEndIndex++;
        }
    }

    /**
     * Cравнивает переданное ему значение с каждым значением в отсортированной части,
     * пока не найдет место для вставки.
     * @param persons
     * @param valueToInsert
     * @param comparator
     * @return
     */
    private int findInsertionIndex(Person[] persons, Person valueToInsert, PersonComparator comparator)
    {
        for (int index = 0; index < persons.length; index++) {
            if (comparator.compare(persons[index], valueToInsert) > 0)
            {
                return index;
            }
        }

        throw new ExceptionInInitializerError("The insertion index was not found");
    }

    /**
     * Осуществляет вставку, удаляя вставляемое значение из массива и с
     * двигая все значения, начиная с индекса для вставки, вправо
     * @param persons
     * @param indexInsertingAt
     * @param indexInsertingFrom
     */
    private void Insert(Person[] persons, int indexInsertingAt, int indexInsertingFrom)
    {
        Person temp = persons[indexInsertingAt];
        persons[indexInsertingAt] = persons[indexInsertingFrom];
        for (int current = indexInsertingFrom; current > indexInsertingAt; current--)
        {
            persons[current] = persons[current - 1];
        }
        persons[indexInsertingAt + 1] = temp;
    }
}