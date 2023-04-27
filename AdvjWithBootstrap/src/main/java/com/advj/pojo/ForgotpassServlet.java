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

@WebServlet("/ForgotpassServlet")
public class ForgotpassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		Connection con=DBuilt.getMySQLConnection();
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		try {
			PreparedStatement ps=con.prepareStatement("update advjjava.login set password=? where email=?");
			ps.setString(2,email);
			ps.setString(1, password);
			int i=ps.executeUpdate();
			RequestDispatcher rd = null;
			if(i>0)
			{
				System.out.println("password change");
				response.sendRedirect("index.jsp");
			}
			else
			{System.out.println("not chanege");
			request.setAttribute("errormessage","password can't change");
			rd = request.getRequestDispatcher("Forgotpass.jsp");
			rd.forward(request, response);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

}
