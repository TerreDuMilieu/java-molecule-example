package yose.primeFactor;

import static org.junit.Assert.*;

import org.junit.Test;

import yose.primeFactor.PrimeFactor;

public class primeFactorTest {

	@Test
	public void testPrimeFactor2() {
		assertArrayEquals(new Integer[]{2}, PrimeFactor.calcPow2(2));
	}

	@Test
	public void testPrimeFactor16() {
		assertArrayEquals(new Integer[]{2,2,2,2}, PrimeFactor.calcPow2(16));
	}

	@Test
	public void testPrimeFactor6() {
		assertArrayEquals(new Integer[]{2,3}, PrimeFactor.calcPow2(6));
	}
	
	@Test
	public void testPrimeFactor7() {
		assertArrayEquals(new Integer[]{7}, PrimeFactor.calcPow2(7));
	}
	
	@Test
	public void testPrimeFactor9() {
		assertArrayEquals(new Integer[]{3,3}, PrimeFactor.calcPow2(9));
	}
}

