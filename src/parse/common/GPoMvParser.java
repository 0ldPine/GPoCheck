// Generated from GPoMv.g4 by ANTLR 4.4
package parse.common;
   
import java.util.*;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GPoMvParser extends Parser {
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
	public static final String[] tokenNames = {
		"<INVALID>", "'&'", "')'", "','", "'('", "'if'", "'<'", "'global'", "'!='", 
		"'>'", "'then'", "'else'", "'=='", "'|'", "'!'", "'Moudle'", "'End Moudle'", 
		"'init'", "'->'", "'Label'", "'int'", "'double'", "'float'", "'boolean'", 
		"'void'", "ID", "NUMBER", "FLOAT", "INT", "STRING", "BOOL", "'='", "'{'", 
		"'}'", "'['", "']'", "';'", "':'", "'..'", "'*'", "'/'", "'+'", "'-'", 
		"WS", "COMMENT", "LINE_COMMENT", "JING_COMMENT"
	};
	public static final int
		RULE_file = 0, RULE_moduleType = 1, RULE_moudle = 2, RULE_statement = 3, 
		RULE_block = 4, RULE_varDecl = 5, RULE_stateDefine = 6, RULE_varName = 7, 
		RULE_varStart = 8, RULE_varEnd = 9, RULE_varInit = 10, RULE_transferStat = 11, 
		RULE_transLable = 12, RULE_transferChildStatLeft = 13, RULE_transferChildStatRight = 14, 
		RULE_labelSet = 15, RULE_labelStat = 16, RULE_labelCondition = 17, RULE_ifStat = 18, 
		RULE_globalVarDecl = 19, RULE_varType = 20, RULE_expr = 21, RULE_exprList = 22;
	public static final String[] ruleNames = {
		"file", "moduleType", "moudle", "statement", "block", "varDecl", "stateDefine", 
		"varName", "varStart", "varEnd", "varInit", "transferStat", "transLable", 
		"transferChildStatLeft", "transferChildStatRight", "labelSet", "labelStat", 
		"labelCondition", "ifStat", "globalVarDecl", "varType", "expr", "exprList"
	};

	@Override
	public String getGrammarFileName() { return "GPoMv.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


	/**************************************************************/
	// Add by dc, only hints
	/** "memory" for our calculator; variable/value pairs go here */
	Map<String, Integer> memory = new HashMap<String, Integer>();

	int eval(int left, int op, int right) {
	    switch ( op ) {
	        case MUL : return left * right;
	        case DIV : return left / right;
	        case ADD : return left + right;
	        case SUB : return left - right;
	    }
	    return 0;
	}
	// new block

	/**************************************************************/

	public GPoMvParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class FileContext extends ParserRuleContext {
		public List<GlobalVarDeclContext> globalVarDecl() {
			return getRuleContexts(GlobalVarDeclContext.class);
		}
		public MoudleContext moudle(int i) {
			return getRuleContext(MoudleContext.class,i);
		}
		public GlobalVarDeclContext globalVarDecl(int i) {
			return getRuleContext(GlobalVarDeclContext.class,i);
		}
		public List<MoudleContext> moudle() {
			return getRuleContexts(MoudleContext.class);
		}
		public ModuleTypeContext moduleType() {
			return getRuleContext(ModuleTypeContext.class,0);
		}
		public FileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_file; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GPoMvListener ) ((GPoMvListener)listener).enterFile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GPoMvListener ) ((GPoMvListener)listener).exitFile(this);
		}
	}

	public final FileContext file() throws RecognitionException {
		FileContext _localctx = new FileContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_file);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(46); moduleType();
			setState(54); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(50);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__7) {
					{
					{
					setState(47); globalVarDecl();
					}
					}
					setState(52);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(53); moudle();
				}
				}
				setState(56); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__7 || _la==MODULE );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ModuleTypeContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(GPoMvParser.ID, 0); }
		public ModuleTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_moduleType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GPoMvListener ) ((GPoMvListener)listener).enterModuleType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GPoMvListener ) ((GPoMvListener)listener).exitModuleType(this);
		}
	}

	public final ModuleTypeContext moduleType() throws RecognitionException {
		ModuleTypeContext _localctx = new ModuleTypeContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_moduleType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(58); match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MoudleContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public TerminalNode MODULE() { return getToken(GPoMvParser.MODULE, 0); }
		public TerminalNode ENDMODULE() { return getToken(GPoMvParser.ENDMODULE, 0); }
		public TerminalNode ID() { return getToken(GPoMvParser.ID, 0); }
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public MoudleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_moudle; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GPoMvListener ) ((GPoMvListener)listener).enterMoudle(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GPoMvListener ) ((GPoMvListener)listener).exitMoudle(this);
		}
	}

	public final MoudleContext moudle() throws RecognitionException {
		MoudleContext _localctx = new MoudleContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_moudle);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(60); match(MODULE);
			setState(61); match(ID);
			setState(65);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__10) | (1L << T__9) | (1L << T__8) | (1L << T__0) | (1L << LABELS) | (1L << K_INT) | (1L << K_FLOAT) | (1L << K_BOOLEAN) | (1L << ID) | (1L << NUMBER) | (1L << BRACELEFT) | (1L << BRACKETLEFT) | (1L << SUB))) != 0)) {
				{
				{
				setState(62); statement();
				}
				}
				setState(67);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(68); match(ENDMODULE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public LabelStatContext labelStat() {
			return getRuleContext(LabelStatContext.class,0);
		}
		public StateDefineContext stateDefine() {
			return getRuleContext(StateDefineContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public LabelSetContext labelSet() {
			return getRuleContext(LabelSetContext.class,0);
		}
		public VarDeclContext varDecl() {
			return getRuleContext(VarDeclContext.class,0);
		}
		public IfStatContext ifStat() {
			return getRuleContext(IfStatContext.class,0);
		}
		public TransferStatContext transferStat() {
			return getRuleContext(TransferStatContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GPoMvListener ) ((GPoMvListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GPoMvListener ) ((GPoMvListener)listener).exitStatement(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_statement);
		try {
			setState(78);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(70); block();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(71); varDecl();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(72); stateDefine();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(73); transferStat();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(74); labelSet();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(75); labelStat();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(76); ifStat();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(77); expr(0);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GPoMvListener ) ((GPoMvListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GPoMvListener ) ((GPoMvListener)listener).exitBlock(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(80); match(BRACELEFT);
			setState(84);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__10) | (1L << T__9) | (1L << T__8) | (1L << T__0) | (1L << LABELS) | (1L << K_INT) | (1L << K_FLOAT) | (1L << K_BOOLEAN) | (1L << ID) | (1L << NUMBER) | (1L << BRACELEFT) | (1L << BRACKETLEFT) | (1L << SUB))) != 0)) {
				{
				{
				setState(81); statement();
				}
				}
				setState(86);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(87); match(BRACERIGHT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VarDeclContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode ID() { return getToken(GPoMvParser.ID, 0); }
		public VarTypeContext varType() {
			return getRuleContext(VarTypeContext.class,0);
		}
		public VarDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GPoMvListener ) ((GPoMvListener)listener).enterVarDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GPoMvListener ) ((GPoMvListener)listener).exitVarDecl(this);
		}
	}

	public final VarDeclContext varDecl() throws RecognitionException {
		VarDeclContext _localctx = new VarDeclContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_varDecl);
		try {
			setState(100);
			switch (_input.LA(1)) {
			case K_INT:
			case K_FLOAT:
			case K_BOOLEAN:
				enterOuterAlt(_localctx, 1);
				{
				setState(89); varType();
				setState(90); match(ID);
				setState(91); match(EQUAL);
				setState(92); expr(0);
				setState(93); match(SEMICONLON);
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(95); match(ID);
				setState(96); match(EQUAL);
				setState(97); expr(0);
				setState(98); match(SEMICONLON);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StateDefineContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public TerminalNode INIT() { return getToken(GPoMvParser.INIT, 0); }
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public VarNameContext varName() {
			return getRuleContext(VarNameContext.class,0);
		}
		public StateDefineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stateDefine; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GPoMvListener ) ((GPoMvListener)listener).enterStateDefine(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GPoMvListener ) ((GPoMvListener)listener).exitStateDefine(this);
		}
	}

	public final StateDefineContext stateDefine() throws RecognitionException {
		StateDefineContext _localctx = new StateDefineContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_stateDefine);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(102); varName();
			setState(103); match(COLON);
			setState(104); match(BRACKETLEFT);
			setState(105); expr(0);
			setState(106); match(DOTDOT);
			setState(107); expr(0);
			setState(108); match(BRACKETRIGHT);
			setState(111);
			_la = _input.LA(1);
			if (_la==INIT) {
				{
				setState(109); match(INIT);
				setState(110); expr(0);
				}
			}

			setState(113); match(SEMICONLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VarNameContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(GPoMvParser.ID, 0); }
		public VarNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GPoMvListener ) ((GPoMvListener)listener).enterVarName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GPoMvListener ) ((GPoMvListener)listener).exitVarName(this);
		}
	}

	public final VarNameContext varName() throws RecognitionException {
		VarNameContext _localctx = new VarNameContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_varName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(115); match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VarStartContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(GPoMvParser.INT, 0); }
		public VarStartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varStart; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GPoMvListener ) ((GPoMvListener)listener).enterVarStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GPoMvListener ) ((GPoMvListener)listener).exitVarStart(this);
		}
	}

	public final VarStartContext varStart() throws RecognitionException {
		VarStartContext _localctx = new VarStartContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_varStart);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(117); match(INT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VarEndContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(GPoMvParser.INT, 0); }
		public VarEndContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varEnd; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GPoMvListener ) ((GPoMvListener)listener).enterVarEnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GPoMvListener ) ((GPoMvListener)listener).exitVarEnd(this);
		}
	}

	public final VarEndContext varEnd() throws RecognitionException {
		VarEndContext _localctx = new VarEndContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_varEnd);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(119); match(INT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VarInitContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(GPoMvParser.INT, 0); }
		public VarInitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varInit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GPoMvListener ) ((GPoMvListener)listener).enterVarInit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GPoMvListener ) ((GPoMvListener)listener).exitVarInit(this);
		}
	}

	public final VarInitContext varInit() throws RecognitionException {
		VarInitContext _localctx = new VarInitContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_varInit);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(121); match(INT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TransferStatContext extends ParserRuleContext {
		public TransferChildStatLeftContext transferChildStatLeft() {
			return getRuleContext(TransferChildStatLeftContext.class,0);
		}
		public TransferChildStatRightContext transferChildStatRight() {
			return getRuleContext(TransferChildStatRightContext.class,0);
		}
		public TerminalNode TRANS() { return getToken(GPoMvParser.TRANS, 0); }
		public TransLableContext transLable() {
			return getRuleContext(TransLableContext.class,0);
		}
		public TransferStatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_transferStat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GPoMvListener ) ((GPoMvListener)listener).enterTransferStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GPoMvListener ) ((GPoMvListener)listener).exitTransferStat(this);
		}
	}

	public final TransferStatContext transferStat() throws RecognitionException {
		TransferStatContext _localctx = new TransferStatContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_transferStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(123); transLable();
			setState(124); transferChildStatLeft();
			setState(125); match(TRANS);
			setState(126); transferChildStatRight();
			setState(127); match(SEMICONLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TransLableContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(GPoMvParser.ID, 0); }
		public TransLableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_transLable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GPoMvListener ) ((GPoMvListener)listener).enterTransLable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GPoMvListener ) ((GPoMvListener)listener).exitTransLable(this);
		}
	}

	public final TransLableContext transLable() throws RecognitionException {
		TransLableContext _localctx = new TransLableContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_transLable);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(129); match(BRACKETLEFT);
			setState(131);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(130); match(ID);
				}
			}

			setState(133); match(BRACKETRIGHT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TransferChildStatLeftContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TransferChildStatLeftContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_transferChildStatLeft; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GPoMvListener ) ((GPoMvListener)listener).enterTransferChildStatLeft(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GPoMvListener ) ((GPoMvListener)listener).exitTransferChildStatLeft(this);
		}
	}

	public final TransferChildStatLeftContext transferChildStatLeft() throws RecognitionException {
		TransferChildStatLeftContext _localctx = new TransferChildStatLeftContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_transferChildStatLeft);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(135); expr(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TransferChildStatRightContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode NUMBER(int i) {
			return getToken(GPoMvParser.NUMBER, i);
		}
		public List<TerminalNode> NUMBER() { return getTokens(GPoMvParser.NUMBER); }
		public TransferChildStatRightContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_transferChildStatRight; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GPoMvListener ) ((GPoMvListener)listener).enterTransferChildStatRight(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GPoMvListener ) ((GPoMvListener)listener).exitTransferChildStatRight(this);
		}
	}

	public final TransferChildStatRightContext transferChildStatRight() throws RecognitionException {
		TransferChildStatRightContext _localctx = new TransferChildStatRightContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_transferChildStatRight);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(137); match(NUMBER);
			setState(139);
			_la = _input.LA(1);
			if (_la==COLON) {
				{
				setState(138); match(COLON);
				}
			}

			setState(141); expr(0);
			setState(148);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ADD) {
				{
				{
				setState(142); match(ADD);
				setState(143); match(NUMBER);
				setState(144); match(COLON);
				setState(145); expr(0);
				}
				}
				setState(150);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LabelSetContext extends ParserRuleContext {
		public ExprListContext exprList() {
			return getRuleContext(ExprListContext.class,0);
		}
		public TerminalNode LABELS() { return getToken(GPoMvParser.LABELS, 0); }
		public LabelSetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_labelSet; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GPoMvListener ) ((GPoMvListener)listener).enterLabelSet(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GPoMvListener ) ((GPoMvListener)listener).exitLabelSet(this);
		}
	}

	public final LabelSetContext labelSet() throws RecognitionException {
		LabelSetContext _localctx = new LabelSetContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_labelSet);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(151); match(LABELS);
			setState(152); match(COLON);
			setState(153); match(BRACKETLEFT);
			setState(154); exprList();
			setState(155); match(BRACKETRIGHT);
			setState(156); match(SEMICONLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LabelStatContext extends ParserRuleContext {
		public LabelConditionContext labelCondition() {
			return getRuleContext(LabelConditionContext.class,0);
		}
		public ExprListContext exprList() {
			return getRuleContext(ExprListContext.class,0);
		}
		public LabelStatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_labelStat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GPoMvListener ) ((GPoMvListener)listener).enterLabelStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GPoMvListener ) ((GPoMvListener)listener).exitLabelStat(this);
		}
	}

	public final LabelStatContext labelStat() throws RecognitionException {
		LabelStatContext _localctx = new LabelStatContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_labelStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(158); labelCondition();
			setState(159); exprList();
			setState(160); match(SEMICONLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LabelConditionContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public LabelConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_labelCondition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GPoMvListener ) ((GPoMvListener)listener).enterLabelCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GPoMvListener ) ((GPoMvListener)listener).exitLabelCondition(this);
		}
	}

	public final LabelConditionContext labelCondition() throws RecognitionException {
		LabelConditionContext _localctx = new LabelConditionContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_labelCondition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(162); match(T__8);
			setState(163); expr(0);
			setState(164); match(EQUAL);
			setState(165); expr(0);
			setState(166); match(T__5);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IfStatContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public IfStatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GPoMvListener ) ((GPoMvListener)listener).enterIfStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GPoMvListener ) ((GPoMvListener)listener).exitIfStat(this);
		}
	}

	public final IfStatContext ifStat() throws RecognitionException {
		IfStatContext _localctx = new IfStatContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_ifStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(168); match(T__9);
			setState(169); expr(0);
			setState(170); match(T__4);
			setState(171); statement();
			setState(174);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				{
				setState(172); match(T__3);
				setState(173); statement();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GlobalVarDeclContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode ID() { return getToken(GPoMvParser.ID, 0); }
		public VarTypeContext varType() {
			return getRuleContext(VarTypeContext.class,0);
		}
		public GlobalVarDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_globalVarDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GPoMvListener ) ((GPoMvListener)listener).enterGlobalVarDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GPoMvListener ) ((GPoMvListener)listener).exitGlobalVarDecl(this);
		}
	}

	public final GlobalVarDeclContext globalVarDecl() throws RecognitionException {
		GlobalVarDeclContext _localctx = new GlobalVarDeclContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_globalVarDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(176); match(T__7);
			setState(178);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << K_INT) | (1L << K_FLOAT) | (1L << K_BOOLEAN))) != 0)) {
				{
				setState(177); varType();
				}
			}

			setState(180); match(ID);
			setState(183);
			_la = _input.LA(1);
			if (_la==EQUAL) {
				{
				setState(181); match(EQUAL);
				setState(182); expr(0);
				}
			}

			setState(185); match(SEMICONLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VarTypeContext extends ParserRuleContext {
		public TerminalNode K_BOOLEAN() { return getToken(GPoMvParser.K_BOOLEAN, 0); }
		public TerminalNode K_INT() { return getToken(GPoMvParser.K_INT, 0); }
		public TerminalNode K_FLOAT() { return getToken(GPoMvParser.K_FLOAT, 0); }
		public VarTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GPoMvListener ) ((GPoMvListener)listener).enterVarType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GPoMvListener ) ((GPoMvListener)listener).exitVarType(this);
		}
	}

	public final VarTypeContext varType() throws RecognitionException {
		VarTypeContext _localctx = new VarTypeContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_varType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(187);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << K_INT) | (1L << K_FLOAT) | (1L << K_BOOLEAN))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public Token ID;
		public ExprListContext exprList() {
			return getRuleContext(ExprListContext.class,0);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public TerminalNode ID() { return getToken(GPoMvParser.ID, 0); }
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode NUMBER() { return getToken(GPoMvParser.NUMBER, 0); }
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GPoMvListener ) ((GPoMvListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GPoMvListener ) ((GPoMvListener)listener).exitExpr(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 42;
		enterRecursionRule(_localctx, 42, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(207);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				{
				setState(190); match(SUB);
				setState(191); expr(13);
				}
				break;
			case 2:
				{
				setState(192); match(T__0);
				setState(193); expr(12);
				}
				break;
			case 3:
				{
				setState(194); ((ExprContext)_localctx).ID = match(ID);
				setState(195); match(T__10);
				setState(197);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__10) | (1L << T__0) | (1L << ID) | (1L << NUMBER) | (1L << SUB))) != 0)) {
					{
					setState(196); exprList();
					}
				}

				setState(199); match(T__12);
				}
				break;
			case 4:
				{
				setState(200); match(T__10);
				setState(201); expr(0);
				setState(202); match(T__12);
				}
				break;
			case 5:
				{
				setState(204); ((ExprContext)_localctx).ID = match(ID);
				/*System.out.println($ID.text);*/
				}
				break;
			case 6:
				{
				setState(206); match(NUMBER);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(240);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(238);
					switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
					case 1:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(209);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(210); match(MUL);
						setState(211); expr(12);
						}
						break;
					case 2:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(212);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(213); match(ADD);
						setState(214); expr(11);
						}
						break;
					case 3:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(215);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(216); match(SUB);
						setState(217); expr(10);
						}
						break;
					case 4:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(218);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(219); match(T__2);
						setState(220); expr(9);
						}
						break;
					case 5:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(221);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(222); match(T__6);
						setState(223); expr(8);
						}
						break;
					case 6:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(224);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(225); match(EQUAL);
						setState(226); expr(7);
						}
						break;
					case 7:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(227);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(228); match(T__13);
						setState(229); expr(6);
						}
						break;
					case 8:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(230);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(231); match(T__1);
						setState(232); expr(5);
						}
						break;
					case 9:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(233);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(234); match(BRACKETLEFT);
						setState(235); expr(0);
						setState(236); match(BRACKETRIGHT);
						}
						break;
					}
					} 
				}
				setState(242);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ExprListContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ExprListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GPoMvListener ) ((GPoMvListener)listener).enterExprList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GPoMvListener ) ((GPoMvListener)listener).exitExprList(this);
		}
	}

	public final ExprListContext exprList() throws RecognitionException {
		ExprListContext _localctx = new ExprListContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_exprList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(243); expr(0);
			setState(248);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__11) {
				{
				{
				setState(244); match(T__11);
				setState(245); expr(0);
				}
				}
				setState(250);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 21: return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return precpred(_ctx, 11);
		case 1: return precpred(_ctx, 10);
		case 2: return precpred(_ctx, 9);
		case 3: return precpred(_ctx, 8);
		case 4: return precpred(_ctx, 7);
		case 5: return precpred(_ctx, 6);
		case 6: return precpred(_ctx, 5);
		case 7: return precpred(_ctx, 4);
		case 8: return precpred(_ctx, 14);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\60\u00fe\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\3\2\3\2\7"+
		"\2\63\n\2\f\2\16\2\66\13\2\3\2\6\29\n\2\r\2\16\2:\3\3\3\3\3\4\3\4\3\4"+
		"\7\4B\n\4\f\4\16\4E\13\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5Q"+
		"\n\5\3\6\3\6\7\6U\n\6\f\6\16\6X\13\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\5\7g\n\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\br\n"+
		"\b\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\16\3\16\5\16\u0086\n\16\3\16\3\16\3\17\3\17\3\20\3\20\5\20\u008e\n\20"+
		"\3\20\3\20\3\20\3\20\3\20\7\20\u0095\n\20\f\20\16\20\u0098\13\20\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\5\24\u00b1\n\24\3\25\3\25\5\25"+
		"\u00b5\n\25\3\25\3\25\3\25\5\25\u00ba\n\25\3\25\3\25\3\26\3\26\3\27\3"+
		"\27\3\27\3\27\3\27\3\27\3\27\3\27\5\27\u00c8\n\27\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\5\27\u00d2\n\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\7\27\u00f1\n\27\f\27\16\27\u00f4"+
		"\13\27\3\30\3\30\3\30\7\30\u00f9\n\30\f\30\16\30\u00fc\13\30\3\30\2\3"+
		",\31\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\2\3\4\2\26\26\30"+
		"\31\u0109\2\60\3\2\2\2\4<\3\2\2\2\6>\3\2\2\2\bP\3\2\2\2\nR\3\2\2\2\ff"+
		"\3\2\2\2\16h\3\2\2\2\20u\3\2\2\2\22w\3\2\2\2\24y\3\2\2\2\26{\3\2\2\2\30"+
		"}\3\2\2\2\32\u0083\3\2\2\2\34\u0089\3\2\2\2\36\u008b\3\2\2\2 \u0099\3"+
		"\2\2\2\"\u00a0\3\2\2\2$\u00a4\3\2\2\2&\u00aa\3\2\2\2(\u00b2\3\2\2\2*\u00bd"+
		"\3\2\2\2,\u00d1\3\2\2\2.\u00f5\3\2\2\2\608\5\4\3\2\61\63\5(\25\2\62\61"+
		"\3\2\2\2\63\66\3\2\2\2\64\62\3\2\2\2\64\65\3\2\2\2\65\67\3\2\2\2\66\64"+
		"\3\2\2\2\679\5\6\4\28\64\3\2\2\29:\3\2\2\2:8\3\2\2\2:;\3\2\2\2;\3\3\2"+
		"\2\2<=\7\33\2\2=\5\3\2\2\2>?\7\21\2\2?C\7\33\2\2@B\5\b\5\2A@\3\2\2\2B"+
		"E\3\2\2\2CA\3\2\2\2CD\3\2\2\2DF\3\2\2\2EC\3\2\2\2FG\7\22\2\2G\7\3\2\2"+
		"\2HQ\5\n\6\2IQ\5\f\7\2JQ\5\16\b\2KQ\5\30\r\2LQ\5 \21\2MQ\5\"\22\2NQ\5"+
		"&\24\2OQ\5,\27\2PH\3\2\2\2PI\3\2\2\2PJ\3\2\2\2PK\3\2\2\2PL\3\2\2\2PM\3"+
		"\2\2\2PN\3\2\2\2PO\3\2\2\2Q\t\3\2\2\2RV\7\"\2\2SU\5\b\5\2TS\3\2\2\2UX"+
		"\3\2\2\2VT\3\2\2\2VW\3\2\2\2WY\3\2\2\2XV\3\2\2\2YZ\7#\2\2Z\13\3\2\2\2"+
		"[\\\5*\26\2\\]\7\33\2\2]^\7!\2\2^_\5,\27\2_`\7&\2\2`g\3\2\2\2ab\7\33\2"+
		"\2bc\7!\2\2cd\5,\27\2de\7&\2\2eg\3\2\2\2f[\3\2\2\2fa\3\2\2\2g\r\3\2\2"+
		"\2hi\5\20\t\2ij\7\'\2\2jk\7$\2\2kl\5,\27\2lm\7(\2\2mn\5,\27\2nq\7%\2\2"+
		"op\7\23\2\2pr\5,\27\2qo\3\2\2\2qr\3\2\2\2rs\3\2\2\2st\7&\2\2t\17\3\2\2"+
		"\2uv\7\33\2\2v\21\3\2\2\2wx\7\36\2\2x\23\3\2\2\2yz\7\36\2\2z\25\3\2\2"+
		"\2{|\7\36\2\2|\27\3\2\2\2}~\5\32\16\2~\177\5\34\17\2\177\u0080\7\24\2"+
		"\2\u0080\u0081\5\36\20\2\u0081\u0082\7&\2\2\u0082\31\3\2\2\2\u0083\u0085"+
		"\7$\2\2\u0084\u0086\7\33\2\2\u0085\u0084\3\2\2\2\u0085\u0086\3\2\2\2\u0086"+
		"\u0087\3\2\2\2\u0087\u0088\7%\2\2\u0088\33\3\2\2\2\u0089\u008a\5,\27\2"+
		"\u008a\35\3\2\2\2\u008b\u008d\7\34\2\2\u008c\u008e\7\'\2\2\u008d\u008c"+
		"\3\2\2\2\u008d\u008e\3\2\2\2\u008e\u008f\3\2\2\2\u008f\u0096\5,\27\2\u0090"+
		"\u0091\7+\2\2\u0091\u0092\7\34\2\2\u0092\u0093\7\'\2\2\u0093\u0095\5,"+
		"\27\2\u0094\u0090\3\2\2\2\u0095\u0098\3\2\2\2\u0096\u0094\3\2\2\2\u0096"+
		"\u0097\3\2\2\2\u0097\37\3\2\2\2\u0098\u0096\3\2\2\2\u0099\u009a\7\25\2"+
		"\2\u009a\u009b\7\'\2\2\u009b\u009c\7$\2\2\u009c\u009d\5.\30\2\u009d\u009e"+
		"\7%\2\2\u009e\u009f\7&\2\2\u009f!\3\2\2\2\u00a0\u00a1\5$\23\2\u00a1\u00a2"+
		"\5.\30\2\u00a2\u00a3\7&\2\2\u00a3#\3\2\2\2\u00a4\u00a5\7\b\2\2\u00a5\u00a6"+
		"\5,\27\2\u00a6\u00a7\7!\2\2\u00a7\u00a8\5,\27\2\u00a8\u00a9\7\13\2\2\u00a9"+
		"%\3\2\2\2\u00aa\u00ab\7\7\2\2\u00ab\u00ac\5,\27\2\u00ac\u00ad\7\f\2\2"+
		"\u00ad\u00b0\5\b\5\2\u00ae\u00af\7\r\2\2\u00af\u00b1\5\b\5\2\u00b0\u00ae"+
		"\3\2\2\2\u00b0\u00b1\3\2\2\2\u00b1\'\3\2\2\2\u00b2\u00b4\7\t\2\2\u00b3"+
		"\u00b5\5*\26\2\u00b4\u00b3\3\2\2\2\u00b4\u00b5\3\2\2\2\u00b5\u00b6\3\2"+
		"\2\2\u00b6\u00b9\7\33\2\2\u00b7\u00b8\7!\2\2\u00b8\u00ba\5,\27\2\u00b9"+
		"\u00b7\3\2\2\2\u00b9\u00ba\3\2\2\2\u00ba\u00bb\3\2\2\2\u00bb\u00bc\7&"+
		"\2\2\u00bc)\3\2\2\2\u00bd\u00be\t\2\2\2\u00be+\3\2\2\2\u00bf\u00c0\b\27"+
		"\1\2\u00c0\u00c1\7,\2\2\u00c1\u00d2\5,\27\17\u00c2\u00c3\7\20\2\2\u00c3"+
		"\u00d2\5,\27\16\u00c4\u00c5\7\33\2\2\u00c5\u00c7\7\6\2\2\u00c6\u00c8\5"+
		".\30\2\u00c7\u00c6\3\2\2\2\u00c7\u00c8\3\2\2\2\u00c8\u00c9\3\2\2\2\u00c9"+
		"\u00d2\7\4\2\2\u00ca\u00cb\7\6\2\2\u00cb\u00cc\5,\27\2\u00cc\u00cd\7\4"+
		"\2\2\u00cd\u00d2\3\2\2\2\u00ce\u00cf\7\33\2\2\u00cf\u00d2\b\27\1\2\u00d0"+
		"\u00d2\7\34\2\2\u00d1\u00bf\3\2\2\2\u00d1\u00c2\3\2\2\2\u00d1\u00c4\3"+
		"\2\2\2\u00d1\u00ca\3\2\2\2\u00d1\u00ce\3\2\2\2\u00d1\u00d0\3\2\2\2\u00d2"+
		"\u00f2\3\2\2\2\u00d3\u00d4\f\r\2\2\u00d4\u00d5\7)\2\2\u00d5\u00f1\5,\27"+
		"\16\u00d6\u00d7\f\f\2\2\u00d7\u00d8\7+\2\2\u00d8\u00f1\5,\27\r\u00d9\u00da"+
		"\f\13\2\2\u00da\u00db\7,\2\2\u00db\u00f1\5,\27\f\u00dc\u00dd\f\n\2\2\u00dd"+
		"\u00de\7\16\2\2\u00de\u00f1\5,\27\13\u00df\u00e0\f\t\2\2\u00e0\u00e1\7"+
		"\n\2\2\u00e1\u00f1\5,\27\n\u00e2\u00e3\f\b\2\2\u00e3\u00e4\7!\2\2\u00e4"+
		"\u00f1\5,\27\t\u00e5\u00e6\f\7\2\2\u00e6\u00e7\7\3\2\2\u00e7\u00f1\5,"+
		"\27\b\u00e8\u00e9\f\6\2\2\u00e9\u00ea\7\17\2\2\u00ea\u00f1\5,\27\7\u00eb"+
		"\u00ec\f\20\2\2\u00ec\u00ed\7$\2\2\u00ed\u00ee\5,\27\2\u00ee\u00ef\7%"+
		"\2\2\u00ef\u00f1\3\2\2\2\u00f0\u00d3\3\2\2\2\u00f0\u00d6\3\2\2\2\u00f0"+
		"\u00d9\3\2\2\2\u00f0\u00dc\3\2\2\2\u00f0\u00df\3\2\2\2\u00f0\u00e2\3\2"+
		"\2\2\u00f0\u00e5\3\2\2\2\u00f0\u00e8\3\2\2\2\u00f0\u00eb\3\2\2\2\u00f1"+
		"\u00f4\3\2\2\2\u00f2\u00f0\3\2\2\2\u00f2\u00f3\3\2\2\2\u00f3-\3\2\2\2"+
		"\u00f4\u00f2\3\2\2\2\u00f5\u00fa\5,\27\2\u00f6\u00f7\7\5\2\2\u00f7\u00f9"+
		"\5,\27\2\u00f8\u00f6\3\2\2\2\u00f9\u00fc\3\2\2\2\u00fa\u00f8\3\2\2\2\u00fa"+
		"\u00fb\3\2\2\2\u00fb/\3\2\2\2\u00fc\u00fa\3\2\2\2\24\64:CPVfq\u0085\u008d"+
		"\u0096\u00b0\u00b4\u00b9\u00c7\u00d1\u00f0\u00f2\u00fa";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}