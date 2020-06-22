package com.poo.jdbc;

import java.sql.Connection;

public class TestConnection {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection connection = ConnectionFactory.getConnection();	
		
		System.out.println("Conexão Estabelecida com Sucesso !");		
	}
}