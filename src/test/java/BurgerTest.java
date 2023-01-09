import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Database;
import praktikum.Ingredient;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    Database database = new Database();

    Burger burger;
    int quantityIngridients;

    @Before
    public void createNewBurger() {
        burger = new Burger();
        for (int i = 0; i <= 5; i++) {
            burger.addIngredient(database.availableIngredients().get(i));
        }
        quantityIngridients = burger.ingredients.size();
    }

    @Mock
    Bun mockBun;

    @Test
    public void addIngredients() {
        int actualquantity = burger.ingredients.size();
        assertEquals("Не доложили ингредиентов в бургер", 6, actualquantity);
    }

    @Test
    public void removeIngredients() {
        burger.removeIngredient(4);
        assertEquals("Ингредиент не удалился", quantityIngridients - 1, burger.ingredients.size());
    }

    @Test
    public void moveIngredient() {
        Ingredient burgerBefore = burger.ingredients.get(5);
        burger.moveIngredient(5, 0);
        Ingredient burgerAfter = burger.ingredients.get(0);
        assertEquals("Ингредиент не переместился", burgerAfter, burgerBefore);
    }

    @Test
    public void getBurgerPrice() {
        burger.setBuns(mockBun);
        Mockito.when(mockBun.getPrice()).thenReturn(100f);
        burger.addIngredient(database.availableIngredients().get(4));
        float actualPrice = burger.getPrice();
        assertEquals("Стоимость рассчитана неверно", 1600f, actualPrice, 0.0f);
    }

    @Test
    public void getReceiptOfBurgerTest() {
        burger.setBuns(mockBun);
        List<Ingredient> ingredientList = new ArrayList<>(burger.ingredients);
        Mockito.when(mockBun.getName()).thenReturn("Булочка для проверки");
        assertEquals("(==== " + mockBun.getName() + " ====)\r\n" +
                "= sauce " + ingredientList.get(0).getName() + " =\r\n" +
                "= sauce " + ingredientList.get(1).getName() + " =\r\n" +
                "= sauce " + ingredientList.get(2).getName() + " =\r\n" +
                "= filling " + ingredientList.get(3).getName() + " =\r\n" +
                "= filling " + ingredientList.get(4).getName() + " =\r\n" +
                "= filling " + ingredientList.get(5).getName() + " =\r\n" +
                "(==== " + mockBun.getName() + " ====)\r\n" +
                "\r\n" +
                "Price: 1200,000000\r\n", burger.getReceipt());
    }

    @Test
    public void createBurger() {
        burger.setBuns(mockBun);
        assertNotNull("Бургер пустой", burger.bun);
    }
}