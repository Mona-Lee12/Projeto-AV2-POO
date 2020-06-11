package com.poo.view;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class PanelArquivos extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelArquivos() {
		setBounds(0,0,597,329);
		setLayout(null);
		
		JLabel lblArquivos = new JLabel("This is Arquivos");
		lblArquivos.setHorizontalAlignment(SwingConstants.CENTER);
		lblArquivos.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblArquivos.setBounds(10, 97, 577, 75);
		add(lblArquivos);
	}

}
