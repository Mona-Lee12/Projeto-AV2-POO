package com.poo.view;

import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.border.LineBorder;

import com.poo.controller.CategoriasController;
import com.poo.controller.FuncionariosController;

public class PanelHomePage extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelHomePage() {
		setBackground(new Color(255, 255, 255));
		setBounds(0, 0, 736, 364);
		setLayout(null);
		
		FuncionariosController controllerFuncionario = new FuncionariosController();
		CategoriasController controllerCategoria = new CategoriasController();
		//ProdutosController controllerProduto = new ProdutosController();
		
		JPanel panelProdutos = new JPanel();
		panelProdutos.setToolTipText("Quantidade de Produtos");
		panelProdutos.setBackground(new Color(255, 255, 255));
		panelProdutos.setBounds(35, 61, 149, 117);
		panelProdutos.setBorder(new LineBorder(new Color(0, 128, 0)));
		add(panelProdutos);
		panelProdutos.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(74, 6, 1, 1);
		panelProdutos.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel labelQtdProdutos = new JLabel("0");

		//labelQtdProdutos.setText(controllerProduto.BuscarQtdProdutos());
		labelQtdProdutos.setHorizontalAlignment(SwingConstants.CENTER);
		labelQtdProdutos.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 16));
		labelQtdProdutos.setBounds(56, 100, 34, 17);
		panelProdutos.add(labelQtdProdutos);
		
		JLabel lblProdutosIcone = new JLabel("");
		lblProdutosIcone.setBounds(25, 0, 118, 98);
		panelProdutos.add(lblProdutosIcone);
		lblProdutosIcone.setIcon(new ImageIcon("icons\\produto.png"));
		
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
		
		JPanel panelIndicadorFuncionarios = new JPanel();
		panelIndicadorFuncionarios.setToolTipText("Quantidade de Funcion\u00E1rios");
		panelIndicadorFuncionarios.setBackground(new Color(255, 255, 255));
		panelIndicadorFuncionarios.setBounds(549, 61, 149, 117);
		panelIndicadorFuncionarios.setBorder(new LineBorder(new Color(255, 165, 0)));
		add(panelIndicadorFuncionarios);
		panelIndicadorFuncionarios.setLayout(null);
		
		JLabel labelQtdFuncionarios = new JLabel("");
		labelQtdFuncionarios.setText(controllerFuncionario.BuscarQtdFuncionarios());
		labelQtdFuncionarios.setBounds(62, 89, 34, 28);
		panelIndicadorFuncionarios.add(labelQtdFuncionarios);
		labelQtdFuncionarios.setHorizontalAlignment(SwingConstants.CENTER);
		labelQtdFuncionarios.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 16));
		
		JLabel lblFuncionarioIcone = new JLabel("");
		lblFuncionarioIcone.setBounds(29, 11, 110, 84);
		panelIndicadorFuncionarios.add(lblFuncionarioIcone);
		lblFuncionarioIcone.setIcon(new ImageIcon("icons\\users.png"));
		setVisible(true);
	}
}
