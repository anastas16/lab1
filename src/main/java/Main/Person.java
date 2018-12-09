package Main;

import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;

public class Person {
    private int id;
    private String FIO;
    private LocalDate birthDate;
    private Integer age;

    /**
     * Создание эземпляра класса Person с заданными парметрами
     *
     * @param id        - идентификатор
     * @param FIO       - фамилия, имя и отчество
     * @param birthDate - дата рождения
     */
    public Person(int id, String FIO, LocalDate birthDate) {
        this.id = id;
        this.FIO = FIO;
        this.birthDate = birthDate;
    }


    /**
     * Получение идентфиикатор человека
     */
    public int getId() {
        return id;
    }

    /**
     * Определение индентификатора человека
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Получение фамилии, имени и отчестова
     *
     * @return
     */
    public String getFIO() {
        return FIO;
    }

    /**
     * Определение фамилии, имени и отчества
     *
     * @param FIO
     */
    public void setFIO(String FIO) {
        this.FIO = FIO;
    }

    /**
     * Получение даты рождения
     *
     * @return
     */
    public LocalDate getBirthDate() {
        return birthDate;
    }

    /**
     * Определение даты рождения
     *
     * @param birthDate
     */
    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    /**
     * Определение возраста человека
     *
     * @return
     */
    public Integer getAge() {
        return Period.between(this.birthDate, LocalDate.now()).getYears();
    }

    /**
     * Текстовое представление класса Person
     *
     * @return
     */
    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", FIO='" + FIO + '\'' +
                ", birthDate=" + birthDate +
                ", age=" + this.getAge() +
                '}';
    }
}
