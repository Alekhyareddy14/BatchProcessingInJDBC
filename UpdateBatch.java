package BatchProcessing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateBatch {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "root");
        String updateSQL = "UPDATE employees SET salary = salary + 5000 WHERE id = ?";
        PreparedStatement pstmt = con.prepareStatement(updateSQL);

        pstmt.setInt(1, 1);
        pstmt.addBatch();

        pstmt.setInt(1, 2);
        pstmt.addBatch();

        int[] rowsAffected = pstmt.executeBatch();
        System.out.println(rowsAffected.length + " rows updated successfully!");

	}
}
