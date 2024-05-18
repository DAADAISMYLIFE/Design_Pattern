/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deu.cse.pccafe_management_system.FoodSystem;

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
