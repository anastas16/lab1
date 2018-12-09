package Main;

import Checkers.*;
import Comparators.PersonComparator;
import Sorters.PersonSorter;
import org.apache.log4j.Logger;

import java.time.LocalDate;


public class PersonRepository {
    private static final Logger log = Logger.getLogger(PersonRepository.class);

    /**
     * массив значений типа Person
     */
    private Person[] elements;
    /**
     * Свойство типа PersonSorter, определяющее вид применяемой сортировки для хранилища
     */
    private PersonSorter sorter;

    /**
     * Создание экземпляра класса PersonRepository с входным параметром сортировки
     *
     * @param sorter переменная типа PersonSorter - вид сортировки
     */
    public PersonRepository(PersonSorter sorter) {
        this.elements = new Person[0];
        this.sorter = sorter;
        log.info("Создание экземпляра класса PersonRepository с заданным sorter");
    }

    /**
     * Создание экземпляра класса PersonRepository без параметров
     */
    public PersonRepository() {
        this.elements = new Person[0];
        log.info("Создание экземпляра класса PersonRepository без параметров");
    }
    /**
     * Создание экземпляра класса PersonRepository указанного размера
     * @param size целочисленное значение - размер массива
     */
    public PersonRepository(int size) {
        this.elements = new Person[size];
        log.info("Создание экземпляра класса PersonRepository указанной длины");
    }

    /**
     * Получение вида сортировки, применяемого для этого хранилища
     * @return вид сортировки
     */
    public PersonSorter getSorter() {
        log.info("Получение человека sorter хранилища");
        return this.sorter;
    }

    /**
     * Определение вида сортировки для данного хранилища
     * @param sorter пременная типа PersonSorter - вид сортировки
     */
    public void setSorter(PersonSorter sorter) {
        this.sorter = sorter;
        log.info("Задание sorter для хранилища");
    }

    /**
     * Получение элемета хранилища по индексу
     * @param index номер элемента в хранилище
     * @return элемент указанного индека
     */
    public Person get(int index) {
        log.info("Получение человека " + index + " из хранилища");
        return this.elements[index];

    }

    /**
     * Переопределение элемента хранилища по индексу, используя новое значение
     * @param index номер элемента в хранилище, который заменяется
     * @param element новый элемент
     */
    public void set(int index, Person element) {
        this.elements[index] = element;
        log.info("Обновление " + index + " элемента массива");
    }

    /**
     * Получение размера хранилища
     * @return размер хранилища
     */
    public int size() {
        log.info("Определение размера хранилища");
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
            log.info("Добавление человека на " + (elements.length - 1) + " позицию хранилища");
            return true;
        } catch(Exception e) {
            e.printStackTrace();
            log.error("Человек не добавлен", e);
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
            log.info("Удаление" + index + " человека из хранилища");
            return true;
        } catch(Exception e) {
            e.printStackTrace();
            log.error("Человек не удален", e);
        }
        return false;
    }

    /**
     * Сортировка по указанному свойству и значению
     * @param personChecker переменная, определяющая свойства Person
     * @param value переменная типа Object - искомое значение
     * @return хранилище людей, удовлетворяющих заданному поиску
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
     * Поиск по возрасту
     * @param age перменнная типа int - искомый возраст
     * @return хранилище людей, удовлетворяющих заданному возрасту
     */
    public PersonRepository searchByAge(int age) {
        log.info("Поиск человека с возрастом - " + age);
        return search(new PersonByAgeChecker(), age);
    }

    /**
     *Поиск человека по полному имени
     * @param fio переменная типа String - искомое полное имя
     * @return хранилище людей, удовлетворяющих заданному полному имени
     */
    public PersonRepository searchByFIO(String fio) {
        log.info("Поиск человека с частью полного имени - " + fio);
        return search(new PersonByFIOChecker(), fio);
    }

    /**
     *Поиск по заданной дате
     * @param birthDate переменная типа LocalDate - искомая дата рождения
     * @return хранилище людей, удовлетворяющих заданной дате рождения
     */
    public PersonRepository searchByBirthDate(LocalDate birthDate) {
        log.info("Поиск человека с датой рождения - " + birthDate);
        return search(new PersonByBirthDateChecker(), birthDate);
    }

    /**
     * Поиск человека по ео идентфиикатору
     * @param id переменная типа int - искомое значение идентфиикатора человека
     * @return хранилище людей, удовлетворяющих заданнщму идентификатору
     */
    public PersonRepository searchById(int id) {
        log.info("Поиск человека с id - " + id);
        return search(new PersonByIdChecker(), id);
    }

    /**
     *Сортировка хралища по указанному компаратору
     * @param comparator перменная типа Comparator - свойсво Person, по которому нужно отсортировать хранилище
     */
    public void sort(PersonComparator comparator) {
        log.info("Сортировка по - " + comparator.getClass().getName());
        this.sorter.sort(elements, comparator);
    }

}


