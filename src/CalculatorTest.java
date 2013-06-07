import static org.junit.Assert.*;

import org.junit.Test;

public class CalculatorTest {

	@Test
	public void testNull() {
		assertTrue(new Calculator().add(null) == 0);
	}

	@Test
	public void testBlankValue() {
		assertTrue(new Calculator().add("") == 0);
	}

//	//
	@Test
	public void testWithOneValue() {
		assertTrue(new Calculator().add("1") == 1);
		assertTrue(new Calculator().add("100") == 100);
	}
//
//	//
	@Test
	public void testUnknownNumberOfValue() {
		assertTrue(new Calculator().add("1,2,3,4") == 10);
		assertTrue(new Calculator().add("1,2,3,4,5") == 15);
	}
////
////	//
	@Test
	public void testWithNewLine() {
		assertTrue(new Calculator().add("1\n2,3,4") == 10);
		assertTrue(new Calculator().add("1\n2,3\n4") == 10);
	}
//
////	//
	@Test
	public void testWithChangeDelimiter() {
		assertTrue(new Calculator().add("//[;]\n1\n2;3,4") == 10);
		assertTrue(new Calculator().add("//[aaa][b3b]\n1\n2aaa3,4") == 10);
		assertTrue(new Calculator().add("//[aaa]\n1\n2aaa3,4") == 10);
	}
//	//
	@Test
	public void testWithNegativeNumber() {
		Exception e = null;
		// ////////////////////////////
		try {
			new Calculator().add("1,-2,3,-7");
		} catch (Exception e1) {
			// TODO: handle exception
			e = e1;
			System.out.println(e.getMessage());
		}
		assertTrue(e.getMessage().equals("negatives not allowed: -2, -7"));
		// ///////////////////////////////
		try {
			new Calculator().add("-100,-2000,-3,-7");
		} catch (Exception e1) {
			// 
			e = e1;
			System.out.println(e.getMessage());
		}
		assertTrue(e.getMessage().equals(
				"negatives not allowed: -100, -2000, -3, -7"));
		// //////////////////////////
		try {
			new Calculator().add("-1,2,3,7");
		} catch (Exception e1) {
			// 
			e = e1;
			System.out.println(e.getMessage());
		}
		assertTrue(e.getMessage().equals("negatives not allowed: -1"));
	}
//
	@Test
	public void testWithNumberLagerThan1000() {
		assertTrue(new Calculator().add("1,2,3,1004") == 6);
	}
////
	@Test
	public void testWithMultiDelimiter() {
		assertTrue(new Calculator().add("//[aaa][bbb][ccc]\n1aaa2bbb3ccc4") == 10);
		assertTrue(new Calculator().add("//[55erffdsfdsfa(*&%$$$]]]]]]]]]]][sdfsadf%&^%&]\n155erffdsfdsfa(*&%$$$]]]]]]]]]]100sdfsadf%&^%&900")==1001);
	}
}
