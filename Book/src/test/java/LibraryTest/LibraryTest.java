package LibraryTest;

import org.junit.Test;

import library.Book;
import library.Member;

public class LibraryTest {
	
	private Book book1,book2,book3,book4;
	private Member member1,member2,member3;
	
	/*
	 * 添加用户
	 */
	@Test
	public void addMember(){
		member1 = new Member();
		member1.setId("0001");
		member1.setName("小明");
	}
	/*
	 * 添加图书
	 */
	@Test
	public void addBook(){
		book1 = new Book();
		book2 = new Book();
		book3 = new Book();
		book4 = new Book();
		book1.setId("0001");
		book1.setiSBN("CT001");
		book1.settItle("西游记");
		book1.setLoanTo(null);
		book2.setId("0002");
		book2.setiSBN("CT002");
		book2.settItle("三国演义");
		book2.setLoanTo(null);
		book3.setId("0003");
		book3.setiSBN("CT003");
		book3.settItle("红楼梦");
		book3.setLoanTo(null);
		book4.setId("0004");
		book4.setiSBN("CT004");
		book4.settItle("水浒传");
		book4.setLoanTo(null);
	}
	/*
	 * 借书
	 */
	@Test
	public void loan(){
		this.addMember(); 
		this.addBook();
		member1.Loan(book1);
		member1.Loan(book2);
		System.out.println(member1.getName() + "成功借了" + member1.getLoans().get(0).getBook().gettItle() + "和" + member1.getLoans().get(1).getBook().gettItle());
	}

}
