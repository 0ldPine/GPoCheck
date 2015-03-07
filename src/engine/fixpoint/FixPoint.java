package engine.fixpoint;


import engine.simple.SimpleMatrix;

/**
 * 每个GPoCTL路径公式都可以刻画为一个适当函数的最大或最小不动点形式
 * 
 * 1.set Z = (1,1,1.....1) 
 * 2.define Zi+1 = f(Zi) 
 * 3.Z0 >= Z1 >= Z2 ...... >= Zi >= Zi+1 
 * 4.Value = Z?
 * 
 * Po(G Φ) : f(Z) = ||Φ|| ∧ ||Po(N Z)||
 * 
 * Po(F Φ): f(Z) = (||Φ|| ∧ Rp) ∨ ||Po(N Z)||
 * 
 * Po(φ U γ) = (||γ|| ∧ Rp) ∨ (||φ|| ∧ ||Po(N Z)||)
 * 
 * ----------------------------------------
 * 
 * Po(N Z) = P。D。Rp
 * 
 * @author Administrator
 *
 */
public class FixPoint {

	private SimpleMatrix moduleTransferMatrix;
	private SimpleMatrix Rp;
	private SimpleMatrix Phi;
	private SimpleMatrix Z0;
	
	public FixPoint(SimpleMatrix Phi,SimpleMatrix moduleTransferMatrix) {
		super();
		this.Phi = Phi;
		this.moduleTransferMatrix = moduleTransferMatrix;
		this.Rp = moduleTransferMatrix.calcRp();
		Z0 = new SimpleMatrix(Phi.getRows(), 1);
		Z0.setContentToValue(1);
	}
	
	public SimpleMatrix calcAlwayProp() {
		SimpleMatrix tmp;
		do {
			SimpleMatrix PoXZ = moduleTransferMatrix.calcRecombine(SimpleMatrix.calcDiagByColVector(Z0)).calcRecombine(Rp);
			SimpleMatrix Z1 = Phi.calcAnd(PoXZ);
			tmp = Z0;
			Z0 = Z1;
		} while (!tmp.equals(Z0));
		Z0.setRowNamesList(moduleTransferMatrix.getRowNamesList());
		return Z0;
	}

	

}
