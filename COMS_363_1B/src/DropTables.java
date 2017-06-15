import java.sql.*;

public class DropTables {

	public static void main(String[] args) throws SQLException {

		Connection conn = getConnection();
		
		Drop_major(conn);
		Drop_minor(conn);
		Drop_register(conn);
		Drop_degrees(conn);
		Drop_students(conn);
		Drop_courses(conn);
		Drop_departments(conn);

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

	private static void Drop_students(Connection c) throws SQLException{
		Statement state = c.createStatement();
		
		String drop = "Drop table Students";
		
		state.executeUpdate(drop);
		System.out.println("Students table dropped");
	}
	
	private static void Drop_departments(Connection c) throws SQLException{
		Statement state = c.createStatement();
		
		String drop = "Drop table Departments";
		
		state.executeUpdate(drop);
		System.out.println("Departments table dropped");

	}
	private static void Drop_degrees(Connection c) throws SQLException{
		Statement state = c.createStatement();
		
		String drop = "Drop table Degrees";
		
		state.executeUpdate(drop);
		System.out.println("Degrees table dropped");

	}
	private static void Drop_register(Connection c) throws SQLException{
		Statement state = c.createStatement();
		
		String drop = "Drop table Register";
		
		state.executeUpdate(drop);
		System.out.println("Register table dropped");

	}
	private static void Drop_major(Connection c) throws SQLException{
		Statement state = c.createStatement();
		
		String drop = "Drop table Major";
		
		state.executeUpdate(drop);
		System.out.println("Major table dropped");

	}
	private static void Drop_minor(Connection c) throws SQLException{
		Statement state = c.createStatement();
		
		String drop = "Drop table Minor";
		
		state.executeUpdate(drop);
		System.out.println("Minor table dropped");

	}
	private static void Drop_courses(Connection c) throws SQLException{
		Statement state = c.createStatement();
		
		String drop = "Drop table Courses";
		
		state.executeUpdate(drop);
		System.out.println("Courses table dropped");

	}

}
