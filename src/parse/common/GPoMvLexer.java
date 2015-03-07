// Generated from GPoMv.g4 by ANTLR 4.4
package parse.common;
   
import java.util.*;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GPoMvLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__13=1, T__12=2, T__11=3, T__10=4, T__9=5, T__8=6, T__7=7, T__6=8, T__5=9, 
		T__4=10, T__3=11, T__2=12, T__1=13, T__0=14, MODULE=15, ENDMODULE=16, 
		INIT=17, TRANS=18, LABELS=19, K_INT=20, K_DOUBLE=21, K_FLOAT=22, K_BOOLEAN=23, 
		K_VOID=24, ID=25, NUMBER=26, FLOAT=27, INT=28, STRING=29, BOOL=30, EQUAL=31, 
		BRACELEFT=32, BRACERIGHT=33, BRACKETLEFT=34, BRACKETRIGHT=35, SEMICONLON=36, 
		COLON=37, DOTDOT=38, MUL=39, DIV=40, ADD=41, SUB=42, WS=43, COMMENT=44, 
		LINE_COMMENT=45, JING_COMMENT=46;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'", "'\\u0003'", "'\\u0004'", "'\\u0005'", 
		"'\\u0006'", "'\\u0007'", "'\b'", "'\t'", "'\n'", "'\\u000B'", "'\f'", 
		"'\r'", "'\\u000E'", "'\\u000F'", "'\\u0010'", "'\\u0011'", "'\\u0012'", 
		"'\\u0013'", "'\\u0014'", "'\\u0015'", "'\\u0016'", "'\\u0017'", "'\\u0018'", 
		"'\\u0019'", "'\\u001A'", "'\\u001B'", "'\\u001C'", "'\\u001D'", "'\\u001E'", 
		"'\\u001F'", "' '", "'!'", "'\"'", "'#'", "'$'", "'%'", "'&'", "'''", 
		"'('", "')'", "'*'", "'+'", "','", "'-'", "'.'"
	};
	public static final String[] ruleNames = {
		"T__13", "T__12", "T__11", "T__10", "T__9", "T__8", "T__7", "T__6", "T__5", 
		"T__4", "T__3", "T__2", "T__1", "T__0", "MODULE", "ENDMODULE", "INIT", 
		"TRANS", "LABELS", "K_INT", "K_DOUBLE", "K_FLOAT", "K_BOOLEAN", "K_VOID", 
		"ID", "NUMBER", "FLOAT", "INT", "STRING", "BOOL", "EQUAL", "BRACELEFT", 
		"BRACERIGHT", "BRACKETLEFT", "BRACKETRIGHT", "SEMICONLON", "COLON", "DOTDOT", 
		"MUL", "DIV", "ADD", "SUB", "ESC", "UNICODE", "HEX", "ID_LETTER", "NOZERODIGIT", 
		"DIGIT", "EXP", "WS", "COMMENT", "LINE_COMMENT", "JING_COMMENT"
	};

	   
	/**************************************************************/
	// Add by dc, only hints
	public static final int WHITESPACE = 1;
	public static final int COMMENTS   = 2;
	// new block

	/**************************************************************/


	public GPoMvLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "GPoMv.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\60\u0173\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64"+
		"\t\64\4\65\t\65\4\66\t\66\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\6"+
		"\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\n\3\n\3\13\3\13\3\13"+
		"\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3"+
		"\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3"+
		"\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\24\3\24\3\24\3"+
		"\24\3\24\3\24\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3"+
		"\27\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3"+
		"\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\7\32\u00d9\n\32\f\32\16\32\u00dc"+
		"\13\32\3\32\5\32\u00df\n\32\3\33\5\33\u00e2\n\33\3\33\3\33\3\33\3\33\5"+
		"\33\u00e8\n\33\3\33\5\33\u00eb\n\33\3\33\3\33\3\33\3\33\5\33\u00f1\n\33"+
		"\3\33\5\33\u00f4\n\33\3\34\5\34\u00f7\n\34\3\34\3\34\3\34\3\34\3\35\6"+
		"\35\u00fe\n\35\r\35\16\35\u00ff\3\36\3\36\3\36\7\36\u0105\n\36\f\36\16"+
		"\36\u0108\13\36\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3#\3#\3$\3$\3"+
		"%\3%\3&\3&\3\'\3\'\3\'\3(\3(\3)\3)\3*\3*\3+\3+\3,\3,\3,\5,\u012a\n,\3"+
		"-\3-\3-\3-\3-\3-\3.\3.\3/\5/\u0135\n/\3\60\3\60\3\61\3\61\3\62\3\62\5"+
		"\62\u013d\n\62\3\62\3\62\3\63\6\63\u0142\n\63\r\63\16\63\u0143\3\63\3"+
		"\63\3\64\3\64\3\64\3\64\7\64\u014c\n\64\f\64\16\64\u014f\13\64\3\64\3"+
		"\64\3\64\3\64\3\64\3\65\3\65\3\65\3\65\7\65\u015a\n\65\f\65\16\65\u015d"+
		"\13\65\3\65\5\65\u0160\n\65\3\65\3\65\3\65\3\65\3\66\3\66\7\66\u0168\n"+
		"\66\f\66\16\66\u016b\13\66\3\66\5\66\u016e\n\66\3\66\3\66\3\66\3\66\5"+
		"\u014d\u015b\u0169\2\67\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f"+
		"\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63"+
		"\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W\2Y\2[\2]\2_\2a\2"+
		"c\2e-g.i/k\60\3\2\f\4\2$$^^\4\2HHVV\n\2$$\61\61^^ddhhppttvv\5\2\62;CH"+
		"ch\5\2C\\aac|\3\2\63;\3\2\62;\4\2GGgg\4\2--//\5\2\13\f\17\17\"\"\u0180"+
		"\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2"+
		"\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2"+
		"\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2"+
		"\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2"+
		"\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3"+
		"\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2"+
		"\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2"+
		"U\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\3m\3\2\2\2\5o\3"+
		"\2\2\2\7q\3\2\2\2\ts\3\2\2\2\13u\3\2\2\2\rx\3\2\2\2\17z\3\2\2\2\21\u0081"+
		"\3\2\2\2\23\u0084\3\2\2\2\25\u0086\3\2\2\2\27\u008b\3\2\2\2\31\u0090\3"+
		"\2\2\2\33\u0093\3\2\2\2\35\u0095\3\2\2\2\37\u0097\3\2\2\2!\u009e\3\2\2"+
		"\2#\u00a9\3\2\2\2%\u00ae\3\2\2\2\'\u00b1\3\2\2\2)\u00b7\3\2\2\2+\u00bb"+
		"\3\2\2\2-\u00c2\3\2\2\2/\u00c8\3\2\2\2\61\u00d0\3\2\2\2\63\u00d5\3\2\2"+
		"\2\65\u00f3\3\2\2\2\67\u00f6\3\2\2\29\u00fd\3\2\2\2;\u0101\3\2\2\2=\u010b"+
		"\3\2\2\2?\u010d\3\2\2\2A\u010f\3\2\2\2C\u0111\3\2\2\2E\u0113\3\2\2\2G"+
		"\u0115\3\2\2\2I\u0117\3\2\2\2K\u0119\3\2\2\2M\u011b\3\2\2\2O\u011e\3\2"+
		"\2\2Q\u0120\3\2\2\2S\u0122\3\2\2\2U\u0124\3\2\2\2W\u0126\3\2\2\2Y\u012b"+
		"\3\2\2\2[\u0131\3\2\2\2]\u0134\3\2\2\2_\u0136\3\2\2\2a\u0138\3\2\2\2c"+
		"\u013a\3\2\2\2e\u0141\3\2\2\2g\u0147\3\2\2\2i\u0155\3\2\2\2k\u0165\3\2"+
		"\2\2mn\7(\2\2n\4\3\2\2\2op\7+\2\2p\6\3\2\2\2qr\7.\2\2r\b\3\2\2\2st\7*"+
		"\2\2t\n\3\2\2\2uv\7k\2\2vw\7h\2\2w\f\3\2\2\2xy\7>\2\2y\16\3\2\2\2z{\7"+
		"i\2\2{|\7n\2\2|}\7q\2\2}~\7d\2\2~\177\7c\2\2\177\u0080\7n\2\2\u0080\20"+
		"\3\2\2\2\u0081\u0082\7#\2\2\u0082\u0083\7?\2\2\u0083\22\3\2\2\2\u0084"+
		"\u0085\7@\2\2\u0085\24\3\2\2\2\u0086\u0087\7v\2\2\u0087\u0088\7j\2\2\u0088"+
		"\u0089\7g\2\2\u0089\u008a\7p\2\2\u008a\26\3\2\2\2\u008b\u008c\7g\2\2\u008c"+
		"\u008d\7n\2\2\u008d\u008e\7u\2\2\u008e\u008f\7g\2\2\u008f\30\3\2\2\2\u0090"+
		"\u0091\7?\2\2\u0091\u0092\7?\2\2\u0092\32\3\2\2\2\u0093\u0094\7~\2\2\u0094"+
		"\34\3\2\2\2\u0095\u0096\7#\2\2\u0096\36\3\2\2\2\u0097\u0098\7O\2\2\u0098"+
		"\u0099\7q\2\2\u0099\u009a\7w\2\2\u009a\u009b\7f\2\2\u009b\u009c\7n\2\2"+
		"\u009c\u009d\7g\2\2\u009d \3\2\2\2\u009e\u009f\7G\2\2\u009f\u00a0\7p\2"+
		"\2\u00a0\u00a1\7f\2\2\u00a1\u00a2\7\"\2\2\u00a2\u00a3\7O\2\2\u00a3\u00a4"+
		"\7q\2\2\u00a4\u00a5\7w\2\2\u00a5\u00a6\7f\2\2\u00a6\u00a7\7n\2\2\u00a7"+
		"\u00a8\7g\2\2\u00a8\"\3\2\2\2\u00a9\u00aa\7k\2\2\u00aa\u00ab\7p\2\2\u00ab"+
		"\u00ac\7k\2\2\u00ac\u00ad\7v\2\2\u00ad$\3\2\2\2\u00ae\u00af\7/\2\2\u00af"+
		"\u00b0\7@\2\2\u00b0&\3\2\2\2\u00b1\u00b2\7N\2\2\u00b2\u00b3\7c\2\2\u00b3"+
		"\u00b4\7d\2\2\u00b4\u00b5\7g\2\2\u00b5\u00b6\7n\2\2\u00b6(\3\2\2\2\u00b7"+
		"\u00b8\7k\2\2\u00b8\u00b9\7p\2\2\u00b9\u00ba\7v\2\2\u00ba*\3\2\2\2\u00bb"+
		"\u00bc\7f\2\2\u00bc\u00bd\7q\2\2\u00bd\u00be\7w\2\2\u00be\u00bf\7d\2\2"+
		"\u00bf\u00c0\7n\2\2\u00c0\u00c1\7g\2\2\u00c1,\3\2\2\2\u00c2\u00c3\7h\2"+
		"\2\u00c3\u00c4\7n\2\2\u00c4\u00c5\7q\2\2\u00c5\u00c6\7c\2\2\u00c6\u00c7"+
		"\7v\2\2\u00c7.\3\2\2\2\u00c8\u00c9\7d\2\2\u00c9\u00ca\7q\2\2\u00ca\u00cb"+
		"\7q\2\2\u00cb\u00cc\7n\2\2\u00cc\u00cd\7g\2\2\u00cd\u00ce\7c\2\2\u00ce"+
		"\u00cf\7p\2\2\u00cf\60\3\2\2\2\u00d0\u00d1\7x\2\2\u00d1\u00d2\7q\2\2\u00d2"+
		"\u00d3\7k\2\2\u00d3\u00d4\7f\2\2\u00d4\62\3\2\2\2\u00d5\u00da\5]/\2\u00d6"+
		"\u00d9\5]/\2\u00d7\u00d9\5a\61\2\u00d8\u00d6\3\2\2\2\u00d8\u00d7\3\2\2"+
		"\2\u00d9\u00dc\3\2\2\2\u00da\u00d8\3\2\2\2\u00da\u00db\3\2\2\2\u00db\u00de"+
		"\3\2\2\2\u00dc\u00da\3\2\2\2\u00dd\u00df\7)\2\2\u00de\u00dd\3\2\2\2\u00de"+
		"\u00df\3\2\2\2\u00df\64\3\2\2\2\u00e0\u00e2\7/\2\2\u00e1\u00e0\3\2\2\2"+
		"\u00e1\u00e2\3\2\2\2\u00e2\u00e3\3\2\2\2\u00e3\u00e4\59\35\2\u00e4\u00e5"+
		"\7\60\2\2\u00e5\u00e7\59\35\2\u00e6\u00e8\5c\62\2\u00e7\u00e6\3\2\2\2"+
		"\u00e7\u00e8\3\2\2\2\u00e8\u00f4\3\2\2\2\u00e9\u00eb\7/\2\2\u00ea\u00e9"+
		"\3\2\2\2\u00ea\u00eb\3\2\2\2\u00eb\u00ec\3\2\2\2\u00ec\u00ed\59\35\2\u00ed"+
		"\u00ee\5c\62\2\u00ee\u00f4\3\2\2\2\u00ef\u00f1\7/\2\2\u00f0\u00ef\3\2"+
		"\2\2\u00f0\u00f1\3\2\2\2\u00f1\u00f2\3\2\2\2\u00f2\u00f4\59\35\2\u00f3"+
		"\u00e1\3\2\2\2\u00f3\u00ea\3\2\2\2\u00f3\u00f0\3\2\2\2\u00f4\66\3\2\2"+
		"\2\u00f5\u00f7\7/\2\2\u00f6\u00f5\3\2\2\2\u00f6\u00f7\3\2\2\2\u00f7\u00f8"+
		"\3\2\2\2\u00f8\u00f9\59\35\2\u00f9\u00fa\7\60\2\2\u00fa\u00fb\59\35\2"+
		"\u00fb8\3\2\2\2\u00fc\u00fe\5a\61\2\u00fd\u00fc\3\2\2\2\u00fe\u00ff\3"+
		"\2\2\2\u00ff\u00fd\3\2\2\2\u00ff\u0100\3\2\2\2\u0100:\3\2\2\2\u0101\u0106"+
		"\7$\2\2\u0102\u0105\5W,\2\u0103\u0105\n\2\2\2\u0104\u0102\3\2\2\2\u0104"+
		"\u0103\3\2\2\2\u0105\u0108\3\2\2\2\u0106\u0104\3\2\2\2\u0106\u0107\3\2"+
		"\2\2\u0107\u0109\3\2\2\2\u0108\u0106\3\2\2\2\u0109\u010a\7$\2\2\u010a"+
		"<\3\2\2\2\u010b\u010c\t\3\2\2\u010c>\3\2\2\2\u010d\u010e\7?\2\2\u010e"+
		"@\3\2\2\2\u010f\u0110\7}\2\2\u0110B\3\2\2\2\u0111\u0112\7\177\2\2\u0112"+
		"D\3\2\2\2\u0113\u0114\7]\2\2\u0114F\3\2\2\2\u0115\u0116\7_\2\2\u0116H"+
		"\3\2\2\2\u0117\u0118\7=\2\2\u0118J\3\2\2\2\u0119\u011a\7<\2\2\u011aL\3"+
		"\2\2\2\u011b\u011c\7\60\2\2\u011c\u011d\7\60\2\2\u011dN\3\2\2\2\u011e"+
		"\u011f\7,\2\2\u011fP\3\2\2\2\u0120\u0121\7\61\2\2\u0121R\3\2\2\2\u0122"+
		"\u0123\7-\2\2\u0123T\3\2\2\2\u0124\u0125\7/\2\2\u0125V\3\2\2\2\u0126\u0129"+
		"\7^\2\2\u0127\u012a\t\4\2\2\u0128\u012a\5Y-\2\u0129\u0127\3\2\2\2\u0129"+
		"\u0128\3\2\2\2\u012aX\3\2\2\2\u012b\u012c\7w\2\2\u012c\u012d\5[.\2\u012d"+
		"\u012e\5[.\2\u012e\u012f\5[.\2\u012f\u0130\5[.\2\u0130Z\3\2\2\2\u0131"+
		"\u0132\t\5\2\2\u0132\\\3\2\2\2\u0133\u0135\t\6\2\2\u0134\u0133\3\2\2\2"+
		"\u0135^\3\2\2\2\u0136\u0137\t\7\2\2\u0137`\3\2\2\2\u0138\u0139\t\b\2\2"+
		"\u0139b\3\2\2\2\u013a\u013c\t\t\2\2\u013b\u013d\t\n\2\2\u013c\u013b\3"+
		"\2\2\2\u013c\u013d\3\2\2\2\u013d\u013e\3\2\2\2\u013e\u013f\59\35\2\u013f"+
		"d\3\2\2\2\u0140\u0142\t\13\2\2\u0141\u0140\3\2\2\2\u0142\u0143\3\2\2\2"+
		"\u0143\u0141\3\2\2\2\u0143\u0144\3\2\2\2\u0144\u0145\3\2\2\2\u0145\u0146"+
		"\b\63\2\2\u0146f\3\2\2\2\u0147\u0148\7\61\2\2\u0148\u0149\7,\2\2\u0149"+
		"\u014d\3\2\2\2\u014a\u014c\13\2\2\2\u014b\u014a\3\2\2\2\u014c\u014f\3"+
		"\2\2\2\u014d\u014e\3\2\2\2\u014d\u014b\3\2\2\2\u014e\u0150\3\2\2\2\u014f"+
		"\u014d\3\2\2\2\u0150\u0151\7,\2\2\u0151\u0152\7\61\2\2\u0152\u0153\3\2"+
		"\2\2\u0153\u0154\b\64\2\2\u0154h\3\2\2\2\u0155\u0156\7\61\2\2\u0156\u0157"+
		"\7\61\2\2\u0157\u015b\3\2\2\2\u0158\u015a\13\2\2\2\u0159\u0158\3\2\2\2"+
		"\u015a\u015d\3\2\2\2\u015b\u015c\3\2\2\2\u015b\u0159\3\2\2\2\u015c\u015f"+
		"\3\2\2\2\u015d\u015b\3\2\2\2\u015e\u0160\7\17\2\2\u015f\u015e\3\2\2\2"+
		"\u015f\u0160\3\2\2\2\u0160\u0161\3\2\2\2\u0161\u0162\7\f\2\2\u0162\u0163"+
		"\3\2\2\2\u0163\u0164\b\65\2\2\u0164j\3\2\2\2\u0165\u0169\7%\2\2\u0166"+
		"\u0168\13\2\2\2\u0167\u0166\3\2\2\2\u0168\u016b\3\2\2\2\u0169\u016a\3"+
		"\2\2\2\u0169\u0167\3\2\2\2\u016a\u016d\3\2\2\2\u016b\u0169\3\2\2\2\u016c"+
		"\u016e\7\17\2\2\u016d\u016c\3\2\2\2\u016d\u016e\3\2\2\2\u016e\u016f\3"+
		"\2\2\2\u016f\u0170\7\f\2\2\u0170\u0171\3\2\2\2\u0171\u0172\b\66\2\2\u0172"+
		"l\3\2\2\2\30\2\u00d8\u00da\u00de\u00e1\u00e7\u00ea\u00f0\u00f3\u00f6\u00ff"+
		"\u0104\u0106\u0129\u0134\u013c\u0143\u014d\u015b\u015f\u0169\u016d\3\b"+
		"\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}