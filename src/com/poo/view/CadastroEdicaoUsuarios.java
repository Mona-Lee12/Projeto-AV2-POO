package com.poo.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;

public class CadastroEdicaoUsuarios extends JPanel {
	private JTextField textNome;
	private JTextField textTelefone;
	private JTextField textLogin;
	private JTextField textCpf;
	private JTextField textEmail;
	private JPasswordField textSenha;
	/**
	 * Create the panel.
	 */
	public CadastroEdicaoUsuarios() {
		setBounds(0,0,597,329);
		setBackground(new Color(255, 255, 255));
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(null);
		setVisible(true);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCadastrar.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 15));
		btnCadastrar.setBackground(new Color(46, 139, 87));
		btnCadastrar.setForeground(new Color(255, 255, 255));
		btnCadastrar.setBounds(500, 290, 91, 36);
		add(btnCadastrar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 15));
		btnVoltar.setForeground(new Color(95, 158, 160));
		btnVoltar.setBackground(new Color(255, 255, 255));
		btnVoltar.setBounds(405, 290, 93, 36);
		btnVoltar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        
        	}
		});
		add(btnVoltar);
		
		textNome = new JTextField();
		textNome.setBounds(10, 82, 353, 33);
		add(textNome);
		textNome.setColumns(10);
		
		textTelefone = new JTextField();
		textTelefone.setColumns(10);
		textTelefone.setBounds(395, 147, 196, 33);
		add(textTelefone);
		
		textLogin = new JTextField();
		textLogin.setColumns(10);
		textLogin.setBounds(10, 212, 353, 33);
		add(textLogin);
		
		textCpf = new JTextField();
		textCpf.setColumns(10);
		textCpf.setBounds(395, 82, 196, 33);
		add(textCpf);
		
		textEmail = new JTextField();
		textEmail.setColumns(10);
		textEmail.setBounds(10, 147, 353, 33);
		add(textEmail);
		
		JLabel lblNome = new JLabel("Nome Completo:");
		lblNome.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 15));
		lblNome.setBounds(10, 63, 121, 21);
		add(lblNome);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 15));
		lblCpf.setBounds(395, 63, 121, 21);
		add(lblCpf);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 15));
		lblTelefone.setBounds(395, 127, 121, 21);
		add(lblTelefone);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 15));
		lblEmail.setBounds(10, 126, 121, 21);
		add(lblEmail);
		
		textSenha = new JPasswordField();
		textSenha.setBounds(395, 212, 196, 33);
		add(textSenha);
		
		JLabel lblLogin = new JLabel("Nome de Usu\u00E1rio:");
		lblLogin.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 15));
		lblLogin.setBounds(10, 192, 121, 21);
		add(lblLogin);
		
		JLabel lblSenha = new JLabel("Senha de Acesso:");
		lblSenha.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 15));
		lblSenha.setBounds(395, 192, 121, 21);
		add(lblSenha);
		
		JLabel lblCadastrarUsuario = new JLabel("Cadastrar Usu\u00E1rio");
		lblCadastrarUsuario.setForeground(new Color(95, 158, 160));
		lblCadastrarUsuario.setBackground(new Color(255, 255, 255));
		lblCadastrarUsuario.setFont(new Font("Segoe UI Emoji", Font.BOLD, 28));
		lblCadastrarUsuario.setBounds(193, 6, 292, 36);
		add(lblCadastrarUsuario);
		
		JLabel lblObrigatoriedade1 = new JLabel("*");
		lblObrigatoriedade1.setHorizontalAlignment(SwingConstants.CENTER);
		lblObrigatoriedade1.setForeground(new Color(255, 0, 0));
		lblObrigatoriedade1.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 15));
		lblObrigatoriedade1.setBounds(125, 63, 19, 18);
		add(lblObrigatoriedade1);
		
		JLabel lblObrigatoriedade2 = new JLabel("*");
		lblObrigatoriedade2.setHorizontalAlignment(SwingConstants.CENTER);
		lblObrigatoriedade2.setForeground(Color.RED);
		lblObrigatoriedade2.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 15));
		lblObrigatoriedade2.setBounds(125, 192, 19, 18);
		add(lblObrigatoriedade2);
		
		JLabel lblObrigatoriedade3 = new JLabel("*");
		lblObrigatoriedade3.setHorizontalAlignment(SwingConstants.CENTER);
		lblObrigatoriedade3.setForeground(Color.RED);
		lblObrigatoriedade3.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 15));
		lblObrigatoriedade3.setBounds(507, 192, 19, 18);
		add(lblObrigatoriedade3);
	}

}
