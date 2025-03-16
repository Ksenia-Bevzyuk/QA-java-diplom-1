import com.github.javafaker.Faker;
import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;
import java.util.Random;
import static org.junit.Assert.assertEquals;

public class BunTest {
    private Bun bun;
    String fakeBunName;
    float fakeBunPrice;

    @Before
    public void before() {
        Faker faker = new Faker();
        fakeBunName = faker.hitchhikersGuideToTheGalaxy().location();

        Random random = new Random();
        fakeBunPrice = random.nextFloat() * 100;

        bun = new Bun(fakeBunName, fakeBunPrice);
    }

    @Test
    public void getBunNameTest() {
        assertEquals("Ожидается другое наименование булочки",
                fakeBunName, bun.getName());
    }

    @Test
    public void getBunPriceTest() {
        assertEquals("Ожидается другая цена булочки",
                fakeBunPrice, bun.getPrice(), 0);
    }
}
