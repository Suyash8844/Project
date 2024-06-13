
package airlinemanagementsystem;

import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class AddCustomer extends JFrame implements ActionListener{
    
    
    JTextField tfname, tfphone, tfaadhar, tfnationality, tfaddress; 
    JRadioButton rbmale, rbfemale;
    public AddCustomer(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("ADD CUSTOMER DETAILS");
        heading.setBounds(220, 20, 500, 35);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 22));
        heading.setForeground(Color.BLUE);
        add(heading);
        
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(50, 80, 150, 25);
        lblname.setFont(new Font("Tahoma", Font.PLAIN, 14));
        add(lblname);
        
        tfname = new JTextField();
        tfname.setBounds(170, 85, 150, 20);
        add(tfname);
        
        JLabel lblnationality = new JLabel("Nationality");
        lblnationality.setBounds(50, 130, 150, 25);
        lblnationality.setFont(new Font("Tahoma", Font.PLAIN, 14));
        add(lblnationality);
        
        tfnationality = new JTextField();
        tfnationality.setBounds(170, 135, 150, 20);
        add(tfnationality);
        
        JLabel lblaadhar = new JLabel("Aadhar Number");
        lblaadhar.setBounds(50, 180, 150, 25);
        lblaadhar.setFont(new Font("Tahoma", Font.PLAIN, 14));
        add(lblaadhar);
        
        tfaadhar = new JTextField();
        tfaadhar.setBounds(170, 185, 150, 20);
        add(tfaadhar);
        
        JLabel lbaddress = new JLabel("Address");
        lbaddress.setBounds(50, 230, 150, 25);
        lbaddress.setFont(new Font("Tahoma", Font.PLAIN, 14));
        add(lbaddress);
        
        tfaddress = new JTextField();
        tfaddress.setBounds(170, 235, 150, 20);
        add(tfaddress);
        
        JLabel lbgender = new JLabel("Gender");
        lbgender.setBounds(50, 280, 150, 25);
        lbgender.setFont(new Font("Tahoma", Font.PLAIN, 14));
        add(lbgender);
        
        ButtonGroup gendergroup =new ButtonGroup();
        
        rbmale = new JRadioButton("Male");
        rbmale.setBounds(170, 285, 70, 20);
        rbmale.setBackground(Color.WHITE);
        add(rbmale);
        
        rbfemale = new JRadioButton("Female");
        rbfemale.setBounds(250, 285, 70, 20);
        rbfemale.setBackground(Color.WHITE);
        add(rbfemale);
        
        gendergroup.add(rbmale);
        gendergroup.add(rbfemale);
        
        JLabel lbphone = new JLabel("Phone");
        lbphone.setBounds(50, 330, 150, 25);
        lbphone.setFont(new Font("Tahoma", Font.PLAIN, 14));
        add(lbphone);
        
        tfphone = new JTextField();
        tfphone.setBounds(170, 335, 150, 20);
        add(tfphone);
        
        JButton save = new JButton("SAVE");
        save.setBackground(Color.BLACK);
        save.setForeground(Color.WHITE);
        save.setBounds(170, 385, 150, 30);
        save.addActionListener(this);
        add(save);
        
        ImageIcon image = new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/emp.png"));
        JLabel lblimage = new JLabel(image);
        lblimage.setBounds(400, 60, 200, 400);
        add(lblimage);
        
        setSize(700, 500);
        setLocation(300, 120);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        String name = tfname.getText();
        String nationality = tfnationality.getText();
        String phone = tfphone.getText();
        String address = tfaddress.getText();
        String aadhar = tfaadhar.getText();
        String gender = null;
        if(rbmale.isSelected()){
            gender = "Male";
        } else {
            gender ="Female";
        }
        try{
            Conn conn = new Conn();
            
            String query = "insert into passenger values('"+name+"', '"+nationality+"', '"+phone+"', '"+address+"', '"+aadhar+"', '"+gender+"')";
            
            conn.s.executeUpdate(query);
            
            JOptionPane.showMessageDialog(null, "Customer Details Added Sucessfully");
            
            setVisible(false);
            
        } catch (Exception e){
            e.printStackTrace();
        }
        
    }
    public static void main(String[] args){
        
        new AddCustomer();
    }
    
}
