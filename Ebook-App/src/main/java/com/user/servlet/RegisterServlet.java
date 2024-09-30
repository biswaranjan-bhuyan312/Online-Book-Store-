package com.user.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.UserDAOImpl;
import com.DB.DBConnect;
import com.entity.User;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public RegisterServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// retrieve all parameter value
		try {
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String phn_no = request.getParameter("phn_no");
			String password = request.getParameter("password");
			String check = request.getParameter("check");
			
			User us = new User();
			us.setName(name);
			us.setEmail(email);
			us.setPhn_no(phn_no);
			us.setPassword(password);
			
			UserDAOImpl dao = new UserDAOImpl(DBConnect.getconn());
			boolean f = dao.userRegistration(us);
			if(f) {
				System.out.println("Register Success");
			}else {
				System.out.println("Somthing Went Wrong");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		doGet(request, response);
	}

}
