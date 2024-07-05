package com.pth.controller;

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

import com.mysql.cj.protocol.Resultset;

/**
 * Servlet implementation class checkId
 */
@WebServlet("/CheckServlet")
public class CheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection conn = null;
	final String CHECKQUERY = "SELECT userid FROM users WHERE userid = ?";

	public CheckServlet() {
	}

	public void init(ServletConfig config) throws ServletException {
		System.out.println("InsertServlet 초기화");

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

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		try {
			String userid = request.getParameter("userid");
			System.out.println(userid);
			PreparedStatement ptmt = conn.prepareStatement(CHECKQUERY);
			ptmt.setString(1, userid);
			
			ResultSet rs = ptmt.executeQuery();
			
			if(rs.next()) {
				response.getWriter().println("<script>alert('사용 가능한 ID 입니다.'); location.href='"+"signin.jsp" +"';</script>");
			} else {
				response.getWriter().println("<script>alert('중복된 ID 입니다.'); location.href='"+"signin.jsp" +"';</script>");
			}
			request.getRequestDispatcher("signin.jsp").forward(request, response);
			
			ptmt.close();
			conn.close();
			
			
		} catch (SQLException e) {
			response.sendRedirect("CheckServlet.jsp?message=error");
		}
		
		
		
	}

}
