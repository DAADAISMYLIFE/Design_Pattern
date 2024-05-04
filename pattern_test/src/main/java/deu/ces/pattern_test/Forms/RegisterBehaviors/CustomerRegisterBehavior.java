/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deu.ces.pattern_test.Forms.RegisterBehaviors;

import deu.ces.pattern_test.Users.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author gka
 */
public class CustomerRegisterBehavior implements RegisterBehavior {

    @Override
    public void showRegisterForm() {
        JFrame registerFrame = new JFrame("회원가입");
        registerFrame.setSize(250, 350);
        registerFrame.setLayout(null);

        JLabel idLabel = new JLabel("아이디 :");
        JTextField idField = new JTextField();
        JLabel passLabel = new JLabel("비밀번호 :");
        JPasswordField passField = new JPasswordField();
        JLabel passCheckLabel = new JLabel("비밀번호 확인 :");
        JPasswordField passCheckField = new JPasswordField();
        JLabel nameLabel = new JLabel("이름 :");
        JTextField nameField = new JTextField();
        JLabel addressLabel = new JLabel("주소 :");
        JTextField addressField = new JTextField();

        JButton submitButton = new JButton("확인");
        JButton cancelButton = new JButton("취소");

        idLabel.setBounds(20, 20, 100, 30);
        idField.setBounds(110, 20, 100, 30);
        passLabel.setBounds(20, 70, 100, 30);
        passField.setBounds(110, 70, 100, 30);
        passCheckLabel.setBounds(20, 120, 100, 30);
        passCheckField.setBounds(110, 120, 100, 30);
        nameLabel.setBounds(20, 170, 100, 30);
        nameField.setBounds(110, 170, 100, 30);
        addressLabel.setBounds(20, 220, 100, 30);
        addressField.setBounds(110, 220, 100, 30);

        submitButton.setBounds(20, 270, 80, 30);
        cancelButton.setBounds(130, 270, 80, 30);

        registerFrame.add(idLabel);
        registerFrame.add(idField);
        registerFrame.add(passLabel);
        registerFrame.add(passField);
        registerFrame.add(passCheckLabel);
        registerFrame.add(passCheckField);
        registerFrame.add(nameLabel);
        registerFrame.add(nameField);
        registerFrame.add(addressLabel);
        registerFrame.add(addressField);
        registerFrame.add(submitButton);
        registerFrame.add(cancelButton);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = idField.getText();
                String password = new String(passField.getPassword());
                String passwordCheck = new String(passCheckField.getPassword());
                String name = nameField.getText();
                String address = addressField.getText();

                // 회원가입 폼 검증
                if (id.isBlank() || password.isBlank() || passwordCheck.isBlank() || name.isBlank() || address.isBlank()) {
                    JOptionPane.showMessageDialog(null, "모든 항목을 입력해주세요.");
                } else if (checkRegisterContext(id, password, passwordCheck)) {
                    User newUser = new Customer(id, password, name, address);
                    try {
                        UserSystem.getInstance().registerUser(newUser);
                    } catch (IOException ex) {
                        Logger.getLogger(CustomerRegisterBehavior.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    JOptionPane.showMessageDialog(null, "회원가입이 완료되었습니다.");
                    registerFrame.dispose();
                }
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registerFrame.dispose();
            }
        });

        registerFrame.setLocationRelativeTo(null);
        registerFrame.setVisible(true);
        registerFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    @Override
    public boolean checkRegisterContext(String id, String password, String passwordCheck) {
        if (!password.equals(passwordCheck)) {
            JOptionPane.showMessageDialog(null, "비밀번호가 다릅니다.");
            return false;
        }

        for (User u : UserSystem.getInstance().getUsers()) {
            if (u.getId().equals(id)) {
                JOptionPane.showMessageDialog(null, "동일한 ID가 존재합니다.");
                return false;
            }
        }

        return password.equals(passwordCheck);
    }
}
