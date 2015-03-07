package gui;

import javax.swing.JDialog;

import java.awt.Component;

import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.text.DateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import common.CONSTANT;

import javax.swing.JSeparator;

import java.awt.Color;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.FlowLayout;
import javax.swing.border.LineBorder;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;

public class AboutDiag extends JDialog {

	private static final long serialVersionUID = 1L;

	public void createDiag() {
		setTitle("About");
		
		this.setSize(500, 250);
		
		setResizable(false);
		this.setModal(true);
		getContentPane().setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 150, 222);
		
		panel.add(panel_1);
		
		
		JLabel label = new JLabel("");
		ImageIcon icon = new ImageIcon(getClass().getResource(CONSTANT.IMAGE_ABOUT));
		panel_1.setLayout(new BorderLayout(0, 0));
		label.setIcon(icon);
		panel_1.add(label);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(192, 192, 192), 2));
		panel_2.setBounds(150, 0, 344, 222);
		panel.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		
		JTextArea txtrMmmmm = new JTextArea();
		txtrMmmmm.setEditable(false);
		txtrMmmmm.setBackground(UIManager.getColor("Panel.background"));
		txtrMmmmm.setLineWrap(true);
		
		txtrMmmmm.append(CONSTANT.STR_VERSION);
		txtrMmmmm.append("\n");
		txtrMmmmm.append("welcome");
		
		JScrollPane scrollPane = new JScrollPane(txtrMmmmm);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		panel_2.add(scrollPane);
		
		
		

	}

	public AboutDiag(Component centerRelative) {
		createDiag();
		this.setLocationRelativeTo(centerRelative);
	}

	public AboutDiag() {
		createDiag();
	}
}
