package engine.test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.OptionalDataException;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import engine.simple.SimpleMatrix;

public class TestSimpleMatrix {

	SimpleMatrix sm1 = new SimpleMatrix(4, 4, "P");
	SimpleMatrix sm2 = new SimpleMatrix(4, 4, "P");

	@BeforeClass
	public static void initClass() {

	}

	@Before
	public void initMethod() {
		sm1.setContent(new double[][] { { 0.0, 0.3, 0.0, 0.9 }, { 0.8, 0.0, 0.2, 0.4 }, { 0.0, 0.0, 0.6, 0.0 }, { 0.0, 0.7, 0.9, 0.4 } });
		sm2.setContent(new double[][] { { 0.1, 0.4, 0.0, 0.9 }, { 0.8, 0.0, 0.2, 0.4 }, { 0.0, 0.0, 0.6, 0.0 }, { 0.0, 0.7, 0.9, 0.4 } });
		sm1.setMartrixName("P1");
		sm2.setMartrixName("P2");
	}

	@Test
	public void testObjectCopyNoClone() {

		SimpleMatrix tmp = new SimpleMatrix(4, 4, "P");
		tmp.setContent(new double[][] { { 0.0, 0.8, 0.6, 0.9 }, { 0.0, 0.5, 0.5, 0.5 }, { 0.0, 0.0, 0.9, 0.0 }, { 0.0, 0.7, 0.6, 0.5 } });
		SimpleMatrix tmp2 = tmp;
		tmp2.setMartrixName("P copy");
		tmp.getContent()[0][0] = 100;
		// 直接对象赋值，不复制任何元素，不使用clone
		// System.out.println(tmp);
		// System.out.println(tmp2);
		tmp.setColumns(100);
		// System.out.println(tmp.getColumns());
		// System.out.println(tmp2.getColumns());
	}

	@Test
	public void testObjectCopyClone() throws CloneNotSupportedException {
		SimpleMatrix tmp = new SimpleMatrix(4, 4, "P");
		tmp.setContent(new double[][] { { 0.0, 0.8, 0.6, 0.9 }, { 0.0, 0.5, 0.5, 0.5 }, { 0.0, 0.0, 0.9, 0.0 }, { 0.0, 0.7, 0.6, 0.5 } });
		SimpleMatrix tmp2 = (SimpleMatrix) tmp.clone();
		tmp2.setMartrixName("P copy");
		tmp.getContent()[0][0] = 100;

		// 使用clone方法，赋值基本变量，二维数组不会被clone，一维数组可以
		// System.out.println(tmp);
		// System.out.println(tmp2);
		tmp.setColumns(100);
		// System.out.println(tmp.getColumns());
		// System.out.println(tmp2.getColumns());
	}

	@Test
	public void testObjectCopyDeepClone() throws OptionalDataException, IOException, ClassNotFoundException {
		// 直接对象赋值，修改tmp，tmp2的值也会变，不使用clone
		SimpleMatrix tmp = new SimpleMatrix(4, 4, "P");
		tmp.setContent(new double[][] { { 0.0, 0.8, 0.6, 0.9 }, { 0.0, 0.5, 0.5, 0.5 }, { 0.0, 0.0, 0.9, 0.0 }, { 0.0, 0.7, 0.6, 0.5 } });
		SimpleMatrix tmp2 = (SimpleMatrix) tmp.deepClone();
		tmp2.setMartrixName("P copy");
		tmp.getContent()[0][0] = 100;
		// System.out.println(tmp);
		// System.out.println(tmp2);
		tmp.setColumns(100);
		// System.out.println(tmp.getColumns());
		// System.out.println(tmp2.getColumns());
	}

	@Test
	public void testSetContentToValue() {
		SimpleMatrix tmp = new SimpleMatrix(1, 4, "P");
		tmp.setContentToValue(0.5);
		SimpleMatrix tmp2 = new SimpleMatrix(1, 4, "P");
		tmp2.setContent(new double[][] { { 0.5, 0.5, 0.5, 0.5 } });
		assertTrue("Has some error", tmp.equals(tmp2));
	}

