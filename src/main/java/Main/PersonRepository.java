package Main;

import Checkers.*;
import Comparators.PersonComparator;
import Sorters.PersonSorter;

import java.time.LocalDate;

public class PersonRepository {
    private Person[] elements;
    private PersonSorter sorter;

    /**
     * Создание экземпляра класса PersonRepository
     */
    public PersonRepository(PersonSorter sorter) {
        this.elements = new Person[0];
        this.sorter = sorter;
    }

    /**
     * Создание экземпляра класса PersonRepository указанного размера
     * @param size
     */
    public PersonRepository(int size) {
        this.elements = new Person[size];
    }
    /**
     * Получение элемета хранилища по индексу
     * @param index номер элемента в хранилище
     * @return элемент указанного индека
     */
    public Person get(int index) {
        return this.elements[index];
    }

    /**
     * Переопределение элемента хранилища по индексу, используя новое значение
     * @param index номер элемента в хранилище, который заменяется
     * @param element новый элемент
     */
    public void set(int index, Person element) {
        this.elements[index] = element;
    }

    /**
     * Получение размера хранилища
     * @return размер хранилища
     */
    public int size() {
        return this.elements.length;
    }
    /**
     * Добавление нового элемента в хранилище
     * @param element элемент, который добавляется в хранилище
     * @return true, если элмент успешно добавлен, иначе false
     */
    public boolean add(Person element) {
        try {
            Person[] temp = this.elements;
            this.elements = new Person[temp.length + 1];
            System.arraycopy(temp, 0, this.elements, 0, temp.length);
            this.elements[elements.length - 1] = element;
            return true;
        } catch(Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    /**
     * Удаление указанного по индексу элемента из хранилища
     * @param index номер элемента в хранилище, который необходимо удалить
     * @return true, если элмент успешно удален, иначе false
     */
    public boolean remove(int index) {
        try {
            Person[] temp = elements;
            elements = new Person[temp.length - 1];
            System.arraycopy(temp, 0, elements, 0, index);
            System.arraycopy(temp, index + 1, elements, index, elements.length - index);
            return true;
        } catch(Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     *
     * @param personChecker
     * @param value
     * @return
     */
    private PersonRepository search(PersonChecker personChecker, Object value) {
        PersonRepository searchRepository = new PersonRepository(sorter);
        for (int i = 0; i < elements.length; i++) {
            if(personChecker.check(elements[i], value)) {
                searchRepository.add(elements[i]);
            }
        }
        return searchRepository;
    }

    /**
     *
     * @param age
     * @return
     */
    public PersonRepository searchByAge(int age) {
        return search(new PersonByAgeChecker(), age);
    }

    /**
     *
     * @param fio
     * @return
     */
    public PersonRepository searchByFIO(String fio) {
        return search(new PersonByFIOChecker(), fio);
    }

    /**
     *
     * @param birthDate
     * @return
     */
    public PersonRepository searchByBirthDate(LocalDate birthDate) {
        return search(new PersonByBirthDateChecker(), birthDate);
    }

    /**
     *
     * @return
     */
    public PersonRepository searchById() {
        return searchById();
    }

    /**
     *
     * @param id
     * @return
     */
    public PersonRepository searchById(int id) {
        return search(new PersonByIdChecker(), id);
    }

    /**
     *
     * @param comparator
     */
    public void sort(PersonComparator comparator) {
        this.sorter.sort(elements, comparator);
    }

}


