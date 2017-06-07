package library;

import java.util.List;

public class LoanOnlySpecification implements ISpecification<Member> {
	private Book wantBook;
	/*
	 * 同一书只能借阅一本
	 * 
	 */
	@Override
	public boolean isSatisfiedBy(Member member) {
		List<Loan> list = member.getLoans();
		for(int i=0 ; i<list.size() ; i++){
			if(list.get(i).getBook().getLoanTo()==null && list.get(i).getBook().getiSBN()!=wantBook.getiSBN()){
				return true;
			}
		}
		return false;
	}
	
}
