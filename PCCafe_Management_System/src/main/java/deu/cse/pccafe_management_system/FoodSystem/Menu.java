package deu.cse.pccafe_management_system.FoodSystem;

//import java.util.Iterator;
import java.util.ArrayList;

public class Menu extends MenuComponent {
    ArrayList<MenuComponent> Menu_Components = new ArrayList<MenuComponent>();
    String mn_name;            
    
    public Menu (String mn_name) {
        this.mn_name = mn_name;
    }
    
    public void add(MenuComponent Menu_Component) {
        Menu_Components.add(Menu_Component);
    }
    public void remove(MenuComponent Menu_Component) {
        Menu_Components.remove(Menu_Component);
    }
    public String getName() {
        return mn_name;
    }
    
    public void print() {
        System.out.println("\n=================================");
        System.out.println(getName());
        System.out.println("=================================");
        
        /*
        Iterator<MenuComponent> iterator = Menu_Components.iterator();
        while(iterator.hasNext()) {
            MenuComponent Menu_Component = iterator.next();
            Menu_Component.print();
        }
        */
        
        for(MenuComponent Menu_Component : Menu_Components) {
            Menu_Component.print();
        }
    }
}