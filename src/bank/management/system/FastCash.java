package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.*;
public class FastCash extends JFrame implements ActionListener {
    JButton fiveHundred,oneThousand, twoThousand,  fourThousand, fiveThousand,tenThousand, back;
    String pinnumber;
    FastCash(String pinnumber) {
        this.pinnumber = pinnumber;
        //Atm image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        //Label
        JLabel text = new JLabel("SELECT WITHDRAWL AMOUNT");
        text.setBounds(215,300,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);

        //Buttons
        fiveHundred = new JButton("500");
        fiveHundred.setBounds(170,415,150,30);
        fiveHundred.addActionListener(this);
        image.add(fiveHundred);

        oneThousand = new JButton("1000");
        oneThousand.setBounds(355,415,150,30);
        oneThousand.addActionListener(this);
        image.add(oneThousand);

        twoThousand = new JButton("2000");
        twoThousand.setBounds(170,450,150,30);
        twoThousand.addActionListener(this);
        image.add(twoThousand);

        fourThousand = new JButton("4000");
        fourThousand.setBounds(355,450,150,30);
        fourThousand.addActionListener(this);
        image.add(fourThousand);

        fiveThousand = new JButton("5000");
        fiveThousand.setBounds(170,485,150,30);
        fiveThousand.addActionListener(this);
        image.add(fiveThousand);

        tenThousand = new JButton("10000");
        tenThousand.setBounds(355,485,150,30);
        tenThousand.addActionListener(this);
        image.add(tenThousand);

        back = new JButton("Back");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);


        //Frame
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true); //this function is used for cut upper and lower linnings
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == back) {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }else{
            String amount = ((JButton)ae.getSource()).getText().substring(3);
            Conn c = new Conn();
            try{
                ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
                int balance = 0;
                while(rs.next()){
                    if(rs.getString("type1").equals("Deposit")){
                        balance += Integer.parseInt(rs.getString("amount"));
                    }else{
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }
                if(ae.getSource() != back && balance < Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return;
                }
                Date date = new Date();
                String query = "insert into bank values('"+pinnumber+"', '"+date+"', 'withdrawl', '"+amount+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Rs "+ amount + "Debited Successfully");

                setVisible(false);
                new Transactions(pinnumber).setVisible(true);

            }catch(Exception e){
                System.out.println(e);
            }
        }
    }

    public static void main(String[] args) {
        new FastCash("");
    }
}
