package com.pth.model;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    static final String CHECKACOUNT = "SELECT userid, userpw FROM user WHERE userid = ? AND userpw = ?";
	Connection conn = null;
    
    public LoginServlet() {
    }

	public void init(ServletConfig config) throws ServletException {
    	System.out.println("SelectServlet 초기화");
    	
		String url = "jdbc:mysql://localhost:3306/jspservlet?serverTimezone=Asia/Seoul";
		String username = "root";
		String password = "asd123";
    	
    	try { 
    		Class.forName("com.mysql.cj.jdbc.Driver");
    		conn = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException | SQLException e) {
			throw new ServletException("JDBC 드라이버를 찾을 수 없습니다", e);
		}
	}

	public void destroy() {
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		try {
			String userid = request.getParameter("userid");
			String userpw = request.getParameter("userpw");
			PreparedStatement ptmt = conn.prepareStatement(CHECKACOUNT);
			ptmt.setString(1, userid);
			ptmt.setString(2, userpw);
			
			ResultSet rs = ptmt.executeQuery();
			
			if(rs.next()) {
				// Javascript 팝업
				response.sendRedirect("petition.jsp");
			} else {
				// Javascript 팝업
				response.sendRedirect("login.jsp");
			}
			
		} catch (Exception e) {

		}
		
	}
	

}
