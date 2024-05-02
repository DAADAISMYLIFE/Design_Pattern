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
public class CustomerMainBehavior implements MainBehavior {

    @Override
    public void showMainForm() {
        JFrame mainFrame = new JFrame("구매자 메인");
        mainFrame.setSize(250, 350);
        mainFrame.setLayout(null);

        JButton cartButton = new JButton("장바구니");
        JButton purchaseButton = new JButton("구매내역");
        JButton shoppingButton = new JButton("쇼핑하기");

        cartButton.setBounds(40, 30, 160, 60);
        purchaseButton.setBounds(40, 120, 160, 60);
        shoppingButton.setBounds(40, 210, 160, 60);

        mainFrame.add(cartButton);
        mainFrame.add(purchaseButton);
        mainFrame.add(shoppingButton);

        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
