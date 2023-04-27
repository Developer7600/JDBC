package com.advj.pojo;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/LoginController")//annotation
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Login controller called");
		//database connectivity
		Connection con=DBuilt.getMySQLConnection();
		System.out.println("connection successful");
		// step 1:get data from jsp form
		try {
			PreparedStatement ps=con.prepareStatement("select * from advjjava.login where email=? and password=?;");
		ps.setString(1,request.getParameter("email"));
		ps.setString(2,request.getParameter("password"));
		ResultSet rs=ps.executeQuery();
		//System.out.println(email);
		//System.out.println(pass);
		RequestDispatcher rd = null;
		if (rs.next()) {
			System.out.println("login success go to dashboard");
			response.sendRedirect("dashboard.jsp");
		} else {
			request.setAttribute("errormessage", "Invalid email and password");
			rd = request.getRequestDispatcher("index.jsp");
			System.out.println("error check it");
			rd.forward(request, response);
		}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	}


