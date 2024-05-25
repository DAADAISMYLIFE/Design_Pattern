/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deu.ces.pattern_test.Forms.MainForm.Composite;

import deu.ces.pattern_test.Forms.MainForm.CustomerMainBehavior;
import deu.ces.pattern_test.Product.ShoppingCartSystem;
import deu.ces.pattern_test.Product.ShoppingData;
import deu.ces.pattern_test.Users.UserSystem;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author gka
 */
public class CartForm extends FormComponent {

    @Override
    public void showForm() {
        String customerID = UserSystem.getInstance().getLogedInUser().getName();
        ArrayList<ShoppingData> carts = ShoppingCartSystem.getInstance().getShoppingCarts(customerID);
        // 장바구니 폼
        JFrame cartFrame = new JFrame("장바구니 정보");
        JTable table;
        JButton payButton;
        JButton deleteButton;
        JButton backButton;

        cartFrame.setTitle("장바구니");
        cartFrame.setSize(600, 400);
        cartFrame.setLocationRelativeTo(null); // 창을 화면 중앙에 위치
        cartFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 테이블 모델 설정
        String[] columnNames = {"구매자", "브랜드", "제품명", "색상", "사이즈", "개수", "구매가격",};
        // 데이터를 저장할 ArrayList 선언 (Object 배열의 리스트)
        ArrayList<Object[]> dataList = new ArrayList<>();

        for (ShoppingData cart : carts) {
            // 각 카트 항목마다 Object 배열 생성
            Object[] row = {cart.getCustomerID(), cart.getBrandName(), cart.getProductName(), cart.getColor(), cart.getSize(), cart.getProductQuantity(), cart.getProductPrice()};
            // 생성된 배열을 dataList에 추가
            dataList.add(row);
        }

        // dataList를 이용하여 Object[][] 배열 생성
        Object[][] data = new Object[dataList.size()][];
        for (int i = 0; i < dataList.size(); i++) {
            data[i] = dataList.get(i);
        }

        DefaultTableModel model = new DefaultTableModel(data, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        table = new JTable(model);

        // 스크롤 패인 추가
        JScrollPane scrollPane = new JScrollPane(table);
        cartFrame.add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        payButton = new JButton("결제");
        deleteButton = new JButton("삭제");
        backButton = new JButton("뒤로가기");
        buttonPanel.add(payButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(backButton);

        cartFrame.add(buttonPanel, BorderLayout.SOUTH);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cartFrame.dispose();
            }
        });

        // 삭제 버튼의 액션 리스너 추가
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    String productName = (String) table.getValueAt(selectedRow, 2); // 제품명 가져오기
                    // 장바구니에서 해당 항목 삭제
                    ShoppingCartSystem.getInstance().removeCartItem(customerID, productName);
                    model.removeRow(selectedRow);
                    JOptionPane.showMessageDialog(cartFrame, "상품이 장바구니에서 삭제되었습니다.");
                } else {
                    JOptionPane.showMessageDialog(cartFrame, "삭제할 항목을 선택해주세요.", "경고", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        // 결제 버튼의 액션 리스너 추가
        payButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 장바구니에 있는 상품 정보를 가져옴
                ArrayList<ShoppingData> carts = ShoppingCartSystem.getInstance().getShoppingCarts(UserSystem.getInstance().getLogedInUser().getId());
                ArrayList<Object[]> cartItems = new ArrayList<>();
                double totalAmount = 0;
                for (ShoppingData cart : carts) {
                    Object[] item = {cart.getBrandName(), cart.getProductName(), cart.getColor(), cart.getSize(), cart.getProductQuantity(), cart.getProductPrice()};
                    cartItems.add(item);
                    totalAmount += cart.getProductPrice() * cart.getProductQuantity();
                }
                // showPaymentDetails 메서드 호출
                cartFrame.dispose();
                showPaymentDetails(cartItems, totalAmount);
            }
        });
        cartFrame.setVisible(true);
        cartFrame.setResizable(false);
    }

    private void showPaymentDetails(ArrayList<Object[]> cartItems, double totalAmount) {
        JFrame paymentFrame = new JFrame("결제 정보");
        paymentFrame.setSize(500, 500);
        paymentFrame.setLocationRelativeTo(null);
        paymentFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new BorderLayout());

        // 결제 정보를 담을 테이블 생성
        String[] columnNames = {"브랜드", "제품명", "색상", "사이즈", "수량", "가격"};
        Object[][] data = new Object[cartItems.size()][6];
        for (int i = 0; i < cartItems.size(); i++) {
            Object[] item = cartItems.get(i);
            data[i][0] = item[0]; // 브랜드
            data[i][1] = item[1]; // 제품명
            data[i][2] = item[2]; // 색상
            data[i][3] = item[3]; // 사이즈
            data[i][4] = item[4]; // 수량
            data[i][5] = item[5]; // 가격
        }

        // 장바구니에 아무것도 담지 않은 경우
        if (data.length <= 0) {
            JOptionPane.showMessageDialog(null, "결제할 내용이 없습니다.", "결제 오류", JOptionPane.WARNING_MESSAGE);
            paymentFrame.dispose();
            return;
        }

        JTable paymentTable = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(paymentTable);

        // 결제 방식 선택 콤보 박스 생성
        JLabel paymentMethodLabel = new JLabel("결제 방식:");
        String[] paymentMethods = {"카드", "계좌이체"};
        JComboBox<String> paymentMethodComboBox = new JComboBox<>(paymentMethods);

        JPanel paymentMethodPanel = new JPanel();
        paymentMethodPanel.add(paymentMethodLabel);
        paymentMethodPanel.add(paymentMethodComboBox);

        // 총 금액 표시 레이블 생성
        int totalAmountInt = (int) totalAmount;
        JLabel totalLabel = new JLabel("총 금액: " + totalAmountInt + "원");

        // 결제하기 버튼 생성
        JButton paymentButton = new JButton("결제하기");
        paymentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedPaymentMethod = (String) paymentMethodComboBox.getSelectedItem();
                JOptionPane.showMessageDialog(paymentFrame, "결제가 완료되었습니다.\n결제 방식: " + selectedPaymentMethod);
                String customerID = UserSystem.getInstance().getLogedInUser().getId();
                try {
                    ShoppingCartSystem.getInstance().clearCart(customerID);
                } catch (IOException ex) {
                    Logger.getLogger(CustomerMainBehavior.class.getName()).log(Level.SEVERE, null, ex);
                }
                paymentFrame.dispose();
            }
        });

        // 뒤로가기 버튼 생성
        JButton backButton = new JButton("뒤로가기");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                paymentFrame.dispose();
                
            }
        });

        // 패널에 버튼 추가JPanel
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(backButton);
        buttonPanel.add(paymentButton);

        // 결제 프레임에 패널 추가
        paymentFrame.add(paymentMethodPanel, BorderLayout.NORTH);
        paymentFrame.add(totalLabel, BorderLayout.CENTER);
        paymentFrame.add(buttonPanel, BorderLayout.SOUTH);

        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.add(totalLabel, BorderLayout.WEST);
        bottomPanel.add(paymentButton, BorderLayout.EAST);

        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(paymentMethodPanel, BorderLayout.NORTH);
        panel.add(bottomPanel, BorderLayout.SOUTH);

        paymentFrame.add(panel);
        paymentFrame.setVisible(true);
        paymentFrame.setResizable(false);
    }

}
