package Main

import org.junit.jupiter.api.Test
import java.time.LocalDate;

class PersonTest  {
    @Test
    void testGetAge() {
        LocalDate birthDate = LocalDate.of(1997, 07, 16);
        Person p = new Person();
        p.setBirthDate(birthDate);
        int actual = p.getAge();
        Assert.asserEquals(21, actual)
    }
}
