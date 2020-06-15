package com.poo.controller;

import java.util.ArrayList;
import java.util.List;

import com.poo.dao.CategoriasDAO;
import com.poo.dao.UsuariosDAO;
import com.poo.model.Categorias;


public class CategoriasController {
	
	public List<Categorias> BuscarCategorias() {
		List<Categorias> categorias = new ArrayList<Categorias>();
		try{
			CategoriasDAO dao = new CategoriasDAO();
			categorias = dao.BuscarCategorias();		
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
