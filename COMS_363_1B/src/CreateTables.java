import java.sql.*;

public class CreateTables {
	
	public static void main(String[] args) throws SQLException{
		Connection conn = null;
		conn = getConnection();
		System.out.println("Connection Established");
		
		Create__Students_Table(conn);
		Create__Departments_Table(conn);
		Create__Degrees_Table(conn);
		Create__Courses_Table(conn);
		Create__Register_Table(conn);
		Create__Majors_Table(conn);
		Create_Minors_Table(conn);
		
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
	
	private static void Create__Students_Table(Connection c) throws SQLException{
		Statement state = c.createStatement();
		
		String students = "CREATE TABLE IF NOT EXISTS Students " +
							"(snum int, " +
							"ssn int, " +
							"name varchar(10), " +
							"gender varchar(1), " +
							"dob DATETIME, " +
							"c_addr varchar(20), " +
							"c_phone varchar(10), " +
							"p_addr varchar(20), " +
							"p_phone varchar(10), " +
							"PRIMARY KEY (ssn), " +
							"UNIQUE (snum)) ";
		state.executeUpdate(students);
		System.out.println("students table created");
	}
		
		
	private static void Create__Departments_Table(Connection c) throws SQLException{
		Statement state = null;
		state = c.createStatement();
		
		String departments = "CREATE TABLE IF NOT EXISTS Departments" +
							"(code int, " +
							"name varchar(50), " +
							"phone varchar(10), " +
							"college varchar(20), " +
							"PRIMARY KEY(code), " +
							"UNIQUE(name)) ";
		state.executeUpdate(departments);
		System.out.println("departments table created");
	}
	
	private static void Create__Degrees_Table(Connection c) throws SQLException{
		Statement state = null;
		state = c.createStatement();

		String degrees = "CREATE TABLE IF NOT EXISTS Degrees" +
							"(name varchar(50), " +
							"level varchar(5), " +
							"department_code int, " +
							"PRIMARY KEY(name, level), " +
							"CONSTRAINT degrees_dept_code FOREIGN KEY(department_code) REFERENCES departments(code)) ";
		state.executeUpdate(degrees);
		System.out.println("degrees table created");
	}
	
	private static void Create__Courses_Table(Connection c) throws SQLException{
		Statement state = null;
		state = c.createStatement();
		String courses = "CREATE TABLE IF NOT EXISTS Courses" +
							"(number_course int, " +
							"name_course varchar(50), " +
							"description varchar(50), " +
							"credithours int, " +
							"level_course varchar(20), " +
							"department_code int, " +
							"PRIMARY KEY (number_course), " +
							"UNIQUE (name_course), " +
							"CONSTRAINT courses_dept_code FOREIGN KEY (department_code) REFERENCES departments(code)) ";
		state.executeUpdate(courses);
		System.out.println("courses table created");
	}
		
	private static void Create__Register_Table(Connection c) throws SQLException{
		Statement state = null;
		state = c.createStatement();

		String register = "CREATE TABLE IF NOT EXISTS Register" +
							"(snum int, " +
							"course_number int, " +
							"regtime varchar(20), " +
							"grade int, " +
							"PRIMARY KEY(snum, course_number), " +
							"CONSTRAINT REGISTER_SNUM FOREIGN KEY(snum) REFERENCES students(snum), " +
							"CONSTRAINT REGISTER_COURSE_NUM FOREIGN KEY (course_number) REFERENCES courses(number))";
		state.executeUpdate(register);
		System.out.println("register table created");
	}
	
	private static void Create__Majors_Table(Connection c) throws SQLException{
	
		Statement state = null;
		state = c.createStatement();
		
		String major = "CREATE TABLE IF NOT EXISTS Major" +
							"(snum int, " +
							"name varchar(50), " +
							"level varchar(5), " +
							"PRIMARY KEY(snum, name, level), " +
							"CONSTRAINT major_snum FOREIGN KEY(snum) REFERENCES students(snum), " +
							"CONSTRAINT major_name_level FOREIGN KEY(name, level) REFERENCES Degrees(name, level))";
		state.executeUpdate(major);
		System.out.println("major table created");
	}
	
	private static void Create_Minors_Table(Connection c) throws SQLException{
		Statement state = null;
		state = c.createStatement();

		String minor = "CREATE TABLE IF NOT EXISTS Minor" +
							"(snum int, " +
							"name varchar(50), " +
							"level varchar(5), " +
							"PRIMARY KEY(snum, name, level), " +
							"CONSTRAINT minor_snum FOREIGN KEY(snum) REFERENCES students(snum), " +
							"CONSTRAINT minor_name_level FOREIGN KEY(name, level) REFERENCES Degrees(name, level)) ";
		state.executeUpdate(minor);
		System.out.println("minor table created");
	}

		
	
}
