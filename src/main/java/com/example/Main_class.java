// import javax.swing.JFrame;
// import javax.swing.*;

// public class Main_class extends JFrame {
//     Main_class(){
//         setSize(500,500);
//         setVisible(true);
//     }
//     public static void main(String[] args) {
//         new Main_class();
        
//     }

    
// }
import javax.swing.JFrame;

public class Main_class extends JFrame {
    Main_class() {
        setSize(500, 500);
        setLocationRelativeTo(null); // Center on screen
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Main_class();
    }
}
