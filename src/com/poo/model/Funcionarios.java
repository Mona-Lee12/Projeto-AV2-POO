package com.poo.model;

public class Funcionarios {

	private int funcionarioId;
	private String nome;
	private String cpf;
	private String telefone;
	private String email;
	private String cargo;
	private float salario;
	public int getFuncionarioId() {
		return funcionarioId;
	}
	public void setFuncionarioId(int funcionarioId) {
		this.funcionarioId = funcionarioId;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public float getSalario() {
		return salario;
	}
	public void setSalario(float salario) {
		this.salario = salario;
	}
}
