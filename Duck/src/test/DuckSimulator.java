package test;

import model.Duck;
import model.MallardDuck;
import model.RedheadDuck;
import model.RubberDuck;
import model.Squeak;

public class DuckSimulator {
	public static void main(String[] args) {
		System.out.println("---------这是三只鸭子的自我介绍----------");
	      Duck mallard = new MallardDuck();
	      mallard.display();
	      mallard.swim();
	      mallard.performFly();
	      mallard.performQuack();
	      System.out.println("最近我学会了一种新叫法");
	      mallard.setQuackBehavior(new Squeak());
	      mallard.performQuack();
	      
	      
	      Duck redhead = new RedheadDuck();
	      redhead.display();
	      redhead.swim();
	      redhead.performFly();
	      redhead.performQuack();
	      
	      
	      Duck rubber = new RubberDuck();
	      rubber.display();
	      rubber.swim();
	      rubber.performFly();
	      rubber.performQuack();
	   }

}
