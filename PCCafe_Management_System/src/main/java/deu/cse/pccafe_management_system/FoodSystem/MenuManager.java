/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deu.cse.pccafe_management_system.FoodSystem;

import deu.cse.pccafe_management_system.FoodSystem.Composite.Menu;
import deu.cse.pccafe_management_system.FoodSystem.Composite.MenuComponent;
import deu.cse.pccafe_management_system.FoodSystem.Composite.MenuItem;

/**
 *
 * @author kgb69
 */
public class MenuManager {

    private static MenuManager instance;
    MenuComponent all_Menu;

    public static synchronized MenuManager getInstance() {
        if (instance == null) {
            instance = new MenuManager();
        }
        return instance;
    }

    public MenuManager() {
        this.all_Menu = new All_Menu().all_Menu;
    }

    public void Print_All_Menu() {
        all_Menu.print();
    }
    
    public void Print_ramen_Menu(){
     all_Menu.getChild(0).print();
    }
    public void Print_snack_Menu(){
     all_Menu.getChild(1).print();
    }
    public void Print_beverage_Menu(){
     all_Menu.getChild(2).print();
    }
    public void Print_meal_Menu(){
     all_Menu.getChild(3).print();
    }

}
