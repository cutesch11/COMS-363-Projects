import java.sql.*;

public class ModifyRecords {

	public static void main(String[] args) throws SQLException {

		Connection conn = getConnection();
		
		Modify(conn);
		conn.close();
	}

	private static Connection getConnection(){
		
	Connection connect = null;
	try
	{
	Class.forName("com.mysql.jdbc.Driver");
	//Set up connection parameters
	String userName = "dbu363cutesch";
	String password = "RUkvtDPMrrz";
	String dbServer = "jdbc:mysql://mysql.cs.iastate.edu/db363cutesch";
	
	//Set up connection
	connect = DriverManager.getConnection(dbServer,userName,password);
	}
	catch(Exception e)
	{
	}
	
	return connect;
	
	}

	private static void Modify(Connection c) throws SQLException{
		Statement state_1 = null;
		
		
		String Modify_1 = "UPDATE Students " +
						  "SET name = 'Scott'" +
						  " WHERE ssn = 746897816";
		state_1 = c.createStatement();
		state_1.executeUpdate(Modify_1);
		
		System.out.println("Modify 1 complete");
		
		
		
		Statement state_2 = null;
		
		String Modify_2 = "UPDATE Major " +
				  "SET name = 'Computer Science', " +
				  "level = 'MS' " +
				  "WHERE snum = " +
				  "(SELECT snum " +
				  "FROM Students " +
				  "WHERE ssn = 746897816)";
		state_2 = c.createStatement();
		state_2.executeUpdate(Modify_2);
		
		System.out.println("Modify 2 complete");

		
		
		Statement state_3 = null;
		String Modify_3 = "DELETE FROM Register " +
				  "WHERE regtime = 'Spring2015'";
		state_3 = c.createStatement();
		state_3.executeUpdate(Modify_3);
		
		System.out.println("Modify 3 complete");

	}
	
}
