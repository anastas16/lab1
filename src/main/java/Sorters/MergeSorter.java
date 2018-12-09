package Sorters;

import Comparators.PersonComparator;
import Main.Person;
import Main.PersonRepository;

public class MergeSorter implements PersonSorter {
    /**
     * Сортировка слиянием
     * Рекурсивного разделение массива на группы
     * @param persons
     * @param comparator
     */
    @Override
    public void sort(Person[] persons, PersonComparator comparator) {
        if (persons.length <= 1)
        {
            return;
        }
        int leftSize = persons.length / 2;
        int rightSize = persons.length - leftSize;
        Person[] left = new Person[leftSize];
        Person[] right = new Person[rightSize];
        System.arraycopy(persons, 0, left, 0, leftSize);
        System.arraycopy(persons, leftSize, right, 0, rightSize);
        sort(left, comparator);
        sort(right, comparator);
        Merge(persons, left, right, comparator);
    }

    /**
     * Слияние в правильном порядке
     * @param persons
     * @param left
     * @param right
     * @param comparator
     */
    private void Merge(Person[] persons, Person[] left, Person[] right, PersonComparator comparator)
    {
        int leftIndex = 0;
        int rightIndex = 0;
        int targetIndex = 0;
        int remaining = left.length + right.length;
        while(remaining > 0)
        {
            if (leftIndex >= left.length)
            {
                persons[targetIndex] = right[rightIndex++];
            }
            else if (rightIndex >= right.length)
            {
                persons[targetIndex] = left[leftIndex++];
            }
            else if (comparator.compare(left[leftIndex], right[rightIndex]) < 0)
            {
                persons[targetIndex] = left[leftIndex++];
            }
            else
            {
                persons[targetIndex] = right[rightIndex++];
            }

            targetIndex++;
            remaining--;
        }
    }
}
