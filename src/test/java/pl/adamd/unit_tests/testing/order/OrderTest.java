package pl.adamd.unit_tests.testing.order;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import pl.adamd.unit_tests.testing.Meal;
import pl.adamd.unit_tests.testing.extensions.BeforeAfterExtension;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(BeforeAfterExtension.class)
class OrderTest {
    private Order order;

    @BeforeEach
    void initializeOrder(){
        System.out.println("Before each");
        order = new Order();
    }

    @AfterEach
    void cleanUp(){
        System.out.println("After each");
        order.cancel();
    }

    @Test
    void testAssertArrayEquals(){
        //given
        int[] ints1 = {1,2,3};
        int[] ints2 = {1,2,3};

        //then
        assertArrayEquals(ints1, ints2);
    }

    @Test
    void mealListShouldBeEmptyAfterCreationOfOrder(){
        //then
        assertThat(order.getMeals(), empty());
        assertThat(order.getMeals().size(), equalTo(0));
        assertThat(order.getMeals(), hasSize(0));
        MatcherAssert.assertThat(order.getMeals(), emptyCollectionOf(Meal.class));
    }

    @Test
    void addingMealToOrderShouldIncreaseOrderSize(){
        //given
        Meal meal = new Meal(15, "Burger");
        Meal meal2 = new Meal(25, "Pizza");

        //when
        order.addMealToOrder(meal);

        //then
        assertThat(order.getMeals(), hasSize(1));
        assertThat(order.getMeals(), contains(meal));
        assertThat(order.getMeals(), not(contains(meal2)));
        assertThat(order.getMeals(), hasItem(meal));
        assertThat(order.getMeals().get(0).getPrice(), equalTo(15));
    }

    @Test
    void removingMealFormOrderShouldDecreaseOrderSize(){
        //given
        Meal meal = new Meal(15, "Burger");

        //when
        order.addMealToOrder(meal);
        order.removeMealFromOrder(meal);

        //then
        assertThat(order.getMeals(), hasSize(0));
        assertThat(order.getMeals(), not(contains(meal)));
    }

    @Test
    void mealsShouldBeInCorrectOrderAfterAddingThemToOrder(){
        //given
        Meal meal1 = new Meal(15, "Burger");
        Meal meal2 = new Meal(25, "Pizza");

        //when
        order.addMealToOrder(meal1);
        order.addMealToOrder(meal2);

        //then
        assertThat(order.getMeals(), contains(meal1, meal2));
        assertThat(order.getMeals(), containsInAnyOrder(meal2, meal1));
        assertThat(order.getMeals().get(0), is(meal1));
        assertThat(order.getMeals().get(1), is(meal2));
    }

    @Test
    void testIfToMealListsAreTheSame(){
        //given
        Meal meal1 = new Meal(15, "Burger");
        Meal meal2 = new Meal(25, "Pizza");
        Meal meal3 = new Meal(35, "Steak");

        List<Meal> meals1 = Arrays.asList(meal1, meal2);
        List<Meal> meals2 = Arrays.asList(meal1, meal2);
        List<Meal> meals3 = Arrays.asList(meal1, meal3);

        //then
        assertThat(meals1, is(meals2));
        assertThat(meals1, not(meals3));
    }

    @Test
    void orderTotalPriceShouldNotExceedsMaxIntValue() {
        //given
        Meal meal1 = new Meal(Integer.MAX_VALUE, "Burger");
        Meal meal2 = new Meal(Integer.MAX_VALUE, "Pizza");
        //when
        order.addMealToOrder(meal1);
        order.addMealToOrder(meal2);
        //then
        assertThrows(IllegalStateException.class, order::totalPrice);
    }

    @Test
    void emptyOrderTotalPriceShouldEqualZero(){
        //given
        //order is created in BeforeEach
        //then
        assertThat(order.totalPrice(), is(0));
    }

    @Test
    void cancelingOrderShouldRemoveAllItemsFromMealsList(){
        //given
        Meal meal1 = new Meal(15, "Burger");
        Meal meal2 = new Meal(25, "Pizza");
        //when
        order.addMealToOrder(meal1);
        order.addMealToOrder(meal2);
        order.cancel();
        //then
        assertThat(order.getMeals().size(), is(0));
    }
}
