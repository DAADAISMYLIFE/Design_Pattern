package deu.cse.pccafe_management_system.FoodSystem;

import deu.cse.pccafe_management_system.FoodSystem.Composite.Menu;
import deu.cse.pccafe_management_system.FoodSystem.Composite.MenuComponent;
import deu.cse.pccafe_management_system.FoodSystem.Composite.MenuItem;

/**
 *
 * @author kgb69
 */
public class All_Menu {

    MenuComponent ramen_Menu;
    MenuComponent snack_Menu;
    MenuComponent beverage_Menu;
    MenuComponent meal_Menu;
    MenuComponent all_Menu;

    public All_Menu() {
        Init_menu();
    }

    public void Init_menu() {
        ramen_Menu = new Menu("라면 메뉴", "여러 라면 메뉴");
        snack_Menu = new Menu("과자 메뉴", "여러 과자 메뉴");
        beverage_Menu = new Menu("음료 메뉴", "여러 음료 메뉴");
        meal_Menu = new Menu("도시락 메뉴", "여러 도시락 메뉴");

        all_Menu = new Menu("전체 메뉴", "전체 메뉴");
        
        all_Menu.add(ramen_Menu);
        all_Menu.add(beverage_Menu);
        all_Menu.add(beverage_Menu);
        all_Menu.add(meal_Menu);

        ramen_Menu.add(new MenuItem("신라면", 1000));
        snack_Menu.add(new MenuItem("꼬깔콘", 1000));
        beverage_Menu.add(new MenuItem("코가콜라", 1000));
        meal_Menu.add(new MenuItem("불고기 도시락", 1000));
    }
}
