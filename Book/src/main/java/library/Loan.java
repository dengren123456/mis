package library;


import java.time.LocalDate;


public class Loan {
	public String id;
	public LocalDate loanDate;
	public LocalDate dateForReturn;
	public LocalDate returnDate;
	public Book book;
	public Member menmber;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public LocalDate getLoanDate() {
		return loanDate;
	}
	public void setLoanDate(LocalDate loanDate) {
		this.loanDate = loanDate;
	}
	public LocalDate getDateForReturn() {
		return dateForReturn;
	}
	public void setDateForReturn(LocalDate dateForReturn) {
		this.dateForReturn = dateForReturn;
	}
	public LocalDate getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(LocalDate returnDate) {
		this.returnDate = returnDate;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public Member getMenmber() {
		return menmber;
	}
	public void setMenmber(Member menmber) {
		this.menmber = menmber;
	}

	
	public boolean HasNotBeenReturn(){
		return returnDate == null;
	}
	
	public void MarkAsReturned(){
		returnDate = LocalDate.now();
	}
}
