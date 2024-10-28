package eba.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import eba.model.BookDtls;
import eba.model.User;


public class AddBookDao {
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://@localhost:3306/ebook-app","root","biswa463");
	}
	
	public boolean addBook(BookDtls book) {
		boolean flag = false;
		Connection con = null;
		PreparedStatement st =null;
		try {
			con=UserDao.getConnection();
			st =con.prepareStatement("insert into book_dtls(bookname,author,price,bookCatagory,status,photo,email) values(?,?,?,?,?,?,?)");
			st.setString(1, book.getBookname());
			st.setString(2, book.getAuthor());
			st.setString(3, book.getPrice());
			st.setString(4, book.getBookCatagory());
			st.setString(5, book.getStatus());
			st.setString(6, book.getPhotoName());
			st.setString(7, book.getEmail());
			
			if(st.executeUpdate()==1) {
				flag = true;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}finally{
			try {
                if (st != null) {
                    st.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
		}
		return flag;
	}
	
	public List<BookDtls> getBook() {
		List<BookDtls> list = new ArrayList<BookDtls>();
		BookDtls book = null;
		Connection con = null;
		PreparedStatement st = null;
		try {
			con=UserDao.getConnection();
			st =con.prepareStatement("select * from book_dtls");
//			st.setString(1, email);
//			st.setString(2, password);
			
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				book = new BookDtls();
				book.setBookId(rs.getInt(1));
				book.setBookname(rs.getString(2));
				book.setAuthor(rs.getString(3));
				book.setPrice(rs.getString(5));
				book.setBookCatagory(rs.getString(6));
				book.setStatus(rs.getString(7));
				book.setPhotoName(rs.getString(8));
				book.setEmail(rs.getString(9));
				list.add(book);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}
public BookDtls getBookById(int id) {
		
		BookDtls book = null;
		Connection con = null;
		PreparedStatement st = null;
		try {
			con=AddBookDao.getConnection();
			st =con.prepareStatement("select * from book_dtls where bookId=?");
			st.setInt(1, id);
			
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				book = new BookDtls();
				book.setBookId(rs.getInt(1));
				book.setBookname(rs.getString(2));
				book.setAuthor(rs.getString(3));
				book.setPrice(rs.getString(4));
				book.setBookCatagory(rs.getString(5));
				book.setStatus(rs.getString(6));
				book.setPhotoName(rs.getString(7));
				book.setEmail(rs.getString(8));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return book;
	}
	
public boolean updateEditBooks(BookDtls book) {
		
		boolean f  = false;
		Connection con = null;
		PreparedStatement st = null;
		try {
			con=AddBookDao.getConnection();
			st =con.prepareStatement("update book_dtls set bookname=?,author=?,price=?,status=? where bookId=?");
			st.setString(1,book.getBookname());
			st.setString(2, book.getAuthor());
			st.setString(3, book.getPrice());
			st.setString(4, book.getStatus());
			st.setInt(5, book.getBookId());
			
			int i= st.executeUpdate();
			if(i==1)
			{
				f=true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return f;
	}

public boolean deleteBooks(int id) {
	
	boolean f  = false;
	Connection con = null;
	PreparedStatement st = null;
	try {
		con=AddBookDao.getConnection();
		st =con.prepareStatement("delete from book_dtls where bookId=?");
		st.setInt(1, id);
		int i= st.executeUpdate();
		if(i==1)
		{
			f=true;
		}
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	return f;
}
}
