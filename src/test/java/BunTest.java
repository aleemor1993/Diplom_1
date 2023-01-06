import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;

public class BunTest {

    Bun bun = new Bun("Название", 12.75F);

    @Test
    public void getName(){

        Assert.assertEquals("Название", bun.getName());

    }

    @Test
    public void getPrice(){

        Assert.assertTrue(12.75F == bun.getPrice());

    }

}
