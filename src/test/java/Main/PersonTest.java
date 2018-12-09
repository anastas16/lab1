package Main;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class PersonTest {

    @Test
    void testGetAge() {
        LocalDate birthDate = LocalDate.of(1997, 07, 16);
        Person p = new Person();
        p.setBirthDate(birthDate);
        int actual = p.getAge();
        Assert.assertEquals(21, actual);
    }
}