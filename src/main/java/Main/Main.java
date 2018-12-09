package Main;

import Comparators.PersonByBirthDateComparator;
import Comparators.PersonByFIOComparator;
import Sorters.BubbleSorter;
import Sorters.InsertSorter;
import Sorters.MergeSorter;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        PersonRepository persons = new PersonRepository(new MergeSorter());
        persons.add(new Person(1, "Круглякова Анастасия Андреевна", LocalDate.of(1998, 6, 16)));
        persons.add(new Person(2, "Свеколкина Таисия Макаровна", LocalDate.of(1999, 7, 18)));
        persons.add(new Person(3, "Аксенов Юрий Виктор", LocalDate.of(1992, 5, 1)));
        persons.add(new Person(4, "Сергеев Смен Андреевич", LocalDate.of(2000, 1, 22)));
        persons.sort(new PersonByFIOComparator());
        System.out.println(persons.get(0));
    }
}
