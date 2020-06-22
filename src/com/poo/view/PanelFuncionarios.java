package com.poo.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.poo.controller.FuncionariosController;
import com.poo.model.Funcionarios;

import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;

import java.awt.Color;
import javax.swing.SwingConstants;

public class PanelFuncionarios extends JPanel {

	private JTextField textBuscaUsuario;
    private JTable tabela;
    private DefaultTableModel modelo = new DefaultTableModel();
    private JTextField textNome;
  
    static FuncionariosController Funcionariocontroller = new FuncionariosController();
	Funcionarios funcionarios = new Funcionarios();
	private JTextField textCpf;
	private JTextField textEmail;
	private JTextField textTelefone;
	private JTextField textCargo;
	private JTextField textSalario;
	private JTextField textFuncionarioId;

	public PanelFuncionarios() {
		setBackground(new Color(255, 255, 255));

		setForeground(new Color(0, 0, 0));
		setBounds(0, 0, 736, 364);
		setLayout(null);
        
		JLabel labelFuncionarios = new JLabel("Funcion\u00E1rios");
		labelFuncionarios.setBounds(10, 6, 715, 34);
		labelFuncionarios.setHorizontalAlignment(SwingConstants.CENTER);
		labelFuncionarios.setForeground(new Color(95, 158, 160));
		labelFuncionarios.setBackground(new Color(255, 255, 255));
		labelFuncionarios.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 28));
		add(labelFuncionarios);
		
		textBuscaUsuario = new JTextField();
		textBuscaUsuario.setBounds(10, 72, 260, 34);
		add(textBuscaUsuario);
		textBuscaUsuario.setColumns(10);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setBounds(282, 72, 89, 34);
		btnPesquisar.setFont(new Font("Segoe UI Emoji", Font.BOLD, 14));
		btnPesquisar.setForeground(new Color(255, 255, 255));
		btnPesquisar.setBackground(new Color(51, 102, 102));
		btnPesquisar.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		try {
	        			pesquisar(modelo,textBuscaUsuario.getText());
						JOptionPane.showMessageDialog(null, "Busca realizada com sucesso!");
					}				
					 catch (Exception e1) {
						JOptionPane.showMessageDialog(null, e1);
					}	
	        	}
	        });
		add(btnPesquisar);
		

		criaJTable("");
		JScrollPane jScrollPane = new JScrollPane();
		jScrollPane.setBounds(10, 118, 715, 124);
		jScrollPane.setBackground(new Color(255, 255, 255));
		jScrollPane.setBorder(null);
		jScrollPane.setViewportBorder(null);
		jScrollPane.setViewportView(tabela);
		jScrollPane.getViewport().setBackground(Color.WHITE);
		tabela.setBackground(Color.WHITE);
		add(jScrollPane);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(636, 244, 89, 34);
		btnCadastrar.setForeground(new Color(255, 255, 255));
		btnCadastrar.setFont(new Font("Segoe UI Emoji", Font.BOLD, 14));
		btnCadastrar.setBackground(new Color(0, 100, 0));
		btnCadastrar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		try {						
					funcionarios.setNome(textNome.getText());
					funcionarios.setCpf(textCpf.getText());
					funcionarios.setEmail(textEmail.getText());
					funcionarios.setTelefone(textTelefone.getText());
					funcionarios.setCargo(textCargo.getText());
					funcionarios.setSalario(Float.parseFloat(textSalario.getText()));
					Funcionariocontroller.CadastrarFuncionarios(funcionarios);
					JOptionPane.showMessageDialog(null, "Funcionário cadastrado com sucesso!");
					CadastrarActionPerformed();
					
				}				
				 catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Erro ao cadastrar Funcionário!");
				}
        	}
        });
		add(btnCadastrar);
		
		
		JLabel labelNome = new JLabel("Nome:");
		labelNome.setBounds(10, 253, 45, 16);
		labelNome.setForeground(new Color(0, 0, 0));
		labelNome.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 14));
		add(labelNome);
		
		textNome = new JTextField();
		textNome.setBounds(10, 268, 248, 34);
		textNome.setColumns(10);
		add(textNome);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setBounds(636, 286, 89, 34);
		btnEditar.setForeground(new Color(255, 255, 255));
		btnEditar.setFont(new Font("Segoe UI Emoji", Font.BOLD, 14));
		btnEditar.setBackground(new Color(255, 204, 0));
		btnEditar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		try {		
        			funcionarios.setFuncionarioId(Integer.parseInt(textFuncionarioId.getText()));
					funcionarios.setNome(textNome.getText());
					funcionarios.setCpf(textCpf.getText());
					funcionarios.setEmail(textEmail.getText());
					funcionarios.setTelefone(textTelefone.getText());
					funcionarios.setCargo(textCargo.getText());
					funcionarios.setSalario(Float.parseFloat(textSalario.getText()));
					Funcionariocontroller.EditarFuncionarios(funcionarios);
					JOptionPane.showMessageDialog(null, "Funcionário editado com sucesso!");
					CadastrarActionPerformed();
					
				}				
				 catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Erro ao editar Funcionário!");
				}
        	}
        });
		add(btnEditar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(636, 326, 89, 34);
		btnExcluir.setForeground(new Color(255, 255, 255));
		btnExcluir.setFont(new Font("Segoe UI Emoji", Font.BOLD, 14));
		btnExcluir.setBackground(new Color(255, 0, 0));
		btnExcluir.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		try {
        			funcionarios.setFuncionarioId(Integer.parseInt(textFuncionarioId.getText()));
					funcionarios.setNome(textNome.getText());
					funcionarios.setCpf(textCpf.getText());
					funcionarios.setEmail(textEmail.getText());
					funcionarios.setTelefone(textTelefone.getText());
					funcionarios.setCargo(textCargo.getText());
					funcionarios.setSalario(Float.parseFloat(textSalario.getText()));
					Funcionariocontroller.ExcluirFuncionarios(funcionarios);
					JOptionPane.showMessageDialog(null, "Funcionário excluído com sucesso!");
					CadastrarActionPerformed();
					
				}				
				 catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Erro ao excluir Funcionário!");
				}
        	}
        });
		add(btnExcluir);
		
		textCpf = new JTextField();
		textCpf.setBounds(268, 268, 167, 34);
		textCpf.setColumns(10);
		add(textCpf);
		
		JLabel labelCpf = new JLabel("CPF:");
		labelCpf.setBounds(268, 253, 43, 16);
		labelCpf.setForeground(new Color(0, 0, 0));
		labelCpf.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 14));
		add(labelCpf);
		
		textEmail = new JTextField();
		textEmail.setBounds(350, 324, 256, 34);
		textEmail.setColumns(10);
		add(textEmail);
		
		JLabel labelEmail = new JLabel("E-mail:");
		labelEmail.setBounds(350, 310, 89, 16);
		labelEmail.setForeground(new Color(0, 0, 0));
		labelEmail.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 14));
		add(labelEmail);
		
		textTelefone = new JTextField();
		textTelefone.setBounds(10, 324, 162, 34);
		textTelefone.setColumns(10);
		add(textTelefone);
		
		JLabel labelTelefone = new JLabel("Telefone:");
		labelTelefone.setBounds(10, 310, 62, 16);
		labelTelefone.setForeground(new Color(0, 0, 0));
		labelTelefone.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 14));
		add(labelTelefone);
		
		textCargo = new JTextField();
		textCargo.setBounds(451, 268, 152, 34);
		textCargo.setColumns(10);
		add(textCargo);
		
		textSalario = new JTextField();
		textSalario.setBounds(184, 324, 152, 34);
		textSalario.setColumns(10);
		add(textSalario);
		
		JLabel labelCargo = new JLabel("Cargo:");
		labelCargo.setBounds(451, 253, 89, 16);
		labelCargo.setForeground(new Color(0, 0, 0));
		labelCargo.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 14));
		add(labelCargo);
		
		JLabel labelSalario = new JLabel("Sal\u00E1rio:");
		labelSalario.setBounds(186, 310, 89, 16);
		labelSalario.setForeground(new Color(0, 0, 0));
		labelSalario.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 14));
		add(labelSalario);
		
		JLabel lblInformeONome = new JLabel("Nome do Funcion\u00E1rio:");
		lblInformeONome.setBounds(10, 54, 214, 16);
		lblInformeONome.setForeground(new Color(0, 0, 0));
		lblInformeONome.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 14));
		add(lblInformeONome);
		
		JLabel label = new JLabel("*");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.RED);
		label.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 15));
		label.setBounds(47, 251, 19, 18);
		add(label);
		
		JLabel label_1 = new JLabel("*");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(Color.RED);
		label_1.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 15));
		label_1.setBounds(292, 251, 19, 18);
		add(label_1);
		
		textFuncionarioId = new JTextField();
		textFuncionarioId.setBounds(122, 10, 13, 28);
		textFuncionarioId.setColumns(10);
		
		repaint();
		tabela.setVisible(true);
		
	}
	 private void criaJTable(String param) {
		 
		 tabela = new JTable(modelo);
		 tabela.addMouseListener(new java.awt.event.MouseAdapter() {
	            public void mouseClicked(java.awt.event.MouseEvent evt) {
	              jTFuncionariosMouseClicked(evt);
	            }
	        });
		 tabela.setSelectionBackground(new Color(0, 128, 128));
		 tabela.setShowHorizontalLines(true);
		 modelo.addColumn("ID");
	     modelo.addColumn("Nome");
	     modelo.addColumn("CPF");
	     modelo.addColumn("Telefone");
	     modelo.addColumn("Email");
	     modelo.addColumn("Cargo");
	     modelo.addColumn("Salario");
	     tabela.getColumnModel().getColumn(0).setPreferredWidth(10);
	     tabela.getColumnModel().getColumn(1).setPreferredWidth(20);
	     tabela.getColumnModel().getColumn(2).setPreferredWidth(20);
	     tabela.getColumnModel().getColumn(3).setPreferredWidth(20);
	     tabela.getColumnModel().getColumn(4).setPreferredWidth(20);
	     tabela.getColumnModel().getColumn(5).setPreferredWidth(20);
	     tabela.getColumnModel().getColumn(6).setPreferredWidth(20);
	     pesquisar(modelo,"");
	     
	 }
	public static void pesquisar(DefaultTableModel modelo, String param) {
		  modelo.setNumRows(0);
		  for(Funcionarios f : Funcionariocontroller.BuscarFuncionarios(param)) {
			  modelo.addRow(new Object[]{
					  f.getFuncionarioId(),
					  f.getNome(),
					  f.getCpf(),
					  f.getTelefone(),
					  f.getEmail(),
					  f.getCargo(),
					  f.getSalario()
				  }
			 );
		}
	}
	
    private void CadastrarActionPerformed() {
        textNome.setText("");
        textCpf.setText("");
        textEmail.setText("");
        textTelefone.setText("");
        textCargo.setText("");
        textSalario.setText("");
        pesquisar(modelo,null);
    }
    
   
    private void jTFuncionariosMouseClicked(java.awt.event.MouseEvent evt) {
        if (tabela.getSelectedRow() != -1) {
        	
        	textFuncionarioId.setText(tabela.getValueAt(tabela.getSelectedRow(), 0).toString());
            textNome.setText(tabela.getValueAt(tabela.getSelectedRow(), 1).toString());
            textCpf.setText(tabela.getValueAt(tabela.getSelectedRow(), 2).toString());
            textTelefone.setText(tabela.getValueAt(tabela.getSelectedRow(), 3).toString());
            textEmail.setText(tabela.getValueAt(tabela.getSelectedRow(), 4).toString());
            textCargo.setText(tabela.getValueAt(tabela.getSelectedRow(), 5).toString());
            textSalario.setText(tabela.getValueAt(tabela.getSelectedRow(), 6).toString());
     
        }
    }

}
