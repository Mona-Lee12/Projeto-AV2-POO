package com.poo.view;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

public class PanelCategorias extends JPanel {
	private JTextField textCategoria;

	/**
	 * Create the panel.
	 */
	public PanelCategorias() {
		setBackground(new Color(255, 255, 255));
		setBounds(0,0,597,329);
		setLayout(null);
		
		textCategoria = new JTextField();
		textCategoria.setColumns(10);
		textCategoria.setBounds(301, 82, 290, 34);
		add(textCategoria);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setForeground(Color.WHITE);
		btnCadastrar.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 13));
		btnCadastrar.setBackground(new Color(95, 158, 160));
		btnCadastrar.setBounds(502, 128, 89, 34);
		add(btnCadastrar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(null);
		scrollPane.setBorder(null);
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setBounds(14, 57, 275, 253);
		add(scrollPane);
		
		JLabel lblNomeCategoria = new JLabel("Nome Categoria:");
		lblNomeCategoria.setForeground(new Color(95, 158, 160));
		lblNomeCategoria.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 14));
		lblNomeCategoria.setBounds(301, 57, 151, 16);
		add(lblNomeCategoria);
		
		JLabel lblCategorias = new JLabel("Categorias");
		lblCategorias.setForeground(new Color(95, 158, 160));
		lblCategorias.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 28));
		lblCategorias.setBackground(Color.WHITE);
		lblCategorias.setBounds(14, 6, 200, 34);
		add(lblCategorias);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setForeground(new Color(95, 158, 160));
		btnVoltar.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 13));
		btnVoltar.setBackground(Color.WHITE);
		btnVoltar.setBounds(502, 9, 89, 34);
		add(btnVoltar);
		
		JLabel label = new JLabel("*");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.RED);
		label.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 15));
		label.setBounds(404, 57, 19, 18);
		add(label);
	}
}
