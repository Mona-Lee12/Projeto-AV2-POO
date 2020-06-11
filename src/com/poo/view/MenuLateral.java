package com.poo.view;

import java.awt.EventQueue;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MenuLateral extends JFrame {

	private JPanel contentPane;
	private PanelHomePage panelHomePage;
	private PanelCategorias panelCategoriasPage;
	private PanelArquivos panelArquivosPage;
	private PanelUsuarios panelUsuariosPage;
	
	
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
		setBounds(100, 100, 789, 390);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(245, 255, 250));
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panelHomePage = new PanelHomePage();
		panelCategoriasPage = new PanelCategorias();
		panelArquivosPage = new PanelArquivos();
		panelUsuariosPage = new PanelUsuarios();
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 156, 1000);
		panel.setBackground(new Color(176, 224, 230));
		contentPane.add(panel);
				panel.setLayout(null);
			
				
				JLabel paneImagem = new JLabel("");
				paneImagem.setBounds(18, 5, 120, 120);
				panel.add(paneImagem);
				paneImagem.setIcon(new ImageIcon("C:\\Users\\Mona Lee\\eclipse-workspace\\projeto-av2\\icons\\logo.png"));
				
				JPanel panelHome = new JPanel();
				panelHome.addMouseListener(new PanelButtonMouseAdapter(panelHome) {
					@Override 
					public void mouseClicked(MouseEvent e) {
						menuClicked(panelHomePage);
					}
				});
				panelHome.setBounds(10, 149, 136, 36);
				panelHome.setBackground(new Color(176, 224, 230));
				panel.add(panelHome);
				panelHome.setLayout(null);
				
				JLabel labelHome = new JLabel("Home");
				labelHome.setHorizontalAlignment(SwingConstants.CENTER);
				labelHome.setFont(new Font("Segoe UI Light", Font.BOLD, 18));
				labelHome.setBounds(0, 0, 136, 36);
				panelHome.add(labelHome);
				
				JPanel panelUsuario = new JPanel();
				panelUsuario.addMouseListener(new PanelButtonMouseAdapter(panelUsuario) {
					@Override 
					public void mouseClicked(MouseEvent e) {
						menuClicked(panelUsuariosPage);
					}
				});
				panelUsuario.setBounds(10, 184, 136, 36);
				panelUsuario.setBackground(new Color(176, 224, 230));
				panel.add(panelUsuario);
				panelUsuario.setLayout(null);
				
				JLabel lblUsuarios = new JLabel("Usu\u00E1rios");
				lblUsuarios.setBounds(0, 0, 136, 36);
				lblUsuarios.setHorizontalAlignment(SwingConstants.CENTER);
				lblUsuarios.setFont(new Font("Segoe UI Light", Font.BOLD, 18));
				panelUsuario.add(lblUsuarios);
				
				JPanel panelArquivos = new JPanel();
				panelArquivos.addMouseListener(new PanelButtonMouseAdapter(panelArquivos) {
					@Override 
					public void mouseClicked(MouseEvent e) {
						menuClicked(panelArquivosPage);
					}
				});
				panelArquivos.setBounds(10, 219, 136, 36);
				panelArquivos.setBackground(new Color(176, 224, 230));
				panel.add(panelArquivos);
				panelArquivos.setLayout(null);
				
				JLabel lblArquivos = new JLabel("Arquivos");
				lblArquivos.setBounds(0, 0, 136, 36);
				lblArquivos.setHorizontalAlignment(SwingConstants.CENTER);
				lblArquivos.setFont(new Font("Segoe UI Light", Font.BOLD, 18));
				panelArquivos.add(lblArquivos);
				
				JPanel panelCategorias = new JPanel();
				panelCategorias.addMouseListener(new PanelButtonMouseAdapter(panelCategorias) {
					@Override 
					public void mouseClicked(MouseEvent e) {
						menuClicked(panelCategoriasPage);
					}
				});
				panelCategorias.setBounds(10, 253, 136, 36);
				panelCategorias.setBackground(new Color(176, 224, 230));
				panel.add(panelCategorias);
				panelCategorias.setLayout(null);
				
				JLabel lblCateg = new JLabel("Categorias");
				lblCateg.setBounds(0, 0, 136, 36);
				lblCateg.setHorizontalAlignment(SwingConstants.CENTER);
				lblCateg.setFont(new Font("Segoe UI Light", Font.BOLD, 18));
				panelCategorias.add(lblCateg);
				
				JPanel panelSair = new JPanel();
				panelSair.addMouseListener(new PanelButtonMouseAdapter(panelSair) {
					@Override 
					public void mouseClicked(MouseEvent e) {
						//Sair do sistema
					}
				});
				panelSair.setBounds(10, 287, 136, 36);
				panel.add(panelSair);
				panelSair.setLayout(null);
				panelSair.setBackground(new Color(176, 224, 230));
				
				JLabel label = new JLabel("Sair");
				label.setHorizontalAlignment(SwingConstants.CENTER);
				label.setFont(new Font("Segoe UI Light", Font.BOLD, 18));
				label.setBounds(0, 0, 136, 36);
				panelSair.add(label);
				
				JPanel panelContentPage = new JPanel();
				panelContentPage.setBounds(166, 11, 597, 329);
				contentPane.add(panelContentPage);
				panelContentPage.setLayout(null);
				
				panelContentPage.add(panelHomePage);
				panelContentPage.add(panelCategoriasPage);
				panelContentPage.add(panelUsuariosPage);
				panelContentPage.add(panelArquivosPage);
				
				menuClicked(panelHomePage);
	}
	
	
	public void menuClicked(JPanel painelSelecionado) {
		panelHomePage.setVisible(false);
		panelCategoriasPage.setVisible(false);
		panelUsuariosPage.setVisible(false);
		panelArquivosPage.setVisible(false);
		
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
			panel.setBackground(new Color(176,224,230));
		}
		@Override
		public void mousePressed(MouseEvent e) {
			panel.setBackground(new Color(255,255,255));
		}
		@Override
		public void mouseReleased(MouseEvent e) {
			panel.setBackground(new Color(176,224,230));
		}		
	}
	
	
}
