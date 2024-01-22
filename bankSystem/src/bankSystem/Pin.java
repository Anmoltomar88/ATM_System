package bankSystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Pin extends JFrame implements ActionListener {

    JPasswordField t1, t2;
    JButton b1, b2;
    JLabel l1, l2, l3;
    String Pin, Card_num;

    Pin(String Card_num, String Pin) {
        this.Card_num = Card_num;
        this.Pin = Pin;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 760, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l4 = new JLabel(i3);
        l4.setBounds(0, 0, 900, 760);
        add(l4);

        l1 = new JLabel("CHANGE YOUR PIN");
        l1.setFont(new Font("System", Font.BOLD, 20));
        l1.setForeground(Color.WHITE);

        l2 = new JLabel("New PIN:");
        l2.setFont(new Font("System", Font.BOLD, 16));
        l2.setForeground(Color.WHITE);

        l3 = new JLabel("Re-Enter New PIN:");
        l3.setFont(new Font("System", Font.BOLD, 16));
        l3.setForeground(Color.WHITE);

        t1 = new JPasswordField();
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

        t2 = new JPasswordField();
        t2.setFont(new Font("Raleway", Font.BOLD, 25));
        t2.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!((c >= '0') && (c <= '9')
                        || (c == KeyEvent.VK_BACK_SPACE)
                        || (c == KeyEvent.VK_DELETE))) {
                    e.consume();
                }
            }
        });

        b1 = new JButton("CHANGE");
        b2 = new JButton("BACK");

        b1.addActionListener(this);
        b2.addActionListener(this);

        setLayout(null);

        l1.setBounds(250, 280, 700, 35);
        l4.add(l1);

        l2.setBounds(159, 345, 150, 35);
        l4.add(l2);

        l3.setBounds(159, 375, 200, 35);
        l4.add(l3);

        t1.setBounds(337, 345, 180, 25);
        l4.add(t1);

        t2.setBounds(337, 375, 180, 27);
        l4.add(t2);

        b1.setBounds(358, 410, 150, 27);
        l4.add(b1);

        b2.setBounds(358, 440, 150, 23);
        l4.add(b2);

        setSize(900, 760);
        setUndecorated(true);
        setLocation(200, 0);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        try {
            char[] passwordChars1 = t1.getPassword();
            char[] passwordChars2 = t2.getPassword();
            String npin = new String(passwordChars1);
            String rpin = new String(passwordChars2);

            if (!npin.equals(rpin)) {
                JOptionPane.showMessageDialog(null, "Entered PIN does not match");
                return;
            }

            if (ae.getSource() == b1) {
                if (passwordChars1.length == 0) {
                    JOptionPane.showMessageDialog(null, "Enter New PIN");
                }
                if (passwordChars2.length == 0) {
                    JOptionPane.showMessageDialog(null, "Re-Enter new PIN");
                } else {
                    Connectivity c1 = new Connectivity();
                    String q1 = "update bank set Pin_num = '" + rpin + "' where Pin_num = '" + Pin + "' ";
                    String q2 = "update login set Pin_num = '" + rpin + "' where Pin_num = '" + Pin + "' ";
                    String q3 = "update signupThree set Pin_num = '" + rpin + "' where Pin_num = '" + Pin + "' ";

                    c1.s.executeUpdate(q1);
                    c1.s.executeUpdate(q2);
                    c1.s.executeUpdate(q3);

                    JOptionPane.showMessageDialog(null, "PIN changed successfully");
                    setVisible(false);
                    new Transactions(Card_num, rpin).setVisible(true);

                }
            } else if (ae.getSource() == b2) {
                new Transactions(Card_num, rpin).setVisible(true);
                setVisible(false);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Pin("", "").setVisible(true);
    }
}
