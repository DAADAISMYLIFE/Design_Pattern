/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deu.ces.pattern_test.Forms.MainForm;

import javax.swing.*;

/**
 *
 * @author gka
 */
public class CustomerMainBehavior implements MainBehavior{

    @Override
    public void showMainForm() {
        JFrame registerFrame = new JFrame("구매자 메인");
        registerFrame.setSize(250, 350);
        registerFrame.setLayout(null);

        JLabel idLabel = new JLabel("아이디 :");
        JTextField idField = new JTextField();

        JButton submitButton = new JButton("확인");
        JButton cancelButton = new JButton("취소");

        idLabel.setBounds(20, 20, 100, 30);
        idField.setBounds(110, 20, 100, 30);
        submitButton.setBounds(20, 270, 80, 30);
        cancelButton.setBounds(130, 270, 80, 30);

        registerFrame.add(idLabel);
        registerFrame.add(idField);

        registerFrame.add(submitButton);
        registerFrame.add(cancelButton);

        registerFrame.setLocationRelativeTo(null);
        registerFrame.setVisible(true);
        registerFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}
