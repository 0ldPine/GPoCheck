package gpocheck;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Callable;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import engine.simple.SimpleMatrixValidate;
import parse.common.GPoMvLexer;
import parse.common.GPoMvParser;
import parse.common.GPoPropLexer;
import parse.common.GPoPropParser;
import parse.common.ModulesFile;
import parse.special.error.UnderlineListener;
import parse.special.listen.SimpleGPoMvListener;
import parse.special.listen.SimpleGPoPropertiesMvListener;

public class GPoCheck implements Callable<String>,Runnable {

	private String moduleFile = null;
	private String propertyFile = null;

	public GPoCheck(String moduleFile, String propertyFile) {
		super();
		this.moduleFile = moduleFile;
		this.propertyFile = propertyFile;
	}

	public ModulesFile executeModule(String inputFile) throws IOException {
		InputStream is = new FileInputStream(inputFile);
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
			return listener.getModulesFile();
		} else {
			System.err.println("Compiler abort!");
		}
		return null;
	}

	public ModulesFile executeProperties(String inputFile, ModulesFile modulesFile) throws IOException {
		InputStream is = new FileInputStream(inputFile);
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
			SimpleGPoPropertiesMvListener listener = new SimpleGPoPropertiesMvListener(modulesFile);
			walker.walk(listener, tree);
			return listener.getModulesFile();
		} else {
			System.err.println("Compiler abort!");
		}
		return null;
	}

	public ModulesFile validateProperty(ModulesFile modulesFile) {
		SimpleMatrixValidate smv = new SimpleMatrixValidate(modulesFile);
		return smv.execute();
	}

	@Override
	public String call() throws Exception {
		double start = System.currentTimeMillis();
		ModulesFile mf = executeModule(moduleFile);
		mf = executeProperties(propertyFile, mf);
		mf = validateProperty(mf);
		double end = System.currentTimeMillis();
		return "Parse Complete!Use time " + (end - start) / 1000 + " seconds" + mf.toString();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

}
