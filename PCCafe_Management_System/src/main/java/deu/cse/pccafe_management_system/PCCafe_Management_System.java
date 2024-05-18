/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
/*
package deu.cse.pccafe_management_system;

import java.util.Scanner;


import deu.cse.pccafe_management_system.FoodSystem.Menu;
import deu.cse.pccafe_management_system.FoodSystem.MenuComponent;
import deu.cse.pccafe_management_system.FoodSystem.MenuItem;
import deu.cse.pccafe_management_system.FoodSystem.ShowMenu;

/**
 *
 * @author kgb69
 */
/*
public class PCCafe_Management_System {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        Scanner sc = new Scanner(System.in);
        
        MenuComponent NoodleMenu = new Menu("라면류");          //신라면, 너구리, 짜파게티 등등?
        MenuComponent SnackMenu = new Menu("간식류");           //새우깡, 냉동만두, 감자튀김 등등?
        MenuComponent DrinkMenu = new Menu("음료류");           //콜라, 아이스티, 커피 등등?
        MenuComponent MainMenu = new Menu("식사류");            //볶음밥, 덮밥, 돈까스 등등?
        
        MenuComponent allMenus = new Menu("전체 메뉴");
        
        allMenus.add(NoodleMenu);
        allMenus.add(SnackMenu);
        allMenus.add(DrinkMenu);
        allMenus.add(MainMenu);
        
        NoodleMenu.add(new MenuItem("신라면", 4500, 30, "라면류"));
        SnackMenu.add(new MenuItem("새우깡", 1700, 25, "간식류"));
        DrinkMenu.add(new MenuItem("아이스티", 2000, 50, "음료류"));
        MainMenu.add(new MenuItem("짜장볶음밥", 4500, 10, "식사류"));
        
        ShowMenu show_menu = new ShowMenu(allMenus);
        
        show_menu.printMenu();  
        
        System.out.println("새로운 메뉴를 추가할 카테고리를 선택하세요:");
        System.out.println("라면류:1");
        System.out.println("간식류:2");
        System.out.println("음료류:3");
        System.out.println("식사류:4");
        
        String category = sc.next();
        MenuComponent selectedMenu = null;
        
        switch (category) {
            case "1":
                selectedMenu = NoodleMenu;
                break;
            case "2":
                selectedMenu = SnackMenu;
                break;
            case "3":
                selectedMenu = DrinkMenu;
                break;
            case "4":
                selectedMenu = MainMenu;
                break;
            default:
                System.out.println("잘못된 카테고리입니다.");
                return; // 메소드 종료
        }
    }
}

*/