package com.poo.view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.poo.dao.AdminDAO;

import java.awt.Color;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textLogin;
	private JPasswordField textSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				AplicaNimbusLookAndFeel.pegaNimbus();  
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	 public static class AplicaNimbusLookAndFeel {
	   	 
	    	public static void pegaNimbus() {
	    	    try {
	    	        for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
	    	            if ("Nimbus".equals(info.getName())) {
	    	                UIManager.setLookAndFeel(info.getClassName());
	    	                break;
	    	            }
	    	        }
	    	    } catch (UnsupportedLookAndFeelException e) {
	    	         
	    	        System.out.println("Erro: " + e.getMessage());
	    	        e.printStackTrace();
	    	         
	    	    } catch (ClassNotFoundException e) {
	    	         
	    	        System.out.println("Erro: " + e.getMessage());
	    	        e.printStackTrace();
	    	         
	    	    } catch (InstantiationException e) {
	    	         
	    	        System.out.println("Erro: " + e.getMessage());
	    	        e.printStackTrace();
	    	         
	    	    } catch (IllegalAccessException e) {
	    	         
	    	        System.out.println("Erro: " + e.getMessage());
	    	        e.printStackTrace();
	    	    }
	    	}
	    }

	/**
	 * Create the frame.
	 */
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 790, 452);
		//setUndecorated(true); // Remove as bordas 
		contentPane = new JPanel();
		contentPane.setBackground(new Color(176, 224, 230));
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textLogin = new JTextField();
		textLogin.setBounds(277, 148, 234, 36);
		contentPane.add(textLogin);
		textLogin.setColumns(10);
		
		textSenha = new JPasswordField();
		textSenha.setColumns(10);
		textSenha.setBounds(277, 219, 234, 36);
		contentPane.add(textSenha);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminDAO dao = new AdminDAO();
				
				if(dao.checkLogin(textLogin.getText(), new String(textSenha.getPassword()) )) {
					new MenuLateral().setVisible(true);
					dispose();
					JOptionPane.showMessageDialog(null, "Usuário logado.");
					
				} else {
					JOptionPane.showMessageDialog(null, "Usuário ou Senha incorretos.");
				}				
			}						
		});
		btnEntrar.setFont(new Font("Segoe UI", Font.BOLD, 13));
		btnEntrar.setForeground(new Color(47, 79, 79));
		btnEntrar.setBackground(new Color(224, 255, 255));
		btnEntrar.setBounds(352, 266, 90, 28);
		contentPane.add(btnEntrar);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblLogin.setForeground(new Color(255, 255, 255));
		lblLogin.setBounds(276, 119, 90, 26);
		contentPane.add(lblLogin);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setForeground(Color.WHITE);
		lblSenha.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblSenha.setBounds(276, 195, 90, 26);
		contentPane.add(lblSenha);
		
		JLabel panelImagemLogin = new JLabel("");
		panelImagemLogin.setHorizontalAlignment(SwingConstants.CENTER);
		panelImagemLogin.setBounds(277, 0, 234, 120);
		contentPane.add(panelImagemLogin);
		panelImagemLogin.setIcon(new ImageIcon("icons\\logo.png"));
	}
}
