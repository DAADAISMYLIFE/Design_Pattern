package deu.cse.pccafe_management_system.FoodSystem.command;

import deu.cse.pccafe_management_system.FoodSystem.util.Order;
import deu.cse.pccafe_management_system.FoodSystem.util.OrderManager;

public class CompleteOrderCommand implements Command {
    private Order order;

    public CompleteOrderCommand(Order order) {
        this.order = order;
    }

    @Override
    public void execute() {
        order.completeOrder();
        OrderManager.getInstance().removeOrder(order);
        System.out.println("주문이 완료되어 현재 주문 목록에서 제거되었습니다.");
    }
}
