package Logic;

import java.util.List;

public class Iter extends Thread {
	private int X;
	private int Y;
	private boolean flag = false; //false - calculation numerator, true - calculation denominator
	private Integer first;
	private Integer second;
	private double result;
	@Override
	public void run() {
		if (flag) {
			denominator();
		} else {
			numerator();
		}
	}
	
	private void numerator() {
		Integer integer = (first - X)*(second - Y);
		System.out.print("numerator");
		System.out.println((first - X)*(second - Y));
		setResult(integer);
	}
	
	private void denominator() {
		System.out.print("denominator");
		System.out.println(Math.sqrt(((int) Math.pow((first - X),2) * ((int) Math.pow((second - Y),2)))));
		double integer = Math.sqrt((Math.pow((first - X),2) * (Math.pow((second - Y),2))));
		setResult(integer);
	}
	
	public void setFirst(Integer val) {
		this.first = val;
	}
	
	public void setSecond(Integer val) {
		this.second = val;
	}
	
	public int getX() {
		return X;
	}
	public void setX(int x) {
		this.X = x;
	}
	public int getY() {
		return Y;
	}
	public void setY(int y) {
		this.Y = y;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public double getResult() {
		return result;
	}

	public void setResult(double integer) {
		this.result = integer;
	}
}
