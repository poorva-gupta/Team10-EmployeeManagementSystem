import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class login extends JFrame implements ActionListener{

    JTextField tusername;
    JPasswordField tpassword;
    JButton login,back;

    login(){
        JLabel l1;  
        l1=new JLabel("Username");  
        l1.setBounds(40,20,100,30); 
        add(l1);

        tusername=new JTextField();
        tusername.setBounds(150,20,150,30);
        add(tusername);
        
        JLabel l2;
        l2=new JLabel("Password");
        l2.setBounds(40,70,100,30);
        add(l2);

        
        tpassword=new JPasswordField();
        tpassword.setBounds(150,70,150,30);
        add(tpassword);

        login=new JButton("LOGIN");
        login.setBounds(150,140,150,30);
        login.setBackground(Color.black);
        login.setForeground(Color.white);
        login.addActionListener(this);
        add(login);

        back=new JButton("BACK");
        back.setBounds(150,180,150,30);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.addActionListener(this);
        add(back);


        ImageIcon i11 = new ImageIcon("login.jpeg");
        Image i22 = i11.getImage().getScaledInstance(250,400, Image.SCALE_DEFAULT);
        ImageIcon i33 = new ImageIcon(i22);
        JLabel imgg= new JLabel(i33); 
        imgg.setBounds(350, 10, 250, 400);
        add(imgg);






        ImageIcon i1 = new ImageIcon("b2.jpeg");
        Image i2 = i1.getImage().getScaledInstance(600,300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3); 
        img.setBounds(0, 0, 600, 300);
        add(img);


        
    

        





       
        
        


        setSize(600,300);
        setLocation(450,200);
        setLayout(null);
        setVisible(true);

    }



    @Override
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == login){

        } else if (e.getSource() == back){
            System.exit(90);
        }

    }
    public static void main(String[] args){
        new login();
    }
}
