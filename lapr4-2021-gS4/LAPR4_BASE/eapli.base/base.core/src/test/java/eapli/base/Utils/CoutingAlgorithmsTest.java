package eapli.base.Utils;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static org.junit.Assert.*;

public class CoutingAlgorithmsTest {


    @Test
    public void numberLength() {
        int a = CoutingAlgorithms.numberLength(1190963);
        assertEquals(a, 7);
    }

    @Test
    public void numberAlgorithms() {
        int a = CoutingAlgorithms.stringLength("A1B2C3E4F5");
        assertEquals(a, 10);
    }

}