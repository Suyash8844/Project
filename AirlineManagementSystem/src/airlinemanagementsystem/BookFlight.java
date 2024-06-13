

package airlinemanagementsystem;

import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;

public class BookFlight extends JFrame implements ActionListener{
    
    
    JTextField tfaadhar;
    JLabel tfname, tfnationality, tfaddress, labelgender, labelfname,labelfcode;
    JButton bookflight, fetchButton, flight;
    Choice source, destination;
    JDateChooser dcdate;
    
    
    public BookFlight(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        
        JLabel heading = new JLabel("Book Flight");
        heading.setBounds(400, 20, 500, 35);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 30));
        heading.setForeground(Color.BLUE);
        add(heading);
        
        JLabel lblaadhar = new JLabel("Aadhar");
        lblaadhar.setBounds(50, 80, 130, 25);
        lblaadhar.setFont(new Font("Tahoma", Font.PLAIN, 14));
        add(lblaadhar);
        
        tfaadhar = new JTextField();
        tfaadhar.setBounds(170, 85, 130, 20);
        add(tfaadhar);
        
        fetchButton = new JButton("Fetch User");
        fetchButton.setBackground(Color.BLACK);
        fetchButton.setForeground(Color.WHITE);
        fetchButton.setBounds(305, 84, 120, 20);
        fetchButton.addActionListener(this);
        add(fetchButton);
        
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(50, 130, 120, 25);
        lblname.setFont(new Font("Tahoma", Font.PLAIN, 14));
        add(lblname);
        
        tfname = new JLabel();
        tfname.setBounds(170, 135, 120, 20);
        add(tfname);
        
        JLabel lblnationality = new JLabel("Nationality");
        lblnationality.setBounds(50, 180, 120, 25);
        lblnationality.setFont(new Font("Tahoma", Font.PLAIN, 14));
        add(lblnationality);
        
        tfnationality = new JLabel();
        tfnationality.setBounds(170, 185, 120, 20);
        add(tfnationality);
        
        
        
        JLabel lbaddress = new JLabel("Address");
        lbaddress.setBounds(50, 230, 120, 25);
        lbaddress.setFont(new Font("Tahoma", Font.PLAIN, 14));
        add(lbaddress);
        
        tfaddress = new JLabel();
        tfaddress.setBounds(170, 235, 120, 20);
        add(tfaddress);
        
        JLabel lblgender = new JLabel("Gender");
        lblgender.setBounds(50, 280, 120, 25);
        lblgender.setFont(new Font("Tahoma", Font.PLAIN, 14));
        add(lblgender);
        
        labelgender = new JLabel("Gender");
        labelgender.setBounds(170, 280, 120, 25);
        add(labelgender);
        
        JLabel lblsource = new JLabel("Source");
        lblsource.setBounds(50, 330, 120, 25);
        lblsource.setFont(new Font("Tahoma", Font.PLAIN, 14));
        add(lblsource);
        
        source = new Choice();
        source.setBounds(170, 330, 120, 25);
        add(source);
        
        JLabel lbldest = new JLabel("Destination");
        lbldest.setBounds(50, 380, 120, 25);
        lbldest.setFont(new Font("Tahoma", Font.PLAIN, 14));
        add(lbldest);
       
        destination = new Choice();
        destination.setBounds(170, 380, 120, 25);
        add(destination);
        
        try{
            Conn c = new Conn();
            String query = "select * from flight";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                source.add(rs.getString("source"));
                destination.add(rs.getString("destination"));
            }
        } catch (Exception e){
            e.printStackTrace();
        }
      
       
        flight = new JButton("Fetch Flights");
        flight.setBackground(Color.BLACK);
        flight.setForeground(Color.WHITE);
        flight.setBounds(300, 380, 120, 20);
        flight.addActionListener(this);
        add(flight);
        
        JLabel lblframe = new JLabel("Flight Name");
        lblframe.setBounds(50, 430, 120, 25);
        lblframe.setFont(new Font("Tahoma", Font.PLAIN, 14));
        add(lblframe);
        
        labelfname = new JLabel();
        labelfname.setBounds(170, 435, 120, 20);
        add(labelfname);
        
        JLabel lblfcode = new JLabel("Flight Code");
        lblfcode.setBounds(50, 480, 120, 25);
        lblfcode.setFont(new Font("Tahoma", Font.PLAIN, 14));
        add(lblfcode);
        
        labelfcode = new JLabel();
        labelfcode.setBounds(170, 485, 120, 20);
        add(labelfcode);
        
        JLabel lbldate = new JLabel("Date of Travel");
        lbldate.setBounds(50, 530, 120, 25);
        lbldate.setFont(new Font("Tahoma", Font.PLAIN, 14));
        add(lbldate);
        
        dcdate = new JDateChooser();
        dcdate.setBounds(170, 535, 120, 20);
        add(dcdate);
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/details.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400, 350, Image.SCALE_DEFAULT);
        ImageIcon image = new ImageIcon(i2);
        JLabel lblimage = new JLabel(image);
        lblimage.setBounds(450, 80, 500, 400);
        add(lblimage);
        
        bookflight = new JButton("Book Flight");
        bookflight.setBackground(Color.BLACK);
        bookflight.setForeground(Color.WHITE);
        bookflight.setBounds(170, 570, 120, 20);
        bookflight.addActionListener(this);
        add(bookflight);
        
        setSize(950, 640);
        setLocation(170, 35);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == fetchButton){
            
            String aadhar = tfaadhar.getText();
           
            try{
                Conn conn = new Conn();
            
                String query = "select * from passenger where aadhar = '"+aadhar+"'";
            
                 ResultSet rs = conn.s.executeQuery(query);
            
                if(rs.next()){
                    tfname.setText(rs.getString("name"));
                    tfnationality.setText(rs.getString("nationality"));
                    tfaddress.setText(rs.getString("address"));
                    labelgender.setText(rs.getString("gender"));
                } else {
                    JOptionPane.showMessageDialog(null, "Please enter correct aadhar");
               }
            } catch (Exception e){
                e.printStackTrace();
            }
        } else if (ae.getSource() == flight){
            
            String src = source.getSelectedItem();
            String dest = destination.getSelectedItem();
           
            try{
                Conn conn = new Conn();
            
                String query = "select * from flight where source = '"+src+"' and destination = '"+dest+"'";
            
                 ResultSet rs = conn.s.executeQuery(query);
            
                if(rs.next()){
                    labelfname.setText(rs.getString("f_name"));
                    labelfcode.setText(rs.getString("f_code"));
                } else {
                    JOptionPane.showMessageDialog(null, "No Flights Found");
               }
            } catch (Exception e){
                e.printStackTrace();
            }
        } else {
            Random random = new Random();
            String aadhar = tfaadhar.getText();
            String name = tfname.getText();
            String nationality = tfnationality.getText();
            String flightname = labelfname.getText();
            String flightcode = labelfcode.getText();
            String src = source.getSelectedItem();
            String des = destination.getSelectedItem();
            String ddate = ((JTextField) dcdate.getDateEditor().getUiComponent()).getText();
            
             try{
                Conn conn = new Conn();
            
                String query = "insert into reservation values('PNR-"+random.nextInt(1000000)+"', 'TIC-"+random.nextInt(10000)+"','"+aadhar+"', '"+name+"', '"+nationality+"', '"+flightname+"', '"+flightcode+"', '"+src+"', '"+des+"', '"+ddate+"')";          
            
                conn.s.executeUpdate(query);
            
                    JOptionPane.showMessageDialog(null, "Ticket Booked Successfully");
                    setVisible(false);
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    
    public static void main(String[] args){
        new BookFlight();
    }
}
   

