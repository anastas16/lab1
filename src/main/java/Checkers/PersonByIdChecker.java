package Checkers;

import Main.Person;

public class PersonByIdChecker implements PersonChecker {
    /**
     * Cheker, сравнивающий заданный идентификатор с идентификаторм указанного человека
     * @param p Person
     * @param value  значение искомого идентфиикатора
     * @return true, если значения входных параметров равны, false - в противном случае
     */
    @Override
    public boolean check(Person p, Object value) {
        return value.equals(p.getId());
    }
}