	@Test
	public void testGetSimpleMatrixByCol() {
		SimpleMatrix tmp = new SimpleMatrix(4, 4, "P");
		tmp.setContent(new double[][] { { 0.0, 0.8, 0.6, 0.9 }, { 0.0, 0.5, 0.5, 0.5 }, { 0.0, 0.0, 0.9, 0.0 }, { 0.0, 0.7, 0.6, 0.5 } });
		SimpleMatrix tmp2 = new SimpleMatrix(4, 1, "P");
		tmp2.setContent(new double[][] { { 0.8 }, { 0.5 }, { 0.0 }, { 0.7 } });
		SimpleMatrix tmp3 = tmp.getSimpleMatrixByCol(1);
		assertTrue("Has some error", tmp2.equals(tmp3));
	}

	@Test
	public void testGetSimpleMatrixByRow() {
		SimpleMatrix tmp = new SimpleMatrix(4, 4, "P");
		tmp.setContent(new double[][] { { 0.0, 0.8, 0.6, 0.9 }, { 0.0, 0.5, 0.5, 0.5 }, { 0.0, 0.0, 0.9, 0.0 }, { 0.0, 0.7, 0.6, 0.5 } });
		SimpleMatrix tmp2 = new SimpleMatrix(1, 4, "P");
		tmp2.setContent(new double[][] { { 0.0, 0.0, 0.9, 0.0 } });
		SimpleMatrix tmp3 = tmp.getSimpleMatrixByRow(2);
		assertTrue("Has some error", tmp2.equals(tmp3));
	}

	// rowToColumn columnToRow

	// public static SimpleMatrix calcDiag(SimpleMatrix simpleMatrix) {
	// public static SimpleMatrix calcDiag(ArrayList<Double> dataList)
	@Test
	public void testCalcDiag() {
		SimpleMatrix tmp = new SimpleMatrix(4, 1, "P");
		tmp.setContent(new double[][] { { 0.8 }, { 0.5 }, { 0.0 }, { 0.7 } });
		SimpleMatrix tmp2 = new SimpleMatrix(4, 4, "P");
		tmp2.setContent(new double[][] { { 0.8, 0.0, 0.0, 0.0 }, { 0.0, 0.5, 0.0, 0.0 }, { 0.0, 0.0, 0.0, 0.0 }, { 0.0, 0.0, 0.0, 0.7 } });
		SimpleMatrix tmp3 = SimpleMatrix.calcDiagByColVector(tmp);
		assertTrue("Has some error", tmp2.equals(tmp3));
	}

	@Test
	public void testRowToColumn() {
		SimpleMatrix tmp = new SimpleMatrix(1, 4, "P");
		tmp.setContent(new double[][] { { 0.8, 0.5, 0.0, 0.7 } });
		SimpleMatrix tmp2 = new SimpleMatrix(4, 1, "P");
		tmp2.setContent(new double[][] { { 0.8 }, { 0.5 }, { 0.0 }, { 0.7 } });
		SimpleMatrix tmp3 = SimpleMatrix.rowToColumn(tmp);
		assertTrue("Has some error", tmp2.equals(tmp3));
	}

	@Test
	public void teseColumnToRow() {
		SimpleMatrix tmp = new SimpleMatrix(4, 1, "P");
		tmp.setContent(new double[][] { { 0.8 }, { 0.5 }, { 0.0 }, { 0.7 } });
		SimpleMatrix tmp2 = new SimpleMatrix(1, 4, "P");
		tmp2.setContent(new double[][] { { 0.8, 0.5, 0.0, 0.7 } });
		SimpleMatrix tmp3 = SimpleMatrix.columnToRow(tmp);
		assertTrue("Has some error", tmp2.equals(tmp3));
	}

	@Test
	public void testCalcAnd() {
		// System.out.println(sm1.calcAnd(sm2));
		assertTrue("Has some error", sm1.calcAnd(sm2).equals(sm1));
	}

