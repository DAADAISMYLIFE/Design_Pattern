/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deu.ces.pattern_test.Mypage.Select;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author baemijin
 */
public class Seller {
    public Seller() {
        JFrame SellerFrame = new JFrame("판매자_Mypage");
        SellerFrame.setSize(250, 350);

        JButton Change = new JButton("정보 수정");
        JButton Purchase = new JButton("판매 내역");
        JButton Back = new JButton("뒤로가기");

        // 버튼들을 패널에 추가
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.add(Change);
        panel.add(Purchase);
        panel.add(Back);

        // 각 버튼들의 위치 설정
        Change.setBounds(44, 45, 160, 60);
        Purchase.setBounds(44, 135, 160, 60);
        Back.setBounds(85, 245, 80, 20);

        Change.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new deu.ces.pattern_test.Mypage.Change.Seller();
                SellerFrame.dispose();
            }
        });
        
        Purchase.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new deu.ces.pattern_test.Mypage.PurchaseHistory.Seller();
                SellerFrame.dispose();
            }
        });
        
        // 패널을 프레임에 추가
        SellerFrame.add(panel);

        SellerFrame.setLocationRelativeTo(null);
        SellerFrame.setResizable(false);
        SellerFrame.setVisible(true);
        SellerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {
        Seller s = new Seller();
    }
}
