package library;

import java.util.ArrayList;

public class Member {
	private String id;
	private String name;
	private ArrayList<Loan> loans;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<Loan> getLoans() {
		return loans;
	}
	public void setLoans(ArrayList<Loan> loans) {
		this.loans = loans;
	}
	
	public Loan FindCurrentLoanFor(Book book){
		for(int i=0 ; i<loans.size() ; i++){
			if(loans.get(i).getBook().equals(book)){
				Loan bookLoan = loans.get(i);
				return bookLoan;
			}
		}
		return null;
	}
		
		
	public final void Return(Book book){
		library.Loan loan = FindCurrentLoanFor(book);
		if(loan != null){
			loan.MarkAsReturned();
			book.setLoanTo(null);
		}
	}
	
	
	public final boolean CanLoad(Book book){
		return book.getLoanTo() == null;
	}
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public final Loan Loan(Book book){
		Loan loan = null;
		if(CanLoad(book)){
			loan = LoanFactory.CreateLoan(book, this);
			if(loans == null){
				loans = new ArrayList();
				loans.add(loan);
			}else{
				loans.add(loan);
			}
		}
		return loan;
	}
}
