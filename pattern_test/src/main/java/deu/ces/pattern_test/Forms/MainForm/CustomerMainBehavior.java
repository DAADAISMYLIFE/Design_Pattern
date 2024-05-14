/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deu.ces.pattern_test.Forms.MainForm;

import deu.ces.pattern_test.FileManager.FileManager;
import deu.ces.pattern_test.LoginState.UserContext;
import deu.ces.pattern_test.Product.Product;
import deu.ces.pattern_test.Product.ProductSystem;
import deu.ces.pattern_test.ShoppingCart.ShoppingCartDisplay;
import deu.ces.pattern_test.ShoppingCart.ShoppingData;
import deu.ces.pattern_test.ShoppingCart.ShoppingCartSystem;
import deu.ces.pattern_test.Users.UserSystem;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author gka
 */
public class CustomerMainBehavior implements MainBehavior {

    @Override
    public void showMainForm() {
        JFrame mainFrame = new JFrame("구매자 메인");
        mainFrame.setSize(250, 450);
        mainFrame.setLayout(null);

        JButton cartButton = new JButton("장바구니");
        JButton purchaseButton = new JButton("구매내역");
        JButton shoppingButton = new JButton("쇼핑하기");
        JButton backButton = new JButton("로그아웃");

        cartButton.setBounds(40, 30, 160, 60);
        purchaseButton.setBounds(40, 120, 160, 60);
        shoppingButton.setBounds(40, 210, 160, 60);
        backButton.setBounds(40, 310, 160, 60);

        mainFrame.add(cartButton);
        mainFrame.add(purchaseButton);
        mainFrame.add(shoppingButton);
        mainFrame.add(backButton);

        cartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showCartForm(UserSystem.getInstance().getLogedInUser().getId());
            }
        });

        shoppingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.dispose();
                showShoppingForm();
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.dispose();
                UserContext.getInstance().logout();
                UserContext.getInstance().login();
            }
        });

        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);
        mainFrame.setResizable(false);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // 쇼핑 화면
    public void showShoppingForm() {
        JFrame frame = new JFrame("상품 목록");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
                        Product selectedProduct = productListModel.getElementAt(selectedIndex);
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
                showCartForm(UserSystem.getInstance().getLogedInUser().getId());
            }
        });

        JButton backButton = new JButton("뒤로가기");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                showMainForm();
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

    // showProductDetail 메서드 수정
    private void showProductDetail(Product product) {
        JFrame detailFrame = new JFrame("상품 상세 정보");
        detailFrame.setSize(400, 300);
        detailFrame.setLocationRelativeTo(null);

        JPanel panel = new JPanel(new BorderLayout());

        JLabel nameLabel = new JLabel("상품명: " + product.getName());
        JLabel priceLabel = new JLabel("가격: " + (int) product.getPrice() + "원");
        JLabel brandLabel = new JLabel("브랜드: " + product.getBrand());
        JLabel descriptionLabel = new JLabel("설명: " + product.getDescription());
        JLabel imageLabel = new JLabel();
        JTextField quantityField = new JTextField(10);
        JButton addToCartButton = new JButton("장바구니에 추가");

        addToCartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int quantity = Integer.parseInt(quantityField.getText());
                    // 장바구니에 상품을 추가하는 기능을 호출
                    addToCart(product, quantity);
                } catch (NumberFormatException numberException) {
                    System.out.println("숫자만 입력할 것");
                } catch (IOException ex) {
                    Logger.getLogger(CustomerMainBehavior.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        // 수량 입력 필드와 추가 버튼을 담는 패널을 생성합니다.
        JPanel inputPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
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
        imageLabel.setIcon(new ImageIcon(FileManager.getBasePath() + "\\" + product.getImagePath()));
        imageLabel.setBounds(230, 20, 150, 150);
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
    private void addToCart(Product product, int quantity) throws IOException {
        // 여기에 장바구니에 상품을 추가하는 코드를 작성하세요.
        String message = "장바구니에 " + quantity + "개의 " + product.getName() + " 상품이 추가되었습니다.";
        ShoppingData newCart = new ShoppingData();
        ShoppingCartDisplay currentDisplay = new ShoppingCartDisplay(newCart);
        ShoppingCartSystem.getInstance().registerCart(currentDisplay);
        newCart.setShoppingCart(UserSystem.getInstance().getLogedInUser().getId(), "브랜드", product.getName(), quantity, (int) product.getPrice());
        JOptionPane.showMessageDialog(null, message, "장바구니 추가", JOptionPane.INFORMATION_MESSAGE);
    }

    public void showCartForm(String customerID) {
        ArrayList<ShoppingCartDisplay> carts = ShoppingCartSystem.getInstance().getShoppingCarts(customerID);
        System.out.println(carts);

        // 장바구니 폼
        JFrame cartFrame = new JFrame("장바구니 정보");
        JTable table;
        JButton payButton;
        JButton backButton;

        cartFrame.setTitle("장바구니");
        cartFrame.setSize(600, 400);
        cartFrame.setLocationRelativeTo(null); // 창을 화면 중앙에 위치
        cartFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 테이블 모델 설정
        String[] columnNames = {"구매자", "브랜드", "제품명", "구매가격", "개수"};
        // 데이터를 저장할 ArrayList 선언 (Object 배열의 리스트)
        ArrayList<Object[]> dataList = new ArrayList<>();

        for (ShoppingCartDisplay cart : carts) {
            // 각 카트 항목마다 Object 배열 생성
            Object[] row = {cart.getCustomerID(), cart.getBrandName(), cart.getProductName(), cart.getProductPrice(), cart.getProductQuantity()};

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
        backButton = new JButton("뒤로가기");
        buttonPanel.add(payButton);
        buttonPanel.add(backButton);

        cartFrame.add(buttonPanel, BorderLayout.SOUTH);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cartFrame.dispose();
            }
        });

        // 결제 버튼의 액션 리스너 추가
        payButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 장바구니에 있는 상품 정보를 가져옴
                ArrayList<ShoppingCartDisplay> carts = ShoppingCartSystem.getInstance().getShoppingCarts(UserSystem.getInstance().getLogedInUser().getId());
                ArrayList<Object[]> cartItems = new ArrayList<>();
                double totalAmount = 0;
                for (ShoppingCartDisplay cart : carts) {
                    Object[] item = {cart.getBrandName(), cart.getProductName(), cart.getProductPrice(), cart.getProductQuantity()};
                    cartItems.add(item);
                    totalAmount += cart.getProductPrice() * cart.getProductQuantity();
                }
                // 결제 정보를 표시하는 메서드 호출
                showPaymentDetails(cartItems, totalAmount);
            }
        });

        cartFrame.setVisible(true);
        cartFrame.setResizable(false);

    }

    private void showPaymentDetails(ArrayList<Object[]> cartItems, double totalAmount) {
        JFrame paymentFrame = new JFrame("결제 정보");
        paymentFrame.setSize(400, 300);
        paymentFrame.setLocationRelativeTo(null);

        JPanel panel = new JPanel(new BorderLayout());

        // 결제 정보를 담을 테이블 생성
        String[] columnNames = {"브랜드", "제품명", "가격", "수량"};
        Object[][] data = new Object[cartItems.size()][4];
        for (int i = 0; i < cartItems.size(); i++) {
            data[i] = cartItems.get(i);
        }
        JTable paymentTable = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(paymentTable);

        // 총 금액 표시 레이블 생성
        int totalAmountInt = (int) totalAmount;
        JLabel totalLabel = new JLabel("총 금액:  " + totalAmountInt + "원");

        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(totalLabel, BorderLayout.SOUTH);

        paymentFrame.add(panel);
        paymentFrame.setVisible(true);
        paymentFrame.setResizable(false);
    }
}
