/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deu.cse.pccafe_management_system.FoodSystem.Composite;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kgb69
 */
public class Menu extends MenuComponent{
    List<MenuComponent> menuComponents = new ArrayList<MenuComponent>();
    String name;
    String description;
    public Menu(String name, String description){
        this.name = name;
        this.description = description;
    }
    
    public void add(MenuComponent menuComponent){
        menuComponents.add(menuComponent);
    }
    
    public void remove(MenuComponent menuComponent){
        menuComponents.remove(menuComponent);
    }
    public MenuComponent getChild(int i){
        return menuComponents.get(i);
    }
    public String getName(){
        return name;
    }
    public String getDescription(){
        return description;
    }
    public void print(){
        System.out.println("====================");
        System.out.println("              "+getName());
        System.out.println("-------------------------------------");
        
        for(MenuComponent menuComponent:menuComponents){
            menuComponent.print();
        }
        System.out.println("====================");

    }
}
