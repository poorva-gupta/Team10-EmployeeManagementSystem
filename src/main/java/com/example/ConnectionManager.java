// // import java.sql.*;
// // import java.sql.Connection;
// // import java.sql.Statement;

// // public class connection {
// //     Connection connection;
// //     Statement statement;

// //     public connection(){
// //         try{
// //             Class.forName("cpm.mysql.cj.jdbc.Driver");
// //             connection=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/employeemanagement","root","ZXdf@#24");
// //             statement=connection.createStatement();

// //         }catch(Exception e){
// //             e.printStackTrace();
// //         }
// //     }
    

    
// // }
// import java.sql.*;

// public class ConnectionManager {
//     Connection connection;
//     Statement statement;

//     public ConnectionManager() {
//         try {
//             Class.forName("com.mysql.cj.jdbc.Driver");
//             connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/employeemanagement", "root", "ZXdf@#24");
//             statement = connection.createStatement();
//         } catch (Exception e) {
//             e.printStackTrace();
//         }
//     }
// }
import java.sql.*;

public class ConnectionManager {
    Connection connection;
    Statement statement;

    public ConnectionManager() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/employeemanagement", "root", "ZXdf@#24");
            statement = connection.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
