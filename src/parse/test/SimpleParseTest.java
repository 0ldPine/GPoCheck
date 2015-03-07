package parse.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import engine.simple.SimpleMatrix;
import parse.common.GPoMvLexer;
import parse.common.GPoMvParser;
import parse.common.ModulesFile;
import parse.special.error.UnderlineListener;
import parse.special.listen.SimpleGPoMvListener;
import parse.type.Symbol;
import util.DebugOut;

public class SimpleParseTest {

	// grun parse.common.GPoMv file -gui D:\EclipseStation\GPoCheck_V0.2\files\easy1.gpo

	public final String GLOBALFILENAME = "files/li1.gpo";

	public static Symbol.Type getType(int tokenType) {
		switch (tokenType) {
		case GPoMvParser.K_VOID:
			return Symbol.Type.tVOID;
		case GPoMvParser.K_INT:
			return Symbol.Type.tINT;
		case GPoMvParser.K_FLOAT:
			return Symbol.Type.tFLOAT;
		}
		return Symbol.Type.tINVALID;
	}

	public ModulesFile execute(String[] args) throws IOException {
		String inputFile = GLOBALFILENAME;
		if (null != args) {
			if (args.length > 0)
				inputFile = args[0];
		}
		InputStream is = System.in;
		if (inputFile != null) {
			is = new FileInputStream(inputFile);
		}
		ANTLRInputStream input = new ANTLRInputStream(is);
		GPoMvLexer lexer = new GPoMvLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		GPoMvParser parser = new GPoMvParser(tokens);
		parser.removeErrorListeners(); // remove ConsoleErrorListener
		parser.addErrorListener(new UnderlineListener());
		parser.setBuildParseTree(true);
		ParseTree tree = parser.file();
		// compile error if UnderlineListener.errorCount > 0
		if (UnderlineListener.errorCount <= 0) {
			ParseTreeWalker walker = new ParseTreeWalker();
			SimpleGPoMvListener listener = new SimpleGPoMvListener();
			walker.walk(listener, tree);
			walker.walk(listener, tree);
			DebugOut.println(listener.getModulesFile().toString(), 2);
			testProperty(listener.getModulesFile());
			return listener.getModulesFile();
		} else {
			System.err.println("Compiler abort!");
		}
		return null;
	}

	private void testProperty(ModulesFile modulesFile) {
		// DebugOut.println(modulesFile.toString(), 2);
		/* Property 1 : Po(N(a∧b) */
		SimpleMatrix P = modulesFile.getModuleTransferMatrix().get("Li1");
		SimpleMatrix labelMatrix = modulesFile.getModuleStateLabelMatrix().get("Li1");
		// DebugOut.println(P.toString(), 2);
		// DebugOut.println(labelMatrix.toString(),2);
		ArrayList<Double> aAndBLabel = new ArrayList<Double>();
		for (int i = 0; i < labelMatrix.getRows(); i++) {
			aAndBLabel.add(labelMatrix.getContent()[i][0] < labelMatrix.getContent()[i][1] ? labelMatrix.getContent()[i][0] : labelMatrix.getContent()[i][1]);
		}
		SimpleMatrix diagAAndB = SimpleMatrix.calcDiag(aAndBLabel);
		// DebugOut.println(diagAAndB.toString());
		SimpleMatrix resultMatrix = P.calcRecombine(diagAAndB).calcRecombine(P.calcRp());
		DebugOut.println(resultMatrix.toString(), 2);
	}

	public static void main(String[] args) throws Exception {
		SimpleParseTest test = new SimpleParseTest();
		double start = System.currentTimeMillis();
		ModulesFile mf = test.execute(args);
		double end = System.currentTimeMillis();
		if (null != mf) {
			DebugOut.println("Parse Complete!Use time " + (end - start) / 1000 + " seconds", 2);
			// DebugOut.println(mf.toString(), 2);
		}
	}
}
