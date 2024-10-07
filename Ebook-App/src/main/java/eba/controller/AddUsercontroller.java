package eba.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import eba.model.User;
import eba.dao.UserDao;


/**
 * Servlet implementation class AddUsercontroller
 */
@WebServlet("/register")
public class AddUsercontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddUsercontroller() {
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
		// retrieve all parameter value
				User user = new User();
				user.setName(request.getParameter("name"));
				user.setEmail(request.getParameter("email"));
				user.setPhn_no(request.getParameter("phn_no"));
				user.setPassword(request.getParameter("password"));
				
				UserDao userDao =new UserDao();
				if(userDao.addUser(user)) {
					request.setAttribute("Succmsg", "Registration Successful");
				}else {
					request.setAttribute("failedmsg", "There is some issues");
				}
				
				request.getRequestDispatcher("register.jsp").forward(request, response);
			}

	}


