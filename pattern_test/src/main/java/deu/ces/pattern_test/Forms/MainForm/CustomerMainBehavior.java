/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deu.ces.pattern_test.Forms.MainForm;

import deu.ces.pattern_test.FileManager.FileManager;
import deu.ces.pattern_test.FileManager.RemoteLoader;
import deu.ces.pattern_test.LoginState.UserContext;
import deu.ces.pattern_test.Product.Product;
import deu.ces.pattern_test.Product.ProductSystem;
import deu.ces.pattern_test.ShoppingCart.ShoppingData;
import deu.ces.pattern_test.ShoppingCart.ShoppingCartSystem;
import deu.ces.pattern_test.ShoppingCart.ShoppingHistory;
import deu.ces.pattern_test.Users.Customer;
import deu.ces.pattern_test.Users.UserSystem;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 *
 * @author gka
 */
public class CustomerMainBehavior implements MainBehavior {

    @Override
    public void showMainForm() {
        JFrame mainFrame = new JFrame("구매자 메인");
        mainFrame.setSize(250, 430);
        mainFrame.setLayout(null);

        JButton cartButton = new JButton("장바구니");
        JButton shoppingButton = new JButton("쇼핑하기");
        JButton myPageButton = new JButton("마이페이지");
        JButton backButton = new JButton("로그아웃");

        cartButton.setBounds(40, 30, 160, 60);
        shoppingButton.setBounds(40, 120, 160, 60);
        myPageButton.setBounds(40, 210, 160, 60);
        backButton.setBounds(40, 300, 160, 60);

        mainFrame.add(cartButton);
        mainFrame.add(myPageButton);
        mainFrame.add(shoppingButton);
        mainFrame.add(backButton);
        cartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.dispose();
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

        myPageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.dispose();
                showMyPageForm();
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

    public void showMyPageForm() {
        JFrame myPageFrame = new JFrame();
        myPageFrame.setTitle("고객 정보 수정");
        myPageFrame.setSize(250, 250);
        myPageFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null); // Null layout 사용

        JButton purchaseButton = new JButton("구매내역");
        JButton changeInfoButton = new JButton("정보수정");
        JButton backButton = new JButton("뒤로가기");

        purchaseButton.setBounds(40, 30, 160, 40);
        changeInfoButton.setBounds(40, 90, 160, 40);
        backButton.setBounds(40, 150, 160, 40);

        // 컴포넌트를 패널에 추가
        panel.add(purchaseButton);
        panel.add(changeInfoButton);
        panel.add(backButton);

        purchaseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                myPageFrame.dispose();
                showPaymentHistory(UserSystem.getInstance().getLogedInUser().getId());
            }
        });

        changeInfoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                myPageFrame.dispose();
                showChangeInfoForm();
            }
        });

        //뒤로가기버튼
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                myPageFrame.dispose();
                showMainForm();
            }
        });

        // 패널을 프레임에 추가
        myPageFrame.add(panel);

        myPageFrame.setLocationRelativeTo(null);
        myPageFrame.setResizable(false);
        myPageFrame.setVisible(true);
    }

    @Override
    public void showChangeInfoForm() {
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
                showMyPageForm();
            }
        });

        //취소 동작
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CustomerFrame.dispose();
                showMyPageForm();
            }
        });

        CustomerFrame.setLocationRelativeTo(null);
        CustomerFrame.setResizable(false);
        CustomerFrame.setVisible(true);
    }

    // 쇼핑 화면
    public void showShoppingForm() {
        JFrame frame = new JFrame("상품 목록");
        frame.setSize(500, 400);
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
                showCartForm(UserSystem.getInstance().getLogedInUser().getId());
                frame.dispose();
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
        ShoppingData newCart = new ShoppingData();
        newCart.setShoppingCart(
                UserSystem.getInstance().getLogedInUser().getId(),
                "브랜드", product.getName(),
                color, size, quantity, (int) product.getPrice());
        ShoppingCartSystem.getInstance().registerCart(newCart);
    }

    public void showCartForm(String customerID) {
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
                showMainForm();
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
                    try {
                        ShoppingCartSystem.getInstance().removeCartItem(customerID, productName);
                        model.removeRow(selectedRow);
                        JOptionPane.showMessageDialog(cartFrame, "상품이 장바구니에서 삭제되었습니다.");
                    } catch (IOException ex) {
                        Logger.getLogger(CustomerMainBehavior.class.getName()).log(Level.SEVERE, null, ex);
                    }
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

    private void updatePaymentInfo() {
        String customerID = UserSystem.getInstance().getLogedInUser().getId();
        ArrayList<ShoppingData> carts = ShoppingCartSystem.getInstance().getShoppingCarts(customerID);
        double totalAmount = 0;
        for (ShoppingData cart : carts) {
            totalAmount += cart.getProductPrice() * cart.getProductQuantity();
        }
    }

    private void showPaymentDetails(ArrayList<Object[]> cartItems, double totalAmount) {
        JFrame paymentFrame = new JFrame("결제 정보");
        paymentFrame.setSize(500, 500);
        paymentFrame.setLocationRelativeTo(null);
        paymentFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new BorderLayout());

        // 결제 정보를 담을 테이블 생성
        String[] columnNames = {"브랜드", "제품명", "색상", "사이즈", "가격", "수량"};
        Object[][] data = new Object[cartItems.size()][6];
        for (int i = 0; i < cartItems.size(); i++) {
            Object[] item = cartItems.get(i);
            data[i][0] = item[0]; // 브랜드
            data[i][1] = item[1]; // 제품명
            data[i][2] = item[2]; // 색상
            data[i][3] = item[3]; // 사이즈
            data[i][4] = item[4]; // 가격
            data[i][5] = item[5]; // 수량
        }

        // 장바구니에 아무것도 담지 않은 경우
        if (data.length <= 0) {
            JOptionPane.showMessageDialog(null, "결제할 내용이 없습니다.", "결제 오류", JOptionPane.WARNING_MESSAGE);
            paymentFrame.dispose();
            showMainForm();
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
                showMainForm();
            }
        });

        // 뒤로가기 버튼 생성
        JButton backButton = new JButton("뒤로가기");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                paymentFrame.dispose();
                showCartForm(UserSystem.getInstance().getLogedInUser().getId());
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

    //구매기록 테이블
    private void showPaymentHistory(String customerID) {
        JFrame paymentFrame = new JFrame("구매 내역");
        paymentFrame.setSize(500, 500);
        paymentFrame.setLocationRelativeTo(null);

        JPanel panel = new JPanel(new BorderLayout());
        JButton cancel = new JButton("뒤로가기");

        ArrayList<Object[]> cartItems = new ArrayList<>();
        for (ShoppingHistory history : ShoppingCartSystem.getInstance().getHistory(customerID)) {
            System.out.println(history.getColor());
            Object[] item = {history.getBrandName(), history.getProductName(),
                history.getColor(), history.getSize(),
                history.getProductPrice(), history.getProductQuantity(), history.getTotalAmount()};
            cartItems.add(item);
        }

        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                paymentFrame.dispose();
                showMainForm();
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
        bottomPanel.add(cancel, BorderLayout.SOUTH);
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(bottomPanel, BorderLayout.SOUTH);

        paymentFrame.add(panel);
        paymentFrame.setVisible(true);
        paymentFrame.setResizable(false);
    }
}
