/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deu.ces.pattern_test.Forms;

import deu.ces.pattern_test.LoginState.UserContext;
import deu.ces.pattern_test.Users.UserSystem;
import java.awt.Container;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author gka
 */
public class LandingForm {

    Form form;

    public void showInterface() {
        JFrame frmR = new JFrame();
        frmR.setTitle("스마트 배송 서비스");
        frmR.setSize(280, 180);
        Container swingContext = frmR.getContentPane();
        swingContext.setLayout(null);

        JLabel idLabel = new JLabel("ID : ");
        JLabel passLabel = new JLabel("Password : ");
        JTextField idField = new JTextField();
        JPasswordField passField = new JPasswordField();
        JButton loginBtn = new JButton("로그인");
        JButton registerBtn = new JButton("회원가입");

        idLabel.setBounds(30, 30, 100, 30);
        idField.setBounds(120, 30, 100, 30);
        passLabel.setBounds(30, 60, 100, 30);
        passField.setBounds(120, 60, 100, 30);
        loginBtn.setBounds(30, 100, 80, 30);
        registerBtn.setBounds(120, 100, 100, 30);

        swingContext.add(idLabel);
        swingContext.add(passLabel);
        swingContext.add(idField);
        swingContext.add(passField);
        swingContext.add(loginBtn);
        swingContext.add(registerBtn);

        loginBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = idField.getText();
                String password = new String(passField.getPassword());
                if (id.isBlank() || password.isBlank()) {
                    JOptionPane.showMessageDialog(null, "아이디와 비밀번호를 입력해주세요.");
                } else {
                    UserSystem.login(id, password);
                    if (UserSystem.LogedInUser == null) {
                        JOptionPane.showMessageDialog(null, "회원정보를 찾을 수 없습니다.");
                    } else if (UserSystem.LogedInUser != null) {
                        frmR.dispose();
                        UserContext.getInstance().login();
                    }

                }
            }
        });

        registerBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //
                JFrame questionFrame = new JFrame("회원 가입");
                questionFrame.setSize(250, 150);
                questionFrame.setLayout(null);

                JLabel questionLabel = new JLabel("사용자 유형을 선택해주세요?");
                JButton customerButton = new JButton("구매자");
                JButton sellerButton = new JButton("판매자");

                questionLabel.setBounds(40, 10, 200, 50);
                customerButton.setBounds(40, 60, 80, 30);
                sellerButton.setBounds(120, 60, 80, 30);

                questionFrame.add(questionLabel);
                questionFrame.add(customerButton);
                questionFrame.add(sellerButton);

                customerButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        form = new CustomerForm();
                        form.performRegister();
                        questionFrame.dispose();
                    }
                });

                sellerButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        form = new SellerForm();
                        form.performRegister();
                        questionFrame.dispose();
                    }
                });

                questionFrame.setLocationRelativeTo(null);
                questionFrame.setVisible(true);
            }
        });

        frmR.setVisible(true);
        frmR.setLocationRelativeTo(null);
        frmR.setResizable(false);
        frmR.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
