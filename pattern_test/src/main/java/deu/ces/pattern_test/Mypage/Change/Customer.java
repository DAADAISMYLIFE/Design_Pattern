/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deu.ces.pattern_test.Mypage.Change;
/**
 *
 * @author baemijin
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Customer extends JFrame {
    public Customer() {
        JFrame CustomerFrame = new JFrame();
        CustomerFrame.setTitle("고객_정보 수정");
        CustomerFrame.setSize(250, 350);
        CustomerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null); // Null layout 사용

        JLabel id = new JLabel("ID");
        JLabel pw = new JLabel("Password");
        JLabel name = new JLabel("Name");

        JTextField idField = new JTextField();
        JTextField pwField = new JTextField();
        JTextField nameField = new JTextField();

        JButton change = new JButton("수정");
        JButton cancel = new JButton("취소");

        // 컴포넌트의 위치와 크기 설정
        id.setBounds(30, 55, 80, 30);
        idField.setBounds(125, 55, 105, 30);
        pw.setBounds(30, 95, 80, 30);
        pwField.setBounds(125, 95, 105, 30);
        name.setBounds(30, 135, 80, 30);
        nameField.setBounds(125, 135, 105, 30);
        change.setBounds(30, 230, 90, 35);
        cancel.setBounds(130, 230, 90, 35);

        // 컴포넌트를 패널에 추가
        panel.add(id);
        panel.add(idField);
        panel.add(pw);
        panel.add(pwField);
        panel.add(name);
        panel.add(nameField);
        panel.add(change);
        panel.add(cancel);

        // 패널을 프레임에 추가
        CustomerFrame.add(panel);

        //버튼 동작
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new deu.ces.pattern_test.Mypage.Select.Customer();
                CustomerFrame.dispose();
            }
        });
        
        CustomerFrame.setLocationRelativeTo(null);
        CustomerFrame.setResizable(false);
        CustomerFrame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Customer();
        });
    }
}
