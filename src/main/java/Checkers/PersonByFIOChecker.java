package Checkers;

import Main.Person;
import org.apache.log4j.Logger;

public class PersonByFIOChecker implements PersonChecker {
    private static final Logger log = Logger.getLogger(PersonByFIOChecker.class);
    /**
     * Cheker, определяющий, есть ли заданное часть полного имени (фамилия, имя, отчество в любом регистре)
     * в полном имени указанного человека
     * @param p Person
     * @param value строка имени
     * @return true, если значения входных параметров равны, false - в противном случае
     */
    @Override
    public boolean check(Person p, Object value) {
        log.info("Проверка на наличие заданной части имени в полном имени человека id = " + p.getId());
        return (p.getFIO().toLowerCase().contains(((String)value).toLowerCase()));
    }
}
