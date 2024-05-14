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
        JFrame mainFrame = new JFrame("판매자 메인");
        mainFrame.setSize(250, 250);
        mainFrame.setLayout(null);

        JButton productButton = new JButton("제품 관리");
        JButton salesButton = new JButton("판매 기록");
        
        productButton.setBounds(40, 30, 160, 60);
        salesButton.setBounds(40, 120, 160, 60);

        mainFrame.add(productButton);
        mainFrame.add(salesButton);

        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);
        mainFrame.setResizable(false);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
