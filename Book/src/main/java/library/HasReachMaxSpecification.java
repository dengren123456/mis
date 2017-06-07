package library;

import java.util.List;

public class HasReachMaxSpecification implements ISpecification<Member> {
	/*
	 * 用户最多只能借阅3本书
	 * 
	 */
	public boolean isSatisfiedBy(Member member) {
		boolean mm = false;
		List<Loan> list = member.getLoans();
		if(list == null){
			mm=true;
		}else{
			if(list.size()<3){
				mm=true;
			}
		}
		return mm;
		
	}

}
