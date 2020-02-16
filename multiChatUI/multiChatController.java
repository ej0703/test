package multiChatUI;

import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.util.logging.Logger;

import com.google.gson.Gson;

public class multiChatController implements Runnable {
	private final multiChatUI v;
	private final multiChatData chatData;
	
	private String ip = "10.0.0.3";
	private Socket socket;
	private BufferedReader inMsg = null;
	private PrintWriter outMsg = null;
	
	Gson gson = new Gson();
	message m;
	
	boolean status;
	
	Logger logger;
	Thread thread;
	
	public multiChatController(multiChatData chatData, multiChatUI v) {
		logger = Logger.getLogger(this.getClass().getName());
		
		this.chatData = chatData;
		this.v = v;
	}
	
	public void appMain() {
		chatData.addObj(v.msgOut);
		
		v.addButtonActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object obj = e.getSource();
				
				if(obj == v.exitButton) {
					System.exit(0);
				} else if(obj == v.loginButton) {
					v.id = v.idInput.getText();
					v.outLabel.setText(" 대화명 : "+v.id);
					v.cardLayout.show(v.tab, "logout");
					connectServer();
				} else if(obj == v.logoutButton) {
					outMsg.println(gson.toJson(new message(v.id, "", v.msgInput.getText(), "msg")));
					v.msgOut.setText("");
					v.cardLayout.show(v.tab, "login");
					outMsg.close();
					
					try {
						inMsg.close();
						socket.close();
					} catch (IOException ex) {
						ex.printStackTrace();
					}
					status = false;
				} else if(obj == v.msgInput) {
					outMsg.println(gson.toJson(new message(v.id, "", v.msgInput.getText(), "msg")));
					v.msgInput.setText("");
				}
			}
		});
	}
	
	public void connectServer() {
		try {
			socket = new Socket(ip, 8888);
			logger.info( "[Client]Server 연결 성공!!");
			
			inMsg = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			outMsg = new PrintWriter(socket.getOutputStream(), true);
			
			m = new message(v.id, "", "", "login");
			outMsg.println(gson.toJson(m));
			
			thread = new Thread(this);
			thread.start();
		} catch (Exception e) {
			logger.info("[MultiChatUI]connectServer() Exception 발생!!");
			e.printStackTrace();
		}
	}

	public void run() {
		String msg;
		status = true;
		
		while(status) {
			try {
				msg = inMsg.readLine();
				m = gson.fromJson(msg, message.class);
				
				chatData.refreshData(m.getId() + ">" + m.getMsg() +"\n");
				
				v.msgOut.setCaretPosition(v.msgOut.getDocument().getLength());
			} catch (IOException e) {
				logger.info("[MultiChatUI]메시지 스트림 종료!!");
			}
		}
		logger.info("[MultiChatUI]" + thread.getName() + " 메시지 수신 스레드 종료됨!!");
	}
	
	public static void main(String[] args) {
		multiChatController app = new multiChatController(new multiChatData(), new multiChatUI());
		app.appMain();
	}
}