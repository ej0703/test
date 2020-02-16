package multiChatUI;

import javax.swing.*;

public class multiChatData {
	JTextArea msgOut;
	
	public void addObj(JComponent comp) {
		this.msgOut = (JTextArea)comp;
	}
	public void refreshData(String msg) {
		msgOut.append(msg);
	}
}
