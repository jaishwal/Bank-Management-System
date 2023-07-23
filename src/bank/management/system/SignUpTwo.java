package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignUpTwo extends JFrame implements ActionListener{
    Long random;

    JTextField PanTextField, AadharTextField;
    JButton next;
    JRadioButton syes, sno, eyes, eno;
    JComboBox religion, catogory, Occupation, education, income;
    String formno;

    SignUpTwo(String formno) {
        this.formno = formno;
        setLayout(null);
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");

        //personal details
        JLabel AdditionalDetails = new JLabel("Page 2: Additional Details");
        AdditionalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        AdditionalDetails.setBounds(290,80,400,30);
        add(AdditionalDetails);


        //Name
        JLabel religionname = new JLabel("Religion:");
        religionname.setFont(new Font("Raleway", Font.BOLD, 20));
        religionname.setBounds(100,140,100,30);
        add(religionname);

        //add combo of religion
        String valReligion[] = {"Hindu", "Muslim", "Sikh", "Christian", "Others"};
        religion = new JComboBox(valReligion);
        religion.setBounds(300, 140, 400, 30);
        religion.setBackground(Color.WHITE);
        add(religion);

        //fathers name
        JLabel fname = new JLabel("Catogory:");
        fname.setFont(new Font("Raleway", Font.BOLD, 20));
        fname.setBounds(100,190,200,30);
        add(fname);

        //name textfield
        String valCatogory[] = {"Gen", "OBC", "SC", "ST", "Others"};
        catogory = new JComboBox(valCatogory);
        catogory.setBounds(300, 190, 400, 30);
        catogory.setBackground(Color.WHITE);
        add(catogory);

        // date of birth
        JLabel dob = new JLabel("Income:");
        dob.setFont(new Font("Raleway", Font.BOLD, 20));
        dob.setBounds(100,240,200,30);
        add(dob);

        //dob jar
        String valIncome[] = {"Null", "< 1,50,000", "< 5,00,000", "> 5,00,000", "Upto 10,00,000"};
        income = new JComboBox(valIncome);
        income.setBounds(300, 240, 400, 30);
        income.setBackground(Color.WHITE);
        add(income);

        //Gender
        JLabel gender = new JLabel("Educational");
        gender.setFont(new Font("Raleway", Font.BOLD, 20));
        gender.setBounds(100,290,200,30);
        add(gender);

        JLabel Email = new JLabel("Qualification:");
        Email.setFont(new Font("Raleway", Font.BOLD, 20));
        Email.setBounds(100,315,200,30);
        add(Email);

        String valEdu[] = {"Non Graduate", "Graduate", "Post-Graduate", "Doctrate", "Others"};
        education = new JComboBox(valEdu);
        education.setBounds(300, 290, 400, 30);
        education.setBackground(Color.WHITE);
        add(education);

        //married status
        JLabel married = new JLabel("Occupational:");
        married.setFont(new Font("Raleway", Font.BOLD, 20));
        married.setBounds(100,390,200,30);
        add(married);

        String valoccupation[] = {"Salaried", "Self-Employeed", "Bussiness", "Student", "Retired", "Others"};
        Occupation = new JComboBox(valoccupation);
        Occupation.setBounds(300, 390, 400, 30);
        Occupation.setBackground(Color.WHITE);
        add(Occupation);

        //Address
        JLabel Pan = new JLabel("PAN Number:");
        Pan.setFont(new Font("Raleway", Font.BOLD, 20));
        Pan.setBounds(100,440,200,30);
        add(Pan);

        //address textfield
        PanTextField = new JTextField();
        PanTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        PanTextField.setBounds(300, 440, 400, 30);
        add(PanTextField);

        //city
        JLabel Aadhar = new JLabel("Aadhar Number:");
        Aadhar.setFont(new Font("Raleway", Font.BOLD, 20));
        Aadhar.setBounds(100,490,200,30);
        add(Aadhar);

        AadharTextField = new JTextField();
        AadharTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        AadharTextField.setBounds(300, 490, 400, 30);
        add(AadharTextField);

        // state
        JLabel state = new JLabel("Senior Citizen:");
        state.setFont(new Font("Raleway", Font.BOLD, 20));
        state.setBounds(100,540,200,30);
        add(state);

        syes = new JRadioButton("Yes");
        syes.setBounds(300, 540, 100, 30);
        syes.setBackground(Color.WHITE);
        add(syes);

        sno = new JRadioButton("No");
        sno.setBounds(450, 540, 100, 30);
        sno.setBackground(Color.WHITE);
        add(sno);


        //pincode
        JLabel existingaccount = new JLabel("Existing Account:");
        existingaccount.setFont(new Font("Raleway", Font.BOLD, 20));
        existingaccount.setBounds(100,590,200,30);
        add(existingaccount);

        eyes = new JRadioButton("Yes");
        eyes.setBounds(300, 590, 100, 30);
        eyes.setBackground(Color.WHITE);
        add(eyes);

        eno = new JRadioButton("No");
        eno.setBounds(450, 590, 100, 30);
        eno.setBackground(Color.WHITE);
        add(eno);

        //next button
        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD, 15));
        next.setBounds(620,660,80,30);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.WHITE);

        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String formno = "" + random; // long
        String sreligion = (String) religion.getSelectedItem(); //setText
        String scatogory = (String) catogory.getSelectedItem();
        String sincome = (String) income.getSelectedItem();
        String seducation = (String) education.getSelectedItem();
        String soccupation= (String) Occupation.getSelectedItem();
        String span = PanTextField.getText();
        String sadhar = AadharTextField.getText();

        String seniorcitizen = null;
        if(syes.isSelected()){
            seniorcitizen = "Yes";
        }else if (sno.isSelected()){
            seniorcitizen = "No";
        }
        String existingaccount = null;
        if(eyes.isSelected()){
            existingaccount = "Yes";
        }else if(eno.isSelected()) {
            existingaccount = "No";
        }

        try{
            Conn c = new Conn();
            String query = "insert into signuptwo value('"+formno+"','"+sreligion+"', '"+scatogory+"','"+sincome+"','"+seducation+"','"+soccupation+"','"+span+"','"+sadhar+"','"+seniorcitizen+"','"+existingaccount+"');";
            c.s.executeUpdate(query);

            //signupthree object
            setVisible(false);
            new SignUpThree(formno).setVisible(true);

        }catch (Exception e){
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        new  SignUpTwo("");
    }
}



