import org.junit.Assert;
import org.junit.Test;
import praktikum.Ingredient;
import static praktikum.IngredientType.SAUCE;

public class IngredientTest {

    Ingredient ingredient = new Ingredient(SAUCE, "Название ингредиента", 170.9F);

    @Test
    public void getPrice(){

        Assert.assertEquals(170.9F, ingredient.getPrice(), 0);

    }

    @Test
    public void getName(){

        Assert.assertEquals("Название ингредиента", ingredient.getName());

    }

    @Test
    public void getType(){

        Assert.assertEquals(SAUCE, ingredient.getType());

    }
}
