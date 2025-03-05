import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import static org.junit.Assert.assertEquals;

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

        assertEquals("Ожидается, что длина не изменилась", ingredientListSize, burgerTestList.ingredients.size());
        assertEquals("Ожидается иное положение ингредиента", ingredient, burgerTestList.ingredients.get(1));
        assertEquals("Ожидается иное положение ингредиента", ingredient1, burgerTestList.ingredients.get(0));
    }
}
