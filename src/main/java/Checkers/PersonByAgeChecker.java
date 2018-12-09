package Checkers;

import Main.Person;

public class PersonByAgeChecker implements PersonChecker {
    /**
     * Cheker, сравнивающий заданный возраст с возрастом указанного человека
     * @param p Person
     * @param value  значение искомого возраста
     * @return true, если значения входных параметров равны, false - в противном случае
     */
    @Override
    public boolean check(Person p, Object value) {
        return value.equals(p.getAge());
    }
}