	@Test
	public void testCalcOr() {
		// System.out.println(sm1.calcOr(sm2));
		assertTrue("Has some error", sm1.calcOr(sm2).equals(sm2));
	}

	@Test
	public void testClacNegation(){
		SimpleMatrix sm1 = new SimpleMatrix(4, 1, "D");
		sm1.setContent(new double[][] { { 0.0 }, { 0.5 }, { 0.1 }, { 0.4 } });
		SimpleMatrix sm2 = new SimpleMatrix(4, 1, "D");
		sm2.setContent(new double[][] { { 1.0 }, { 0.5 }, { 0.9 }, { 0.6 } });
		assertTrue("Has some error", sm1.calcNegation().equals(sm2));
	}
	
	
	@Test
	public void testCalcRecombine() {
		SimpleMatrix sm3 = new SimpleMatrix(4, 4, "P");
		sm3.setContent(new double[][] { { 0.3, 0.7, 0.9, 0.4 }, { 0.0, 0.4, 0.4, 0.8 }, { 0.0, 0.0, 0.6, 0.0 }, { 0.7, 0.4, 0.6, 0.4 } });
		assertTrue("Has some error", sm1.calcRecombine(sm1).equals(sm3));
	}

	@Test
	public void testCalcRecombineDifferntRowsCols() {
		SimpleMatrix sm3 = new SimpleMatrix(4, 4, "P");
		sm3.setContent(new double[][] { { 0.0, 0.8, 0.6, 0.9 }, { 0.0, 0.5, 0.5, 0.5 }, { 0.0, 0.0, 0.9, 0.0 }, { 0.0, 0.7, 0.6, 0.5 } });
		// System.out.println(sm3);
		SimpleMatrix sm4 = new SimpleMatrix(4, 1, "D");
		sm4.setContent(new double[][] { { 0.0 }, { 0.5 }, { 0.9 }, { 0.5 } });
		// System.out.println(sm4);
		SimpleMatrix sm5 = new SimpleMatrix(4, 1, "P Recombine D");
		sm5.setContent(new double[][] { { 0.6 }, { 0.5 }, { 0.9 }, { 0.6 } });
		// System.out.println(sm5);
		assertTrue("Has some error", sm3.calcRecombine(sm4).equals(sm5));
	}

	@Test
	public void testCalcPower1() {
		// System.out.println(sm1.calcPower(1));
		assertTrue("Has some error", sm1.calcPower(1).equals(sm1));
	}

	@Test
	public void testCalcPower2() {
		SimpleMatrix sm3 = new SimpleMatrix(4, 4, "P");
		sm3.setContent(new double[][] { { 0.3, 0.7, 0.9, 0.4 }, { 0.0, 0.4, 0.4, 0.8 }, { 0.0, 0.0, 0.6, 0.0 }, { 0.7, 0.4, 0.6, 0.4 } });
		// System.out.println(sm1.calcPower(2).equals(sm3));
		assertTrue("Has some error", sm1.calcPower(2).equals(sm3));
	}

	@Test
	public void testCalcPplus() {
		SimpleMatrix sm4 = new SimpleMatrix(4, 4, "P");
		sm4.setContent(new double[][] { { 0.7, 0.7, 0.9, 0.9 }, { 0.8, 0.7, 0.8, 0.8 }, { 0.0, 0.0, 0.6, 0.0 }, { 0.7, 0.7, 0.9, 0.7 } });
		// System.out.println(sm1.calcPplus());
		assertTrue("Has some error", sm1.calcPplus().equals(sm4));
	}
	
