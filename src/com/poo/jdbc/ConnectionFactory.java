package com.poo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConnectionFactory {

		private static final String DRIVE = "com.mysql.jdbc.Driver"; 
		private static final String URL = "jdbc:mysql://database-3.ckibuhsl7ji5.us-east-1.rds.amazonaws.com:3306/meu_banco_aula?useTimezone=true&serverTimezone=UTC"; 
		private static final String USER = "mona"; 
		private static final String SENHA = "mona1234"; 
		
		
		public static Connection getConnection() {
	        try {
	        	
	        	//Class.forName(DRIVER); opcional dependendo da versao
	        	
	            return DriverManager.getConnection(
	            		URL, USER, SENHA);
	        } catch (SQLException e) {
	            throw new RuntimeException("Erro na conex�o com o Banco de Dados!",e);
	        }
		}
		
		public static void closeConnection(Connection con) {
			if(con != null)
			{
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		public static void closeConnection(Connection con, PreparedStatement stmt)
		{
			closeConnection(con);
			
			if(stmt != null)
			{
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
}
