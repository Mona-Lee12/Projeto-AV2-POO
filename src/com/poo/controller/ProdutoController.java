package com.poo.controller;

import java.util.ArrayList;
import java.util.List;

import com.poo.dao.ProdutoDAO;
import com.poo.model.Produto;

public class ProdutoController {
	
	public void CadastrarProduto(Produto p) {
		try {
			ProdutoDAO dao = new ProdutoDAO();
			dao.CadastrarProduto(p);
			
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("Controller_Error:" +e.getMessage());
		}
		finally {
			System.out.println("Fim inserção" + this.getClass());
		}
	}
	public static List<Produto> BuscarProdutos() {
		List<Produto> produtos = new ArrayList<Produto>();
		try{
			ProdutoDAO dao = new ProdutoDAO();
			produtos = dao.BuscarProdutos();
			
		} catch (Exception e) {
			System.out.println("Controller_Error: " +e.getMessage());
		}
		finally {
			System.out.println("Fim da leitura!");
		}
		
		return produtos;
	}
	
	public void AtualizarProduto(Produto p) {
		try {
			ProdutoDAO dao = new ProdutoDAO();
			dao.AtualizarProduto(p);
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("Controller_Error:" +e.getMessage());
		}
		finally {
			System.out.println("Fim atualização"+ this.getClass());
		}
	}
	
	public void DeletarProduto(Produto p) {
		try {
			ProdutoDAO dao = new ProdutoDAO();
			dao.DeletarProduto(p);
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("Erro" +e.getMessage());
		}
		finally {
			System.out.println("Fim exclusao"+ this.getClass());
		}
	}
	 public String BuscarQtdProdutos() {
			String qtdProdutos = null;
			
			try {
				ProdutoDAO dao = new ProdutoDAO();
				qtdProdutos = dao.BuscarQtdProdutos();
			}
			catch(Exception e) {
				System.out.println("Erro no Controller");
			}
			finally {
			}
			
			return qtdProdutos;
		}

}
