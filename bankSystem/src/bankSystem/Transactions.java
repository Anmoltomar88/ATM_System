package bankSystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
// import java.sql.*;

public class Transactions extends JFrame implements ActionListener {

    JLabel l1;
    JButton b1, b2, b3, b4, b5, b6, b7, b8;
    String Pin;
    String Card_num;

    Transactions(String Card_num, String Pin) {
        this.Card_num = Card_num;
        this.Pin = Pin;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l2 = new JLabel(i3);
        l2.setBounds(0, 0, 900, 900);
        add(l2);

        l1 = new JLabel("Please Select Your Transaction");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System", Font.BOLD, 16));

        b1 = new JButton("DEPOSIT");
        b2 = new JButton("CASH WITHDRAWL");
        b3 = new JButton("FAST CASH");
        b4 = new JButton("MINI STATEMENT");
        b5 = new JButton("PIN CHANGE");
        b6 = new JButton("BALANCE ENQUIRY");
        b7 = new JButton("EXIT");

        setLayout(null);

        l1.setBounds(225, 310, 700, 35);
        l2.add(l1);

        b1.setBounds(159, 417, 150, 28);
        l2.add(b1);

        b2.setBounds(364, 417, 150, 28);
        l2.add(b2);

        b3.setBounds(159, 452, 150, 28);
        l2.add(b3);

        b4.setBounds(364, 452, 150, 28);
        l2.add(b4);

        b5.setBounds(159, 489, 150, 28);
        l2.add(b5);

        b6.setBounds(364, 489, 150, 28);
        l2.add(b6);

        b7.setBounds(364, 523, 150, 28);
        l2.add(b7);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);

        b8 = new JButton("Login");
        b8.setBounds(159, 523, 150, 28);
        b8.addActionListener(this);
        add(b8);

        setSize(900, 900);
        setLocation(200, 0);
        setUndecorated(true);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {
            new Deposit(Card_num, Pin).setVisible(true);
            setVisible(false);
        } else if (ae.getSource() == b2) {
            new Withdrawl(Card_num, Pin).setVisible(true);
            setVisible(false);
        } else if (ae.getSource() == b3) {
            new FastCash(Card_num, Pin).setVisible(true);
            setVisible(false);
        } else if (ae.getSource() == b4) {
            new MiniStatement(Card_num).setVisible(true);
        } else if (ae.getSource() == b5) {
            new Pin(Card_num, Pin).setVisible(true);
            setVisible(false);
        } else if (ae.getSource() == b6) {
            new BalanceEnquiry(Card_num, Pin).setVisible(true);
            setVisible(false);
        } else if (ae.getSource() == b7) {
            System.exit(0);
        } else if (ae.getSource() == b8) {
            new Login().setVisible(true);
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Transactions("","");
    }
}
