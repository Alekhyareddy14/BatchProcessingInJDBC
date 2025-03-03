package BatchProcessing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertBatch {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "root");

        String insertSQL = "INSERT INTO employees (first_name, last_name, email, salary) VALUES (?, ?, ?, ?)";
        PreparedStatement pstmt = con.prepareStatement(insertSQL);

        // Adding first record
        pstmt.setString(1, "Alice");
        pstmt.setString(2, "Smith");
        pstmt.setString(3, "alice.smith@gmail.com");
        pstmt.setDouble(4, 60000.00);
        pstmt.addBatch(); // Add to batch

        // Adding second record
        pstmt.setString(1, "Bob");
        pstmt.setString(2, "Johnson");
        pstmt.setString(3, "bob.johnson@gmail.com");
        pstmt.setDouble(4, 55000.00);
        pstmt.addBatch();

        // Executing batch
        int[] rowsAffected = pstmt.executeBatch();
        System.out.println(rowsAffected.length + " rows inserted successfully!");

     
    }
}
