package Comparators;

import Main.Person;

import java.util.Comparator;

public class PersonByFIOComparator implements PersonComparator {
    /**
     * Comparator, оперделяющий, чье полное имя будет стоять выше в таблице алфавитного порядка
     * @param p1 первый человек
     * @param p2 второй человек
     * @return  знаечние типа Integer,если
     *          >0, то первый человек до второго,
     *          >0 - первый после второго
     *
     */
    @Override
    public int compare(Person p1, Person p2) {
        return p1.getFIO().compareTo(p2.getFIO());
    }
}
