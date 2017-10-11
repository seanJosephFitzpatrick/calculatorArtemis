package ReversePolishNotationTest;

import static org.junit.Assert.*;

import org.junit.Test;

import ReversePolishNotation.CalcInterface;

public class CalcInterfaceTest {

	@Test
	public void testTwoNumbersAdditionOK() {
		assertEquals("9.0", CalcInterface.run("4+5", true));
	}
	
	@Test
	public void testTwoNumbersSubtractionOK() {
		assertEquals("-2.0", CalcInterface.run("4-6", true));
	}

	@Test
	public void testTwoNumbersMultiplicationOK() {
		assertEquals("35.0", CalcInterface.run("7*5", true));
	}
	
	@Test
	public void testTwoNumbersDivisionOK() {
		assertEquals("2.0", CalcInterface.run("10/5", true));
	}
	
	@Test
	public void testNumberRaisedToPowerOK() {
		assertEquals("64.0", CalcInterface.run("2^(2+4)", true));
	}
	
	@Test
	public void testOneBracketExpressionOK() {
		assertEquals("100.0", CalcInterface.run("10 * ( 5 + 5 )", true));
	}
	
	@Test
	public void testTwoBracketExpressionOK() {
		assertEquals("100.0", CalcInterface.run("(20 / 2) * ( 5 + 5 )", true));
	}
	
	@Test
	public void testCosFunctionOK() {
		assertEquals("0.5000000000000001", CalcInterface.run("cos(60)", true));			//Clean double!
	}
	
	@Test
	public void testSinFunctionOK() {
		assertEquals("0.8660254037844386", CalcInterface.run("sin(60)", true));			
	}
	
	@Test
	public void testTanFunctionOK() {
		assertEquals("1.7320508075688767", CalcInterface.run("tan(60)", true));			
	}
	
	@Test
	public void testSquareRootFunctionOK() {
		assertEquals("3.0", CalcInterface.run("rts(9)", true));
	}
	
	@Test
	public void testNaturalLogFunction() {
		assertEquals("2.1972245773362196", CalcInterface.run("elg(9)", true));
	}
	
	@Test
	public void testLogTenFunction() {
		assertEquals("0.9542425094393249", CalcInterface.run("lgt(9)", true));
	}
	
	@Test
	public void testFunctionWithinBracketsOK() {
		assertEquals("6.866025403784438", CalcInterface.run("1+(5+cos(30))", true));
	}
		

	
	
}
