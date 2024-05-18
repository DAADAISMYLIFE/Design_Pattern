package deu.cse.pccafe_management_system.FoodSystem;

import java.util.ArrayList;
import java.util.List;

public class FoodComposite extends FoodComponent {
    private List<FoodComponent> foodItems = new ArrayList<>();

    public FoodComposite(String name) {
        super(name);
    }

    @Override
    public void addFood(FoodComponent food) {
        foodItems.add(food);
    }

    @Override
    public void removeFood(String name) {
        foodItems.removeIf(food -> food.getName().equals(name));
    }

    @Override
    public void updateFood(String name, int newPrice, int newStock) {
        for (FoodComponent food : foodItems) {
            if (food.getName().equals(name)) {
                if (food instanceof FoodItem) {
                    ((FoodItem) food).setPrice(newPrice);
                    ((FoodItem) food).setStock(newStock);
                }
                break;
            }
        }
    }

    @Override
    public int getPrice() {
        int total = 0;
        for (FoodComponent food : foodItems) {
            total += food.getPrice();
        }
        return total;
    }

    @Override
    public void print() {
        System.out.println("메뉴: " + getName());
        for (FoodComponent food : foodItems) {
            food.print();
        }
    }

    public List<FoodComponent> getFoodItems() {
        return foodItems;
    }
}
