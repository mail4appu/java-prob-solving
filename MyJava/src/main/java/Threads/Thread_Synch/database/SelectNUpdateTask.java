//package Threads.Thread_Synch.database;
//
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//import com.mysql.jdbc.Connection;
//
//public class SelectNUpdateTask implements Runnable {
//
//	@Override
//	public void run() {
//		System.out.println(Thread.currentThread().getName()+" :  is executing ");
//	   Connection con=(Connection) DBCommon.getConnection();
//	   String sql= "select status from student where name=?";
//	   String updateSql="update student set status=? where name=?";
//	   try {
//		PreparedStatement ps =con.prepareStatement(sql);
//		ps.setString(1, "appu");;
//		ResultSet rs=ps.executeQuery();
//		while(rs.next()){
//			String status=rs.getString(1);
//			System.out.println("status by "+Thread.currentThread().getName()+" : "+status);
//			ps=con.prepareStatement(updateSql);
//			ps.setString(1, status+" : "+Thread.currentThread().getName());
//			ps.setString(2, "appu");
//			ps.execute();
//		}
//
//
//	} catch (SQLException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//	catch(Exception ex){
//		ex.printStackTrace();
//	}
//
//
//	}
//
//}
