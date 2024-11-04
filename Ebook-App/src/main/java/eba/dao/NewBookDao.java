package eba.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import eba.model.BookDtls;

public class NewBookDao {
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://@localhost:3306/ebook-app","root","biswa463");
	}
	
	public List<BookDtls> getNewBook() {
		List<BookDtls> list = new ArrayList<BookDtls>();
		BookDtls book = null;
		Connection con = null;
		PreparedStatement st = null;
		
		try {
			con=AddBookDao.getConnection();
			st =con.prepareStatement("select * from book_dtls where bookCatagory=? order by bookId DESC");
			st.setString(1, "new");
			ResultSet rs = st.executeQuery();
			int i=1;
			while (rs.next() && i<=4) {
				book = new BookDtls();
				book.setBookId(rs.getInt(1));
				book.setBookname(rs.getString(2));
				book.setAuthor(rs.getString(3));
				book.setPrice(rs.getString(4));
				book.setBookCatagory(rs.getString(5));
				book.setStatus(rs.getString(6));
				book.setPhotoName(rs.getString(7));
				book.setEmail(rs.getString(8));
				list.add(book);
				i++;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}
	
	public List<BookDtls> getRecentBook() {
		List<BookDtls> list = new ArrayList<BookDtls>();
		BookDtls book = null;
		Connection con = null;
		PreparedStatement st = null;
		
		try {
			con=AddBookDao.getConnection();
			st =con.prepareStatement("select * from book_dtls where bookCatagory=? order by bookId ASC");
			st.setString(1, "new");
			ResultSet rs = st.executeQuery();
			int i=1;
			while (rs.next() && i<=4) {
				book = new BookDtls();
				book.setBookId(rs.getInt(1));
				book.setBookname(rs.getString(2));
				book.setAuthor(rs.getString(3));
				book.setPrice(rs.getString(4));
				book.setBookCatagory(rs.getString(5));
				book.setStatus(rs.getString(6));
				book.setPhotoName(rs.getString(7));
				book.setEmail(rs.getString(8));
				list.add(book);
				i++;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}
	
	public List<BookDtls> getNoteworthy() {
		List<BookDtls> list = new ArrayList<BookDtls>();
		BookDtls book = null;
		Connection con = null;
		PreparedStatement st = null;
		
		try {
			con=AddBookDao.getConnection();
			st =con.prepareStatement("select * from book_dtls where bookCatagory=? order by price ASC");
			st.setString(1, "new");
			ResultSet rs = st.executeQuery();
			int i=1;
			while (rs.next() && i<=4) {
				book = new BookDtls();
				book.setBookId(rs.getInt(1));
				book.setBookname(rs.getString(2));
				book.setAuthor(rs.getString(3));
				book.setPrice(rs.getString(4));
				book.setBookCatagory(rs.getString(5));
				book.setStatus(rs.getString(6));
				book.setPhotoName(rs.getString(7));
				book.setEmail(rs.getString(8));
				list.add(book);
				i++;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}
	
	public List<BookDtls> getAllTrendingBook() {
		List<BookDtls> list = new ArrayList<BookDtls>();
		BookDtls book = null;
		Connection con = null;
		PreparedStatement st = null;
		
		try {
			con=AddBookDao.getConnection();
			st =con.prepareStatement("select * from book_dtls where bookCatagory=? order by bookId ASC");
			st.setString(1, "new");
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
				list.add(book);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}
	
	public List<BookDtls> getNewRelease() {
		List<BookDtls> list = new ArrayList<BookDtls>();
		BookDtls book = null;
		Connection con = null;
		PreparedStatement st = null;
		
		try {
			con=AddBookDao.getConnection();
			st =con.prepareStatement("select * from book_dtls where bookCatagory=? order by bookId DESC");
			st.setString(1, "new");
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
				list.add(book);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}
	
	public List<BookDtls> getAllNoteworthy() {
		List<BookDtls> list = new ArrayList<BookDtls>();
		BookDtls book = null;
		Connection con = null;
		PreparedStatement st = null;
		
		try {
			con=AddBookDao.getConnection();
			st =con.prepareStatement("select * from book_dtls where bookCatagory=? order by price ASC");
			st.setString(1, "new");
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
}
