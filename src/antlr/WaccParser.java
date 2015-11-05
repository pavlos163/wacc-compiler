// Generated from ./WaccParser.g4 by ANTLR 4.4
package antlr;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class WaccParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		WHILE=17, DOUBLE_QUOTE=36, MOD=44, GREATER_OR_EQUAL=48, CHAR=26, DO=18, 
		NOT=37, AND=53, ORD=40, R_SQ=32, IF=13, FREE=8, SINGLE_QUOTE=35, GREATER=47, 
		THEN=14, NOT_EQUAL=52, COMMA=33, DONE=19, IS=4, PRINTLN=12, EQUAL=51, 
		BEGIN=3, LESS=49, RETURN=9, CHAR_LITER=58, IDENT=55, PLUS=45, PAIR=28, 
		COMMENT=62, NEWPAIR=20, INTEGER=56, EXIT=10, STRING_LITER=57, SECOND=23, 
		LESS_OR_EQUAL=50, NULL=61, NEGATIVE=38, ELSE=15, BOOL=25, WHITESPACE=63, 
		INT=24, SEMICOLON=2, MINUS=46, FILE=1, TRUE=59, MUL=42, PRINT=11, CHR=41, 
		FI=16, SKIP=6, READ=7, OR=54, L_SQ=31, ASSIGN=34, LEN=39, CALL=21, L_PAR=29, 
		DIV=43, END=5, FALSE=60, R_PAR=30, FIRST=22, STRING=27;
	public static final String[] tokenNames = {
		"<INVALID>", "FILE", "';'", "'begin'", "'is'", "'end'", "'skip'", "'read'", 
		"'free'", "'return'", "'exit'", "'print'", "'println'", "'if'", "'then'", 
		"'else'", "'fi'", "'while'", "'do'", "'done'", "'newpair'", "'call'", 
		"'fst'", "'snd'", "'int'", "'bool'", "'char'", "'string'", "'pair'", "'('", 
		"')'", "'['", "']'", "','", "'='", "'''", "'\"'", "'!'", "NEGATIVE", "'len'", 
		"'ord'", "'chr'", "'*'", "'/'", "'%'", "'+'", "MINUS", "'>'", "'>='", 
		"'<'", "'<='", "'=='", "'!='", "'&&'", "'||'", "IDENT", "INTEGER", "STRING_LITER", 
		"CHAR_LITER", "'true'", "'false'", "'null'", "COMMENT", "WHITESPACE"
	};
	public static final int
		RULE_program = 0, RULE_func = 1, RULE_paramList = 2, RULE_param = 3, RULE_stat = 4, 
		RULE_assignLHS = 5, RULE_assignRHS = 6, RULE_argList = 7, RULE_pairElem = 8, 
		RULE_type = 9, RULE_baseType = 10, RULE_arrayType = 11, RULE_pairType = 12, 
		RULE_pairElemType = 13, RULE_expr = 14, RULE_unaryOper = 15, RULE_binaryOper = 16, 
		RULE_arrayElem = 17, RULE_intSign = 18, RULE_intLiter = 19, RULE_boolLiter = 20, 
		RULE_arrayLiter = 21, RULE_pairLiter = 22;
	public static final String[] ruleNames = {
		"program", "func", "paramList", "param", "stat", "assignLHS", "assignRHS", 
		"argList", "pairElem", "type", "baseType", "arrayType", "pairType", "pairElemType", 
		"expr", "unaryOper", "binaryOper", "arrayElem", "intSign", "intLiter", 
		"boolLiter", "arrayLiter", "pairLiter"
	};

	@Override
	public String getGrammarFileName() { return "WaccParser.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public WaccParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(WaccParser.EOF, 0); }
		public List<FuncContext> func() {
			return getRuleContexts(FuncContext.class);
		}
		public StatContext stat() {
			return getRuleContext(StatContext.class,0);
		}
		public FuncContext func(int i) {
			return getRuleContext(FuncContext.class,i);
		}
		public TerminalNode BEGIN() { return getToken(WaccParser.BEGIN, 0); }
		public TerminalNode END() { return getToken(WaccParser.END, 0); }
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(46); match(BEGIN);
			setState(50);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(47); func();
					}
					} 
				}
				setState(52);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			setState(53); stat(0);
			setState(54); match(END);
			setState(55); match(EOF);
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

	public static class FuncContext extends ParserRuleContext {
		public ParamListContext paramList() {
			return getRuleContext(ParamListContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public StatContext stat() {
			return getRuleContext(StatContext.class,0);
		}
		public TerminalNode IS() { return getToken(WaccParser.IS, 0); }
		public TerminalNode R_PAR() { return getToken(WaccParser.R_PAR, 0); }
		public TerminalNode L_PAR() { return getToken(WaccParser.L_PAR, 0); }
		public TerminalNode IDENT() { return getToken(WaccParser.IDENT, 0); }
		public TerminalNode END() { return getToken(WaccParser.END, 0); }
		public FuncContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_func; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitFunc(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncContext func() throws RecognitionException {
		FuncContext _localctx = new FuncContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_func);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(57); type(0);
			setState(58); match(IDENT);
			setState(59); match(L_PAR);
			setState(60); paramList();
			setState(61); match(R_PAR);
			setState(62); match(IS);
			setState(63); stat(0);
			setState(64); match(END);
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

	public static class ParamListContext extends ParserRuleContext {
		public List<ParamContext> param() {
			return getRuleContexts(ParamContext.class);
		}
		public List<TerminalNode> COMMA() { return getTokens(WaccParser.COMMA); }
		public ParamContext param(int i) {
			return getRuleContext(ParamContext.class,i);
		}
		public TerminalNode COMMA(int i) {
			return getToken(WaccParser.COMMA, i);
		}
		public ParamListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_paramList; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitParamList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParamListContext paramList() throws RecognitionException {
		ParamListContext _localctx = new ParamListContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_paramList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(74);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << BOOL) | (1L << CHAR) | (1L << STRING) | (1L << PAIR))) != 0)) {
				{
				setState(66); param();
				setState(71);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(67); match(COMMA);
					setState(68); param();
					}
					}
					setState(73);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
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

	public static class ParamContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode IDENT() { return getToken(WaccParser.IDENT, 0); }
		public ParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitParam(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParamContext param() throws RecognitionException {
		ParamContext _localctx = new ParamContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_param);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(76); type(0);
			setState(77); match(IDENT);
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

	public static class StatContext extends ParserRuleContext {
		public TerminalNode THEN() { return getToken(WaccParser.THEN, 0); }
		public TerminalNode PRINT() { return getToken(WaccParser.PRINT, 0); }
		public TerminalNode SEMICOLON() { return getToken(WaccParser.SEMICOLON, 0); }
		public TerminalNode FI() { return getToken(WaccParser.FI, 0); }
		public TerminalNode DONE() { return getToken(WaccParser.DONE, 0); }
		public TerminalNode SKIP() { return getToken(WaccParser.SKIP, 0); }
		public TerminalNode WHILE() { return getToken(WaccParser.WHILE, 0); }
		public TerminalNode IF() { return getToken(WaccParser.IF, 0); }
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public TerminalNode DO() { return getToken(WaccParser.DO, 0); }
		public TerminalNode ELSE() { return getToken(WaccParser.ELSE, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(WaccParser.ASSIGN, 0); }
		public TerminalNode READ() { return getToken(WaccParser.READ, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode RETURN() { return getToken(WaccParser.RETURN, 0); }
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public AssignLHSContext assignLHS() {
			return getRuleContext(AssignLHSContext.class,0);
		}
		public TerminalNode FREE() { return getToken(WaccParser.FREE, 0); }
		public AssignRHSContext assignRHS() {
			return getRuleContext(AssignRHSContext.class,0);
		}
		public TerminalNode EXIT() { return getToken(WaccParser.EXIT, 0); }
		public TerminalNode BEGIN() { return getToken(WaccParser.BEGIN, 0); }
		public TerminalNode IDENT() { return getToken(WaccParser.IDENT, 0); }
		public TerminalNode END() { return getToken(WaccParser.END, 0); }
		public TerminalNode PRINTLN() { return getToken(WaccParser.PRINTLN, 0); }
		public StatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stat; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitStat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatContext stat() throws RecognitionException {
		return stat(0);
	}

	private StatContext stat(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		StatContext _localctx = new StatContext(_ctx, _parentState);
		StatContext _prevctx = _localctx;
		int _startState = 8;
		enterRecursionRule(_localctx, 8, RULE_stat, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(126);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				{
				setState(80); match(SKIP);
				}
				break;
			case 2:
				{
				setState(81); type(0);
				setState(82); match(IDENT);
				setState(83); match(ASSIGN);
				setState(84); assignRHS();
				}
				break;
			case 3:
				{
				setState(86); assignLHS();
				setState(87); match(ASSIGN);
				setState(88); assignRHS();
				}
				break;
			case 4:
				{
				setState(90); match(READ);
				setState(91); assignLHS();
				}
				break;
			case 5:
				{
				setState(92); match(FREE);
				setState(93); expr(0);
				}
				break;
			case 6:
				{
				setState(94); match(RETURN);
				setState(95); expr(0);
				}
				break;
			case 7:
				{
				setState(96); match(EXIT);
				setState(97); expr(0);
				}
				break;
			case 8:
				{
				setState(98); match(PRINT);
				setState(99); expr(0);
				}
				break;
			case 9:
				{
				setState(100); match(PRINTLN);
				setState(101); expr(0);
				}
				break;
			case 10:
				{
				setState(102); match(IF);
				setState(103); expr(0);
				setState(104); match(THEN);
				setState(105); stat(0);
				setState(106); match(FI);
				}
				break;
			case 11:
				{
				setState(108); match(IF);
				setState(109); expr(0);
				setState(110); match(THEN);
				setState(111); stat(0);
				setState(112); match(ELSE);
				setState(113); stat(0);
				setState(114); match(FI);
				}
				break;
			case 12:
				{
				setState(116); match(WHILE);
				setState(117); expr(0);
				setState(118); match(DO);
				setState(119); stat(0);
				setState(120); match(DONE);
				}
				break;
			case 13:
				{
				setState(122); match(BEGIN);
				setState(123); stat(0);
				setState(124); match(END);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(133);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new StatContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_stat);
					setState(128);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(129); match(SEMICOLON);
					setState(130); stat(2);
					}
					} 
				}
				setState(135);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
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

	public static class AssignLHSContext extends ParserRuleContext {
		public PairElemContext pairElem() {
			return getRuleContext(PairElemContext.class,0);
		}
		public ArrayElemContext arrayElem() {
			return getRuleContext(ArrayElemContext.class,0);
		}
		public TerminalNode IDENT() { return getToken(WaccParser.IDENT, 0); }
		public AssignLHSContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignLHS; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitAssignLHS(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignLHSContext assignLHS() throws RecognitionException {
		AssignLHSContext _localctx = new AssignLHSContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_assignLHS);
		try {
			setState(139);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(136); match(IDENT);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(137); arrayElem();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(138); pairElem();
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

	public static class AssignRHSContext extends ParserRuleContext {
		public TerminalNode CALL() { return getToken(WaccParser.CALL, 0); }
		public ArrayLiterContext arrayLiter() {
			return getRuleContext(ArrayLiterContext.class,0);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public PairElemContext pairElem() {
			return getRuleContext(PairElemContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(WaccParser.COMMA, 0); }
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ArgListContext argList() {
			return getRuleContext(ArgListContext.class,0);
		}
		public TerminalNode NEWPAIR() { return getToken(WaccParser.NEWPAIR, 0); }
		public TerminalNode R_PAR() { return getToken(WaccParser.R_PAR, 0); }
		public TerminalNode L_PAR() { return getToken(WaccParser.L_PAR, 0); }
		public TerminalNode IDENT() { return getToken(WaccParser.IDENT, 0); }
		public AssignRHSContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignRHS; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitAssignRHS(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignRHSContext assignRHS() throws RecognitionException {
		AssignRHSContext _localctx = new AssignRHSContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_assignRHS);
		int _la;
		try {
			setState(158);
			switch (_input.LA(1)) {
			case L_PAR:
			case NOT:
			case NEGATIVE:
			case LEN:
			case ORD:
			case CHR:
			case IDENT:
			case INTEGER:
			case STRING_LITER:
			case CHAR_LITER:
			case TRUE:
			case FALSE:
			case NULL:
				enterOuterAlt(_localctx, 1);
				{
				setState(141); expr(0);
				}
				break;
			case L_SQ:
				enterOuterAlt(_localctx, 2);
				{
				setState(142); arrayLiter();
				}
				break;
			case NEWPAIR:
				enterOuterAlt(_localctx, 3);
				{
				setState(143); match(NEWPAIR);
				setState(144); match(L_PAR);
				setState(145); expr(0);
				setState(146); match(COMMA);
				setState(147); expr(0);
				setState(148); match(R_PAR);
				}
				break;
			case FIRST:
			case SECOND:
				enterOuterAlt(_localctx, 4);
				{
				setState(150); pairElem();
				}
				break;
			case CALL:
				enterOuterAlt(_localctx, 5);
				{
				setState(151); match(CALL);
				setState(152); match(IDENT);
				setState(153); match(L_PAR);
				setState(155);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << L_PAR) | (1L << NOT) | (1L << NEGATIVE) | (1L << LEN) | (1L << ORD) | (1L << CHR) | (1L << IDENT) | (1L << INTEGER) | (1L << STRING_LITER) | (1L << CHAR_LITER) | (1L << TRUE) | (1L << FALSE) | (1L << NULL))) != 0)) {
					{
					setState(154); argList();
					}
				}

				setState(157); match(R_PAR);
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

	public static class ArgListContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public List<TerminalNode> COMMA() { return getTokens(WaccParser.COMMA); }
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode COMMA(int i) {
			return getToken(WaccParser.COMMA, i);
		}
		public ArgListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argList; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitArgList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgListContext argList() throws RecognitionException {
		ArgListContext _localctx = new ArgListContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_argList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(160); expr(0);
			setState(165);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(161); match(COMMA);
				setState(162); expr(0);
				}
				}
				setState(167);
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

	public static class PairElemContext extends ParserRuleContext {
		public TerminalNode FIRST() { return getToken(WaccParser.FIRST, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SECOND() { return getToken(WaccParser.SECOND, 0); }
		public PairElemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pairElem; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitPairElem(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PairElemContext pairElem() throws RecognitionException {
		PairElemContext _localctx = new PairElemContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_pairElem);
		try {
			setState(172);
			switch (_input.LA(1)) {
			case FIRST:
				enterOuterAlt(_localctx, 1);
				{
				setState(168); match(FIRST);
				setState(169); expr(0);
				}
				break;
			case SECOND:
				enterOuterAlt(_localctx, 2);
				{
				setState(170); match(SECOND);
				setState(171); expr(0);
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

	public static class TypeContext extends ParserRuleContext {
		public PairTypeContext pairType() {
			return getRuleContext(PairTypeContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode R_SQ() { return getToken(WaccParser.R_SQ, 0); }
		public BaseTypeContext baseType() {
			return getRuleContext(BaseTypeContext.class,0);
		}
		public TerminalNode L_SQ() { return getToken(WaccParser.L_SQ, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		return type(0);
	}

	private TypeContext type(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		TypeContext _localctx = new TypeContext(_ctx, _parentState);
		TypeContext _prevctx = _localctx;
		int _startState = 18;
		enterRecursionRule(_localctx, 18, RULE_type, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(177);
			switch (_input.LA(1)) {
			case INT:
			case BOOL:
			case CHAR:
			case STRING:
				{
				setState(175); baseType();
				}
				break;
			case PAIR:
				{
				setState(176); pairType();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(184);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new TypeContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_type);
					setState(179);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(180); match(L_SQ);
					setState(181); match(R_SQ);
					}
					} 
				}
				setState(186);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
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

	public static class BaseTypeContext extends ParserRuleContext {
		public TerminalNode BOOL() { return getToken(WaccParser.BOOL, 0); }
		public TerminalNode INT() { return getToken(WaccParser.INT, 0); }
		public TerminalNode STRING() { return getToken(WaccParser.STRING, 0); }
		public TerminalNode CHAR() { return getToken(WaccParser.CHAR, 0); }
		public BaseTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_baseType; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitBaseType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BaseTypeContext baseType() throws RecognitionException {
		BaseTypeContext _localctx = new BaseTypeContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_baseType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(187);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << BOOL) | (1L << CHAR) | (1L << STRING))) != 0)) ) {
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

	public static class ArrayTypeContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode R_SQ() { return getToken(WaccParser.R_SQ, 0); }
		public TerminalNode L_SQ() { return getToken(WaccParser.L_SQ, 0); }
		public ArrayTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayType; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitArrayType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayTypeContext arrayType() throws RecognitionException {
		ArrayTypeContext _localctx = new ArrayTypeContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_arrayType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(189); type(0);
			setState(190); match(L_SQ);
			setState(191); match(R_SQ);
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

	public static class PairTypeContext extends ParserRuleContext {
		public List<PairElemTypeContext> pairElemType() {
			return getRuleContexts(PairElemTypeContext.class);
		}
		public PairElemTypeContext pairElemType(int i) {
			return getRuleContext(PairElemTypeContext.class,i);
		}
		public TerminalNode COMMA() { return getToken(WaccParser.COMMA, 0); }
		public TerminalNode PAIR() { return getToken(WaccParser.PAIR, 0); }
		public TerminalNode R_PAR() { return getToken(WaccParser.R_PAR, 0); }
		public TerminalNode L_PAR() { return getToken(WaccParser.L_PAR, 0); }
		public PairTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pairType; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitPairType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PairTypeContext pairType() throws RecognitionException {
		PairTypeContext _localctx = new PairTypeContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_pairType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(193); match(PAIR);
			setState(194); match(L_PAR);
			setState(195); pairElemType();
			setState(196); match(COMMA);
			setState(197); pairElemType();
			setState(198); match(R_PAR);
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

	public static class PairElemTypeContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode PAIR() { return getToken(WaccParser.PAIR, 0); }
		public TerminalNode R_SQ() { return getToken(WaccParser.R_SQ, 0); }
		public BaseTypeContext baseType() {
			return getRuleContext(BaseTypeContext.class,0);
		}
		public TerminalNode L_SQ() { return getToken(WaccParser.L_SQ, 0); }
		public PairElemTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pairElemType; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitPairElemType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PairElemTypeContext pairElemType() throws RecognitionException {
		PairElemTypeContext _localctx = new PairElemTypeContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_pairElemType);
		try {
			setState(206);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(200); baseType();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(201); type(0);
				setState(202); match(L_SQ);
				setState(203); match(R_SQ);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(205); match(PAIR);
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

	public static class ExprContext extends ParserRuleContext {
		public BoolLiterContext boolLiter() {
			return getRuleContext(BoolLiterContext.class,0);
		}
		public PairLiterContext pairLiter() {
			return getRuleContext(PairLiterContext.class,0);
		}
		public ArrayElemContext arrayElem() {
			return getRuleContext(ArrayElemContext.class,0);
		}
		public TerminalNode L_PAR() { return getToken(WaccParser.L_PAR, 0); }
		public TerminalNode CHAR_LITER() { return getToken(WaccParser.CHAR_LITER, 0); }
		public IntLiterContext intLiter() {
			return getRuleContext(IntLiterContext.class,0);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode R_PAR() { return getToken(WaccParser.R_PAR, 0); }
		public UnaryOperContext unaryOper() {
			return getRuleContext(UnaryOperContext.class,0);
		}
		public TerminalNode IDENT() { return getToken(WaccParser.IDENT, 0); }
		public BinaryOperContext binaryOper() {
			return getRuleContext(BinaryOperContext.class,0);
		}
		public TerminalNode STRING_LITER() { return getToken(WaccParser.STRING_LITER, 0); }
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitExpr(this);
			else return visitor.visitChildren(this);
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
		int _startState = 28;
		enterRecursionRule(_localctx, 28, RULE_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(223);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				{
				setState(209); unaryOper();
				setState(210); expr(3);
				}
				break;
			case 2:
				{
				setState(212); intLiter();
				}
				break;
			case 3:
				{
				setState(213); boolLiter();
				}
				break;
			case 4:
				{
				setState(214); match(CHAR_LITER);
				}
				break;
			case 5:
				{
				setState(215); match(STRING_LITER);
				}
				break;
			case 6:
				{
				setState(216); pairLiter();
				}
				break;
			case 7:
				{
				setState(217); match(IDENT);
				}
				break;
			case 8:
				{
				setState(218); arrayElem();
				}
				break;
			case 9:
				{
				setState(219); match(L_PAR);
				setState(220); expr(0);
				setState(221); match(R_PAR);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(231);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ExprContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_expr);
					setState(225);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(226); binaryOper();
					setState(227); expr(3);
					}
					} 
				}
				setState(233);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
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

	public static class UnaryOperContext extends ParserRuleContext {
		public TerminalNode LEN() { return getToken(WaccParser.LEN, 0); }
		public TerminalNode NOT() { return getToken(WaccParser.NOT, 0); }
		public TerminalNode CHR() { return getToken(WaccParser.CHR, 0); }
		public TerminalNode ORD() { return getToken(WaccParser.ORD, 0); }
		public TerminalNode NEGATIVE() { return getToken(WaccParser.NEGATIVE, 0); }
		public UnaryOperContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryOper; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitUnaryOper(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnaryOperContext unaryOper() throws RecognitionException {
		UnaryOperContext _localctx = new UnaryOperContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_unaryOper);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(234);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NOT) | (1L << NEGATIVE) | (1L << LEN) | (1L << ORD) | (1L << CHR))) != 0)) ) {
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

	public static class BinaryOperContext extends ParserRuleContext {
		public TerminalNode MUL() { return getToken(WaccParser.MUL, 0); }
		public TerminalNode LESS_OR_EQUAL() { return getToken(WaccParser.LESS_OR_EQUAL, 0); }
		public TerminalNode AND() { return getToken(WaccParser.AND, 0); }
		public TerminalNode OR() { return getToken(WaccParser.OR, 0); }
		public TerminalNode MINUS() { return getToken(WaccParser.MINUS, 0); }
		public TerminalNode EQUAL() { return getToken(WaccParser.EQUAL, 0); }
		public TerminalNode NOT_EQUAL() { return getToken(WaccParser.NOT_EQUAL, 0); }
		public TerminalNode DIV() { return getToken(WaccParser.DIV, 0); }
		public TerminalNode GREATER_OR_EQUAL() { return getToken(WaccParser.GREATER_OR_EQUAL, 0); }
		public TerminalNode LESS() { return getToken(WaccParser.LESS, 0); }
		public TerminalNode PLUS() { return getToken(WaccParser.PLUS, 0); }
		public TerminalNode GREATER() { return getToken(WaccParser.GREATER, 0); }
		public TerminalNode MOD() { return getToken(WaccParser.MOD, 0); }
		public BinaryOperContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binaryOper; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitBinaryOper(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BinaryOperContext binaryOper() throws RecognitionException {
		BinaryOperContext _localctx = new BinaryOperContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_binaryOper);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(236);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MUL) | (1L << DIV) | (1L << MOD) | (1L << PLUS) | (1L << MINUS) | (1L << GREATER) | (1L << GREATER_OR_EQUAL) | (1L << LESS) | (1L << LESS_OR_EQUAL) | (1L << EQUAL) | (1L << NOT_EQUAL) | (1L << AND) | (1L << OR))) != 0)) ) {
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

	public static class ArrayElemContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode PLUS() { return getToken(WaccParser.PLUS, 0); }
		public TerminalNode R_SQ() { return getToken(WaccParser.R_SQ, 0); }
		public TerminalNode L_SQ() { return getToken(WaccParser.L_SQ, 0); }
		public TerminalNode IDENT() { return getToken(WaccParser.IDENT, 0); }
		public ArrayElemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayElem; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitArrayElem(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayElemContext arrayElem() throws RecognitionException {
		ArrayElemContext _localctx = new ArrayElemContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_arrayElem);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(238); match(IDENT);
			{
			setState(239); match(L_SQ);
			setState(240); expr(0);
			setState(241); match(R_SQ);
			}
			setState(243); match(PLUS);
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

	public static class IntSignContext extends ParserRuleContext {
		public TerminalNode MINUS() { return getToken(WaccParser.MINUS, 0); }
		public TerminalNode PLUS() { return getToken(WaccParser.PLUS, 0); }
		public IntSignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_intSign; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitIntSign(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IntSignContext intSign() throws RecognitionException {
		IntSignContext _localctx = new IntSignContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_intSign);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(245);
			_la = _input.LA(1);
			if ( !(_la==PLUS || _la==MINUS) ) {
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

	public static class IntLiterContext extends ParserRuleContext {
		public TerminalNode INTEGER() { return getToken(WaccParser.INTEGER, 0); }
		public IntLiterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_intLiter; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitIntLiter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IntLiterContext intLiter() throws RecognitionException {
		IntLiterContext _localctx = new IntLiterContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_intLiter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(247); match(INTEGER);
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

	public static class BoolLiterContext extends ParserRuleContext {
		public TerminalNode TRUE() { return getToken(WaccParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(WaccParser.FALSE, 0); }
		public BoolLiterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolLiter; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitBoolLiter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BoolLiterContext boolLiter() throws RecognitionException {
		BoolLiterContext _localctx = new BoolLiterContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_boolLiter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(249);
			_la = _input.LA(1);
			if ( !(_la==TRUE || _la==FALSE) ) {
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

	public static class ArrayLiterContext extends ParserRuleContext {
		public ArgListContext argList() {
			return getRuleContext(ArgListContext.class,0);
		}
		public TerminalNode R_SQ() { return getToken(WaccParser.R_SQ, 0); }
		public TerminalNode L_SQ() { return getToken(WaccParser.L_SQ, 0); }
		public ArrayLiterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayLiter; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitArrayLiter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayLiterContext arrayLiter() throws RecognitionException {
		ArrayLiterContext _localctx = new ArrayLiterContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_arrayLiter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(251); match(L_SQ);
			setState(253);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << L_PAR) | (1L << NOT) | (1L << NEGATIVE) | (1L << LEN) | (1L << ORD) | (1L << CHR) | (1L << IDENT) | (1L << INTEGER) | (1L << STRING_LITER) | (1L << CHAR_LITER) | (1L << TRUE) | (1L << FALSE) | (1L << NULL))) != 0)) {
				{
				setState(252); argList();
				}
			}

			setState(255); match(R_SQ);
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

	public static class PairLiterContext extends ParserRuleContext {
		public TerminalNode NULL() { return getToken(WaccParser.NULL, 0); }
		public PairLiterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pairLiter; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitPairLiter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PairLiterContext pairLiter() throws RecognitionException {
		PairLiterContext _localctx = new PairLiterContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_pairLiter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(257); match(NULL);
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
		case 4: return stat_sempred((StatContext)_localctx, predIndex);
		case 9: return type_sempred((TypeContext)_localctx, predIndex);
		case 14: return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2: return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean type_sempred(TypeContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1: return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean stat_sempred(StatContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3A\u0106\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\3\2\3\2\7"+
		"\2\63\n\2\f\2\16\2\66\13\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\4\3\4\3\4\7\4H\n\4\f\4\16\4K\13\4\5\4M\n\4\3\5\3\5\3\5\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6\u0081\n\6\3\6\3\6\3\6"+
		"\7\6\u0086\n\6\f\6\16\6\u0089\13\6\3\7\3\7\3\7\5\7\u008e\n\7\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b\u009e\n\b\3\b\5\b\u00a1"+
		"\n\b\3\t\3\t\3\t\7\t\u00a6\n\t\f\t\16\t\u00a9\13\t\3\n\3\n\3\n\3\n\5\n"+
		"\u00af\n\n\3\13\3\13\3\13\5\13\u00b4\n\13\3\13\3\13\3\13\7\13\u00b9\n"+
		"\13\f\13\16\13\u00bc\13\13\3\f\3\f\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u00d1\n\17\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20"+
		"\u00e2\n\20\3\20\3\20\3\20\3\20\7\20\u00e8\n\20\f\20\16\20\u00eb\13\20"+
		"\3\21\3\21\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\25"+
		"\3\25\3\26\3\26\3\27\3\27\5\27\u0100\n\27\3\27\3\27\3\30\3\30\3\30\2\5"+
		"\n\24\36\31\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\2\7\3\2\32"+
		"\35\3\2\'+\3\2,8\3\2/\60\3\2=>\u0115\2\60\3\2\2\2\4;\3\2\2\2\6L\3\2\2"+
		"\2\bN\3\2\2\2\n\u0080\3\2\2\2\f\u008d\3\2\2\2\16\u00a0\3\2\2\2\20\u00a2"+
		"\3\2\2\2\22\u00ae\3\2\2\2\24\u00b3\3\2\2\2\26\u00bd\3\2\2\2\30\u00bf\3"+
		"\2\2\2\32\u00c3\3\2\2\2\34\u00d0\3\2\2\2\36\u00e1\3\2\2\2 \u00ec\3\2\2"+
		"\2\"\u00ee\3\2\2\2$\u00f0\3\2\2\2&\u00f7\3\2\2\2(\u00f9\3\2\2\2*\u00fb"+
		"\3\2\2\2,\u00fd\3\2\2\2.\u0103\3\2\2\2\60\64\7\5\2\2\61\63\5\4\3\2\62"+
		"\61\3\2\2\2\63\66\3\2\2\2\64\62\3\2\2\2\64\65\3\2\2\2\65\67\3\2\2\2\66"+
		"\64\3\2\2\2\678\5\n\6\289\7\7\2\29:\7\2\2\3:\3\3\2\2\2;<\5\24\13\2<=\7"+
		"9\2\2=>\7\37\2\2>?\5\6\4\2?@\7 \2\2@A\7\6\2\2AB\5\n\6\2BC\7\7\2\2C\5\3"+
		"\2\2\2DI\5\b\5\2EF\7#\2\2FH\5\b\5\2GE\3\2\2\2HK\3\2\2\2IG\3\2\2\2IJ\3"+
		"\2\2\2JM\3\2\2\2KI\3\2\2\2LD\3\2\2\2LM\3\2\2\2M\7\3\2\2\2NO\5\24\13\2"+
		"OP\79\2\2P\t\3\2\2\2QR\b\6\1\2R\u0081\7\b\2\2ST\5\24\13\2TU\79\2\2UV\7"+
		"$\2\2VW\5\16\b\2W\u0081\3\2\2\2XY\5\f\7\2YZ\7$\2\2Z[\5\16\b\2[\u0081\3"+
		"\2\2\2\\]\7\t\2\2]\u0081\5\f\7\2^_\7\n\2\2_\u0081\5\36\20\2`a\7\13\2\2"+
		"a\u0081\5\36\20\2bc\7\f\2\2c\u0081\5\36\20\2de\7\r\2\2e\u0081\5\36\20"+
		"\2fg\7\16\2\2g\u0081\5\36\20\2hi\7\17\2\2ij\5\36\20\2jk\7\20\2\2kl\5\n"+
		"\6\2lm\7\22\2\2m\u0081\3\2\2\2no\7\17\2\2op\5\36\20\2pq\7\20\2\2qr\5\n"+
		"\6\2rs\7\21\2\2st\5\n\6\2tu\7\22\2\2u\u0081\3\2\2\2vw\7\23\2\2wx\5\36"+
		"\20\2xy\7\24\2\2yz\5\n\6\2z{\7\25\2\2{\u0081\3\2\2\2|}\7\5\2\2}~\5\n\6"+
		"\2~\177\7\7\2\2\177\u0081\3\2\2\2\u0080Q\3\2\2\2\u0080S\3\2\2\2\u0080"+
		"X\3\2\2\2\u0080\\\3\2\2\2\u0080^\3\2\2\2\u0080`\3\2\2\2\u0080b\3\2\2\2"+
		"\u0080d\3\2\2\2\u0080f\3\2\2\2\u0080h\3\2\2\2\u0080n\3\2\2\2\u0080v\3"+
		"\2\2\2\u0080|\3\2\2\2\u0081\u0087\3\2\2\2\u0082\u0083\f\3\2\2\u0083\u0084"+
		"\7\4\2\2\u0084\u0086\5\n\6\4\u0085\u0082\3\2\2\2\u0086\u0089\3\2\2\2\u0087"+
		"\u0085\3\2\2\2\u0087\u0088\3\2\2\2\u0088\13\3\2\2\2\u0089\u0087\3\2\2"+
		"\2\u008a\u008e\79\2\2\u008b\u008e\5$\23\2\u008c\u008e\5\22\n\2\u008d\u008a"+
		"\3\2\2\2\u008d\u008b\3\2\2\2\u008d\u008c\3\2\2\2\u008e\r\3\2\2\2\u008f"+
		"\u00a1\5\36\20\2\u0090\u00a1\5,\27\2\u0091\u0092\7\26\2\2\u0092\u0093"+
		"\7\37\2\2\u0093\u0094\5\36\20\2\u0094\u0095\7#\2\2\u0095\u0096\5\36\20"+
		"\2\u0096\u0097\7 \2\2\u0097\u00a1\3\2\2\2\u0098\u00a1\5\22\n\2\u0099\u009a"+
		"\7\27\2\2\u009a\u009b\79\2\2\u009b\u009d\7\37\2\2\u009c\u009e\5\20\t\2"+
		"\u009d\u009c\3\2\2\2\u009d\u009e\3\2\2\2\u009e\u009f\3\2\2\2\u009f\u00a1"+
		"\7 \2\2\u00a0\u008f\3\2\2\2\u00a0\u0090\3\2\2\2\u00a0\u0091\3\2\2\2\u00a0"+
		"\u0098\3\2\2\2\u00a0\u0099\3\2\2\2\u00a1\17\3\2\2\2\u00a2\u00a7\5\36\20"+
		"\2\u00a3\u00a4\7#\2\2\u00a4\u00a6\5\36\20\2\u00a5\u00a3\3\2\2\2\u00a6"+
		"\u00a9\3\2\2\2\u00a7\u00a5\3\2\2\2\u00a7\u00a8\3\2\2\2\u00a8\21\3\2\2"+
		"\2\u00a9\u00a7\3\2\2\2\u00aa\u00ab\7\30\2\2\u00ab\u00af\5\36\20\2\u00ac"+
		"\u00ad\7\31\2\2\u00ad\u00af\5\36\20\2\u00ae\u00aa\3\2\2\2\u00ae\u00ac"+
		"\3\2\2\2\u00af\23\3\2\2\2\u00b0\u00b1\b\13\1\2\u00b1\u00b4\5\26\f\2\u00b2"+
		"\u00b4\5\32\16\2\u00b3\u00b0\3\2\2\2\u00b3\u00b2\3\2\2\2\u00b4\u00ba\3"+
		"\2\2\2\u00b5\u00b6\f\4\2\2\u00b6\u00b7\7!\2\2\u00b7\u00b9\7\"\2\2\u00b8"+
		"\u00b5\3\2\2\2\u00b9\u00bc\3\2\2\2\u00ba\u00b8\3\2\2\2\u00ba\u00bb\3\2"+
		"\2\2\u00bb\25\3\2\2\2\u00bc\u00ba\3\2\2\2\u00bd\u00be\t\2\2\2\u00be\27"+
		"\3\2\2\2\u00bf\u00c0\5\24\13\2\u00c0\u00c1\7!\2\2\u00c1\u00c2\7\"\2\2"+
		"\u00c2\31\3\2\2\2\u00c3\u00c4\7\36\2\2\u00c4\u00c5\7\37\2\2\u00c5\u00c6"+
		"\5\34\17\2\u00c6\u00c7\7#\2\2\u00c7\u00c8\5\34\17\2\u00c8\u00c9\7 \2\2"+
		"\u00c9\33\3\2\2\2\u00ca\u00d1\5\26\f\2\u00cb\u00cc\5\24\13\2\u00cc\u00cd"+
		"\7!\2\2\u00cd\u00ce\7\"\2\2\u00ce\u00d1\3\2\2\2\u00cf\u00d1\7\36\2\2\u00d0"+
		"\u00ca\3\2\2\2\u00d0\u00cb\3\2\2\2\u00d0\u00cf\3\2\2\2\u00d1\35\3\2\2"+
		"\2\u00d2\u00d3\b\20\1\2\u00d3\u00d4\5 \21\2\u00d4\u00d5\5\36\20\5\u00d5"+
		"\u00e2\3\2\2\2\u00d6\u00e2\5(\25\2\u00d7\u00e2\5*\26\2\u00d8\u00e2\7<"+
		"\2\2\u00d9\u00e2\7;\2\2\u00da\u00e2\5.\30\2\u00db\u00e2\79\2\2\u00dc\u00e2"+
		"\5$\23\2\u00dd\u00de\7\37\2\2\u00de\u00df\5\36\20\2\u00df\u00e0\7 \2\2"+
		"\u00e0\u00e2\3\2\2\2\u00e1\u00d2\3\2\2\2\u00e1\u00d6\3\2\2\2\u00e1\u00d7"+
		"\3\2\2\2\u00e1\u00d8\3\2\2\2\u00e1\u00d9\3\2\2\2\u00e1\u00da\3\2\2\2\u00e1"+
		"\u00db\3\2\2\2\u00e1\u00dc\3\2\2\2\u00e1\u00dd\3\2\2\2\u00e2\u00e9\3\2"+
		"\2\2\u00e3\u00e4\f\4\2\2\u00e4\u00e5\5\"\22\2\u00e5\u00e6\5\36\20\5\u00e6"+
		"\u00e8\3\2\2\2\u00e7\u00e3\3\2\2\2\u00e8\u00eb\3\2\2\2\u00e9\u00e7\3\2"+
		"\2\2\u00e9\u00ea\3\2\2\2\u00ea\37\3\2\2\2\u00eb\u00e9\3\2\2\2\u00ec\u00ed"+
		"\t\3\2\2\u00ed!\3\2\2\2\u00ee\u00ef\t\4\2\2\u00ef#\3\2\2\2\u00f0\u00f1"+
		"\79\2\2\u00f1\u00f2\7!\2\2\u00f2\u00f3\5\36\20\2\u00f3\u00f4\7\"\2\2\u00f4"+
		"\u00f5\3\2\2\2\u00f5\u00f6\7/\2\2\u00f6%\3\2\2\2\u00f7\u00f8\t\5\2\2\u00f8"+
		"\'\3\2\2\2\u00f9\u00fa\7:\2\2\u00fa)\3\2\2\2\u00fb\u00fc\t\6\2\2\u00fc"+
		"+\3\2\2\2\u00fd\u00ff\7!\2\2\u00fe\u0100\5\20\t\2\u00ff\u00fe\3\2\2\2"+
		"\u00ff\u0100\3\2\2\2\u0100\u0101\3\2\2\2\u0101\u0102\7\"\2\2\u0102-\3"+
		"\2\2\2\u0103\u0104\7?\2\2\u0104/\3\2\2\2\22\64IL\u0080\u0087\u008d\u009d"+
		"\u00a0\u00a7\u00ae\u00b3\u00ba\u00d0\u00e1\u00e9\u00ff";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}