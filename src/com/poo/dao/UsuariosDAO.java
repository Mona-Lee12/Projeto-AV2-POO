package com.poo.dao;

import java.sql.CallableStatement;
//import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.poo.jdbc.ConnectionFactory;
import com.poo.model.Usuarios;

public class UsuariosDAO {
	
	public List<Usuarios> BuscarUsuarios(String nome) {
		Connection con = ConnectionFactory.getConnection();
		ResultSet rs = null;
		CallableStatement procedure = null;
		ArrayList<Usuarios> usuarios = new ArrayList<Usuarios>();
		
		try{
			//Prepara a chamada para a procedure. Observe que h� "?"
			// Que neste caso � o par�metro de sa�da.
			procedure = con.prepareCall("{ CALL USP_BUSCAR_USUARIOS (?)}");
			// parametro de entrada 
			procedure.setString(1, nome);
			//Informa o tipo de retorno
			
			// Executa a Stored procedure
			rs = procedure.executeQuery();

			while(rs.next())
			{
				Usuarios usuario = new Usuarios();
				usuario.setNome(rs.getString("nome"));
				usuarios.add(usuario);
			}
		}
		catch(SQLException e) {
			System.out.println("Erro na DAO: "+e);
		}
		finally {
			ConnectionFactory.closeConnection(con,procedure);
		}
		
		return usuarios;
	}
	
}
