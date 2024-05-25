package deu.cse.pccafe_management_system.FoodSystem;

import deu.cse.pccafe_management_system.FoodSystem.util.FoodMenu;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        boolean isAdminMode = isAdminMode(scanner);

        if (isAdminMode) {
            FoodMenu foodMenu = FoodMenu.getInstance(); // FoodMenu 객체 얻기
            AdminModeManager adminModeManager = new AdminModeManager(foodMenu); // AdminModeManager 객체 생성 시 FoodMenu 객체 전달
            adminModeManager.adminMode(scanner);
        } else {
            CustomerModeManager customerModeManager = new CustomerModeManager();
            //customerModeManager.customerMode(scanner);
        }

        scanner.close();
    }

    private static boolean isAdminMode(Scanner scanner) {
        System.out.println("어드민이십니까? (y/n)");
        String isAdmin = scanner.nextLine();
        return isAdmin.equalsIgnoreCase("y");
    }
}