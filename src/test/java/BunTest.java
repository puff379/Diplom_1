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
    public void getBunPrice() {
        Float actualPrice = bun.getPrice();
        Float expectedPrice = 100F;
        assertEquals(expectedPrice, actualPrice);
    }
}