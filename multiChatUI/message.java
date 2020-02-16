package multiChatUI;

public class message {

	   private String id, pw, msg, type;
	   
	   public message() {}
	   
	   public message(String id,String pw,String msg,String type)
	   {
	      this.id = id;
	      this.pw = pw;
	      this.msg = msg;
	      this.type = type;
	   }
	   
	   public String getId() {return id;}
	   public String getPw() {return pw;}
	   public String getMsg() {return msg;}
	   public String getType() {return type;}
	   
	   public void setId(String id) {this.id = id;}
	   public void setPw(String pw) {this.id = pw;}
	   public void setMsg(String msg) {this.id = msg;}
	   public void setType(String type) {this.id = type;}

	}
