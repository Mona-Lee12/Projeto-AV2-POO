package com.poo.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import com.poo.controller.CategoriasController;
import com.poo.model.Categorias;

public class PanelCategorias extends JPanel {
	
	private JTextField textCategoria;
	private JTable tabela;
	private DefaultTableModel modelo = new DefaultTableModel();

	/**
	 * Create the panel.
	 */
	public PanelCategorias() {
		setBackground(new Color(255, 255, 255));
		setBounds(0,0,597,329);
		setLayout(null);
		
		Categorias categoria = new Categorias();
		CategoriasController controller = new CategoriasController();
		
		textCategoria = new JTextField();
		textCategoria.setColumns(10);
		textCategoria.setBounds(301, 82, 290, 34);
		add(textCategoria);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setForeground(Color.WHITE);
		btnCadastrar.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 13));
		btnCadastrar.setBackground(new Color(95, 158, 160));
		btnCadastrar.setBounds(502, 128, 89, 34);
		btnCadastrar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		try {						
        			categoria.setNome(textCategoria.getText());
					controller.CadastrarCategoria(categoria);
					JOptionPane.showMessageDialog(null, "Categoria cadastrada com sucesso!");
					pesquisar(modelo);
				}				
				 catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Erro ao Inserir Aluno!");
				}	
        	}
        });
		add(btnCadastrar);
		

		criaJTable();
		JScrollPane jScrollPane = new JScrollPane();
		jScrollPane.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 14));
		jScrollPane.setBackground(Color.WHITE);
		jScrollPane.setBorder(null);
		jScrollPane.setViewportBorder(null);
		jScrollPane.setBounds(10, 82, 279, 239);
		jScrollPane.setViewportView(tabela);
		jScrollPane.getViewport().setBackground(Color.WHITE);
		tabela.setBackground(Color.WHITE);
		add(jScrollPane);
		
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
		
		JLabel label = new JLabel("*");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.RED);
		label.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 15));
		label.setBounds(404, 57, 19, 18);
		add(label);
		
		repaint();
	}
	private void criaJTable() {
		 
		 tabela = new JTable(modelo);
		 tabela.setShowHorizontalLines(true);
		 tabela.setBackground(Color.WHITE);
		 tabela.setSelectionBackground(new Color(0, 128, 128));
	     modelo.addColumn("Nome");
	     tabela.getColumnModel().getColumn(0).setPreferredWidth(40);
	     pesquisar(modelo);
	     
	 }
	public static void pesquisar(DefaultTableModel modelo) {
		  CategoriasController controller = new CategoriasController();
		  modelo.setNumRows(0);
		  for(Categorias categoria : controller.BuscarCategorias()) {
			  modelo.addRow(new Object[]{categoria.getNome()});
		  }
	}
}
