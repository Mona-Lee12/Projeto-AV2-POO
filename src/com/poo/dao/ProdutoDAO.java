package com.poo.dao;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

import com.poo.jdbc.ConnectionFactory;
import com.poo.model.Produto;

public class ProdutoDAO {
	
	 Connection con = ConnectionFactory.getConnection();     
     PreparedStatement stmt = null;
     ResultSet rs = null;
     CallableStatement procedure = null;
     
     public void CadastrarProduto(Produto p) {
    	 
    	 try {
			procedure = con.prepareCall("{ CALL SP_CADASTRAR_PRODUTO(?,?,?,?,?)}");
			procedure.setString(1, p.getDescricao());
			procedure.setInt(2, p.getQtd());
			procedure.setDouble(3, p.getPreco());
			procedure.setString(4, p.getCategoria());			
			procedure.setString(5, p.getLote());            

            procedure.executeUpdate();

            JOptionPane.showMessageDialog(null, "Produto Cadastrado !");
    	 } catch (SQLException ex) {
             System.out.println("Error: "+ex.getMessage() + ex.getErrorCode());
             JOptionPane.showMessageDialog(null, "Produto nao Cadastrado !");
             
         } finally {
             ConnectionFactory.closeConnection(con, stmt);
         }
     }
     
 	public List<Produto> BuscarProdutos() {		
		
		ArrayList<Produto> produtos = new ArrayList<Produto>();
		
		try{
			//Prepara a chamada para a procedure. Observe que há "?"
			// Que neste caso é o parâmetro de saída.
			procedure = con.prepareCall("{ CALL SP_BUSCAR_PRODUTOS (?)}");
			// parametro de entrada 
			procedure.setString(1, null);
			//Informa o tipo de retorno
			
			// Executa a Stored procedure
			rs = procedure.executeQuery();

			while(rs.next())
			{
				Produto produto = new Produto();
				produto.setId(rs.getInt("id"));
				produto.setDescricao(rs.getString("descricao"));
				produto.setQtd(rs.getInt("qtd"));
				produto.setPreco(rs.getDouble("preco"));
				produto.setCategoria(rs.getString("categoria"));				
				produto.setLote(rs.getString("lote"));
				
				produtos.add(produto);
			}
		}
		catch(SQLException ex) {
			
			System.out.println("DAO_Error: "+ex.getMessage() + ex.getErrorCode());
			JOptionPane.showMessageDialog(null, "Erro ao exibir");
		}
		finally {
			ConnectionFactory.closeConnection(con,procedure);
		}
		
		return produtos;
	}
     
     public void AtualizarProduto(Produto p) {       

         try {
        	 Produto produto = new Produto();
        	 procedure = con.prepareCall("{CALL SP_EDITAR_PRODUTO(?, ?, ?, ?, ?, ?)}"); 
             procedure.setInt(1, produto.getId() );
             procedure.setString(2,  produto.getDescricao());
             procedure.setInt(3, produto.getQtd());
             procedure.setDouble(4, produto.getPreco());
             procedure.setString(5, produto.getCategoria());
             procedure.setString(6, produto.getLote());
             
             procedure.executeUpdate();

             JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
         } catch (SQLException ex) {
        	 
        	 System.out.println("DAO_Error: "+ex.getMessage() + ex.getErrorCode());
             JOptionPane.showMessageDialog(null, "Erro ao atualizar: ");
             
         } finally {
             ConnectionFactory.closeConnection(con, stmt);
         }

     }
     
     public void DeletarProduto(Produto p) {         

         try {
             stmt = con.prepareStatement("DELETE FROM PRODUTO WHERE id = ?");
             stmt.setInt(1, p.getId());

             stmt.executeUpdate();
             JOptionPane.showMessageDialog(null, "Produto excluido");
             
         } catch (SQLException ex) {	
        	 ex.printStackTrace();
        	 System.out.println("DAO_Error: " +ex.getMessage() + ex.getErrorCode());
        	 JOptionPane.showMessageDialog(null, "Erro ao excluir");
        	 
         } finally {
             ConnectionFactory.closeConnection(con, stmt);
         }
     }
     
     public String BuscarQtdProdutos() { 		
 		String qtdProdutos = null;
 		
 		String sql = "SELECT COUNT(*) AS QTD FROM FUNCIONARIO";
 		
 		try {
 			stmt = con.prepareStatement(sql);
 			rs = stmt.executeQuery();
 			while(rs.next())
 			{
 				qtdProdutos = rs.getString("QTD");
 			}
 		}
 		catch(SQLException e) {
 			System.out.println(e);
 		}
 		finally {
 			ConnectionFactory.closeConnection(con, stmt);
 		}
 		
 		return qtdProdutos;
 	}
     
    
}
