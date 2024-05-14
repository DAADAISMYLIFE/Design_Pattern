/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deu.ces.pattern_test.Mypage.PurchaseHistory;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author baemijin
 */
public class Sellersujung {
    private JTable SaleTable;
    private DefaultTableModel SellerModel;
    
    public Sellersujung() {
        JFrame SellerFrame = new JFrame("판매 내역");
        SellerFrame.setSize(500, 500);
        SellerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        SellerModel = new DefaultTableModel();
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
        
        
        SellerFrame.setLocationRelativeTo(null);
        SellerFrame.setResizable(false); //창 크기 고정
        SellerFrame.setVisible(true);

        SaleTable.getModel().addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                if (e.getType() == TableModelEvent.UPDATE) {
                    // 셀이 수정되었을 때 파일 업데이트 로직
                    updateFile();
                }
            }
        });

        // 파일에서 데이터 읽어오기
        try {
            BufferedReader reader = new BufferedReader(new FileReader("/Users/baemijin/Documents/Project/Mypage/구매내역.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                SellerModel.addRow(data);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private void updateFile() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("/Users/baemijin/Documents/Project/Mypage/구매내역.txt"));
            for (int i = 0; i < SellerModel.getRowCount(); i++) {
                for (int j = 0; j < SellerModel.getColumnCount(); j++) {
                    writer.write(SellerModel.getValueAt(i, j).toString());
                    if (j < SellerModel.getColumnCount() - 1) {
                        writer.write(","); // 셀 데이터 사이에 쉼표 추가
                    }
                }
                writer.newLine(); // 행마다 줄바꿈 추가
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        Sellersujung c = new Sellersujung();
    }
}