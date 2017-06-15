import java.sql.*;


public class InsertRecords {

	public static void main(String[] args) throws SQLException {

		Connection conn = getConnection();
		
		Insert_Students(conn);
		Insert_Departments(conn);
		Insert_Degrees(conn);
		Insert_Major(conn);
		Insert_Minor(conn);
		Insert_Courses(conn);
		Insert_Register(conn);
		
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

	private static void Insert_Students(Connection c) throws SQLException{
		PreparedStatement state = null;
		state = c.prepareStatement("Insert Into Students(snum, ssn, name, gender, dob, c_addr, c_phone, p_addr, p_phone)" +
									"values(?, ?, ?, ?, ?, ? , ?, ?, ?)");
		
		
		state.setInt(1, 1001);
		state.setInt(2, 654651234);
		state.setString(3, "Randy");
		state.setString(4, "M");
		state.setString(5, "2000/12/01");
		state.setString(6, "301 E Hall");
		state.setString(7, "5152700988");
		state.setString(8, "121 Main");
		state.setString(9, "7083066321");
		state.executeUpdate();
		
		state.setInt(1, 1002);
		state.setInt(2, 123097834);
		state.setString(3, "Victor");
		state.setString(4, "M");
		state.setString(5, "2000/05/06");
		state.setString(6, "270 W Hall");
		state.setString(7, "5151234578");
		state.setString(8, "702 Walnut");
		state.setString(9, "7080366333");
		state.executeUpdate();
		
		state.setInt(1, 1003);
		state.setInt(2, 978012431);
		state.setString(3, "John");
		state.setString(4, "M");
		state.setString(5, "1999/07/08");
		state.setString(6, "201 W Hall");
		state.setString(7, "5154132805");
		state.setString(8, "888 University");
		state.setString(9, "5152012011");
		state.executeUpdate();
		
		state.setInt(1, 1004);
		state.setInt(2, 746897816);
		state.setString(3, "Seth");
		state.setString(4, "M");
		state.setString(5, "1998/12/30");
		state.setString(6, "199 N Hall");
		state.setString(7, "5158891504");
		state.setString(8, "21 Green");
		state.setString(9, "5154132907");
		state.executeUpdate();
		
		state.setInt(1, 1005);
		state.setInt(2, 186032894);
		state.setString(3, "Nicole");
		state.setString(4, "F");
		state.setString(5, "2001/04/01");
		state.setString(6, "178 S Hall");
		state.setString(7, "5158891155");
		state.setString(8, "13 Gray");
		state.setString(9, "5157162071");
		state.executeUpdate();
		
		state.setInt(1, 1006);
		state.setInt(2, 534218752);
		state.setString(3, "Becky");
		state.setString(4, "F");
		state.setString(5, "2001/05/16");
		state.setString(6, "12 N Hall");
		state.setString(7, "5157083698");
		state.setString(8, "189 Clark");
		state.setString(9, "2034367632");
		state.executeUpdate();
		
		state.setInt(1, 1007);
		state.setInt(2, 432609519);
		state.setString(3, "Kevin");
		state.setString(4, "M");
		state.setString(5, "2000/08/12");
		state.setString(6, "75 E Hall");
		state.setString(7, "5157082497");
		state.setString(8, "89 National");
		state.setString(9, "7182340772");
		state.executeUpdate();

		
		
		System.out.println("Students Table rows updated");

	}

	private static void Insert_Departments(Connection c) throws SQLException{
		PreparedStatement state = null;
		state = c.prepareStatement("Insert Into Departments(code,name,phone,college)" +
									"values(?, ?, ?, ?)");
		
		state.setInt(1, 401);
		state.setString(2, "Computer Science");
		state.setString(3, "5152982801");
		state.setString(4, "LAS");
		state.executeUpdate();
		
		state.setInt(1, 402);
		state.setString(2, "Mathematics");
		state.setString(3, "5152982802");
		state.setString(4, "LAS");
		state.executeUpdate();
		
		
		state.setInt(1, 403);
		state.setString(2, "Chemical Engineering");
		state.setString(3, "5152982803");
		state.setString(4, "Engineerig");
		state.executeUpdate();
		
		
		state.setInt(1, 404);
		state.setString(2, "Landscape architect");
		state.setString(3, "5152982804");
		state.setString(4, "Design");
		state.executeUpdate();
		
		
		System.out.println("Departments Table rows updated");
	}
	
	private static void Insert_Degrees(Connection c) throws SQLException{
		PreparedStatement state = null;
		state = c.prepareStatement("Insert Into Degrees(name, level, department_code)" +
									"values(?, ?, ?)");
		
		
		state.setString(1, "Computer Science");
		state.setString(2, "BS");
		state.setInt(3, 401);
		state.executeUpdate();
		
		state.setString(1, "Software Engineering");
		state.setString(2, "BS");
		state.setInt(3, 401);
		state.executeUpdate();
		
		state.setString(1, "Computer Science");
		state.setString(2, "MS");
		state.setInt(3, 401);
		state.executeUpdate();
		
		state.setString(1, "Computer Science");
		state.setString(2, "PhD");
		state.setInt(3, 401);
		state.executeUpdate();
		
		state.setString(1, "Applied Mathematics");
		state.setString(2, "MS");
		state.setInt(3, 402);
		state.executeUpdate();
		
		state.setString(1, "Chemical Engineering");
		state.setString(2, "BS");
		state.setInt(3, 403);
		state.executeUpdate();
		
		state.setString(1, "Landscape Architect");
		state.setString(2, "BS");
		state.setInt(3, 404);
		state.executeUpdate();

		
		System.out.println("Degrees Table rows updated");

	}
	
	private static void Insert_Major(Connection c) throws SQLException{
		PreparedStatement state = null;
		state = c.prepareStatement("Insert Into Major(snum, name, level)" +
									"values(?, ?, ?)");
		
		state.setInt(1, 1001);
		state.setString(2, "Computer Science");
		state.setString(3, "BS");
		state.executeUpdate();
		
		state.setInt(1, 1002);
		state.setString(2, "Software Engineering");
		state.setString(3, "BS");
		state.executeUpdate();
		
		state.setInt(1, 1003);
		state.setString(2, "Chemical Engineering");
		state.setString(3, "BS");
		state.executeUpdate();
		
		state.setInt(1, 1004);
		state.setString(2, "Landscape Architect");
		state.setString(3, "BS");
		state.executeUpdate();
		
		state.setInt(1, 1005);
		state.setString(2, "Computer Science");
		state.setString(3, "MS");
		state.executeUpdate();
		
		state.setInt(1, 1006);
		state.setString(2, "Applied Mathematics");
		state.setString(3, "MS");
		state.executeUpdate();
		
		state.setInt(1, 1007);
		state.setString(2, "Computer Science");
		state.setString(3, "Phd");
		state.executeUpdate();
		
		
		System.out.println("Major Table rows updated");
	}
	
	private static void Insert_Minor(Connection c) throws SQLException{
		PreparedStatement state = null;
		state = c.prepareStatement("Insert Into Minor(snum, name, level)" +
									"values(?, ?, ?)");
		
		state.setInt(1, 1007);
		state.setString(2, "Applied Mathematics");
		state.setString(3, "MS");
		state.executeUpdate();
		
		state.setInt(1, 1005);
		state.setString(2, "Applied Mathematics");
		state.setString(3, "MS");
		state.executeUpdate();
		
		state.setInt(1, 1001);
		state.setString(2, "Software Engineering");
		state.setString(3, "BS");
		state.executeUpdate();
		
		System.out.println("Minor Table rows updated");
	}

	private static void Insert_Courses(Connection c) throws SQLException{
		PreparedStatement state = null;
		state = c.prepareStatement("Insert Into Courses(number_course, name_course, description, credithours, level_course, department_code)" +
									"values(?, ?, ?, ?, ?, ?)");
		
		state.setInt(1, 113);
		state.setString(2, "Spreadsheet");
		state.setString(3, "MicrosoftExcel and Access");
		state.setInt(4, 3);
		state.setString(5, "Undergraduate");
		state.setInt(6, 401);
		state.executeUpdate();
		
		state.setInt(1, 311);
		state.setString(2, "Algorithm");
		state.setString(3, "Design and Analysis");
		state.setInt(4, 3);
		state.setString(5, "Undergraduate");
		state.setInt(6, 401);
		state.executeUpdate();
		
		
		state.setInt(1, 531);
		state.setString(2, "Theory of Computation");
		state.setString(3, "Theory and Probability");
		state.setInt(4, 3);
		state.setString(5, "Graduate");
		state.setInt(6, 401);
		state.executeUpdate();
		
		
		state.setInt(1, 363);
		state.setString(2, "Database");
		state.setString(3, "Design Principle");
		state.setInt(4, 3);
		state.setString(5, "Undergraduate");
		state.setInt(6, 401);
		state.executeUpdate();
		
		
		state.setInt(1, 412);
		state.setString(2, "Water Management");
		state.setString(3, "Water Management");
		state.setInt(4, 3);
		state.setString(5, "Undergraduate");
		state.setInt(6, 404);
		state.executeUpdate();
		
		
		state.setInt(1, 228);
		state.setString(2, "Special Topics");
		state.setString(3, "Interesting Topics about CE");
		state.setInt(4, 3);
		state.setString(5, "Undergraduate");
		state.setInt(6, 403);
		state.executeUpdate();
		
		
		state.setInt(1, 101);
		state.setString(2, "Calculus");
		state.setString(3, "Limit and Derivative");
		state.setInt(4, 4);
		state.setString(5, "Undergraduate");
		state.setInt(6, 402);
		state.executeUpdate();
		
		
		System.out.println("Courses Table rows updated");
	}
	

	private static void Insert_Register(Connection c) throws SQLException{
		PreparedStatement state = null;
		state = c.prepareStatement("Insert Into Register(snum, course_number, regtime, grade)" +
									"values(?, ?, ?, ?)");
		
		state.setInt(1, 1001);
		state.setInt(2, 363);
		state.setString(3, "Fall2015");
		state.setInt(4, 3);
		state.executeUpdate();

		state.setInt(1, 1002);
		state.setInt(2, 311);
		state.setString(3, "Fall2015");
		state.setInt(4, 4);
		state.executeUpdate();
		
		state.setInt(1, 1003);
		state.setInt(2, 228);
		state.setString(3, "Fall2015");
		state.setInt(4, 4);
		state.executeUpdate();
		
		state.setInt(1, 1004);
		state.setInt(2, 363);
		state.setString(3, "Spring2015");
		state.setInt(4, 4);
		state.executeUpdate();
		
		state.setInt(1, 1005);
		state.setInt(2, 531);
		state.setString(3, "Spring2015");
		state.setInt(4, 4);
		state.executeUpdate();
		
		state.setInt(1, 1006);
		state.setInt(2, 363);
		state.setString(3, "Fall2015");
		state.setInt(4, 3);
		state.executeUpdate();
		
		state.setInt(1, 1007);
		state.setInt(2, 531);
		state.setString(3, "Spring2015");
		state.setInt(4, 4);
		state.executeUpdate();
		

		System.out.println("Register Table rows updated");
	}

}
