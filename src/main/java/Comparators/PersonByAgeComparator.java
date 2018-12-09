package Comparators;

import Main.Person;
import org.apache.log4j.Logger;

import java.util.Comparator;

public class PersonByAgeComparator implements PersonComparator {
    private static final Logger log = Logger.getLogger(PersonByAgeComparator.class);
    /**
     * Comparator, оперделяющий, кто старше из заданных людей в качестве параметров
     * @param p1 первый человек
     * @param p2 второй человек
     * @return  знаечние типа Integer,если
     *          >0, то первый человек младше первго,
     *          >0 - первый старше второго,
     *          =0 - возраст первого и вторго одинаков
     *
     */
    @Override
    public int compare(Person p1, Person p2) {
        log.info("Сравнение возраста человека id = " + p1.getId() + " и человека id = " + p2.getId());
        return p1.getAge().compareTo(p2.getAge()) ;
    }
}
