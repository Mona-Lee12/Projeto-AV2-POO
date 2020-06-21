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
	
	private JTextField textCategoriaNome;
	private JTable tabela;
	private DefaultTableModel modelo = new DefaultTableModel();
	private JTextField textBuscaCategoria;
	private JTextField textCategoriaId;

	static CategoriasController controller = new CategoriasController();
	
	public PanelCategorias() {
		setBackground(new Color(255, 255, 255));
		setBounds(0, 0, 736, 364);
		setLayout(null);
		
		Categorias categoria = new Categorias();
		CategoriasController controller = new CategoriasController();
		
		textCategoriaNome = new JTextField();
		textCategoriaNome.setColumns(10);
		textCategoriaNome.setBounds(364, 136, 355, 34);
		add(textCategoriaNome);
		

		JLabel labelMsgObrigatoriedade = new JLabel("Campo obrigat\u00F3rio.");
		labelMsgObrigatoriedade.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 12));
		labelMsgObrigatoriedade.setForeground(new Color(255, 0, 0));
		labelMsgObrigatoriedade.setBounds(608, 118, 111, 16);
		labelMsgObrigatoriedade.setVisible(false);
		add(labelMsgObrigatoriedade);
		
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setForeground(Color.WHITE);
		btnCadastrar.setFont(new Font("Segoe UI Emoji", Font.BOLD, 14));
		btnCadastrar.setBackground(new Color(0, 102, 0));
		btnCadastrar.setBounds(364, 194, 89, 34);
		btnCadastrar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		if (textCategoriaNome.getText().length() <= 0 || textCategoriaNome.getText().isEmpty()) {
        			labelMsgObrigatoriedade.setVisible(true);
        			JOptionPane.showMessageDialog(null, "Confira os campos Obrigatórios!!");
                } 
        		else {
                	try {	
                			labelMsgObrigatoriedade.setVisible(false);
		        			categoria.setNome(textCategoriaNome.getText());
							controller.CadastrarCategoria(categoria);
							JOptionPane.showMessageDialog(null, "Categoria cadastrada com sucesso!");
							pesquisar(modelo,null);
							CadastrarActionPerformed();
						}				
						 catch (Exception e1) {
							JOptionPane.showMessageDialog(null, "Erro ao tentar cadastrar categoria.");
						}	
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
		jScrollPane.setBounds(14, 118, 321, 239);
		jScrollPane.setViewportView(tabela);
		jScrollPane.getViewport().setBackground(Color.WHITE);
		tabela.setBackground(Color.WHITE);
		add(jScrollPane);
		
		JLabel lblNomeCategoria = new JLabel("Nome:");
		lblNomeCategoria.setForeground(new Color(0, 0, 0));
		lblNomeCategoria.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 14));
		lblNomeCategoria.setBounds(364, 120, 50, 16);
		add(lblNomeCategoria);
		
		JLabel lblCategorias = new JLabel("Categorias");
		lblCategorias.setHorizontalAlignment(SwingConstants.CENTER);
		lblCategorias.setForeground(new Color(95, 158, 160));
		lblCategorias.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 28));
		lblCategorias.setBackground(Color.WHITE);
		lblCategorias.setBounds(14, 6, 682, 34);
		add(lblCategorias);
		
		JLabel label = new JLabel("*");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.RED);
		label.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 15));
		label.setBounds(400, 119, 19, 18);
		add(label);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setForeground(Color.WHITE);
		btnEditar.setFont(new Font("Segoe UI Emoji", Font.BOLD, 14));
		btnEditar.setBackground(new Color(255, 204, 0));
		btnEditar.setBounds(492, 194, 89, 34);
		btnEditar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if (textCategoriaNome.getText().length() <= 0 || textCategoriaNome.getText().isEmpty()) {
        			labelMsgObrigatoriedade.setVisible(true);
        			JOptionPane.showMessageDialog(null, "Confira os campos Obrigatórios!!");
                } 
        		else {
	        		try {
            			labelMsgObrigatoriedade.setVisible(false);
	        			categoria.setCategoriaId(Integer.parseInt(textCategoriaId.getText()));
	        			categoria.setNome(textCategoriaNome.getText());
						controller.EditarCategoria(categoria);
						JOptionPane.showMessageDialog(null, "Categoria editada com sucesso!");
						pesquisar(modelo,null);
						CadastrarActionPerformed();
					}				
					 catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "Erro ao tentar editar categoria.");
					}	
        		}
        	}
        });
		add(btnEditar);
		
		JButton btnExcluir = new JButton("Excluir ");
		btnExcluir.setForeground(Color.WHITE);
		btnExcluir.setFont(new Font("Segoe UI Emoji", Font.BOLD, 14));
		btnExcluir.setBackground(new Color(255, 0, 0));
		btnExcluir.setBounds(630, 194, 89, 34);
		btnExcluir.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if (textCategoriaNome.getText().length() <= 0 || textCategoriaNome.getText().isEmpty()) {
        			labelMsgObrigatoriedade.setVisible(true);
        			JOptionPane.showMessageDialog(null, "Confira os campos Obrigatórios!!");
                } 
        		else {
	        		try {

            			labelMsgObrigatoriedade.setVisible(false);
	        			categoria.setCategoriaId(Integer.parseInt(textCategoriaId.getText()));
	        			categoria.setNome(textCategoriaNome.getText());
						controller.ExcluirCategoria(categoria);
						JOptionPane.showMessageDialog(null, "Categoria excluída com sucesso!");
						pesquisar(modelo,null);
						CadastrarActionPerformed();
					}				
					 catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "Erro ao tentar excluir categoria.");
					}
        		}
        	}
        });
		add(btnExcluir);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setForeground(Color.WHITE);
		btnPesquisar.setFont(new Font("Segoe UI Emoji", Font.BOLD, 14));
		btnPesquisar.setBackground(new Color(51, 102, 102));
		btnPesquisar.setBounds(246, 82, 89, 34);
		btnPesquisar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
					try {
	        			pesquisar(modelo,textBuscaCategoria.getText());
						JOptionPane.showMessageDialog(null, "Busca realizada com sucesso!");
					}				
					 catch (Exception e1) {
						JOptionPane.showMessageDialog(null, e1);
					}	
        	}
        });
		add(btnPesquisar);
		
		textBuscaCategoria = new JTextField();
		textBuscaCategoria.setColumns(10);
		textBuscaCategoria.setBounds(14, 80, 220, 34);
		add(textBuscaCategoria);
		
		JLabel labelBuscaCategoria = new JLabel("Nome da Categoria:");
		labelBuscaCategoria.setForeground(new Color(0, 0, 0));
		labelBuscaCategoria.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 14));
		labelBuscaCategoria.setBounds(14, 63, 214, 16);
		add(labelBuscaCategoria);
		
		
		textCategoriaId = new JTextField();
		textCategoriaId.setBounds(364, 52, 13, 28);
		textCategoriaId.setColumns(10);
		
		repaint();
	}
	private void criaJTable() {
		 
		 tabela = new JTable(modelo);
		 tabela.addMouseListener(new java.awt.event.MouseAdapter() {
	            public void mouseClicked(java.awt.event.MouseEvent evt) {
	              jTCategoriaMouseClicked(evt);
	            }
	        });
		 tabela.setShowHorizontalLines(true);
		 tabela.setBackground(Color.WHITE);
		 tabela.setSelectionBackground(new Color(0, 128, 128));
		 modelo.addColumn("ID");
	     modelo.addColumn("Nome");
	     tabela.getColumnModel().getColumn(0).setPreferredWidth(40);
	     tabela.getColumnModel().getColumn(1).setPreferredWidth(40);
	     pesquisar(modelo,null);
	     
	 }
	public static void pesquisar(DefaultTableModel modelo, String param) {
		  modelo.setNumRows(0);
		  for(Categorias categoria : controller.BuscarCategorias(param)) {
			  modelo.addRow(new Object[]{
					  categoria.getCategoriaId(),
					  categoria.getNome()
				   }
			  );
		  }
	}
	
    private void CadastrarActionPerformed() {
    	textCategoriaNome.setText("");
        pesquisar(modelo,null);
    }
       
    private void jTCategoriaMouseClicked(java.awt.event.MouseEvent evt) {
        if (tabela.getSelectedRow() != -1) {
        	textCategoriaId.setText(tabela.getValueAt(tabela.getSelectedRow(), 0).toString());
            textCategoriaNome.setText(tabela.getValueAt(tabela.getSelectedRow(), 1).toString());
        }
    }
   
}
