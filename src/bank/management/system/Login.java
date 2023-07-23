package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
    JButton login, clearB, signUpB;
    JTextField cardNoField;
    JPasswordField pinNoField;
    Login(){
        // title
        setTitle("AUTOMATIC TELLER MACHINE");

        setLayout(null);
        // frame
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(70,10,100,100);
        add(label);

        JLabel text = new JLabel("Welcome to DJ ATM");
        text.setFont(new Font("Osward", Font.BOLD, 38));
        text.setBounds(200,40,400,40);
        add(text);

        JLabel cardNo = new JLabel("Card No:");
        cardNo.setFont(new Font("Raleway", Font.BOLD, 28));
        cardNo.setBounds(120,150,400,30);
        add(cardNo);

        cardNoField = new JTextField();
        cardNoField.setBounds(300,150, 230, 30);
        cardNoField.setFont(new Font("Arial", Font.BOLD, 14));
        add(cardNoField);

        JLabel pin = new JLabel("PIN:");
        pin.setFont(new Font("Raleway", Font.BOLD, 28));
        pin.setBounds(120,220,400,30);
        pin.setFont(new Font("Arial", Font.BOLD, 14));
        add(pin);

        pinNoField = new JPasswordField();
        pinNoField.setBounds(300,220, 230, 30);
        add(pinNoField);

        //signing button
        login = new JButton("SIGN IN");
        login.setBounds(300, 300, 100, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);

        //clear button
        clearB = new JButton("CLEAR");
        clearB.setBounds(430, 300, 100, 30);
        clearB.setBackground(Color.BLACK);
        clearB.setForeground(Color.WHITE);
        clearB.addActionListener(this);
        add(clearB);

        //signup button
        signUpB = new JButton("SIGN UP");
        signUpB.setBounds(300, 350, 230, 30);
        signUpB.setBackground(Color.BLACK);
        signUpB.setForeground(Color.WHITE);
        signUpB.addActionListener(this);
        add(signUpB);

        getContentPane().setBackground(Color.WHITE);

        setSize(800, 480);
        setVisible(true);
        setLocation(350,200);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == clearB){
            cardNoField.setText("");
            pinNoField.setText("");
        }else if (ae.getSource() == login){
            Conn conn = new Conn();
            String cardnumber = cardNoField.getText();
            String pinnumber = pinNoField.getText();
            String query = "select * from login where cardnumber = '"+cardnumber+"' and pin = '"+pinnumber+"'";
            try{
                ResultSet rs = conn.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null, "Incorrect card Number or Pin");
                }
            } catch (SQLException e) {
                System.out.println(e);
                throw new RuntimeException(e);
            }

        }else if(ae.getSource() == signUpB){
            setVisible(false);
            new SignUpOne().setVisible(true);
        }
    }

    public static void main(String[] args) {

        new Login();
    }
}
