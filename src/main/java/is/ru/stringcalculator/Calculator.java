package main.java.is.ru.stringcalculator;

import java.util.Arrays;
import java.util.regex.Pattern;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;

public class Calculator {	
	
	public static final Pattern separatorDefinitionPattern = Pattern.compile("^(//(.)\n).*$");
    public static final String regDelim= "^(//.\n)?$";
    public static final String defaultDelim = "[,\n]";
	public static int add(String text){
		if(text.equals("")){
			return 0;
		}else if(text.length() == 1){
			return toInt(text);
		}else if(text.startsWith("//")){
			return parseText(text);
		}else{
			return sum(text.split(defaultDelim));
		}	
	}
	
	private static int parseText(String text) {
		ArrayList<String> list = new ArrayList<String>();
		boolean check = false;
		String str = "";
		for(int i = 0; i < text.length(); i++){
			if(text.charAt(i) < 48 || text.charAt(i) > 57){
				if(check){
					str = str+" ";
					check = false;
				}
			}else{
				str = str+text.charAt(i);
				check = true;
			}
		}
		return sum(str.split(" "));
	}
	private static int summery(String str) {
		// TODO Auto-generated method stub
		String[] aarray = str.split("[^\\d]+");
		int sum = 0;
		for(int i = 0; i < aarray.length; i++)
			sum += Integer.parseInt(aarray[i]);
		
		return sum;
	}

	public static boolean isNumeric(String str)
	{
	  return str.matches("-?\\d+(\\.\\d+)?");  //match a number with optional '-' and decimal.
	}

	private static int toInt(String number){
		return Integer.parseInt(number);
	}

	private static String[] splitNumbers(String numbers){
	    return numbers.split(defaultDelim);
	}
      
    private static int sum(String[] numbers){
 	    int total = 0; 
 	    StdOut.print(numbers);
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