/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deu.ces.pattern_test.Forms.MainForm.Composite;

import deu.ces.pattern_test.LoginState.UserContext;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author gka
 */
public class MainForm extends FormComponent {

    FormComponent main = this;

    @Override
    public void showForm() {
        JFrame mainFrame = new JFrame("구매자 메인");
        mainFrame.setSize(250, 430);
        mainFrame.setLayout(null);

        JButton cartButton = new JButton("장바구니");
        JButton shoppingButton = new JButton("쇼핑하기");
        JButton myPageButton = new JButton("마이페이지");
        JButton backButton = new JButton("로그아웃");

        cartButton.setBounds(45, 30, 160, 60);
        shoppingButton.setBounds(45, 120, 160, 60);
        myPageButton.setBounds(45, 210, 160, 60);
        backButton.setBounds(45, 300, 160, 60);

        mainFrame.add(cartButton);
        mainFrame.add(myPageButton);
        mainFrame.add(shoppingButton);
        mainFrame.add(backButton);

        cartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.dispose();
                main.getChild(0).showForm();
            }
        });

        shoppingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.dispose();
                main.getChild(1).showForm();

            }
        });

        myPageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.dispose();
                main.getChild(2).showForm();
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.dispose();
                UserContext.getInstance().logout();
                UserContext.getInstance().login();
            }
        });

        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);
        mainFrame.setResizable(false);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
