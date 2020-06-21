package com.poo.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.poo.jdbc.ConnectionFactory;
import com.poo.model.Categorias;

public class CategoriasDAO {
	public List<Categorias> BuscarCategorias(String nome)
	{
		Connection con = ConnectionFactory.getConnection();
		ResultSet rs = null;
		CallableStatement procedure = null;
		ArrayList<Categorias> categorias = new ArrayList<Categorias>();
		
		try{
			procedure = con.prepareCall("{ CALL SP_BUSCAR_CATEGORIAS (?)}");
			// parametro de entrada 
			procedure.setString(1, nome);
			//Informa o tipo de retorno
			
			// Executa a Stored procedure
			rs = procedure.executeQuery();
			
			while(rs.next())
			{
				Categorias categoria = new Categorias();
				categoria.setCategoriaId(rs.getInt("CATEGORIA_ID"));
				categoria.setNome(rs.getString("NOME"));
				
				categorias.add(categoria);
			}
		
		}
		catch(SQLException e) {
			System.out.println("Erro ao tentar carregar categorias.");
		}
		finally {
			ConnectionFactory.closeConnection(con, procedure);
		}
		
		return categorias;
	}
	
	public void CadastrarCategoria(Categorias categoria)
	{
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		String sql = "INSERT INTO CATEGORIA(NOME) VALUES (?)";
		
		try {
			stmt = con.prepareStatement(sql);  
			stmt.setString(1, categoria.getNome());
			stmt.executeUpdate();
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			ConnectionFactory.closeConnection(con, stmt);
		}	
	}
	
	public void EditarCategoria(Categorias categoria)
	{
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		String sql = "UPDATE CATEGORIA SET NOME = ? WHERE CATEGORIA_ID = ? ";
		
		try {
			stmt = con.prepareStatement(sql);  
			stmt.setString(1, categoria.getNome());
			stmt.setInt(2, categoria.getCategoriaId());
			stmt.executeUpdate();
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
			e.printStackTrace();
		}
		finally {
			ConnectionFactory.closeConnection(con, stmt);
		}	
	}
	
	public void ExcluirCategoria(Categorias categoria)
	{
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		String sql = "DELETE FROM CATEGORIA WHERE CATEGORIA_ID = ? ";
		
		try {
			stmt = con.prepareStatement(sql);  
			stmt.setInt(1, categoria.getCategoriaId());
			stmt.executeUpdate();
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			ConnectionFactory.closeConnection(con, stmt);
		}	
	}
	
	public String BuscarQtdCategorias() {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String qtd_categorias = null;
		
		String sql = "SELECT COUNT(*) AS QUANTIDADE_CATEGORIA FROM CATEGORIA";
		try {
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next())
			{
				qtd_categorias = rs.getString("QUANTIDADE_CATEGORIA");
			}
		}
		catch(SQLException e) {
			System.out.println(e);
		}
		finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
		
		return qtd_categorias;
	}
}
