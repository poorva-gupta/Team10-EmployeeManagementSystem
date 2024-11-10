package com.example.employeemanagement;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.sql.*; 

public class AddEmployee extends JFrame implements ActionListener {
    Random ran = new Random();
    int number = ran.nextInt(999999);
    JTextField tname, tfname, taddress, tphone, taadhar, temail, tsalary, tdesignation;
    JLabel tempid;

    JButton addButton, backButton;
    JComboBox<String> boxEducation;

    AddEmployee() {
        getContentPane().setBackground(new Color(163, 255, 188));
        JLabel heading = new JLabel("Add Employee Detail");
        heading.setBounds(320, 30, 500, 50);
        heading.setFont(new Font("serif", Font.BOLD, 25));
        add(heading);

        JLabel l1 = new JLabel("Name");
        l1.setBounds(50, 150, 150, 30);
        l1.setFont(new Font("serif", Font.BOLD, 20));
        add(l1);

        tname = new JTextField();
        tname.setBounds(200, 150, 150, 30);
        add(tname);

        JLabel l2 = new JLabel("Father's Name");
        l2.setBounds(400, 150, 150, 30);
        l2.setFont(new Font("serif", Font.BOLD, 20));
        add(l2);

        tfname = new JTextField();
        tfname.setBounds(600, 150, 150, 30);
        add(tfname);

        JLabel l3 = new JLabel("Salary");
        l3.setBounds(400, 200, 150, 30);
        l3.setFont(new Font("serif", Font.BOLD, 20));
        add(l3);

        tsalary = new JTextField();
        tsalary.setBounds(600, 200, 150, 30);
        add(tsalary);

        JLabel l4 = new JLabel("Address");
        l4.setBounds(50, 250, 150, 30);
        l4.setFont(new Font("serif", Font.BOLD, 20));
        add(l4);

        taddress = new JTextField();
        taddress.setBounds(200, 250, 150, 30);
        add(taddress);

        JLabel l5 = new JLabel("Phone");
        l5.setBounds(400, 250, 150, 30);
        l5.setFont(new Font("serif", Font.BOLD, 20));
        add(l5);

        tphone = new JTextField();
        tphone.setBounds(600, 250, 150, 30);
        add(tphone);

        JLabel l6 = new JLabel("Email");
        l6.setBounds(50, 300, 150, 30);
        l6.setFont(new Font("serif", Font.BOLD, 20));
        add(l6);

        temail = new JTextField();
        temail.setBounds(200, 300, 150, 30);
        add(temail);

        JLabel education = new JLabel("Highest Education");
        education.setBounds(400, 300, 150, 30);
        education.setFont(new Font("serif", Font.BOLD, 20));
        add(education);

        String items[] = {"BBA", "B.TECH", "BCA", "BA", "BSC", "B.COM", "MBA", "MCA", "MA", "M.TECH", "MSC", "PHD"};
        boxEducation = new JComboBox<>(items);
        boxEducation.setBackground(new Color(177, 252, 197));
        boxEducation.setBounds(600, 300, 150, 30);
        add(boxEducation);

        JLabel l7 = new JLabel("Aadhar Number");
        l7.setBounds(400, 350, 150, 30);
        l7.setFont(new Font("serif", Font.BOLD, 20));
        add(l7);

        taadhar = new JTextField();
        taadhar.setBounds(600, 350, 150, 30);
        add(taadhar);

        JLabel l8 = new JLabel("Employee ID");
        l8.setBounds(50, 400, 150, 30);
        l8.setFont(new Font("serif", Font.BOLD, 20));
        add(l8);

        tempid = new JLabel("" + number);
        tempid.setBounds(200, 400, 150, 30);
        tempid.setFont(new Font("serif", Font.BOLD, 20));
        tempid.setForeground(Color.RED);
        add(tempid);

        JLabel l9 = new JLabel("Designation");
        l9.setBounds(50, 350, 150, 30);
        l9.setFont(new Font("serif", Font.BOLD, 20));
        add(l9);

        tdesignation = new JTextField();
        tdesignation.setBounds(200, 350, 150, 30);
        add(tdesignation);

        addButton = new JButton("ADD");
        addButton.setBounds(450, 550, 150, 40);
        addButton.setBackground(Color.BLACK);
        addButton.setForeground(Color.WHITE);
        addButton.addActionListener(this);
        add(addButton);

        backButton = new JButton("BACK");
        backButton.setBounds(250, 550, 150, 40);
        backButton.setBackground(Color.BLACK);
        backButton.setForeground(Color.WHITE);
        backButton.addActionListener(this);
        add(backButton);

        setSize(900, 700);
        setLayout(null);
        setLocation(300, 50);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            String name = tname.getText();
            String fname = tfname.getText();
            String salary = tsalary.getText();
            String address = taddress.getText();
            String aadhar = taadhar.getText();
            String phone = tphone.getText();
            String email = temail.getText();
            String education = (String) boxEducation.getSelectedItem(); // Corrected method
            String designation = tdesignation.getText();
            String empID = tempid.getText();

            try {
                ConnectionManager c = new ConnectionManager(); 
                String query = "INSERT INTO employee (name, father_name, salary, address, phone, email, education, designation, aadhar, emp_id) " +
                               "VALUES ('" + name + "','" + fname + "','" + salary + "','" + address + "','" + phone + "','" + email + "','" + education + "','" + designation + "','" + aadhar + "','" + empID + "')";
                c.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details added successfully");
                setVisible(false);
                new Main_class(); // Ensure this class exists
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        new AddEmployee();
    }
}

