package library;

public class Book {
	private String id;
	private String iSBN;
	private String tItle;
	private Member loanTo;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getiSBN() {
		return iSBN;
	}
	public void setiSBN(String iSBN) {
		this.iSBN = iSBN;
	}
	public String gettItle() {
		return tItle;
	}
	public void settItle(String tItle) {
		this.tItle = tItle;
	}
	public Member getLoanTo() {
		return loanTo;
	}
	public void setLoanTo(Member loanTo) {
		this.loanTo = loanTo;
	}
	
	
	
}
