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
public class SellerMainBehavior implements MainBehavior{

    @Override
    public void showMainForm() {
        JFrame registerFrame = new JFrame("판매자 메인");
        registerFrame.setSize(250, 250);
        registerFrame.setLayout(null);

        JButton productButton = new JButton("제품 관리");
        JButton salesButton = new JButton("판매 기록");
        
        productButton.setBounds(40, 30, 160, 60);
        salesButton.setBounds(40, 120, 160, 60);

        registerFrame.add(productButton);
        registerFrame.add(salesButton);

        registerFrame.setLocationRelativeTo(null);
        registerFrame.setVisible(true);
        registerFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}