	@Test
	public void testLunWenLiTi() {
		// Gong Shi1
		SimpleMatrix P = new SimpleMatrix(4, 4, "P");//P
		P.setContent(new double[][] { { 0, 0.4, 0, 0.4 }, { 0, 0.3, 1, 0.8 }, { 0.0, 0.1, 0, 0 }, { 0.9, 0, 0.7, 0.0} });
		SimpleMatrix D = new SimpleMatrix(4, 4, "D");//D
		D.setContent(new double[][] { { 0.4 }, {  0.4 }, {  0.1 }, { 0.4 } });
		SimpleMatrix Pplus = P.calcPplus();//P+
		System.out.println(Pplus);
		SimpleMatrix Rp = P.calcRp();
		System.out.println(Rp);
		
		SimpleMatrix Db = new SimpleMatrix(4, 1, "Db");//D_b 0.9,0,0.6,0.9
		Db.setContent(new double[][] { { 0.9 }, { 0 }, { 0.6 }, { 0.9 } });
		SimpleMatrix Dc = new SimpleMatrix(4, 1, "Dc");//D_b 0.9,0,0.6,0.9
		Dc.setContent(new double[][] { { 0 }, { 0 }, { 0.4 }, { 0.3 } });
		Db = Db.calcDiagByColVector(Db);
		System.out.println(Db);
		Dc = Db.calcDiagByColVector(Dc);
		System.out.println(Dc);
		
		SimpleMatrix GongShi1 = Db.calcRecombine(P).calcPstar().calcRecombine(Dc).calcRecombine(Rp);
		System.out.println(GongShi1);
		
		// Gong Shi2
		SimpleMatrix Z0 = new SimpleMatrix(4, 1, "Z0");//Z0
		Z0.setContent(new double[][] { { 1 }, {  1 }, {  1 }, { 1 } });
		Z0 = Z0.calcDiagByColVector(Z0);
		
		SimpleMatrix Phi = new SimpleMatrix(4, 1, "Phi");//Phi
		Phi.setContent(new double[][] { { 0.9 }, { 0.2 }, { 0.6 }, { 0.9 } });
		
		SimpleMatrix Z1 = Phi.calcAnd( P.calcRecombine(Z0).calcRecombine(Rp) );
		System.out.println(Z1);
		
		SimpleMatrix Z2 = Phi.calcAnd( P.calcRecombine(Z1.calcDiagByColVector(Z1)).calcRecombine(Rp) );
		System.out.println(Z2);
	}

	@Test
	public void testCalcPstart() {
		SimpleMatrix sm5 = new SimpleMatrix(4, 4, "P");
		sm5.setContent(new double[][] { { 1.0, 0.7, 0.9, 0.9 }, { 0.8, 1.0, 0.8, 0.8 }, { 0.0, 0.0, 1.0, 0.0 }, { 0.7, 0.7, 0.9, 1.0 } });
		// System.out.println(sm1.calcPstar());
		assertTrue("Has some error", sm1.calcPstar().equals(sm5));
	}

	@Test
	public void testCalcRp() {
		SimpleMatrix P = new SimpleMatrix(4, 4, "P");
		P.setContent(new double[][] { { 0.2, 0.9, 0.6, 0.3 }, { 0.4, 0.5, 1, 0.7 }, { 0.2, 0.3, 0.5, 1 }, { 0.1, 0.3, 0.8, 0.7 } });
		SimpleMatrix I = new SimpleMatrix(4, 1, "I");
		I.setContent(new double[][] { { 1 }, { 0 }, { 0 }, { 0 } });
		SimpleMatrix Pplus = P.calcPplus();
		// System.out.println(Pplus);
		SimpleMatrix rightPlus = new SimpleMatrix(4, 4, "rightPlus");
		rightPlus.setContent(new double[][] { { 0.4, 0.9, 0.9, 0.9 }, { 0.4, 0.5, 1, 1 }, { 0.3, 0.3, 0.8, 1 }, { 0.3, 0.3, 0.8, 0.8 } });
		assertTrue("Has some error", Pplus.equals(rightPlus));
		SimpleMatrix Rp = P.calcRp(Pplus);
		// System.out.println(Rp);
		SimpleMatrix rightRp = new SimpleMatrix(4, 1, "rightPp");
		rightRp.setContent(new double[][] { { 0.8 }, { 0.8 }, { 0.8 }, { 0.8 } });
		assertTrue("Has some error", Rp.equals(rightRp));
	}

