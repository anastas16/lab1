package Checkers;

import Main.Person;
import org.apache.log4j.Logger;

public class PersonByBirthDateChecker implements PersonChecker {
    private static final Logger log = Logger.getLogger(PersonByBirthDateChecker.class);
    /**
     * Cheker, сравнивающий заданную дату рождения с датой рождения указанного человека
     * @param p Person
     * @param value  значение искомой даты рождения
     * @return true, если значения входных параметров равны, false - в противном случае
     */
    @Override
    public boolean check(Person p, Object value) {
        log.info("Проверка искомого значения даты рождения человека с датой рождения человека id = " + p.getId());
        return value.equals(p.getBirthDate());
    }
}
