package com.poo.view;

import java.awt.EventQueue;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuLateral extends JFrame {

	private JPanel contentPane;
	private PanelHomePage panelHomePage;
	private PanelCategorias panelCategoriasPage;
	private PanelProdutos panelProdutosPage;
	private PanelFuncionarios panelFuncionariosPage;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuLateral frame = new MenuLateral();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MenuLateral() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 924, 419);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panelHomePage = new PanelHomePage();
		panelHomePage.setBounds(0, 0, 736, 364);
		panelCategoriasPage = new PanelCategorias();
		panelProdutosPage = new PanelProdutos();
		panelFuncionariosPage = new PanelFuncionarios();
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 156, 380);
		panel.setBackground(new Color(153, 204, 204));
		contentPane.add(panel);
				panel.setLayout(null);
			
				
		JLabel paneImagem = new JLabel("");
		paneImagem.setBounds(20, 17, 136, 120);
		panel.add(paneImagem);
		paneImagem.setIcon(new ImageIcon("icons\\carro.png"));
		
		JPanel panelHome = new JPanel();
		panelHome.addMouseListener(new PanelButtonMouseAdapter(panelHome) {
			@Override 
			public void mouseClicked(MouseEvent e) {
				menuClicked(panelHomePage);
			}
		});
		panelHome.setBounds(10, 149, 136, 36);
		panelHome.setBackground(new Color(153, 204, 204));
		panel.add(panelHome);
		panelHome.setLayout(null);
		
		JLabel labelHome = new JLabel("Home");
		labelHome.setBackground(new Color(153, 204, 204));
		labelHome.setHorizontalAlignment(SwingConstants.CENTER);
		labelHome.setFont(new Font("Segoe UI Light", Font.BOLD, 18));
		labelHome.setBounds(6, 0, 130, 36);
		panelHome.add(labelHome);
		
		JPanel panelUsuario = new JPanel();
		panelUsuario.addMouseListener(new PanelButtonMouseAdapter(panelUsuario) {
			@Override 
			public void mouseClicked(MouseEvent e) {
				menuClicked(panelFuncionariosPage);
			}
		});
		panelUsuario.setBounds(10, 184, 136, 36);
		panelUsuario.setBackground(new Color(153, 204, 204));
		panel.add(panelUsuario);
		panelUsuario.setLayout(null);
		
		JLabel lblUsuarios = new JLabel("Funcion\u00E1rios");
		lblUsuarios.setBounds(6, 0, 130, 36);
		lblUsuarios.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsuarios.setFont(new Font("Segoe UI Light", Font.BOLD, 18));
		panelUsuario.add(lblUsuarios);
		
		JPanel panelArquivos = new JPanel();
		panelArquivos.addMouseListener(new PanelButtonMouseAdapter(panelArquivos) {
			@Override 
			public void mouseClicked(MouseEvent e) {
				menuClicked(panelProdutosPage);
			}
		});
		panelArquivos.setBounds(10, 219, 136, 36);
		panelArquivos.setBackground(new Color(153, 204, 204));
		panel.add(panelArquivos);
		panelArquivos.setLayout(null);
		
		JLabel lblProdutos = new JLabel("Produtos");
		lblProdutos.setBackground(new Color(153, 204, 204));
		lblProdutos.setBounds(6, 0, 130, 36);
		lblProdutos.setHorizontalAlignment(SwingConstants.CENTER);
		lblProdutos.setFont(new Font("Segoe UI Light", Font.BOLD, 18));
		panelArquivos.add(lblProdutos);
		
		JPanel panelCategorias = new JPanel();
		panelCategorias.addMouseListener(new PanelButtonMouseAdapter(panelCategorias) {
			@Override 
			public void mouseClicked(MouseEvent e) {
				menuClicked(panelCategoriasPage);
			}
		});
		panelCategorias.setBounds(10, 253, 136, 36);
		panelCategorias.setBackground(new Color(153, 204, 204));
		panel.add(panelCategorias);
		panelCategorias.setLayout(null);
		
		JLabel lblCateg = new JLabel("Categorias");
		lblCateg.setBounds(6, 0, 124, 36);
		lblCateg.setHorizontalAlignment(SwingConstants.CENTER);
		lblCateg.setFont(new Font("Segoe UI Light", Font.BOLD, 18));
		panelCategorias.add(lblCateg);	
		
		JButton btnNewButton = new JButton("Sair");
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setForeground(new Color(51, 102, 102));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int confirm = JOptionPane.showConfirmDialog(panel, "Tem certeza que deseja sair?");
				if(confirm == 0) {
					dispose();
					new Login().setVisible(true);
					setVisible(false);
				} else {
					return;
				}
			}
		});
		
		btnNewButton.setFont(new Font("Segoe UI Light", Font.BOLD, 18));		
		btnNewButton.setBounds(33, 304, 91, 30);		
		panel.add(btnNewButton);
		
		JPanel panelContentPage = new JPanel();
		panelContentPage.setBounds(166, 11, 736, 363);
		contentPane.add(panelContentPage);
		panelContentPage.setLayout(null);
		
		panelContentPage.add(panelHomePage);
		panelContentPage.add(panelCategoriasPage);
		panelContentPage.add(panelFuncionariosPage);
		panelContentPage.add(panelProdutosPage);
		
		menuClicked(panelHomePage);
	}
	
	
	public void menuClicked(JPanel painelSelecionado) {
		panelHomePage.setVisible(false);
		panelCategoriasPage.setVisible(false);
		panelFuncionariosPage.setVisible(false);
		panelProdutosPage.setVisible(false);
		
		painelSelecionado.setVisible(true);
	}
	
	private class PanelButtonMouseAdapter extends MouseAdapter {
		JPanel panel;
		
		public PanelButtonMouseAdapter(JPanel panel) {
			this.panel = panel;
		}
		@Override
		public void mouseEntered(MouseEvent e) {
			panel.setBackground(new Color(230,230,250));
		}
		@Override
		public void mouseExited(MouseEvent e) {
			panel.setBackground(new Color(153, 204, 204));
		}
		@Override
		public void mousePressed(MouseEvent e) {
			panel.setBackground(new Color(255,255,255));
		}
		@Override
		public void mouseReleased(MouseEvent e) {
			panel.setBackground(new Color(153, 204, 204));
		}		
	}
}
