
import javax.swing.*;
import java.awt.Image;

public class Splash extends JFrame {
    Splash() {
         
    JLabel l1;  
    l1=new JLabel("Employee Management System");  
    l1.setBounds(70,50, 400,100);  
    
   
    add(l1); 
    setSize(300,300); 
        ImageIcon i1 = new ImageIcon("background.jpeg");
        Image i2 = i1.getImage().getScaledInstance(1000,500, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1000, 500);
        add(image);

        setSize(1000, 500);
        setLocation(200, 50);
        setLayout(null);
        setVisible(true);

        try {
            Thread.sleep(5000);
            setVisible(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
     new Splash(); 
    }
}

