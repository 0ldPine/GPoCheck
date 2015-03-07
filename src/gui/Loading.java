package gui;

import javax.swing.*;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import common.CONSTANT;

import java.awt.*;
import java.net.URL;

public class Loading extends JWindow implements Runnable {
	private static final long serialVersionUID = 1L;
	Thread splashThread; // 进度条更新线程
	JProgressBar progress; // 进度条

	public Loading() {
		Container container = getContentPane(); // 得到容器
		setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR)); // 设置光标
		URL url = getClass().getResource(CONSTANT.IMAGE_LOADING); // 图片的位置
		if (url != null) {
			container.add(new JLabel(new ImageIcon(url)),
					BorderLayout.CENTER); // 增加图片
		}
		progress = new JProgressBar(1, 100); // 实例化进度条
		progress.setStringPainted(true); // 描绘文字
		progress.setString("加载程序中,请稍候......"); // 设置显示文字
		progress.setBackground(Color.white); // 设置背景色
		container.add(progress, BorderLayout.SOUTH); // 增加进度条到容器上

		Dimension screen = getToolkit().getScreenSize(); // 得到屏幕尺寸
		pack(); // 窗口适应组件尺寸
		setLocation((screen.width - getSize().width) / 2,
				(screen.height - getSize().height) / 2); // 设置窗口位置
	}

	public void start() {
		this.toFront(); // 窗口前端显示
		splashThread = new Thread(this); // 实例化线程
		splashThread.start(); // 开始运行线程
	}

	public void run() {
		setVisible(true); // 显示窗口
		try {
			for (int i = 0; i < 100; i++) {
				Thread.sleep(30); // 线程休眠
				progress.setValue(progress.getValue() + 1); // 设置进度条值
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		dispose(); // 释放窗口
		showChecker(); // 运行主程序
	}

	static void showChecker() {
		GPoCheckGUI gpoCheckGUI = new GPoCheckGUI();
	}

	public static void main(String[] args) {
		try {
			org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
			// 关闭设置按钮
			UIManager.put("RootPane.setupButtonVisible", false);
			// JTabbedPane 没有缩进
			UIManager.put("TabbedPane.tabAreaInsets", new javax.swing.plaf.InsetsUIResource(0, 0, 0, 0));
			// 关闭半透明效果，设置此开关量为false即表示关闭之，BeautyEye LNF中默认是true
			BeautyEyeLNFHelper.translucencyAtFrameInactive = false;
		} catch (Exception e) {
			// TODO exception
		}

		Loading loading = new Loading();
		loading.start(); // 运行启动界面
	}
}
