/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deu.ces.pattern_test.Forms.MainForm.Composite;

import deu.ces.pattern_test.Product.ShoppingCartSystem;
import deu.ces.pattern_test.Product.ShoppingHistory;
import deu.ces.pattern_test.Users.UserSystem;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author gka
 */
public class ShoppingHistoryForm extends FormComponent {

    @Override
    public void showForm() {
        JFrame paymentFrame = new JFrame("구매 내역");
        paymentFrame.setSize(500, 500);
        paymentFrame.setLocationRelativeTo(null);

        JPanel panel = new JPanel(new BorderLayout());
        JButton back = new JButton("뒤로가기");
        
        String customerID = UserSystem.getInstance().getLogedInUser().getName();

        ArrayList<Object[]> cartItems = new ArrayList<>();
        for (ShoppingHistory history : ShoppingCartSystem.getInstance().getHistory(customerID)) {
            System.out.println(history.getColor());
            Object[] item = {history.getBrandName(), history.getProductName(),
                history.getColor(), history.getSize(),
                history.getProductPrice(), history.getProductQuantity(), history.getTotalAmount()};
            cartItems.add(item);
        }

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                paymentFrame.dispose();
            }
        });

        // 결제 정보를 담을 테이블 생성
        String[] columnNames = {"브랜드", "제품명", "색상", "사이즈", "가격", "수량", "총 가격"};
        Object[][] data = new Object[cartItems.size()][7];
        for (int i = 0; i < cartItems.size(); i++) {
            Object[] item = cartItems.get(i);
            data[i][0] = item[0]; // 브랜드
            data[i][1] = item[1]; // 제품명
            data[i][2] = item[2]; // 색상
            data[i][3] = item[3]; // 사이즈
            data[i][4] = item[4]; // 가격
            data[i][5] = item[5]; // 수량
            data[i][6] = item[6]; // 총 가격
        }

        JTable paymentTable = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(paymentTable);

        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.add(back, BorderLayout.SOUTH);
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(bottomPanel, BorderLayout.SOUTH);

        paymentFrame.add(panel);
        paymentFrame.setVisible(true);
        paymentFrame.setResizable(false);
    }
}

