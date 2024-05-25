/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deu.ces.pattern_test.Forms.MainForm.Composite;

import deu.ces.pattern_test.Forms.MainForm.CustomerMainBehavior;
import deu.ces.pattern_test.Product.Product;
import deu.ces.pattern_test.Product.ProductSystem;
import deu.ces.pattern_test.Users.UserSystem;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListCellRenderer;
import javax.swing.ListSelectionModel;

/**
 *
 * @author gka
 */
public class ShoppingForm extends FormComponent {

    @Override
    public void showForm() {
        JFrame frame = new JFrame("상품 목록");
        frame.setSize(550, 400);
        frame.setLocationRelativeTo(null);

        // 상품 목록 모델 생성
        DefaultListModel<Product> productListModel = new DefaultListModel<>();

        // 상품 목록 불러옴
        ArrayList<Product> products = ProductSystem.getInstance().getProducts();

        for (Product product : products) {
            productListModel.addElement(product);
        }

        JList<Product> productList = new JList<>(productListModel);
        productList.setCellRenderer(new ProductListCellRenderer());
        productList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // 단일 선택 모드로 설정

        JScrollPane scrollPane = new JScrollPane(productList);

        // 상품 목록 클릭 이벤트 리스너 추가 (단일 클릭)
        productList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1) { // 단일 클릭인 경우
                    int selectedIndex = productList.getSelectedIndex();
                    if (selectedIndex != -1) {
                        Product selectedProduct = productList.getModel().getElementAt(selectedIndex);
                    }
                }
            }
        });

        JTextField searchField = new JTextField(20);
        searchField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String searchText = searchField.getText().toLowerCase();
                DefaultListModel<Product> filteredModel = new DefaultListModel<>();
                for (int i = 0; i < productListModel.getSize(); i++) {
                    Product product = productListModel.getElementAt(i);
                    if (product.getName().toLowerCase().contains(searchText)
                            || product.getDescription().toLowerCase().contains(searchText)) {
                        filteredModel.addElement(product);
                    }
                }
                productList.setModel(filteredModel);
            }
        });

        JButton cartButton = new JButton("장바구니로 이동");
        cartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 장바구니로 이동하는 기능을 추가하세요.
                frame.dispose();
            }
        });

        JButton backButton = new JButton("뒤로가기");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });

        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        topPanel.add(new JLabel("검색: "));
        topPanel.add(searchField);
        topPanel.add(cartButton);
        topPanel.add(backButton);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        frame.add(mainPanel);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // 상품 목록 셀 렌더러
    class ProductListCellRenderer extends JLabel implements ListCellRenderer<Product> {

        public ProductListCellRenderer() {
            setOpaque(true);
            setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        }

        @Override
        public Component getListCellRendererComponent(JList<? extends Product> list, Product value, int index, boolean isSelected, boolean cellHasFocus) {
            setText(value.getName());
            setIcon(new ImageIcon(value.getImagePath()));

            if (isSelected) {
                setBackground(list.getSelectionBackground());
                setForeground(list.getSelectionForeground());
            } else {
                setBackground(list.getBackground());
                setForeground(list.getForeground());
            }

            setFont(list.getFont());
            return this;
        }
    }
}
