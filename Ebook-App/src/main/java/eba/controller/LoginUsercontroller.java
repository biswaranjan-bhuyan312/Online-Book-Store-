package eba.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import eba.dao.UserDao;
import eba.model.User;

/**
 * Servlet implementation class LoginUsercontroller
 */
@WebServlet("/login")
public class LoginUsercontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginUsercontroller() {
        super();
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
		// TODO Auto-generated method stub
//		
		try {
			UserDao userDao =new UserDao();
			HttpSession session = request.getSession();
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			
			if("admin@gmail.com".equals(email) && "admin".equals(password)) {
				User us = new User();
				session.setAttribute("userobj", us);
				response.sendRedirect("admin/home.jsp");
			}else {
				User us = userDao.loginUser(email, password);
				if(us!=null) {
					session.setAttribute("userobj", us);
					response.sendRedirect("home.jsp");
				}else {
					session.setAttribute("failedmsg", "Invalid email and password");
					response.sendRedirect("login.jsp");
				}
				response.sendRedirect("home.jsp");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
