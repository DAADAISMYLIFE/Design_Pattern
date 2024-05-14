/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deu.ces.pattern_test.Mypage.PurchaseHistory;

/**
 *
 * @author baemijin
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.*;

public class Seller {
    private JTable SaleTable;
    
    public Seller() {
        JFrame SellerFrame = new JFrame("판매 내역");
        SellerFrame.setSize(500, 500);
        SellerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        DefaultTableModel SellerModel = new DefaultTableModel();
        SellerModel.addColumn("종류");
        SellerModel.addColumn("수량");
        SellerModel.addColumn("옵션");
        
        JButton cancel = new JButton("취소");
        JPanel p = new JPanel();
        
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new deu.ces.pattern_test.Mypage.Select.Seller();
                SellerFrame.dispose();
            }
        });
        
        SaleTable = new JTable(SellerModel);
        JScrollPane scrollPane = new JScrollPane(SaleTable);
        SellerFrame.add(p);
        p.add(scrollPane);
        p.add(cancel);
        
        File note = new File("/Users/baemijin/Documents/Project/Mypage/구매내역.txt");
        try {
            BufferedReader reader = new BufferedReader(new FileReader("구매내역.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                SellerModel.addRow(data);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    
        SellerFrame.setLocationRelativeTo(null);
        SellerFrame.setResizable(false); //창 크기 고정
        SellerFrame.setVisible(true);
    }
    
    
    public static void main(String[] args) {
        Seller c = new Seller();
    }
    
}
