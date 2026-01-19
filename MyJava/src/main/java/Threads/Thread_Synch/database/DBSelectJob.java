/*package Threads.Thread_Synch.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//import com.mysql.jdbc.PreparedStatement;

public class DBSelectJob implements Runnable{

	Connection conn=null;
	public void run() {

		List<String> mobiles= new ArrayList<String>();

		//PreparedStatement ps=null;
		try{
			conn=DBCommon.getConnection();
			int jobLength=2000000/4;
			//ps = (PreparedStatement) conn.prepareStatement("select * from employee where  id between ? and ? ");
			int threadId=Integer.parseInt(Thread.currentThread().getName());
			ps.setInt(1, threadId*jobLength);
			ps.setInt(2, (threadId+1)*jobLength);
			ResultSet rs=ps.executeQuery();
			int count=0;
			while(rs.next()){
				String mobile=rs.getString(4);
				mobiles.add(mobile);
				count=getNoOfCustomers(mobile, count);

			}
			System.out.println("no of customers  selected "+count+" mobiles size"+mobiles.size());

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




	}

	private int getNoOfCustomers(String customer, int count){
		if(customer!=null){
			count++;
		}
		return count++;
	}
}
*/