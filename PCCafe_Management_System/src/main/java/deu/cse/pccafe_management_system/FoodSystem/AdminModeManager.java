
package deu.cse.pccafe_management_system.FoodSystem;


import java.util.List;
import java.util.Scanner;

public class AdminModeManager {

    private FoodMenu foodMenu;

    public AdminModeManager(FoodMenu foodMenu) {
        this.foodMenu = foodMenu;
    }

    public void adminMode(Scanner scanner) {
        boolean continueAdmin = true;

        while (continueAdmin) {
            System.out.println("어드민 사용자 모드입니다. 원하시는 작업을 선택해주세요:");
            System.out.println("1. 음식 추가");
            System.out.println("2. 음식 삭제");
            System.out.println("3. 음식 수정");
            System.out.println("4. 현재 음식 목록 확인");
            System.out.println("5. 손님 주문 현황 확인");
            System.out.println("6. 주문 완료 처리");
            System.out.println("0. 손님 모드로 전환");

            int adminChoice = scanner.nextInt();
            scanner.nextLine(); // 개행 문자 처리

            switch (adminChoice) {
                case 1:
                    addFood(scanner);
                    break;
                case 2:
                    removeFood(scanner);
                    break;
                case 3:
                    updateFood(scanner);
                    break;
                case 4:
                    showMenu();
                    break;
                case 5:
                    showOrders();
                    break;
                case 6:
                    completeOrder(scanner);
                    break;
                case 0:
                    continueAdmin = false;
                    CustomerModeManager customerModeManager = new CustomerModeManager();
                    customerModeManager.customerMode(scanner);
                    break;
                default:
                    System.out.println("잘못된 입력입니다.");
                    break;
            }
        }
    }

    private void addFood(Scanner scanner) {
        FoodComposite chosenMenu = chooseMenu(scanner);
        if (chosenMenu != null) {
            System.out.println("추가할 음식 이름을 입력해주세요:");
            String foodName = scanner.nextLine();
            System.out.println("추가할 음식 가격을 입력해주세요:");
            int foodPrice = scanner.nextInt();
            System.out.println("추가할 음식 재고량을 입력해주세요:");
            int foodStock = scanner.nextInt();
            chosenMenu.addFood(new FoodItem(foodName, foodPrice, foodStock));
            System.out.println("음식이 추가되었습니다.");
        } else {
            System.out.println("잘못된 카테고리 선택입니다.");
        }
    }

    private void removeFood(Scanner scanner) {
        FoodComposite chosenMenu = chooseMenu(scanner);
        if (chosenMenu != null) {
            System.out.println("삭제할 음식 이름을 입력해주세요:");
            String foodName = scanner.nextLine();
            chosenMenu.removeFood(foodName);
            System.out.println("음식이 삭제되었습니다.");
        } else {
            System.out.println("잘못된 카테고리 선택입니다.");
        }
    }

    private void updateFood(Scanner scanner) {
        FoodComposite chosenMenu = chooseMenu(scanner);
        if (chosenMenu != null) {
            System.out.println("수정할 음식 이름을 입력해주세요:");
            String foodName = scanner.nextLine();
            System.out.println("수정할 음식의 새로운 가격을 입력해주세요:");
            int newPrice = scanner.nextInt();
            System.out.println("수정할 음식의 새로운 재고량을 입력해주세요:");
            int newStock = scanner.nextInt();
            chosenMenu.updateFood(foodName, newPrice, newStock);
            System.out.println("음식이 수정되었습니다.");
        } else {
            System.out.println("잘못된 카테고리 선택입니다.");
        }
    }

    private void showMenu() {
        foodMenu.showMenu();
    }

    private void showOrders() {
        List<Order> orders = OrderManager.getInstance().getOrders();
        for (int i = 0; i < orders.size(); i++) {
            System.out.println("주문 번호 " + (i + 1) + ":");
            orders.get(i).printOrder();
        }
    }

    private void completeOrder(Scanner scanner) {
        System.out.println("완료할 주문 번호를 입력해주세요:");
        int orderIndex = scanner.nextInt();
        scanner.nextLine(); // 개행 문자 처리

        List<Order> orders = OrderManager.getInstance().getOrders();
        if (orderIndex < 1 || orderIndex > orders.size()) {
            System.out.println("잘못된 주문 번호입니다.");
        } else {
            Order order = orders.get(orderIndex - 1);
            if (order.isCompleted()) {
                System.out.println("이미 완료된 주문입니다.");
            } else {
                Command completeOrder = new CompleteOrderCommand(order);
                completeOrder.execute();
            }
        }
    }

    private FoodComposite chooseMenu(Scanner scanner) {
        System.out.println("카테고리를 선택해주세요:");
        System.out.println("1. 라면류");
        System.out.println("2. 간식류");
        System.out.println("3. 음료류");
        System.out.println("4. 식사류");

        int categoryChoice = scanner.nextInt();
        scanner.nextLine(); // 개행 문자 처리

        switch (categoryChoice) {
            case 1:
                FoodComposite ramenMenu = foodMenu.getRamenMenu();
                System.out.println("라면류 음식 목록:");
                ramenMenu.print();
                return ramenMenu;
            case 2:
                FoodComposite snackMenu = foodMenu.getSnackMenu();
                System.out.println("간식류 음식 목록:");
                snackMenu.print();
                return snackMenu;
            case 3:
                FoodComposite beverageMenu = foodMenu.getBeverageMenu();
                System.out.println("음료류 음식 목록:");
                beverageMenu.print();
                return beverageMenu;
            case 4:
                FoodComposite mealMenu = foodMenu.getMealMenu();
                System.out.println("식사류 음식 목록:");
                mealMenu.print();
                return mealMenu;
            default:
                return null;
        }
    }
}
