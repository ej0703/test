package multiChatUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class multiChatUI extends JFrame {
	private JPanel loginPanel;
	private JPanel logoutPanel;
	protected JButton loginButton;
	protected JButton logoutButton;
	
	private JPanel msgPanel;
	protected JTextField idInput;
	protected JTextField msgInput;
	protected JTextArea msgOut;
	
	protected JButton exitButton;
	
	private JLabel inLabel;
	JLabel outLabel;
	
	protected Container tab;
	protected CardLayout cardLayout;
	
	private JScrollPane jsp;
	protected String id;
		
	public multiChatUI() {
		//메인 프레임 구성
		super("::멀티챗::");
		//로그인 패널
		loginPanel = new JPanel();		
		loginPanel.setLayout(new BorderLayout());
		
		idInput = new JTextField(15);
		loginButton = new JButton("로그인");
		//로그인 패널에 위젯 구성
		inLabel = new JLabel("대화명");
		loginPanel.add(inLabel, BorderLayout.WEST);
		loginPanel.add(idInput, BorderLayout.CENTER);
		loginPanel.add(loginButton, BorderLayout.EAST);
		//로그아웃 패널
		logoutPanel = new JPanel();
		logoutPanel.setLayout(new BorderLayout());
		outLabel = new JLabel();
		logoutButton = new JButton("로그아웃");
		
		logoutPanel.add(outLabel, BorderLayout.CENTER);
		logoutPanel.add(logoutButton, BorderLayout.EAST);
		//메시지 입력 패널에 위젯 구성
		exitButton = new JButton("종료");
		msgInput = new JTextField(10);
		msgPanel = new JPanel();
		msgPanel.add(msgInput, BorderLayout.CENTER);
		msgPanel.add(exitButton, BorderLayout.EAST);
		//로그인/로그아웃 패널 중 하나를 선택하는 CardLayout 패널
		tab = new JPanel();
		cardLayout = new CardLayout();
		tab.setLayout(cardLayout);
		tab.add(loginPanel, "login");
		tab.add(logoutPanel, "logout");
		cardLayout.show(tab, "login");
		//메세지 출력 영역
		msgOut = new JTextArea("", 10, 30);
		
		msgOut.setEditable(false); //출력 전용
		
		JScrollPane jsp = new JScrollPane(msgOut, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		add(tab,BorderLayout.NORTH);
	    add(jsp,BorderLayout.CENTER);
	    add(msgPanel,BorderLayout.SOUTH);
	   
	    setLocation(500, 200);
	    setVisible(true);
	    setResizable(false);
	    pack();        
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void addButtonActionListener(ActionListener listener) {
		loginButton.addActionListener(listener);
		logoutButton.addActionListener(listener);
		exitButton.addActionListener(listener);
		msgInput.addActionListener(listener);
	}
}
