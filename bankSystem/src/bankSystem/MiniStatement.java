package bankSystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class MiniStatement extends JFrame implements ActionListener {

    JButton exit;
    JLabel l1, l2, l3, l4;
    String Card_num;
    JTable table;

    MiniStatement(String Card_num) {
        this.Card_num = Card_num;

        getContentPane().setBackground(Color.WHITE);
        setSize(600, 400);
        setLocation(20, 20);

        l1 = new JLabel();
        l1.setBounds(20, 100, 400, 20);
        add(l1);

        l2 = new JLabel("Indian Bank");
        l2.setBounds(250, 20, 100, 20);
        add(l2);

        l3 = new JLabel();
        l3.setBounds(20, 95, 300, 20);
//        l3.setBounds(20, 80, 300, 20);
        add(l3);

        l4 = new JLabel();
        l4.setBounds(20, 320, 300, 20);
        add(l4);

        exit = new JButton("Exit");
        exit.setBounds(20, 350, 100, 25);
        exit.addActionListener(this);
        add(exit);

        // Create columns and data for the JTable
        String[] columns = {"Date", "Type", "Amount"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);
        table = new JTable(model);
        
        table.setBackground(new Color(240, 240, 240));
        table.setForeground(Color.black);
        
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(20, 130, 550, 180);
        add(scrollPane);

        setLayout(null);
        setUndecorated(true);
        setVisible(true);

        try {
            Connectivity c = new Connectivity();
            ResultSet rs = c.s.executeQuery("select * from login where Card_num = '" + Card_num + "'");
            while (rs.next()) {
                l3.setText("Card Number: " + rs.getString("Card_num").substring(0, 4) + "XXXXXXXX" + rs.getString("Card_num").substring(12));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            int balance = 0;
            Connectivity c1 = new Connectivity();
            ResultSet rs = c1.s.executeQuery("SELECT * FROM bank where Card_num = '" + Card_num + "'");
            DefaultTableModel tableModel = (DefaultTableModel) table.getModel();

            while (rs.next()) {
                String date = rs.getString("Date");
                String type = rs.getString("Type");
                String amount = rs.getString("Ammount");

                tableModel.addRow(new Object[]{date, type, amount});

                if (type.equals("Deposit")) {
                    balance += Integer.parseInt(amount);
                } else {
                    balance -= Integer.parseInt(amount);
                }
            }

            l4.setText("Your Total Balance is Rs " + balance);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void actionPerformed(ActionEvent ae) {
        this.setVisible(false);
    }

    public static void main(String[] args) {
        new MiniStatement("");
    }
}
