package pl.adamd.unit_tests.testing;

import java.util.Objects;

public class Meal {
    private int price;
    private  int quantity;
    private String Name;

    public Meal() {
    }

    public Meal(int price) {
        this.price = price;
    }

    public Meal(int price, String name) {
        this.price = price;
        Name = name;
    }

    public Meal(int price, int quantity, String name) {
        this.price = price;
        this.quantity = quantity;
        Name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getPrice() {
        return price;
    }

    public int getDiscountedPrice(int discount){

        if(discount > this.price){
            throw new IllegalArgumentException("Discount cannot be higher than the price!");
        }

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

    @Override
    public String toString() {
        return "Meal{" +
                "price=" + price +
                ", Name='" + Name + '\'' +
                '}';
    }

    int sumPrice(){
        return getPrice() * getQuantity();
    }
}
