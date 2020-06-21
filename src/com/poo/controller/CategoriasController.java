package com.poo.controller;

import java.util.ArrayList;
import java.util.List;

import com.poo.dao.CategoriasDAO;
import com.poo.dao.UsuariosDAO;
import com.poo.model.Categorias;


public class CategoriasController {
	
	public List<Categorias> BuscarCategorias(String nome) {
		List<Categorias> categorias = new ArrayList<Categorias>();
		try{
			CategoriasDAO dao = new CategoriasDAO();
			categorias = dao.BuscarCategorias(nome);		
		}
		finally {
			System.out.println("Fim da leitura!");
		}
		
		return categorias;
	}
	
	public void CadastrarCategoria(Categorias categoria) {
		try {
			CategoriasDAO dao = new CategoriasDAO();
			dao.CadastrarCategoria(categoria);
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("Erro no Controller");
		}
		finally {
			System.out.println("Fim inserção");
		}
	}
	
	public void EditarCategoria(Categorias categoria) {
		try {
			CategoriasDAO dao = new CategoriasDAO();
			dao.EditarCategoria(categoria);
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("Erro no Controller");
		}
		finally {
			System.out.println("Fim inserção");
		}
	}
	
	public void ExcluirCategoria(Categorias categoria) {
		try {
			CategoriasDAO dao = new CategoriasDAO();
			dao.ExcluirCategoria(categoria);
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		finally {
			System.out.println("Fim inserção");
		}
	}
	
	public String BuscarQtdCategorias() {
		String qtd_categorias = null;
		
		try {
			CategoriasDAO dao = new CategoriasDAO();
			qtd_categorias = dao.BuscarQtdCategorias();
		}
		catch(Exception e) {
			System.out.println("Erro no Controller");
		}
		finally {
			//
		}
		
		return qtd_categorias;
	}
}
