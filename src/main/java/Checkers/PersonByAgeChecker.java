package Checkers;

import Main.Person;

public class PersonByAgeChecker implements PersonChecker {
    /**
     *
     * @param p
     * @param value
     * @return
     */
    @Override
    public boolean check(Person p, Object value) {
        return value.equals(p.getAge());
    }
}
