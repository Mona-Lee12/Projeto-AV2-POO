package com.poo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import com.poo.jdbc.ConnectionFactory;

public class AdminDAO {
	
	public boolean checkLogin (String login, String senha) {
		
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		boolean check = false;
		
		
		try {
			
			stmt = con.prepareStatement("SELECT * FROM admin WHERE login = ? AND senha = ? ");
			stmt.setString(1,  login);
			stmt.setString(2,  senha);
			rs = stmt.executeQuery();
			
			if(rs.next()) { 
				check = true;				
			}
			
		} catch (SQLException e) {
			System.out.println("Error: O Banco de dados nao correspondeu!");			
			
		}
		finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
		
		return check;
	}
}
