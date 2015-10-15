package test.java.is.ru.stringcalculator;

import main.java.is.ru.stringcalculator.Calculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalculatorTest {

	public static void main(String args[]) {
      org.junit.runner.JUnitCore.main("test.java.is.ru.stringcalculator.CalculatorTest");
    }

	@Test
	public void testEmptyString() {
		assertEquals(0, Calculator.add(""));
	}

	@Test
	public void testOneNumber() {
		assertEquals(1, Calculator.add("1"));
	}

	@Test
	public void testTwoNumbers() {
		assertEquals(3, Calculator.add("1,2"));
	}	

	@Test
    public void testMultipleNumbers(){
    	assertEquals(15, Calculator.add("1,2,3,4,5"));
    }
	
	@Test
    public void testNewLine(){
		
    	assertEquals(6, Calculator.add("1\n2,3"));
    }

}