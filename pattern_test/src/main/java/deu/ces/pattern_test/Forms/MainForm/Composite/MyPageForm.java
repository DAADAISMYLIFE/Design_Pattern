/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deu.ces.pattern_test.Forms.MainForm.Composite;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author gka
 */
public class MyPageForm extends FormComponent {

    @Override
    public void showForm() {
        JFrame myPageFrame = new JFrame();
        myPageFrame.setTitle("고객 정보 수정");
        myPageFrame.setSize(250, 270);
        myPageFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null); // Null layout 사용

        JButton purchaseButton = new JButton("구매내역");
        JButton changeInfoButton = new JButton("정보수정");
        JButton backButton = new JButton("뒤로가기");

        purchaseButton.setBounds(50, 40, 150, 48);
        changeInfoButton.setBounds(50, 100, 150, 48);
        backButton.setBounds(70, 170, 110, 35);

        // 컴포넌트를 패널에 추가
        panel.add(purchaseButton);
        panel.add(changeInfoButton);
        panel.add(backButton);

        purchaseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                myPageFrame.dispose();
            }
        });

        changeInfoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                myPageFrame.dispose();
            }
        });

        //뒤로가기버튼
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                myPageFrame.dispose();
            }
        });

        // 패널을 프레임에 추가
        myPageFrame.add(panel);

        myPageFrame.setLocationRelativeTo(null);
        myPageFrame.setResizable(false);
        myPageFrame.setVisible(true);
    }

}
