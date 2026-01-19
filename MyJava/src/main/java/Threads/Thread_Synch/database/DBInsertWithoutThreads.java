package Threads.Thread_Synch.database;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;


public class DBInsertWithoutThreads {
	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost/mydb";

	//  Database credentials
	static final String USER = "root";
	static final String PASS = "test123";

	public static void main(String[] args) {
		Connection conn = null;
		//Statement stmt = null;
		PreparedStatement ps=null;
		try{
			//STEP 2: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");

			//STEP 3: Open a connection
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL,USER,PASS);

			//STEP 4: Execute a query
			System.out.println("Creating statement...");
			ps = (PreparedStatement) conn.prepareStatement("insert into employee values(?, ?, ?, ?)");
			String sql;
			long start= System.currentTimeMillis();
			for(int i=0;i<2000000;i++){
				ps.setInt(1,i);
				String name=getName(10);
				ps.setString(2, name);
				ps.setString(3, name+"@gmail.com");
				//System.out.println(String.valueOf(getMobile()));
				ps.setString(4, String.valueOf(getMobile()));
				ps.execute();
			}
			long end= System.currentTimeMillis();
			System.out.println("tme takeen to insert 1 million records:  "+(end-start));

			//STEP 5: Extract data from result set
			/*while(rs.next()){
				//Retrieve by column name
				int id  = rs.getInt("employeeNumber");
				String lastName = rs.getString("lastName");
				String firstName = rs.getString("firstName");
				String email = rs.getString("email");

				//Display values
				System.out.print("ID: " + id);
				System.out.print(", Last Name: " + lastName);
				System.out.print(", First Name: " + firstName);
				System.out.println(", email: " + email);
			}*/
			//STEP 6: Clean-up environment
			//rs.close();
			ps.close();
			conn.close();
		}catch(SQLException se){
			//Handle errors for JDBC
			se.printStackTrace();
		}catch(Exception e){
			//Handle errors for Class.forName
			e.printStackTrace();
		}finally{
			//finally block used to close resources
			try{
				if(ps!=null)
					ps.close();
			}catch(SQLException se2){
			}// nothing we can do
			try{
				if(conn!=null)
					conn.close();
			}catch(SQLException se){
				se.printStackTrace();
			}//end finally try
		}//end try
		System.out.println("Goodbye!");
	}//end main

	private static String getName(int len){

		String str = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		Random rnd = new Random();
		StringBuilder sb = new StringBuilder( len );
		for( int i = 0; i < len; i++ ) 
			sb.append( str.charAt( rnd.nextInt(str.length()) ) );
		return sb.toString();

	}
	
	private static BigInteger getMobile(){
		Random rng = new Random(); 
		return BigInteger.valueOf(rng.nextInt(2147483647));

	}

}
