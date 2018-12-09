package Checkers;

import Main.Person;
import org.apache.log4j.Logger;

public class PersonByAgeChecker implements PersonChecker {
    private static final Logger log = Logger.getLogger(PersonByAgeChecker.class);
    /**
     * Cheker, сравнивающий заданный возраст с возрастом указанного человека
     * @param p Person
     * @param value  значение искомого возраста
     * @return true, если значения входных параметров равны, false - в противном случае
     */
    @Override
    public boolean check(Person p, Object value) {
        log.info("Проверка искомого значения возрастом человека с возрастом человека id = " + p.getId());
        return value.equals(p.getAge());
    }
}
