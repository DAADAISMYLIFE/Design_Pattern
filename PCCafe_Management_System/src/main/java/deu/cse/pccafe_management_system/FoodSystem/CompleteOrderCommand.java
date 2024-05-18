/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deu.cse.pccafe_management_system.FoodSystem;

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
