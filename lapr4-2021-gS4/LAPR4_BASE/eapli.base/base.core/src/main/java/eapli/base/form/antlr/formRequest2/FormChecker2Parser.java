// Generated from C:/Users/Pedro/Documents/lei20_21_s4_2dh_01/LAPR4_BASE/eapli.base/base.core/src/main/java/eapli/base/form/antlr/formRequest2\FormChecker2.g4 by ANTLR 4.9.1
package eapli.base.form.antlr.formRequest2;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class FormChecker2Parser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, TYPEDATE=3, TYPEINT=4, TYPESTRING=5, TYPEBOOL=6, TYPEPHONENUMBER=7, 
		TYPEPOSTALCODE=8, TYPENAME=9, TYPEADDRESS=10, DASH=11, FSLASH=12, STRING=13, 
		NEWLINE=14;
	public static final int
		RULE_lprog = 0, RULE_start = 1, RULE_allParameters = 2, RULE_parameterDate = 3, 
		RULE_parameterInt = 4, RULE_parameterBool = 5, RULE_parameterString = 6, 
		RULE_parameterAddress = 7, RULE_parameterPhoneNumber = 8, RULE_parameterPostalCode = 9, 
		RULE_parameterName = 10, RULE_stringPhrase = 11, RULE_error = 12;
	private static String[] makeRuleNames() {
		return new String[] {
			"lprog", "start", "allParameters", "parameterDate", "parameterInt", "parameterBool", 
			"parameterString", "parameterAddress", "parameterPhoneNumber", "parameterPostalCode", 
			"parameterName", "stringPhrase", "error"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "' '", "': '", null, null, null, null, null, null, null, null, 
			"'-'", "'/'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, "TYPEDATE", "TYPEINT", "TYPESTRING", "TYPEBOOL", "TYPEPHONENUMBER", 
			"TYPEPOSTALCODE", "TYPENAME", "TYPEADDRESS", "DASH", "FSLASH", "STRING", 
			"NEWLINE"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "FormChecker2.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public FormChecker2Parser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class LprogContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(FormChecker2Parser.EOF, 0); }
		public List<StartContext> start() {
			return getRuleContexts(StartContext.class);
		}
		public StartContext start(int i) {
			return getRuleContext(StartContext.class,i);
		}
		public LprogContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lprog; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FormChecker2Listener ) ((FormChecker2Listener)listener).enterLprog(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FormChecker2Listener ) ((FormChecker2Listener)listener).exitLprog(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FormChecker2Visitor ) return ((FormChecker2Visitor<? extends T>)visitor).visitLprog(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LprogContext lprog() throws RecognitionException {
		LprogContext _localctx = new LprogContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_lprog);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(27); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(26);
				start();
				}
				}
				setState(29); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << TYPEDATE) | (1L << TYPEINT) | (1L << TYPESTRING) | (1L << TYPEBOOL) | (1L << TYPEPHONENUMBER) | (1L << TYPEPOSTALCODE) | (1L << TYPENAME) | (1L << TYPEADDRESS) | (1L << DASH) | (1L << FSLASH) | (1L << STRING) | (1L << NEWLINE))) != 0) );
			setState(31);
			match(EOF);
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

	public static class StartContext extends ParserRuleContext {
		public AllParametersContext allParameters() {
			return getRuleContext(AllParametersContext.class,0);
		}
		public TerminalNode NEWLINE() { return getToken(FormChecker2Parser.NEWLINE, 0); }
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FormChecker2Listener ) ((FormChecker2Listener)listener).enterStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FormChecker2Listener ) ((FormChecker2Listener)listener).exitStart(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FormChecker2Visitor ) return ((FormChecker2Visitor<? extends T>)visitor).visitStart(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_start);
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(33);
			allParameters();
			setState(34);
			match(NEWLINE);
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

	public static class AllParametersContext extends ParserRuleContext {
		public ParameterDateContext parameterDate() {
			return getRuleContext(ParameterDateContext.class,0);
		}
		public ParameterStringContext parameterString() {
			return getRuleContext(ParameterStringContext.class,0);
		}
		public ParameterIntContext parameterInt() {
			return getRuleContext(ParameterIntContext.class,0);
		}
		public ParameterBoolContext parameterBool() {
			return getRuleContext(ParameterBoolContext.class,0);
		}
		public ParameterPhoneNumberContext parameterPhoneNumber() {
			return getRuleContext(ParameterPhoneNumberContext.class,0);
		}
		public ParameterPostalCodeContext parameterPostalCode() {
			return getRuleContext(ParameterPostalCodeContext.class,0);
		}
		public ParameterNameContext parameterName() {
			return getRuleContext(ParameterNameContext.class,0);
		}
		public ParameterAddressContext parameterAddress() {
			return getRuleContext(ParameterAddressContext.class,0);
		}
		public ErrorContext error() {
			return getRuleContext(ErrorContext.class,0);
		}
		public AllParametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_allParameters; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FormChecker2Listener ) ((FormChecker2Listener)listener).enterAllParameters(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FormChecker2Listener ) ((FormChecker2Listener)listener).exitAllParameters(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FormChecker2Visitor ) return ((FormChecker2Visitor<? extends T>)visitor).visitAllParameters(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AllParametersContext allParameters() throws RecognitionException {
		AllParametersContext _localctx = new AllParametersContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_allParameters);
		try {
			setState(45);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(36);
				parameterDate();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(37);
				parameterString();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(38);
				parameterInt();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(39);
				parameterBool();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(40);
				parameterPhoneNumber();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(41);
				parameterPostalCode();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(42);
				parameterName();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(43);
				parameterAddress();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(44);
				error();
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

	public static class ParameterDateContext extends ParserRuleContext {
		public TerminalNode TYPEDATE() { return getToken(FormChecker2Parser.TYPEDATE, 0); }
		public List<TerminalNode> STRING() { return getTokens(FormChecker2Parser.STRING); }
		public TerminalNode STRING(int i) {
			return getToken(FormChecker2Parser.STRING, i);
		}
		public List<TerminalNode> FSLASH() { return getTokens(FormChecker2Parser.FSLASH); }
		public TerminalNode FSLASH(int i) {
			return getToken(FormChecker2Parser.FSLASH, i);
		}
		public ParameterDateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameterDate; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FormChecker2Listener ) ((FormChecker2Listener)listener).enterParameterDate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FormChecker2Listener ) ((FormChecker2Listener)listener).exitParameterDate(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FormChecker2Visitor ) return ((FormChecker2Visitor<? extends T>)visitor).visitParameterDate(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParameterDateContext parameterDate() throws RecognitionException {
		ParameterDateContext _localctx = new ParameterDateContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_parameterDate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(47);
			match(TYPEDATE);
			setState(48);
			match(T__0);
			setState(49);
			match(STRING);
			setState(50);
			match(T__1);
			setState(57);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NEWLINE:
				{
				}
				break;
			case STRING:
				{
				setState(52);
				match(STRING);
				setState(53);
				match(FSLASH);
				setState(54);
				match(STRING);
				setState(55);
				match(FSLASH);
				setState(56);
				match(STRING);
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class ParameterIntContext extends ParserRuleContext {
		public TerminalNode TYPEINT() { return getToken(FormChecker2Parser.TYPEINT, 0); }
		public List<TerminalNode> STRING() { return getTokens(FormChecker2Parser.STRING); }
		public TerminalNode STRING(int i) {
			return getToken(FormChecker2Parser.STRING, i);
		}
		public ParameterIntContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameterInt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FormChecker2Listener ) ((FormChecker2Listener)listener).enterParameterInt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FormChecker2Listener ) ((FormChecker2Listener)listener).exitParameterInt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FormChecker2Visitor ) return ((FormChecker2Visitor<? extends T>)visitor).visitParameterInt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParameterIntContext parameterInt() throws RecognitionException {
		ParameterIntContext _localctx = new ParameterIntContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_parameterInt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(59);
			match(TYPEINT);
			setState(60);
			match(T__0);
			setState(61);
			match(STRING);
			setState(62);
			match(T__1);
			setState(65);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NEWLINE:
				{
				}
				break;
			case STRING:
				{
				setState(64);
				match(STRING);
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class ParameterBoolContext extends ParserRuleContext {
		public TerminalNode TYPEBOOL() { return getToken(FormChecker2Parser.TYPEBOOL, 0); }
		public List<TerminalNode> STRING() { return getTokens(FormChecker2Parser.STRING); }
		public TerminalNode STRING(int i) {
			return getToken(FormChecker2Parser.STRING, i);
		}
		public ParameterBoolContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameterBool; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FormChecker2Listener ) ((FormChecker2Listener)listener).enterParameterBool(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FormChecker2Listener ) ((FormChecker2Listener)listener).exitParameterBool(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FormChecker2Visitor ) return ((FormChecker2Visitor<? extends T>)visitor).visitParameterBool(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParameterBoolContext parameterBool() throws RecognitionException {
		ParameterBoolContext _localctx = new ParameterBoolContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_parameterBool);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(67);
			match(TYPEBOOL);
			setState(68);
			match(T__0);
			setState(69);
			match(STRING);
			setState(70);
			match(T__1);
			setState(73);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NEWLINE:
				{
				}
				break;
			case STRING:
				{
				setState(72);
				match(STRING);
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class ParameterStringContext extends ParserRuleContext {
		public TerminalNode TYPESTRING() { return getToken(FormChecker2Parser.TYPESTRING, 0); }
		public TerminalNode STRING() { return getToken(FormChecker2Parser.STRING, 0); }
		public StringPhraseContext stringPhrase() {
			return getRuleContext(StringPhraseContext.class,0);
		}
		public ParameterStringContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameterString; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FormChecker2Listener ) ((FormChecker2Listener)listener).enterParameterString(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FormChecker2Listener ) ((FormChecker2Listener)listener).exitParameterString(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FormChecker2Visitor ) return ((FormChecker2Visitor<? extends T>)visitor).visitParameterString(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParameterStringContext parameterString() throws RecognitionException {
		ParameterStringContext _localctx = new ParameterStringContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_parameterString);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(75);
			match(TYPESTRING);
			setState(76);
			match(T__0);
			setState(77);
			match(STRING);
			setState(78);
			match(T__1);
			setState(81);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NEWLINE:
				{
				}
				break;
			case STRING:
				{
				setState(80);
				stringPhrase();
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class ParameterAddressContext extends ParserRuleContext {
		public TerminalNode TYPEADDRESS() { return getToken(FormChecker2Parser.TYPEADDRESS, 0); }
		public TerminalNode STRING() { return getToken(FormChecker2Parser.STRING, 0); }
		public StringPhraseContext stringPhrase() {
			return getRuleContext(StringPhraseContext.class,0);
		}
		public ParameterAddressContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameterAddress; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FormChecker2Listener ) ((FormChecker2Listener)listener).enterParameterAddress(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FormChecker2Listener ) ((FormChecker2Listener)listener).exitParameterAddress(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FormChecker2Visitor ) return ((FormChecker2Visitor<? extends T>)visitor).visitParameterAddress(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParameterAddressContext parameterAddress() throws RecognitionException {
		ParameterAddressContext _localctx = new ParameterAddressContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_parameterAddress);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(83);
			match(TYPEADDRESS);
			setState(84);
			match(T__0);
			setState(85);
			match(STRING);
			setState(86);
			match(T__1);
			setState(89);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NEWLINE:
				{
				}
				break;
			case STRING:
				{
				setState(88);
				stringPhrase();
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class ParameterPhoneNumberContext extends ParserRuleContext {
		public TerminalNode TYPEPHONENUMBER() { return getToken(FormChecker2Parser.TYPEPHONENUMBER, 0); }
		public List<TerminalNode> STRING() { return getTokens(FormChecker2Parser.STRING); }
		public TerminalNode STRING(int i) {
			return getToken(FormChecker2Parser.STRING, i);
		}
		public ParameterPhoneNumberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameterPhoneNumber; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FormChecker2Listener ) ((FormChecker2Listener)listener).enterParameterPhoneNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FormChecker2Listener ) ((FormChecker2Listener)listener).exitParameterPhoneNumber(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FormChecker2Visitor ) return ((FormChecker2Visitor<? extends T>)visitor).visitParameterPhoneNumber(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParameterPhoneNumberContext parameterPhoneNumber() throws RecognitionException {
		ParameterPhoneNumberContext _localctx = new ParameterPhoneNumberContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_parameterPhoneNumber);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(91);
			match(TYPEPHONENUMBER);
			setState(92);
			match(T__0);
			setState(93);
			match(STRING);
			setState(94);
			match(T__1);
			setState(97);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NEWLINE:
				{
				}
				break;
			case STRING:
				{
				setState(96);
				match(STRING);
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class ParameterPostalCodeContext extends ParserRuleContext {
		public TerminalNode TYPEPOSTALCODE() { return getToken(FormChecker2Parser.TYPEPOSTALCODE, 0); }
		public List<TerminalNode> STRING() { return getTokens(FormChecker2Parser.STRING); }
		public TerminalNode STRING(int i) {
			return getToken(FormChecker2Parser.STRING, i);
		}
		public TerminalNode DASH() { return getToken(FormChecker2Parser.DASH, 0); }
		public ParameterPostalCodeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameterPostalCode; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FormChecker2Listener ) ((FormChecker2Listener)listener).enterParameterPostalCode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FormChecker2Listener ) ((FormChecker2Listener)listener).exitParameterPostalCode(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FormChecker2Visitor ) return ((FormChecker2Visitor<? extends T>)visitor).visitParameterPostalCode(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParameterPostalCodeContext parameterPostalCode() throws RecognitionException {
		ParameterPostalCodeContext _localctx = new ParameterPostalCodeContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_parameterPostalCode);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(99);
			match(TYPEPOSTALCODE);
			setState(100);
			match(T__0);
			setState(101);
			match(STRING);
			setState(102);
			match(T__1);
			setState(107);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NEWLINE:
				{
				}
				break;
			case STRING:
				{
				setState(104);
				match(STRING);
				setState(105);
				match(DASH);
				setState(106);
				match(STRING);
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class ParameterNameContext extends ParserRuleContext {
		public TerminalNode TYPENAME() { return getToken(FormChecker2Parser.TYPENAME, 0); }
		public TerminalNode STRING() { return getToken(FormChecker2Parser.STRING, 0); }
		public StringPhraseContext stringPhrase() {
			return getRuleContext(StringPhraseContext.class,0);
		}
		public ParameterNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameterName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FormChecker2Listener ) ((FormChecker2Listener)listener).enterParameterName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FormChecker2Listener ) ((FormChecker2Listener)listener).exitParameterName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FormChecker2Visitor ) return ((FormChecker2Visitor<? extends T>)visitor).visitParameterName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParameterNameContext parameterName() throws RecognitionException {
		ParameterNameContext _localctx = new ParameterNameContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_parameterName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(109);
			match(TYPENAME);
			setState(110);
			match(T__0);
			setState(111);
			match(STRING);
			setState(112);
			match(T__1);
			setState(115);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NEWLINE:
				{
				}
				break;
			case STRING:
				{
				setState(114);
				stringPhrase();
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class StringPhraseContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(FormChecker2Parser.STRING, 0); }
		public StringPhraseContext stringPhrase() {
			return getRuleContext(StringPhraseContext.class,0);
		}
		public StringPhraseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stringPhrase; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FormChecker2Listener ) ((FormChecker2Listener)listener).enterStringPhrase(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FormChecker2Listener ) ((FormChecker2Listener)listener).exitStringPhrase(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FormChecker2Visitor ) return ((FormChecker2Visitor<? extends T>)visitor).visitStringPhrase(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StringPhraseContext stringPhrase() throws RecognitionException {
		StringPhraseContext _localctx = new StringPhraseContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_stringPhrase);
		try {
			setState(121);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(117);
				match(STRING);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(118);
				match(STRING);
				setState(119);
				match(T__0);
				setState(120);
				stringPhrase();
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

	public static class ErrorContext extends ParserRuleContext {
		public ErrorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_error; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FormChecker2Listener ) ((FormChecker2Listener)listener).enterError(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FormChecker2Listener ) ((FormChecker2Listener)listener).exitError(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FormChecker2Visitor ) return ((FormChecker2Visitor<? extends T>)visitor).visitError(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ErrorContext error() throws RecognitionException {
		ErrorContext _localctx = new ErrorContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_error);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(123);
			matchWildcard();
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\20\u0080\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\3\2\6\2\36\n\2\r\2\16\2\37\3\2\3\2\3\3"+
		"\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4\60\n\4\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5<\n\5\3\6\3\6\3\6\3\6\3\6\3\6\5\6D\n\6\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\5\7L\n\7\3\b\3\b\3\b\3\b\3\b\3\b\5\bT\n\b\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\5\t\\\n\t\3\n\3\n\3\n\3\n\3\n\3\n\5\nd\n\n\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\5\13n\n\13\3\f\3\f\3\f\3\f\3\f\3\f\5\f"+
		"v\n\f\3\r\3\r\3\r\3\r\5\r|\n\r\3\16\3\16\3\16\2\2\17\2\4\6\b\n\f\16\20"+
		"\22\24\26\30\32\2\2\2\u0084\2\35\3\2\2\2\4#\3\2\2\2\6/\3\2\2\2\b\61\3"+
		"\2\2\2\n=\3\2\2\2\fE\3\2\2\2\16M\3\2\2\2\20U\3\2\2\2\22]\3\2\2\2\24e\3"+
		"\2\2\2\26o\3\2\2\2\30{\3\2\2\2\32}\3\2\2\2\34\36\5\4\3\2\35\34\3\2\2\2"+
		"\36\37\3\2\2\2\37\35\3\2\2\2\37 \3\2\2\2 !\3\2\2\2!\"\7\2\2\3\"\3\3\2"+
		"\2\2#$\5\6\4\2$%\7\20\2\2%\5\3\2\2\2&\60\5\b\5\2\'\60\5\16\b\2(\60\5\n"+
		"\6\2)\60\5\f\7\2*\60\5\22\n\2+\60\5\24\13\2,\60\5\26\f\2-\60\5\20\t\2"+
		".\60\5\32\16\2/&\3\2\2\2/\'\3\2\2\2/(\3\2\2\2/)\3\2\2\2/*\3\2\2\2/+\3"+
		"\2\2\2/,\3\2\2\2/-\3\2\2\2/.\3\2\2\2\60\7\3\2\2\2\61\62\7\5\2\2\62\63"+
		"\7\3\2\2\63\64\7\17\2\2\64;\7\4\2\2\65<\3\2\2\2\66\67\7\17\2\2\678\7\16"+
		"\2\289\7\17\2\29:\7\16\2\2:<\7\17\2\2;\65\3\2\2\2;\66\3\2\2\2<\t\3\2\2"+
		"\2=>\7\6\2\2>?\7\3\2\2?@\7\17\2\2@C\7\4\2\2AD\3\2\2\2BD\7\17\2\2CA\3\2"+
		"\2\2CB\3\2\2\2D\13\3\2\2\2EF\7\b\2\2FG\7\3\2\2GH\7\17\2\2HK\7\4\2\2IL"+
		"\3\2\2\2JL\7\17\2\2KI\3\2\2\2KJ\3\2\2\2L\r\3\2\2\2MN\7\7\2\2NO\7\3\2\2"+
		"OP\7\17\2\2PS\7\4\2\2QT\3\2\2\2RT\5\30\r\2SQ\3\2\2\2SR\3\2\2\2T\17\3\2"+
		"\2\2UV\7\f\2\2VW\7\3\2\2WX\7\17\2\2X[\7\4\2\2Y\\\3\2\2\2Z\\\5\30\r\2["+
		"Y\3\2\2\2[Z\3\2\2\2\\\21\3\2\2\2]^\7\t\2\2^_\7\3\2\2_`\7\17\2\2`c\7\4"+
		"\2\2ad\3\2\2\2bd\7\17\2\2ca\3\2\2\2cb\3\2\2\2d\23\3\2\2\2ef\7\n\2\2fg"+
		"\7\3\2\2gh\7\17\2\2hm\7\4\2\2in\3\2\2\2jk\7\17\2\2kl\7\r\2\2ln\7\17\2"+
		"\2mi\3\2\2\2mj\3\2\2\2n\25\3\2\2\2op\7\13\2\2pq\7\3\2\2qr\7\17\2\2ru\7"+
		"\4\2\2sv\3\2\2\2tv\5\30\r\2us\3\2\2\2ut\3\2\2\2v\27\3\2\2\2w|\7\17\2\2"+
		"xy\7\17\2\2yz\7\3\2\2z|\5\30\r\2{w\3\2\2\2{x\3\2\2\2|\31\3\2\2\2}~\13"+
		"\2\2\2~\33\3\2\2\2\r\37/;CKS[cmu{";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}