package deu.cse.pccafe_management_system.FoodSystem.util;

import deu.cse.pccafe_management_system.FoodSystem.composite.FoodComponent;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<FoodComponent> items = new ArrayList<>();
    private boolean isCompleted = false;

    public void addItem(FoodComponent item) {
        items.add(item);
    }

    public List<FoodComponent> getItems() {
        return items;
    }

    public void completeOrder() {
        isCompleted = true;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public int getTotalPrice() {
        int total = 0;
        for (FoodComponent item : items) {
            total += item.getPrice();
        }
        return total;
    }

    public void printOrder() {
        System.out.println("주문 내역:");
        for (FoodComponent item : items) {
            item.print();
        }
        System.out.println("총 가격: " + getTotalPrice() + "원");
    }
}
