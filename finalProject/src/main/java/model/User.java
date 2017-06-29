package model;

public class User {
	
	private String ssn;
	private String password;
	private String type;
	
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public boolean validatePassword(String pw , String ty) {
		if (pw.equals(password) && ty.equals(type)) return true;
		else return false;
	}
	
}
