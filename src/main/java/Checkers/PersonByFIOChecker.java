package Checkers;

import Main.Person;

public class PersonByFIOChecker implements PersonChecker {
    /**
     *
     * @param p
     * @param value
     * @return
     */
    @Override
    public boolean check(Person p, Object value) {
        return (p.getFIO().toLowerCase().contains(((String)value).toLowerCase()));
    }
}
