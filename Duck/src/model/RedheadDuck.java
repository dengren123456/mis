package model;

public class RedheadDuck extends Duck{
	public RedheadDuck() {
	      quackBehavior = new Quack();
	      flyBehavior = new FlyWithRocket();
	   }

 public void display() {
	   System.out.println("ºìÍ·Ñ¼");
 }
}
