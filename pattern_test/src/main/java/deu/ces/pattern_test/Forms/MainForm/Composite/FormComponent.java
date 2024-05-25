/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deu.ces.pattern_test.Forms.MainForm.Composite;

import java.util.ArrayList;

/**
 *
 * @author gka
 */
public abstract class FormComponent {


    private ArrayList<FormComponent> formComponents = new ArrayList<>();

    public void add(FormComponent formComponent) {
        formComponents.add(formComponent);
    }

    public void remove(FormComponent formComponent) {
        formComponents.remove(formComponent);
    }

    public FormComponent getChild(int i) {
        return formComponents.get(i);
    }
    
    public void showForm() {
        for (FormComponent formComponent : formComponents) {
            formComponent.showForm();
        }
    }
}
