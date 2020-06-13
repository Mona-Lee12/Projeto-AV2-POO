package com.poo.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.poo.controller.UsuariosController;
import com.poo.model.Usuarios;

import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;

import java.awt.Color;

public class PanelUsuarios extends JPanel {
	
	private JTextField textBuscaUsuario;
    private JTable tabela;
    private DefaultTableModel modelo = new DefaultTableModel();
    CadastroEdicaoUsuarios t1 = new CadastroEdicaoUsuarios(); 

	public PanelUsuarios() {
		setBackground(new Color(255, 255, 255));

		UsuariosController controller = new UsuariosController();
		setForeground(new Color(0, 0, 0));
		setBounds(0,0,597,329);
	 	setLayout(null);
        
		JLabel lblUsuarios = new JLabel("Usu\u00E1rios");
		lblUsuarios.setForeground(new Color(95, 158, 160));
		lblUsuarios.setBackground(new Color(255, 255, 255));
		lblUsuarios.setBounds(10, 10, 200, 34);
		lblUsuarios.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 28));
		add(lblUsuarios);
		
		textBuscaUsuario = new JTextField();
		textBuscaUsuario.setBounds(10, 71, 290, 34);
		add(textBuscaUsuario);
		textBuscaUsuario.setColumns(10);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 13));
		btnPesquisar.setForeground(new Color(255, 255, 255));
		btnPesquisar.setBackground(new Color(95, 158, 160));
		btnPesquisar.setBounds(312, 71, 89, 34);
		btnPesquisar.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		try {
	        			pesquisar(modelo,textBuscaUsuario.getText());
						JOptionPane.showMessageDialog(null, "Busca realizada com sucesso!");
					}				
					 catch (Exception e1) {
						JOptionPane.showMessageDialog(null, e1);
					}	
	        	}
	        });
		add(btnPesquisar);
		

		criaJTable("");
		JScrollPane jScrollPane = new JScrollPane();
		jScrollPane.setBackground(new Color(255, 255, 255));
		jScrollPane.setBorder(null);
		jScrollPane.setViewportBorder(null);
		jScrollPane.setBounds(10, 117, 577, 201);
		jScrollPane.setViewportView(tabela);
		add(jScrollPane);
		
		JButton btnNovoUsuario = new JButton("Novo Usu\u00E1rio");
		btnNovoUsuario.setForeground(new Color(95, 158, 160));
		btnNovoUsuario.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 13));
		btnNovoUsuario.setBackground(new Color(255, 255, 255));
		btnNovoUsuario.setBounds(478, 13, 109, 34);
		btnNovoUsuario.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		setVisible(false);
        		t1.setVisible(true); 
        	   
        	}
        });
		add(btnNovoUsuario);
		
		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setForeground(new Color(95, 158, 160));
		lblNewLabel.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 56, 89, 16);
		add(lblNewLabel);
		
		repaint();
		
		tabela.setVisible(true);
		
	}
	 private void criaJTable(String param) {
		 
		 tabela = new JTable(modelo);
	     modelo.addColumn("Nome");
	     modelo.addColumn("CPF");
	     modelo.addColumn("Ações");
	     tabela.getColumnModel().getColumn(0).setPreferredWidth(40);
	     tabela.getColumnModel().getColumn(1).setPreferredWidth(20);
	     tabela.getColumnModel().getColumn(2).setPreferredWidth(20);
	     pesquisar(modelo,"");
	 }
	public static void pesquisar(DefaultTableModel modelo, String param) {
		  UsuariosController controller = new UsuariosController();
		 
		  modelo.setNumRows(0);
		  for(Usuarios user : controller.BuscarUsuarios(param)) {
			  modelo.addRow(new Object[]{user.getNome(),"","Editar"});
		  }
	}
}
