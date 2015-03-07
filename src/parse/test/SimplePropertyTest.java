package parse.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import parse.common.GPoPropLexer;
import parse.common.GPoPropParser;
import parse.common.ModulesFile;
import parse.special.error.UnderlineListener;
import parse.special.listen.SimpleGPoPropertiesMvListener;
import util.DebugOut;

public class SimplePropertyTest {

	// grun parse.common.GPoProp file -gui D:\EclipseStation\GPoCheck_V0.2\files\easy1.poctl
	
	public final String GLOABLFILENAME = "files/li1.poctl";

	public ModulesFile execute(String[] args) throws IOException {
		String inputFile = GLOABLFILENAME;
		if (null != args) {
			if (args.length > 0)
				inputFile = args[0];
		}
		InputStream is = System.in;
		if (inputFile != null) {
			is = new FileInputStream(inputFile);
		}
		ANTLRInputStream input = new ANTLRInputStream(is);
		GPoPropLexer lexer = new GPoPropLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		GPoPropParser parser = new GPoPropParser(tokens);
		parser.removeErrorListeners(); // remove ConsoleErrorListener
		parser.addErrorListener(new UnderlineListener());
		parser.setBuildParseTree(true);
		ParseTree tree = parser.file();
		// compile error if UnderlineListener.errorCount > 0
		if (UnderlineListener.errorCount <= 0) {
			ParseTreeWalker walker = new ParseTreeWalker();
			SimpleGPoPropertiesMvListener listener = new SimpleGPoPropertiesMvListener();
			walker.walk(listener, tree);
			return null;
		} else {
			System.err.println("Compiler abort!");
		}
		return null;
	}

	public static void main(String[] args) throws Exception {
		SimplePropertyTest test = new SimplePropertyTest();
		double start = System.currentTimeMillis();
		ModulesFile mf = test.execute(args);
		double end = System.currentTimeMillis();
		if (null != mf) {
			DebugOut.println("Parse Complete!Use time " + (end - start) / 1000 + " seconds", 2);
			// DebugOut.println(mf.toString(), 2);
		}
	}
}
