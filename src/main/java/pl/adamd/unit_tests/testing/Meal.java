package pl.adamd.unit_tests.testing;

import java.util.Objects;

public class Meal {
    private int price;
    private String Name;

    public Meal(int price) {
        this.price = price;
    }

    public Meal(int price, String name) {
        this.price = price;
        Name = name;
    }

    public int getPrice() {
        return price;
    }

    public int getDiscountedPrice(int discount){
        return this.price - discount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Meal meal = (Meal) o;
        return price == meal.price && Objects.equals(Name, meal.Name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(price, Name);
    }
}
