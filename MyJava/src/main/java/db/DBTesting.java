package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Threads.Thread_Synch.database.DBCommon;

public class DBTesting {

	public DBTesting() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		
		try {
			while(true){
			Connection con=DBCommon.getConnection();
			PreparedStatement ps=con.prepareStatement("select name from student");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				System.out.println(rs.getString(1));
			}
			System.out.println("###################");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		
		
	}
	
}
