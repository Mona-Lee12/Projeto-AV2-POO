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
             System.out.println("DAO_Error: "+ex.getMessage() + ex.getErrorCode());
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
        	 stmt = con.prepareStatement(" UPDATE PRODUTO SET descricao = ? ,qtd = ? ,preco = ? ,categoria = ?, lote = ?  WHERE id = ?;");
        	 stmt.setString(1,  p.getDescricao());
        	 stmt.setInt(2, p.getQtd());
        	 stmt.setDouble(3, p.getPreco());
        	 stmt.setString(4, p.getCategoria());
        	 stmt.setString(5, p.getLote());
        	 stmt.setInt(6, p.getId() );

             stmt.executeUpdate();

             JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
         } catch (SQLException ex) {
        	 
        	 JOptionPane.showMessageDialog(null, "Erro ao atualizar: ");
        	 System.out.println("DAO_Error: "+ex.getMessage() + ex.getErrorCode());
             
         } finally {
             ConnectionFactory.closeConnection(con, procedure);
         }

     }
     
     public void DeletarProduto(Produto p) {         

         try {
             stmt = con.prepareStatement("DELETE FROM PRODUTO WHERE id = ?");
             stmt.setInt(1, p.getId());

             stmt.executeUpdate();
             JOptionPane.showMessageDialog(null, "Produto excluido");
             
         } catch (SQLException ex) {
        	 
        	 JOptionPane.showMessageDialog(null, "Erro ao excluir");
        	 System.out.println("DAO_Error: " +ex.getMessage() + ex.getErrorCode());
        	 
         } finally {
             ConnectionFactory.closeConnection(con, stmt);
         }
     }
     
     public String BuscarQtdProdutos() { 		
 		String qtdProdutos = null;
 		
 		String sql = "SELECT COUNT(*) AS QTD FROM PRODUTO";
 		
 		try {
 			stmt = con.prepareStatement(sql);
 			rs = stmt.executeQuery();
 			while(rs.next())
 			{
 				qtdProdutos = rs.getString("QTD");
 			}
 		}
 		catch(SQLException e) {
 			e.printStackTrace();
 		}
 		finally {
 			ConnectionFactory.closeConnection(con, stmt);
 		}
 		
 		return qtdProdutos;
 	}
     
    
}
