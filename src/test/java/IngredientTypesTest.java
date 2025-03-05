import com.github.javafaker.Faker;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;
import java.util.Random;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTypesTest {
    private Ingredient ingredient;
    private String fakeIngredientName;
    private float fakeIngredientPrice;
    private IngredientType type;

    public IngredientTypesTest(IngredientType type) {
        this.type = type;
    }

    @Parameterized.Parameters (name = "Тип ингредиента: {0} {1}")
    public static Object[][] getTypeIngredientFromEnum() {
        return new Object[][] {
                {IngredientType.FILLING},
                {IngredientType.SAUCE}
        };
    }

    @Before
    public void before() {
        Faker faker = new Faker();
        fakeIngredientName = faker.hitchhikersGuideToTheGalaxy().location();

        Random random = new Random();
        fakeIngredientPrice = random.nextFloat() * 100;
    }

    @Test
    public void getIngredientTypeTest() {
        ingredient = new Ingredient(type, fakeIngredientName, fakeIngredientPrice);
        assertEquals("Ожидается другой тип ингредиента", type, ingredient.getType());
    }
}