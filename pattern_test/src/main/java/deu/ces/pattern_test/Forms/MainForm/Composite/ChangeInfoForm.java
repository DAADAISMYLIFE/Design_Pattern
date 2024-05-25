/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deu.ces.pattern_test.Forms.MainForm.Composite;

import deu.ces.pattern_test.FileManager.FileManager;
import deu.ces.pattern_test.FileManager.RemoteLoader;
import deu.ces.pattern_test.Forms.MainForm.CustomerMainBehavior;
import deu.ces.pattern_test.Product.Product;
import deu.ces.pattern_test.Product.ProductSystem;
import deu.ces.pattern_test.Product.ShoppingCartSystem;
import deu.ces.pattern_test.Product.ShoppingData;
import deu.ces.pattern_test.Users.Customer;
import deu.ces.pattern_test.Users.UserSystem;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListCellRenderer;
import javax.swing.ListSelectionModel;

/**
 *
 * @author gka
 */
public class ChangeInfoForm extends FormComponent {

    @Override
    public void showForm() {
        JFrame CustomerFrame = new JFrame();
        CustomerFrame.setTitle("고객 정보 수정");
        CustomerFrame.setSize(250, 250);
        CustomerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null); // Null layout 사용

        JLabel name = new JLabel("Name");
        JLabel address = new JLabel("Address");

        Customer user = (Customer) UserSystem.getInstance().getUser(UserSystem.getInstance().getLogedInUser().getId());

        JTextField nameField = new JTextField(user.getName());
        JTextField addressField = new JTextField(user.getAddress());

        JButton change = new JButton("수정");
        JButton cancel = new JButton("취소");

        // 컴포넌트의 위치와 크기 설정
        name.setBounds(25, 25, 80, 30);
        nameField.setBounds(120, 25, 105, 30);
        address.setBounds(25, 65, 80, 30);
        addressField.setBounds(25, 95, 200, 30);
        change.setBounds(25, 160, 90, 35);
        cancel.setBounds(125, 160, 90, 35);

        // 컴포넌트를 패널에 추가
        panel.add(name);
        panel.add(nameField);
        panel.add(address);
        panel.add(addressField);
        panel.add(change);
        panel.add(cancel);

        // 패널을 프레임에 추가
        CustomerFrame.add(panel);

        //변경 동작
        change.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String changedName = nameField.getText();
                String changedAddress = addressField.getText();

                if (!changedName.isBlank() && !changedAddress.isBlank()) {
                    user.setName(changedName);
                    user.setAddress(changedAddress);
                    RemoteLoader.getInstance().getRemoteControl().buttonWasPressed(2, "user.txt");
                    JOptionPane.showMessageDialog(null, "성공적으로 변경됨", "변경 성공", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "변경 내용을 입력해주세요", "변경 오류", JOptionPane.WARNING_MESSAGE);
                }

                CustomerFrame.dispose();
            }
        });

        //취소 동작
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CustomerFrame.dispose();
            }
        });

        CustomerFrame.setLocationRelativeTo(null);
        CustomerFrame.setResizable(false);
        CustomerFrame.setVisible(true);
    }

    // 쇼핑 화면
    public void showShoppingForm() {
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
                        showProductDetail(selectedProduct);
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

    // showProductDetail 메서드 수정
    private void showProductDetail(Product product) {
        JFrame detailFrame = new JFrame("상품 상세 정보");
        detailFrame.setSize(500, 400);
        detailFrame.setLocationRelativeTo(null);

        JPanel panel = new JPanel(new BorderLayout());

        JLabel nameLabel = new JLabel("상품명: " + product.getName());
        JLabel priceLabel = new JLabel("가격: " + (int) product.getPrice() + "원");
        JLabel brandLabel = new JLabel("브랜드: " + product.getBrand());
        JLabel descriptionLabel = new JLabel("설명: " + product.getDescription());
        JLabel imageLabel = new JLabel();

        // 사이즈 선택 콤보박스
        JComboBox<String> sizeComboBox = new JComboBox<>(new String[]{"S", "M", "L", "XL", "2XL"});

        // 색상 선택 콤보박스
        JComboBox<String> colorComboBox = new JComboBox<>(new String[]{"Black", "White", "Red", "Blue", "Kaki", "Gray"});

        JTextField quantityField = new JTextField(10);
        JButton addToCartButton = new JButton("장바구니에 추가");

        addToCartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int quantity = Integer.parseInt(quantityField.getText());
                    String selectedSize = (String) sizeComboBox.getSelectedItem();
                    String selectedColor = (String) colorComboBox.getSelectedItem();
                    // 선택한 상품과 함께 사이즈와 색상 정보를 장바구니에 추가하는 메서드 호출
                    addToCart(product, quantity, selectedSize, selectedColor);
                    JOptionPane.showMessageDialog(null, "장바구니에 추가되었습니다.", "장바구니", JOptionPane.INFORMATION_MESSAGE);

                    detailFrame.dispose();
                } catch (NumberFormatException numberException) {
                    JOptionPane.showMessageDialog(null, "양의 정수만 입력해 주세요", "value error!", JOptionPane.WARNING_MESSAGE);
                } catch (IOException ex) {
                    Logger.getLogger(CustomerMainBehavior.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        // 수량 입력 필드와 추가 버튼을 담는 패널을 생성합니다.
        JPanel inputPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        inputPanel.add(new JLabel("사이즈: "));
        inputPanel.add(sizeComboBox);
        inputPanel.add(new JLabel("색상: "));
        inputPanel.add(colorComboBox);
        inputPanel.add(new JLabel("수량: "));
        inputPanel.add(quantityField);
        inputPanel.add(addToCartButton);

        // 상품 설명 등을 담는 패널을 생성합니다.
        JPanel infoPanel = new JPanel(new GridLayout(0, 1));
        infoPanel.add(nameLabel);
        infoPanel.add(priceLabel);
        infoPanel.add(brandLabel);
        infoPanel.add(descriptionLabel);

        // 이미지를 담는 레이블을 infoPanel에 추가합니다.
        imageLabel.setIcon(new ImageIcon(FileManager.getBasePath() + File.separator + product.getImagePath()));
        imageLabel.setBounds(280, 20, 200, 200);
        detailFrame.add(imageLabel);

        // infoPanel을 BorderLayout의 CENTER에 추가합니다.
        panel.add(infoPanel, BorderLayout.CENTER);

        // inputPanel을 infoPanel의 SOUTH에 추가합니다.
        infoPanel.add(inputPanel, BorderLayout.SOUTH);

        detailFrame.add(panel);
        detailFrame.setVisible(true);
        detailFrame.setResizable(false);

    }

    // 장바구니에 상품을 추가하는 메서드
    private void addToCart(Product product, int quantity, String size, String color) throws IOException {
        // 여기에 장바구니에 상품을 추가하는 코드를 작성하세요.
        ShoppingData newCart = new ShoppingData(product);
        newCart.initialSetShoppingCart(
                UserSystem.getInstance().getLogedInUser().getId(), product.getProductID(),
                product.getBrand(), product.getName(),
                color, size, quantity, (int) product.getPrice());
        ShoppingCartSystem.getInstance().registerCart(newCart);
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
