/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deu.cse.pccafe_management_system.Forms;

/**
 *
 * @author kgb69
 */
public class AdminForm_Behavior implements MainForm_Behavior {

    @Override
    public void show_Form() {
        System.out.println(" ===============");
        System.out.println("||   1. 관리자 인증         ||");
        System.out.println("||   2. 관리자 등록         ||");
        System.out.println(" ===============");
    }

}
