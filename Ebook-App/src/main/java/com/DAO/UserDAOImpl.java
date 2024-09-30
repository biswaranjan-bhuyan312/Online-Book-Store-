package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.entity.User;

public class UserDAOImpl implements UserDAO {
	private Connection conn;

	public UserDAOImpl(Connection conn) {
		super();
		this.conn = conn;
	}

	@Override
	public boolean userRegistration(User us) {
		boolean f= false;
		try {
			String sql = "insert int user(name,email,phn_no,password)values(?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, us.getName());
			ps.setString(2, us.getEmail());
			ps.setString(3, us.getPhn_no());
			ps.setString(4, us.getPassword());
			int i = ps.executeUpdate();
			if(i==1) {
				f=true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	
}
