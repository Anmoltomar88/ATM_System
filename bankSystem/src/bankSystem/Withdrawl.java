package bankSystem;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import javax.swing.*;
import java.util.Date;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Withdrawl extends JFrame implements ActionListener {

    JTextField t1, t2;
    JButton b1, b2, b3;
    JLabel l1, l2, l3, l4;
    String Pin;
    String Card_num;

    Withdrawl(String Card_num, String Pin) {
        this.Pin = Pin;
        this.Card_num = Card_num;
        setSize(900, 760);
        setUndecorated(true);
        setLocation(200, 0);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 760, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0, 0, 900, 760);
        add(l3);

        l1 = new JLabel("Withdrawl Available in 100rs and 500rs");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System", Font.BOLD, 16));

        l2 = new JLabel("PLEASE ENTER YOUR AmMOUNT");
        l2.setForeground(Color.WHITE);
        l2.setFont(new Font("System", Font.BOLD, 16));

        t1 = new JTextField();
        t1.setFont(new Font("Raleway", Font.BOLD, 25));
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

        b1 = new JButton("WITHDRAW");
        b2 = new JButton("BACK");

        setLayout(null);

        l1.setBounds(170, 260, 400, 20);
        l3.add(l1);

        l2.setBounds(195, 310, 400, 20);
        l3.add(l2);

        t1.setBounds(170, 352, 330, 30);
        l3.add(t1);

        b1.setBounds(358, 400, 150, 30);
        l3.add(b1);

        b2.setBounds(358, 435, 150, 30);
        l3.add(b2);

        b1.addActionListener(this);
        b2.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b2) {
            new Transactions(Card_num, Pin).setVisible(true);
            setVisible(false);
        } else {
            String Ammount = t1.getText();
            Date Date = new Date();
            try {
                if (t1.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Please enter the Amount to you want to Withdraw");
                } else {
                    Connectivity c = new Connectivity();
                    ResultSet rs = c.s.executeQuery("select * from Bank where Card_num = '" + Card_num + "'");
                    int balance = 0;
                    while (rs.next()) {
                        if (rs.getString("Type").equals("Deposit")) {
                            balance += Integer.parseInt(rs.getString("Ammount"));
                        } else {
                            balance -= Integer.parseInt(rs.getString("Ammount"));
                        }
                    }
                    if (ae.getSource() != b2 && balance < Integer.parseInt(Ammount)) {
                        JOptionPane.showMessageDialog(null, "Insuffient Balance");
                        return;
                    } else {
                        c.s.executeUpdate("insert into Bank values('" + Card_num + "','" + Pin + "', '" + Date + "', 'Withdrawl', '" + Ammount + "')");
                        JOptionPane.showMessageDialog(null, "Rs. " + Ammount + " Debited Successfully", "Withdrawl", JOptionPane.INFORMATION_MESSAGE);
                        new Transactions(Card_num, Pin).setVisible(true);
                        setVisible(false);
                    }
                    new Transactions(Card_num, Pin).setVisible(true);
                    setVisible(false);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
        new Withdrawl("", "").setVisible(true);
    }
}
