// Generated from C:/Users/pedro/OneDrive/Documentos/Eng.Informática_Projects/2ºAno/LAPR/lapr4-2021-gS4/LAPR4_BASE/eapli.base/base.core/src/main/java/eapli/base/form/antlr/formRequested\FormChecker.g4 by ANTLR 4.9.1
package eapli.base.form.antlr.formRequestedUnused;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class FormCheckerParser extends Parser {
    static {
        RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION);
    }

    protected static final DFA[] _decisionToDFA;
    protected static final PredictionContextCache _sharedContextCache =
            new PredictionContextCache();
    public static final int
            T__0 = 1, T__1 = 2, TYPEDATE = 3, TYPEOPTIONALDATE = 4, TYPEINT = 5, TYPEOPTIONALINT = 6,
            TYPESTRING = 7, TYPEOPTIONALSTRING = 8, TYPEBOOL = 9, TYPEOPTIONALBOOL = 10, TYPEPHONENUMBER = 11,
            TYPEOPTIONALPHONENUMBER = 12, TYPEPOSTALCODE = 13, TYPEOPTIONALPOSTALCODE = 14,
            TYPENAME = 15, TYPEOPTIONALNAME = 16, TYPEADDRESS = 17, TYPEOPTIONALADDRESS = 18,
            TRUE = 19, FALSE = 20, NAME = 21, PHONENUMBER = 22, INT = 23, STRING = 24, DATE = 25,
            POSTALCODE = 26, NEWLINE = 27;
    public static final int
            RULE_lprog = 0, RULE_start = 1, RULE_allParameters = 2, RULE_parameterDate = 3,
            RULE_parameterOptionalDate = 4, RULE_parameterInt = 5, RULE_parameterOptionalInt = 6,
            RULE_parameterBool = 7, RULE_parameterOptionalBool = 8, RULE_parameterString = 9,
            RULE_parameterOptionalString = 10, RULE_parameterAddress = 11, RULE_parameterOptionalAddress = 12,
            RULE_parameterPhoneNumber = 13, RULE_parameterOptionalPhoneNumber = 14,
            RULE_parameterPostalCode = 15, RULE_parameterOptionalPostalCode = 16,
            RULE_parameterName = 17, RULE_parameterOptionalName = 18, RULE_namePossibility = 19,
            RULE_addressPosibility = 20, RULE_stringPossibility = 21, RULE_booleano = 22,
            RULE_optionalDate = 23, RULE_optionalName = 24, RULE_optionalAddress = 25,
            RULE_optionalPostalCode = 26, RULE_optionalString = 27, RULE_optionalBool = 28,
            RULE_optionalInt = 29, RULE_optionalPhoneNumber = 30;

    private static String[] makeRuleNames() {
        return new String[]{
                "lprog", "start", "allParameters", "parameterDate", "parameterOptionalDate",
                "parameterInt", "parameterOptionalInt", "parameterBool", "parameterOptionalBool",
                "parameterString", "parameterOptionalString", "parameterAddress", "parameterOptionalAddress",
                "parameterPhoneNumber", "parameterOptionalPhoneNumber", "parameterPostalCode",
                "parameterOptionalPostalCode", "parameterName", "parameterOptionalName",
                "namePossibility", "addressPosibility", "stringPossibility", "booleano",
                "optionalDate", "optionalName", "optionalAddress", "optionalPostalCode",
                "optionalString", "optionalBool", "optionalInt", "optionalPhoneNumber"
        };
    }

    public static final String[] ruleNames = makeRuleNames();

    private static String[] makeLiteralNames() {
        return new String[]{
                null, "' '", "': '", "'Date'", "'OptionalDate'", "'Integer'", "'OptionalInteger'",
                "'String'", "'OptionalString'", "'Bool'", "'OptionalBool'", "'PhoneNumber'",
                "'OptionalPhoneNumber'", "'PostalCode'", "'OptionalPostalCode'", "'Name'",
                "'OptionalName'", "'Address'", "'OptionalAddress'"
        };
    }

    private static final String[] _LITERAL_NAMES = makeLiteralNames();

    private static String[] makeSymbolicNames() {
        return new String[]{
                null, null, null, "TYPEDATE", "TYPEOPTIONALDATE", "TYPEINT", "TYPEOPTIONALINT",
                "TYPESTRING", "TYPEOPTIONALSTRING", "TYPEBOOL", "TYPEOPTIONALBOOL", "TYPEPHONENUMBER",
                "TYPEOPTIONALPHONENUMBER", "TYPEPOSTALCODE", "TYPEOPTIONALPOSTALCODE",
                "TYPENAME", "TYPEOPTIONALNAME", "TYPEADDRESS", "TYPEOPTIONALADDRESS",
                "TRUE", "FALSE", "NAME", "PHONENUMBER", "INT", "STRING", "DATE", "POSTALCODE",
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
    public String getGrammarFileName() {
        return "FormChecker.g4";
    }

    @Override
    public String[] getRuleNames() {
        return ruleNames;
    }

    @Override
    public String getSerializedATN() {
        return _serializedATN;
    }

    @Override
    public ATN getATN() {
        return _ATN;
    }

    public FormCheckerParser(TokenStream input) {
        super(input);
        _interp = new ParserATNSimulator(this, _ATN, _decisionToDFA, _sharedContextCache);
    }

    public static class LprogContext extends ParserRuleContext {
        public List<StartContext> start() {
            return getRuleContexts(StartContext.class);
        }

        public StartContext start(int i) {
            return getRuleContext(StartContext.class, i);
        }

        public LprogContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_lprog;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof FormCheckerListener) ((FormCheckerListener) listener).enterLprog(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof FormCheckerListener) ((FormCheckerListener) listener).exitLprog(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof FormCheckerVisitor)
                return ((FormCheckerVisitor<? extends T>) visitor).visitLprog(this);
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
                setState(63);
                _errHandler.sync(this);
                _la = _input.LA(1);
                do {
                    {
                        {
                            setState(62);
                            start();
                        }
                    }
                    setState(65);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                } while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TYPEDATE) | (1L << TYPEOPTIONALDATE) | (1L << TYPEINT) | (1L << TYPEOPTIONALINT) | (1L << TYPESTRING) | (1L << TYPEOPTIONALSTRING) | (1L << TYPEBOOL) | (1L << TYPEOPTIONALBOOL) | (1L << TYPEPHONENUMBER) | (1L << TYPEOPTIONALPHONENUMBER) | (1L << TYPEPOSTALCODE) | (1L << TYPEOPTIONALPOSTALCODE) | (1L << TYPENAME) | (1L << TYPEOPTIONALNAME) | (1L << TYPEADDRESS) | (1L << TYPEOPTIONALADDRESS))) != 0));
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
            System.out.println("Erro Semantico");
            throw new IllegalArgumentException();
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class StartContext extends ParserRuleContext {
        public AllParametersContext allParameters() {
            return getRuleContext(AllParametersContext.class, 0);
        }

        public TerminalNode NEWLINE() {
            return getToken(FormCheckerParser.NEWLINE, 0);
        }

        public StartContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_start;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof FormCheckerListener) ((FormCheckerListener) listener).enterStart(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof FormCheckerListener) ((FormCheckerListener) listener).exitStart(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof FormCheckerVisitor)
                return ((FormCheckerVisitor<? extends T>) visitor).visitStart(this);
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
                    setState(67);
                    allParameters();
                    setState(68);
                    match(NEWLINE);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
            System.out.println("Erro Semantico");
            throw new IllegalArgumentException();
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class AllParametersContext extends ParserRuleContext {
        public ParameterDateContext parameterDate() {
            return getRuleContext(ParameterDateContext.class, 0);
        }

        public ParameterStringContext parameterString() {
            return getRuleContext(ParameterStringContext.class, 0);
        }

        public ParameterIntContext parameterInt() {
            return getRuleContext(ParameterIntContext.class, 0);
        }

        public ParameterBoolContext parameterBool() {
            return getRuleContext(ParameterBoolContext.class, 0);
        }

        public ParameterPhoneNumberContext parameterPhoneNumber() {
            return getRuleContext(ParameterPhoneNumberContext.class, 0);
        }

        public ParameterPostalCodeContext parameterPostalCode() {
            return getRuleContext(ParameterPostalCodeContext.class, 0);
        }

        public ParameterNameContext parameterName() {
            return getRuleContext(ParameterNameContext.class, 0);
        }

        public ParameterAddressContext parameterAddress() {
            return getRuleContext(ParameterAddressContext.class, 0);
        }

        public ParameterOptionalDateContext parameterOptionalDate() {
            return getRuleContext(ParameterOptionalDateContext.class, 0);
        }

        public ParameterOptionalBoolContext parameterOptionalBool() {
            return getRuleContext(ParameterOptionalBoolContext.class, 0);
        }

        public ParameterOptionalIntContext parameterOptionalInt() {
            return getRuleContext(ParameterOptionalIntContext.class, 0);
        }

        public ParameterOptionalStringContext parameterOptionalString() {
            return getRuleContext(ParameterOptionalStringContext.class, 0);
        }

        public ParameterOptionalAddressContext parameterOptionalAddress() {
            return getRuleContext(ParameterOptionalAddressContext.class, 0);
        }

        public ParameterOptionalNameContext parameterOptionalName() {
            return getRuleContext(ParameterOptionalNameContext.class, 0);
        }

        public ParameterOptionalPhoneNumberContext parameterOptionalPhoneNumber() {
            return getRuleContext(ParameterOptionalPhoneNumberContext.class, 0);
        }

        public ParameterOptionalPostalCodeContext parameterOptionalPostalCode() {
            return getRuleContext(ParameterOptionalPostalCodeContext.class, 0);
        }

        public AllParametersContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_allParameters;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof FormCheckerListener) ((FormCheckerListener) listener).enterAllParameters(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof FormCheckerListener) ((FormCheckerListener) listener).exitAllParameters(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof FormCheckerVisitor)
                return ((FormCheckerVisitor<? extends T>) visitor).visitAllParameters(this);
            else return visitor.visitChildren(this);
        }
    }

    public final AllParametersContext allParameters() throws RecognitionException {
        AllParametersContext _localctx = new AllParametersContext(_ctx, getState());
        enterRule(_localctx, 4, RULE_allParameters);
        try {
            setState(86);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case TYPEDATE:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(70);
                    parameterDate();
                }
                break;
                case TYPESTRING:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(71);
                    parameterString();
                }
                break;
                case TYPEINT:
                    enterOuterAlt(_localctx, 3);
                {
                    setState(72);
                    parameterInt();
                }
                break;
                case TYPEBOOL:
                    enterOuterAlt(_localctx, 4);
                {
                    setState(73);
                    parameterBool();
                }
                break;
                case TYPEPHONENUMBER:
                    enterOuterAlt(_localctx, 5);
                {
                    setState(74);
                    parameterPhoneNumber();
                }
                break;
                case TYPEPOSTALCODE:
                    enterOuterAlt(_localctx, 6);
                {
                    setState(75);
                    parameterPostalCode();
                }
                break;
                case TYPENAME:
                    enterOuterAlt(_localctx, 7);
                {
                    setState(76);
                    parameterName();
                }
                break;
                case TYPEADDRESS:
                    enterOuterAlt(_localctx, 8);
                {
                    setState(77);
                    parameterAddress();
                }
                break;
                case TYPEOPTIONALDATE:
                    enterOuterAlt(_localctx, 9);
                {
                    setState(78);
                    parameterOptionalDate();
                }
                break;
                case TYPEOPTIONALBOOL:
                    enterOuterAlt(_localctx, 10);
                {
                    setState(79);
                    parameterOptionalBool();
                }
                break;
                case TYPEOPTIONALINT:
                    enterOuterAlt(_localctx, 11);
                {
                    setState(80);
                    parameterOptionalInt();
                }
                break;
                case TYPEOPTIONALSTRING:
                    enterOuterAlt(_localctx, 12);
                {
                    setState(81);
                    parameterOptionalString();
                }
                break;
                case TYPEOPTIONALADDRESS:
                    enterOuterAlt(_localctx, 13);
                {
                    setState(82);
                    parameterOptionalAddress();
                }
                break;
                case TYPEOPTIONALNAME:
                    enterOuterAlt(_localctx, 14);
                {
                    setState(83);
                    parameterOptionalName();
                }
                break;
                case TYPEOPTIONALPHONENUMBER:
                    enterOuterAlt(_localctx, 15);
                {
                    setState(84);
                    parameterOptionalPhoneNumber();
                }
                break;
                case TYPEOPTIONALPOSTALCODE:
                    enterOuterAlt(_localctx, 16);
                {
                    setState(85);
                    parameterOptionalPostalCode();
                }
                break;
                default:
                    throw new NoViableAltException(this);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
            System.out.println("Erro Semantico");
            throw new IllegalArgumentException();
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class ParameterDateContext extends ParserRuleContext {
        public TerminalNode TYPEDATE() {
            return getToken(FormCheckerParser.TYPEDATE, 0);
        }

        public TerminalNode STRING() {
            return getToken(FormCheckerParser.STRING, 0);
        }

        public TerminalNode DATE() {
            return getToken(FormCheckerParser.DATE, 0);
        }

        public ParameterDateContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_parameterDate;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof FormCheckerListener) ((FormCheckerListener) listener).enterParameterDate(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof FormCheckerListener) ((FormCheckerListener) listener).exitParameterDate(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof FormCheckerVisitor)
                return ((FormCheckerVisitor<? extends T>) visitor).visitParameterDate(this);
            else return visitor.visitChildren(this);
        }
    }

    public final ParameterDateContext parameterDate() throws RecognitionException {
        ParameterDateContext _localctx = new ParameterDateContext(_ctx, getState());
        enterRule(_localctx, 6, RULE_parameterDate);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(88);
                match(TYPEDATE);
                setState(89);
                match(T__0);
                setState(90);
                match(STRING);
                setState(91);
                match(T__1);
                setState(92);
                match(DATE);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
            System.out.println("Erro Semantico");
            throw new IllegalArgumentException();
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class ParameterOptionalDateContext extends ParserRuleContext {
        public TerminalNode TYPEOPTIONALDATE() {
            return getToken(FormCheckerParser.TYPEOPTIONALDATE, 0);
        }

        public TerminalNode STRING() {
            return getToken(FormCheckerParser.STRING, 0);
        }

        public OptionalDateContext optionalDate() {
            return getRuleContext(OptionalDateContext.class, 0);
        }

        public ParameterOptionalDateContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_parameterOptionalDate;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof FormCheckerListener)
                ((FormCheckerListener) listener).enterParameterOptionalDate(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof FormCheckerListener)
                ((FormCheckerListener) listener).exitParameterOptionalDate(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof FormCheckerVisitor)
                return ((FormCheckerVisitor<? extends T>) visitor).visitParameterOptionalDate(this);
            else return visitor.visitChildren(this);
        }
    }

    public final ParameterOptionalDateContext parameterOptionalDate() throws RecognitionException {
        ParameterOptionalDateContext _localctx = new ParameterOptionalDateContext(_ctx, getState());
        enterRule(_localctx, 8, RULE_parameterOptionalDate);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(94);
                match(TYPEOPTIONALDATE);
                setState(95);
                match(T__0);
                setState(96);
                match(STRING);
                setState(97);
                match(T__1);
                setState(98);
                optionalDate();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
            System.out.println("Erro Semantico");
            throw new IllegalArgumentException();
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class ParameterIntContext extends ParserRuleContext {
        public TerminalNode TYPEINT() {
            return getToken(FormCheckerParser.TYPEINT, 0);
        }

        public TerminalNode STRING() {
            return getToken(FormCheckerParser.STRING, 0);
        }

        public TerminalNode INT() {
            return getToken(FormCheckerParser.INT, 0);
        }

        public ParameterIntContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_parameterInt;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof FormCheckerListener) ((FormCheckerListener) listener).enterParameterInt(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof FormCheckerListener) ((FormCheckerListener) listener).exitParameterInt(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof FormCheckerVisitor)
                return ((FormCheckerVisitor<? extends T>) visitor).visitParameterInt(this);
            else return visitor.visitChildren(this);
        }
    }

    public final ParameterIntContext parameterInt() throws RecognitionException {
        ParameterIntContext _localctx = new ParameterIntContext(_ctx, getState());
        enterRule(_localctx, 10, RULE_parameterInt);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(100);
                match(TYPEINT);
                setState(101);
                match(T__0);
                setState(102);
                match(STRING);
                setState(103);
                match(T__1);
                setState(104);
                match(INT);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
            System.out.println("Erro Semantico");
            throw new IllegalArgumentException();
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class ParameterOptionalIntContext extends ParserRuleContext {
        public TerminalNode TYPEOPTIONALINT() {
            return getToken(FormCheckerParser.TYPEOPTIONALINT, 0);
        }

        public TerminalNode STRING() {
            return getToken(FormCheckerParser.STRING, 0);
        }

        public OptionalIntContext optionalInt() {
            return getRuleContext(OptionalIntContext.class, 0);
        }

        public ParameterOptionalIntContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_parameterOptionalInt;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof FormCheckerListener)
                ((FormCheckerListener) listener).enterParameterOptionalInt(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof FormCheckerListener)
                ((FormCheckerListener) listener).exitParameterOptionalInt(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof FormCheckerVisitor)
                return ((FormCheckerVisitor<? extends T>) visitor).visitParameterOptionalInt(this);
            else return visitor.visitChildren(this);
        }
    }

    public final ParameterOptionalIntContext parameterOptionalInt() throws RecognitionException {
        ParameterOptionalIntContext _localctx = new ParameterOptionalIntContext(_ctx, getState());
        enterRule(_localctx, 12, RULE_parameterOptionalInt);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(106);
                match(TYPEOPTIONALINT);
                setState(107);
                match(T__0);
                setState(108);
                match(STRING);
                setState(109);
                match(T__1);
                setState(110);
                optionalInt();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
            System.out.println("Erro Semantico");
            throw new IllegalArgumentException();
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class ParameterBoolContext extends ParserRuleContext {
        public TerminalNode TYPEBOOL() {
            return getToken(FormCheckerParser.TYPEBOOL, 0);
        }

        public TerminalNode STRING() {
            return getToken(FormCheckerParser.STRING, 0);
        }

        public BooleanoContext booleano() {
            return getRuleContext(BooleanoContext.class, 0);
        }

        public ParameterBoolContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_parameterBool;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof FormCheckerListener) ((FormCheckerListener) listener).enterParameterBool(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof FormCheckerListener) ((FormCheckerListener) listener).exitParameterBool(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof FormCheckerVisitor)
                return ((FormCheckerVisitor<? extends T>) visitor).visitParameterBool(this);
            else return visitor.visitChildren(this);
        }
    }

    public final ParameterBoolContext parameterBool() throws RecognitionException {
        ParameterBoolContext _localctx = new ParameterBoolContext(_ctx, getState());
        enterRule(_localctx, 14, RULE_parameterBool);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(112);
                match(TYPEBOOL);
                setState(113);
                match(T__0);
                setState(114);
                match(STRING);
                setState(115);
                match(T__1);
                setState(116);
                booleano();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
            System.out.println("Erro Semantico");
            throw new IllegalArgumentException();
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class ParameterOptionalBoolContext extends ParserRuleContext {
        public TerminalNode TYPEOPTIONALBOOL() {
            return getToken(FormCheckerParser.TYPEOPTIONALBOOL, 0);
        }

        public TerminalNode STRING() {
            return getToken(FormCheckerParser.STRING, 0);
        }

        public OptionalBoolContext optionalBool() {
            return getRuleContext(OptionalBoolContext.class, 0);
        }

        public ParameterOptionalBoolContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_parameterOptionalBool;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof FormCheckerListener)
                ((FormCheckerListener) listener).enterParameterOptionalBool(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof FormCheckerListener)
                ((FormCheckerListener) listener).exitParameterOptionalBool(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof FormCheckerVisitor)
                return ((FormCheckerVisitor<? extends T>) visitor).visitParameterOptionalBool(this);
            else return visitor.visitChildren(this);
        }
    }

    public final ParameterOptionalBoolContext parameterOptionalBool() throws RecognitionException {
        ParameterOptionalBoolContext _localctx = new ParameterOptionalBoolContext(_ctx, getState());
        enterRule(_localctx, 16, RULE_parameterOptionalBool);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(118);
                match(TYPEOPTIONALBOOL);
                setState(119);
                match(T__0);
                setState(120);
                match(STRING);
                setState(121);
                match(T__1);
                setState(122);
                optionalBool();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
            System.out.println("Erro Semantico");
            throw new IllegalArgumentException();
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class ParameterStringContext extends ParserRuleContext {
        public TerminalNode TYPESTRING() {
            return getToken(FormCheckerParser.TYPESTRING, 0);
        }

        public TerminalNode STRING() {
            return getToken(FormCheckerParser.STRING, 0);
        }

        public StringPossibilityContext stringPossibility() {
            return getRuleContext(StringPossibilityContext.class, 0);
        }

        public ParameterStringContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_parameterString;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof FormCheckerListener) ((FormCheckerListener) listener).enterParameterString(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof FormCheckerListener) ((FormCheckerListener) listener).exitParameterString(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof FormCheckerVisitor)
                return ((FormCheckerVisitor<? extends T>) visitor).visitParameterString(this);
            else return visitor.visitChildren(this);
        }
    }

    public final ParameterStringContext parameterString() throws RecognitionException {
        ParameterStringContext _localctx = new ParameterStringContext(_ctx, getState());
        enterRule(_localctx, 18, RULE_parameterString);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(124);
                match(TYPESTRING);
                setState(125);
                match(T__0);
                setState(126);
                match(STRING);
                setState(127);
                match(T__1);
                setState(128);
                stringPossibility();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
            System.out.println("Erro Semantico");
            throw new IllegalArgumentException();
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class ParameterOptionalStringContext extends ParserRuleContext {
        public TerminalNode TYPEOPTIONALSTRING() {
            return getToken(FormCheckerParser.TYPEOPTIONALSTRING, 0);
        }

        public TerminalNode STRING() {
            return getToken(FormCheckerParser.STRING, 0);
        }

        public OptionalStringContext optionalString() {
            return getRuleContext(OptionalStringContext.class, 0);
        }

        public ParameterOptionalStringContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_parameterOptionalString;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof FormCheckerListener)
                ((FormCheckerListener) listener).enterParameterOptionalString(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof FormCheckerListener)
                ((FormCheckerListener) listener).exitParameterOptionalString(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof FormCheckerVisitor)
                return ((FormCheckerVisitor<? extends T>) visitor).visitParameterOptionalString(this);
            else return visitor.visitChildren(this);
        }
    }

    public final ParameterOptionalStringContext parameterOptionalString() throws RecognitionException {
        ParameterOptionalStringContext _localctx = new ParameterOptionalStringContext(_ctx, getState());
        enterRule(_localctx, 20, RULE_parameterOptionalString);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(130);
                match(TYPEOPTIONALSTRING);
                setState(131);
                match(T__0);
                setState(132);
                match(STRING);
                setState(133);
                match(T__1);
                setState(134);
                optionalString();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
            System.out.println("Erro Semantico");
            throw new IllegalArgumentException();
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class ParameterAddressContext extends ParserRuleContext {
        public TerminalNode TYPEADDRESS() {
            return getToken(FormCheckerParser.TYPEADDRESS, 0);
        }

        public TerminalNode STRING() {
            return getToken(FormCheckerParser.STRING, 0);
        }

        public AddressPosibilityContext addressPosibility() {
            return getRuleContext(AddressPosibilityContext.class, 0);
        }

        public ParameterAddressContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_parameterAddress;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof FormCheckerListener) ((FormCheckerListener) listener).enterParameterAddress(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof FormCheckerListener) ((FormCheckerListener) listener).exitParameterAddress(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof FormCheckerVisitor)
                return ((FormCheckerVisitor<? extends T>) visitor).visitParameterAddress(this);
            else return visitor.visitChildren(this);
        }
    }

    public final ParameterAddressContext parameterAddress() throws RecognitionException {
        ParameterAddressContext _localctx = new ParameterAddressContext(_ctx, getState());
        enterRule(_localctx, 22, RULE_parameterAddress);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(136);
                match(TYPEADDRESS);
                setState(137);
                match(T__0);
                setState(138);
                match(STRING);
                setState(139);
                match(T__1);
                setState(140);
                addressPosibility();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
            System.out.println("Erro Semantico");
            throw new IllegalArgumentException();
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class ParameterOptionalAddressContext extends ParserRuleContext {
        public TerminalNode TYPEOPTIONALADDRESS() {
            return getToken(FormCheckerParser.TYPEOPTIONALADDRESS, 0);
        }

        public TerminalNode STRING() {
            return getToken(FormCheckerParser.STRING, 0);
        }

        public OptionalAddressContext optionalAddress() {
            return getRuleContext(OptionalAddressContext.class, 0);
        }

        public ParameterOptionalAddressContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_parameterOptionalAddress;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof FormCheckerListener)
                ((FormCheckerListener) listener).enterParameterOptionalAddress(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof FormCheckerListener)
                ((FormCheckerListener) listener).exitParameterOptionalAddress(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof FormCheckerVisitor)
                return ((FormCheckerVisitor<? extends T>) visitor).visitParameterOptionalAddress(this);
            else return visitor.visitChildren(this);
        }
    }

    public final ParameterOptionalAddressContext parameterOptionalAddress() throws RecognitionException {
        ParameterOptionalAddressContext _localctx = new ParameterOptionalAddressContext(_ctx, getState());
        enterRule(_localctx, 24, RULE_parameterOptionalAddress);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(142);
                match(TYPEOPTIONALADDRESS);
                setState(143);
                match(T__0);
                setState(144);
                match(STRING);
                setState(145);
                match(T__1);
                setState(146);
                optionalAddress();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
            System.out.println("Erro Semantico");
            throw new IllegalArgumentException();
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class ParameterPhoneNumberContext extends ParserRuleContext {
        public TerminalNode TYPEPHONENUMBER() {
            return getToken(FormCheckerParser.TYPEPHONENUMBER, 0);
        }

        public TerminalNode STRING() {
            return getToken(FormCheckerParser.STRING, 0);
        }

        public TerminalNode PHONENUMBER() {
            return getToken(FormCheckerParser.PHONENUMBER, 0);
        }

        public ParameterPhoneNumberContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_parameterPhoneNumber;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof FormCheckerListener)
                ((FormCheckerListener) listener).enterParameterPhoneNumber(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof FormCheckerListener)
                ((FormCheckerListener) listener).exitParameterPhoneNumber(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof FormCheckerVisitor)
                return ((FormCheckerVisitor<? extends T>) visitor).visitParameterPhoneNumber(this);
            else return visitor.visitChildren(this);
        }
    }

    public final ParameterPhoneNumberContext parameterPhoneNumber() throws RecognitionException {
        ParameterPhoneNumberContext _localctx = new ParameterPhoneNumberContext(_ctx, getState());
        enterRule(_localctx, 26, RULE_parameterPhoneNumber);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(148);
                match(TYPEPHONENUMBER);
                setState(149);
                match(T__0);
                setState(150);
                match(STRING);
                setState(151);
                match(T__1);
                setState(152);
                match(PHONENUMBER);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
            System.out.println("Erro Semantico");
            throw new IllegalArgumentException();
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class ParameterOptionalPhoneNumberContext extends ParserRuleContext {
        public TerminalNode TYPEOPTIONALPHONENUMBER() {
            return getToken(FormCheckerParser.TYPEOPTIONALPHONENUMBER, 0);
        }

        public TerminalNode STRING() {
            return getToken(FormCheckerParser.STRING, 0);
        }

        public OptionalPhoneNumberContext optionalPhoneNumber() {
            return getRuleContext(OptionalPhoneNumberContext.class, 0);
        }

        public ParameterOptionalPhoneNumberContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_parameterOptionalPhoneNumber;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof FormCheckerListener)
                ((FormCheckerListener) listener).enterParameterOptionalPhoneNumber(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof FormCheckerListener)
                ((FormCheckerListener) listener).exitParameterOptionalPhoneNumber(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof FormCheckerVisitor)
                return ((FormCheckerVisitor<? extends T>) visitor).visitParameterOptionalPhoneNumber(this);
            else return visitor.visitChildren(this);
        }
    }

    public final ParameterOptionalPhoneNumberContext parameterOptionalPhoneNumber() throws RecognitionException {
        ParameterOptionalPhoneNumberContext _localctx = new ParameterOptionalPhoneNumberContext(_ctx, getState());
        enterRule(_localctx, 28, RULE_parameterOptionalPhoneNumber);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(154);
                match(TYPEOPTIONALPHONENUMBER);
                setState(155);
                match(T__0);
                setState(156);
                match(STRING);
                setState(157);
                match(T__1);
                setState(158);
                optionalPhoneNumber();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
            System.out.println("Erro Semantico");
            throw new IllegalArgumentException();
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class ParameterPostalCodeContext extends ParserRuleContext {
        public TerminalNode TYPEPOSTALCODE() {
            return getToken(FormCheckerParser.TYPEPOSTALCODE, 0);
        }

        public TerminalNode STRING() {
            return getToken(FormCheckerParser.STRING, 0);
        }

        public TerminalNode POSTALCODE() {
            return getToken(FormCheckerParser.POSTALCODE, 0);
        }

        public ParameterPostalCodeContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_parameterPostalCode;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof FormCheckerListener)
                ((FormCheckerListener) listener).enterParameterPostalCode(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof FormCheckerListener) ((FormCheckerListener) listener).exitParameterPostalCode(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof FormCheckerVisitor)
                return ((FormCheckerVisitor<? extends T>) visitor).visitParameterPostalCode(this);
            else return visitor.visitChildren(this);
        }
    }

    public final ParameterPostalCodeContext parameterPostalCode() throws RecognitionException {
        ParameterPostalCodeContext _localctx = new ParameterPostalCodeContext(_ctx, getState());
        enterRule(_localctx, 30, RULE_parameterPostalCode);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(160);
                match(TYPEPOSTALCODE);
                setState(161);
                match(T__0);
                setState(162);
                match(STRING);
                setState(163);
                match(T__1);
                setState(164);
                match(POSTALCODE);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
            System.out.println("Erro Semantico");
            throw new IllegalArgumentException();
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class ParameterOptionalPostalCodeContext extends ParserRuleContext {
        public TerminalNode TYPEOPTIONALPOSTALCODE() {
            return getToken(FormCheckerParser.TYPEOPTIONALPOSTALCODE, 0);
        }

        public TerminalNode STRING() {
            return getToken(FormCheckerParser.STRING, 0);
        }

        public OptionalPostalCodeContext optionalPostalCode() {
            return getRuleContext(OptionalPostalCodeContext.class, 0);
        }

        public ParameterOptionalPostalCodeContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_parameterOptionalPostalCode;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof FormCheckerListener)
                ((FormCheckerListener) listener).enterParameterOptionalPostalCode(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof FormCheckerListener)
                ((FormCheckerListener) listener).exitParameterOptionalPostalCode(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof FormCheckerVisitor)
                return ((FormCheckerVisitor<? extends T>) visitor).visitParameterOptionalPostalCode(this);
            else return visitor.visitChildren(this);
        }
    }

    public final ParameterOptionalPostalCodeContext parameterOptionalPostalCode() throws RecognitionException {
        ParameterOptionalPostalCodeContext _localctx = new ParameterOptionalPostalCodeContext(_ctx, getState());
        enterRule(_localctx, 32, RULE_parameterOptionalPostalCode);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(166);
                match(TYPEOPTIONALPOSTALCODE);
                setState(167);
                match(T__0);
                setState(168);
                match(STRING);
                setState(169);
                match(T__1);
                setState(170);
                optionalPostalCode();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
            System.out.println("Erro Semantico");
            throw new IllegalArgumentException();
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class ParameterNameContext extends ParserRuleContext {
        public TerminalNode TYPENAME() {
            return getToken(FormCheckerParser.TYPENAME, 0);
        }

        public TerminalNode STRING() {
            return getToken(FormCheckerParser.STRING, 0);
        }

        public NamePossibilityContext namePossibility() {
            return getRuleContext(NamePossibilityContext.class, 0);
        }

        public ParameterNameContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_parameterName;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof FormCheckerListener) ((FormCheckerListener) listener).enterParameterName(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof FormCheckerListener) ((FormCheckerListener) listener).exitParameterName(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof FormCheckerVisitor)
                return ((FormCheckerVisitor<? extends T>) visitor).visitParameterName(this);
            else return visitor.visitChildren(this);
        }
    }

    public final ParameterNameContext parameterName() throws RecognitionException {
        ParameterNameContext _localctx = new ParameterNameContext(_ctx, getState());
        enterRule(_localctx, 34, RULE_parameterName);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(172);
                match(TYPENAME);
                setState(173);
                match(T__0);
                setState(174);
                match(STRING);
                setState(175);
                match(T__1);
                setState(176);
                namePossibility();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
            System.out.println("Erro Semantico");
            throw new IllegalArgumentException();
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class ParameterOptionalNameContext extends ParserRuleContext {
        public TerminalNode TYPEOPTIONALNAME() {
            return getToken(FormCheckerParser.TYPEOPTIONALNAME, 0);
        }

        public TerminalNode STRING() {
            return getToken(FormCheckerParser.STRING, 0);
        }

        public OptionalNameContext optionalName() {
            return getRuleContext(OptionalNameContext.class, 0);
        }

        public ParameterOptionalNameContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_parameterOptionalName;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof FormCheckerListener)
                ((FormCheckerListener) listener).enterParameterOptionalName(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof FormCheckerListener)
                ((FormCheckerListener) listener).exitParameterOptionalName(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof FormCheckerVisitor)
                return ((FormCheckerVisitor<? extends T>) visitor).visitParameterOptionalName(this);
            else return visitor.visitChildren(this);
        }
    }

    public final ParameterOptionalNameContext parameterOptionalName() throws RecognitionException {
        ParameterOptionalNameContext _localctx = new ParameterOptionalNameContext(_ctx, getState());
        enterRule(_localctx, 36, RULE_parameterOptionalName);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(178);
                match(TYPEOPTIONALNAME);
                setState(179);
                match(T__0);
                setState(180);
                match(STRING);
                setState(181);
                match(T__1);
                setState(182);
                optionalName();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
            System.out.println("Erro Semantico");
            throw new IllegalArgumentException();
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class NamePossibilityContext extends ParserRuleContext {
        public TerminalNode NAME() {
            return getToken(FormCheckerParser.NAME, 0);
        }

        public NamePossibilityContext namePossibility() {
            return getRuleContext(NamePossibilityContext.class, 0);
        }

        public NamePossibilityContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_namePossibility;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof FormCheckerListener) ((FormCheckerListener) listener).enterNamePossibility(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof FormCheckerListener) ((FormCheckerListener) listener).exitNamePossibility(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof FormCheckerVisitor)
                return ((FormCheckerVisitor<? extends T>) visitor).visitNamePossibility(this);
            else return visitor.visitChildren(this);
        }
    }

    public final NamePossibilityContext namePossibility() throws RecognitionException {
        NamePossibilityContext _localctx = new NamePossibilityContext(_ctx, getState());
        enterRule(_localctx, 38, RULE_namePossibility);
        try {
            setState(191);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case NAME:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(188);
                    _errHandler.sync(this);
                    switch (getInterpreter().adaptivePredict(_input, 2, _ctx)) {
                        case 1: {
                            setState(184);
                            match(NAME);
                        }
                        break;
                        case 2: {
                            setState(185);
                            match(NAME);
                            setState(186);
                            match(T__0);
                            setState(187);
                            namePossibility();
                        }
                        break;
                    }
                }
                break;
                case NEWLINE:
                    enterOuterAlt(_localctx, 2);
                {
                }
                break;
                default:
                    throw new IllegalArgumentException();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
            System.out.println("Erro Semantico");
            throw new IllegalArgumentException();
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class AddressPosibilityContext extends ParserRuleContext {
        public StringPossibilityContext stringPossibility() {
            return getRuleContext(StringPossibilityContext.class, 0);
        }

        public AddressPosibilityContext addressPosibility() {
            return getRuleContext(AddressPosibilityContext.class, 0);
        }

        public AddressPosibilityContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_addressPosibility;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof FormCheckerListener) ((FormCheckerListener) listener).enterAddressPosibility(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof FormCheckerListener) ((FormCheckerListener) listener).exitAddressPosibility(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof FormCheckerVisitor)
                return ((FormCheckerVisitor<? extends T>) visitor).visitAddressPosibility(this);
            else return visitor.visitChildren(this);
        }
    }

    public final AddressPosibilityContext addressPosibility() throws RecognitionException {
        AddressPosibilityContext _localctx = new AddressPosibilityContext(_ctx, getState());
        enterRule(_localctx, 40, RULE_addressPosibility);
        try {
            setState(198);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 4, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(193);
                    stringPossibility();
                }
                break;
                case 2:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(194);
                    stringPossibility();
                    setState(195);
                    match(T__0);
                    setState(196);
                    addressPosibility();
                }
                break;
                default:
                    throw new IllegalArgumentException();

            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
            System.out.println("Erro Semantico");
            throw new IllegalArgumentException();
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class StringPossibilityContext extends ParserRuleContext {
        public TerminalNode STRING() {
            return getToken(FormCheckerParser.STRING, 0);
        }

        public TerminalNode INT() {
            return getToken(FormCheckerParser.INT, 0);
        }

        public TerminalNode NAME() {
            return getToken(FormCheckerParser.NAME, 0);
        }

        public BooleanoContext booleano() {
            return getRuleContext(BooleanoContext.class, 0);
        }

        public StringPossibilityContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_stringPossibility;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof FormCheckerListener) ((FormCheckerListener) listener).enterStringPossibility(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof FormCheckerListener) ((FormCheckerListener) listener).exitStringPossibility(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof FormCheckerVisitor)
                return ((FormCheckerVisitor<? extends T>) visitor).visitStringPossibility(this);
            else return visitor.visitChildren(this);
        }
    }

    public final StringPossibilityContext stringPossibility() throws RecognitionException {
        StringPossibilityContext _localctx = new StringPossibilityContext(_ctx, getState());
        enterRule(_localctx, 42, RULE_stringPossibility);
        try {
            setState(204);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case STRING:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(200);
                    match(STRING);
                }
                break;
                case INT:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(201);
                    match(INT);
                }
                break;
                case NAME:
                    enterOuterAlt(_localctx, 3);
                {
                    setState(202);
                    match(NAME);
                }
                break;
                case TRUE:
                case FALSE:
                    enterOuterAlt(_localctx, 4);
                {
                    setState(203);
                    booleano();
                }
                break;
                default:
                    throw new IllegalArgumentException();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
            System.out.println("Erro Semantico");
            throw new IllegalArgumentException();
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class BooleanoContext extends ParserRuleContext {
        public TerminalNode TRUE() {
            return getToken(FormCheckerParser.TRUE, 0);
        }

        public TerminalNode FALSE() {
            return getToken(FormCheckerParser.FALSE, 0);
        }

        public BooleanoContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_booleano;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof FormCheckerListener) ((FormCheckerListener) listener).enterBooleano(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof FormCheckerListener) ((FormCheckerListener) listener).exitBooleano(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof FormCheckerVisitor)
                return ((FormCheckerVisitor<? extends T>) visitor).visitBooleano(this);
            else return visitor.visitChildren(this);
        }
    }

    public final BooleanoContext booleano() throws RecognitionException {
        BooleanoContext _localctx = new BooleanoContext(_ctx, getState());
        enterRule(_localctx, 44, RULE_booleano);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(206);
                _la = _input.LA(1);
                if (!(_la == TRUE || _la == FALSE)) {
                    _errHandler.recoverInline(this);
                } else {
                    if (_input.LA(1) == Token.EOF) matchedEOF = true;
                    _errHandler.reportMatch(this);
                    consume();
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
            System.out.println("Erro Semantico");
            throw new IllegalArgumentException();
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class OptionalDateContext extends ParserRuleContext {
        public TerminalNode DATE() {
            return getToken(FormCheckerParser.DATE, 0);
        }

        public OptionalDateContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_optionalDate;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof FormCheckerListener) ((FormCheckerListener) listener).enterOptionalDate(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof FormCheckerListener) ((FormCheckerListener) listener).exitOptionalDate(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof FormCheckerVisitor)
                return ((FormCheckerVisitor<? extends T>) visitor).visitOptionalDate(this);
            else return visitor.visitChildren(this);
        }
    }

    public final OptionalDateContext optionalDate() throws RecognitionException {
        OptionalDateContext _localctx = new OptionalDateContext(_ctx, getState());
        enterRule(_localctx, 46, RULE_optionalDate);
        try {
            setState(210);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case NEWLINE:
                    enterOuterAlt(_localctx, 1);
                {
                }
                break;
                case DATE:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(209);
                    match(DATE);
                }
                break;
                default:
                    throw new IllegalArgumentException();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
            System.out.println("Erro Semantico");
            throw new IllegalArgumentException();
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class OptionalNameContext extends ParserRuleContext {
        public NamePossibilityContext namePossibility() {
            return getRuleContext(NamePossibilityContext.class, 0);
        }

        public OptionalNameContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_optionalName;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof FormCheckerListener) ((FormCheckerListener) listener).enterOptionalName(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof FormCheckerListener) ((FormCheckerListener) listener).exitOptionalName(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof FormCheckerVisitor)
                return ((FormCheckerVisitor<? extends T>) visitor).visitOptionalName(this);
            else return visitor.visitChildren(this);
        }
    }

    public final OptionalNameContext optionalName() throws RecognitionException {
        OptionalNameContext _localctx = new OptionalNameContext(_ctx, getState());
        enterRule(_localctx, 48, RULE_optionalName);
        try {
            setState(214);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 7, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1);
                {
                }
                break;
                case 2:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(213);
                    namePossibility();
                }
                break;
                default:
                    throw new IllegalArgumentException();

            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
            System.out.println("Erro Semantico");
            throw new IllegalArgumentException();
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class OptionalAddressContext extends ParserRuleContext {
        public AddressPosibilityContext addressPosibility() {
            return getRuleContext(AddressPosibilityContext.class, 0);
        }

        public OptionalAddressContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_optionalAddress;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof FormCheckerListener) ((FormCheckerListener) listener).enterOptionalAddress(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof FormCheckerListener) ((FormCheckerListener) listener).exitOptionalAddress(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof FormCheckerVisitor)
                return ((FormCheckerVisitor<? extends T>) visitor).visitOptionalAddress(this);
            else return visitor.visitChildren(this);
        }
    }

    public final OptionalAddressContext optionalAddress() throws RecognitionException {
        OptionalAddressContext _localctx = new OptionalAddressContext(_ctx, getState());
        enterRule(_localctx, 50, RULE_optionalAddress);
        try {
            setState(218);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case NEWLINE:
                    enterOuterAlt(_localctx, 1);
                {
                }
                break;
                case TRUE:
                case FALSE:
                case NAME:
                case INT:
                case STRING:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(217);
                    addressPosibility();
                }
                break;
                default:
                    throw new IllegalArgumentException();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
            System.out.println("Erro Semantico");
            throw new IllegalArgumentException();
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class OptionalPostalCodeContext extends ParserRuleContext {
        public TerminalNode POSTALCODE() {
            return getToken(FormCheckerParser.POSTALCODE, 0);
        }

        public OptionalPostalCodeContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_optionalPostalCode;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof FormCheckerListener) ((FormCheckerListener) listener).enterOptionalPostalCode(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof FormCheckerListener) ((FormCheckerListener) listener).exitOptionalPostalCode(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof FormCheckerVisitor)
                return ((FormCheckerVisitor<? extends T>) visitor).visitOptionalPostalCode(this);
            else return visitor.visitChildren(this);
        }
    }

    public final OptionalPostalCodeContext optionalPostalCode() throws RecognitionException {
        OptionalPostalCodeContext _localctx = new OptionalPostalCodeContext(_ctx, getState());
        enterRule(_localctx, 52, RULE_optionalPostalCode);
        try {
            setState(222);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case NEWLINE:
                    enterOuterAlt(_localctx, 1);
                {
                }
                break;
                case POSTALCODE:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(221);
                    match(POSTALCODE);
                }
                break;
                default:
                    throw new IllegalArgumentException();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
            System.out.println("Erro Semantico");
            throw new IllegalArgumentException();
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class OptionalStringContext extends ParserRuleContext {
        public StringPossibilityContext stringPossibility() {
            return getRuleContext(StringPossibilityContext.class, 0);
        }

        public OptionalStringContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_optionalString;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof FormCheckerListener) ((FormCheckerListener) listener).enterOptionalString(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof FormCheckerListener) ((FormCheckerListener) listener).exitOptionalString(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof FormCheckerVisitor)
                return ((FormCheckerVisitor<? extends T>) visitor).visitOptionalString(this);
            else return visitor.visitChildren(this);
        }
    }

    public final OptionalStringContext optionalString() throws RecognitionException {
        OptionalStringContext _localctx = new OptionalStringContext(_ctx, getState());
        enterRule(_localctx, 54, RULE_optionalString);
        try {
            setState(226);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case NEWLINE:
                    enterOuterAlt(_localctx, 1);
                {
                }
                break;
                case TRUE:
                case FALSE:
                case NAME:
                case INT:
                case STRING:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(225);
                    stringPossibility();
                }
                break;
                default:
                    throw new IllegalArgumentException();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
            System.out.println("Erro Semantico");
            throw new IllegalArgumentException();
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class OptionalBoolContext extends ParserRuleContext {
        public BooleanoContext booleano() {
            return getRuleContext(BooleanoContext.class, 0);
        }

        public OptionalBoolContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_optionalBool;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof FormCheckerListener) ((FormCheckerListener) listener).enterOptionalBool(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof FormCheckerListener) ((FormCheckerListener) listener).exitOptionalBool(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof FormCheckerVisitor)
                return ((FormCheckerVisitor<? extends T>) visitor).visitOptionalBool(this);
            else return visitor.visitChildren(this);
        }
    }

    public final OptionalBoolContext optionalBool() throws RecognitionException {
        OptionalBoolContext _localctx = new OptionalBoolContext(_ctx, getState());
        enterRule(_localctx, 56, RULE_optionalBool);
        try {
            setState(230);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case NEWLINE:
                    enterOuterAlt(_localctx, 1);
                {
                }
                break;
                case TRUE:
                case FALSE:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(229);
                    booleano();
                }
                break;
                default:
                    throw new IllegalArgumentException();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
            System.out.println("Erro Semantico");
            throw new IllegalArgumentException();
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class OptionalIntContext extends ParserRuleContext {
        public TerminalNode INT() {
            return getToken(FormCheckerParser.INT, 0);
        }

        public OptionalIntContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_optionalInt;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof FormCheckerListener) ((FormCheckerListener) listener).enterOptionalInt(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof FormCheckerListener) ((FormCheckerListener) listener).exitOptionalInt(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof FormCheckerVisitor)
                return ((FormCheckerVisitor<? extends T>) visitor).visitOptionalInt(this);
            else return visitor.visitChildren(this);
        }
    }

    public final OptionalIntContext optionalInt() throws RecognitionException {
        OptionalIntContext _localctx = new OptionalIntContext(_ctx, getState());
        enterRule(_localctx, 58, RULE_optionalInt);
        try {
            setState(234);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case NEWLINE:
                    enterOuterAlt(_localctx, 1);
                {
                }
                break;
                case INT:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(233);
                    match(INT);
                }
                break;
                default:
                    throw new IllegalArgumentException();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
            System.out.println("Erro Semantico");
            throw new IllegalArgumentException();
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class OptionalPhoneNumberContext extends ParserRuleContext {
        public TerminalNode PHONENUMBER() {
            return getToken(FormCheckerParser.PHONENUMBER, 0);
        }

        public OptionalPhoneNumberContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_optionalPhoneNumber;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof FormCheckerListener)
                ((FormCheckerListener) listener).enterOptionalPhoneNumber(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof FormCheckerListener) ((FormCheckerListener) listener).exitOptionalPhoneNumber(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof FormCheckerVisitor)
                return ((FormCheckerVisitor<? extends T>) visitor).visitOptionalPhoneNumber(this);
            else return visitor.visitChildren(this);
        }
    }

    public final OptionalPhoneNumberContext optionalPhoneNumber() throws RecognitionException {
        OptionalPhoneNumberContext _localctx = new OptionalPhoneNumberContext(_ctx, getState());
        enterRule(_localctx, 60, RULE_optionalPhoneNumber);
        try {
            setState(238);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case NEWLINE:
                    enterOuterAlt(_localctx, 1);
                {
                }
                break;
                case PHONENUMBER:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(237);
                    match(PHONENUMBER);
                }
                break;
                default:
                    throw new IllegalArgumentException();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
            System.out.println("Erro Semantico");
            throw new IllegalArgumentException();
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static final String _serializedATN =
            "\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\35\u00f3\4\2\t\2" +
                    "\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13" +
                    "\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22" +
                    "\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31" +
                    "\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \3\2" +
                    "\6\2B\n\2\r\2\16\2C\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3" +
                    "\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4Y\n\4\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3" +
                    "\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t" +
                    "\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13" +
                    "\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3" +
                    "\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3" +
                    "\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3" +
                    "\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\5" +
                    "\25\u00bf\n\25\3\25\5\25\u00c2\n\25\3\26\3\26\3\26\3\26\3\26\5\26\u00c9" +
                    "\n\26\3\27\3\27\3\27\3\27\5\27\u00cf\n\27\3\30\3\30\3\31\3\31\5\31\u00d5" +
                    "\n\31\3\32\3\32\5\32\u00d9\n\32\3\33\3\33\5\33\u00dd\n\33\3\34\3\34\5" +
                    "\34\u00e1\n\34\3\35\3\35\5\35\u00e5\n\35\3\36\3\36\5\36\u00e9\n\36\3\37" +
                    "\3\37\5\37\u00ed\n\37\3 \3 \5 \u00f1\n \3 \2\2!\2\4\6\b\n\f\16\20\22\24" +
                    "\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>\2\3\3\2\25\26\2\u00f1\2A\3\2" +
                    "\2\2\4E\3\2\2\2\6X\3\2\2\2\bZ\3\2\2\2\n`\3\2\2\2\ff\3\2\2\2\16l\3\2\2" +
                    "\2\20r\3\2\2\2\22x\3\2\2\2\24~\3\2\2\2\26\u0084\3\2\2\2\30\u008a\3\2\2" +
                    "\2\32\u0090\3\2\2\2\34\u0096\3\2\2\2\36\u009c\3\2\2\2 \u00a2\3\2\2\2\"" +
                    "\u00a8\3\2\2\2$\u00ae\3\2\2\2&\u00b4\3\2\2\2(\u00c1\3\2\2\2*\u00c8\3\2" +
                    "\2\2,\u00ce\3\2\2\2.\u00d0\3\2\2\2\60\u00d4\3\2\2\2\62\u00d8\3\2\2\2\64" +
                    "\u00dc\3\2\2\2\66\u00e0\3\2\2\28\u00e4\3\2\2\2:\u00e8\3\2\2\2<\u00ec\3" +
                    "\2\2\2>\u00f0\3\2\2\2@B\5\4\3\2A@\3\2\2\2BC\3\2\2\2CA\3\2\2\2CD\3\2\2" +
                    "\2D\3\3\2\2\2EF\5\6\4\2FG\7\35\2\2G\5\3\2\2\2HY\5\b\5\2IY\5\24\13\2JY" +
                    "\5\f\7\2KY\5\20\t\2LY\5\34\17\2MY\5 \21\2NY\5$\23\2OY\5\30\r\2PY\5\n\6" +
                    "\2QY\5\22\n\2RY\5\16\b\2SY\5\26\f\2TY\5\32\16\2UY\5&\24\2VY\5\36\20\2" +
                    "WY\5\"\22\2XH\3\2\2\2XI\3\2\2\2XJ\3\2\2\2XK\3\2\2\2XL\3\2\2\2XM\3\2\2" +
                    "\2XN\3\2\2\2XO\3\2\2\2XP\3\2\2\2XQ\3\2\2\2XR\3\2\2\2XS\3\2\2\2XT\3\2\2" +
                    "\2XU\3\2\2\2XV\3\2\2\2XW\3\2\2\2Y\7\3\2\2\2Z[\7\5\2\2[\\\7\3\2\2\\]\7" +
                    "\32\2\2]^\7\4\2\2^_\7\33\2\2_\t\3\2\2\2`a\7\6\2\2ab\7\3\2\2bc\7\32\2\2" +
                    "cd\7\4\2\2de\5\60\31\2e\13\3\2\2\2fg\7\7\2\2gh\7\3\2\2hi\7\32\2\2ij\7" +
                    "\4\2\2jk\7\31\2\2k\r\3\2\2\2lm\7\b\2\2mn\7\3\2\2no\7\32\2\2op\7\4\2\2" +
                    "pq\5<\37\2q\17\3\2\2\2rs\7\13\2\2st\7\3\2\2tu\7\32\2\2uv\7\4\2\2vw\5." +
                    "\30\2w\21\3\2\2\2xy\7\f\2\2yz\7\3\2\2z{\7\32\2\2{|\7\4\2\2|}\5:\36\2}" +
                    "\23\3\2\2\2~\177\7\t\2\2\177\u0080\7\3\2\2\u0080\u0081\7\32\2\2\u0081" +
                    "\u0082\7\4\2\2\u0082\u0083\5,\27\2\u0083\25\3\2\2\2\u0084\u0085\7\n\2" +
                    "\2\u0085\u0086\7\3\2\2\u0086\u0087\7\32\2\2\u0087\u0088\7\4\2\2\u0088" +
                    "\u0089\58\35\2\u0089\27\3\2\2\2\u008a\u008b\7\23\2\2\u008b\u008c\7\3\2" +
                    "\2\u008c\u008d\7\32\2\2\u008d\u008e\7\4\2\2\u008e\u008f\5*\26\2\u008f" +
                    "\31\3\2\2\2\u0090\u0091\7\24\2\2\u0091\u0092\7\3\2\2\u0092\u0093\7\32" +
                    "\2\2\u0093\u0094\7\4\2\2\u0094\u0095\5\64\33\2\u0095\33\3\2\2\2\u0096" +
                    "\u0097\7\r\2\2\u0097\u0098\7\3\2\2\u0098\u0099\7\32\2\2\u0099\u009a\7" +
                    "\4\2\2\u009a\u009b\7\30\2\2\u009b\35\3\2\2\2\u009c\u009d\7\16\2\2\u009d" +
                    "\u009e\7\3\2\2\u009e\u009f\7\32\2\2\u009f\u00a0\7\4\2\2\u00a0\u00a1\5" +
                    "> \2\u00a1\37\3\2\2\2\u00a2\u00a3\7\17\2\2\u00a3\u00a4\7\3\2\2\u00a4\u00a5" +
                    "\7\32\2\2\u00a5\u00a6\7\4\2\2\u00a6\u00a7\7\34\2\2\u00a7!\3\2\2\2\u00a8" +
                    "\u00a9\7\20\2\2\u00a9\u00aa\7\3\2\2\u00aa\u00ab\7\32\2\2\u00ab\u00ac\7" +
                    "\4\2\2\u00ac\u00ad\5\66\34\2\u00ad#\3\2\2\2\u00ae\u00af\7\21\2\2\u00af" +
                    "\u00b0\7\3\2\2\u00b0\u00b1\7\32\2\2\u00b1\u00b2\7\4\2\2\u00b2\u00b3\5" +
                    "(\25\2\u00b3%\3\2\2\2\u00b4\u00b5\7\22\2\2\u00b5\u00b6\7\3\2\2\u00b6\u00b7" +
                    "\7\32\2\2\u00b7\u00b8\7\4\2\2\u00b8\u00b9\5\62\32\2\u00b9\'\3\2\2\2\u00ba" +
                    "\u00bf\7\27\2\2\u00bb\u00bc\7\27\2\2\u00bc\u00bd\7\3\2\2\u00bd\u00bf\5" +
                    "(\25\2\u00be\u00ba\3\2\2\2\u00be\u00bb\3\2\2\2\u00bf\u00c2\3\2\2\2\u00c0" +
                    "\u00c2\3\2\2\2\u00c1\u00be\3\2\2\2\u00c1\u00c0\3\2\2\2\u00c2)\3\2\2\2" +
                    "\u00c3\u00c9\5,\27\2\u00c4\u00c5\5,\27\2\u00c5\u00c6\7\3\2\2\u00c6\u00c7" +
                    "\5*\26\2\u00c7\u00c9\3\2\2\2\u00c8\u00c3\3\2\2\2\u00c8\u00c4\3\2\2\2\u00c9" +
                    "+\3\2\2\2\u00ca\u00cf\7\32\2\2\u00cb\u00cf\7\31\2\2\u00cc\u00cf\7\27\2" +
                    "\2\u00cd\u00cf\5.\30\2\u00ce\u00ca\3\2\2\2\u00ce\u00cb\3\2\2\2\u00ce\u00cc" +
                    "\3\2\2\2\u00ce\u00cd\3\2\2\2\u00cf-\3\2\2\2\u00d0\u00d1\t\2\2\2\u00d1" +
                    "/\3\2\2\2\u00d2\u00d5\3\2\2\2\u00d3\u00d5\7\33\2\2\u00d4\u00d2\3\2\2\2" +
                    "\u00d4\u00d3\3\2\2\2\u00d5\61\3\2\2\2\u00d6\u00d9\3\2\2\2\u00d7\u00d9" +
                    "\5(\25\2\u00d8\u00d6\3\2\2\2\u00d8\u00d7\3\2\2\2\u00d9\63\3\2\2\2\u00da" +
                    "\u00dd\3\2\2\2\u00db\u00dd\5*\26\2\u00dc\u00da\3\2\2\2\u00dc\u00db\3\2" +
                    "\2\2\u00dd\65\3\2\2\2\u00de\u00e1\3\2\2\2\u00df\u00e1\7\34\2\2\u00e0\u00de" +
                    "\3\2\2\2\u00e0\u00df\3\2\2\2\u00e1\67\3\2\2\2\u00e2\u00e5\3\2\2\2\u00e3" +
                    "\u00e5\5,\27\2\u00e4\u00e2\3\2\2\2\u00e4\u00e3\3\2\2\2\u00e59\3\2\2\2" +
                    "\u00e6\u00e9\3\2\2\2\u00e7\u00e9\5.\30\2\u00e8\u00e6\3\2\2\2\u00e8\u00e7" +
                    "\3\2\2\2\u00e9;\3\2\2\2\u00ea\u00ed\3\2\2\2\u00eb\u00ed\7\31\2\2\u00ec" +
                    "\u00ea\3\2\2\2\u00ec\u00eb\3\2\2\2\u00ed=\3\2\2\2\u00ee\u00f1\3\2\2\2" +
                    "\u00ef\u00f1\7\30\2\2\u00f0\u00ee\3\2\2\2\u00f0\u00ef\3\2\2\2\u00f1?\3" +
                    "\2\2\2\20CX\u00be\u00c1\u00c8\u00ce\u00d4\u00d8\u00dc\u00e0\u00e4\u00e8" +
                    "\u00ec\u00f0";
    public static final ATN _ATN =
            new ATNDeserializer().deserialize(_serializedATN.toCharArray());

    static {
        _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
        for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
            _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
        }
    }
}