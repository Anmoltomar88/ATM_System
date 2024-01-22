package bankSystem;

import java.awt.*;
import java.awt.event.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;
import java.util.*;

public class Deposit extends JFrame implements ActionListener {

    JTextField t1, t2;
    JButton b1, b2, b3;
    JLabel l1, l2;
    String Pin;
    String Card_num;

    Deposit(String Card_num, String Pin) {
        this.Card_num = Card_num;
        this.Pin = Pin;
        setSize(900, 760);
        setUndecorated(true);
        setLocation(200, 0);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 760, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l2 = new JLabel(i3);
        l2.setBounds(0, 0, 900, 760);
        add(l2);

        l1 = new JLabel("ENTER AMOUNT YOU WANT TO DEPOSIT");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System", Font.BOLD, 16));

        t1 = new JTextField();
        t1.setFont(new Font("System", Font.BOLD, 16));
        t1.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!((c >= '0') && (c <= '9')
                        || (c == KeyEvent.VK_BACK_SPACE)
                        || (c == KeyEvent.VK_DELETE))) {
                    e.consume();
                }
            }
        });

        b1 = new JButton("DEPOSIT");
        b2 = new JButton("BACK");

        setLayout(null);

        l1.setBounds(170, 260, 400, 35);
        l2.add(l1);

        t1.setBounds(170, 300, 320, 25);
        l2.add(t1);

        b1.setBounds(358, 400, 150, 30);
        l2.add(b1);

        b2.setBounds(358, 435, 150, 30);
        l2.add(b2);

        b1.addActionListener(this);
        b2.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        try {
            String Ammount = t1.getText();
            Date Date = new Date();
            if (ae.getSource() == b1) {
                if (t1.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Please enter the Amount to you want to Deposit");
                } else {
                    Connectivity c = new Connectivity();
                    c.s.executeUpdate("insert into Bank values('" + Card_num + "','" + Pin + "', '" + Date + "', 'Deposit', '" + Ammount + "')");
                    JOptionPane.showMessageDialog(null, "Rs. " + Ammount + " Deposited Successfully");
                    new Transactions(Card_num, Pin).setVisible(true);
                    setVisible(false);
                }
            } else if (ae.getSource() == b2) {
                new Transactions(Card_num, Pin).setVisible(true);
                setVisible(false);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new Deposit("", "");
    }
}
