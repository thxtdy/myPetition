package com.pth.model;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/signin")
public class SigninServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public SigninServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String userid = request.getParameter("userid");
        String userpw = request.getParameter("userpw");
        String checkpw = request.getParameter("confirm-password");

        if (!userpw.equals(checkpw)) {
            response.sendRedirect("result.jsp?message=password-mismatch");
            return;
        }

        try (Connection conn = DBConnect.getConnection()) {
            String selectQuery = "SELECT userid FROM user WHERE userid = ?";
            PreparedStatement checkptmt = conn.prepareStatement(selectQuery);
            checkptmt.setString(1, userid);
            ResultSet rs = checkptmt.executeQuery();

            if (!rs.next()) { // 아이디가 중복되지 않을 때
                String insertQuery = "INSERT INTO user(username, email, userid, userpw) VALUES (?, ?, ?, ?)";
                PreparedStatement insertptmt = conn.prepareStatement(insertQuery);
                insertptmt.setString(1, username);
                insertptmt.setString(2, email);
                insertptmt.setString(3, userid);
                insertptmt.setString(4, userpw);

                conn.setAutoCommit(false); // 트랜잭션 시작
                int rowCount = insertptmt.executeUpdate();

                if (rowCount > 0) { // Query가 정상작동이 되었다면
                    conn.commit();
                    response.sendRedirect("result.jsp?message=sign-success");
                } else {
                    conn.rollback();
                    response.sendRedirect("result.jsp?message=error");
                }

                insertptmt.close();
            } else {
                response.sendRedirect("result.jsp?message=sign-fail");
            }

            rs.close();
            checkptmt.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServletException("연결 오류", e);
        }
    }
}