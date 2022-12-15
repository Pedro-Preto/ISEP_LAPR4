package eapli.base.Color.domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class ColorTest {

    @Test
    public void colorEqualsTest() {
        Color color1 = new Color(ColorDesignation.valueOf("blue"), ColorHexCode.valueOf("#0000FF"));
        Color color2 = new Color(ColorDesignation.valueOf("red"), ColorHexCode.valueOf("#FF0000"));
        Color color3 = new Color(ColorDesignation.valueOf("gold"), ColorHexCode.valueOf("#FFD700"));
        Color color4 = new Color(ColorDesignation.valueOf("green"), ColorHexCode.valueOf("#00FF00"));
        Color color5 = new Color(ColorDesignation.valueOf("silver"), ColorHexCode.valueOf("#C0C0C0"));
        Color color6 = new Color(ColorDesignation.valueOf("pink"), ColorHexCode.valueOf("#FFC0CB"));


        boolean a = color1.getDesignation().equals(color2.getDesignation());
        boolean b = color3.getDesignation().equals(color4.getDesignation());
        boolean c = color5.getDesignation().equals(color6.getDesignation());

        assertFalse(a);
        assertFalse(b);
        assertFalse(c);

        color1 = new Color(ColorDesignation.valueOf("red"), ColorHexCode.valueOf("#FF0000"));
        boolean d = color1.getDesignation().equals(color2.getDesignation());
        assertTrue(d);

        color3 = new Color(ColorDesignation.valueOf("green"), ColorHexCode.valueOf("#00FF00"));

        boolean e = color3.getDesignation().equals(color4.getDesignation());
        assertTrue(e);

        color5 = new Color(ColorDesignation.valueOf("pink"), ColorHexCode.valueOf("#FFC0CB"));
        boolean f = color5.getDesignation().equals(color6.getDesignation());
        assertTrue(f);

    }

}