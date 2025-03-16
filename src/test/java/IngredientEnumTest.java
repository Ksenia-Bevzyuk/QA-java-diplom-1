import org.junit.Test;
import praktikum.IngredientType;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class IngredientEnumTest {
    @Test
    public void ingredientEnumValuesTest() {
        for (IngredientType type : IngredientType.values()) {
            assertNotNull(type);
        }
    }

    @Test
    public void ingredientEnumOrdinalTest() {
        int number = 0;
        for (IngredientType type : IngredientType.values()) {
            number++;
        }

        assertEquals("Ожидается другое количество типов ингредиентов",
                IngredientType.values().length, number);
    }
}
