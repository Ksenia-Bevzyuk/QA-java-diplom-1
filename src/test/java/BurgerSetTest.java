import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import static org.junit.Assert.*;
import org.assertj.core.api.SoftAssertions;

@RunWith(MockitoJUnitRunner.class)
public class BurgerSetTest {

    @Mock
    Bun bun;

    @Mock
    Burger burger;

    @Mock
    Ingredient ingredient;

    @Mock
    Ingredient ingredient1;

    @Test
    public void setBunTest() {
        burger.setBuns(bun);
        Mockito.verify(burger).setBuns(bun);
    }

    @Test
    public void addIngredientTest() {
        burger.addIngredient(ingredient);
        Mockito.verify(burger,
                Mockito.times(1)).addIngredient(ingredient);
    }

    @Test
    public void removeIngredientTest() {
        Burger burgerTestList = new Burger();
        burgerTestList.addIngredient(ingredient);
        int ingredientListSize = burgerTestList.ingredients.size();
        burgerTestList.removeIngredient(0);
        assertEquals("Ожидается, что длина уменьшилась на 1", ingredientListSize - 1, burgerTestList.ingredients.size());
    }

    @Test
    public void moveIngredientTest() {
        Burger burgerTestList = new Burger();

        burgerTestList.addIngredient(ingredient);
        burgerTestList.addIngredient(ingredient1);

        int ingredientListSize = burgerTestList.ingredients.size();

        burgerTestList.moveIngredient(0, 1);

        SoftAssertions softAssertions = new SoftAssertions();

        softAssertions.assertThat(ingredientListSize).isEqualTo(burgerTestList.ingredients.size());
        softAssertions.assertThat(ingredient).isEqualTo(burgerTestList.ingredients.get(1));
        softAssertions.assertThat(ingredient1).isEqualTo(burgerTestList.ingredients.get(0));
    }
}
