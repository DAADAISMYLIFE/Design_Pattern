package deu.cse.pccafe_management_system.FoodSystem;

import java.util.Scanner;

public class MenuItem extends MenuComponent {
    String mn_name;         //메뉴 이름
    int mn_price;        //메뉴 가격
    int mn_inventory;    //메뉴 재고량
    String mn_category;     //메뉴 카테고리
    Scanner sc = new Scanner(System.in);
    
    public MenuItem(String mn_name, int mn_price, int mn_inventory, String mn_category) {
        this.mn_name = mn_name;
        this.mn_price = mn_price;
        this.mn_inventory = mn_inventory;
        this.mn_category = mn_category;
    }
    
    public String getName() {
        return mn_name;
    }
    public int getPrice() {
        return mn_price;
    }
    public int getInventory() {
        return mn_inventory;
    }
    public String getCategory() {
        return mn_category;
    }
    
    public void print() {
        
        System.out.println("---------------------------");
        System.out.print(getName());
        System.out.print("\n" + getPrice());
        System.out.print("\n" + getInventory());
        System.out.println("\n---------------------------");
        //System.out.print("\n" + getCategory() + "\n");
       
        /*
        System.out.print(getName());
        System.out.print("\n" + getPrice());
        System.out.print("\n" + getInventory() + "\n");
        //System.out.print("\n" + getCategory() + "\n");
        */
    }
}