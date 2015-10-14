
import java.util.Arrays;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class StringCalculator {
	public static void main(String[] args) {
		
		String numbers = "";
		int sum = Add(numbers);
		StdOut.println(sum);
	}
	
	public static int Add(String numbers){
		int number = 0;
		while(!StdIn.isEmpty()){
	           numbers = StdIn.readString();
	           
	           String[] parts = numbers.split("-?\\d+");
	           System.out.println(Arrays.toString(parts));
	           number += Integer.parseInt(Arrays.toString(parts));
	     }
		
		 return number;
	}
}
