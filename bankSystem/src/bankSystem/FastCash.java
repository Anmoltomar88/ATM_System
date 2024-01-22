package bankSystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {

        JLabel l1, l2;
        JButton b1, b2, b3, b4, b5, b6, b7;
        JTextField t1;
        String Pin,Card_num;

        public FastCash(String Card_num,String pin) {
            this.Card_num=Card_num;
            this.Pin = pin;
            ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/atm.jpg"));
            Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
            ImageIcon i3 = new ImageIcon(i2);
            JLabel l2 = new JLabel(i3);
            l2.setBounds(0, 0, 900, 900);
            add(l2);

            l1 = new JLabel("SELECT WITHDRAWL AMOUNT");
            l1.setForeground(Color.WHITE);
            l1.setFont(new Font("System", Font.BOLD, 16));

        b1 = new JButton("Rs 100");
        b2 = new JButton("Rs 500");
        b3 = new JButton("Rs 1000");
        b4 = new JButton("Rs 2000");
        b5 = new JButton("Rs 5000");
        b6 = new JButton("Rs 10000");
        b7 = new JButton("BACK");

        setLayout(null);

        l1.setBounds(225,310,700,35);
        l2.add(l1);
        
        b1.setBounds(159,417,150,28);
        l2.add(b1);
        
        b2.setBounds(364,417,150,28);
        l2.add(b2);
        
        b3.setBounds(159,452,150,28);
        l2.add(b3);
        
        b4.setBounds(364,452,150,28);
        l2.add(b4);
        
        b5.setBounds(159,489,150,28);
        l2.add(b5);
        
        b6.setBounds(364,489,150,28);
        l2.add(b6);
        
        b7.setBounds(364,523,150,28);
        l2.add(b7);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);

        setSize(900,900);
        setLocation(200,0);
        setUndecorated(true);
        setVisible(true);

    }
        public static void main(String[] args) {
            new FastCash("","").setVisible(true);
            }

        public void actionPerformed(ActionEvent ae) {
            if(ae.getSource() == b7){
                new Transactions(Card_num,Pin).setVisible(true);
                setVisible(false);
                }else{
                    String Ammount = ((JButton)ae.getSource()).getText().substring(3); //k
                    Connectivity c = new Connectivity();
                    try {
                        ResultSet rs = c.s.executeQuery("select * from Bank where Card_num = '"+Card_num+"'");
                        int balance = 0;
                        while(rs.next()) {
                            if(rs.getString("Type").equals("Deposit")) {
                                balance += Integer.parseInt(rs.getString("Ammount"));
                            } else {
                                balance -= Integer.parseInt(rs.getString("Ammount"));
                            }
                        }if(ae.getSource()!= b7 && balance < Integer.parseInt(Ammount)) {
                            JOptionPane.showMessageDialog(null, "Insuffient Balance");
                            return;
                        }else{
                            Date Date = new Date();
                            c.s.executeUpdate("insert into Bank values('"+Card_num+"','"+Pin+"', '"+Date+"', 'Withdrawl', '"+Ammount+"')");
                            JOptionPane.showMessageDialog(null, "Rs. "+Ammount+" Debited Successfully","Fast Cash",JOptionPane.INFORMATION_MESSAGE);
                            new Transactions(Card_num,Pin).setVisible(true);
                            setVisible(false);
                        }   
                    } catch (Exception e) {
                        e.printStackTrace();
                        }                    
                    }
                }
    } 