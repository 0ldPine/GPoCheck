package gui.test;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.UIManager;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JSlider;

public class Beautyeye {

	public static void main(String[] args) {
		try
	    {
	        org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
	        UIManager.put("RootPane.setupButtonVisible", false);
	        //设置此开关量为false即表示关闭之，BeautyEye LNF中默认是true
	        BeautyEyeLNFHelper.translucencyAtFrameInactive = false;
	    }
	    catch(Exception e)
	    {
	        //TODO exception
	    }
		new Beautyeye();
	}
	
	JFrame mFrame;
	
	public Beautyeye(){
		mFrame = new JFrame();
		
		JPanel panel = new JPanel();
		mFrame.getContentPane().add(panel, BorderLayout.CENTER);
		
		mFrame.setBounds(400, 400, 800, 600);
		mFrame.setVisible(true);
	}
	
}
