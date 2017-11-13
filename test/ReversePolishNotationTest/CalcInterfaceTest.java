package ReversePolishNotationTest;

import static org.junit.Assert.*;

import org.junit.Test;

import ReversePolishNotation.CalcInterface;
import ReversePolishNotation.EquationGenerator;

public class CalcInterfaceTest {

	@Test
	public void testTwoNumbersAdditionOK() {
		assertEquals("9", CalcInterface.run("4+5", true));
	}
	
	@Test
	public void testTwoNumbersSubtractionOK() {
		assertEquals("-2", CalcInterface.run("4-6", true));
	}

	@Test
	public void testTwoNumbersMultiplicationOK() {
		assertEquals("35", CalcInterface.run("7*5", true));
	}
	
	@Test
	public void testTwoNumbersDivisionOK() {
		assertEquals("2", CalcInterface.run("10/5", true));
	}
	
	@Test
	public void testNumberRaisedToPowerOK() {
		assertEquals("64", CalcInterface.run("2^(2+4)", true));
	}
	
	@Test
	public void testOneBracketExpressionOK() {
		assertEquals("100", CalcInterface.run("10 * ( 5 + 5 )", true));
	}
	
	@Test
	public void testTwoBracketExpressionOK() {
		assertEquals("100", CalcInterface.run("(20 / 2) * ( 5 + 5 )", true));
	}
	
	@Test
	public void testCosFunctionTrueOK() {
		assertEquals("0.500000000000", CalcInterface.run("cos(60)", true));		
	}
	
	@Test
	public void testCosFunctionFalseOK() {
		assertEquals("-0.952412980415", CalcInterface.run("cos(60)", false));		
	}
	
	@Test
	public void testACosFunctionTrueOK() {
		assertEquals("60.0000000000", CalcInterface.run("bac(0.5)", true));		
	}
	
	@Test
	public void testACosFunctionFalseOK() {
		assertEquals("1.04719755120", CalcInterface.run("bac(0.5)", false));		
	}
	
	@Test
	public void testSinFunctionTrueOK() {
		assertEquals("0.866025403784", CalcInterface.run("sin(60)", true));			
	}
	
	@Test
	public void testSinFunctionFalseOK() {
		assertEquals("-0.304810621102", CalcInterface.run("sin(60)", false));			
	}
	
	@Test
	public void testASinFunctionTrueOK() {
		assertEquals("30.0000000000", CalcInterface.run("dsn(0.5)", true));			
	}
	
	@Test
	public void testASinFunctionFalseOK() {
		assertEquals("0.523598775598", CalcInterface.run("dsn(0.5)", false));			
	}
	
	@Test
	public void testTanFunctionOK() {
		assertEquals("1.73205080757", CalcInterface.run("tan(60)", true));			
	}
	
	@Test
	public void testSquareRootFunctionOK() {
		assertEquals("3", CalcInterface.run("rts(9)", true));
	}
	
	@Test
	public void testNaturalLogFunction() {
		assertEquals("2.19722457734", CalcInterface.run("elg(9)", true));
	}
	
	@Test
	public void testLogTenFunction() {
		assertEquals("0.954242509439", CalcInterface.run("lgt(9)", true));
	}
	
	@Test
	public void testFunctionWithinBracketsOK() {
		assertEquals("6.86602540", CalcInterface.run("1+(5+cos(30))", true));
	}


	
	
}
