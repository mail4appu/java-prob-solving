package Threads.Thread_Synch.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 * @author Test
 * 
 * With prepared statement we can prevent sql injection prevention
 * 
 * how?
 * example: user input="'VO6IC0LY1O' or '1'='1';
 * 
 * query with statement: "select * from employee where name="+input;
 *                        select * from employee where name='VO6IC0LY1O' or '1'='1';
 *  here it selects all the records from table.
 * 
 * Query with prepared statement: select *  from employee where  name='\'VO6IC0LY1O\' or \'1\'=\'1\'' 
 * 
 * To understand it better,
 * 
 * prepared statement query is sent to server right after we create the prepared statement.
 * 
 * At later point of time, inputs are sent. i.e query and inputs are sent at two different times.
 * 
 * i.e we are giving the input to the already prepared product.
 * i.e the query will not be re constructed again. 
 * 
 * i.e here the input is the entire string: '\'VO6IC0LY1O\' or \'1\'=\'1\''. not the part of the string.
 * so we dont get any matching records
 * 
 *  where as with statement query is reconstructed with input submission, the query looks different.
 *  More over prepared statement escapes the single quotes and treats input to a placeholder as single entity.
 * 
 * if the input is "VO6IC0LY1O;drop table employee"
 * 
 * statement query :     select * from employee where name='VO6IC0LY1O' ; drop table employee;
 * Prepared statement query :   select * from employee where name='VO6IC0LY1O ; drop table employee'; 
 * here input is grouped as one entity by surrounding the total string with single quotes and user given single quotes are escaped.
 * And as it does not reconstruct the query, it executes the already compiled query with given inputs.
 * 
 * So we dont get any matching records here
 * 
 * 
 * PreparedStatment is just an interface in java.sql package. 
 * Its implementation is given by the driver jar we use.
 * 
 * It is the responsibility of the Driver jar to give the implementation to this interface
 * 
 * 
 *
 */
public class SQLinjectionPrevention {
	
	static Connection conn = null;
		public static void main(String[] args) {
		PreparedStatement ps=null;
		List<String> mobiles= new ArrayList<String>();
		try{
           long start= System.currentTimeMillis();
			conn = DBCommon.getConnection();

			//STEP 4: Execute a query
			ps = (PreparedStatement) conn.prepareStatement("select *  from employee where  name=? ");
			//int threadId=Integer.parseInt(Thread.currentThread().getName());
			String  input="'VO6IC0LY1O' or '1'='1'";
			ps.setString(1, input);
			//ps.setInt(2, 1999999);
			ResultSet rs=ps.executeQuery();
			int count=0;
			while(rs.next()){
				String mobile=rs.getString(4);
				mobiles.add(mobile);
				count=getNoOfCustomers(mobile, count);
			}
			System.out.println(ps.toString());
			long end= System.currentTimeMillis();
			System.out.println(" Time taken: "+(end-start)+"   NO fo customers selected"+count+"    Mobiles size: "+mobiles.size());
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
			}
		}
	}
	
	private static int getNoOfCustomers(String customer, int count){
		
		if(customer!=null){
			 count++;
		}
		return count++;
	}
}