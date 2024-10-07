package eba.controller;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import eba.dao.AddBookDao;
import eba.model.BookDtls;

/**
 * Servlet implementation class BooksAdd
 */
@WebServlet("/add_Books")
@MultipartConfig
public class BooksAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BooksAdd() {
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
		try {
		BookDtls bd = new BookDtls();
		bd.setBookname(request.getParameter("bname"));
		bd.setAuthor(request.getParameter("author"));
		bd.setPrice(request.getParameter("price"));
		bd.setBookCatagory(request.getParameter("btype"));
		bd.setStatus(request.getParameter("bstatus"));
		 Part part = request.getPart("bimg");
		    String fileName = part.getSubmittedFileName(); // Get file name
		    bd.setPhotoName(fileName);
		   
		AddBookDao addbookDao =new AddBookDao();
		HttpSession session = request.getSession();
		if(addbookDao.addBook(bd)) {
			String path = getServletContext().getRealPath("")+"Book";		
		    File file = new File(path);
		    part.write(path + File.separator + fileName);
			session.setAttribute("Succmsg", "Books Added SuccessFully");
			response.sendRedirect("admin/add_books.jsp");
		}else {
			session.setAttribute("failedmsg", "There is some issues");
			response.sendRedirect("admin/add_books.jsp");
		}
		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
