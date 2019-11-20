package com.project.thebooklender.utility;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
		
		public DBConnection() {}
		
		public java.sql.Connection getDBConnection(){
			String logHead="DBConnection.class :: getDBConnection() :: ";
			Connection con=null;
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://db4free.net:3306/booklender?autoReconnect=true&useSSL=false", "spebooklender", "8a314486");
				System.out.println(logHead+" Mysql Connection Created Successfully ..");
			}catch(Exception e) {
				System.out.println(logHead+" Exception while Creating mysql Conection .. "+e);
			}
			return con;
		}
}
