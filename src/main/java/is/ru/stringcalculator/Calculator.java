package main.java.is.ru.stringcalculator;

import java.util.Arrays;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;

public class Calculator {	
	
	public static int add(String text){
		if(text.equals("")){
			return 0;
		}else if(text.startsWith("//")){
			//delimiter += "|" + text.substring(2, 3);
			String str = "";
			for(int i = 3; i < text.length(); i++){
				if(text.charAt(i) != text.charAt(2)){
					str += text.charAt(i);
					
				}else{
					str += ",";
				}
				
			}
			StdOut.println(str);
			str = "1,2";
			StdOut.println(str);
			//text = str;
			return sum(splitNumbers(str));
		}
		else if(text.contains(",") || text.contains("\n")){
			return sum(splitNumbers(text));
		}
		else
			return 1;
	}

	private static int toInt(String number){
		return Integer.parseInt(number);
	}

	private static String[] splitNumbers(String numbers){
	    return numbers.split("[\\D]");
	}
      
    private static int sum(String[] numbers){
 	    int total = 0;    
 	   ArrayList<Integer> list = new ArrayList<Integer>();
        for(String number : numbers){
        	if(checkNegative(number)){
        		list.add(toInt(number));
        	}else
		    total += toInt(number);
		}
        //StdOut.println(total);
		return total;
    }
    
	private static boolean checkNegative(String number) {
		// TODO Auto-generated method stub
		if(toInt(number) < 0){
			return true;
		}
		return false;
	}
	
	private static void ThrowAndReturnNegatives( ArrayList<Integer> list ) throws IllegalArgumentException {
		String negatives= "";
		for(int i = 0; i < list.size(); i++){
			if(i == 0){
				negatives += list.get(i);
			}else {
				negatives = negatives + ", " + list.get(i);
			}
		}
		throw new IllegalArgumentException("Negatives not allowed: " + negatives);
	}
    
    
}