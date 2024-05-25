/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deu.ces.pattern_test.Forms.MainForm;

import deu.ces.pattern_test.Forms.CustomerForm;
import deu.ces.pattern_test.Forms.MainForm.Composite.CartForm;
import deu.ces.pattern_test.Forms.MainForm.Composite.ChangeInfoForm;
import deu.ces.pattern_test.Forms.MainForm.Composite.CustomerFormManager;
import deu.ces.pattern_test.Forms.MainForm.Composite.FormComponent;
import deu.ces.pattern_test.Forms.MainForm.Composite.MainForm;
import deu.ces.pattern_test.Forms.MainForm.Composite.MyPageForm;
import deu.ces.pattern_test.Forms.MainForm.Composite.ShoppingForm;
import deu.ces.pattern_test.Forms.MainForm.Composite.ShoppingHistoryForm;

/**
 *
 * @author gka
 */
public class CustomerMainBehavior implements MainBehavior {

    @Override
    public void showMainForm() {

        FormComponent mainForm = new MainForm();
        FormComponent cartForm = new CartForm();
        FormComponent shoppingForm = new ShoppingForm();
        FormComponent myPageForm = new MyPageForm();
        FormComponent shoppingHistoryForm = new ShoppingHistoryForm();
        FormComponent changeInfoForm = new ChangeInfoForm();

        mainForm.add(cartForm);
        mainForm.add(shoppingForm);
        mainForm.add(myPageForm);

        myPageForm.add(shoppingHistoryForm);
        myPageForm.add(changeInfoForm);

        CustomerFormManager cfm = new CustomerFormManager(mainForm);
        cfm.showForm();
    }
}
