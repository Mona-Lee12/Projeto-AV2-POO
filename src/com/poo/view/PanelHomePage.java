package com.poo.view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class PanelHomePage extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelHomePage() {
		setBounds(0,0,597,329);
		setLayout(null);
		setVisible(true);
		
		JLabel lblHome = new JLabel("This is Home");
		lblHome.setHorizontalAlignment(SwingConstants.CENTER);
		lblHome.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblHome.setBounds(10, 97, 577, 75);
		add(lblHome);
	}
}
