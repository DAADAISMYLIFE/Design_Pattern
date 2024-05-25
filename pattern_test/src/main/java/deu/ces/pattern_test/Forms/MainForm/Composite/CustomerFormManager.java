/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deu.ces.pattern_test.Forms.MainForm.Composite;

/**
 *
 * @author gka
 */
public class CustomerFormManager {

    FormComponent allForms;

    public CustomerFormManager(FormComponent allForms) {
        this.allForms = allForms;
    }
    
    public void showForm(){
        allForms.showForm();
    }   
}
