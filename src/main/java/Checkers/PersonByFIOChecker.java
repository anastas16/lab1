package Checkers;

import Main.Person;

public class PersonByFIOChecker implements PersonChecker {
    /**
     * Cheker, определяющий, есть ли заданное часть полного имени (фамилия, имя, отчество в любом регистре)
     * в полном имени указанного человека
     * @param p Person
     * @param value строка имени
     * @return true, если значения входных параметров равны, false - в противном случае
     */
    @Override
    public boolean check(Person p, Object value) {
        return (p.getFIO().toLowerCase().contains(((String)value).toLowerCase()));
    }
}
