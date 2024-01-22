package bankSystem;

import java.util.Random;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import com.toedter.calendar.JDateChooser;
// Libraries\jcalendar-tz-1.3.3-4.jar

public class Signup extends JFrame implements ActionListener {
    Random random;
    long n;
    Font font = new Font("Reliway", Font.BOLD, 14);
    JTextField nam, panam, ename, addtf, cit, stat, pint;
    JRadioButton b1, b2, b3, b4, b5, b6;
    ButtonGroup bGroup, bGroup2;
    JButton next;
    JDateChooser date;
    String Form_no;

    public Signup() {
        random = new Random();
        n = random.nextInt(8999) + 1000;
        // to use setbound
        setLayout(null);

        // frame define
        setSize(850, 730);
        setLocation(250, 5);
        setVisible(true);

        // frame color
        getContentPane().setBackground(Color.DARK_GRAY);

        // label
        JLabel formNumber = new JLabel("Application number" + " : " + n);
        formNumber.setFont(new Font("Raleway", Font.BOLD, 38));
        formNumber.setBounds(145, 20, 500, 50);
        formNumber.setForeground(Color.WHITE);
        add(formNumber);

        JLabel detail = new JLabel("Page 1 : Personal details");
        detail.setFont(new Font("Raleway", Font.BOLD, 22));
        detail.setBounds(290, 80, 500, 50);
        detail.setForeground(Color.WHITE);
        add(detail);

        JLabel name = new JLabel("Name:");
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setBounds(100, 140, 100, 30);
        name.setForeground(Color.WHITE);
        add(name);
        // name
        nam = new JTextField();
        nam.setFont(font);
        nam.setBounds(300, 140, 400, 30);
        add(nam);

        JLabel fname = new JLabel("Father's Name:");
        fname.setFont(new Font("Raleway", Font.BOLD, 20));
        fname.setBounds(100, 190, 200, 30);
        fname.setForeground(Color.WHITE);
        add(fname);
        // name
        panam = new JTextField();
        panam.setFont(font);
        panam.setBounds(300, 190, 400, 30);
        add(panam);

        JLabel dob = new JLabel("Date Of Birth:");
        dob.setFont(new Font("Raleway", Font.BOLD, 20));
        dob.setBounds(100, 240, 200, 30);
        dob.setForeground(Color.WHITE);
        add(dob);
        // jarfile for calander dob
        date = new JDateChooser();
        date.setBounds(300, 240, 400, 30);
        add(date);

        JLabel gender = new JLabel("Gender:");
        gender.setFont(new Font("Raleway", Font.BOLD, 20));
        gender.setBounds(100, 290, 200, 30);
        gender.setForeground(Color.WHITE);
        add(gender);
        // button gender
        b1 = new JRadioButton("MALE");
        b1.setBackground(Color.DARK_GRAY);
        b1.setForeground(Color.white);
        b1.setBounds(300, 290, 90, 30);
        add(b1);

        b2 = new JRadioButton("FEMALE");
        b2.setBackground(Color.DARK_GRAY);
        b2.setForeground(Color.white);
        b2.setBounds(450, 290, 150, 30);
        add(b2);

        b3 = new JRadioButton("OTHERS");
        b3.setBackground(Color.DARK_GRAY);
        b3.setForeground(Color.white);
        b3.setBounds(600, 290, 250, 30);
        add(b3);

        bGroup = new ButtonGroup();
        bGroup.add(b1);
        bGroup.add(b2);
        bGroup.add(b3);
        // add(bGroup); it is not required to use add for buttongroup class
        //
        JLabel Email = new JLabel("Email:");
        Email.setFont(new Font("Raleway", Font.BOLD, 20));
        Email.setBounds(100, 340, 200, 30);
        Email.setForeground(Color.WHITE);
        add(Email);
        // email
        ename = new JTextField();
        ename.setFont(font);
        ename.setBounds(300, 340, 400, 30);
        add(ename);
        // married
        JLabel Marital = new JLabel("Marital Status:");
        Marital.setFont(new Font("Raleway", Font.BOLD, 20));
        Marital.setBounds(100, 390, 200, 30);
        Marital.setForeground(Color.WHITE);
        add(Marital);
        // mari button
        b4 = new JRadioButton("Married");
        b4.setBackground(Color.DARK_GRAY);
        b4.setForeground(Color.white);
        b4.setBounds(300, 390, 90, 30);
        add(b4);

        b5 = new JRadioButton("Unmarried");
        b5.setBackground(Color.DARK_GRAY);
        b5.setForeground(Color.white);
        b5.setBounds(450, 390, 150, 30);
        add(b5);

        b6 = new JRadioButton("Other");
        b6.setBackground(Color.DARK_GRAY);
        b6.setForeground(Color.white);
        b6.setBounds(600, 390, 250, 30);
        add(b6);

        bGroup2 = new ButtonGroup();
        bGroup2.add(b4);
        bGroup2.add(b5);
        bGroup2.add(b6);

        JLabel Address = new JLabel("Address:");
        Address.setFont(new Font("Raleway", Font.BOLD, 20));
        Address.setBounds(100, 440, 200, 30);
        Address.setForeground(Color.WHITE);
        add(Address);
        //
        addtf = new JTextField();
        addtf.setFont(font);
        addtf.setBounds(300, 440, 400, 30);
        add(addtf);

        JLabel City = new JLabel("City:");
        City.setFont(new Font("Raleway", Font.BOLD, 20));
        City.setBounds(100, 490, 200, 30);
        City.setForeground(Color.WHITE);
        add(City);
        //
        cit = new JTextField();
        cit.setFont(font);
        cit.setBounds(300, 490, 400, 30);
        add(cit);

        JLabel state = new JLabel("State:");
        state.setFont(new Font("Raleway", Font.BOLD, 20));
        state.setBounds(100, 540, 200, 30);
        state.setForeground(Color.WHITE);
        add(state);
        //
        stat = new JTextField();
        stat.setFont(font);
        stat.setBounds(300, 540, 400, 30);
        add(stat);

        JLabel Pin = new JLabel("Pin Code:");
        Pin.setFont(new Font("Raleway", Font.BOLD, 20));
        Pin.setBounds(100, 590, 200, 30);
        Pin.setForeground(Color.WHITE);
        add(Pin);
        //
        pint = new JTextField();
        pint.setFont(font);
        pint.setBounds(300, 590, 400, 30);
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

        // next page button
        next = new JButton("Next-Page");
        next.setBackground(new Color(133, 188, 199));
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Railway", Font.BOLD, 14));
        next.setBounds(620, 630, 80, 30);
        next.addActionListener(this);
        add(next);
    }

