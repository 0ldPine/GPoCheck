// Generated from GPoProp.g4 by ANTLR 4.4
package parse.common;
   


import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GPoPropParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		PROP_PO=1, PROP_GPO=2, POCTL_NEXT=3, POCTL_UNTIL=4, POCTL_EVENTUALLY=5, 
		POCTL_ALWAYS=6, POCTL_AND=7, POCTL_OR=8, POCTL_NEGATON=9, POCTL_TRUE=10, 
		K_INT=11, K_DOUBLE=12, K_FLOAT=13, K_BOOLEAN=14, K_VOID=15, ID=16, NUMBER=17, 
		FLOAT=18, INT=19, STRING=20, BOOL=21, EQUAL=22, GREATER=23, GREATEREQUAL=24, 
		LESSER=25, LESSEREQUAL=26, BRACELEFT=27, BRACERIGHT=28, BRACKETLEFT=29, 
		BRACKETRIGHT=30, PARENLEFT=31, PARENRIGHT=32, SEMICONLON=33, COLON=34, 
		DOTDOT=35, MUL=36, DIV=37, ADD=38, SUB=39, WS=40, COMMENT=41, LINE_COMMENT=42, 
		JING_COMMENT=43;
	public static final String[] tokenNames = {
		"<INVALID>", "'Po'", "'GPo'", "'X'", "'U'", "'F'", "'G'", "'&'", "'|'", 
		"'N'", "'true'", "'int'", "'double'", "'float'", "'boolean'", "'void'", 
		"ID", "NUMBER", "FLOAT", "INT", "STRING", "BOOL", "'=='", "'>'", "'>='", 
		"'<'", "'<='", "'{'", "'}'", "'['", "']'", "'('", "')'", "';'", "':'", 
		"'..'", "'*'", "'/'", "'+'", "'-'", "WS", "COMMENT", "LINE_COMMENT", "JING_COMMENT"
	};
	public static final int
		RULE_file = 0, RULE_properties = 1, RULE_pathFormulae = 2, RULE_nextChildProp = 3, 
		RULE_untilChildProp = 4, RULE_eventuallyProp = 5, RULE_alwaysProp = 6, 
		RULE_stateFormulae = 7, RULE_poctl_true = 8, RULE_andProp = 9, RULE_orProp = 10, 
		RULE_negationProp = 11, RULE_poProp = 12, RULE_expr = 13, RULE_propertyCondition = 14, 
		RULE_conditionOperate = 15, RULE_conditionValue = 16;
	public static final String[] ruleNames = {
		"file", "properties", "pathFormulae", "nextChildProp", "untilChildProp", 
		"eventuallyProp", "alwaysProp", "stateFormulae", "poctl_true", "andProp", 
		"orProp", "negationProp", "poProp", "expr", "propertyCondition", "conditionOperate", 
		"conditionValue"
	};

	@Override
	public String getGrammarFileName() { return "GPoProp.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }




	public GPoPropParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class FileContext extends ParserRuleContext {
		public PropertiesContext properties(int i) {
			return getRuleContext(PropertiesContext.class,i);
		}
		public List<PropertiesContext> properties() {
			return getRuleContexts(PropertiesContext.class);
		}
		public FileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_file; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GPoPropListener ) ((GPoPropListener)listener).enterFile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GPoPropListener ) ((GPoPropListener)listener).exitFile(this);
		}
	}

	public final FileContext file() throws RecognitionException {
		FileContext _localctx = new FileContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_file);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(35); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(34); properties();
				}
				}
				setState(37); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PROP_PO) | (1L << POCTL_NEGATON) | (1L << POCTL_TRUE) | (1L << ID) | (1L << PARENLEFT))) != 0) );
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

	public static class PropertiesContext extends ParserRuleContext {
		public PropertyConditionContext propertyCondition() {
			return getRuleContext(PropertyConditionContext.class,0);
		}
		public StateFormulaeContext stateFormulae() {
			return getRuleContext(StateFormulaeContext.class,0);
		}
		public PropertiesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_properties; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GPoPropListener ) ((GPoPropListener)listener).enterProperties(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GPoPropListener ) ((GPoPropListener)listener).exitProperties(this);
		}
	}

	public final PropertiesContext properties() throws RecognitionException {
		PropertiesContext _localctx = new PropertiesContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_properties);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(39); stateFormulae();
			setState(41);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EQUAL) | (1L << GREATER) | (1L << GREATEREQUAL) | (1L << LESSER) | (1L << LESSEREQUAL))) != 0)) {
				{
				setState(40); propertyCondition();
				}
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

	public static class PathFormulaeContext extends ParserRuleContext {
		public UntilChildPropContext untilChildProp() {
			return getRuleContext(UntilChildPropContext.class,0);
		}
		public EventuallyPropContext eventuallyProp() {
			return getRuleContext(EventuallyPropContext.class,0);
		}
		public NextChildPropContext nextChildProp() {
			return getRuleContext(NextChildPropContext.class,0);
		}
		public AlwaysPropContext alwaysProp() {
			return getRuleContext(AlwaysPropContext.class,0);
		}
		public PathFormulaeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pathFormulae; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GPoPropListener ) ((GPoPropListener)listener).enterPathFormulae(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GPoPropListener ) ((GPoPropListener)listener).exitPathFormulae(this);
		}
	}

	public final PathFormulaeContext pathFormulae() throws RecognitionException {
		PathFormulaeContext _localctx = new PathFormulaeContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_pathFormulae);
		try {
			setState(47);
			switch (_input.LA(1)) {
			case POCTL_NEXT:
				enterOuterAlt(_localctx, 1);
				{
				setState(43); nextChildProp();
				}
				break;
			case PROP_PO:
			case POCTL_NEGATON:
			case POCTL_TRUE:
			case ID:
			case PARENLEFT:
				enterOuterAlt(_localctx, 2);
				{
				setState(44); untilChildProp();
				}
				break;
			case POCTL_EVENTUALLY:
				enterOuterAlt(_localctx, 3);
				{
				setState(45); eventuallyProp();
				}
				break;
			case POCTL_ALWAYS:
				enterOuterAlt(_localctx, 4);
				{
				setState(46); alwaysProp();
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

	public static class NextChildPropContext extends ParserRuleContext {
		public TerminalNode POCTL_NEXT() { return getToken(GPoPropParser.POCTL_NEXT, 0); }
		public StateFormulaeContext stateFormulae() {
			return getRuleContext(StateFormulaeContext.class,0);
		}
		public NextChildPropContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nextChildProp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GPoPropListener ) ((GPoPropListener)listener).enterNextChildProp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GPoPropListener ) ((GPoPropListener)listener).exitNextChildProp(this);
		}
	}

	public final NextChildPropContext nextChildProp() throws RecognitionException {
		NextChildPropContext _localctx = new NextChildPropContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_nextChildProp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(49); match(POCTL_NEXT);
			setState(50); stateFormulae();
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

	public static class UntilChildPropContext extends ParserRuleContext {
		public PropertyConditionContext propertyCondition() {
			return getRuleContext(PropertyConditionContext.class,0);
		}
		public TerminalNode POCTL_UNTIL() { return getToken(GPoPropParser.POCTL_UNTIL, 0); }
		public List<StateFormulaeContext> stateFormulae() {
			return getRuleContexts(StateFormulaeContext.class);
		}
		public StateFormulaeContext stateFormulae(int i) {
			return getRuleContext(StateFormulaeContext.class,i);
		}
		public UntilChildPropContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_untilChildProp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GPoPropListener ) ((GPoPropListener)listener).enterUntilChildProp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GPoPropListener ) ((GPoPropListener)listener).exitUntilChildProp(this);
		}
	}

	public final UntilChildPropContext untilChildProp() throws RecognitionException {
		UntilChildPropContext _localctx = new UntilChildPropContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_untilChildProp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(52); stateFormulae();
			setState(53); match(POCTL_UNTIL);
			setState(55);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EQUAL) | (1L << GREATER) | (1L << GREATEREQUAL) | (1L << LESSER) | (1L << LESSEREQUAL))) != 0)) {
				{
				setState(54); propertyCondition();
				}
			}

			setState(57); stateFormulae();
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

	public static class EventuallyPropContext extends ParserRuleContext {
		public TerminalNode POCTL_EVENTUALLY() { return getToken(GPoPropParser.POCTL_EVENTUALLY, 0); }
		public StateFormulaeContext stateFormulae() {
			return getRuleContext(StateFormulaeContext.class,0);
		}
		public EventuallyPropContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eventuallyProp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GPoPropListener ) ((GPoPropListener)listener).enterEventuallyProp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GPoPropListener ) ((GPoPropListener)listener).exitEventuallyProp(this);
		}
	}

	public final EventuallyPropContext eventuallyProp() throws RecognitionException {
		EventuallyPropContext _localctx = new EventuallyPropContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_eventuallyProp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(59); match(POCTL_EVENTUALLY);
			setState(60); stateFormulae();
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

	public static class AlwaysPropContext extends ParserRuleContext {
		public StateFormulaeContext stateFormulae() {
			return getRuleContext(StateFormulaeContext.class,0);
		}
		public TerminalNode POCTL_ALWAYS() { return getToken(GPoPropParser.POCTL_ALWAYS, 0); }
		public AlwaysPropContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_alwaysProp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GPoPropListener ) ((GPoPropListener)listener).enterAlwaysProp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GPoPropListener ) ((GPoPropListener)listener).exitAlwaysProp(this);
		}
	}

	public final AlwaysPropContext alwaysProp() throws RecognitionException {
		AlwaysPropContext _localctx = new AlwaysPropContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_alwaysProp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(62); match(POCTL_ALWAYS);
			setState(63); stateFormulae();
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

	public static class StateFormulaeContext extends ParserRuleContext {
		public NegationPropContext negationProp() {
			return getRuleContext(NegationPropContext.class,0);
		}
		public OrPropContext orProp() {
			return getRuleContext(OrPropContext.class,0);
		}
		public AndPropContext andProp() {
			return getRuleContext(AndPropContext.class,0);
		}
		public Poctl_trueContext poctl_true() {
			return getRuleContext(Poctl_trueContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public PoPropContext poProp() {
			return getRuleContext(PoPropContext.class,0);
		}
		public StateFormulaeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stateFormulae; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GPoPropListener ) ((GPoPropListener)listener).enterStateFormulae(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GPoPropListener ) ((GPoPropListener)listener).exitStateFormulae(this);
		}
	}

	public final StateFormulaeContext stateFormulae() throws RecognitionException {
		StateFormulaeContext _localctx = new StateFormulaeContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_stateFormulae);
		try {
			setState(71);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(65); poctl_true();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(66); expr();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(67); andProp();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(68); orProp();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(69); negationProp();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(70); poProp();
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

	public static class Poctl_trueContext extends ParserRuleContext {
		public TerminalNode POCTL_TRUE() { return getToken(GPoPropParser.POCTL_TRUE, 0); }
		public Poctl_trueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_poctl_true; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GPoPropListener ) ((GPoPropListener)listener).enterPoctl_true(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GPoPropListener ) ((GPoPropListener)listener).exitPoctl_true(this);
		}
	}

	public final Poctl_trueContext poctl_true() throws RecognitionException {
		Poctl_trueContext _localctx = new Poctl_trueContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_poctl_true);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(73); match(POCTL_TRUE);
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

	public static class AndPropContext extends ParserRuleContext {
		public List<TerminalNode> POCTL_AND() { return getTokens(GPoPropParser.POCTL_AND); }
		public TerminalNode PARENRIGHT() { return getToken(GPoPropParser.PARENRIGHT, 0); }
		public List<StateFormulaeContext> stateFormulae() {
			return getRuleContexts(StateFormulaeContext.class);
		}
		public TerminalNode POCTL_AND(int i) {
			return getToken(GPoPropParser.POCTL_AND, i);
		}
		public TerminalNode PARENLEFT() { return getToken(GPoPropParser.PARENLEFT, 0); }
		public StateFormulaeContext stateFormulae(int i) {
			return getRuleContext(StateFormulaeContext.class,i);
		}
		public AndPropContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_andProp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GPoPropListener ) ((GPoPropListener)listener).enterAndProp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GPoPropListener ) ((GPoPropListener)listener).exitAndProp(this);
		}
	}

	public final AndPropContext andProp() throws RecognitionException {
		AndPropContext _localctx = new AndPropContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_andProp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(75); match(PARENLEFT);
			setState(76); stateFormulae();
			setState(79); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(77); match(POCTL_AND);
				setState(78); stateFormulae();
				}
				}
				setState(81); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==POCTL_AND );
			setState(83); match(PARENRIGHT);
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

	public static class OrPropContext extends ParserRuleContext {
		public TerminalNode POCTL_OR(int i) {
			return getToken(GPoPropParser.POCTL_OR, i);
		}
		public TerminalNode PARENRIGHT() { return getToken(GPoPropParser.PARENRIGHT, 0); }
		public List<StateFormulaeContext> stateFormulae() {
			return getRuleContexts(StateFormulaeContext.class);
		}
		public TerminalNode PARENLEFT() { return getToken(GPoPropParser.PARENLEFT, 0); }
		public List<TerminalNode> POCTL_OR() { return getTokens(GPoPropParser.POCTL_OR); }
		public StateFormulaeContext stateFormulae(int i) {
			return getRuleContext(StateFormulaeContext.class,i);
		}
		public OrPropContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_orProp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GPoPropListener ) ((GPoPropListener)listener).enterOrProp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GPoPropListener ) ((GPoPropListener)listener).exitOrProp(this);
		}
	}

	public final OrPropContext orProp() throws RecognitionException {
		OrPropContext _localctx = new OrPropContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_orProp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(85); match(PARENLEFT);
			setState(86); stateFormulae();
			setState(89); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(87); match(POCTL_OR);
				setState(88); stateFormulae();
				}
				}
				setState(91); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==POCTL_OR );
			setState(93); match(PARENRIGHT);
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

	public static class NegationPropContext extends ParserRuleContext {
		public StateFormulaeContext stateFormulae() {
			return getRuleContext(StateFormulaeContext.class,0);
		}
		public TerminalNode POCTL_NEGATON() { return getToken(GPoPropParser.POCTL_NEGATON, 0); }
		public NegationPropContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_negationProp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GPoPropListener ) ((GPoPropListener)listener).enterNegationProp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GPoPropListener ) ((GPoPropListener)listener).exitNegationProp(this);
		}
	}

	public final NegationPropContext negationProp() throws RecognitionException {
		NegationPropContext _localctx = new NegationPropContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_negationProp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(95); match(POCTL_NEGATON);
			setState(96); stateFormulae();
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

	public static class PoPropContext extends ParserRuleContext {
		public TerminalNode PARENRIGHT() { return getToken(GPoPropParser.PARENRIGHT, 0); }
		public TerminalNode PROP_PO() { return getToken(GPoPropParser.PROP_PO, 0); }
		public TerminalNode PARENLEFT() { return getToken(GPoPropParser.PARENLEFT, 0); }
		public PathFormulaeContext pathFormulae() {
			return getRuleContext(PathFormulaeContext.class,0);
		}
		public PoPropContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_poProp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GPoPropListener ) ((GPoPropListener)listener).enterPoProp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GPoPropListener ) ((GPoPropListener)listener).exitPoProp(this);
		}
	}

	public final PoPropContext poProp() throws RecognitionException {
		PoPropContext _localctx = new PoPropContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_poProp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(98); match(PROP_PO);
			setState(99); match(PARENLEFT);
			setState(100); pathFormulae();
			setState(101); match(PARENRIGHT);
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
		public TerminalNode ID() { return getToken(GPoPropParser.ID, 0); }
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GPoPropListener ) ((GPoPropListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GPoPropListener ) ((GPoPropListener)listener).exitExpr(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(103); match(ID);
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

	public static class PropertyConditionContext extends ParserRuleContext {
		public ConditionValueContext conditionValue() {
			return getRuleContext(ConditionValueContext.class,0);
		}
		public ConditionOperateContext conditionOperate() {
			return getRuleContext(ConditionOperateContext.class,0);
		}
		public PropertyConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_propertyCondition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GPoPropListener ) ((GPoPropListener)listener).enterPropertyCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GPoPropListener ) ((GPoPropListener)listener).exitPropertyCondition(this);
		}
	}

	public final PropertyConditionContext propertyCondition() throws RecognitionException {
		PropertyConditionContext _localctx = new PropertyConditionContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_propertyCondition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(105); conditionOperate();
			setState(106); conditionValue();
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

	public static class ConditionOperateContext extends ParserRuleContext {
		public TerminalNode LESSEREQUAL() { return getToken(GPoPropParser.LESSEREQUAL, 0); }
		public TerminalNode GREATEREQUAL() { return getToken(GPoPropParser.GREATEREQUAL, 0); }
		public TerminalNode EQUAL() { return getToken(GPoPropParser.EQUAL, 0); }
		public TerminalNode LESSER() { return getToken(GPoPropParser.LESSER, 0); }
		public TerminalNode GREATER() { return getToken(GPoPropParser.GREATER, 0); }
		public ConditionOperateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conditionOperate; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GPoPropListener ) ((GPoPropListener)listener).enterConditionOperate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GPoPropListener ) ((GPoPropListener)listener).exitConditionOperate(this);
		}
	}

	public final ConditionOperateContext conditionOperate() throws RecognitionException {
		ConditionOperateContext _localctx = new ConditionOperateContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_conditionOperate);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(108);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EQUAL) | (1L << GREATER) | (1L << GREATEREQUAL) | (1L << LESSER) | (1L << LESSEREQUAL))) != 0)) ) {
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

	public static class ConditionValueContext extends ParserRuleContext {
		public TerminalNode NUMBER() { return getToken(GPoPropParser.NUMBER, 0); }
		public ConditionValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conditionValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GPoPropListener ) ((GPoPropListener)listener).enterConditionValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GPoPropListener ) ((GPoPropListener)listener).exitConditionValue(this);
		}
	}

	public final ConditionValueContext conditionValue() throws RecognitionException {
		ConditionValueContext _localctx = new ConditionValueContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_conditionValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(110); match(NUMBER);
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

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3-s\4\2\t\2\4\3\t\3"+
		"\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t\13\4\f"+
		"\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22\3\2\6\2"+
		"&\n\2\r\2\16\2\'\3\3\3\3\5\3,\n\3\3\4\3\4\3\4\3\4\5\4\62\n\4\3\5\3\5\3"+
		"\5\3\6\3\6\3\6\5\6:\n\6\3\6\3\6\3\7\3\7\3\7\3\b\3\b\3\b\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\5\tJ\n\t\3\n\3\n\3\13\3\13\3\13\3\13\6\13R\n\13\r\13\16\13"+
		"S\3\13\3\13\3\f\3\f\3\f\3\f\6\f\\\n\f\r\f\16\f]\3\f\3\f\3\r\3\r\3\r\3"+
		"\16\3\16\3\16\3\16\3\16\3\17\3\17\3\20\3\20\3\20\3\21\3\21\3\22\3\22\3"+
		"\22\2\2\23\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"\2\3\3\2\30\34n\2"+
		"%\3\2\2\2\4)\3\2\2\2\6\61\3\2\2\2\b\63\3\2\2\2\n\66\3\2\2\2\f=\3\2\2\2"+
		"\16@\3\2\2\2\20I\3\2\2\2\22K\3\2\2\2\24M\3\2\2\2\26W\3\2\2\2\30a\3\2\2"+
		"\2\32d\3\2\2\2\34i\3\2\2\2\36k\3\2\2\2 n\3\2\2\2\"p\3\2\2\2$&\5\4\3\2"+
		"%$\3\2\2\2&\'\3\2\2\2\'%\3\2\2\2\'(\3\2\2\2(\3\3\2\2\2)+\5\20\t\2*,\5"+
		"\36\20\2+*\3\2\2\2+,\3\2\2\2,\5\3\2\2\2-\62\5\b\5\2.\62\5\n\6\2/\62\5"+
		"\f\7\2\60\62\5\16\b\2\61-\3\2\2\2\61.\3\2\2\2\61/\3\2\2\2\61\60\3\2\2"+
		"\2\62\7\3\2\2\2\63\64\7\5\2\2\64\65\5\20\t\2\65\t\3\2\2\2\66\67\5\20\t"+
		"\2\679\7\6\2\28:\5\36\20\298\3\2\2\29:\3\2\2\2:;\3\2\2\2;<\5\20\t\2<\13"+
		"\3\2\2\2=>\7\7\2\2>?\5\20\t\2?\r\3\2\2\2@A\7\b\2\2AB\5\20\t\2B\17\3\2"+
		"\2\2CJ\5\22\n\2DJ\5\34\17\2EJ\5\24\13\2FJ\5\26\f\2GJ\5\30\r\2HJ\5\32\16"+
		"\2IC\3\2\2\2ID\3\2\2\2IE\3\2\2\2IF\3\2\2\2IG\3\2\2\2IH\3\2\2\2J\21\3\2"+
		"\2\2KL\7\f\2\2L\23\3\2\2\2MN\7!\2\2NQ\5\20\t\2OP\7\t\2\2PR\5\20\t\2QO"+
		"\3\2\2\2RS\3\2\2\2SQ\3\2\2\2ST\3\2\2\2TU\3\2\2\2UV\7\"\2\2V\25\3\2\2\2"+
		"WX\7!\2\2X[\5\20\t\2YZ\7\n\2\2Z\\\5\20\t\2[Y\3\2\2\2\\]\3\2\2\2][\3\2"+
		"\2\2]^\3\2\2\2^_\3\2\2\2_`\7\"\2\2`\27\3\2\2\2ab\7\13\2\2bc\5\20\t\2c"+
		"\31\3\2\2\2de\7\3\2\2ef\7!\2\2fg\5\6\4\2gh\7\"\2\2h\33\3\2\2\2ij\7\22"+
		"\2\2j\35\3\2\2\2kl\5 \21\2lm\5\"\22\2m\37\3\2\2\2no\t\2\2\2o!\3\2\2\2"+
		"pq\7\23\2\2q#\3\2\2\2\t\'+\619IS]";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}