package stringcalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalculatorTest {

	public static void main(String args[]) {
      org.junit.runner.JUnitCore.main("CalculatorTest");
    }

	@Test
	public void testEmptyString() {
		assertEquals(0, Calculator.add(""));
	}

	@Test
	public void testOneDigit() {
		assertEquals(1, Calculator.add("1"));
	}

	@Test
	public void testTwoDigit(){
		assertEquals(6, Calculator.add("1,5"));
	}

	@Test
    public void testThreeDigit(){
    	assertEquals(13, Calculator.add("1,5,7"));
    }

    @Test
    public void testNewLine(){
    	assertEquals(13, Calculator.add("1\n5,7"));
    }
    
    @Test
    public void testThousandAbove(){
    	assertEquals(5, Calculator.add("1000,5"));
    }

    @Test
    public void testOtherDelimiter(){
    	assertEquals(6, Calculator.add("//;\n1;5"));
    }

    @Test
    public void testNegativeNumver(){
    	try {
			Calculator.add("-1,3");
		}
		catch (IllegalArgumentException e){
			assertEquals(e.getMessage(), "Negatives not allowed: -1");
		}

		try {
			Calculator.add("2,-5,3,-7");
		}
		catch (IllegalArgumentException e){
			assertEquals(e.getMessage(), "Negatives not allowed: -5,-7");
		}
    }

    
}