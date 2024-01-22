package bankSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class SignupTwo extends JFrame implements ActionListener{
    JLabel religion, category, income, eduQuali, occupation, panc, aadharc, senCit, existAcc;
    JRadioButton b1, b2,b3,b4;
    JComboBox<String> rel,cat,inc,edu,occ;
    JTextField pan, aadhar;
    JButton next;
    //primary key
    String formno;

    public SignupTwo(String formno) {
        this.formno=formno;//ptimary key
        //frame color
        getContentPane().setBackground(Color.DARK_GRAY);

        // Frame settings
        setLayout(null);
        setTitle("Form no.2");
        // setSize(800, 720);
        // setLocation(300, 30);
        setBounds(300,30,800,720);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // JLabels
        JLabel detail=new JLabel("Page 2 : Additional details");
        detail.setFont(new Font("Raleway", Font.BOLD, 30));
        detail.setBounds(260,40, 500,50);
        detail.setForeground(Color.WHITE);
        add(detail);

        //religion
        religion = new JLabel("Religion:");
        religion.setForeground(Color.WHITE);
        religion.setFont(new Font("Raleway", Font.BOLD, 20));
        religion.setBounds(100,140, 100,30); // Adjust the bounds as needed
        add(religion);
        // String[] regv={"Hindu","Muslim","Sikh","Christian","Others"};
        // rel=new JComboBox<>();
        rel = new JComboBox<>(new String[]{"Hindu", "Muslim", "Sikh", "Christian", "Others"});
        rel.setBounds(300,140,400,30);
        rel.setBackground(new Color(133, 188, 199));
        add(rel);

        //category
        category = new JLabel("Category:");
        category.setForeground(Color.WHITE);
        category.setFont(new Font("Raleway", Font.BOLD, 20));
        category.setBounds(100,190, 200,30); // Adjust the bounds as needed
        add(category);
        cat = new JComboBox<>(new String[]{"General","OBC","SC/ST","Minorities"});
        cat.setBounds(300,190,400,30);
        cat.setBackground(new Color(133, 188, 199));
        add(cat);

        //income
        income = new JLabel("Income:");
        income.setForeground(Color.WHITE);
        income.setFont(new Font("Raleway", Font.BOLD, 20));
        income.setBounds(100,240, 200,30); // Adjust the bounds as needed
        add(income);
        inc = new JComboBox<>(new String[]{"Null","<1,50,000","<2,50,000","<5,00,000","upto 10,00,000"});
        inc.setBounds(300,240,400,30);
        inc.setBackground(new Color(133, 188, 199));
        add(inc);

        //eduQualification
        eduQuali = new JLabel("Education:");
        eduQuali.setForeground(Color.WHITE);
        eduQuali.setFont(new Font("Raleway", Font.BOLD, 20));
        eduQuali.setBounds(100,290, 200,30); // Adjust the bounds as needed
        add(eduQuali);
        edu = new JComboBox<>(new String[]{"High School","Intermediate","Under Graduate","Post Graduate","Others"});
        edu.setBounds(300,290,400,30);
        edu.setBackground(new Color(133, 188, 199));
        add(edu);

        //occupation
        occupation = new JLabel("Occupation:");
        occupation.setForeground(Color.WHITE);
        occupation.setFont(new Font("Raleway", Font.BOLD, 20));
        occupation.setBounds(100, 340, 200, 30); // Adjust the bounds as needed
        add(occupation);

        occ = new JComboBox<>(new String[]{"UnEmployeed","Job","Self-Employeed","Buisness-Man","Others"});
        occ.setBounds(300,340,400,30);
        occ.setBackground(new Color(133, 188, 199));
        add(occ);

        //panc
        panc = new JLabel("Pan Card:");
        panc.setForeground(Color.WHITE);
        panc.setFont(new Font("Raleway", Font.BOLD, 20));
        panc.setBounds(100, 390, 200, 30); // Adjust the bounds as needed
        add(panc);

        pan=new JTextField();
        pan.setFont(new Font("Reliway",Font.BOLD, 14));
        pan.setBounds(300, 390, 400, 30);
        add(pan);

        //aadharc
        aadharc = new JLabel("Aadhar No:");
        aadharc.setForeground(Color.WHITE);
        aadharc.setFont(new Font("Raleway", Font.BOLD, 20));
        aadharc.setBounds(100, 440, 200, 30); // Adjust the bounds as needed
        add(aadharc);

        aadhar=new JTextField();
        aadhar.setFont(new Font("Reliway",Font.BOLD, 14));
        aadhar.setBounds(300, 440, 400, 30);
        aadhar.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!((c >= '0') && (c <= '9') ||
                      (c == KeyEvent.VK_BACK_SPACE) ||
                      (c == KeyEvent.VK_DELETE))) {
                    e.consume();
                }
            }
        });
        add(aadhar);

        //senCit
        senCit = new JLabel("Senior Citizen:");
        senCit.setForeground(Color.WHITE);
        senCit.setFont(new Font("Raleway", Font.BOLD, 20));
        senCit.setBounds(100, 490, 200, 30); // Adjust the bounds as needed
        add(senCit);

        b1=new JRadioButton("Yes");
        b1.setBackground(Color.DARK_GRAY);
        b1.setForeground(Color.white);
        b1.setBounds(300, 490, 90, 30);
        add(b1);

        b2=new JRadioButton("No");
        b2.setBackground(Color.DARK_GRAY);
        b2.setForeground(Color.white);
        b2.setBounds(450, 490, 90, 30);
        add(b2);

        ButtonGroup buttongrp=new ButtonGroup();
        buttongrp.add(b1);
        buttongrp.add(b2);

        //existAcc
        existAcc = new JLabel("Existing-Account:");
        existAcc.setForeground(Color.WHITE);
        existAcc.setFont(new Font("Raleway", Font.BOLD, 20));
        existAcc.setBounds(100, 540, 200, 30); // Adjust the bounds as needed
        add(existAcc);

        b3=new JRadioButton("Yes");
        b3.setBackground(Color.DARK_GRAY);
        b3.setForeground(Color.white);
        b3.setBounds(300, 540, 90, 30);
        add(b3);

        b4=new JRadioButton("No");
        b4.setBackground(Color.DARK_GRAY);
        b4.setForeground(Color.white);
        b4.setBounds(450, 540, 90, 30);
        add(b4);

        ButtonGroup buttongrp2=new ButtonGroup();
        buttongrp2.add(b3);
        buttongrp2.add(b4);
        //next
        next=new JButton("Next");
        next.setBackground(new Color(133, 188, 199));
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Railway", Font.BOLD, 14));
        next.setBounds(620,590,80,30);
        next.addActionListener(this);
        add(next); 
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        String Religion=(String)rel.getSelectedItem();
        String Category=(String)cat.getSelectedItem();
        String Income=(String)inc.getSelectedItem();
        String Education_QF=(String)edu.getSelectedItem();
        String Occupation=(String)occ.getSelectedItem();
        String Aadhar_No=aadhar.getText();
        String Pan_Card=pan.getText();
        String Senior_cit=null;
        if(b1.isSelected()){
            Senior_cit="Yes";
        }else if(b2.isSelected()){
            Senior_cit="No";
        }
        String Existing_Acc=null;
        if(b3.isSelected()){
            Existing_Acc="Yes";
        }else if(b4.isSelected()){
            Existing_Acc="No";
        }
        //sql
        try {
            Connectivity c= new Connectivity();
            String query2 = "INSERT INTO signupTwo (Form_no , Religion, Category, Income, Education_QF, Occupation, Senior_cit, Existing_Acc, Aadhar_No, Pan_Card) VALUES ('" + formno + "','" + Religion + "','" + Category + "','" + Income + "','" + Education_QF + "','" + Occupation + "','" + Senior_cit + "','" + Existing_Acc + "','" + Aadhar_No + "','" + Pan_Card + "')";
            c.s.executeUpdate(query2);
            new SignupThree(formno).setVisible(true);
            setVisible(false);
        }catch (Exception e) {
            System.out.println(e);
        }       
    }
    public static void main(String[] args) {
        new SignupTwo("");
    }
}
