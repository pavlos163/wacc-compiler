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
		RULE_pairType = 13, RULE_expr = 14, RULE_intLiter = 15, RULE_intSign = 16, 
		RULE_unaryOper = 17, RULE_arrayElem = 18, RULE_boolLiter = 19, RULE_arrayLiter = 20, 
		RULE_pairLiter = 21;
	public static final String[] ruleNames = {
		"program", "func", "paramList", "param", "stat", "assignLHS", "assignRHS", 
		"argList", "pairElem", "type", "baseType", "arrayType", "pairElemType", 
		"pairType", "expr", "intLiter", "intSign", "unaryOper", "arrayElem", "boolLiter", 
		"arrayLiter", "pairLiter"
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
			setState(44); match(BEGIN);
			setState(48);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(45); func();
					}
					} 
				}
				setState(50);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			setState(51); stat(0);
			setState(52); match(END);
			setState(53); match(EOF);
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
			setState(55); type();
			setState(56); match(IDENT);
			setState(57); match(L_PAR);
			setState(58); paramList();
			setState(59); match(R_PAR);
			setState(60); match(IS);
			setState(61); stat(0);
			setState(62); match(END);
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
			setState(72);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << BOOL) | (1L << CHAR) | (1L << STRING) | (1L << PAIR))) != 0)) {
				{
				setState(64); param();
				setState(69);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(65); match(COMMA);
					setState(66); param();
					}
					}
					setState(71);
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
			setState(74); type();
			setState(75); match(IDENT);
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
	public static class IfStatContext extends StatContext {
		public TerminalNode THEN() { return getToken(WaccParser.THEN, 0); }
		public TerminalNode IF() { return getToken(WaccParser.IF, 0); }
		public TerminalNode FI() { return getToken(WaccParser.FI, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public StatContext stat() {
			return getRuleContext(StatContext.class,0);
		}
		public IfStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitIfStat(this);
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
			setState(124);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				{
				_localctx = new SkipStatContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(78); match(SKIP);
				}
				break;
			case 2:
				{
				_localctx = new AssignStatContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(79); type();
				setState(80); match(IDENT);
				setState(81); match(ASSIGN);
				setState(82); assignRHS();
				}
				break;
			case 3:
				{
				_localctx = new AssignStatContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(84); assignLHS();
				setState(85); match(ASSIGN);
				setState(86); assignRHS();
				}
				break;
			case 4:
				{
				_localctx = new ReadStatContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(88); match(READ);
				setState(89); assignLHS();
				}
				break;
			case 5:
				{
				_localctx = new FreeStatContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(90); match(FREE);
				setState(91); expr(0);
				}
				break;
			case 6:
				{
				_localctx = new ReturnStatContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(92); match(RETURN);
				setState(93); expr(0);
				}
				break;
			case 7:
				{
				_localctx = new ExitStatContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(94); match(EXIT);
				setState(95); expr(0);
				}
				break;
			case 8:
				{
				_localctx = new PrintStatContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(96); match(PRINT);
				setState(97); expr(0);
				}
				break;
			case 9:
				{
				_localctx = new PrintlnStatContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(98); match(PRINTLN);
				setState(99); expr(0);
				}
				break;
			case 10:
				{
				_localctx = new IfThenElseStatContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(100); match(IF);
				setState(101); expr(0);
				setState(102); match(THEN);
				setState(103); stat(0);
				setState(104); match(ELSE);
				setState(105); stat(0);
				setState(106); match(FI);
				}
				break;
			case 11:
				{
				_localctx = new IfStatContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(108); match(IF);
				setState(109); expr(0);
				setState(110); match(THEN);
				setState(111); stat(0);
				setState(112); match(FI);
				}
				break;
			case 12:
				{
				_localctx = new WhileStatContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(114); match(WHILE);
				setState(115); expr(0);
				setState(116); match(DO);
				setState(117); stat(0);
				setState(118); match(DONE);
				}
				break;
			case 13:
				{
				_localctx = new BeginStatContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(120); match(BEGIN);
				setState(121); stat(0);
				setState(122); match(END);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(131);
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
					setState(126);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(127); match(SEMICOLON);
					setState(128); stat(2);
					}
					} 
				}
				setState(133);
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
			setState(137);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(134); match(IDENT);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(135); arrayElem();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(136); pairElem();
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
			setState(156);
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
				setState(139); expr(0);
				}
				break;
			case L_SQ:
				enterOuterAlt(_localctx, 2);
				{
				setState(140); arrayLiter();
				}
				break;
			case NEWPAIR:
				enterOuterAlt(_localctx, 3);
				{
				setState(141); match(NEWPAIR);
				setState(142); match(L_PAR);
				setState(143); expr(0);
				setState(144); match(COMMA);
				setState(145); expr(0);
				setState(146); match(R_PAR);
				}
				break;
			case FIRST:
			case SECOND:
				enterOuterAlt(_localctx, 4);
				{
				setState(148); pairElem();
				}
				break;
			case CALL:
				enterOuterAlt(_localctx, 5);
				{
				setState(149); match(CALL);
				setState(150); match(IDENT);
				setState(151); match(L_PAR);
				setState(153);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TRUE) | (1L << FALSE) | (1L << NULL) | (1L << L_PAR) | (1L << NOT) | (1L << LEN) | (1L << ORD) | (1L << CHR) | (1L << PLUS) | (1L << MINUS) | (1L << IDENT) | (1L << INTEGER) | (1L << STRING_LITER) | (1L << CHAR_LITER))) != 0)) {
					{
					setState(152); argList();
					}
				}

				setState(155); match(R_PAR);
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
			setState(158); expr(0);
			setState(163);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(159); match(COMMA);
				setState(160); expr(0);
				}
				}
				setState(165);
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
			setState(170);
			switch (_input.LA(1)) {
			case FIRST:
				enterOuterAlt(_localctx, 1);
				{
				setState(166); match(FIRST);
				setState(167); expr(0);
				}
				break;
			case SECOND:
				enterOuterAlt(_localctx, 2);
				{
				setState(168); match(SECOND);
				setState(169); expr(0);
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
			setState(175);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(172); baseType();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(173); arrayType(0);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(174); pairType();
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
			setState(177);
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
			setState(188);
			switch (_input.LA(1)) {
			case INT:
			case BOOL:
			case CHAR:
			case STRING:
				{
				setState(180); baseType();
				setState(181); match(L_SQ);
				setState(182); match(R_SQ);
				}
				break;
			case PAIR:
				{
				setState(184); pairType();
				setState(185); match(L_SQ);
				setState(186); match(R_SQ);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(195);
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
					setState(190);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(191); match(L_SQ);
					setState(192); match(R_SQ);
					}
					} 
				}
				setState(197);
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
			setState(201);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(198); baseType();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(199); arrayType(0);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(200); match(PAIR);
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
			setState(203); match(PAIR);
			setState(204); match(L_PAR);
			setState(205); pairElemType();
			setState(206); match(COMMA);
			setState(207); pairElemType();
			setState(208); match(R_PAR);
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
		public TerminalNode MUL() { return getToken(WaccParser.MUL, 0); }
		public TerminalNode LESS_OR_EQUAL() { return getToken(WaccParser.LESS_OR_EQUAL, 0); }
		public TerminalNode AND() { return getToken(WaccParser.AND, 0); }
		public TerminalNode OR() { return getToken(WaccParser.OR, 0); }
		public TerminalNode MINUS() { return getToken(WaccParser.MINUS, 0); }
		public TerminalNode EQUAL() { return getToken(WaccParser.EQUAL, 0); }
		public TerminalNode NOT_EQUAL() { return getToken(WaccParser.NOT_EQUAL, 0); }
		public TerminalNode DIV() { return getToken(WaccParser.DIV, 0); }
		public TerminalNode GREATER_OR_EQUAL() { return getToken(WaccParser.GREATER_OR_EQUAL, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public TerminalNode LESS() { return getToken(WaccParser.LESS, 0); }
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode PLUS() { return getToken(WaccParser.PLUS, 0); }
		public TerminalNode GREATER() { return getToken(WaccParser.GREATER, 0); }
		public TerminalNode MOD() { return getToken(WaccParser.MOD, 0); }
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
			setState(225);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				{
				_localctx = new UnaryOperExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(211); unaryOper();
				setState(212); expr(15);
				}
				break;
			case 2:
				{
				_localctx = new IntLiterExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(214); intLiter();
				}
				break;
			case 3:
				{
				_localctx = new BoolLiterExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(215); boolLiter();
				}
				break;
			case 4:
				{
				_localctx = new CharLiterExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(216); match(CHAR_LITER);
				}
				break;
			case 5:
				{
				_localctx = new StringLiterExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(217); match(STRING_LITER);
				}
				break;
			case 6:
				{
				_localctx = new PairLiterExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(218); pairLiter();
				}
				break;
			case 7:
				{
				_localctx = new IdentExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(219); match(IDENT);
				}
				break;
			case 8:
				{
				_localctx = new ArrayElemExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(220); arrayElem();
				}
				break;
			case 9:
				{
				_localctx = new ParanthesesExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(221); match(L_PAR);
				setState(222); expr(0);
				setState(223); match(R_PAR);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(268);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(266);
					switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
					case 1:
						{
						_localctx = new BinaryOperExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(227);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(228); match(MUL);
						setState(229); expr(15);
						}
						break;
					case 2:
						{
						_localctx = new BinaryOperExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(230);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(231); match(DIV);
						setState(232); expr(14);
						}
						break;
					case 3:
						{
						_localctx = new BinaryOperExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(233);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(234); match(MOD);
						setState(235); expr(13);
						}
						break;
					case 4:
						{
						_localctx = new BinaryOperExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(236);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(237); match(PLUS);
						setState(238); expr(12);
						}
						break;
					case 5:
						{
						_localctx = new BinaryOperExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(239);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(240); match(MINUS);
						setState(241); expr(11);
						}
						break;
					case 6:
						{
						_localctx = new BinaryOperExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(242);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(243); match(GREATER);
						setState(244); expr(10);
						}
						break;
					case 7:
						{
						_localctx = new BinaryOperExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(245);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(246); match(GREATER_OR_EQUAL);
						setState(247); expr(9);
						}
						break;
					case 8:
						{
						_localctx = new BinaryOperExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(248);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(249); match(LESS);
						setState(250); expr(8);
						}
						break;
					case 9:
						{
						_localctx = new BinaryOperExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(251);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(252); match(LESS_OR_EQUAL);
						setState(253); expr(7);
						}
						break;
					case 10:
						{
						_localctx = new BinaryOperExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(254);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(255); match(EQUAL);
						setState(256); expr(6);
						}
						break;
					case 11:
						{
						_localctx = new BinaryOperExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(257);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(258); match(NOT_EQUAL);
						setState(259); expr(5);
						}
						break;
					case 12:
						{
						_localctx = new BinaryOperExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(260);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(261); match(AND);
						setState(262); expr(4);
						}
						break;
					case 13:
						{
						_localctx = new BinaryOperExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(263);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(264); match(OR);
						setState(265); expr(3);
						}
						break;
					}
					} 
				}
				setState(270);
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
		enterRule(_localctx, 30, RULE_intLiter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(272);
			_la = _input.LA(1);
			if (_la==PLUS || _la==MINUS) {
				{
				setState(271); intSign();
				}
			}

			setState(274); match(INTEGER);
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
		enterRule(_localctx, 32, RULE_intSign);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(276);
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
		enterRule(_localctx, 34, RULE_unaryOper);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(278);
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
		enterRule(_localctx, 36, RULE_arrayElem);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(280); match(IDENT);
			setState(285); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(281); match(L_SQ);
					setState(282); expr(0);
					setState(283); match(R_SQ);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(287); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
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
		enterRule(_localctx, 38, RULE_boolLiter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(289);
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
		enterRule(_localctx, 40, RULE_arrayLiter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(291); match(L_SQ);
			setState(293);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TRUE) | (1L << FALSE) | (1L << NULL) | (1L << L_PAR) | (1L << NOT) | (1L << LEN) | (1L << ORD) | (1L << CHR) | (1L << PLUS) | (1L << MINUS) | (1L << IDENT) | (1L << INTEGER) | (1L << STRING_LITER) | (1L << CHAR_LITER))) != 0)) {
				{
				setState(292); argList();
				}
			}

			setState(295); match(R_SQ);
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
		enterRule(_localctx, 42, RULE_pairLiter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(297); match(NULL);
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
		case 2: return precpred(_ctx, 14);
		case 3: return precpred(_ctx, 13);
		case 4: return precpred(_ctx, 12);
		case 5: return precpred(_ctx, 11);
		case 6: return precpred(_ctx, 10);
		case 7: return precpred(_ctx, 9);
		case 8: return precpred(_ctx, 8);
		case 9: return precpred(_ctx, 7);
		case 10: return precpred(_ctx, 6);
		case 11: return precpred(_ctx, 5);
		case 12: return precpred(_ctx, 4);
		case 13: return precpred(_ctx, 3);
		case 14: return precpred(_ctx, 2);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3@\u012e\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\3\2\3\2\7\2\61\n\2"+
		"\f\2\16\2\64\13\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\4\3\4\3\4\7\4F\n\4\f\4\16\4I\13\4\5\4K\n\4\3\5\3\5\3\5\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6\177\n\6\3\6\3\6\3\6\7\6\u0084"+
		"\n\6\f\6\16\6\u0087\13\6\3\7\3\7\3\7\5\7\u008c\n\7\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b\u009c\n\b\3\b\5\b\u009f\n\b\3"+
		"\t\3\t\3\t\7\t\u00a4\n\t\f\t\16\t\u00a7\13\t\3\n\3\n\3\n\3\n\5\n\u00ad"+
		"\n\n\3\13\3\13\3\13\5\13\u00b2\n\13\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\5\r\u00bf\n\r\3\r\3\r\3\r\7\r\u00c4\n\r\f\r\16\r\u00c7\13\r"+
		"\3\16\3\16\3\16\5\16\u00cc\n\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\5\20\u00e4\n\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\7\20\u010d\n\20\f\20\16\20\u0110\13\20\3\21\5\21\u0113\n\21\3\21\3\21"+
		"\3\22\3\22\3\23\3\23\3\24\3\24\3\24\3\24\3\24\6\24\u0120\n\24\r\24\16"+
		"\24\u0121\3\25\3\25\3\26\3\26\5\26\u0128\n\26\3\26\3\26\3\27\3\27\3\27"+
		"\2\5\n\30\36\30\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,\2\6\3\2"+
		"\32\35\3\2\61\62\4\2*-\62\62\3\2\37 \u014e\2.\3\2\2\2\49\3\2\2\2\6J\3"+
		"\2\2\2\bL\3\2\2\2\n~\3\2\2\2\f\u008b\3\2\2\2\16\u009e\3\2\2\2\20\u00a0"+
		"\3\2\2\2\22\u00ac\3\2\2\2\24\u00b1\3\2\2\2\26\u00b3\3\2\2\2\30\u00be\3"+
		"\2\2\2\32\u00cb\3\2\2\2\34\u00cd\3\2\2\2\36\u00e3\3\2\2\2 \u0112\3\2\2"+
		"\2\"\u0116\3\2\2\2$\u0118\3\2\2\2&\u011a\3\2\2\2(\u0123\3\2\2\2*\u0125"+
		"\3\2\2\2,\u012b\3\2\2\2.\62\7\5\2\2/\61\5\4\3\2\60/\3\2\2\2\61\64\3\2"+
		"\2\2\62\60\3\2\2\2\62\63\3\2\2\2\63\65\3\2\2\2\64\62\3\2\2\2\65\66\5\n"+
		"\6\2\66\67\7\7\2\2\678\7\2\2\38\3\3\2\2\29:\5\24\13\2:;\7;\2\2;<\7\"\2"+
		"\2<=\5\6\4\2=>\7#\2\2>?\7\6\2\2?@\5\n\6\2@A\7\7\2\2A\5\3\2\2\2BG\5\b\5"+
		"\2CD\7&\2\2DF\5\b\5\2EC\3\2\2\2FI\3\2\2\2GE\3\2\2\2GH\3\2\2\2HK\3\2\2"+
		"\2IG\3\2\2\2JB\3\2\2\2JK\3\2\2\2K\7\3\2\2\2LM\5\24\13\2MN\7;\2\2N\t\3"+
		"\2\2\2OP\b\6\1\2P\177\7\b\2\2QR\5\24\13\2RS\7;\2\2ST\7\'\2\2TU\5\16\b"+
		"\2U\177\3\2\2\2VW\5\f\7\2WX\7\'\2\2XY\5\16\b\2Y\177\3\2\2\2Z[\7\t\2\2"+
		"[\177\5\f\7\2\\]\7\n\2\2]\177\5\36\20\2^_\7\13\2\2_\177\5\36\20\2`a\7"+
		"\f\2\2a\177\5\36\20\2bc\7\r\2\2c\177\5\36\20\2de\7\16\2\2e\177\5\36\20"+
		"\2fg\7\17\2\2gh\5\36\20\2hi\7\20\2\2ij\5\n\6\2jk\7\21\2\2kl\5\n\6\2lm"+
		"\7\22\2\2m\177\3\2\2\2no\7\17\2\2op\5\36\20\2pq\7\20\2\2qr\5\n\6\2rs\7"+
		"\22\2\2s\177\3\2\2\2tu\7\23\2\2uv\5\36\20\2vw\7\24\2\2wx\5\n\6\2xy\7\25"+
		"\2\2y\177\3\2\2\2z{\7\5\2\2{|\5\n\6\2|}\7\7\2\2}\177\3\2\2\2~O\3\2\2\2"+
		"~Q\3\2\2\2~V\3\2\2\2~Z\3\2\2\2~\\\3\2\2\2~^\3\2\2\2~`\3\2\2\2~b\3\2\2"+
		"\2~d\3\2\2\2~f\3\2\2\2~n\3\2\2\2~t\3\2\2\2~z\3\2\2\2\177\u0085\3\2\2\2"+
		"\u0080\u0081\f\3\2\2\u0081\u0082\7\4\2\2\u0082\u0084\5\n\6\4\u0083\u0080"+
		"\3\2\2\2\u0084\u0087\3\2\2\2\u0085\u0083\3\2\2\2\u0085\u0086\3\2\2\2\u0086"+
		"\13\3\2\2\2\u0087\u0085\3\2\2\2\u0088\u008c\7;\2\2\u0089\u008c\5&\24\2"+
		"\u008a\u008c\5\22\n\2\u008b\u0088\3\2\2\2\u008b\u0089\3\2\2\2\u008b\u008a"+
		"\3\2\2\2\u008c\r\3\2\2\2\u008d\u009f\5\36\20\2\u008e\u009f\5*\26\2\u008f"+
		"\u0090\7\26\2\2\u0090\u0091\7\"\2\2\u0091\u0092\5\36\20\2\u0092\u0093"+
		"\7&\2\2\u0093\u0094\5\36\20\2\u0094\u0095\7#\2\2\u0095\u009f\3\2\2\2\u0096"+
		"\u009f\5\22\n\2\u0097\u0098\7\27\2\2\u0098\u0099\7;\2\2\u0099\u009b\7"+
		"\"\2\2\u009a\u009c\5\20\t\2\u009b\u009a\3\2\2\2\u009b\u009c\3\2\2\2\u009c"+
		"\u009d\3\2\2\2\u009d\u009f\7#\2\2\u009e\u008d\3\2\2\2\u009e\u008e\3\2"+
		"\2\2\u009e\u008f\3\2\2\2\u009e\u0096\3\2\2\2\u009e\u0097\3\2\2\2\u009f"+
		"\17\3\2\2\2\u00a0\u00a5\5\36\20\2\u00a1\u00a2\7&\2\2\u00a2\u00a4\5\36"+
		"\20\2\u00a3\u00a1\3\2\2\2\u00a4\u00a7\3\2\2\2\u00a5\u00a3\3\2\2\2\u00a5"+
		"\u00a6\3\2\2\2\u00a6\21\3\2\2\2\u00a7\u00a5\3\2\2\2\u00a8\u00a9\7\30\2"+
		"\2\u00a9\u00ad\5\36\20\2\u00aa\u00ab\7\31\2\2\u00ab\u00ad\5\36\20\2\u00ac"+
		"\u00a8\3\2\2\2\u00ac\u00aa\3\2\2\2\u00ad\23\3\2\2\2\u00ae\u00b2\5\26\f"+
		"\2\u00af\u00b2\5\30\r\2\u00b0\u00b2\5\34\17\2\u00b1\u00ae\3\2\2\2\u00b1"+
		"\u00af\3\2\2\2\u00b1\u00b0\3\2\2\2\u00b2\25\3\2\2\2\u00b3\u00b4\t\2\2"+
		"\2\u00b4\27\3\2\2\2\u00b5\u00b6\b\r\1\2\u00b6\u00b7\5\26\f\2\u00b7\u00b8"+
		"\7$\2\2\u00b8\u00b9\7%\2\2\u00b9\u00bf\3\2\2\2\u00ba\u00bb\5\34\17\2\u00bb"+
		"\u00bc\7$\2\2\u00bc\u00bd\7%\2\2\u00bd\u00bf\3\2\2\2\u00be\u00b5\3\2\2"+
		"\2\u00be\u00ba\3\2\2\2\u00bf\u00c5\3\2\2\2\u00c0\u00c1\f\3\2\2\u00c1\u00c2"+
		"\7$\2\2\u00c2\u00c4\7%\2\2\u00c3\u00c0\3\2\2\2\u00c4\u00c7\3\2\2\2\u00c5"+
		"\u00c3\3\2\2\2\u00c5\u00c6\3\2\2\2\u00c6\31\3\2\2\2\u00c7\u00c5\3\2\2"+
		"\2\u00c8\u00cc\5\26\f\2\u00c9\u00cc\5\30\r\2\u00ca\u00cc\7\36\2\2\u00cb"+
		"\u00c8\3\2\2\2\u00cb\u00c9\3\2\2\2\u00cb\u00ca\3\2\2\2\u00cc\33\3\2\2"+
		"\2\u00cd\u00ce\7\36\2\2\u00ce\u00cf\7\"\2\2\u00cf\u00d0\5\32\16\2\u00d0"+
		"\u00d1\7&\2\2\u00d1\u00d2\5\32\16\2\u00d2\u00d3\7#\2\2\u00d3\35\3\2\2"+
		"\2\u00d4\u00d5\b\20\1\2\u00d5\u00d6\5$\23\2\u00d6\u00d7\5\36\20\21\u00d7"+
		"\u00e4\3\2\2\2\u00d8\u00e4\5 \21\2\u00d9\u00e4\5(\25\2\u00da\u00e4\7>"+
		"\2\2\u00db\u00e4\7=\2\2\u00dc\u00e4\5,\27\2\u00dd\u00e4\7;\2\2\u00de\u00e4"+
		"\5&\24\2\u00df\u00e0\7\"\2\2\u00e0\u00e1\5\36\20\2\u00e1\u00e2\7#\2\2"+
		"\u00e2\u00e4\3\2\2\2\u00e3\u00d4\3\2\2\2\u00e3\u00d8\3\2\2\2\u00e3\u00d9"+
		"\3\2\2\2\u00e3\u00da\3\2\2\2\u00e3\u00db\3\2\2\2\u00e3\u00dc\3\2\2\2\u00e3"+
		"\u00dd\3\2\2\2\u00e3\u00de\3\2\2\2\u00e3\u00df\3\2\2\2\u00e4\u010e\3\2"+
		"\2\2\u00e5\u00e6\f\20\2\2\u00e6\u00e7\7.\2\2\u00e7\u010d\5\36\20\21\u00e8"+
		"\u00e9\f\17\2\2\u00e9\u00ea\7/\2\2\u00ea\u010d\5\36\20\20\u00eb\u00ec"+
		"\f\16\2\2\u00ec\u00ed\7\60\2\2\u00ed\u010d\5\36\20\17\u00ee\u00ef\f\r"+
		"\2\2\u00ef\u00f0\7\61\2\2\u00f0\u010d\5\36\20\16\u00f1\u00f2\f\f\2\2\u00f2"+
		"\u00f3\7\62\2\2\u00f3\u010d\5\36\20\r\u00f4\u00f5\f\13\2\2\u00f5\u00f6"+
		"\7\63\2\2\u00f6\u010d\5\36\20\f\u00f7\u00f8\f\n\2\2\u00f8\u00f9\7\64\2"+
		"\2\u00f9\u010d\5\36\20\13\u00fa\u00fb\f\t\2\2\u00fb\u00fc\7\65\2\2\u00fc"+
		"\u010d\5\36\20\n\u00fd\u00fe\f\b\2\2\u00fe\u00ff\7\66\2\2\u00ff\u010d"+
		"\5\36\20\t\u0100\u0101\f\7\2\2\u0101\u0102\7\67\2\2\u0102\u010d\5\36\20"+
		"\b\u0103\u0104\f\6\2\2\u0104\u0105\78\2\2\u0105\u010d\5\36\20\7\u0106"+
		"\u0107\f\5\2\2\u0107\u0108\79\2\2\u0108\u010d\5\36\20\6\u0109\u010a\f"+
		"\4\2\2\u010a\u010b\7:\2\2\u010b\u010d\5\36\20\5\u010c\u00e5\3\2\2\2\u010c"+
		"\u00e8\3\2\2\2\u010c\u00eb\3\2\2\2\u010c\u00ee\3\2\2\2\u010c\u00f1\3\2"+
		"\2\2\u010c\u00f4\3\2\2\2\u010c\u00f7\3\2\2\2\u010c\u00fa\3\2\2\2\u010c"+
		"\u00fd\3\2\2\2\u010c\u0100\3\2\2\2\u010c\u0103\3\2\2\2\u010c\u0106\3\2"+
		"\2\2\u010c\u0109\3\2\2\2\u010d\u0110\3\2\2\2\u010e\u010c\3\2\2\2\u010e"+
		"\u010f\3\2\2\2\u010f\37\3\2\2\2\u0110\u010e\3\2\2\2\u0111\u0113\5\"\22"+
		"\2\u0112\u0111\3\2\2\2\u0112\u0113\3\2\2\2\u0113\u0114\3\2\2\2\u0114\u0115"+
		"\7<\2\2\u0115!\3\2\2\2\u0116\u0117\t\3\2\2\u0117#\3\2\2\2\u0118\u0119"+
		"\t\4\2\2\u0119%\3\2\2\2\u011a\u011f\7;\2\2\u011b\u011c\7$\2\2\u011c\u011d"+
		"\5\36\20\2\u011d\u011e\7%\2\2\u011e\u0120\3\2\2\2\u011f\u011b\3\2\2\2"+
		"\u0120\u0121\3\2\2\2\u0121\u011f\3\2\2\2\u0121\u0122\3\2\2\2\u0122\'\3"+
		"\2\2\2\u0123\u0124\t\5\2\2\u0124)\3\2\2\2\u0125\u0127\7$\2\2\u0126\u0128"+
		"\5\20\t\2\u0127\u0126\3\2\2\2\u0127\u0128\3\2\2\2\u0128\u0129\3\2\2\2"+
		"\u0129\u012a\7%\2\2\u012a+\3\2\2\2\u012b\u012c\7!\2\2\u012c-\3\2\2\2\26"+
		"\62GJ~\u0085\u008b\u009b\u009e\u00a5\u00ac\u00b1\u00be\u00c5\u00cb\u00e3"+
		"\u010c\u010e\u0112\u0121\u0127";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}