package com.poo.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.poo.jdbc.ConnectionFactory;
import com.poo.model.Funcionarios;

public class FuncionariosDAO {
	
	public void CadastrarFuncionarios(Funcionarios funcionario) {
		// TODO Auto-generated method stub
		Connection con = ConnectionFactory.getConnection();
		CallableStatement procedure = null;
		
		try {
			procedure = con.prepareCall("{ CALL SP_CADASTRAR_FUNCIONARIO(?,?,?,?,?,?)}");  
			procedure.setString(1, funcionario.getNome());
			procedure.setString(2, funcionario.getTelefone());
			procedure.setString(3, funcionario.getCpf());
			procedure.setString(4, funcionario.getEmail());
			procedure.setString(5, funcionario.getCargo());
			procedure.setFloat(6, funcionario.getSalario());
			
			procedure.executeQuery();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			ConnectionFactory.closeConnection(con, procedure);
		}	
	}
	
	public List<Funcionarios> BuscarFuncionarios(String nome) {
		Connection con = ConnectionFactory.getConnection();
		ResultSet rs = null;
		CallableStatement procedure = null;
		ArrayList<Funcionarios> funcionarios = new ArrayList<Funcionarios>();
		
		try{
			//Prepara a chamada para a procedure. Observe que há "?"
			// Que neste caso é o parâmetro de saída.
			procedure = con.prepareCall("{ CALL SP_BUSCAR_FUNCIONARIOS (?)}");
			// parametro de entrada 
			procedure.setString(1, nome);
			//Informa o tipo de retorno
			
			// Executa a Stored procedure
			rs = procedure.executeQuery();

			while(rs.next())
			{
				Funcionarios funcionario = new Funcionarios();
				funcionario.setFuncionarioId(rs.getInt("FUNCIONARIO_ID"));
				funcionario.setNome(rs.getString("NOME"));
				funcionario.setCpf(rs.getString("CPF"));
				funcionario.setEmail(rs.getString("EMAIL"));
				funcionario.setTelefone(rs.getString("TELEFONE"));
				funcionario.setCargo(rs.getString("CARGO"));
				funcionario.setSalario(rs.getFloat("SALARIO"));
				
				funcionarios.add(funcionario);
			}
		}
		catch(SQLException e) {
			System.out.println(e);
		}
		finally {
			ConnectionFactory.closeConnection(con,procedure);
		}
		
		return funcionarios;
	}
	
	public void EditarFuncionarios(Funcionarios funcionario) {
		Connection con = ConnectionFactory.getConnection();
		CallableStatement procedure = null;
		
		try {
			
			procedure = con.prepareCall("{ CALL SP_EDITAR_FUNCIONARIO(?,?,?,?,?,?,?)}");  
			procedure.setInt(1, funcionario.getFuncionarioId()); 
			procedure.setString(2, funcionario.getNome()); 
			procedure.setString(3, funcionario.getTelefone());
			procedure.setString(4, funcionario.getCpf());
			procedure.setString(5, funcionario.getEmail());
			procedure.setString(6, funcionario.getCargo());
			procedure.setFloat(7, funcionario.getSalario());
			procedure.executeUpdate();
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			ConnectionFactory.closeConnection(con, procedure);
		}
	}
	public void ExcluirFuncionarios(Funcionarios funcionario) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		String sql = "DELETE FROM FUNCIONARIO WHERE FUNCIONARIO_ID = ?";
		
		try {
			stmt = con.prepareStatement(sql);
			stmt.setInt(1,funcionario.getFuncionarioId()); 
			
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
	
	public String BuscarQtdFuncionarios() {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String qtdFuncionarios = null;
		
		String sql = "SELECT COUNT(*) AS QTD FROM FUNCIONARIO";
		try {
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next())
			{
				qtdFuncionarios = rs.getString("QTD");
			}
		}
		catch(SQLException e) {
			System.out.println(e);
		}
		finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
		
		return qtdFuncionarios;
	}
}
