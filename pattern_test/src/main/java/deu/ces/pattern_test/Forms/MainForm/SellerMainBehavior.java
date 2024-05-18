/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deu.ces.pattern_test.Forms.MainForm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author gka
 */
public class SellerMainBehavior implements MainBehavior {

    @Override
    public void showMainForm() {
        JFrame mainFrame = new JFrame("판매자 메인");
        mainFrame.setSize(250, 350);
        mainFrame.setLayout(null);

        JButton productButton = new JButton("제품 관리");
        JButton salesButton = new JButton("판매 기록");
        JButton changeInfoButton = new JButton("정보 수정");

        productButton.setBounds(40, 30, 160, 60);
        salesButton.setBounds(40, 120, 160, 60);
        changeInfoButton.setBounds(40, 210, 160, 60);

        mainFrame.add(productButton);
        mainFrame.add(salesButton);
        mainFrame.add(changeInfoButton);

        //버튼 동작
        changeInfoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.dispose();
                showChangeInfoForm();
            }
        });

        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);
        mainFrame.setResizable(false);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void showChangeInfoForm() {
        JFrame SellerFrame = new JFrame();
        SellerFrame.setTitle("판매자_ 정보수정");
        SellerFrame.setSize(250, 350);
        SellerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel id = new JLabel("ID");
        JLabel pw = new JLabel("Password");
        JLabel name = new JLabel("Name");
        JLabel BrandName = new JLabel("Brand Name");

        JTextField idField = new JTextField();
        JTextField pwField = new JTextField();
        JTextField nameField = new JTextField();
        JTextField BrandNameField = new JTextField();

        JButton change = new JButton("수정");
        JButton cancel = new JButton("취소");

        // 컴포넌트의 위치와 크기 설정
        id.setBounds(30, 40, 80, 30);
        idField.setBounds(125, 40, 105, 30);
        pw.setBounds(30, 80, 80, 30);
        pwField.setBounds(125, 80, 105, 30);
        name.setBounds(30, 120, 80, 30);
        nameField.setBounds(125, 120, 105, 30);
        BrandName.setBounds(30, 160, 80, 30);
        BrandNameField.setBounds(125, 160, 105, 30);

        change.setBounds(30, 235, 90, 35);
        cancel.setBounds(130, 235, 90, 35);

        // 컴포넌트를 패널에 추가
        panel.add(id);
        panel.add(idField);
        panel.add(pw);
        panel.add(pwField);
        panel.add(name);
        panel.add(nameField);
        panel.add(BrandName);
        panel.add(BrandNameField);

        panel.add(change);
        panel.add(cancel);

        // 패널을 프레임에 추가
        SellerFrame.add(panel);

        //버튼 동작
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SellerFrame.dispose();
            }
        });

        SellerFrame.setLocationRelativeTo(null);
        SellerFrame.setResizable(false);
        SellerFrame.setVisible(true);
    }
}
