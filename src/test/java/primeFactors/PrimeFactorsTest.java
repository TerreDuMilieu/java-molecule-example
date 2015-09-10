package primeFactors;
import static org.junit.Assert.*;

import org.junit.Test;

import primeFactor.PrimeFactors;

public class PrimeFactorsTest {

	@Test
	public void test() {
		assertArrayEquals(new int[] {2},PrimeFactors.primesOf(2));
	}
	
	@Test
	public void testReturnsArray() {
		assertArrayEquals(new int[] {2, 2},PrimeFactors.primesOf(4));
	}
	
	@Test
	public void testCorrectForPowerOfTwo()  {
		assertArrayEquals(new int[] {2,2,2,2}, PrimeFactors.primesOf(16));
	}

	@Test
	public void testCorrectForPrimesTwoAndThree()  {
		assertArrayEquals(new int[] {2,3}, PrimeFactors.primesOf(6));
	}
}
