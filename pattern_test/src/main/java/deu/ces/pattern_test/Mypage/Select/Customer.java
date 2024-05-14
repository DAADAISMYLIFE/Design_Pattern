package deu.ces.pattern_test.Mypage.Select;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author baemijin
 */
public class Customer extends JFrame {
    public Customer() {
        JFrame CustomerFrame = new JFrame("고객_Mypage");
        CustomerFrame.setSize(250, 350);

        JButton Change = new JButton("정보 수정");
        JButton Purchase = new JButton("구매 내역");
        JButton Back = new JButton("뒤로가기");

        // 버튼들을 패널에 추가
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.add(Change);
        panel.add(Purchase);
        panel.add(Back);

        // 각 버튼들의 위치 설정
        Change.setBounds(44, 45, 160, 60);
        Purchase.setBounds(44, 135, 160, 60);
        Back.setBounds(85, 245, 80, 20);
        
        //버튼 동작
        Change.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new deu.ces.pattern_test.Mypage.Change.Customer();
                CustomerFrame.dispose();
            }
        });
        
        Purchase.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new deu.ces.pattern_test.Mypage.PurchaseHistory.Customer();
                CustomerFrame.dispose();
            }
        });

        // 패널을 프레임에 추가
        CustomerFrame.add(panel);

        CustomerFrame.setLocationRelativeTo(null);
        CustomerFrame.setVisible(true);
        CustomerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {
        Customer M = new Customer();
    }
}
