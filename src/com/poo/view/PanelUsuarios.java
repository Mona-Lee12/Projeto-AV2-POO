package com.poo.view;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class PanelUsuarios extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelUsuarios() {
		setBounds(0,0,597,329);
		setLayout(null);
		
		JLabel lblUsuarios = new JLabel("This is Users");
		lblUsuarios.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsuarios.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblUsuarios.setBounds(10, 97, 577, 75);
		add(lblUsuarios);
	}

}
