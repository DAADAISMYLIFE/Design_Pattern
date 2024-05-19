/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deu.cse.pccafe_management_system.FoodSystem;

import deu.cse.pccafe_management_system.FoodSystem.Command.Invoker;
import deu.cse.pccafe_management_system.FoodSystem.Command.PrintMenu_Command;
import deu.cse.pccafe_management_system.FoodSystem.Composite.Menu;
import deu.cse.pccafe_management_system.FoodSystem.Composite.MenuComponent;
import deu.cse.pccafe_management_system.FoodSystem.Composite.MenuItem;
import deu.cse.pccafe_management_system.UserAccountSystem.PCCafeMember;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author kgb69
 */
public class Guest_FoodSys {

     public static Guest_FoodSys instance;
    boolean is_running = true;
    public PCCafeMember cur_member;
    public Guest_FoodSys() {
    }

    public static synchronized Guest_FoodSys getInstance() {
        if (instance == null) {
            instance = new Guest_FoodSys();
        }
        return instance;
    }

    public void Run_FoodSys() throws IOException {
        while (is_running) {
            System.out.println("카테고리를 선택해주세요:");
            System.out.println("1. 라면류");
            System.out.println("2. 간식류");
            System.out.println("3. 음료류");
            System.out.println("4. 식사류");
            System.out.println("5. 뒤로가기");
            // 유저 입력 ->
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String choice = reader.readLine();

            switch (choice) {
                case "1":
                    MenuManager.getInstance().Print_ramen_Menu();
                    break;
                case "2":
                    MenuManager.getInstance().Print_snack_Menu();
                    break;
                case "3":
                    MenuManager.getInstance().Print_beverage_Menu();
                    break;
                case "4":
                    MenuManager.getInstance().Print_meal_Menu();
                    break;
                case "5":
                    is_running =false;
                    break;
            }
        }
    }
}
