package Logic;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.StringTokenizer;

public class Calculation {
	public int Y;
	public int X;
	public String startCulc(String first_vect, String second_vect) {
		List<Integer> first = getVect(first_vect); //Y
		List<Integer> second = getVect(second_vect); //X
		if (first.size() != second.size()) {
			return "Error!";
		}
		Y = (int) getAverage(first);
		X = (int) getAverage(second);
		return new Double (numerator(first, second)/denominator(first, second)).toString(); 
	}
	
	private double getAverage(List<Integer> list) {
		OptionalDouble average = list
	            .stream()
	            .mapToDouble(a -> a)
	            .average();
		return average.isPresent() ? average.getAsDouble() : 0;
	}
	
	private List<Integer> getVect(String s){
		
		StringTokenizer st = new StringTokenizer(s," ");
		List<Integer> numbers = new ArrayList<>();
		while(st.hasMoreTokens()){
            numbers.add(Integer.parseInt(st.nextToken()));
        }
		return numbers;
	}
	
	private double numerator(List<Integer> first, List<Integer> second) {
		int iterator = 0;
		double result = 0;
		while(first.size() > iterator) {
			Iter iter = new Iter();
			iter.setFlag(false);
			iter.setFirst(first.get(iterator));
			iter.setSecond(second.get(iterator));
			iter.setX(X);
			iter.setY(Y);
			iter.start();
			result += iter.getResult();
			try {
				iter.join();
				result += iter.getResult();
				System.out.println(iter.getResult());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			iterator++;
		}
		return result;
	}
	
	private double denominator(List<Integer> first, List<Integer> second) {
		int iterator = 0;
		double result = 0;
		while(first.size() > iterator) {
			Iter iter = new Iter();
			iter.setFlag(true);
			iter.setFirst(first.get(iterator));
			iter.setSecond(second.get(iterator));
			iter.setX(X);
			iter.setY(Y);
			iter.start();
			result += iter.getResult();
			try {
				iter.join();
				result += iter.getResult();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			iterator++;
		}
		if (result == 0) {
			return 1;
		} else {
		return result;
		}
	}
}
