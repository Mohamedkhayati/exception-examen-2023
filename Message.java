package tp9;

import java.time.LocalDate;

public class Message extends Billet {

	private String msg ;
	Message(LocalDate datePub, String auteur, String contenu){
		super(datePub,auteur);
		this.msg=contenu;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}

}
