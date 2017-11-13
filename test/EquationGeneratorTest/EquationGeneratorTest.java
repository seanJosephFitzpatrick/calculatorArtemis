package EquationGeneratorTest;

import static org.junit.Assert.*;

import org.junit.Test;

import ReversePolishNotation.EquationGenerator;

public class EquationGeneratorTest {


	@Test
	public void testFactorial(){
		assertEquals("1 + 120", EquationGenerator.evaluateFactorial("1 + 5!"));
	}

	@Test
	public void testStringFormat(){
		assertEquals("90 + 120 + bac(0.5)", EquationGenerator.formatEquation("90 + 5! + acos(0.5)"));
	}
	
}
