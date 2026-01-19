package Threads.Thread_Synch.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class DBSelectWithoutThreads {
	
	static Connection conn = null;
		public static void main(String[] args) {
		PreparedStatement ps=null;
		List<String> mobiles= new ArrayList<String>();
		try{
           long start= System.currentTimeMillis();
			conn = DBCommon.getConnection();

			//STEP 4: Execute a query
			ps = (PreparedStatement) conn.prepareStatement("select *  from employee where  id between ? and ? ");
			//int threadId=Integer.parseInt(Thread.currentThread().getName());
			ps.setInt(1, 0);
			ps.setInt(2, 1999999);
			ResultSet rs=ps.executeQuery();
			int count=0;
			while(rs.next()){
				String mobile=rs.getString(4);
				mobiles.add(mobile);
				count=getNoOfCustomers(mobile, count);
			}
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