package com.advj.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// check connectivity using @WebServlet
		System.out.println("login controllar called");
		// step 1:get data from jsp form
		String email = request.getParameter("email");
		String pass = request.getParameter("password");
		System.out.println(email);
		System.out.println(pass);
		RequestDispatcher rd = null;
		if (email.equals(pass)) {
			System.out.println("login success go to dashboard");
			response.sendRedirect("dashboard.jsp");
		} else {
			request.setAttribute("errormessage", "Invalid check once");
			rd = request.getRequestDispatcher("index.jsp");
			System.out.println("error check it");
			rd.forward(request, response);
		}
	}

}
