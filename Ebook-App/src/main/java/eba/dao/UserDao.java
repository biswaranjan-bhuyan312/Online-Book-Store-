package eba.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import eba.model.User;
import eba.dao.UserDao;
import eba.model.User;
public class UserDao {

	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://@localhost:3306/ebook-app","root","biswa463");
	}
	
	public boolean addUser(User user) {
		boolean flag = false;
		Connection con = null;
		PreparedStatement st =null;
		try {
			con=UserDao.getConnection();
			st =con.prepareStatement("insert into user(name,email,phn_no,password) values(?,?,?,?)");
			st.setString(1, user.getName());
			st.setString(2, user.getEmail());
			st.setString(3, user.getPhn_no());
			st.setString(4, user.getPassword());
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
	
	public User loginUser(String email , String password) {
		User us = null;
		Connection con = null;
		PreparedStatement st = null;
		try {
			con=UserDao.getConnection();
			st =con.prepareStatement("select * from user where email=? and password=?");
			st.setString(1, email);
			st.setString(2, password);
			
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				us = new User();
				us.setId(rs.getInt(1));
				us.setName(rs.getString(2));
				us.setEmail(rs.getString(3));
				us.setPhn_no(rs.getString(4));
				us.setPassword(rs.getString(5));
				us.setAddress(rs.getString(6));
				us.setLandmark(rs.getString(7));
				us.setCity(rs.getString(8));
				us.setState(rs.getString(9));
				us.setPin_code(rs.getString(10));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return us;
	}
	
}
