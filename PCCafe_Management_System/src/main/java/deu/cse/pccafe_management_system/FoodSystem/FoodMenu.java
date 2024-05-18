package deu.cse.pccafe_management_system.FoodSystem;

import java.util.ArrayList;
import java.util.List;

public class FoodMenu {
    private static FoodMenu instance;

    private FoodComposite ramenMenu;
    private FoodComposite snackMenu;
    private FoodComposite beverageMenu;
    private FoodComposite mealMenu;

    private FoodMenu() {
        ramenMenu = createRamenMenu();
        snackMenu = createSnackMenu();
        beverageMenu = createBeverageMenu();
        mealMenu = createMealMenu();
    }
    public List<FoodComponent> getAllMenuItems() {
        List<FoodComponent> allItems = new ArrayList<>();
        allItems.addAll(ramenMenu.getFoodItems());
        allItems.addAll(snackMenu.getFoodItems());
        allItems.addAll(beverageMenu.getFoodItems());
        allItems.addAll(mealMenu.getFoodItems());
        return allItems;
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
        ramenMenu.print();
        snackMenu.print();
        beverageMenu.print();
        mealMenu.print();
        System.out.println("-------------------------------------");
    }

    private FoodComposite createRamenMenu() {
        FoodComposite ramenMenu = new FoodComposite("라면류");
        ramenMenu.addFood(new FoodItem("신라면", 2500, 50));
        return ramenMenu;
    }

    private FoodComposite createSnackMenu() {
        FoodComposite snackMenu = new FoodComposite("간식류");
        snackMenu.addFood(new FoodItem("과자", 1000, 100));
        return snackMenu;
    }

    private FoodComposite createBeverageMenu() {
        FoodComposite beverageMenu = new FoodComposite("음료류");
        beverageMenu.addFood(new FoodItem("콜라", 1500, 80));
        return beverageMenu;
    }

    private FoodComposite createMealMenu() {
        FoodComposite mealMenu = new FoodComposite("식사류");
        mealMenu.addFood(new FoodItem("치킨", 5000, 30));
        return mealMenu;
    }
}
