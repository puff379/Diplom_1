import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

public class BunTest {

    private Bun bun;


    @Before
    public void setUp() {
        bun = new Bun("black bun", 100);
    }

    @Test
    public void getBunName() {
        String actualName = bun.getName();
        String expectedName = "black bun";
        assertEquals(expectedName, actualName);
    }

    @Test
    public void emptyNameBun() {
        bun = new Bun("", 100);
        assertEquals(bun.getName(), "");
    }

    @Test
    public void nullNameBun() {
        bun = new Bun(null, 100);
        assertEquals(bun.getName(), null);
    }

    @Test
    public void longNameBun() {
        String data = "a";
        while (data.length() < 1000) {
            data += "a";
        }
        bun = new Bun(data, 100);
        assertEquals(bun.getName(), data);
    }

    @Test
    public void cpecSymbolNameBun() {
        bun = new Bun("#$%&", 100);
        assertEquals(bun.getName(), "#$%&");
    }

    @Test
    public void getBunPrice() {
        Float actualPrice = bun.getPrice();
        Float expectedPrice = 100F;
        assertEquals(expectedPrice, actualPrice);
    }

    @Test
    public void getBunMinusPrice() {
        bun = new Bun("black bun", -100F);
        assertEquals(bun.getPrice(), -100F, 1E-15);
    }

    @Test
    public void getBunZeroPrice() {
        bun = new Bun("black bun", 0);
        assertEquals(bun.getPrice(), 0, 1E-15);
    }

    @Test
    public void getMaxFloatZeroPrice() {
        bun = new Bun("black bun", Float.MAX_VALUE);
        assertEquals(bun.getPrice(), Float.MAX_VALUE, 1E-15);
    }

    @Test
    public void getMaxIntZeroPrice() {
        bun = new Bun("black bun", Integer.MAX_VALUE);
        assertEquals(bun.getPrice(), Integer.MAX_VALUE, bun.getPrice() - Integer.MAX_VALUE);
    }

    @Test
    public void getMinFloatZeroPrice() {
        bun = new Bun("black bun", Float.MIN_VALUE);
        assertEquals(bun.getPrice(), Float.MIN_VALUE, 1E-15);
    }

    @Test
    public void getMinIntZeroPrice() {
        bun = new Bun("black bun", Integer.MIN_VALUE);
        assertEquals(bun.getPrice(), Integer.MIN_VALUE, 1E-15);
    }
}