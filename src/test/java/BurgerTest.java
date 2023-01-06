import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    public Bun bun;

    @Mock
    public Ingredient ingredient;

    @Test
    public void setBuns(){

        Burger burger = new Burger();
        bun = new Bun("Булочка с кунжутом", 12.5F);
        burger.setBuns(bun);
        Assert.assertEquals(burger.bun, bun);
    }

    @Test
    public void addIngredient(){

        Burger burger = new Burger();
        Assert.assertTrue(burger.ingredients.size() == 0);
        burger.addIngredient(new Ingredient(SAUCE, "Специальный соус", (float) 25));
        Assert.assertTrue(burger.ingredients.size() == 1);
    }

    @Test
    public void removeIngredient(){

        Burger burger = new Burger();
        burger.addIngredient(new Ingredient(SAUCE, "Специальный соус", (float) 25));
        Assert.assertTrue(burger.ingredients.size() == 1);
        burger.removeIngredient(0);
        Assert.assertTrue(burger.ingredients.size() == 0);

    }

    @Test
    public void moveIngredient(){

        Burger burger = new Burger();
        burger.addIngredient(new Ingredient(SAUCE, "Специальный соус", (float) 125));
        burger.addIngredient(new Ingredient(FILLING, "Второй специальный соус", (float) 35));
        burger.moveIngredient(0, 1);
        Assert.assertEquals(burger.ingredients.get(0).name, "Второй специальный соус");

    }

    @Test
    public void getPrice(){

        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Mockito.when(bun.getPrice()).thenReturn(300.4F);
        Mockito.when(ingredient.getPrice()).thenReturn(10F);
        Assert.assertEquals(610.8F, burger.getPrice(), 0);
    }

    @Test
    public void getReceipt(){

        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Mockito.when(bun.getName()).thenReturn("Космобулочка");
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredient.getName()).thenReturn("Космоначинка");
        Assert.assertEquals(
                "(==== Космобулочка ====)\r\n" +
                "= filling Космоначинка =\r\n" +
                "(==== Космобулочка ====)\r\n" +
                "\r\n" +
                "Price: 0,000000"+
                "\r\n", burger.getReceipt());

    }
}
