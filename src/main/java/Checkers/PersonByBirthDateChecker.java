package Checkers;

import Main.Person;

public class PersonByBirthDateChecker implements PersonChecker {
    /**
     * Cheker, сравнивающий заданную дату рождения с датой рождения указанного человека
     * @param p Person
     * @param value  значение искомой даты рождения
     * @return true, если значения входных параметров равны, false - в противном случае
     */
    @Override
    public boolean check(Person p, Object value) {
        return value.equals(p.getBirthDate());
    }
}
