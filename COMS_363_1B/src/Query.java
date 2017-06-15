import java.sql.*;

public class Query {

	public static void main(String[] args) throws SQLException {
		
		Connection conn = getConnection();
		
		Queries(conn);

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

	
	private static void Queries(Connection c) throws SQLException{
		ResultSet result = null;
		String output = "";
		String query_1 = "SELECT snum, ssn " +
					 "FROM Students " +
					 "Where name = ?";
		PreparedStatement state = null;
		state = c.prepareStatement(query_1);
		state.setString(1, "Becky");
		result = state.executeQuery();
		
		while(result.next()){
		output += result.getString(1) + "  ";
		output += result.getString(2);
		}
		
		System.out.println(output);
		
		
		String query_2 = "SELECT name, level " +
						 "FROM major " +
						 "Where snum = " +
						 "(SELECT snum " +
						 "FROM students " +
						 "WHERE ssn = ?)";
				
		String output_2 = "";
		state = c.prepareStatement(query_2);
		state.setInt(1, 123097834);
		result = state.executeQuery();
		
		while(result.next()){
			output_2 += result.getString(1) + "  ";
			output_2 += result.getString(2);
		}
		
		System.out.println(output_2);
			
		
		String query_3 = "SELECT name_course " +
				 "FROM Courses " +
				 "Where department_code = " +
				 "(SELECT code " +
				 "FROM departments " +
				 "WHERE name = ?)";
		
		String output_3 = "";
		state = c.prepareStatement(query_3);
		state.setString(1, "Computer Science");
		result = state.executeQuery();

		while(result.next()){
			output_3 += result.getString(1) + "  ";
		}

		System.out.println(output_3);

		
		String query_4 = "SELECT name, level " +
				 "FROM Degrees " +
				 "Where department_code = " +
				 "(SELECT code " +
				 "FROM departments " +
				 "WHERE name = ?)";
		
		String output_4 = "";
		state = c.prepareStatement(query_4);
		state.setString(1, "Computer Science");
		result = state.executeQuery();

		while(result.next()){
			output_4 += result.getString(1) + "  ";
			output_4 += result.getString(2) + "  ";
		}

		System.out.println(output_4);
		
		
		
		String query_5 = "SELECT name " +
				 "FROM Students " +
				 "Where snum IN " +
				 "(SELECT snum " +
				 "FROM minor) ";
		
		String output_5 = "";
		state = c.prepareStatement(query_5);
		result = state.executeQuery();

		while(result.next()){
			output_5 += result.getString(1) + "  ";
		}

		System.out.println(output_5);


	}

}
