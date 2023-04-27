package com.advj.pojo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection con=DBuilt.getMySQLConnection();
		try {
			String uname=request.getParameter("uname");
			String email=request.getParameter("email");
			String password=request.getParameter("password");
			
			PreparedStatement ps=con.prepareStatement("insert into advjjava.login(username,email,password)values(?,?,?)");
			ps.setString(1,uname);
			ps.setString(2,email);
			ps.setString(3,password);
			int rowcount=ps.executeUpdate();
			RequestDispatcher rd = null;
			if(rowcount > 0) {
				request.setAttribute("status", "success");
				}
			else {
				request.setAttribute("satus", "failed");
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

}
