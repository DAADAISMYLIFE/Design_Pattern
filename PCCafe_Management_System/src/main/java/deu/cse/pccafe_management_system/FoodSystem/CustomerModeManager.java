package deu.cse.pccafe_management_system.FoodSystem;

import deu.cse.pccafe_management_system.FoodSystem.util.FoodMenu;
import deu.cse.pccafe_management_system.FoodSystem.util.Order;
import deu.cse.pccafe_management_system.FoodSystem.decorator.EggDecorator;
import deu.cse.pccafe_management_system.FoodSystem.decorator.ShotDecorator;
import deu.cse.pccafe_management_system.FoodSystem.decorator.CheeseDecorator;
import deu.cse.pccafe_management_system.FoodSystem.composite.FoodComponent;
import deu.cse.pccafe_management_system.FoodSystem.composite.FoodComposite;
import deu.cse.pccafe_management_system.FoodSystem.command.TakeOrderCommand;
import deu.cse.pccafe_management_system.FoodSystem.command.Command;
import deu.cse.pccafe_management_system.IntegratedSystem.IntegratedSys;
import deu.cse.pccafe_management_system.SeatSystem.Seat;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class CustomerModeManager {

    public void customerMode(Scanner scanner, Seat seat) throws IOException {
        FoodComposite chosenMenu = chooseMenu(scanner);
        if (chosenMenu != null) {
            List<FoodComponent> menuItems = chosenMenu.getFoodItems();
            System.out.println("==========================");
            for (int i = 0; i < menuItems.size(); i++) {
                System.out.println((i + 1) + ". " + menuItems.get(i).getName() + " " + menuItems.get(i).getPrice() + "원");
            }
            System.out.println("0. 뒤로가기");
            System.out.println("==========================");
            System.out.println("주문하실 음식을 선택해주세요:");
            int foodChoice = scanner.nextInt();
            scanner.nextLine(); // 개행 문자 처리
            if (foodChoice > 0 && foodChoice <= menuItems.size()) {
                FoodComponent selectedFood = menuItems.get(foodChoice - 1);

                System.out.println("토핑을 추가하시겠습니까? (y/n)");
                String addTopping = scanner.nextLine();
                while (addTopping.equalsIgnoreCase("y")) {
                    selectedFood = addTopping(scanner, selectedFood, chosenMenu.getName());
                    System.out.println("토핑을 추가하시겠습니까? (y/n)");
                    addTopping = scanner.nextLine();
                }

                Order order = new Order();
                order.addItem(selectedFood);

                Command takeOrder = new TakeOrderCommand(order);
                takeOrder.execute();
                IntegratedSys is = new IntegratedSys();
                is.Guest_Menu(seat);
            } else {
                System.out.println("잘못된 선택입니다.");
            }
        } else {
            IntegratedSys is = new IntegratedSys();
            is.Guest_Menu(seat);
        }
    }

    private FoodComponent addTopping(Scanner scanner, FoodComponent food, String category) {
        switch (category) {
            case "라면류":
                System.out.println("추가할 토핑을 선택해주세요:");
                System.out.println("1. 치즈 (500원)");
                System.out.println("2. 계란 (300원)");
                int toppingChoiceRamen = scanner.nextInt();
                scanner.nextLine(); // 개행 문자 처리
                switch (toppingChoiceRamen) {
                    case 1:
                        return new CheeseDecorator(food);
                    case 2:
                        return new EggDecorator(food);
                    default:
                        System.out.println("잘못된 선택입니다.");
                        break;
                }
                break;

            case "음료류":
                System.out.println("추가할 토핑을 선택해주세요:");
                System.out.println("1. 샷 추가 (400원)");
                int toppingChoiceBeverage = scanner.nextInt();
                scanner.nextLine(); // 개행 문자 처리
                if (toppingChoiceBeverage == 1) {
                    return new ShotDecorator(food);
                } else {
                    System.out.println("잘못된 선택입니다.");
                }
                break;
            // 다른 카테고리 추가 가능
        }
        return food;
    }

    private FoodComposite chooseMenu(Scanner scanner) throws IOException {
        System.out.println("카테고리를 선택해주세요:");
        System.out.println(" ===============");
        System.out.println("|| 1. 라면류                  ||");
        System.out.println("|| 2. 간식류                  ||");
        System.out.println("|| 3. 음료류                  ||");
        System.out.println("|| 4. 식사류                  ||");
        System.out.println("|| 5. 뒤로가기               ||");
        System.out.println(" ===============");
        int categoryChoice = scanner.nextInt();
        scanner.nextLine(); // 개행 문자 처리

        switch (categoryChoice) {
            case 1:
                return FoodMenu.getInstance().getRamenMenu();
            case 2:
                return FoodMenu.getInstance().getSnackMenu();
            case 3:
                return FoodMenu.getInstance().getBeverageMenu();
            case 4:
                return FoodMenu.getInstance().getMealMenu();
            case 5:
                return null;
            case 6:
                AdminModeManager adminModeManager = new AdminModeManager(FoodMenu.getInstance());
                adminModeManager.adminMode(scanner);
                return null;
            default:
                return null;
        }
    }
}
