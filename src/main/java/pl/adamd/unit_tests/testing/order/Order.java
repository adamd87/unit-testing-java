package pl.adamd.unit_tests.testing.order;

import pl.adamd.unit_tests.testing.Meal;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<Meal> meals = new ArrayList<>();

    public void addMealToOrder(Meal meal) {
        this.meals.add(meal);
    }

    public void removeMealFromOrder(Meal meal) {
        this.meals.remove(meal);
    }

    void cancel() {
        this.meals.clear();
    }

    public List<Meal> getMeals() {
        return meals;
    }

    int totalPrice() {

        int sum = this.meals.stream().mapToInt(meal -> meal.getPrice()).sum();

        if (sum < 0) {
            throw new IllegalStateException("Price limit exceeded");
        } else {
            return sum;
        }

    }

    @Override
    public String toString() {
        return "Order{" +
                "meals=" + meals +
                '}';
    }
}
