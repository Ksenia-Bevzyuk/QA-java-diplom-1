import com.github.javafaker.Faker;
import org.junit.Before;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;
import java.util.Random;
import static org.junit.Assert.assertEquals;

public class IngredientNamesAndPriceTest {
    private Ingredient ingredient;
    private String fakeIngredientName;
    private float fakeIngredientPrice;
    private IngredientType type = IngredientType.FILLING;

    @Before
    public void before() {
        Faker faker = new Faker();
        fakeIngredientName = faker.hitchhikersGuideToTheGalaxy().location();

        Random random = new Random();
        fakeIngredientPrice = random.nextFloat() * 100;

        ingredient = new Ingredient(type, fakeIngredientName, fakeIngredientPrice);
    }

    @Test
    public void getBunNameTest() {
        assertEquals("Ожидается другое наименование ингредиента",
                fakeIngredientName, ingredient.getName());
    }

    @Test
    public void getBunPriceTest() {
        assertEquals("Ожидается другая цена ингредиента",
                fakeIngredientPrice, ingredient.getPrice(), 0.0);
    }
}
