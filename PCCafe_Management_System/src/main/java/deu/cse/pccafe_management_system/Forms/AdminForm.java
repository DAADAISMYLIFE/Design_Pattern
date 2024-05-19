/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deu.cse.pccafe_management_system.Forms;

import deu.cse.pccafe_management_system.UserAccountSystem.Member_Creation.AdminMember_Creation_Behavior;

public class AdminForm extends Form {

    public AdminForm() {
         this.form_Behavior = new AdminForm_Behavior();
         this.creation_Behavior = new AdminMember_Creation_Behavior();
    }
    
}
