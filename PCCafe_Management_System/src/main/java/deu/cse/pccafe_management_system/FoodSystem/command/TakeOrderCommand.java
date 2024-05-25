package deu.cse.pccafe_management_system.FoodSystem.command;

import deu.cse.pccafe_management_system.FoodSystem.util.Order;
import deu.cse.pccafe_management_system.FoodSystem.util.OrderManager;

public class TakeOrderCommand implements Command {
    private Order order;

    public TakeOrderCommand(Order order) {
        this.order = order;
    }

    @Override
    public void execute() {
        OrderManager.getInstance().addOrder(order);
        System.out.println("주문이 접수되었습니다.");
    }
}
