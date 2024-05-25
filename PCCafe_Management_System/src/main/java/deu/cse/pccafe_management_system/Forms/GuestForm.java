/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deu.cse.pccafe_management_system.Forms;


import deu.cse.pccafe_management_system.UserAccountSystem.Member_Creation.PCcafeMember_Creation_Behavior;

/**
 *
 * @author kgb69
 */
public class GuestForm extends Form{
    
    
    public GuestForm() {
        this.form_Behavior = new GuestForm_Behavior();
        this.creation_Behavior = new PCcafeMember_Creation_Behavior();
    }
}
