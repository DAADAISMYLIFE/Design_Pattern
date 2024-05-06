package deu.cse.pccafe_management_system.FoodSystem;

public class ShowMenu {
    MenuComponent allMenus;
    
    public ShowMenu(MenuComponent allMenus) {
        this.allMenus = allMenus;
    }
    
    public void printMenu() {
        allMenus.print();
    }
}