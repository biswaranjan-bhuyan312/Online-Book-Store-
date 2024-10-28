package eba.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import eba.dao.AddBookDao;
import eba.model.BookDtls;

/**
 * Servlet implementation class Editcontroller
 */
@WebServlet("/edit_Books")
public class Editcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Editcontroller() {
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
		try {
			int id= Integer.parseInt(request.getParameter("id"));
			String bookName= request.getParameter("bname");
			String author= request.getParameter("author");
			String price = request.getParameter("price");
			String status = request.getParameter("status");
			
			BookDtls book = new BookDtls();
			book.setBookId(id);
			book.setBookname(bookName);
			book.setAuthor(author);
			book.setPrice(price);
			book.setStatus(status);
			
			AddBookDao addbookdao = new AddBookDao();
			boolean f = addbookdao.updateEditBooks(book);
			HttpSession session = request.getSession();
			if(f) {
				session.setAttribute("Succmsg", "Book Updated Successfully");
				response.sendRedirect("admin/all_books.jsp");
			}else {
				session.setAttribute("failedmsg", "Something went Wrong");
				response.sendRedirect("admin/all_books.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
