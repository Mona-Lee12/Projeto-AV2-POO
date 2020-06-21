package com.poo.controller;

import java.util.ArrayList;
import java.util.List;
import com.poo.dao.FuncionariosDAO;
import com.poo.model.Funcionarios;

public class FuncionariosController {
	
		public void CadastrarFuncionarios(Funcionarios funcionario) {
			try {
				FuncionariosDAO dao = new FuncionariosDAO();
				
				dao.CadastrarFuncionarios(funcionario);
			}
			catch (Exception e) {
				// TODO: handle exception
				System.out.println("Erro no Controller");
			}
			finally {
				System.out.println("Fim inserção");
			}
		}
		public List<Funcionarios> BuscarFuncionarios(String nome) {
			List<Funcionarios> funcionarios = new ArrayList<Funcionarios>();
			try{
				FuncionariosDAO dao = new FuncionariosDAO();
				funcionarios = dao.BuscarFuncionarios(nome);		
			}
			finally {
				//System.out.println("Fim da leitura!");
			}
			
			return funcionarios;
		}
		
		public void EditarFuncionarios(Funcionarios funcionario) {
			try {
				FuncionariosDAO dao = new FuncionariosDAO();
				dao.EditarFuncionarios(funcionario);
			}
			catch (Exception e) {
				// TODO: handle exception
				//System.out.println("Erro no Controller");
			}
			finally {
				//System.out.println("Fim atualização");
			}
		}
		
		public void ExcluirFuncionarios(Funcionarios funcionario) {
			try {
				FuncionariosDAO dao = new FuncionariosDAO();
				dao.ExcluirFuncionarios(funcionario);
			}
			catch (Exception e) {
				// TODO: handle exception
			//	System.out.println("Erro no Controller");
			}
			finally {
				//System.out.println("Fim exclusão");
			}
		}
}
