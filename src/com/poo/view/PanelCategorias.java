package com.poo.view;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class PanelCategorias extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelCategorias() {
		setBounds(0,0,597,329);
		setLayout(null);
		
		JLabel lblCategorias = new JLabel("This is Categorias");
		lblCategorias.setHorizontalAlignment(SwingConstants.CENTER);
		lblCategorias.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCategorias.setBounds(10, 97, 577, 75);
		add(lblCategorias);
	}

}
