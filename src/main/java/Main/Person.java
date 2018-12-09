package Main;

import org.apache.log4j.Logger;

import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;

public class Person {
    private static final Logger log = Logger.getLogger(Person.class);
    /**
     * целочисленное значение - идентификатор человека
     */
    private int id;
    /**
     * стркоовое значение - полное имя человека
     */
    private String FIO;
    /**
     * знаечние типа дата - дата рождения человека
     */
    private LocalDate birthDate;
    /**
     * целочисленное значение - возраст человека
     */
    private Integer age;

    /**
     * Создание экземпляра класса Person с заданными параметрами
     *
     * @param id ппеременная типа int - идентификатор чловека
     * @param FIO переменная типа String - полное имя человека
     * @param birthDate переменная типа LocalDate - дата рождения человека
     */
    public Person(int id, String FIO, LocalDate birthDate) {
        this.id = id;
        this.FIO = FIO;
        this.birthDate = birthDate;
        log.info("Создание экземпляра класса Person");
    }

    /**
     * Создание экземпляра класса Person без параметров
     */
    public Person() {
        log.info("Создание экземпляра класса Person без параметров");
    }

    /**
     *
     * Получение значения идентификатора человека
     *
     * @return идентификатор человека
     */
    public int getId() {
        return id;
    }

    /**
     * Определение индентификатора человека
     *
     * @param id переменная типа int - идентфиикатор человека
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Получение полного имени
     *
     * @return строку с полным именем человека
     */
    public String getFIO() {
        return FIO;
    }

    /**
     * Определение фамилии, имени и отчества
     *
     * @param FIO перемнная типа String - полное имя человека
     */
    public void setFIO(String FIO) {
        this.FIO = FIO;
    }

    /**
     * Получение даты рождения
     *
     * @return дату рождения человека
     */
    public LocalDate getBirthDate() {
        return birthDate;
    }

    /**
     * Определение даты рождения
     *
     * @param birthDate перменна типа LocalDate - дата рождения человека
     */
    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    /**
     * Определение возраста человека, а именно рассчитывает период времени от даты рожедения человека
     * до сегодняшней и преобразует получившиеся значение в года
     *
     * @return возраст человека
     */
    public Integer getAge() {
        log.info("Определение возраста человека");
        return Period.between(this.birthDate, LocalDate.now()).getYears();
    }

    /**
     * Текстовое представление класса Person
     *
     * @return строку, в которой записаны все свойсва этого Person
     */
    @Override
    public String toString() {
        log.info("Получение строкового представления экземпляра класса");
        return "Person{" +
                "id=" + id +
                ", FIO='" + FIO + '\'' +
                ", birthDate=" + birthDate +
                ", age=" + this.getAge() +
                '}';
    }
}
