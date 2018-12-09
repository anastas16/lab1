package Comparators;

import Main.Person;

import java.time.Period;
import java.util.Comparator;

public class PersonByBirthDateComparator implements PersonComparator {
    @Override
    public int compare(Person p1, Person p2) {
        int compare = Period.between(p2.getBirthDate(), p1.getBirthDate()).getYears();
        if (compare == 0) {
            compare = Period.between(p2.getBirthDate(), p1.getBirthDate()).getMonths();
            if (compare == 0) {
                compare = Period.between(p2.getBirthDate(), p1.getBirthDate()).getDays();
            }
        }
        return compare;
    }
}
