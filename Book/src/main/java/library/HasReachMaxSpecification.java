package library;

import java.util.List;

public class HasReachMaxSpecification implements ISpecification<Member> {
	/*
	 * 用户最多只能借阅3本书
	 * 
	 */
	@Override
	public boolean isSatisfiedBy(Member member) {
		List<Loan> list = member.getLoans();
		for(int i=0 ; i<list.size() ; i++){
			if(list.get(i).getBook().getLoanTo()==null && list.size()<3){
				return true;
			}
		}
		return false;
	}

}
