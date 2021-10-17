package pl.adamd.unit_tests.testing;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MealTest {

    @Test
    void shouldReturnDiscountedPrice() {
        //given
        Meal meal = new Meal(35);
        //when
        int discountedPrice = meal.getDiscountedPrice(7);
        //then
        assertEquals(28, discountedPrice);
/*
hamcrest:
        assertThat(discountedPrice, equalTo(28));
*/
/*
assertj-core:
        assertThat(discountedPrice).isEqualTo(28);
*/
    }

    @Test
    void referencesToTheSameObjectShouldBeEqual(){
        //given
        Meal meal1 = new Meal(10);
        Meal meal2 = meal1;
        //then
        assertSame(meal1, meal2);
/*
hamcrest:
        assertThat(meal1, sameInstance(meal2));
*/
/*
assertj-core:
        assertThat(meal1).isSameAs(meal2);
*/
    }

    @Test
    void referencesToDifferentObjectShouldNotBeEqual(){
        //given
        Meal meal1 = new Meal(10);
        Meal meal2 = new Meal(20);
        //then
        assertNotSame(meal1, meal2);
/*
hamcrest:
        assertThat(meal1, not(sameInstance(meal2)));
*/
/*
assertj-core:
        assertThat(meal1).isNotSameAs(meal2);
*/
    }

    @Test
    void twoMealsShouldBeEqualWhenPriceAndNameAreTheSame(){
        Meal meal1 = new Meal(10, "Burger");
        Meal meal2 = new Meal(10, "Burger");

        assertEquals(meal1, meal2);
/*
hamcrest:
        assertThat(meal1, equalTo(meal2));
*/
/*
assertj-core:
        assertThat(meal1).isEqualTo(meal2);
*/
    }
}
