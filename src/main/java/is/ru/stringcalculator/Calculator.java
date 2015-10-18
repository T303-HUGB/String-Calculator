package main.java.is.ru.stringcalculator;

import java.util.Arrays;
import java.util.regex.Pattern;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;

public class Calculator {	
	
	
    public static final String defaultDelim = "[,\n]";
	
	public static int add(String text){
		if(text.equals("")){
			return 0;
		}else if(text.length() == 1){
			return toInt(text);
		}else if(text.startsWith("//")){
			parseText(text);
			return -1;
		}else{
			return sum(text.split(defaultDelim));
		}	
	}
	
	private static void parseText(String text) {
		// TODO Auto-generated method stub
		ArrayList<String> list = new ArrayList<String>();
		
		
	}

	private static int toInt(String number){
		return Integer.parseInt(number);
	}

	private static String[] splitNumbers(String numbers){
	    return numbers.split(defaultDelim);
	}
      
    private static int sum(String[] numbers){
 	    int total = 0;    
 	   ArrayList<Integer> list = new ArrayList<Integer>();
        for(String number : numbers){
        	if(toInt(number) > 1000){
        		
        	}else if(checkNegative(number)){
        		list.add(toInt(number));
        	}else
		    total += toInt(number);
		}
        if(list.size() > 0){
			ThrowAndReturnNegatives(list);
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