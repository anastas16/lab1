package Comparators;

import Main.Person;
import org.apache.log4j.Logger;

import java.util.Comparator;

public class PersonByFIOComparator implements PersonComparator {
    private static final Logger log = Logger.getLogger(PersonByFIOComparator.class);
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
        log.info("Сравнение полного имени человека id = " + p1.getId() + " и человека id = " + p2.getId());
        return p1.getFIO().compareTo(p2.getFIO());
    }
}
