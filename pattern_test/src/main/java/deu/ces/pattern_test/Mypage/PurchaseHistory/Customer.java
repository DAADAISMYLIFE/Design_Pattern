/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deu.ces.pattern_test.Mypage.PurchaseHistory;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.*;

/**
 *
 * @author baemijin
 */
public class Customer {

    //모든 셀을 편집 불가능하도록 설정
    class NonEditableModel extends DefaultTableModel {

        public NonEditableModel(Object[][] data, Object[] columnNames) {
            super(data, columnNames);
        }

        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    }

    public Customer() {
        JTable purchaseTable;
        JFrame CustomerFrame = new JFrame("구매내역");
        CustomerFrame.setSize(500, 500);
        CustomerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        NonEditableModel CustomerModel = new NonEditableModel(new Object[][]{}, new Object[]{"종류", "수량", "옵션"});

        JButton cancel = new JButton("취소");
        JPanel p = new JPanel();

        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new deu.ces.pattern_test.Mypage.Select.Customer();
                CustomerFrame.dispose();
            }
        });

        purchaseTable = new JTable(CustomerModel);
        JScrollPane scrollPane = new JScrollPane(purchaseTable);
        //CustomerFrame.getContentPane().add(scrollPane);
        CustomerFrame.add(p);
        p.add(scrollPane);
        p.add(cancel);

        File note = new File("/Users/baemijin/Documents/Project/Mypage/구매내역.txt");
        try {
            BufferedReader reader = new BufferedReader(new FileReader("구매내역.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                CustomerModel.addRow(data);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        CustomerFrame.setLocationRelativeTo(null);
        CustomerFrame.setResizable(false); //창 크기 고정
        CustomerFrame.setVisible(true);
    }

    public static void main(String[] args) {
        Customer c = new Customer();
    }

}
