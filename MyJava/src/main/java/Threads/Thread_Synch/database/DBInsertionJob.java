package Threads.Thread_Synch.database;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;


public class DBInsertionJob implements Runnable{
	Connection conn=null;
	public void run() {

		PreparedStatement ps=null;
		try{
			conn=DBCommon.getConnection();
			int jobLength=2000000/2;
			ps = (PreparedStatement) conn.prepareStatement("insert into employee values(?, ?, ?, ?)");
			int threadId=Integer.parseInt(Thread.currentThread().getName());
			int minOffSet=threadId*jobLength;
			int maxOffSet=(threadId+1)*jobLength;
			long start= System.currentTimeMillis();
			for(int i=minOffSet;i<maxOffSet;i++){
				ps.setInt(1,i);
				String name=getName(10);
				if(name!=null){
					ps.setString(2, name);
					ps.setString(3, name+"@gmail.com");
				}
				String mobile=String.valueOf(getMobile());
				if(mobile!=null){
					ps.setString(4, String.valueOf(getMobile()));
				}
				
				ps.execute();
			}
			long end= System.currentTimeMillis();
			System.out.println("tme taken to insert by thread  "+threadId+"  is:  "+(end-start));

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
