package deu.cse.pccafe_management_system.FoodSystem.util;

import deu.cse.pccafe_management_system.FoodSystem.composite.FoodItem;
import deu.cse.pccafe_management_system.FoodSystem.composite.FoodComponent;
import deu.cse.pccafe_management_system.FoodSystem.composite.FoodComposite;

import java.util.List;

public class FoodMenu {
    private static FoodMenu instance;

    private FoodComposite ramenMenu;
    private FoodComposite snackMenu;
    private FoodComposite beverageMenu;
    private FoodComposite mealMenu;
    private FoodComposite allMenu;

    private FoodMenu() {
        allMenu = new FoodComposite("전체 메뉴");

        ramenMenu = initRamenMenu();
        snackMenu = initSnackMenu();
        beverageMenu = initBeverageMenu();
        mealMenu = initMealMenu();

        allMenu.addFood(ramenMenu);
        allMenu.addFood(snackMenu);
        allMenu.addFood(beverageMenu);
        allMenu.addFood(mealMenu);
    }

    public List<FoodComponent> getAllMenuItems() {
        return allMenu.getFoodItems();
    }

    public static FoodMenu getInstance() {
        if (instance == null) {
            instance = new FoodMenu();
        }
        return instance;
    }

    public FoodComposite getRamenMenu() {
        return ramenMenu;
    }

    public FoodComposite getSnackMenu() {
        return snackMenu;
    }

    public FoodComposite getBeverageMenu() {
        return beverageMenu;
    }

    public FoodComposite getMealMenu() {
        return mealMenu;
    }

    public void showMenu() {
        System.out.println("-------------------------------------");
        System.out.println("현재 음식 목록:");
        allMenu.print();
        System.out.println("-------------------------------------");
    }

    private FoodComposite initRamenMenu() {
        FoodComposite ramenMenu = new FoodComposite("라면류");
        ramenMenu.addFood(new FoodItem("신라면", 2500, 50));
        ramenMenu.addFood(new FoodItem("진라면", 2400, 45));
        ramenMenu.addFood(new FoodItem("너구리", 2600, 30));
        return ramenMenu;
    }

    private FoodComposite initSnackMenu() {
        FoodComposite snackMenu = new FoodComposite("간식류");
        snackMenu.addFood(new FoodItem("과자", 1000, 100));
        snackMenu.addFood(new FoodItem("초콜릿", 1500, 50));
        return snackMenu;
    }

    private FoodComposite initBeverageMenu() {
        FoodComposite beverageMenu = new FoodComposite("음료류");
        beverageMenu.addFood(new FoodItem("콜라", 1500, 80));
        beverageMenu.addFood(new FoodItem("아메리카노", 2500, 75));
        beverageMenu.addFood(new FoodItem("아이스티", 3000, 60));
        return beverageMenu;
    }

    private FoodComposite initMealMenu() {
        FoodComposite mealMenu = new FoodComposite("식사류");
        mealMenu.addFood(new FoodItem("치킨", 5000, 30));
        mealMenu.addFood(new FoodItem("햄버거", 3000, 50));
        return mealMenu;
    }
}
