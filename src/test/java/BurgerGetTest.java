import com.github.javafaker.Faker;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import static java.lang.String.valueOf;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BurgerGetTest {
    private Burger burger;
    private String fakeBunName;
    private String fakeIngredientName;
    private IngredientType fakeIngredientType;
    private float fakeBunPrice;
    private float fakeIngredientPrice;
    private float fakeBurgerPrice;

    @Mock
    Ingredient ingredient;

    @Mock
    Bun bun;

    @Before
    public void before() {
        Faker faker = new Faker();
        fakeBunName = faker.color().name() + " bun";
        fakeIngredientName = faker.food().ingredient();
        fakeIngredientType = IngredientType.FILLING;

        Random random = new Random();
        fakeBunPrice = random.nextFloat() * 100;
        fakeIngredientPrice = random.nextFloat() * 100;

        float fakePrice = random.nextFloat() * 100;

        fakeBurgerPrice = LimitDecPlaces.limitDecPlaces(fakePrice, 6);

        burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
    }


    @Test
    public void getPriceTest() {
        Mockito.when(bun.getPrice()).thenReturn(fakeBunPrice);

        List<Ingredient> ingredients = Arrays.asList(ingredient);
        Mockito.when(ingredients.get(0).getPrice()).thenReturn(fakeIngredientPrice);

        float burgerPrice = fakeBunPrice * 2 + fakeIngredientPrice;

        assertEquals("Ожидается другая цена", burgerPrice, burger.getPrice(), 0);
    }

    @Test
    public void getReceiptTest() {
        Mockito.when(bun.getName()).thenReturn(fakeBunName);

        List<Ingredient> ingredients = Arrays.asList(ingredient);
        Mockito.when(ingredients.get(0).getName()).thenReturn(fakeIngredientName);
        Mockito.when(ingredients.get(0).getType()).thenReturn(fakeIngredientType);

        Mockito.when(burger.getPrice()).thenReturn(fakeBurgerPrice);

        String burgerReceipt =
                "(==== " + fakeBunName + " ====)" +
                        "\r\n" +
                "= " + fakeIngredientType.toString().toLowerCase() + " " + fakeIngredientName + " =\r\n" +
                "(==== " + fakeBunName + " ====)" +
                        "\r\n" +
                        "\r\n" +
                "Price: " + valueOf(fakeBurgerPrice).replace(".", ",") +
                        "\r\n";

        assertEquals("Ожидается другая строка", burgerReceipt, burger.getReceipt());
    }
}