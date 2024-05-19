/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deu.cse.pccafe_management_system.FoodSystem.Composite;

/**
 *
 * @author kgb69
 */
public class MenuItem extends MenuComponent{
    String name;
    int price;

    public MenuItem(String name, int price) {
        this.name = name;
        this.price = price;
    }
    
    public String getName(){
        return name;
    }
    public int getPrice(){
        return price;
    }
    public void print(){
        System.out.print("  "+getName());
        System.out.println(", "+getPrice()+"원");
    }
    
}
