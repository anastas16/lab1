package Main;

import Comparators.PersonByAgeComparator;
import Comparators.PersonByBirthDateComparator;
import Comparators.PersonByFIOComparator;
import Sorters.BubbleSorter;
import Sorters.InsertSorter;
import Sorters.MergeSorter;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;


public class PersonRepositoryTest {

    private PersonRepository createPersonRepository() {
        PersonRepository persons = new PersonRepository(new BubbleSorter());
        persons.add(new Person(1, "Круглякова Анастасия Андреевна", LocalDate.of(1998, 6, 16)));
        persons.add(new Person(2, "Свеколкина Таисия Макаровна", LocalDate.of(1999, 7, 18)));
        persons.add(new Person(3, "Аксенов Юрий Виктор", LocalDate.of(1992, 5, 1)));
        return persons;
    }

    @Test
    public void add() {
        PersonRepository persons = createPersonRepository();
        int actual = persons.size();
        int expected = 3;
        Assert.assertEquals(expected, actual);
        actual = persons.get(1).getAge();
        expected = 19;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void remove() {
        PersonRepository persons = createPersonRepository();
        persons.remove(0);
        int actual = persons.size();
        int expected = 2;
        Assert.assertEquals(expected, actual);
        actual = persons.get(0).getAge();
        expected = 19;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void searchByAge() {
        PersonRepository persons = createPersonRepository();
        int actual = persons.searchByAge(20).get(0).getId();
        int expected = 1;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void searchByFIO() {
        PersonRepository persons = createPersonRepository();
        int actual = persons.searchByFIO("Аксенов").get(0).getId();
        int expected = 3;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void searchByBirthDate() {
        PersonRepository persons = createPersonRepository();
        int actual = persons.searchByBirthDate(LocalDate.of(1998, 6, 16)).get(0).getId();
        int expected = 1;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void sortByFIO() {
        PersonRepository persons = createPersonRepository();
        persons.sort(new PersonByFIOComparator());
        int actual = persons.get(0).getId();
        int expected = 3;
        Assert.assertEquals(expected, actual);
        actual = persons.size();
        expected = 3;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void sortByBirthDate() {
        PersonRepository persons = createPersonRepository();
        persons.sort(new PersonByBirthDateComparator());
        int actual = persons.get(0).getId();
        int expected = 3;
        Assert.assertEquals(expected, actual);
        actual = persons.size();
        expected = 3;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void sortByAge() {
        PersonRepository persons = createPersonRepository();
        persons.sort(new PersonByAgeComparator());
        int actual = persons.get(0).getId();
        int expected = 2;
        Assert.assertEquals(expected, actual);
        actual = persons.size();
        expected = 3;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void BubbleSort() {
        PersonRepository persons = createPersonRepository();
        persons.setSorter(new BubbleSorter());
        persons.sort(new PersonByAgeComparator());
        int actual = persons.get(0).getId();
        int expected = 2;
        Assert.assertEquals(expected, actual);
        actual = persons.size();
        expected = 3;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void InsertSort() {
        PersonRepository persons = createPersonRepository();
        persons.setSorter(new InsertSorter());
        persons.sort(new PersonByAgeComparator());
        int actual = persons.get(0).getId();
        int expected = 2;
        Assert.assertEquals(expected, actual);
        actual = persons.size();
        expected = 3;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void MergeSort() {
        PersonRepository persons = createPersonRepository();
        persons.setSorter(new MergeSorter());
        persons.sort(new PersonByAgeComparator());
        int actual = persons.get(0).getId();
        int expected = 2;
        Assert.assertEquals(expected, actual);
        actual = persons.size();
        expected = 3;
        Assert.assertEquals(expected, actual);
    }
}