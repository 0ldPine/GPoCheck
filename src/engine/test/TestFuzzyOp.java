package engine.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import engine.common.FuzzyOp;

public class TestFuzzyOp {

	@BeforeClass
	public static void initClass() {

	}

	@Before
	public void initMethod() {

	}

	@Test
	public void testOr1Arg() {
		assertTrue(FuzzyOp.or(1) == 1);
	}

	@Test
	public void testOr1ArgNeg() {
		assertTrue(FuzzyOp.or(-1) == -1);
	}
	
	@Test
	public void testOr2Args() {
		assertTrue(FuzzyOp.or(-1, -2) == -1);
	}

	@Test
	public void testOr5Args() {
		assertTrue(FuzzyOp.or(0.1, 0.2, 0.3, 0.4, 0.5) == 0.5);
	}

	@Test
	public void testAnd1Arg() {
		assertTrue(FuzzyOp.and(1) == 1);
	}

	
	@Test
	public void testAnd1ArgNeg() {
		assertTrue(FuzzyOp.and(-1) == -1);
	}
	
	@Test
	public void testAnd2Args() {
		assertTrue(FuzzyOp.and(-1, -2) == -2);
	}

	@Test
	public void testAnd5Args() {
		assertTrue(FuzzyOp.and(0.1, 0.2, 0.3, 0.4, 0.5) == 0.1);
	}

}
