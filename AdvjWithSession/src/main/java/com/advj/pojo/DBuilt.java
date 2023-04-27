package com.advj.pojo;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBuilt {
public static Connection getMySQLConnection()
{
	Connection con=null;
	try {
	Class.forName("com.mysql.cj.jdbc.Driver");
	con= DriverManager.getConnection("jdbc:mysql://localhost:3306/advjjava", "root", "root");
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	return con;
}
}
