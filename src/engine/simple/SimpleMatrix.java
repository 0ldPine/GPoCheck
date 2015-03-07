package engine.simple;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OptionalDataException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import util.DebugOut;
import engine.common.FuzzyOp;

public class SimpleMatrix implements Cloneable, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int rows;
	private int columns;

	private String martrixName;

	private double[][] content;

	private List<String> columnNamesList;
	private List<String> rowNamesList;

	/**
	 * initial simple matrix 初始化矩阵
	 * 
	 * @param x
	 *            rows
	 * @param y
	 *            columns
	 */
	public SimpleMatrix(int x, int y) {
		this.rows = x;
		this.columns = y;
		this.martrixName = "No Name";
		this.content = new double[x][y];
		columnNamesList = new ArrayList<String>();
		rowNamesList = new ArrayList<String>();
	}

	/**
	 * initial simple matrix 初始化矩阵
	 * 
	 * @param x
	 *            rows
	 * @param y
	 *            columns
	 * @param martixName
	 */
	public SimpleMatrix(int x, int y, String martixName) {
		this.rows = x;
		this.columns = y;
		this.martrixName = martixName;
		this.content = new double[x][y];
		columnNamesList = new ArrayList<String>();
		rowNamesList = new ArrayList<String>();
	}

	/**
	 * 将一个列表转化为Diag矩阵，必须列向量矩阵，如果行向量，使用 rowToColumn(SimpleMatrix s)转化
	 * 
	 * @param dataList
	 * @return
	 */
	public static SimpleMatrix calcDiagByColVector(SimpleMatrix simpleMatrix) {
		if (null == simpleMatrix)
			return null;
		if (1 != simpleMatrix.getColumns())
			return null;
		SimpleMatrix sm = new SimpleMatrix(simpleMatrix.getRows(), simpleMatrix.getRows(), "Diag");
		for (int i = 0; i < simpleMatrix.getRows(); i++) {
			sm.getContent()[i][i] = simpleMatrix.getContent()[i][0];
		}
		return sm;
	}

	/**
	 * 行转列
	 * 
	 * @param simpleMatrix
	 * @return
	 */
	public static SimpleMatrix rowToColumn(SimpleMatrix simpleMatrix) {
		if (null == simpleMatrix)
			return null;
		if (1 != simpleMatrix.getRows())
			return null;
		SimpleMatrix sm = new SimpleMatrix(simpleMatrix.getColumns(), 1);
		for (int i = 0; i < simpleMatrix.getColumns(); i++) {
			sm.getContent()[i][0] = simpleMatrix.getContent()[0][i];
		}
		return sm;
	}

	/**
	 * 列转行
	 * 
	 * @param simpleMatrix
	 * @return
	 */
	public static SimpleMatrix columnToRow(SimpleMatrix simpleMatrix) {
		if (null == simpleMatrix)
			return null;
		if (1 != simpleMatrix.getColumns())
			return null;
		SimpleMatrix sm = new SimpleMatrix(1, simpleMatrix.getRows());
		for (int i = 0; i < simpleMatrix.getRows(); i++) {
			sm.getContent()[0][i] = simpleMatrix.getContent()[i][0];
		}
		return sm;
	}

	/**
	 * 将一个列表转化为Diag矩阵
	 * 
	 * @param dataList
	 * @return
	 */
	public static SimpleMatrix calcDiag(ArrayList<Double> dataList) {
		if (null == dataList)
			return null;
		if (0 == dataList.size())
			return null;
		SimpleMatrix sm = new SimpleMatrix(dataList.size(), dataList.size(), "Diag");
		for (int i = 0; i < dataList.size(); i++)
			sm.setContentByIndex(i, i, dataList.get(i));
		return sm;
	}

	/**
	 * fuzzy matrix recombine 模糊矩阵复合运算
	 * 
	 * @param sm
	 */
	public SimpleMatrix calcRecombine(SimpleMatrix sm) {
		if (sm.getRows() != this.columns) {
			DebugOut.printErrln("Matrix width or height not matching!", 4);
			return null;
		} else {
			SimpleMatrix tmpSimpleMatrix = new SimpleMatrix(this.getRows(), sm.getColumns(), "(" + this.martrixName + "•" + sm.getMartrixName() + ")");
			// every element need calculate
			for (int i = 0; i < this.getRows(); i++) {
				for (int j = 0; j < sm.getColumns(); j++) {
					// calculate
					double tmpVal = -Double.MAX_VALUE;
					for (int k = 0; k < this.getColumns(); k++) {
						tmpVal = FuzzyOp.or(tmpVal, FuzzyOp.and(this.content[i][k], sm.getContent()[k][j]));
					}
					tmpSimpleMatrix.getContent()[i][j] = tmpVal;
				}
			}
			tmpSimpleMatrix.setRows(this.getRows());
			tmpSimpleMatrix.setColumns(sm.getColumns());
			return tmpSimpleMatrix;
		}
	}

	/**
	 * assign value to matrix content
	 * 
	 * @param value
	 */
	public void setContentToValue(double value) {
		for (int i = 0; i < content.length; i++) {
			for (int j = 0; j < content[i].length; j++) {
				content[i][j] = value;
			}
		}
	}

	/**
	 * get column matrix by column index
	 * 
	 * @param col
	 * @return
	 */
	public SimpleMatrix getSimpleMatrixByCol(int col) {
		SimpleMatrix tmpSimpleMatrix = new SimpleMatrix(this.rows, 1);
		double[][] content = new double[this.rows][1];
		for (int i = 0; i < this.rows; i++) {
			content[i][0] = this.content[i][col];
		}
		tmpSimpleMatrix.setContent(content);
		return tmpSimpleMatrix;
	}

	/**
	 * get row matrix by row index
	 * 
	 * @param row
	 * @return
	 */
	public SimpleMatrix getSimpleMatrixByRow(int row) {
		SimpleMatrix tmpSimpleMatrix = new SimpleMatrix(1, this.columns);
		double[][] content = new double[1][this.columns];
		for (int j = 0; j < this.columns; j++) {
			content[0][j] = this.content[row][j];
		}
		tmpSimpleMatrix.setContent(content);
		return tmpSimpleMatrix;
	}

	/**
	 * fuzzy matrix and operate 模糊矩阵交运算
	 * 
	 * @param sm
	 * @return
	 */
	public SimpleMatrix calcAnd(SimpleMatrix sm) {
		if (sm.getRows() != this.rows || sm.getColumns() != this.columns) {
			DebugOut.printErrln("Matrix width or height not matching!", 4);
			return null;
		} else {
			SimpleMatrix tmpSimpleMatrix = new SimpleMatrix(this.getRows(), this.getColumns(), "(" + this.getMartrixName() + "∧" + sm.getMartrixName() + ")");
			for (int i = 0; i < this.rows; i++) {
				for (int j = 0; j < this.columns; j++) {
					if (this.content[i][j] <= sm.getContent()[i][j])
						tmpSimpleMatrix.getContent()[i][j] = this.content[i][j];
					else
						tmpSimpleMatrix.getContent()[i][j] = sm.getContent()[i][j];
				}
			}
			return tmpSimpleMatrix;
		}
	}

	public SimpleMatrix calcNegation() {
		SimpleMatrix tmpSimpleMatrix = new SimpleMatrix(this.getRows(), this.getColumns(), "(﹁" + this.martrixName + ")");
		for (int i = 0; i < this.rows; i++) {
			for (int j = 0; j < this.columns; j++) {
				tmpSimpleMatrix.getContent()[i][j] = 1 - this.content[i][j];
			}
		}
		return tmpSimpleMatrix;
	}

	/**
	 * fuzzy matrix or operate 模糊矩阵并运算
	 * 
	 * @param sm
	 * @return
	 */
	public SimpleMatrix calcOr(SimpleMatrix sm) {
		if (sm.getRows() != this.rows || sm.getColumns() != this.columns) {
			DebugOut.printErrln("Matrix width or height not matching!", 4);
			return null;
		} else {
			SimpleMatrix tmpSimpleMatrix = new SimpleMatrix(this.getRows(), this.getColumns(), "(" + this.getMartrixName() + "∨" + sm.getMartrixName() + ")");
			for (int i = 0; i < this.rows; i++) {
				for (int j = 0; j < this.columns; j++) {
					if (this.content[i][j] >= sm.getContent()[i][j])
						tmpSimpleMatrix.getContent()[i][j] = this.content[i][j];
					else
						tmpSimpleMatrix.getContent()[i][j] = sm.getContent()[i][j];
				}
			}
			return tmpSimpleMatrix;
		}
	}

	/**
	 * fuzzy matrix power operate 模糊矩阵指数运算 example : P^3 = P*P*P
	 * 
	 * @param n
	 */
	public SimpleMatrix calcPower(int n) {
		if (this.getColumns() != this.getRows()) {
			DebugOut.printErrln("matrix must be square!", 4);
			return null;
		} else {
			SimpleMatrix sm = new SimpleMatrix(this.rows, this.columns);
			sm.setContent(this.content);
			for (int i = 1; i < n; i++) {
				sm = this.calcRecombine(sm);
			}
			return sm;
		}
	}

	/**
	 * fuzzy matrix P+闭包 P+=P^1∪P^2∪P^3...
	 */
	public SimpleMatrix calcPplus() {
		if (this.getColumns() != this.getRows()) {
			DebugOut.printErrln("matrix must be square!", 4);
			return null;
		} else {
			int n = 1;
			SimpleMatrix result = new SimpleMatrix(this.rows, this.columns, this.getMartrixName() + "^" + n);
			result.setContent(this.content);// P^1
			SimpleMatrix tmp = new SimpleMatrix(this.rows, this.columns, this.getMartrixName() + "^" + n);
			tmp.setContent(this.content);
			SimpleMatrix P = new SimpleMatrix(this.rows, this.columns);
			P.setContent(this.content);
			DebugOut.printErrln(tmp.toString(), 0);
			tmp = tmp.calcRecombine(P);// P^2
			tmp.setMartrixName(this.getMartrixName() + "^" + n++);
			DebugOut.printErrln(tmp.toString(), 0);
			while (!result.equals(result.calcOr(tmp))) {
				result = result.calcOr(tmp);
				tmp = tmp.calcRecombine(P);// P^3 P^4 ...
				tmp.setMartrixName(this.getMartrixName() + "^" + n++);
				DebugOut.printErrln(tmp.toString(), 0);
			}
			result.setMartrixName(this.getMartrixName() + "+");
			return result;
		}
	}

	/**
	 * fuzzy matrix P*闭包 P*=P^0∪P+
	 */
	public SimpleMatrix calcPstar() {
		if (this.getColumns() != this.getRows()) {
			DebugOut.printErrln("matrix must be square!", 4);
			return null;
		} else {
			SimpleMatrix sm1 = new SimpleMatrix(this.rows, this.columns, this.getMartrixName() + ")*");
			double[][] d = new double[this.rows][this.columns];
			for (int i = 0; i < this.rows; i++) {
				d[i][i] = 1d;
			}
			sm1.setContent(d);
			sm1 = this.calcPplus().calcOr(sm1);
			return sm1;
		}
	}

	/**
	 * the max probability of every point move to its successor point. Rp = P+。D D = (P+(t,t))(t∈S) 直接使用当前矩阵计算Rp
	 * 
	 * @return
	 */
	public SimpleMatrix calcRp() {
		if (this.getColumns() != this.getRows()) {
			DebugOut.printErrln("matrix must be square!", 4);
			return null;
		} else {
			SimpleMatrix Pplus = this.calcPplus();
			SimpleMatrix D = new SimpleMatrix(this.getRows(), 1, "D");
			double[][] d = new double[this.getRows()][1];
			for (int i = 0; i < this.getRows(); i++) {
				d[i][0] = Pplus.getContent()[i][i];
			}
			D.setContent(d);
			Pplus = Pplus.calcRecombine(D);
			// Pplus.setMartrixName("Rp=" + Pplus.getMartrixName());
			Pplus.setMartrixName("Rp");
			return Pplus;
		}
	}

	/**
	 * 通过P+算Rp
	 * 
	 * @param ArgPplus
	 * @return
	 */
	public SimpleMatrix calcRp(SimpleMatrix ArgPplus) {
		if (ArgPplus.getColumns() != ArgPplus.getRows()) {
			DebugOut.printErrln("Pplus matrix must be square!", 4);
			return null;
		} else {
			SimpleMatrix Pplus = ArgPplus;
			SimpleMatrix D = new SimpleMatrix(this.getRows(), 1, "D");
			double[][] d = new double[this.getRows()][1];
			for (int i = 0; i < this.getRows(); i++) {
				d[i][0] = Pplus.getContent()[i][i];
			}
			D.setContent(d);
			Pplus = Pplus.calcRecombine(D);
			Pplus.setMartrixName("Rp=" + Pplus.getMartrixName());
			return Pplus;
		}
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getColumns() {
		return columns;
	}

	public void setColumns(int columns) {
		this.columns = columns;
	}

	public double[][] getContent() {
		return content;
	}

	public void setContent(double[][] content) {
		this.content = content;
	}

	public String getMartrixName() {
		return martrixName;
	}

	public void setMartrixName(String martrixName) {
		this.martrixName = martrixName;
	}

	public List<String> getColumnNamesList() {
		return columnNamesList;
	}

	public void setColumnNamesList(List<String> columnNamesList) {
		this.columnNamesList = columnNamesList;
	}

	public List<String> getRowNamesList() {
		return rowNamesList;
	}

	public void setRowNamesList(List<String> rowNamesList) {
		this.rowNamesList = rowNamesList;
	}

	public void setContentByIndex(int x, int y, double value) {
		if (x >= this.rows || x < 0 || y < 0 || y >= this.columns) {
			DebugOut.printErrln("Matrix index out of bound", 4);
		} else {
			this.content[x][y] = value;
		}
	}

	@Override
	// maybe format double
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.getMartrixName() + ":\n");
		if (columnNamesList.size() == 0 && rowNamesList.size() == 0) {
			for (int i = 0; i < this.rows; i++) {
				for (int j = 0; j < this.columns; j++) {
					sb.append(this.content[i][j] + " ");
				}
				sb.append("\n");
			}
		} else if (columnNamesList.size() != 0 && rowNamesList.size() == 0) {
			if (columnNamesList.size() != this.columns)
				return "colum names number not equals martix colums\n";
			if (rowNamesList.size() == 0) {
				for (int i = 0; i < columnNamesList.size(); i++) {
					sb.append(String.format("%5s", columnNamesList.get(i)));
				}
				sb.append("\n");
				for (int i = 0; i < this.rows; i++) {
					for (int j = 0; j < this.columns; j++) {
						sb.append(String.format("% 1.2f", this.content[i][j]));
					}
					sb.append("\n");
				}
			}
		} else if (columnNamesList.size() == 0 && rowNamesList.size() != 0) {
			if (rowNamesList.size() != this.rows)
				return "row names number not equals matrix rows\n";
			for (int i = 0; i < rowNamesList.size(); i++) {
				sb.append(String.format("%-9s", rowNamesList.get(i)));
				for (int j = 0; j < this.columns; j++) {
					sb.append(String.format("%1.2f    ", this.content[i][j]));
				}
				sb.append("\n");
			}
		} else {
			if (columnNamesList.size() != this.columns)
				return "colum names number not equals martix colums\n";
			if (rowNamesList.size() != this.rows)
				return "row names number not equals matrix rows\n";
			sb.append(String.format("%9s", ""));
			for (int i = 0; i < columnNamesList.size(); i++) {
				sb.append(String.format("%-8s", columnNamesList.get(i)));
			}
			sb.append("\n");
			for (int i = 0; i < rowNamesList.size(); i++) {
				sb.append(String.format("%-9s", rowNamesList.get(i)));
				for (int j = 0; j < this.columns; j++) {
					sb.append(String.format("%1.2f    ", this.content[i][j]));
				}
				sb.append("\n");
			}
		}
		return sb.toString();
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		SimpleMatrix sm = (SimpleMatrix) obj;
		if (sm.getRows() != this.rows)
			return false;
		if (sm.getColumns() != this.columns)
			return false;
		for (int i = 0; i < this.rows; i++) {
			for (int j = 0; j < this.columns; j++) {
				if (sm.getContent()[i][j] != this.content[i][j])
					return false;
			}
		}
		return true;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

	public Object deepClone() throws IOException, OptionalDataException, ClassNotFoundException {
		// 将对象写到流里
		ByteArrayOutputStream bo = new ByteArrayOutputStream();
		ObjectOutputStream oo = new ObjectOutputStream(bo);
		oo.writeObject(this);
		// 从流里读出来
		ByteArrayInputStream bi = new ByteArrayInputStream(bo.toByteArray());
		ObjectInputStream oi = new ObjectInputStream(bi);
		return (oi.readObject());
	}
}
