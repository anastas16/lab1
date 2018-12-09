package Comparators;

import Main.Person;

import java.time.Period;
import java.util.Comparator;

public class PersonByBirthDateComparator implements PersonComparator {
    /**
     * Comparator, оперделяющий, кто родился раньше
     * Если года рожденяи одинаковы, проверяются месяцы,
     * если одинаковы месяцы - проверяются дни
     * @param p1 первый человек
     * @param p2 второй человек
     * @return  знаечние типа Integer,если
     *          >0, то первый человек родился раньше второго,
     *          >0 - первый позже второго,
     *          =0 - даты о=рождения одинаковы одинаковы
     *
     */
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
