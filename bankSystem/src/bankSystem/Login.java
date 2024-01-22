package bankSystem;

import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.Image;//Image class 
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.*;

class Login extends JFrame implements ActionListener{ 
    ImageIcon getimage,getimage2;
    JLabel pasteimage,text,card,pin;
    Image imagesize; 
    JTextField cardTf;
    JTextField pinTf;
    JButton login,clear,signup ;
    Font font=new Font("Osward", Font.PLAIN,18);
    private JButton exit;

    Login(){    
        setLayout(null);
        setUndecorated(true);
        // define frame
        setTitle("Anmol ki Machine");
        setSize(800,500);
        setLocation(275,190);
        //frame color
        getContentPane().setBackground(Color.DARK_GRAY);
   
        //icons or image
        getimage=new ImageIcon(ClassLoader.getSystemResource("Icons/th.jpeg"));
        imagesize=getimage.getImage().getScaledInstance(140, 140, DO_NOTHING_ON_CLOSE);
        getimage2=new ImageIcon(imagesize);
        pasteimage=new JLabel(getimage2);
        pasteimage.setBounds(25, 60, 140, 140);
        add(pasteimage);
  
        //write 
        text=new JLabel("Welcome to ATM");
        text.setFont(new Font("Osward",Font.BOLD | Font.ITALIC | Font.CENTER_BASELINE, 38));
        text.setForeground(Color.WHITE);
        text.setBounds(250, 40, 400, 40);
        add(text);

        card=new JLabel("Card no");
        card.setFont(font);
        card.setForeground(Color.WHITE);       
        card.setBounds(250, 80, 100, 100);
        add(card);
        
        cardTf=new JTextField();
        cardTf.setBounds(350, 118, 250, 30);
        cardTf.setFont(font);
        cardTf.setForeground(Color.black);
        cardTf.setBackground(Color.lightGray);
        cardTf.setBorder(BorderFactory.createEmptyBorder());
        add(cardTf);

        pin=new JLabel("Pin");
        pin.setFont(new Font("Osward", Font.BOLD,18));
        pin.setForeground(Color.WHITE);
        pin.setBounds(250, 144, 100, 100);
        add(pin);

        pinTf=new JPasswordField();
        pinTf.setBounds(350, 180, 250, 30);
        pinTf.setFont(new Font("Osward", Font.PLAIN,20));
        // pinTf.setBorder(new LineBorder(Color.blue,2, true));
        pinTf.setBackground(Color.LIGHT_GRAY);
        pinTf.setForeground(Color.BLACK);
        pinTf.setBorder(BorderFactory.createEmptyBorder());
        pinTf.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!((c >= '0') && (c <= '9') ||
                      (c == KeyEvent.VK_BACK_SPACE) ||
                      (c == KeyEvent.VK_DELETE))) {
                    e.consume();
                }
            }
        });
        add(pinTf);
        
        //Buttons
        login=new JButton("Sign in");
        login.setBounds(350, 250, 100, 30);
        login.setBackground(Color.WHITE);
        login.setForeground(Color.DARK_GRAY);
        login.setBorder(new LineBorder(new Color(133, 188, 199)));
        login.addActionListener(this);
        add(login);

        clear=new JButton("Clear");
        clear.setBounds(500, 250, 100, 30);
        clear.setBackground(Color.WHITE);
        clear.setForeground(Color.DARK_GRAY);
        clear.setBorder(new LineBorder(new Color(133,188,199)));
        clear.addActionListener(this);
        add(clear);

        signup=new JButton("Sign up");
        signup.setBounds(350, 310, 100, 30);
        signup.setBackground(Color.WHITE);
        signup.setForeground(Color.DARK_GRAY);
        signup.setBorder(new LineBorder(new Color(133, 188, 199)));
        signup.addActionListener(this);
        add(signup);      
        
        exit=new JButton("Exit");
        exit.setBounds(500, 310, 100, 30);
        exit.setBackground(Color.WHITE);
        exit.setForeground(Color.DARK_GRAY);
        exit.setBorder(new LineBorder(new Color(133, 188, 199)));
        exit.addActionListener(this);
        add(exit); 

        setVisible(true); 
    }
   public static void main(String[] args) {
    new Login();
   }
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()== clear){
            cardTf.setText("");
            pinTf.setText("");
        }else if (ae.getSource()==login) {
            Connectivity c = new Connectivity();
            String Card_num  = cardTf.getText();
            String Pin  = pinTf.getText();
            String query  = "select * from Login where Card_num = '"+Card_num+"' and Pin_num = '"+Pin+"'";
            try { 
                ResultSet rs = c.s.executeQuery(query);
                if(rs.next()){
                System.out.println("Login successful");
                new Transactions(Card_num,Pin).setVisible(true);
                setVisible(false);
                }else{
                JOptionPane.showMessageDialog(null, "Login failed. Incorrect card number or pin.","Error",JOptionPane.INFORMATION_MESSAGE);
                }         
                }catch (SQLException e) {
                e.printStackTrace();
                }
        }else if(ae.getSource()==signup){
            new Signup().setVisible(true);
            setVisible(false);
        }else if(ae.getSource()==exit){
            System.exit(0);
        }
    }
}
