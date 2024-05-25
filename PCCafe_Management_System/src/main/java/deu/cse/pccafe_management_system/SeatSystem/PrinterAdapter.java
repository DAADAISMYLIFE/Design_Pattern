/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deu.cse.pccafe_management_system.SeatSystem;

/**
 *
 * @author kgb69
 */
public class PrinterAdapter extends Seat{
    Printer printer;
    
    public PrinterAdapter(Printer printer){
        this.printer = printer;
    }
    
    public void computerUse(){
        printer.computerUse();
    }
     public void setDrive() {
        System.out.println("프린터 설치 완료.");
    }
    
}
