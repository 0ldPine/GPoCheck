package gui.test;

import javax.swing.JFrame;

public class StandardTemplate {
	JFrame mFrame;
	
	public StandardTemplate(){
		mFrame = new JFrame();
		mFrame.setBounds(400, 400, 800, 600);
		mFrame.setVisible(true);
	}
}
