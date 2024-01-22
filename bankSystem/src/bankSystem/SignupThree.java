package bankSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class SignupThree extends JFrame implements ActionListener{
    JTextField pint;
    JLabel h1,card,number,pin,pind;
    JCheckBox a1, a2, a3, a4,s1,s2,s3,s4,s5,s6,d1;
    JButton b1,b2;
    String formno;
    

    public SignupThree(String formno) {
        this.formno=formno;
        setTitle("Form_No.3");
        setLayout(null);
        setBounds(300, 30, 800, 720);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.DARK_GRAY);

        JLabel detail = new JLabel("<html><u><b>Page 3: Account Detail</b></u></html>");
        detail.setFont(new Font("Raleway", Font.BOLD, 35));
        detail.setBounds(220, 35, 500, 50);
        detail.setForeground(Color.WHITE);
        add(detail);
        //account type
        h1 = new JLabel("<html><u> Account Type</u></html>");
        h1.setForeground(Color.WHITE);
        h1.setFont(new Font("Raleway", Font.BOLD, 24));
        h1.setBounds(300, 100, 200, 30);
        add(h1);
        a1 = new JCheckBox("Savings Account");
        a1.setBounds(200, 150, 200, 30);
        a1.setBackground(Color.DARK_GRAY);
        a1.setForeground(Color.WHITE);
        add(a1);
        a2 = new JCheckBox("Fixed Deposit Account");
        a2.setBounds(400, 150, 200, 30);
        a2.setBackground(Color.DARK_GRAY);
        a2.setForeground(Color.WHITE);
        add(a2);
        a3 = new JCheckBox("Current Account");
        a3.setBounds(200, 190, 200, 30);
        a3.setBackground(Color.DARK_GRAY);
        a3.setForeground(Color.WHITE);
        add(a3);
        a4 = new JCheckBox("Recurring Deposit Account");
        a4.setBounds(400, 190, 250, 30);
        a4.setBackground(Color.DARK_GRAY);
        a4.setForeground(Color.WHITE);
        add(a4);
        ButtonGroup accountTypeGroup = new ButtonGroup();
        accountTypeGroup.add(a1);
        accountTypeGroup.add(a2);
        accountTypeGroup.add(a3);
        accountTypeGroup.add(a4);
        //card no
        card = new JLabel("Card Number:");
        card.setForeground(Color.WHITE);
        card.setFont(new Font("Raleway", Font.BOLD, 20));
        card.setBounds(170, 240, 200, 30);
        add(card);
        //number
        number = new JLabel("XXXX-XXXX-XXXX-0000");
        number.setForeground(Color.WHITE);
        number.setFont(new Font("Raleway", Font.BOLD, 20));
        number.setBounds(400, 240, 300, 30);
        add(number);
        JLabel cardd = new JLabel("Your 16 Digit Card Number");
        cardd.setForeground(new Color(133, 188, 199));
        cardd.setFont(new Font("Raleway", Font.BOLD, 12));
        cardd.setBounds(170, 260, 400, 30);
        add(cardd);
        //pin no
        pin = new JLabel("Pin Number:");
        pin.setForeground(Color.WHITE);
        pin.setFont(new Font("Raleway", Font.BOLD, 20));
        pin.setBounds(170, 290, 200, 30);
        add(pin);
        pint=new JTextField();
        pint.setBounds(400, 290, 170, 20);
        pint.setBackground(Color.WHITE);
        pint.setForeground(Color.DARK_GRAY);
                pint.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!((c >= '0') && (c <= '9') ||
                        (c == KeyEvent.VK_BACK_SPACE) ||
                        (c == KeyEvent.VK_DELETE))) {
                    e.consume();
                }
            }
        });
        add(pint);
        // pint.setBounds(, ABORT, WIDTH, HEIGHT);
        JLabel pindd = new JLabel("Your 4 Digit Pin : XXXX");
        pindd.setForeground(new Color(133, 188, 199));
        pindd.setFont(new Font("Raleway", Font.BOLD, 12));
        pindd.setBounds(170, 320, 400, 30);
        add(pindd);
        //services
        JLabel services = new JLabel("<html><u>Services Required</u></html>");
        services.setForeground(Color.WHITE);
        services.setFont(new Font("Raleway", Font.BOLD, 24));
        services.setBounds(290, 370, 300, 30);
        add(services);
        s1 = new JCheckBox("ATM CARD");
        s1.setBounds(200, 410, 200, 30);
        s1.setBackground(Color.DARK_GRAY);
        s1.setForeground(Color.WHITE);
        add(s1);
        s2 = new JCheckBox("Internet Net Banking");
        s2.setBounds(400, 410, 200, 30);
        s2.setBackground(Color.DARK_GRAY);
        s2.setForeground(Color.WHITE);
        add(s2);
        s3 = new JCheckBox("Mobile Banking");
        s3.setBounds(200, 440, 200, 30);
        s3.setBackground(Color.DARK_GRAY);
        s3.setForeground(Color.WHITE);
        add(s3);
        s4 = new JCheckBox("Email & SMS Alerts");
        s4.setBounds(400, 440, 250, 30);
        s4.setBackground(Color.DARK_GRAY);
        s4.setForeground(Color.WHITE);
        add(s4);
        s5 = new JCheckBox("Cheque Book");
        s5.setBounds(200, 470, 200, 30);
        s5.setBackground(Color.DARK_GRAY);
        s5.setForeground(Color.WHITE);
        add(s5);
        s6 = new JCheckBox("E-Statement");
        s6.setBounds(400, 470, 250, 30);
        s6.setBackground(Color.DARK_GRAY);
        s6.setForeground(Color.WHITE);
        add(s6);
        //declaration terms and condition
        d1 = new JCheckBox("I hereby declare that all the above details are correct to the best of my knowlwdge.");
        d1.setBounds(100, 530, 620, 30);
        d1.setFont(new Font("Raleway",Font.BOLD,14));
        d1.setBackground(new Color(133, 188, 199));
        d1.setForeground(Color.WHITE);
        add(d1);
        //submit and cancel button 
        b1=new JButton("Submit");
        b1.setBackground(Color.WHITE);
        b1.setForeground(Color.DARK_GRAY);
        b1.setBounds(200, 590, 90, 30);
        b1.addActionListener(this);
        add(b1);

        b2=new JButton("Cancel");
        b2.setBackground(Color.WHITE);
        b2.setForeground(Color.DARK_GRAY);
        b2.setBounds(400, 590, 90, 30);
        b2.addActionListener(this);
        add(b2);        
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        //card number
        Random random=new Random();
        String Card_num=""+Math.abs((random.nextLong()%90000000L)+8750153700000000L);
        String Pin=pint.getText();
        if (ae.getSource()==b1) {
            String Account_type=null;
            if(a1.isSelected()){
                Account_type="Saving Account";
            }if(a2.isSelected()){
                Account_type="Fixed Deposit Account";
            }if(a3.isSelected()){
                Account_type="Current Account";
            }if(a4.isSelected()){
                Account_type="Recurring Deposit Account";
            }
            String Services_Req=" "+" ";
            if(s1.isSelected()){
                Services_Req=Services_Req+"ATM CARD";
            }if(s2.isSelected()){
                Services_Req=Services_Req+"Internet Net Banking";
            }if(s3.isSelected()){
                Services_Req=Services_Req+"Mobile Banking";
            }if(s4.isSelected()){
                Services_Req=Services_Req+"Email & SMS Alerts";
            }if(s5.isSelected()){
                Services_Req=Services_Req+"Cheque Book";
            }if(s6.isSelected()){
                Services_Req=Services_Req+"E-Statement";
            }
            try {
                if(!d1.isSelected()) {
                    JOptionPane.showMessageDialog(SignupThree.this, "Please agree to the terms and conditions.");
                    return;
                }
                else{
                    Connectivity c=new Connectivity();
                String query = "INSERT INTO signupThree (Form_no, Card_num, Pin_num, Account_type, Services_Req) " +
               "VALUES ('" + formno + "', '" + Card_num + "', '" + Pin + "', '" + Account_type + "', '" + Services_Req + "')";
               String query2 = "INSERT INTO Login (Form_no, Card_num, Pin_num) " +
               "VALUES ('" + formno + "', '" + Card_num + "', '" + Pin + "')";
               c.s.executeUpdate(query);
               c.s.executeUpdate(query2);
               JOptionPane.showMessageDialog(null, "Card number: " + Card_num, "Card Number", JOptionPane.INFORMATION_MESSAGE);
               new Login().setVisible(true);
               setVisible(false);
                }
            }catch (Exception e) {
                System.out.println(e);
            }           
        }else if(ae.getSource()==b2) {
            System.exit(0);
        }
    }
    public static void main(String[] args) {
        new SignupThree("");
    }
}