	@Test
	public void testCalcRpWithArg() {
		SimpleMatrix P = new SimpleMatrix(4, 4, "P");
		P.setContent(new double[][] { { 0.0, 0.8, 0.0, 0.9 }, { 0.0, 0.0, 0.2, 0.5 }, { 0.0, 0.0, 0.9, 0.0 }, { 0.0, 0.7, 0.6, 0.4 } });
		SimpleMatrix I = new SimpleMatrix(4, 1, "I");
		I.setContent(new double[][] { { 1, 0, 0, 0 }, { 0, 1, 0, 0 }, { 0, 0, 1, 0 }, { 0, 0, 0, 1 } });
		// SimpleMatrix Pplus = P.calcPplus();
		SimpleMatrix Rp = P.calcRp();
		// System.out.println(Rp);
		SimpleMatrix rightRp = new SimpleMatrix(4, 1, "rightPp");
		rightRp.setContent(new double[][] { { 0.6 }, { 0.5 }, { 0.9 }, { 0.6 } });
		assertTrue("Has some error", Rp.equals(rightRp));
	}

	@Test
	public void testModelMa() {
		SimpleMatrix P = new SimpleMatrix(4, 4, "P");
		P.setContent(new double[][] { { 0.2, 0.9, 0.6, 0.3 }, { 0.4, 0.5, 1, 0.7 }, { 0.2, 0.3, 0.5, 1 }, { 0.1, 0.3, 0.8, 0.7 } });
		SimpleMatrix I = new SimpleMatrix(4, 1, "I");
		I.setContent(new double[][] { { 1 }, { 0 }, { 0 }, { 0 } });
		SimpleMatrix Pplus = P.calcPplus();
		// System.out.println(Pplus);
		SimpleMatrix rightPlus = new SimpleMatrix(4, 4, "rightPlus");
		rightPlus.setContent(new double[][] { { 0.4, 0.9, 0.9, 0.9 }, { 0.4, 0.5, 1, 1 }, { 0.3, 0.3, 0.8, 1 }, { 0.3, 0.3, 0.8, 0.8 } });
		assertTrue("Has some error", Pplus.equals(rightPlus));
		SimpleMatrix Rp = P.calcRp(Pplus);
		// System.out.println(Rp);
		SimpleMatrix rightRp = new SimpleMatrix(4, 1, "rightPp");
		rightRp.setContent(new double[][] { { 0.8 }, { 0.8 }, { 0.8 }, { 0.8 } });
		assertTrue("Has some error", Rp.equals(rightRp));
	}

	/*
	 * "Possibilistic Computation Tree Logic Model Checking Based on Generalized Possibility Measures" -- Example
	 */
	@Test
	public void testModelLi() {
		SimpleMatrix P = new SimpleMatrix(4, 4, "P");
		P.setContent(new double[][] { { 0.0, 0.8, 0.0, 0.9 }, { 0.0, 0.0, 0.2, 0.5 }, { 0.0, 0.0, 0.9, 0.0 }, { 0.0, 0.7, 0.6, 0.4 } });
		SimpleMatrix I = new SimpleMatrix(4, 1, "I");
		I.setContent(new double[][] { { 1, 0, 0, 0 }, { 0, 1, 0, 0 }, { 0, 0, 1, 0 }, { 0, 0, 0, 1 } });
		// SimpleMatrix Pplus = P.calcPplus();
		SimpleMatrix Rp = P.calcRp();
		// System.out.println(Rp);
		SimpleMatrix rightRp = new SimpleMatrix(4, 1, "rightPp");
		rightRp.setContent(new double[][] { { 0.6 }, { 0.5 }, { 0.9 }, { 0.6 } });
		SimpleMatrix Dab = new SimpleMatrix(4, 4, "Dab");
		Dab.setContent(new double[][] { { 0.8, 0, 0, 0 }, { 0, 0.6, 0, 0 }, { 0, 0, 0, 0.0 }, { 0, 0, 0, 0.4 } });
		// System.out.println(P.calcRecombine(Dab).calcRecombine(Rp));
		assertTrue("Has some error", Rp.equals(rightRp));
	}

}