    public static void main(String[] args) {
        new Signup();
    }

    // For Sql
    public void actionPerformed(ActionEvent ae) {
        Form_no = "" + n;
        String Name = nam.getText();
        String Father_name = panam.getText();
        String Email_ID = ename.getText();
        String Address = addtf.getText();
        String City = cit.getText();
        String State = stat.getText();
        String Pin_code = pint.getText();
        String DOB = ((JTextField) date.getDateEditor().getUiComponent()).getText();
        String Gender = null;
        if (b1.isSelected()) {
            Gender = "MALE";
        } else if (b2.isSelected()) {
            Gender = "Female";
        } else if (b3.isSelected()) {
            Gender = "Others";
        }
        String Mstatus = null;
        if (b4.isSelected()) {
            Mstatus = "Married";
        } else if (b5.isSelected()) {
            Mstatus = "UnMarried";
        } else if (b6.isSelected()) {
            Mstatus = "Other";
        }
        try {
            if (Name.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Name is required");
                return;
            }
            if (Father_name.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Father's Name is required");
                return;
            }
            if (DOB.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Date of Birth is required");
                return;
            }
            if (Email_ID.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Email is required");
                return;
            }
            if (Address.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Address is required");
                return;
            }
            if (City.isEmpty()) {
                JOptionPane.showMessageDialog(null, "city is required");
                return;
            }
            if (State.isEmpty()) {
                JOptionPane.showMessageDialog(null, "state is required");
                return;
            }
            if (Pin_code.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Pin Code is required");
                return;
            } else {
                Connectivity c = new Connectivity();
                String query1 = "insert into signup values('" + Form_no + "','" + Name + "','" + Father_name + "','"
                        + DOB + "','" + Gender + "','" + Email_ID + "','" + Mstatus + "','" + Address + "','" + City
                        + "','" + State + "','" + Pin_code + "')";
                c.s.executeUpdate(query1);
                // signup ka data aagaya to use close karo aur signuo2 ko kholo
                new SignupTwo(Form_no).setVisible(true);
                setVisible(false);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
