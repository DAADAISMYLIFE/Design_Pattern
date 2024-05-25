package deu.ces.pattern_test.Forms.MainForm;

import deu.ces.pattern_test.FileManager.RemoteLoader;
import deu.ces.pattern_test.LoginState.UserContext;
import deu.ces.pattern_test.Product.Product;
import deu.ces.pattern_test.Product.ProductSystem;
import deu.ces.pattern_test.Product.ShoppingCartSystem;
import deu.ces.pattern_test.Product.ShoppingHistory;
import deu.ces.pattern_test.Users.Seller;
import deu.ces.pattern_test.Users.UserSystem;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.*;
import java.util.ArrayList;
import java.text.DecimalFormat;

/**
 *
 * @author gka
 */
public class SellerMainBehavior implements MainBehavior {

    @Override
    public void showMainForm() {
        JFrame mainFrame = new JFrame("판매자 메인");
        mainFrame.setSize(250, 350);
        mainFrame.setLayout(null);

        JButton productButton = new JButton("제품 관리");
        JButton salesButton = new JButton("판매 기록");
        JButton backButton = new JButton("로그아웃");

        productButton.setBounds(40, 30, 160, 60);
        salesButton.setBounds(40, 120, 160, 60);
        backButton.setBounds(40, 210, 160, 60);

        mainFrame.add(productButton);
        mainFrame.add(salesButton);
        mainFrame.add(backButton);

        // 버튼 동작
        productButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.dispose();
                showProductManagementForm();
            }
        });

        salesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.dispose();
                showSalesHistoryForm();
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

    public void showSalesHistoryForm() {
        JFrame salesFrame = new JFrame("판매 내역");
        salesFrame.setSize(500, 500);
        salesFrame.setLocationRelativeTo(null);

        JPanel panel = new JPanel(new BorderLayout());
        JButton back = new JButton("뒤로가기");

        Seller loginUser = (Seller) UserSystem.getInstance().getLogedInUser();

        ArrayList<Object[]> cartItems = new ArrayList<>();
        for (ShoppingHistory history : ShoppingCartSystem.getInstance().getSalesHistory(loginUser.getBrandName())) {
            System.out.println(history.getColor());
            Object[] item = {history.getCustomerID(), history.getBrandName(), history.getProductName(),
                history.getColor(), history.getSize(),
                history.getProductPrice(), history.getProductQuantity(), history.getTotalAmount()};
            cartItems.add(item);
        }

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                salesFrame.dispose();
                showMainForm();
            }
        });

        // 결제 정보를 담을 테이블 생성
        String[] columnNames = {"구매자", "브랜드", "제품명", "색상", "사이즈", "가격", "수량", "총 가격"};
        Object[][] data = new Object[cartItems.size()][8];
        for (int i = 0; i < cartItems.size(); i++) {
            Object[] item = cartItems.get(i);
            data[i][0] = item[0]; // 구매자
            data[i][1] = item[1]; // 브랜드
            data[i][2] = item[2]; // 제품명
            data[i][3] = item[3]; // 색상
            data[i][4] = item[4]; // 사이즈
            data[i][5] = item[5]; // 가격
            data[i][6] = item[6]; // 수량
            data[i][7] = item[7]; // 총 가격

        }

        JTable paymentTable = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(paymentTable);

        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.add(back, BorderLayout.SOUTH);
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(bottomPanel, BorderLayout.SOUTH);

        salesFrame.add(panel);
        salesFrame.setVisible(true);
        salesFrame.setResizable(false);
    }

    public void showProductManagementForm() {
        JFrame productFrame = new JFrame("제품 관리");
        productFrame.setSize(600, 350);
        productFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        ArrayList<Object[]> productItem = new ArrayList<>();

        Seller loginUser = (Seller) (UserSystem.getInstance().getLogedInUser());
        String userBrandName = loginUser.getBrandName();
        ArrayList<Product> products = ProductSystem.getInstance().getProductsByBrand(userBrandName);
        for (Product product : products) {
            // 각 카트 항목마다 Object 배열 생성
            Object[] row = {product.getProductID(), product.getBrand(), product.getName(), product.getPrice()};
            // 생성된 배열을 dataList에 추가
            productItem.add(row);
        }
        String[] columnNames = {"제품 ID", "브랜드", "제품 이름", "가격"};
        Object[][] data = new Object[productItem.size()][5];

        for (int i = 0; i < productItem.size(); i++) {
            Object[] item = productItem.get(i);
            data[i][0] = item[0]; // 제품 ID
            data[i][1] = item[1]; // 브랜드
            data[i][2] = item[2]; // 제품 이름
            data[i][3] = item[3]; // 가격
        }
        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        JTable productTable = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(productTable);
        scrollPane.setBounds(20, 20, 550, 200);
        panel.add(scrollPane);

        JButton addButton = new JButton("제품 추가");
        JButton modifyButton = new JButton("제품 수정");
        JButton deleteButton = new JButton("제품 삭제");
        JButton backButton = new JButton("뒤로가기");

        addButton.setBounds(40, 250, 100, 30);
        modifyButton.setBounds(160, 250, 100, 30);
        deleteButton.setBounds(280, 250, 100, 30);
        backButton.setBounds(400, 250, 100, 30);

        panel.add(addButton);
        panel.add(modifyButton);
        panel.add(deleteButton);
        panel.add(backButton);

        // 추가 버튼 동작
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showAddProductForm(model);
            }
        });

        // 수정 버튼 동작
        modifyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = productTable.getSelectedRow();
                if (selectedRow != -1) {
                    showModifyProductForm(model, selectedRow);
                } else {
                    JOptionPane.showMessageDialog(productFrame, "수정할 제품을 선택하세요.", "경고", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        // 삭제 버튼 동작
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = productTable.getSelectedRow();
                if (selectedRow != -1) {
                    String productID = model.getValueAt(selectedRow, 0).toString();
                    ProductSystem.getInstance().removeProduct(ProductSystem.getInstance().getProductsByID(productID));
                    JOptionPane.showMessageDialog(productFrame, "제품이 삭제되었습니다.", "제품 삭제", JOptionPane.INFORMATION_MESSAGE);
                    model.removeRow(selectedRow);
                } else {
                    JOptionPane.showMessageDialog(productFrame, "삭제할 제품을 선택하세요.", "경고", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        // 뒤로가기 버튼 동작
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                productFrame.dispose();
                showMainForm();
            }
        });

        productFrame.add(panel);
        productFrame.setLocationRelativeTo(null);
        productFrame.setResizable(false);
        productFrame.setVisible(true);
    }

    public void showAddProductForm(DefaultTableModel model) {
        JFrame addFrame = new JFrame("제품 추가");
        addFrame.setSize(400, 380);
        addFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel idLabel = new JLabel("제품 ID:");
        JLabel brandLabel = new JLabel("브랜드:");
        JLabel nameLabel = new JLabel("제품 이름:");
        JLabel priceLabel = new JLabel("가격:");
        JLabel descriptionLabel = new JLabel("설명:");
        JLabel imageLabel = new JLabel("이미지:");

        Seller loginUser = (Seller) (UserSystem.getInstance().getLogedInUser());
        String userBrandName = loginUser.getBrandName();
        JTextField idField = new JTextField();
        JLabel brandField = new JLabel(userBrandName);
        JTextField nameField = new JTextField();
        JTextField descriptionField = new JTextField();
        JTextField priceField = new JTextField();
        JLabel imageDisplayLabel = new JLabel();

        JButton addButton = new JButton("추가");
        JButton cancelButton = new JButton("취소");
        JButton attachImageButton = new JButton("이미지 첨부");

        idLabel.setBounds(20, 20, 80, 25);
        idField.setBounds(120, 20, 250, 25);
        brandLabel.setBounds(20, 60, 80, 25);
        brandField.setBounds(120, 60, 250, 25);
        nameLabel.setBounds(20, 100, 80, 25);
        nameField.setBounds(120, 100, 250, 25);
        priceLabel.setBounds(20, 140, 80, 25);
        priceField.setBounds(120, 140, 250, 25);
        imageLabel.setBounds(20, 180, 80, 25);
        imageDisplayLabel.setBounds(120, 180, 250, 25);
        attachImageButton.setBounds(120, 180, 150, 25);
        descriptionLabel.setBounds(20, 220, 80, 25);
        descriptionField.setBounds(120, 220, 250, 25);

        addButton.setBounds(80, 280, 100, 30);
        cancelButton.setBounds(220, 280, 100, 30);

        panel.add(idLabel);
        panel.add(idField);
        panel.add(brandLabel);
        panel.add(brandField);
        panel.add(descriptionLabel);
        panel.add(descriptionField);
        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(priceLabel);
        panel.add(priceField);
        panel.add(addButton);
        panel.add(cancelButton);
        panel.add(imageLabel);
        panel.add(imageDisplayLabel);
        panel.add(attachImageButton);

        addFrame.add(panel);

        final String[] imageName = new String[1];
        // 이미지 첨부 버튼 동작
        attachImageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int result = fileChooser.showOpenDialog(addFrame);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    String imagePath = selectedFile.getAbsolutePath();
                    imageName[0] = "images" + File.separator + selectedFile.getName(); // 파일 이름만 저장
                    System.out.println(imageName[0]);
                    ImageIcon icon = new ImageIcon(imagePath);
                    imageDisplayLabel.setIcon(icon);
                    System.out.println(imagePath);
                }
            }
        });

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = idField.getText();
                String brand = brandField.getText();
                String name = nameField.getText();
                int price;
                try {
                    price = Integer.parseInt(priceField.getText()); // 입력된 가격 문자열을 Int 변환
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(addFrame, "가격 필드엔 숫자만 입력해 주세요", "경고", JOptionPane.WARNING_MESSAGE);
                    return; // 가격이 올바르지 않으면 추가를 중단하고 메소드 종료
                }
                String description = descriptionField.getText();

                if (!id.isEmpty() && !name.isEmpty() && !description.isEmpty()) {
                    try {
                        if (ProductSystem.getInstance().getProductsByID(id) != null) {
                            JOptionPane.showMessageDialog(addFrame, "이미 존재하는 제품ID", "경고", JOptionPane.WARNING_MESSAGE);
                        } else {
                            Product newProduct = new Product(id, name, price, description, imageName[0], brand);
                            ProductSystem.getInstance().registerProduct(newProduct);
                            model.addRow(new Object[]{id, brand, name, price});
                            JOptionPane.showMessageDialog(addFrame, "제품이 추가되었습니다.", "제품 추가", JOptionPane.INFORMATION_MESSAGE);
                            addFrame.dispose();
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(addFrame, "가격 필드엔 숫자만 입력해 주세요", "경고", JOptionPane.WARNING_MESSAGE);
                    }

                } else {
                    JOptionPane.showMessageDialog(addFrame, "모든 필드를 채워주세요.", "경고", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addFrame.dispose();
            }
        });

        addFrame.setLocationRelativeTo(null);
        addFrame.setResizable(false);
        addFrame.setVisible(true);
    }

    public void showModifyProductForm(DefaultTableModel model, int row) {
        JFrame modifyFrame = new JFrame("제품 수정");
        modifyFrame.setSize(400, 230);
        modifyFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel nameLabel = new JLabel("제품 이름:");
        JLabel priceLabel = new JLabel("가격:");
        JLabel descLabel = new JLabel("제품 설명:");

        String productID = model.getValueAt(row, 0).toString();
        JTextField nameField = new JTextField(model.getValueAt(row, 2).toString());
        JTextField priceField = new JTextField(model.getValueAt(row, 3).toString());
        JTextField descField = new JTextField(ProductSystem.getInstance().getProductsByID(productID).getDescription());

        JButton modifyButton = new JButton("수정");
        JButton cancelButton = new JButton("취소");

        nameLabel.setBounds(20, 25, 80, 25);
        nameField.setBounds(120, 25, 250, 25);
        priceLabel.setBounds(20, 55, 80, 25);
        priceField.setBounds(120, 55, 250, 25);
        descLabel.setBounds(20, 85, 80, 25);
        descField.setBounds(120, 85, 250, 25);

        modifyButton.setBounds(80, 130, 100, 30);
        cancelButton.setBounds(220, 130, 100, 30);

        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(priceLabel);
        panel.add(priceField);
        panel.add(descLabel);
        panel.add(descField);
        panel.add(modifyButton);
        panel.add(cancelButton);

        modifyFrame.add(panel);

        modifyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String price = priceField.getText();
                String desc = descField.getText();

                if (!name.isEmpty() && !price.isEmpty()) {
                    try {
                        ProductSystem.getInstance().getProductsByID(productID).updateInfo(name, Integer.parseInt(price), desc);
                        RemoteLoader.getInstance().getRemoteControl().buttonWasPressed(2, "product.txt");

                        model.setValueAt(name, row, 2);
                        model.setValueAt(price, row, 3);
                        JOptionPane.showMessageDialog(modifyFrame, "제품이 수정되었습니다.", "제품 수정", JOptionPane.INFORMATION_MESSAGE);

                        modifyFrame.dispose();
                    } catch (NumberFormatException nfe) {
                        JOptionPane.showMessageDialog(modifyFrame, "필드의 형식을 맞춰주세요", "경고", JOptionPane.WARNING_MESSAGE);

                    }
                } else {
                    JOptionPane.showMessageDialog(modifyFrame, "모든 필드를 채워주세요.", "경고", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modifyFrame.dispose();
            }
        });

        modifyFrame.setLocationRelativeTo(null);
        modifyFrame.setResizable(false);
        modifyFrame.setVisible(true);
    }
}
