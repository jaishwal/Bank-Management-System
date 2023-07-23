package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PinChange extends JFrame implements ActionListener {
    String pinnumber;
    JButton change , back;
    JPasswordField pin, repin;
    PinChange(String pinnumber){
        this.pinnumber = pinnumber;
        setLayout(null);

        //Add image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text = new JLabel(("CHANGE YOUR PIN"));
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(250, 280, 500, 35);
        image.add(text);

        JLabel textpin = new JLabel(("New PIN:"));
        textpin.setForeground(Color.WHITE);
        textpin.setFont(new Font("System", Font.BOLD, 16));
        textpin.setBounds(165, 320, 180, 25);
        image.add(textpin);

        pin = new JPasswordField();
        pin.setFont(new Font("Raleway", Font.BOLD,25));
        pin.setBounds(330,320,180,25);
        image.add(pin);

        JLabel retextpin = new JLabel(("Re-Enter New PIN:"));
        retextpin.setForeground(Color.WHITE);
        retextpin.setFont(new Font("System", Font.BOLD, 16));
        retextpin.setBounds(165, 360, 180, 25);
        image.add(retextpin);

        repin = new JPasswordField();
        repin.setFont(new Font("Raleway", Font.BOLD,25));
        repin.setBounds(330,360,180,25);
        image.add(repin);

        //Buttons
        change = new JButton("CHANGE");
        change.setBounds(355,485,150,30);
        change.addActionListener(this);
        image.add(change);

        back = new JButton("BACK");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);

        setSize(900,900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == change){
            try{
                String npin = pin.getText();
                String rpin = repin.getText();

                if(!npin.equals(rpin)){
                    JOptionPane.showMessageDialog(null, "Entered PIN does not match");
                    return;
                }
                if(npin.equals((""))){
                    JOptionPane.showMessageDialog(null, "Please enter new PIN");
                    return;
                }
                if(rpin.equals((""))){
                    JOptionPane.showMessageDialog(null, "Please re-enter new PIN");
                    return;
                }
                Conn conn = new Conn();
                String query1 = "update bank set pin = '"+rpin+"' where pin='"+pinnumber+"'";
                String query2 = "update login set pin = '"+rpin+"' where pin='"+pinnumber+"'";
                String query3 = "update signupthree set pin = '"+rpin+"' where pin='"+pinnumber+"'";

                conn.s.executeUpdate(query1);
                conn.s.executeUpdate(query2);
                conn.s.executeUpdate(query3);

                JOptionPane.showMessageDialog(null, "PIN changed successfully");
                setVisible(false);
                new Transactions(rpin).setVisible(true);

            }catch (Exception e){
                System.out.println(e);
            }
        }else{
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);

        }

    }

    public static void main(String[] args) {
        new PinChange("").setVisible(true);
    }
}
