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
	
	@Test
	public void testWithDelimiter(){
		assertEquals(3, Calculator.add("//;\n1;2"));
	}

	
	@Test( expected = IllegalArgumentException.class )
	public void testWithNegative(){
		assertEquals("Negatives not allowed: -4,-5", Calculator.add("2,-4,3,-5"));
	}
	
	@Test( expected = IllegalArgumentException.class )
	public void testWithNegatives(){
		assertEquals(5, Calculator.add("2,-4,3,-5"));
	}
	
	@Test
	public void testLargeNumbers(){
		assertEquals(2, Calculator.add("1001,2"));
	}
	@Test
	public void testLargeNumbersWithaLegalLargeNumber(){
		assertEquals(502, Calculator.add("1001,2,500"));
	}
	
	@Test
	public void testAnyLengthDelimiters(){
		assertEquals(6, Calculator.add("//[***]\n1***2***3"));
	}
	@Test
	public void testMultipleDelimiters(){
		assertEquals(6, Calculator.add("//[*][%]\n1*2%3"));
	}

	
}