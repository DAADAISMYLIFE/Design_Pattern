/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deu.cse.pccafe_management_system.FoodSystem;

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