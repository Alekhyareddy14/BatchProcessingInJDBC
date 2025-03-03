package BatchProcessing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteBatch {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "root");

		String deleteSQL = "DELETE FROM employees WHERE id = ?";
		PreparedStatement pstmt = con.prepareStatement(deleteSQL);

		pstmt.setInt(1, 3);
		pstmt.addBatch();

		pstmt.setInt(1, 4);
		pstmt.addBatch();

		int[] deletedRows = pstmt.executeBatch(); // Executes all deletions at once
		System.out.println(deletedRows.length+"rows deleted");
	}
}
