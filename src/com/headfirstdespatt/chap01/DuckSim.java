package com.headfirstdespatt.chap01;

/*
 * Strategy
 */
public class DuckSim {

	public static void main(String[] args) {
		Duck d = new MallardDuck();
		d.display();
		d.performFly();
		d.performQuack();
		System.out.println("-----");
		
		d.setQuackBehavr(new MuteQuack());
		d.performQuack();
	}

}

abstract class Duck {
	FlyBehavior flyBehavr;
	QuackBehavior quackBehavr;

	public void swim() {
	}

	public void display() {
	}

	public void performFly() {
		flyBehavr.fly();
	}

	public void performQuack() {
		quackBehavr.quack();
	}

	public void setFlyBehavr(FlyBehavior flyBehavr) {
		this.flyBehavr = flyBehavr;
	}

	public void setQuackBehavr(QuackBehavior quackBehavr) {
		this.quackBehavr = quackBehavr;
	}
}

class MallardDuck extends Duck {
	MallardDuck() {
		flyBehavr = new FlyWithWings();
		quackBehavr = new Quack();
	}

	public void display() {
		System.out.println("I am a mallrd duck");
	}
}

class RedHeadDuck extends Duck {
	RedHeadDuck() {
		flyBehavr = new FlyWithWings();
		quackBehavr = new Squeak();
	}

	public void display() {
		System.out.println("I am a Red Head duck");
	}
}

class RubberDuck extends Duck {
	RubberDuck() {
		flyBehavr = new FlyNoWay();
		quackBehavr = new MuteQuack();
	}

	public void display() {
		System.out.println("I am a Rubber duck");
	}
}

class DecoyDuck extends Duck {
	DecoyDuck() {
		flyBehavr = new FlyNoWay();
		quackBehavr = new MuteQuack();
	}

	public void display() {
		System.out.println("I am a Decoy duck");
	}
}

interface FlyBehavior {
	public void fly();
}

class FlyWithWings implements FlyBehavior {

	@Override
	public void fly() {
		System.out.println("I am flying");
	}

}

class FlyNoWay implements FlyBehavior {

	@Override
	public void fly() {
		System.out.println("I can't fly");
	}

}

interface QuackBehavior {
	public void quack();
}

class Quack implements QuackBehavior {

	@Override
	public void quack() {
		System.out.println("Quack Quack Quack");
	}

}

class Squeak implements QuackBehavior {

	@Override
	public void quack() {
		System.out.println("Squeak Squeak Squeak");
	}

}

class MuteQuack implements QuackBehavior {

	@Override
	public void quack() {
		System.out.println("can not quack!!! its mute");
	}

}