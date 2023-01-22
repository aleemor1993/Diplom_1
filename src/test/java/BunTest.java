import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;
import praktikum.Database;


public class BunTest {

    Database database = new Database();

    Bun bun = new Bun(database.availableBuns().get(0).getName(), database.availableBuns().get(0).getPrice());


    @Test
    public void getName(){

        Assert.assertEquals("black bun", bun.getName());

    }

    @Test
    public void getPrice(){

        Assert.assertTrue(100F == bun.getPrice());

    }

}
