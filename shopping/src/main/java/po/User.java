package po;

public class User {
	private int u_id;
	private String u_name;
	private String u_pw;
	private String u_adress;
	private String u_email;
	private int u_status;
	public int getU_id() {
		return u_id;
	}
	public void setU_id(int u_id) {
		this.u_id = u_id;
	}
	public String getU_name() {
		return u_name;
	}
	public void setU_name(String u_name) {
		this.u_name = u_name;
	}
	public String getU_pw() {
		return u_pw;
	}
	public void setU_pw(String u_pw) {
		this.u_pw = u_pw;
	}
	public String getU_adress() {
		return u_adress;
	}
	public void setU_adress(String u_adress) {
		this.u_adress = u_adress;
	}
	public String getU_email() {
		return u_email;
	}
	public void setU_email(String u_email) {
		this.u_email = u_email;
	}
	public int getU_status() {
		return u_status;
	}
	public void setU_status(int u_status) {
		this.u_status = u_status;
	}
	public User() {
		super();
	}
	public User(int u_id, String u_name, String u_pw, String u_adress, String u_email, int u_status) {
		super();
		this.u_id = u_id;
		this.u_name = u_name;
		this.u_pw = u_pw;
		this.u_adress = u_adress;
		this.u_email = u_email;
		this.u_status = u_status;
	}
	@Override
	public String toString() {
		return "User [u_id=" + u_id + ", u_name=" + u_name + ", u_pw=" + u_pw + ", u_adress=" + u_adress + ", u_email="
				+ u_email + ", u_status=" + u_status + "]";
	}
	
}
