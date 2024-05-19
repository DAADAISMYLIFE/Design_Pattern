/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deu.cse.pccafe_management_system.FoodSystem.Command;

import deu.cse.pccafe_management_system.FoodSystem.MenuManager;

/**
 *
 * @author kgb69
 */
public class PrintMenu_Command implements Command{
    MenuManager menuManager;

    public PrintMenu_Command(MenuManager menuManager) {
        this.menuManager = menuManager;
    }

    @Override
    public void execute() {
        menuManager.Print_All_Menu();
    }
    
    
}
