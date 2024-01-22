package bankSystem;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import javax.swing.*;

class BalanceEnquiry extends JFrame implements ActionListener {

    JTextField t1, t2;
    JButton b1, b2, b3;
    JLabel l1, l2, l3;
    String pin,Card_num;

    BalanceEnquiry(String Card_num,String pin) {
        this.pin = pin;
        this.Card_num=Card_num;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 760, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0, 0, 900, 760);
        add(l3);

        l1 = new JLabel();
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System", Font.BOLD, 16));

        b1 = new JButton("BACK");

        setLayout(null);

        l1.setBounds(170, 250, 400, 35);
        l3.add(l1);

        b1.setBounds(358,435,150,30);
        l3.add(b1);
        int balance = 0;
        try{
            Connectivity c1 = new Connectivity();
            ResultSet rs = c1.s.executeQuery("select * from bank where Card_num = '"+Card_num+"'");
            while (rs.next()) {
                if (rs.getString("Type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("Ammount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("Ammount"));
                }
            }
        }catch(Exception e){}
        
        l1.setText("Your Current Account Balance is Rs "+balance);

        b1.addActionListener(this);

        setSize(900,760);
        setUndecorated(true);
        setLocation(200,0);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        new Transactions(Card_num,pin).setVisible(true);
        setVisible(false);
    }

    public static void main(String[] args) {
        new BalanceEnquiry("","").setVisible(true);
    }
}
