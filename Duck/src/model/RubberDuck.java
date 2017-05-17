package model;

public class RubberDuck extends Duck{
	   public RubberDuck() {
		      quackBehavior = new Squeak();
		      flyBehavior = new FlyNoWay();
		   }
	 
	   public void display() {
		   System.out.println("Ïð½ºÑ¼");
	   }
	 
}
