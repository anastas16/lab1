package Checkers;

import Main.Person;
import org.apache.log4j.Logger;

public class PersonByIdChecker implements PersonChecker {
    private static final Logger log = Logger.getLogger(PersonByIdChecker.class);
    /**
     * Cheker, сравнивающий заданный идентификатор с идентификаторм указанного человека
     * @param p Person
     * @param value  значение искомого идентфиикатора
     * @return true, если значения входных параметров равны, false - в противном случае
     */
    @Override
    public boolean check(Person p, Object value) {
        log.info("Проверка искомого значения идентификатора человека с идентификатором человека id = " + p.getId());
        return value.equals(p.getId());
    }
}
