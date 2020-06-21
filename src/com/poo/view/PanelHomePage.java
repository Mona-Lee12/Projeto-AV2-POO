package com.poo.view;

import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.border.LineBorder;

import com.poo.controller.CategoriasController;
import com.poo.controller.UsuariosController;

public class PanelHomePage extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelHomePage() {
		setBackground(new Color(255, 255, 255));
		setBounds(0, 0, 736, 364);
		setLayout(null);
		
		UsuariosController controllerUsuario = new UsuariosController();
		CategoriasController controllerCategoria = new CategoriasController();
		//ArquivosController controllerArquivos = new ArquivosController();
		
		JPanel panelArquivos = new JPanel();
		panelArquivos.setToolTipText("Quantidade de Arquivos");
		panelArquivos.setBackground(new Color(255, 255, 255));
		panelArquivos.setBounds(35, 61, 149, 117);
		panelArquivos.setBorder(new LineBorder(new Color(0, 128, 0)));
		add(panelArquivos);
		panelArquivos.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(74, 6, 1, 1);
		panelArquivos.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel labelQtdArquivos = new JLabel("0");
		//labelQtdArquivos.setText(controllerCategoria.BuscarQtdArquivos()); --> Tem que implementar 
		labelQtdArquivos.setHorizontalAlignment(SwingConstants.CENTER);
		labelQtdArquivos.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 16));
		labelQtdArquivos.setBounds(56, 100, 34, 17);
		panelArquivos.add(labelQtdArquivos);
		
		JLabel lblArquivosIcone = new JLabel("");
		lblArquivosIcone.setBounds(25, 0, 118, 98);
		panelArquivos.add(lblArquivosIcone);
		lblArquivosIcone.setIcon(new ImageIcon("icons\\produto.png"));
		
		JLabel lblNewLabel = new JLabel("Welcome");
		lblNewLabel.setBounds(35, 11, 663, 39);
		lblNewLabel.setForeground(new Color(95, 158, 160));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 28));
		add(lblNewLabel);
		
		JPanel panelCategoria = new JPanel();
		panelCategoria.setToolTipText("Quantidade de Categorias");
		panelCategoria.setBounds(290, 61, 149, 117);
		panelCategoria.setBorder(new LineBorder(new Color(70, 130, 180)));
		panelCategoria.setBackground(new Color(255, 255, 255));
		add(panelCategoria);
		panelCategoria.setLayout(null);
		
		JLabel labelQtdCategorias = new JLabel("");
		labelQtdCategorias.setText(controllerCategoria.BuscarQtdCategorias());
		labelQtdCategorias.setHorizontalAlignment(SwingConstants.CENTER);
		labelQtdCategorias.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 16));
		labelQtdCategorias.setBounds(62, 94, 34, 23);
		panelCategoria.add(labelQtdCategorias);
		
		JLabel lblCategoriaIcone = new JLabel("");
		lblCategoriaIcone.setBounds(21, 0, 110, 93);
		panelCategoria.add(lblCategoriaIcone);
		lblCategoriaIcone.setIcon(new ImageIcon("icons\\categoria.png"));
		
		JPanel panelIndicadorUsuarios = new JPanel();
		panelIndicadorUsuarios.setToolTipText("Quantidade de Usu\u00E1rios");
		panelIndicadorUsuarios.setBackground(new Color(255, 255, 255));
		panelIndicadorUsuarios.setBounds(549, 61, 149, 117);
		panelIndicadorUsuarios.setBorder(new LineBorder(new Color(255, 165, 0)));
		add(panelIndicadorUsuarios);
		panelIndicadorUsuarios.setLayout(null);
		
		JLabel labelQtdUsuarios = new JLabel("");
		labelQtdUsuarios.setText(controllerUsuario.BuscarQtdUsuarios());
		labelQtdUsuarios.setBounds(62, 89, 34, 28);
		panelIndicadorUsuarios.add(labelQtdUsuarios);
		labelQtdUsuarios.setHorizontalAlignment(SwingConstants.CENTER);
		labelQtdUsuarios.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 16));
		
		JLabel lblUsuarioIcone = new JLabel("");
		lblUsuarioIcone.setBounds(29, 11, 110, 84);
		panelIndicadorUsuarios.add(lblUsuarioIcone);
		lblUsuarioIcone.setIcon(new ImageIcon("icons\\users.png"));
		setVisible(true);
	}
}
