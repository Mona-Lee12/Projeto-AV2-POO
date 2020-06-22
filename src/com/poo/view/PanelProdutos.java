package com.poo.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.poo.controller.ProdutoController;
import com.poo.model.Produto;

import javax.swing.JButton;

import java.awt.Color;
import javax.swing.SwingConstants;

public class PanelProdutos extends JPanel {
	
	private JTextField textBuscaProduto;
    private JTable tabela;
    private DefaultTableModel modelo = new DefaultTableModel();
    private JTextField textQuantidade;
  
    static ProdutoController produtocontroller = new ProdutoController();
	Produto produto = new Produto();
	private JTextField textPreco;	
	private JTextField textLote;
	private JTextField textCategoria;
	private JTextField textProdutoId;	

	public PanelProdutos() {
		setBackground(new Color(255, 255, 255));

		setForeground(new Color(0, 0, 0));
		setBounds(0, 0, 736, 364);
		setLayout(null);
        
		JLabel labelProdutos = new JLabel("Produtos");
		labelProdutos.setBounds(10, 6, 715, 34);
		labelProdutos.setHorizontalAlignment(SwingConstants.CENTER);
		labelProdutos.setForeground(new Color(95, 158, 160));
		labelProdutos.setBackground(new Color(255, 255, 255));
		labelProdutos.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 28));
		add(labelProdutos);
		
		textBuscaProduto = new JTextField();
		textBuscaProduto.setBounds(10, 72, 260, 34);
		add(textBuscaProduto);
		textBuscaProduto.setColumns(10);
		

		criaJTable("");
		JScrollPane jScrollPane = new JScrollPane();
		jScrollPane.setBounds(10, 171, 610, 182);
		jScrollPane.setBackground(new Color(255, 255, 255));
		jScrollPane.setBorder(null);
		jScrollPane.setViewportBorder(null);
		jScrollPane.setViewportView(tabela);
		jScrollPane.getViewport().setBackground(Color.WHITE);
		tabela.setBackground(Color.WHITE);
		add(jScrollPane);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(630, 167, 95, 40);
		btnCadastrar.setForeground(new Color(255, 255, 255));
		btnCadastrar.setFont(new Font("Segoe UI Emoji", Font.BOLD, 14));
		btnCadastrar.setBackground(new Color(0, 100, 0));
		btnCadastrar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		try {
        			produto.setDescricao(textBuscaProduto.getText());
        			produto.setQtd(Integer.parseInt(textQuantidade.getText()));
        			produto.setPreco(Float.parseFloat(textPreco.getText()));
        			produto.setCategoria(textCategoria.getText());        			
        			produto.setLote(textLote.getText());
        			
        			produtocontroller.CadastrarProduto(produto);
        			JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!");        			
        			CadastrarActionPerformed();
        			
        		} catch (Exception el) {
        			System.out.println(el);
        			JOptionPane.showMessageDialog(null, "Erro ao cadastrar Produto!");	
        		}
        	}
        });
		add(btnCadastrar);
		
		
		JLabel labelPQtd = new JLabel("Quantidade:");
		labelPQtd.setBounds(292, 54, 115, 16);
		labelPQtd.setForeground(new Color(0, 0, 0));
		labelPQtd.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 14));
		add(labelPQtd);
		
		textQuantidade = new JTextField();
		textQuantidade.setBounds(292, 72, 191, 34);
		textQuantidade.setColumns(10);
		add(textQuantidade);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {      		        		
        		try {       			
        			
        			produto.setId(Integer.parseInt(textProdutoId.getText()));
        			produto.setDescricao(textBuscaProduto.getText());
        			produto.setQtd(Integer.parseInt(textQuantidade.getText()));
        			produto.setPreco(Float.parseFloat(textPreco.getText()));
        			produto.setCategoria(textCategoria.getText());        			
        			produto.setLote(textLote.getText());       			       			
					
        			produtocontroller.AtualizarProduto(produto);
					JOptionPane.showMessageDialog(null, "Produto atualizado com sucesso!");
					CadastrarActionPerformed();
				}				
				 catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Erro ao tentar editar Produto!");
				}
    		}
        	
		});
		btnEditar.setBounds(630, 213, 95, 40);
		btnEditar.setForeground(new Color(255, 255, 255));
		btnEditar.setFont(new Font("Segoe UI Emoji", Font.BOLD, 14));
		btnEditar.setBackground(new Color(255, 204, 0));		        
		add(btnEditar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					produto.setId(Integer.parseInt(textProdutoId.getText()));
        			produto.setDescricao(textBuscaProduto.getText());
        			produto.setQtd(Integer.parseInt(textQuantidade.getText()));
        			produto.setPreco(Float.parseFloat(textPreco.getText()));
        			produto.setCategoria(textCategoria.getText());        			
        			produto.setLote(textLote.getText()); 
        			
        			produtocontroller.DeletarProduto(produto);
					JOptionPane.showMessageDialog(null, "Produto excluído com sucesso!");
					CadastrarActionPerformed();
					
				}				
				 catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Erro ao excluir Produto!");
				}
			}
		});
		btnExcluir.setBounds(631, 260, 95, 40);
		btnExcluir.setForeground(new Color(255, 255, 255));
		btnExcluir.setFont(new Font("Segoe UI Emoji", Font.BOLD, 14));
		btnExcluir.setBackground(new Color(255, 0, 0));		        	
		add(btnExcluir);
		
		textPreco = new JTextField();
		textPreco.setBounds(504, 72, 191, 34);
		textPreco.setColumns(10);
		add(textPreco);
		
		JLabel labelPvalor = new JLabel("Pre\u00E7o:");
		labelPvalor.setBounds(505, 54, 89, 16);
		labelPvalor.setForeground(new Color(0, 0, 0));
		labelPvalor.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 14));
		add(labelPvalor);
		
		JLabel lblPDescricao = new JLabel("Descri\u00E7\u00E3o:");
		lblPDescricao.setBounds(10, 54, 214, 16);
		lblPDescricao.setForeground(new Color(0, 0, 0));
		lblPDescricao.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 14));
		add(lblPDescricao);
		
		JLabel lblLote = new JLabel("Lote:");
		lblLote.setForeground(Color.BLACK);
		lblLote.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 14));
		lblLote.setBounds(292, 109, 115, 16);
		add(lblLote);
		
		textLote = new JTextField();
		textLote.setColumns(10);
		textLote.setBounds(292, 126, 191, 34);
		add(textLote);
		
		JLabel lblCategoria = new JLabel("Categoria");
		lblCategoria.setForeground(Color.BLACK);
		lblCategoria.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 14));
		lblCategoria.setBounds(10, 109, 115, 16);
		add(lblCategoria);
		
		textCategoria = new JTextField();
		textCategoria.setColumns(10);
		textCategoria.setBounds(10, 126, 260, 34);
		add(textCategoria);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textBuscaProduto.setText("");
			 	textQuantidade.setText("");
			 	textPreco.setText("");		 	
			 	textCategoria.setText("");       
			 	textLote.setText("");
			}
		});
		btnLimpar.setForeground(new Color(128, 128, 128));
		btnLimpar.setBackground(new Color(224, 255, 255));
		btnLimpar.setBounds(630, 313, 95, 40);
		add(btnLimpar);
		
		textProdutoId = new JTextField();
		textProdutoId.setBounds(122, 10, 13, 28);
		textProdutoId.setColumns(10);
		
		repaint();
		
	}
	 private void criaJTable(String param) {
		 
		 tabela = new JTable(modelo);
		 tabela.addMouseListener(new java.awt.event.MouseAdapter() {
	            public void mouseClicked(java.awt.event.MouseEvent evt) {
	            	jTProdutoMouseClicked(evt);
	            }
	        });
		 tabela.setSelectionBackground(new Color(0, 128, 128));
		 tabela.setShowHorizontalLines(true);
		 modelo.addColumn("ID");
	     modelo.addColumn("Descricao");
	     modelo.addColumn("Qtd");
	     modelo.addColumn("Preco");
	     modelo.addColumn("Categoria");	     
	     modelo.addColumn("Lote");
	     tabela.getColumnModel().getColumn(0).setPreferredWidth(10);
	     tabela.getColumnModel().getColumn(1).setPreferredWidth(20);
	     tabela.getColumnModel().getColumn(2).setPreferredWidth(20);
	     tabela.getColumnModel().getColumn(3).setPreferredWidth(20);
	     tabela.getColumnModel().getColumn(4).setPreferredWidth(20);
	     tabela.getColumnModel().getColumn(5).setPreferredWidth(20);	     
	     pesquisar(modelo);
	     
	 }
	public static void pesquisar(DefaultTableModel modelo) {
		  modelo.setNumRows(0);
		  for(Produto p : ProdutoController.BuscarProdutos()) {
			  modelo.addRow(new Object[]{
					  p.getId(),
					  p.getDescricao(),
					  p.getQtd(),
					  p.getPreco(),
					  p.getCategoria(),					  
					  p.getLote()					  
				  }
			 );
		}
	}  
	
	 private void CadastrarActionPerformed() {
		 	textBuscaProduto.setText("");
		 	textQuantidade.setText("");
		 	textPreco.setText("");		 	
		 	textCategoria.setText("");       
		 	textLote.setText("");
	        pesquisar(modelo);
	    }
	    
	   
	    private void jTProdutoMouseClicked(java.awt.event.MouseEvent evt) {
	        if (tabela.getSelectedRow() != -1) {
	        	
	        	textProdutoId.setText(tabela.getValueAt(tabela.getSelectedRow(), 0).toString());
	        	textBuscaProduto.setText(tabela.getValueAt(tabela.getSelectedRow(), 1).toString());
	        	textQuantidade.setText(tabela.getValueAt(tabela.getSelectedRow(), 2).toString());
	        	textPreco.setText(tabela.getValueAt(tabela.getSelectedRow(), 3).toString());	        	
	        	textCategoria.setText(tabela.getValueAt(tabela.getSelectedRow(), 4).toString());
	        	textLote.setText(tabela.getValueAt(tabela.getSelectedRow(), 5).toString());
	     
	        }
	    }
}
