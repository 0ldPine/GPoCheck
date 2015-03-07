package gui;

import gpocheck.GPoCheck;
import gui.comp.ButtonTabComponent;
import gui.comp.GPoTreeViewer;
import gui.comp.MemoryPanel;

import javax.swing.JFrame;
import javax.swing.UIManager;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.fife.ui.rsyntaxtextarea.AbstractTokenMakerFactory;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rsyntaxtextarea.SyntaxConstants;
import org.fife.ui.rsyntaxtextarea.TokenMakerFactory;
import org.fife.ui.rtextarea.RTextScrollPane;
import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;
import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.FrameBorderStyle;
import org.jb2011.lnf.beautyeye.ch3_button.BEButtonUI;

import common.CONSTANT;
import parse.common.GPoMvLexer;
import parse.common.GPoMvParser;
import parse.common.GpoCheckTokenMaker;
import util.file.FileUtilities;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.UnsupportedLookAndFeelException;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import javax.swing.JTextArea;
import javax.swing.JScrollPane;

import java.awt.Font;

import javax.swing.border.LineBorder;

import java.awt.Color;

public class GPoCheckGUI extends JFrame {

	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		// 设置字体
		// GUIUtil.setGlobalFontSetting(new Font(null, 0, 12));
		new GPoCheckGUI();
	}

	private JTabbedPane editorTabbedPane = null;
	private JTabbedPane currentStateTabbedPane = null;
	private JTabbedPane infoTabbedPane = null;
	private JTextArea textAreaModuleFile = null;
	private JTextArea textAreaPropertyFile = null;
	private JTextArea textAreaLog = null;
	private JPanel panelModuleTree  = null;

	public GPoCheckGUI() {

		setThemeDefault();
		setIconImage(new ImageIcon(getClass().getResource(CONSTANT.IMAGE_FILE_16_16)).getImage());
		setTitle(CONSTANT.STR_VERSION);
		this.setBounds(400, 400, 1024, 738);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		// Dimension size = this.getSize();
		// int x = (screenSize.width - size.width) / 2;
		// int y = (screenSize.height - size.height) / 2;
		// this.setLocation( x, y );
		setLocationRelativeTo(null); // frame center

		final JPanel mainPanel = new JPanel();
		this.getContentPane().add(mainPanel, BorderLayout.CENTER);
		mainPanel.setLayout(new BorderLayout(0, 0));

		JSplitPane splitPaneMainFrame = new JSplitPane();
		mainPanel.add(splitPaneMainFrame, BorderLayout.CENTER);

		JPanel panelLeft = new JPanel();
		splitPaneMainFrame.setLeftComponent(panelLeft);
		panelLeft.setLayout(new BorderLayout(0, 0));

		JSplitPane splitPaneLeftFrame = new JSplitPane();
		splitPaneLeftFrame.setOrientation(JSplitPane.VERTICAL_SPLIT);
		panelLeft.add(splitPaneLeftFrame, BorderLayout.CENTER);
		splitPaneLeftFrame.setDividerLocation(400);

		currentStateTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		currentStateTabbedPane.setFont(CONSTANT.FONT_DEFAULT);
		JPanel currentPanel = new JPanel();
		currentStateTabbedPane.addTab("Current State", currentPanel);
		currentPanel.setLayout(null);

		JLabel lblModuleFile = new JLabel("Module File :");
		lblModuleFile.setBounds(10, 10, 94, 15);
		currentPanel.add(lblModuleFile);

		JLabel lblPropertyFile = new JLabel("Property File :");
		lblPropertyFile.setBounds(10, 77, 94, 15);
		currentPanel.add(lblPropertyFile);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(110, 10, 172, 62);
		currentPanel.add(scrollPane_2);

		textAreaModuleFile = new JTextArea();
		textAreaModuleFile.setFont(CONSTANT.FONT_DEFAULT);
		scrollPane_2.setViewportView(textAreaModuleFile);
		textAreaModuleFile.setLineWrap(true);
		textAreaModuleFile.setWrapStyleWord(true);
		textAreaModuleFile.setEditable(false);
		textAreaModuleFile.setBackground(UIManager.getColor("Panel.background"));

		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(110, 82, 172, 62);
		currentPanel.add(scrollPane_3);

		textAreaPropertyFile = new JTextArea();
		textAreaPropertyFile.setFont(CONSTANT.FONT_DEFAULT);
		textAreaPropertyFile.setBackground(UIManager.getColor("Panel.background"));
		scrollPane_3.setViewportView(textAreaPropertyFile);
		textAreaPropertyFile.setLineWrap(true);
		textAreaPropertyFile.setWrapStyleWord(true);
		textAreaPropertyFile.setEditable(false);
		splitPaneLeftFrame.setBottomComponent(currentStateTabbedPane);

		
		infoTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		panelModuleTree = new JPanel();
		infoTabbedPane.setFont(CONSTANT.FONT_DEFAULT);
		infoTabbedPane.addTab("Moudle", panelModuleTree);
		panelModuleTree.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPaneModuleTree = new JScrollPane();
		panelModuleTree.add(scrollPaneModuleTree);
		JPanel panelLog = new JPanel();
		infoTabbedPane.addTab("Log", panelLog);
		panelLog.setLayout(new BorderLayout(0, 0));

		textAreaLog = new JTextArea();
		textAreaLog.setFont(new Font("Consolas", Font.PLAIN, 12));
		textAreaLog.setWrapStyleWord(true);
		textAreaLog.setLineWrap(true);

		JScrollPane scrollPaneLog = new JScrollPane(textAreaLog);
		panelLog.add(scrollPaneLog, BorderLayout.CENTER);

		splitPaneLeftFrame.setTopComponent(infoTabbedPane);

		JPanel panelRight = new JPanel();
		splitPaneMainFrame.setRightComponent(panelRight);
		panelRight.setLayout(new BorderLayout(0, 0));

		editorTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		panelRight.add(editorTabbedPane);

		JPanel editorPanel = new JPanel(new BorderLayout());
		RSyntaxTextArea textArea = new RSyntaxTextArea();
		textArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_JAVA);
		textArea.setCodeFoldingEnabled(true);
		RTextScrollPane sp = new RTextScrollPane(textArea);
		editorPanel.add(sp);

		JToolBar toolsBar = new JToolBar();
		toolsBar.setFloatable(false);
		mainPanel.add(toolsBar, BorderLayout.NORTH);

		JButton btnNew = new JButton("");
		btnNew.setToolTipText("New");
		btnNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				newFile();
			}
		});
		btnNew.setIcon(new ImageIcon(GPoCheckGUI.class.getResource(CONSTANT.IMAGE_NEW)));

		// 设置按钮颜色
		btnNew.setUI(new BEButtonUI().setNormalColor(BEButtonUI.NormalColor.lightBlue));
		toolsBar.add(btnNew);

		JButton btnOpen = new JButton("");
		btnOpen.setIcon(new ImageIcon(GPoCheckGUI.class.getResource(CONSTANT.IMAGE_OPEN)));
		btnOpen.setToolTipText("Open");
		btnOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File file = openFile();
				createTabbedByFile(file);
			}
		});
		toolsBar.add(btnOpen);

		JButton btnAdd = new JButton("");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		JButton btnSave = new JButton("");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saveFile();
			}
		});
		btnSave.setToolTipText("Save");
		btnSave.setIcon(new ImageIcon(GPoCheckGUI.class.getResource("/images/smallSave.png")));
		toolsBar.add(btnSave);

		JButton btnSaveAll = new JButton("");
		btnSaveAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saveAsFile();
			}
		});
		btnSaveAll.setToolTipText("Save All");
		btnSaveAll.setIcon(new ImageIcon(GPoCheckGUI.class.getResource("/images/smallSaveAs.png")));
		toolsBar.add(btnSaveAll);
		btnAdd.setIcon(new ImageIcon(GPoCheckGUI.class.getResource(CONSTANT.IMAGE_ADDFONT)));
		btnAdd.setToolTipText("Add Font");
		toolsBar.add(btnAdd);

		JButton btnDecrease = new JButton("");
		btnDecrease.setIcon(new ImageIcon(GPoCheckGUI.class.getResource(CONSTANT.IMAGE_DECREASEFONT)));
		btnDecrease.setToolTipText("Decrease Font");
		toolsBar.add(btnDecrease);

		JButton btnRun = new JButton("");
		btnRun.setIcon(new ImageIcon(GPoCheckGUI.class.getResource(CONSTANT.IMAGE_RUN)));
		btnRun.setToolTipText("Run");
		btnRun.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				runChecker();
			}
		});

		toolsBar.addSeparator();

		JButton btnLoadmoudle = new JButton("");
		btnLoadmoudle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadModuleFile();
			}
		});
		btnLoadmoudle.setToolTipText("Load Current Module");
		btnLoadmoudle.setIcon(new ImageIcon(GPoCheckGUI.class.getResource(CONSTANT.IMAGE_LOADMOUDLE)));
		toolsBar.add(btnLoadmoudle);

		JButton btnLoadproperty = new JButton("");
		btnLoadproperty.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadPropertyFile();
			}
		});
		btnLoadproperty.setToolTipText("Load Current Property");
		btnLoadproperty.setIcon(new ImageIcon(GPoCheckGUI.class.getResource(CONSTANT.IMAGE_LOADPORPERTY)));
		toolsBar.add(btnLoadproperty);

		JButton btnLoad = new JButton("");
		btnLoad.setToolTipText("Load Current Module and Property");
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadFile();
			}
		});
		btnLoad.setIcon(new ImageIcon(GPoCheckGUI.class.getResource(CONSTANT.IMAGE_LOAD)));
		toolsBar.add(btnLoad);
		toolsBar.add(btnRun);

		toolsBar.addSeparator();

		JButton btnDebug = new JButton("Debug");
		btnDebug.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		toolsBar.add(btnDebug);

		JButton btnShowmoudle = new JButton("ShowMoudle");
		btnShowmoudle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShowModuleGraphis();
			}
		});
		toolsBar.add(btnShowmoudle);

		JToolBar statusBar = new JToolBar();
		statusBar.setFloatable(false);
		mainPanel.add(statusBar, BorderLayout.SOUTH);

		JPanel panelState = new JPanel();
		statusBar.add(panelState);
		panelState.setLayout(new BorderLayout(0, 0));

		JLabel stateInfoLabel = new JLabel(CONSTANT.STR_STATEBAR_INIT);
		panelState.add(stateInfoLabel, BorderLayout.WEST);

		final MemoryPanel memoryPanel = new MemoryPanel();
		memoryPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.gc();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				memoryPanel.setBorder(new LineBorder(new Color(255, 0, 0), 2));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				memoryPanel.setBorder(null);
			}
		});
		memoryPanel.setToolTipText("Click here to force garbage collection");
		memoryPanel.setPreferredSize(new Dimension(100, 15));
		memoryPanel.setMaximumSize(new Dimension(100, 15));
		memoryPanel.setMinimumSize(new Dimension(100, 15));
		Timer timer = new Timer();
		TimerTask task = new TimerTask() {
			public void run() {
				memoryPanel.repaint();
			}
		};
		timer.schedule(task, 1000, 2000);
		panelState.add(memoryPanel, BorderLayout.EAST);

		JMenuBar menuBar = new JMenuBar();
		this.setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("File ");
		menuBar.add(mnNewMenu);

		JMenuItem mntmNewMenuItem = new JMenuItem("New");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newFile();
			}
		});
		mnNewMenu.add(mntmNewMenuItem);

		JMenuItem mntmOpen = new JMenuItem("Open");
		mntmOpen.setIcon(new ImageIcon(GPoCheckGUI.class.getResource(CONSTANT.IMAGE_OPEN)));
		mntmOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File file = openFile();
				createTabbedByFile(file);
			}
		});

		mnNewMenu.add(mntmOpen);

		mnNewMenu.addSeparator();

		JMenuItem mntmClose = new JMenuItem("Close");
		mnNewMenu.add(mntmClose);
		mnNewMenu.addSeparator();

		JMenuItem mntmSave = new JMenuItem("Save");
		mntmSave.setAccelerator(KeyStroke.getKeyStroke("control S"));
		mntmSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saveFile();
			}
		});
		mntmSave.setIcon(new ImageIcon(GPoCheckGUI.class.getResource(CONSTANT.IMAGE_SAVE)));
		mnNewMenu.add(mntmSave);

		JMenuItem mntmSaveAs = new JMenuItem("Save As");
		mntmSaveAs.setAccelerator(KeyStroke.getKeyStroke("control shift S"));
		mntmSaveAs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saveAsFile();
			}
		});
		mntmSaveAs.setIcon(new ImageIcon(GPoCheckGUI.class.getResource(CONSTANT.IMAGE_SAVEAS)));
		mnNewMenu.add(mntmSaveAs);

		JMenuItem mntmSaveAll = new JMenuItem("Save All");
		mnNewMenu.add(mntmSaveAll);

		mnNewMenu.addSeparator();

		JMenuItem mntmExit = new JMenuItem("Exit");
		mnNewMenu.add(mntmExit);

		JMenu mnRun = new JMenu("Run ");
		menuBar.add(mnRun);

		JMenuItem mntmRun = new JMenuItem("Run");
		mntmRun.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				runChecker();
			}
		});
		mntmRun.setIcon(new ImageIcon(GPoCheckGUI.class.getResource(CONSTANT.IMAGE_RUN)));
		mnRun.add(mntmRun);

		mnRun.addSeparator();

		JMenuItem mntmMakeModel = new JMenuItem("Load Moudle");
		mntmMakeModel.setIcon(new ImageIcon(GPoCheckGUI.class.getResource(CONSTANT.IMAGE_LOADMOUDLE)));
		mntmMakeModel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadModuleFile();
			}
		});

		JMenuItem mntmLoad = new JMenuItem("Load");
		mntmLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadFile();
			}
		});
		mntmLoad.setIcon(new ImageIcon(GPoCheckGUI.class.getResource(CONSTANT.IMAGE_LOAD)));
		mnRun.add(mntmLoad);
		mnRun.add(mntmMakeModel);

		JMenuItem mntmVildateProperty = new JMenuItem("Load Property");
		mntmVildateProperty.setIcon(new ImageIcon(GPoCheckGUI.class.getResource(CONSTANT.IMAGE_LOADPORPERTY)));
		mntmVildateProperty.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadPropertyFile();
			}
		});
		mnRun.add(mntmVildateProperty);

		JMenu mnWindow = new JMenu("Window ");
		menuBar.add(mnWindow);

		JMenu mnTheme = new JMenu("Theme");
		mnWindow.add(mnTheme);

		JMenuItem mntmBeautyeye = new JMenuItem("Beautyeye");
		mntmBeautyeye.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				changeTheme(GPoCheckGUI.THEME_BEAUTYEYE);
			}
		});

		JMenuItem mntmDefault = new JMenuItem("Default");
		mntmDefault.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changeTheme(GPoCheckGUI.THEME_DEFAULT);
			}
		});
		mntmDefault.setSelected(true);
		mnTheme.add(mntmDefault);
		mnTheme.add(mntmBeautyeye);

		JMenuItem mntmQuaqua = new JMenuItem("Quaqua");
		mntmQuaqua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				changeTheme(GPoCheckGUI.THEME_QUAQUA);
			}
		});
		mnTheme.add(mntmQuaqua);

		JMenu mnHelp = new JMenu("Help ");
		menuBar.add(mnHelp);

		JMenuItem mntmAbout = new JMenuItem("About");
		mntmAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AboutDiag aboutDiag = new AboutDiag(mainPanel);
				aboutDiag.setVisible(true);
			}
		});
		mnHelp.add(mntmAbout);
		this.setVisible(true);

		splitPaneMainFrame.setDividerLocation(0.3);
		splitPaneMainFrame.setContinuousLayout(true);
		splitPaneLeftFrame.setDividerLocation(0.7);
		splitPaneLeftFrame.setContinuousLayout(true);
		// DebugOperate
		DebugOperate();
	}

	private void loadFile() {
		int x = editorTabbedPane.getSelectedIndex();
		String toolTipText = editorTabbedPane.getToolTipTextAt(x);
		if (toolTipText.equals(CONSTANT.STR_NEW)) {
			JOptionPane.showMessageDialog(this, "Please save file!", "Warning", JOptionPane.WARNING_MESSAGE);
		} else {
			String fileStr = toolTipText.substring(0, toolTipText.lastIndexOf('.'));
			File tmpModuleFile = new File(fileStr + CONSTANT.STR_GPO);
			File tmpPropertyFile = new File(fileStr + CONSTANT.STR_POCTL);
			if (!tmpModuleFile.exists()) {
				JOptionPane.showMessageDialog(this, "No module file!", "Warning", JOptionPane.WARNING_MESSAGE);
				return;
			}
			if (!tmpPropertyFile.exists()) {
				JOptionPane.showMessageDialog(this, "No property file!", "Warning", JOptionPane.WARNING_MESSAGE);
				return;
			}
			textAreaModuleFile.setText(fileStr + CONSTANT.STR_GPO);
			textAreaPropertyFile.setText(fileStr + CONSTANT.STR_POCTL);
		}
	}

	private void loadModuleFile() {
		int x = editorTabbedPane.getSelectedIndex();
		String toolTipText = editorTabbedPane.getToolTipTextAt(x);
		if (toolTipText.equals(CONSTANT.STR_NEW)) {
			JOptionPane.showMessageDialog(this, "Please save file!", "Warning", JOptionPane.WARNING_MESSAGE);
		} else {
			String fileStr = toolTipText.substring(0, toolTipText.lastIndexOf('.'));
			File tmpModuleFile = new File(fileStr + CONSTANT.STR_GPO);
			if (!tmpModuleFile.exists()) {
				JOptionPane.showMessageDialog(this, "No module file!", "Warning", JOptionPane.WARNING_MESSAGE);
				return;
			}
			textAreaModuleFile.setText(fileStr + CONSTANT.STR_GPO);
		}
	}

	private void loadPropertyFile() {
		int x = editorTabbedPane.getSelectedIndex();
		String toolTipText = editorTabbedPane.getToolTipTextAt(x);
		if (toolTipText.equals(CONSTANT.STR_NEW)) {
			JOptionPane.showMessageDialog(this, "Please save file!", "Warning", JOptionPane.WARNING_MESSAGE);
		} else {
			String fileStr = toolTipText.substring(0, toolTipText.lastIndexOf('.'));
			File tmpPropertyFile = new File(fileStr + CONSTANT.STR_POCTL);
			if (!tmpPropertyFile.exists()) {
				JOptionPane.showMessageDialog(this, "No property file!", "Warning", JOptionPane.WARNING_MESSAGE);
				return;
			}
			textAreaPropertyFile.setText(fileStr + CONSTANT.STR_POCTL);
		}

	}

	private void runChecker() {
		// easy,no operate exception
		String moduleFile = textAreaModuleFile.getText();
		String propertyFile = textAreaPropertyFile.getText();
		if (!new File(moduleFile).exists()) {
			JOptionPane.showMessageDialog(this, "Module file not exist!", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
		if (!new File(propertyFile).exists()) {
			JOptionPane.showMessageDialog(this, "Property file not exist!", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
		RunThread runThread = new RunThread();
		runThread.moduleFile = moduleFile;
		runThread.propertyFile = propertyFile;
		runThread.start();
		infoTabbedPane.setSelectedIndex(1);
	}

	private class RunThread extends Thread {
		String moduleFile = null;
		String propertyFile = null;

		@Override
		public void run() {
			// 创建一个线程池
			ExecutorService pool = Executors.newCachedThreadPool();
			Callable<String> gPoCheck = new GPoCheck(moduleFile, propertyFile);
			Future<String> f1 = pool.submit(gPoCheck);
			try {
				textAreaLog.append(f1.get().toString());
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
			pool.shutdown();
		}

	}

	private static final int THEME_DEFAULT = 0;
	private static final int THEME_BEAUTYEYE = 1;
	private static final int THEME_QUAQUA = 2;

	private void changeTheme(int themeId) {
		switch (themeId) {
		case THEME_DEFAULT:
			setThemeDefault();
			break;
		case THEME_BEAUTYEYE:
			setThemeBeauty();
			break;
		case THEME_QUAQUA:
			setThemeQuaqua();
			break;
		default:
			setThemeDefault();
			break;
		}
	}

	private void setThemeDefault() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		SwingUtilities.updateComponentTreeUI(this);
	}

	private void setThemeBeauty() {
		try {
			org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
			// 关闭设置按钮
			UIManager.put("RootPane.setupButtonVisible", false);
			// JTabbedPane 没有缩进
			UIManager.put("TabbedPane.tabAreaInsets", new javax.swing.plaf.InsetsUIResource(0, 0, 0, 0));
			// 关闭半透明效果，设置此开关量为false即表示关闭之，BeautyEye LNF中默认是true
			BeautyEyeLNFHelper.translucencyAtFrameInactive = false;
			// 改变边框样式
			BeautyEyeLNFHelper.frameBorderStyle = FrameBorderStyle.translucencyAppleLike;

			SwingUtilities.updateComponentTreeUI(this);
		} catch (Exception e) {
		}
	}

	public void setThemeQuaqua() {
		System.setProperty("Quaqua.tabLayoutPolicy", "wrap");
		// set the Quaqua Look and Feel in the UIManager
		try {
			UIManager.setLookAndFeel(ch.randelshofer.quaqua.QuaquaManager.getLookAndFeel());
			// set UI manager properties here that affect Quaqua
		} catch (Exception e) {
			// take an appropriate action here
		}
		SwingUtilities.updateComponentTreeUI(this);
	}

	@SuppressWarnings("unused")
	private JFrame getJFrame() {
		return this;
	}

	private void newFile() {
		RSyntaxTextArea textArea = new RSyntaxTextArea();
		AbstractTokenMakerFactory atmf = (AbstractTokenMakerFactory) TokenMakerFactory.getDefaultInstance();
		atmf.putMapping("GPoCheckTokenMaker", GpoCheckTokenMaker.class.getName());
		TokenMakerFactory.setDefaultInstance(atmf);
		// textArea.setSyntaxEditingStyle(RSyntaxTextArea.SYNTAX_STYLE_JAVA);
		textArea.setSyntaxEditingStyle("GPoCheckTokenMaker");
		textArea.setCodeFoldingEnabled(true);
		RTextScrollPane sp = new RTextScrollPane(textArea);
		JPanel editorPanel = new JPanel(new BorderLayout());
		editorPanel.add(sp);

		editorTabbedPane.addTab("New", editorPanel);
		editorTabbedPane.setToolTipTextAt(editorTabbedPane.getTabCount() - 1, CONSTANT.STR_NEW);
		ButtonTabComponent buttonTabComponent = new ButtonTabComponent(editorTabbedPane);
		buttonTabComponent.setLabelBold();
		editorTabbedPane.setTabComponentAt(editorTabbedPane.getTabCount() - 1, buttonTabComponent);
		editorTabbedPane.setSelectedIndex(editorTabbedPane.getTabCount() - 1);
	}

	/**
	 * Open Dialog modify file name
	 * 
	 * @param c
	 * @return
	 */
	public JTextField getTextField(Container c) {
		JTextField textField = null;
		for (int i = 0; i < c.getComponentCount(); i++) {
			Component cnt = c.getComponent(i);
			if (cnt instanceof JTextField) {
				return (JTextField) cnt;
			}
			if (cnt instanceof Container) {
				textField = getTextField((Container) cnt);
				if (textField != null) {
					return textField;
				}
			}
		}
		return textField;
	}

	private void saveFile() {
		int tabIndex = editorTabbedPane.getSelectedIndex();
		String filePath = editorTabbedPane.getToolTipTextAt(tabIndex);
		if (filePath.equals(CONSTANT.STR_NEW)) {
			saveAsFile();
		} else {
			JPanel jPanel = (JPanel) editorTabbedPane.getComponentAt(tabIndex);
			RTextScrollPane rTextScrollPane = (RTextScrollPane) jPanel.getComponent(0);
			String content = rTextScrollPane.getTextArea().getText();
			FileUtilities.createFileFromString(filePath, content);

			if (editorTabbedPane.getTitleAt(tabIndex).trim().substring(0, 1).equals("*"))
				editorTabbedPane.setTitleAt(tabIndex, editorTabbedPane.getTitleAt(tabIndex).substring(1).trim());
			ButtonTabComponent buttonTabComponent = ((ButtonTabComponent) editorTabbedPane.getTabComponentAt(tabIndex));
			buttonTabComponent.setLabelDefault();
		}

	}

	private void saveAsFile() {
		int tabIndex = editorTabbedPane.getSelectedIndex();
		ButtonTabComponent buttonTabComponent = ((ButtonTabComponent) editorTabbedPane.getTabComponentAt(tabIndex));
		buttonTabComponent.setLabelDefault();
		JFileChooser fc = new JFileChooser();
		fc.setDialogTitle("Save");
		fc.setApproveButtonText("Save");
		// fc.setFileSelectionMode(JFileChooser.SAVE_DIALOG);
		if (null != lastSelectFile) {
			fc.setCurrentDirectory(lastSelectFile.getAbsoluteFile());
		} else {
			fc.setCurrentDirectory(new File(System.getProperty("user.dir")));
		}
		JTextField text = getTextField(fc);
		text.setText(buttonTabComponent.getLabelText());
		int saveResult = fc.showOpenDialog(this);

		File selectedFile = fc.getSelectedFile();
		if (saveResult == JFileChooser.APPROVE_OPTION) {
			JPanel jPanel = (JPanel) editorTabbedPane.getComponentAt(tabIndex);
			RTextScrollPane rTextScrollPane = (RTextScrollPane) jPanel.getComponent(0);
			String content = rTextScrollPane.getTextArea().getText();
			if (selectedFile.exists()) {
				// has exist
				int overwriteResult = JOptionPane.showConfirmDialog(this, "Has exist this file, confirm overwrite ?", "Info", JOptionPane.OK_CANCEL_OPTION);
				if (overwriteResult == JOptionPane.OK_OPTION) {
					System.out.println(content);
					FileUtilities.createFileFromString(selectedFile.getAbsolutePath(), content);
				}
			} else {
				FileUtilities.createFileFromString(selectedFile.getAbsolutePath(), content);
			}
		}
	}

	private File lastSelectFile = null;

	private File openFile() {
		JFileChooser fc = new JFileChooser();
		if (null != lastSelectFile) {
			fc.setCurrentDirectory(lastSelectFile.getAbsoluteFile());
		} else {
			fc.setCurrentDirectory(new File(System.getProperty("user.dir")));
		}
		fc.showOpenDialog(this);
		File selectedFile = fc.getSelectedFile();
		if (null != selectedFile) {
			lastSelectFile = selectedFile;
			return selectedFile;
		}
		return null;
	}

	private void createTabbedByFile(File file) {
		if (null != file) {
			if (file.exists() && !file.isDirectory()) {
				BufferedReader br = null;
				try {
					br = new BufferedReader(new FileReader(file));
					StringBuffer content = new StringBuffer();
					String tmp = null;
					while ((tmp = br.readLine()) != null) {
						content.append(tmp);
						content.append("\r\n");
					}
					RSyntaxTextArea textArea = new RSyntaxTextArea();
					textArea.addKeyListener(new KeyListener() {
						@Override
						public void keyTyped(KeyEvent e) {
							int tabIndex = editorTabbedPane.getSelectedIndex();
							if (!editorTabbedPane.getTitleAt(tabIndex).trim().substring(0, 1).equals("*"))
								editorTabbedPane.setTitleAt(tabIndex, "*" + editorTabbedPane.getTitleAt(tabIndex).trim());
							ButtonTabComponent buttonTabComponent = ((ButtonTabComponent) editorTabbedPane.getTabComponentAt(tabIndex));
							buttonTabComponent.setLabelBold();
						}

						@Override
						public void keyReleased(KeyEvent e) {
						}

						@Override
						public void keyPressed(KeyEvent e) {
						}
					});
					AbstractTokenMakerFactory atmf = (AbstractTokenMakerFactory) TokenMakerFactory.getDefaultInstance();
					atmf.putMapping("GPoCheckTokenMaker", GpoCheckTokenMaker.class.getName());
					TokenMakerFactory.setDefaultInstance(atmf);
					// textArea.setSyntaxEditingStyle(RSyntaxTextArea.SYNTAX_STYLE_JAVA);
					textArea.setSyntaxEditingStyle("GPoCheckTokenMaker");
					textArea.setCodeFoldingEnabled(true);
					textArea.setText(content.toString());
					RTextScrollPane sp = new RTextScrollPane(textArea);
					JPanel editorPanel = new JPanel(new BorderLayout());
					editorPanel.add(sp);

					editorTabbedPane.addTab(file.getName(), editorPanel);
					editorTabbedPane.setToolTipTextAt(editorTabbedPane.getTabCount() - 1, file.getAbsolutePath());
					editorTabbedPane.setTabComponentAt(editorTabbedPane.getTabCount() - 1, new ButtonTabComponent(editorTabbedPane));
					editorTabbedPane.setSelectedIndex(editorTabbedPane.getTabCount() - 1);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
					if (null != br)
						try {
							br.close();
						} catch (IOException e1) {
							e1.printStackTrace();
						}
				} catch (IOException e) {
					e.printStackTrace();
					if (null != br)
						try {
							br.close();
						} catch (IOException e1) {
							e1.printStackTrace();
						}
				} finally {
					if (null != br)
						try {
							br.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
				}

			}
		}
	}

	/**
	 * 显示当前模型的分析树
	 */
	private void ShowModuleGraphis() {
		int tabIndex = editorTabbedPane.getSelectedIndex();
		JPanel jPanel = (JPanel) editorTabbedPane.getComponentAt(tabIndex);
		RTextScrollPane rTextScrollPane = (RTextScrollPane) jPanel.getComponent(0);
		String content = rTextScrollPane.getTextArea().getText();

		// currentStateTabbedPane
		ANTLRInputStream input = new ANTLRInputStream(content);
		GPoMvLexer lexer = new GPoMvLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		GPoMvParser parser = new GPoMvParser(tokens);
		parser.setBuildParseTree(true);

		ParserRuleContext tree = parser.file();
		List<String> ruleNames = parser != null ? Arrays.asList(parser.getRuleNames()) : null;
		GPoTreeViewer viewer = new GPoTreeViewer(ruleNames, tree);
		JPanel aaa = viewer.open();
		panelModuleTree.removeAll();
		panelModuleTree.add(aaa, BorderLayout.CENTER);
		this.repaint();
	}

	private void DebugOperate() {
		File thermostat_combine_gpo = new File(System.getProperty("user.dir") + "/files/thermostat_combine.gpo");
		File thermostat_poctl = new File(System.getProperty("user.dir") + "/files/thermostat.gpoctl");
		createTabbedByFile(thermostat_combine_gpo);
		createTabbedByFile(thermostat_poctl);
		File easy1_gpo = new File(System.getProperty("user.dir") + "/files/easy1.gpo");
		File easy1_gpoctl = new File(System.getProperty("user.dir") + "/files/easy1.gpoctl");
		createTabbedByFile(easy1_gpo);
		createTabbedByFile(easy1_gpoctl);
		editorTabbedPane.setSelectedIndex(0);
	}
}
