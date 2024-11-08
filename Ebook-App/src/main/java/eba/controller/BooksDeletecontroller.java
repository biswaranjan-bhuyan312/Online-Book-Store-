package eba.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import eba.dao.AddBookDao;

/**
 * Servlet implementation class BooksDeletecontroller
 */
@WebServlet("/delete")
public class BooksDeletecontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BooksDeletecontroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int id= Integer.parseInt(request.getParameter("id"));
			AddBookDao addbookdao = new AddBookDao();
			boolean f = addbookdao.deleteBooks(id);
			HttpSession session = request.getSession();
			if(f) {
				session.setAttribute("Succmsg", "Book Deleted Successfully");
				response.sendRedirect("admin/all_books.jsp");
			}else {
				session.setAttribute("failedmsg", "Something went Wrong");
				response.sendRedirect("admin/all_books.jsp");
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
