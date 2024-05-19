/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deu.cse.pccafe_management_system.Forms;

import deu.cse.pccafe_management_system.UserAccountSystem.Member_Creation.MemberCreation_Behavior;
import java.io.IOException;

/**
 *
 * @author kgb69
 */
public abstract class Form { // 폼 인터페이스

    protected MainForm_Behavior form_Behavior;
    protected MemberCreation_Behavior creation_Behavior;

    public void Perform_Main() {
        form_Behavior.show_Form();
    }

    public void perform_Creation() throws IOException {
        creation_Behavior.make_member();
    }
    
}
