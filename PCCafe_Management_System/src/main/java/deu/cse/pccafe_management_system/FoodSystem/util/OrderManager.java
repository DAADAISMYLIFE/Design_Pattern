package deu.cse.pccafe_management_system.FoodSystem.util;

import java.util.ArrayList;
import java.util.List;

public class OrderManager {
    private static OrderManager instance;
    private List<Order> orders = new ArrayList<>();

    private OrderManager() {
    }

    public static OrderManager getInstance() {
        if (instance == null) {
            instance = new OrderManager();
        }
        return instance;
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void printOrders() {
        for (Order order : orders) {
            order.printOrder();
        }
    }

    public void removeOrder(Order order) {
        orders.remove(order);
    }

    public void removeOrderByIndex(int index) {
        if (index >= 0 && index < orders.size()) {
            orders.remove(index);
        }
    }
}