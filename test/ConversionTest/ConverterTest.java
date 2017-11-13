package ConversionTest;

import static org.junit.Assert.*;

import org.junit.Test;


public class ConverterTest {

	@Test
	public void testFromConvertWorking() {
		assertEquals(39.3700787, conversions.Converter.toOrFromConvert("from", 1, 0.0254), 0.0000001);
	}
	
	@Test
	public void testToConvertWorking() {
		assertEquals(0.0254, conversions.Converter.toOrFromConvert("to", 1, 0.0254), 0.0000001);
	}
	
	@Test
	public void testCorrectFactorAssignedForCM() {
		assertEquals(0.01, conversions.Converter.lengths("cm"), 0.0000001);
	}
	
	@Test
	public void testCorrectFactorAssignedForINCH() {
		assertEquals(0.0254, conversions.Converter.lengths("in"), 0.0000001);
	}
	
	@Test
	public void testCorrectFactorAssignedForFoot() {
		assertEquals(0.3048, conversions.Converter.lengths("ft"), 0.0000001);
	}
	
	@Test
	public void testCorrectFactorAssignedForMile() {
		assertEquals(1609.344, conversions.Converter.lengths("mi"), 0.0000001);
	}
	
	@Test
	public void testCorrectFactorAssignedForMm() {
		assertEquals(0.001, conversions.Converter.lengths("mm"), 0.0000001);
	}
	
	@Test
	public void testCorrectFactorAssignedForKm() {
		assertEquals(1000, conversions.Converter.lengths("km"), 0.0000001);
	}
	
	@Test
	public void testCorrectFactorAssignedForYd() {
		assertEquals(0.9144, conversions.Converter.lengths("yd"), 0.0000001);
	}
	
	@Test
	public void testCorrectFactorAssignedForGallons() {
		assertEquals(3.78541178, conversions.Converter.volumes("gallons"), 0.0000001);
	}
	
	@Test
	public void testCorrectFactorAssignedForPints() {
		assertEquals(0.473176473, conversions.Converter.volumes("pints"), 0.0000001);
	}
	
	@Test
	public void testCorrectFactorAssignedForMilliliters() {
		assertEquals(0.001, conversions.Converter.volumes("milliliters"), 0.0000001);
	}
	
	@Test
	public void testCorrectFactorAssignedForCubicMeters() {
		assertEquals(1000.00, conversions.Converter.volumes("cubic meters"), 0.0000001);
	}
	
	@Test
	public void testCorrectFactorAssignedForPounds() {
		assertEquals(0.45359237, conversions.Converter.weight("pounds"), 0.0000001);
	}

	@Test
	public void testCorrectFactorAssignedForOunces() {
		assertEquals(0.0283495231, conversions.Converter.weight("ounces"), 0.0000001);
	}
	
	@Test
	public void testCorrectFactorAssignedForStones() {
		assertEquals(6.35029318, conversions.Converter.weight("stones"), 0.0000001);
	}


}
