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
		WHILE=17, DOUBLE_QUOTE=39, MOD=46, GREATER_OR_EQUAL=50, CHAR=26, DO=18, 
		NOT=40, AND=55, ORD=42, R_SQ=35, IF=13, FREE=8, SINGLE_QUOTE=38, GREATER=49, 
		THEN=14, NOT_EQUAL=54, COMMA=36, DONE=19, IS=4, PRINTLN=12, EQUAL=53, 
		BEGIN=3, LESS=51, RETURN=9, CHAR_LITER=60, IDENT=57, PLUS=47, PAIR=28, 
		COMMENT=61, NEWPAIR=20, INTEGER=58, EXIT=10, STRING_LITER=59, SECOND=23, 
		LESS_OR_EQUAL=52, NULL=31, ELSE=15, BOOL=25, WHITESPACE=62, INT=24, SEMICOLON=2, 
		MINUS=48, FILE=1, TRUE=29, MUL=44, PRINT=11, CHR=43, FI=16, SKIP=6, READ=7, 
		OR=56, L_SQ=34, ASSIGN=37, LEN=41, CALL=21, L_PAR=32, DIV=45, END=5, FALSE=30, 
		R_PAR=33, FIRST=22, STRING=27;
	public static final String[] tokenNames = {
		"<INVALID>", "FILE", "';'", "'begin'", "'is'", "'end'", "'skip'", "'read'", 
		"'free'", "'return'", "'exit'", "'print'", "'println'", "'if'", "'then'", 
		"'else'", "'fi'", "'while'", "'do'", "'done'", "'newpair'", "'call'", 
		"'fst'", "'snd'", "'int'", "'bool'", "'char'", "'string'", "'pair'", "'true'", 
		"'false'", "'null'", "'('", "')'", "'['", "']'", "','", "'='", "'''", 
		"'\"'", "'!'", "'len'", "'ord'", "'chr'", "'*'", "'/'", "'%'", "'+'", 
		"'-'", "'>'", "'>='", "'<'", "'<='", "'=='", "'!='", "'&&'", "'||'", "IDENT", 
		"INTEGER", "STRING_LITER", "CHAR_LITER", "COMMENT", "WHITESPACE"
	};
	public static final int
		RULE_program = 0, RULE_func = 1, RULE_paramList = 2, RULE_param = 3, RULE_stat = 4, 
		RULE_assignLHS = 5, RULE_assignRHS = 6, RULE_argList = 7, RULE_pairElem = 8, 
		RULE_type = 9, RULE_baseType = 10, RULE_arrayType = 11, RULE_pairElemType = 12, 
		RULE_pairType = 13, RULE_expr = 14, RULE_unaryOper = 15, RULE_binaryOper = 16, 
		RULE_arrayElem = 17, RULE_intSign = 18, RULE_intLiter = 19, RULE_boolLiter = 20, 
		RULE_arrayLiter = 21, RULE_pairLiter = 22;
	public static final String[] ruleNames = {
		"program", "func", "paramList", "param", "stat", "assignLHS", "assignRHS", 
		"argList", "pairElem", "type", "baseType", "arrayType", "pairElemType", 
		"pairType", "expr", "unaryOper", "binaryOper", "arrayElem", "intSign", 
		"intLiter", "boolLiter", "arrayLiter", "pairLiter"
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
			setState(57); type();
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
			setState(76); type();
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
		public StatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stat; }
	 
		public StatContext() { }
		public void copyFrom(StatContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ReturnStatContext extends StatContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RETURN() { return getToken(WaccParser.RETURN, 0); }
		public ReturnStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitReturnStat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IfThenElseStatContext extends StatContext {
		public TerminalNode THEN() { return getToken(WaccParser.THEN, 0); }
		public TerminalNode IF() { return getToken(WaccParser.IF, 0); }
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public TerminalNode FI() { return getToken(WaccParser.FI, 0); }
		public TerminalNode ELSE() { return getToken(WaccParser.ELSE, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public IfThenElseStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitIfThenElseStat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AssignStatContext extends StatContext {
		public TerminalNode ASSIGN() { return getToken(WaccParser.ASSIGN, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public AssignLHSContext assignLHS() {
			return getRuleContext(AssignLHSContext.class,0);
		}
		public AssignRHSContext assignRHS() {
			return getRuleContext(AssignRHSContext.class,0);
		}
		public TerminalNode IDENT() { return getToken(WaccParser.IDENT, 0); }
		public AssignStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitAssignStat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class WhileStatContext extends StatContext {
		public TerminalNode WHILE() { return getToken(WaccParser.WHILE, 0); }
		public TerminalNode DO() { return getToken(WaccParser.DO, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode DONE() { return getToken(WaccParser.DONE, 0); }
		public StatContext stat() {
			return getRuleContext(StatContext.class,0);
		}
		public WhileStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitWhileStat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExitStatContext extends StatContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode EXIT() { return getToken(WaccParser.EXIT, 0); }
		public ExitStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitExitStat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StatListContext extends StatContext {
		public TerminalNode SEMICOLON() { return getToken(WaccParser.SEMICOLON, 0); }
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public StatListContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitStatList(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PrintStatContext extends StatContext {
		public TerminalNode PRINT() { return getToken(WaccParser.PRINT, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public PrintStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitPrintStat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BeginStatContext extends StatContext {
		public StatContext stat() {
			return getRuleContext(StatContext.class,0);
		}
		public TerminalNode BEGIN() { return getToken(WaccParser.BEGIN, 0); }
		public TerminalNode END() { return getToken(WaccParser.END, 0); }
		public BeginStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitBeginStat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ReadStatContext extends StatContext {
		public TerminalNode READ() { return getToken(WaccParser.READ, 0); }
		public AssignLHSContext assignLHS() {
			return getRuleContext(AssignLHSContext.class,0);
		}
		public ReadStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitReadStat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SkipStatContext extends StatContext {
		public TerminalNode SKIP() { return getToken(WaccParser.SKIP, 0); }
		public SkipStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitSkipStat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PrintlnStatContext extends StatContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode PRINTLN() { return getToken(WaccParser.PRINTLN, 0); }
		public PrintlnStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitPrintlnStat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FreeStatContext extends StatContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode FREE() { return getToken(WaccParser.FREE, 0); }
		public FreeStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitFreeStat(this);
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
			setState(120);
			switch (_input.LA(1)) {
			case SKIP:
				{
				_localctx = new SkipStatContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(80); match(SKIP);
				}
				break;
			case INT:
			case BOOL:
			case CHAR:
			case STRING:
			case PAIR:
				{
				_localctx = new AssignStatContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(81); type();
				setState(82); match(IDENT);
				setState(83); match(ASSIGN);
				setState(84); assignRHS();
				}
				break;
			case FIRST:
			case SECOND:
			case IDENT:
				{
				_localctx = new AssignStatContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(86); assignLHS();
				setState(87); match(ASSIGN);
				setState(88); assignRHS();
				}
				break;
			case READ:
				{
				_localctx = new ReadStatContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(90); match(READ);
				setState(91); assignLHS();
				}
				break;
			case FREE:
				{
				_localctx = new FreeStatContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(92); match(FREE);
				setState(93); expr(0);
				}
				break;
			case RETURN:
				{
				_localctx = new ReturnStatContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(94); match(RETURN);
				setState(95); expr(0);
				}
				break;
			case EXIT:
				{
				_localctx = new ExitStatContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(96); match(EXIT);
				setState(97); expr(0);
				}
				break;
			case PRINT:
				{
				_localctx = new PrintStatContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(98); match(PRINT);
				setState(99); expr(0);
				}
				break;
			case PRINTLN:
				{
				_localctx = new PrintlnStatContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(100); match(PRINTLN);
				setState(101); expr(0);
				}
				break;
			case IF:
				{
				_localctx = new IfThenElseStatContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(102); match(IF);
				setState(103); expr(0);
				setState(104); match(THEN);
				setState(105); stat(0);
				setState(106); match(ELSE);
				setState(107); stat(0);
				setState(108); match(FI);
				}
				break;
			case WHILE:
				{
				_localctx = new WhileStatContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(110); match(WHILE);
				setState(111); expr(0);
				setState(112); match(DO);
				setState(113); stat(0);
				setState(114); match(DONE);
				}
				break;
			case BEGIN:
				{
				_localctx = new BeginStatContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(116); match(BEGIN);
				setState(117); stat(0);
				setState(118); match(END);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(127);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new StatListContext(new StatContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_stat);
					setState(122);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(123); match(SEMICOLON);
					setState(124); stat(2);
					}
					} 
				}
				setState(129);
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
			setState(133);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(130); match(IDENT);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(131); arrayElem();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(132); pairElem();
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
			setState(152);
			switch (_input.LA(1)) {
			case TRUE:
			case FALSE:
			case NULL:
			case L_PAR:
			case NOT:
			case LEN:
			case ORD:
			case CHR:
			case PLUS:
			case MINUS:
			case IDENT:
			case INTEGER:
			case STRING_LITER:
			case CHAR_LITER:
				enterOuterAlt(_localctx, 1);
				{
				setState(135); expr(0);
				}
				break;
			case L_SQ:
				enterOuterAlt(_localctx, 2);
				{
				setState(136); arrayLiter();
				}
				break;
			case NEWPAIR:
				enterOuterAlt(_localctx, 3);
				{
				setState(137); match(NEWPAIR);
				setState(138); match(L_PAR);
				setState(139); expr(0);
				setState(140); match(COMMA);
				setState(141); expr(0);
				setState(142); match(R_PAR);
				}
				break;
			case FIRST:
			case SECOND:
				enterOuterAlt(_localctx, 4);
				{
				setState(144); pairElem();
				}
				break;
			case CALL:
				enterOuterAlt(_localctx, 5);
				{
				setState(145); match(CALL);
				setState(146); match(IDENT);
				setState(147); match(L_PAR);
				setState(149);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TRUE) | (1L << FALSE) | (1L << NULL) | (1L << L_PAR) | (1L << NOT) | (1L << LEN) | (1L << ORD) | (1L << CHR) | (1L << PLUS) | (1L << MINUS) | (1L << IDENT) | (1L << INTEGER) | (1L << STRING_LITER) | (1L << CHAR_LITER))) != 0)) {
					{
					setState(148); argList();
					}
				}

				setState(151); match(R_PAR);
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
			setState(154); expr(0);
			setState(159);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(155); match(COMMA);
				setState(156); expr(0);
				}
				}
				setState(161);
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
			setState(166);
			switch (_input.LA(1)) {
			case FIRST:
				enterOuterAlt(_localctx, 1);
				{
				setState(162); match(FIRST);
				setState(163); expr(0);
				}
				break;
			case SECOND:
				enterOuterAlt(_localctx, 2);
				{
				setState(164); match(SECOND);
				setState(165); expr(0);
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
		public ArrayTypeContext arrayType() {
			return getRuleContext(ArrayTypeContext.class,0);
		}
		public BaseTypeContext baseType() {
			return getRuleContext(BaseTypeContext.class,0);
		}
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
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_type);
		try {
			setState(171);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(168); baseType();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(169); arrayType(0);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(170); pairType();
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
			setState(173);
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
		public PairTypeContext pairType() {
			return getRuleContext(PairTypeContext.class,0);
		}
		public ArrayTypeContext arrayType() {
			return getRuleContext(ArrayTypeContext.class,0);
		}
		public TerminalNode R_SQ() { return getToken(WaccParser.R_SQ, 0); }
		public BaseTypeContext baseType() {
			return getRuleContext(BaseTypeContext.class,0);
		}
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
		return arrayType(0);
	}

	private ArrayTypeContext arrayType(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ArrayTypeContext _localctx = new ArrayTypeContext(_ctx, _parentState);
		ArrayTypeContext _prevctx = _localctx;
		int _startState = 22;
		enterRecursionRule(_localctx, 22, RULE_arrayType, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(184);
			switch (_input.LA(1)) {
			case INT:
			case BOOL:
			case CHAR:
			case STRING:
				{
				setState(176); baseType();
				setState(177); match(L_SQ);
				setState(178); match(R_SQ);
				}
				break;
			case PAIR:
				{
				setState(180); pairType();
				setState(181); match(L_SQ);
				setState(182); match(R_SQ);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(191);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ArrayTypeContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_arrayType);
					setState(186);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(187); match(L_SQ);
					setState(188); match(R_SQ);
					}
					} 
				}
				setState(193);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
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

	public static class PairElemTypeContext extends ParserRuleContext {
		public TerminalNode PAIR() { return getToken(WaccParser.PAIR, 0); }
		public ArrayTypeContext arrayType() {
			return getRuleContext(ArrayTypeContext.class,0);
		}
		public BaseTypeContext baseType() {
			return getRuleContext(BaseTypeContext.class,0);
		}
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
		enterRule(_localctx, 24, RULE_pairElemType);
		try {
			setState(197);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(194); baseType();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(195); arrayType(0);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(196); match(PAIR);
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
		enterRule(_localctx, 26, RULE_pairType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(199); match(PAIR);
			setState(200); match(L_PAR);
			setState(201); pairElemType();
			setState(202); match(COMMA);
			setState(203); pairElemType();
			setState(204); match(R_PAR);
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
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class IntLiterExprContext extends ExprContext {
		public IntLiterContext intLiter() {
			return getRuleContext(IntLiterContext.class,0);
		}
		public IntLiterExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitIntLiterExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ParanthesesExprContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode R_PAR() { return getToken(WaccParser.R_PAR, 0); }
		public TerminalNode L_PAR() { return getToken(WaccParser.L_PAR, 0); }
		public ParanthesesExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitParanthesesExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CharLiterExprContext extends ExprContext {
		public TerminalNode CHAR_LITER() { return getToken(WaccParser.CHAR_LITER, 0); }
		public CharLiterExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitCharLiterExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IdentExprContext extends ExprContext {
		public TerminalNode IDENT() { return getToken(WaccParser.IDENT, 0); }
		public IdentExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitIdentExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BinaryOperExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public BinaryOperContext binaryOper() {
			return getRuleContext(BinaryOperContext.class,0);
		}
		public BinaryOperExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitBinaryOperExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StringLiterExprContext extends ExprContext {
		public TerminalNode STRING_LITER() { return getToken(WaccParser.STRING_LITER, 0); }
		public StringLiterExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitStringLiterExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BoolLiterExprContext extends ExprContext {
		public BoolLiterContext boolLiter() {
			return getRuleContext(BoolLiterContext.class,0);
		}
		public BoolLiterExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitBoolLiterExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class UnaryOperExprContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public UnaryOperContext unaryOper() {
			return getRuleContext(UnaryOperContext.class,0);
		}
		public UnaryOperExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitUnaryOperExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PairLiterExprContext extends ExprContext {
		public PairLiterContext pairLiter() {
			return getRuleContext(PairLiterContext.class,0);
		}
		public PairLiterExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitPairLiterExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ArrayElemExprContext extends ExprContext {
		public ArrayElemContext arrayElem() {
			return getRuleContext(ArrayElemContext.class,0);
		}
		public ArrayElemExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitArrayElemExpr(this);
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
			setState(221);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				{
				_localctx = new UnaryOperExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(207); unaryOper();
				setState(208); expr(3);
				}
				break;
			case 2:
				{
				_localctx = new IntLiterExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(210); intLiter();
				}
				break;
			case 3:
				{
				_localctx = new BoolLiterExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(211); boolLiter();
				}
				break;
			case 4:
				{
				_localctx = new CharLiterExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(212); match(CHAR_LITER);
				}
				break;
			case 5:
				{
				_localctx = new StringLiterExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(213); match(STRING_LITER);
				}
				break;
			case 6:
				{
				_localctx = new PairLiterExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(214); pairLiter();
				}
				break;
			case 7:
				{
				_localctx = new IdentExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(215); match(IDENT);
				}
				break;
			case 8:
				{
				_localctx = new ArrayElemExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(216); arrayElem();
				}
				break;
			case 9:
				{
				_localctx = new ParanthesesExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(217); match(L_PAR);
				setState(218); expr(0);
				setState(219); match(R_PAR);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(229);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new BinaryOperExprContext(new ExprContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_expr);
					setState(223);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(224); binaryOper();
					setState(225); expr(3);
					}
					} 
				}
				setState(231);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
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
		public TerminalNode MINUS() { return getToken(WaccParser.MINUS, 0); }
		public TerminalNode NOT() { return getToken(WaccParser.NOT, 0); }
		public TerminalNode CHR() { return getToken(WaccParser.CHR, 0); }
		public TerminalNode ORD() { return getToken(WaccParser.ORD, 0); }
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
			setState(232);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NOT) | (1L << LEN) | (1L << ORD) | (1L << CHR) | (1L << MINUS))) != 0)) ) {
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
			setState(234);
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
		public TerminalNode L_SQ(int i) {
			return getToken(WaccParser.L_SQ, i);
		}
		public TerminalNode R_SQ(int i) {
			return getToken(WaccParser.R_SQ, i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> R_SQ() { return getTokens(WaccParser.R_SQ); }
		public List<TerminalNode> L_SQ() { return getTokens(WaccParser.L_SQ); }
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
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(236); match(IDENT);
			setState(241); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(237); match(L_SQ);
					setState(238); expr(0);
					setState(239); match(R_SQ);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(243); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
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
		public IntSignContext intSign() {
			return getRuleContext(IntSignContext.class,0);
		}
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
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(248);
			_la = _input.LA(1);
			if (_la==PLUS || _la==MINUS) {
				{
				setState(247); intSign();
				}
			}

			setState(250); match(INTEGER);
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
			setState(252);
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
			setState(254); match(L_SQ);
			setState(256);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TRUE) | (1L << FALSE) | (1L << NULL) | (1L << L_PAR) | (1L << NOT) | (1L << LEN) | (1L << ORD) | (1L << CHR) | (1L << PLUS) | (1L << MINUS) | (1L << IDENT) | (1L << INTEGER) | (1L << STRING_LITER) | (1L << CHAR_LITER))) != 0)) {
				{
				setState(255); argList();
				}
			}

			setState(258); match(R_SQ);
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
			setState(260); match(NULL);
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
		case 11: return arrayType_sempred((ArrayTypeContext)_localctx, predIndex);
		case 14: return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean arrayType_sempred(ArrayTypeContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1: return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2: return precpred(_ctx, 2);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3@\u0109\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\3\2\3\2\7"+
		"\2\63\n\2\f\2\16\2\66\13\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\4\3\4\3\4\7\4H\n\4\f\4\16\4K\13\4\5\4M\n\4\3\5\3\5\3\5\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\5\6{\n\6\3\6\3\6\3\6\7\6\u0080\n\6\f\6\16\6\u0083"+
		"\13\6\3\7\3\7\3\7\5\7\u0088\n\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\5\b\u0098\n\b\3\b\5\b\u009b\n\b\3\t\3\t\3\t\7\t\u00a0"+
		"\n\t\f\t\16\t\u00a3\13\t\3\n\3\n\3\n\3\n\5\n\u00a9\n\n\3\13\3\13\3\13"+
		"\5\13\u00ae\n\13\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u00bb"+
		"\n\r\3\r\3\r\3\r\7\r\u00c0\n\r\f\r\16\r\u00c3\13\r\3\16\3\16\3\16\5\16"+
		"\u00c8\n\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u00e0\n\20\3\20"+
		"\3\20\3\20\3\20\7\20\u00e6\n\20\f\20\16\20\u00e9\13\20\3\21\3\21\3\22"+
		"\3\22\3\23\3\23\3\23\3\23\3\23\6\23\u00f4\n\23\r\23\16\23\u00f5\3\24\3"+
		"\24\3\25\5\25\u00fb\n\25\3\25\3\25\3\26\3\26\3\27\3\27\5\27\u0103\n\27"+
		"\3\27\3\27\3\30\3\30\3\30\2\5\n\30\36\31\2\4\6\b\n\f\16\20\22\24\26\30"+
		"\32\34\36 \"$&(*,.\2\7\3\2\32\35\4\2*-\62\62\3\2.:\3\2\61\62\3\2\37 \u011b"+
		"\2\60\3\2\2\2\4;\3\2\2\2\6L\3\2\2\2\bN\3\2\2\2\nz\3\2\2\2\f\u0087\3\2"+
		"\2\2\16\u009a\3\2\2\2\20\u009c\3\2\2\2\22\u00a8\3\2\2\2\24\u00ad\3\2\2"+
		"\2\26\u00af\3\2\2\2\30\u00ba\3\2\2\2\32\u00c7\3\2\2\2\34\u00c9\3\2\2\2"+
		"\36\u00df\3\2\2\2 \u00ea\3\2\2\2\"\u00ec\3\2\2\2$\u00ee\3\2\2\2&\u00f7"+
		"\3\2\2\2(\u00fa\3\2\2\2*\u00fe\3\2\2\2,\u0100\3\2\2\2.\u0106\3\2\2\2\60"+
		"\64\7\5\2\2\61\63\5\4\3\2\62\61\3\2\2\2\63\66\3\2\2\2\64\62\3\2\2\2\64"+
		"\65\3\2\2\2\65\67\3\2\2\2\66\64\3\2\2\2\678\5\n\6\289\7\7\2\29:\7\2\2"+
		"\3:\3\3\2\2\2;<\5\24\13\2<=\7;\2\2=>\7\"\2\2>?\5\6\4\2?@\7#\2\2@A\7\6"+
		"\2\2AB\5\n\6\2BC\7\7\2\2C\5\3\2\2\2DI\5\b\5\2EF\7&\2\2FH\5\b\5\2GE\3\2"+
		"\2\2HK\3\2\2\2IG\3\2\2\2IJ\3\2\2\2JM\3\2\2\2KI\3\2\2\2LD\3\2\2\2LM\3\2"+
		"\2\2M\7\3\2\2\2NO\5\24\13\2OP\7;\2\2P\t\3\2\2\2QR\b\6\1\2R{\7\b\2\2ST"+
		"\5\24\13\2TU\7;\2\2UV\7\'\2\2VW\5\16\b\2W{\3\2\2\2XY\5\f\7\2YZ\7\'\2\2"+
		"Z[\5\16\b\2[{\3\2\2\2\\]\7\t\2\2]{\5\f\7\2^_\7\n\2\2_{\5\36\20\2`a\7\13"+
		"\2\2a{\5\36\20\2bc\7\f\2\2c{\5\36\20\2de\7\r\2\2e{\5\36\20\2fg\7\16\2"+
		"\2g{\5\36\20\2hi\7\17\2\2ij\5\36\20\2jk\7\20\2\2kl\5\n\6\2lm\7\21\2\2"+
		"mn\5\n\6\2no\7\22\2\2o{\3\2\2\2pq\7\23\2\2qr\5\36\20\2rs\7\24\2\2st\5"+
		"\n\6\2tu\7\25\2\2u{\3\2\2\2vw\7\5\2\2wx\5\n\6\2xy\7\7\2\2y{\3\2\2\2zQ"+
		"\3\2\2\2zS\3\2\2\2zX\3\2\2\2z\\\3\2\2\2z^\3\2\2\2z`\3\2\2\2zb\3\2\2\2"+
		"zd\3\2\2\2zf\3\2\2\2zh\3\2\2\2zp\3\2\2\2zv\3\2\2\2{\u0081\3\2\2\2|}\f"+
		"\3\2\2}~\7\4\2\2~\u0080\5\n\6\4\177|\3\2\2\2\u0080\u0083\3\2\2\2\u0081"+
		"\177\3\2\2\2\u0081\u0082\3\2\2\2\u0082\13\3\2\2\2\u0083\u0081\3\2\2\2"+
		"\u0084\u0088\7;\2\2\u0085\u0088\5$\23\2\u0086\u0088\5\22\n\2\u0087\u0084"+
		"\3\2\2\2\u0087\u0085\3\2\2\2\u0087\u0086\3\2\2\2\u0088\r\3\2\2\2\u0089"+
		"\u009b\5\36\20\2\u008a\u009b\5,\27\2\u008b\u008c\7\26\2\2\u008c\u008d"+
		"\7\"\2\2\u008d\u008e\5\36\20\2\u008e\u008f\7&\2\2\u008f\u0090\5\36\20"+
		"\2\u0090\u0091\7#\2\2\u0091\u009b\3\2\2\2\u0092\u009b\5\22\n\2\u0093\u0094"+
		"\7\27\2\2\u0094\u0095\7;\2\2\u0095\u0097\7\"\2\2\u0096\u0098\5\20\t\2"+
		"\u0097\u0096\3\2\2\2\u0097\u0098\3\2\2\2\u0098\u0099\3\2\2\2\u0099\u009b"+
		"\7#\2\2\u009a\u0089\3\2\2\2\u009a\u008a\3\2\2\2\u009a\u008b\3\2\2\2\u009a"+
		"\u0092\3\2\2\2\u009a\u0093\3\2\2\2\u009b\17\3\2\2\2\u009c\u00a1\5\36\20"+
		"\2\u009d\u009e\7&\2\2\u009e\u00a0\5\36\20\2\u009f\u009d\3\2\2\2\u00a0"+
		"\u00a3\3\2\2\2\u00a1\u009f\3\2\2\2\u00a1\u00a2\3\2\2\2\u00a2\21\3\2\2"+
		"\2\u00a3\u00a1\3\2\2\2\u00a4\u00a5\7\30\2\2\u00a5\u00a9\5\36\20\2\u00a6"+
		"\u00a7\7\31\2\2\u00a7\u00a9\5\36\20\2\u00a8\u00a4\3\2\2\2\u00a8\u00a6"+
		"\3\2\2\2\u00a9\23\3\2\2\2\u00aa\u00ae\5\26\f\2\u00ab\u00ae\5\30\r\2\u00ac"+
		"\u00ae\5\34\17\2\u00ad\u00aa\3\2\2\2\u00ad\u00ab\3\2\2\2\u00ad\u00ac\3"+
		"\2\2\2\u00ae\25\3\2\2\2\u00af\u00b0\t\2\2\2\u00b0\27\3\2\2\2\u00b1\u00b2"+
		"\b\r\1\2\u00b2\u00b3\5\26\f\2\u00b3\u00b4\7$\2\2\u00b4\u00b5\7%\2\2\u00b5"+
		"\u00bb\3\2\2\2\u00b6\u00b7\5\34\17\2\u00b7\u00b8\7$\2\2\u00b8\u00b9\7"+
		"%\2\2\u00b9\u00bb\3\2\2\2\u00ba\u00b1\3\2\2\2\u00ba\u00b6\3\2\2\2\u00bb"+
		"\u00c1\3\2\2\2\u00bc\u00bd\f\3\2\2\u00bd\u00be\7$\2\2\u00be\u00c0\7%\2"+
		"\2\u00bf\u00bc\3\2\2\2\u00c0\u00c3\3\2\2\2\u00c1\u00bf\3\2\2\2\u00c1\u00c2"+
		"\3\2\2\2\u00c2\31\3\2\2\2\u00c3\u00c1\3\2\2\2\u00c4\u00c8\5\26\f\2\u00c5"+
		"\u00c8\5\30\r\2\u00c6\u00c8\7\36\2\2\u00c7\u00c4\3\2\2\2\u00c7\u00c5\3"+
		"\2\2\2\u00c7\u00c6\3\2\2\2\u00c8\33\3\2\2\2\u00c9\u00ca\7\36\2\2\u00ca"+
		"\u00cb\7\"\2\2\u00cb\u00cc\5\32\16\2\u00cc\u00cd\7&\2\2\u00cd\u00ce\5"+
		"\32\16\2\u00ce\u00cf\7#\2\2\u00cf\35\3\2\2\2\u00d0\u00d1\b\20\1\2\u00d1"+
		"\u00d2\5 \21\2\u00d2\u00d3\5\36\20\5\u00d3\u00e0\3\2\2\2\u00d4\u00e0\5"+
		"(\25\2\u00d5\u00e0\5*\26\2\u00d6\u00e0\7>\2\2\u00d7\u00e0\7=\2\2\u00d8"+
		"\u00e0\5.\30\2\u00d9\u00e0\7;\2\2\u00da\u00e0\5$\23\2\u00db\u00dc\7\""+
		"\2\2\u00dc\u00dd\5\36\20\2\u00dd\u00de\7#\2\2\u00de\u00e0\3\2\2\2\u00df"+
		"\u00d0\3\2\2\2\u00df\u00d4\3\2\2\2\u00df\u00d5\3\2\2\2\u00df\u00d6\3\2"+
		"\2\2\u00df\u00d7\3\2\2\2\u00df\u00d8\3\2\2\2\u00df\u00d9\3\2\2\2\u00df"+
		"\u00da\3\2\2\2\u00df\u00db\3\2\2\2\u00e0\u00e7\3\2\2\2\u00e1\u00e2\f\4"+
		"\2\2\u00e2\u00e3\5\"\22\2\u00e3\u00e4\5\36\20\5\u00e4\u00e6\3\2\2\2\u00e5"+
		"\u00e1\3\2\2\2\u00e6\u00e9\3\2\2\2\u00e7\u00e5\3\2\2\2\u00e7\u00e8\3\2"+
		"\2\2\u00e8\37\3\2\2\2\u00e9\u00e7\3\2\2\2\u00ea\u00eb\t\3\2\2\u00eb!\3"+
		"\2\2\2\u00ec\u00ed\t\4\2\2\u00ed#\3\2\2\2\u00ee\u00f3\7;\2\2\u00ef\u00f0"+
		"\7$\2\2\u00f0\u00f1\5\36\20\2\u00f1\u00f2\7%\2\2\u00f2\u00f4\3\2\2\2\u00f3"+
		"\u00ef\3\2\2\2\u00f4\u00f5\3\2\2\2\u00f5\u00f3\3\2\2\2\u00f5\u00f6\3\2"+
		"\2\2\u00f6%\3\2\2\2\u00f7\u00f8\t\5\2\2\u00f8\'\3\2\2\2\u00f9\u00fb\5"+
		"&\24\2\u00fa\u00f9\3\2\2\2\u00fa\u00fb\3\2\2\2\u00fb\u00fc\3\2\2\2\u00fc"+
		"\u00fd\7<\2\2\u00fd)\3\2\2\2\u00fe\u00ff\t\6\2\2\u00ff+\3\2\2\2\u0100"+
		"\u0102\7$\2\2\u0101\u0103\5\20\t\2\u0102\u0101\3\2\2\2\u0102\u0103\3\2"+
		"\2\2\u0103\u0104\3\2\2\2\u0104\u0105\7%\2\2\u0105-\3\2\2\2\u0106\u0107"+
		"\7!\2\2\u0107/\3\2\2\2\25\64ILz\u0081\u0087\u0097\u009a\u00a1\u00a8\u00ad"+
		"\u00ba\u00c1\u00c7\u00df\u00e7\u00f5\u00fa\u0102";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}