/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deu.cse.pccafe_management_system.FoodSystem.Command;

/**
 *
 * @author kgb69
 */
public class Invoker {
    
    private static Invoker instance;
    private Command command;
    
        public static synchronized Invoker getInstance() {
        if (instance == null) {
            instance = new Invoker();
        }
        return instance;
    }
    
    public void takeOrder(){
        System.out.println("인보커가 명령을 받고 커맨드를 실행");
        command.execute();
    }
    
    public void setCommand(Command command){
        this.command =command;
    }
}
