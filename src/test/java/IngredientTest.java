import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTest {

    private final String expectedIngredientName;
    private final IngredientType expectedIngredientType;
    private final float expectedIngredientPrice;

    public IngredientTest(String expectedIngredientName, IngredientType expectedIngredientType, float expectedIngredientPrice) {
        this.expectedIngredientName = expectedIngredientName;
        this.expectedIngredientType = expectedIngredientType;
        this.expectedIngredientPrice = expectedIngredientPrice;
    }

    Ingredient ingredient;

    @Before
    public void setUp() {
        ingredient = new Ingredient(expectedIngredientType, expectedIngredientName, expectedIngredientPrice);
    }

    @Parameterized.Parameters(name = "using expectedIngredientType {0} and actualIngredientType {1} and expectedIngredientPrice {2}")
    public static Object[][] testedIngredient() {
        return new Object[][]{
                {"chili sauce", IngredientType.SAUCE, 300},
                {"dinosaur", IngredientType.FILLING, 200},
                {"cutlet", IngredientType.FILLING, 100},
                {"hot sauce", IngredientType.SAUCE, 100}
        };
    }

    @Test
    public void ingredientType() {
        IngredientType actualIngredientType = ingredient.getType();
        assertEquals(expectedIngredientType, actualIngredientType);
    }

    @Test
    public void ingredientName() {
        String actualIngredientName = ingredient.getName();
        assertEquals(expectedIngredientName, actualIngredientName);
    }

    @Test
    public void ingredientPrice() {
        float actualIngredientPrice = ingredient.getPrice();
        assertEquals(expectedIngredientPrice, actualIngredientPrice, 0.0f);
    }

}