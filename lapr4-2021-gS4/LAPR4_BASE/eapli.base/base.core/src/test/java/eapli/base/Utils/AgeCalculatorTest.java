package eapli.base.Utils;


import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static org.junit.Assert.*;

public class AgeCalculatorTest {

    @Test
    public void calculateAge() throws ParseException {
        String a = "29/08/2001";
        Date d = new SimpleDateFormat("dd/MM/yyyy").parse(a);
        int age = AgeCalculator.getCalculateAge(d);
        assertEquals(age, age);

        String b = "29/08/1999";
        Date d1 = new SimpleDateFormat("dd/MM/yyyy").parse(b);
        int age1 = AgeCalculator.getCalculateAge(d1);
        assertEquals(age1, age1);

    }
}