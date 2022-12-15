// Generated from C:/Users/pedro/OneDrive/Documentos/Eng.Informática_Projects/2ºAno/LAPR/lapr4-2021-gS4/LAPR4_BASE/eapli.base/base.core/src/main/java/eapli/base/form/antlr/formBase\FormBaseChecker.g4 by ANTLR 4.9.1
package eapli.base.form.antlr.formBase;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class FormBaseCheckerParser extends Parser {
    static {
        RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION);
    }

    protected static final DFA[] _decisionToDFA;
    protected static final PredictionContextCache _sharedContextCache =
            new PredictionContextCache();
    public static final int
            T__0 = 1, T__1 = 2, T__2 = 3, T__3 = 4, T__4 = 5, T__5 = 6, T__6 = 7, TYPEDATE = 8, TYPEOPTIONALDATE = 9,
            TYPEINT = 10, TYPEOPTIONALINT = 11, TYPESTRING = 12, TYPEOPTIONALSTRING = 13,
            TYPEBOOL = 14, TYPEOPTIONALBOOL = 15, TYPEPHONENUMBER = 16, TYPEOPTIONALPHONENUMBER = 17,
            TYPEPOSTALCODE = 18, TYPEOPTIONALPOSTALCODE = 19, TYPENAME = 20, TYPEOPTIONALNAME = 21,
            TYPEADDRESS = 22, TYPEOPTIONALADDRESS = 23, STRING = 24, NEWLINE = 25;
    public static final int
            RULE_lprog = 0, RULE_start = 1, RULE_joinedParameters = 2, RULE_parameterType = 3,
            RULE_parameterLabel = 4, RULE_stringPossibilities = 5;

    private static String[] makeRuleNames() {
        return new String[]{
                "lprog", "start", "joinedParameters", "parameterType", "parameterLabel",
                "stringPossibilities"
        };
    }

    public static final String[] ruleNames = makeRuleNames();

    private static String[] makeLiteralNames() {
        return new String[]{
                null, "' '", "'//'", "':'", "'('", "')'", "'/'", "'\"'", "'Date'", "'OptionalDate'",
                "'Integer'", "'OptionalInteger'", "'String'", "'OptionalString'", "'Bool'",
                "'OptionalBool'", "'PhoneNumber'", "'OptionalPhoneNumber'", "'PostalCode'",
                "'OptionalPostalCode'", "'Name'", "'OptionalName'", "'Address'", "'OptionalAddress'"
        };
    }

    private static final String[] _LITERAL_NAMES = makeLiteralNames();

    private static String[] makeSymbolicNames() {
        return new String[]{
                null, null, null, null, null, null, null, null, "TYPEDATE", "TYPEOPTIONALDATE",
                "TYPEINT", "TYPEOPTIONALINT", "TYPESTRING", "TYPEOPTIONALSTRING", "TYPEBOOL",
                "TYPEOPTIONALBOOL", "TYPEPHONENUMBER", "TYPEOPTIONALPHONENUMBER", "TYPEPOSTALCODE",
                "TYPEOPTIONALPOSTALCODE", "TYPENAME", "TYPEOPTIONALNAME", "TYPEADDRESS",
                "TYPEOPTIONALADDRESS", "STRING", "NEWLINE"
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
        return "FormBaseChecker.g4";
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

    public FormBaseCheckerParser(TokenStream input) {
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
            if (listener instanceof FormBaseCheckerListener) ((FormBaseCheckerListener) listener).enterLprog(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof FormBaseCheckerListener) ((FormBaseCheckerListener) listener).exitLprog(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof FormBaseCheckerVisitor)
                return ((FormBaseCheckerVisitor<? extends T>) visitor).visitLprog(this);
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
                setState(13);
                _errHandler.sync(this);
                _la = _input.LA(1);
                do {
                    {
                        {
                            setState(12);
                            start();
                        }
                    }
                    setState(15);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                } while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << TYPEDATE) | (1L << TYPEOPTIONALDATE) | (1L << TYPEINT) | (1L << TYPEOPTIONALINT) | (1L << TYPESTRING) | (1L << TYPEOPTIONALSTRING) | (1L << TYPEBOOL) | (1L << TYPEOPTIONALBOOL) | (1L << TYPEPHONENUMBER) | (1L << TYPEOPTIONALPHONENUMBER) | (1L << TYPEPOSTALCODE) | (1L << TYPEOPTIONALPOSTALCODE) | (1L << TYPENAME) | (1L << TYPEADDRESS) | (1L << TYPEOPTIONALADDRESS))) != 0));
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class StartContext extends ParserRuleContext {
        public JoinedParametersContext joinedParameters() {
            return getRuleContext(JoinedParametersContext.class, 0);
        }

        public TerminalNode NEWLINE() {
            return getToken(FormBaseCheckerParser.NEWLINE, 0);
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
            if (listener instanceof FormBaseCheckerListener) ((FormBaseCheckerListener) listener).enterStart(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof FormBaseCheckerListener) ((FormBaseCheckerListener) listener).exitStart(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof FormBaseCheckerVisitor)
                return ((FormBaseCheckerVisitor<? extends T>) visitor).visitStart(this);
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
                    setState(17);
                    joinedParameters();
                    setState(18);
                    match(NEWLINE);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class JoinedParametersContext extends ParserRuleContext {
        public ParameterTypeContext parameterType() {
            return getRuleContext(ParameterTypeContext.class, 0);
        }

        public TerminalNode STRING() {
            return getToken(FormBaseCheckerParser.STRING, 0);
        }

        public ParameterLabelContext parameterLabel() {
            return getRuleContext(ParameterLabelContext.class, 0);
        }

        public JoinedParametersContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_joinedParameters;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof FormBaseCheckerListener)
                ((FormBaseCheckerListener) listener).enterJoinedParameters(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof FormBaseCheckerListener)
                ((FormBaseCheckerListener) listener).exitJoinedParameters(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof FormBaseCheckerVisitor)
                return ((FormBaseCheckerVisitor<? extends T>) visitor).visitJoinedParameters(this);
            else return visitor.visitChildren(this);
        }
    }

    public final JoinedParametersContext joinedParameters() throws RecognitionException {
        JoinedParametersContext _localctx = new JoinedParametersContext(_ctx, getState());
        enterRule(_localctx, 4, RULE_joinedParameters);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(20);
                parameterType();
                setState(21);
                match(T__0);
                setState(22);
                match(STRING);
                setState(23);
                match(T__1);
                setState(24);
                parameterLabel();
                setState(25);
                match(T__2);
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

    public static class ParameterTypeContext extends ParserRuleContext {
        public TerminalNode TYPEDATE() {
            return getToken(FormBaseCheckerParser.TYPEDATE, 0);
        }

        public TerminalNode TYPEINT() {
            return getToken(FormBaseCheckerParser.TYPEINT, 0);
        }

        public TerminalNode TYPESTRING() {
            return getToken(FormBaseCheckerParser.TYPESTRING, 0);
        }

        public TerminalNode TYPEBOOL() {
            return getToken(FormBaseCheckerParser.TYPEBOOL, 0);
        }

        public TerminalNode TYPENAME() {
            return getToken(FormBaseCheckerParser.TYPENAME, 0);
        }

        public TerminalNode TYPEADDRESS() {
            return getToken(FormBaseCheckerParser.TYPEADDRESS, 0);
        }

        public TerminalNode TYPEPHONENUMBER() {
            return getToken(FormBaseCheckerParser.TYPEPHONENUMBER, 0);
        }

        public TerminalNode TYPEPOSTALCODE() {
            return getToken(FormBaseCheckerParser.TYPEPOSTALCODE, 0);
        }

        public TerminalNode TYPEOPTIONALDATE() {
            return getToken(FormBaseCheckerParser.TYPEOPTIONALDATE, 0);
        }

        public TerminalNode TYPEOPTIONALINT() {
            return getToken(FormBaseCheckerParser.TYPEOPTIONALINT, 0);
        }

        public TerminalNode TYPEOPTIONALSTRING() {
            return getToken(FormBaseCheckerParser.TYPEOPTIONALSTRING, 0);
        }

        public TerminalNode TYPEOPTIONALBOOL() {
            return getToken(FormBaseCheckerParser.TYPEOPTIONALBOOL, 0);
        }

        public TerminalNode TYPEOPTIONALPHONENUMBER() {
            return getToken(FormBaseCheckerParser.TYPEOPTIONALPHONENUMBER, 0);
        }

        public TerminalNode TYPEOPTIONALPOSTALCODE() {
            return getToken(FormBaseCheckerParser.TYPEOPTIONALPOSTALCODE, 0);
        }

        public TerminalNode TYPEOPTIONALADDRESS() {
            return getToken(FormBaseCheckerParser.TYPEOPTIONALADDRESS, 0);
        }

        public ParameterTypeContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_parameterType;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof FormBaseCheckerListener)
                ((FormBaseCheckerListener) listener).enterParameterType(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof FormBaseCheckerListener)
                ((FormBaseCheckerListener) listener).exitParameterType(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof FormBaseCheckerVisitor)
                return ((FormBaseCheckerVisitor<? extends T>) visitor).visitParameterType(this);
            else return visitor.visitChildren(this);
        }
    }

    public final ParameterTypeContext parameterType() throws RecognitionException {
        ParameterTypeContext _localctx = new ParameterTypeContext(_ctx, getState());
        enterRule(_localctx, 6, RULE_parameterType);
        try {
            setState(44);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 1, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(27);
                    match(TYPEDATE);
                }
                break;
                case 2:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(28);
                    match(TYPEINT);
                }
                break;
                case 3:
                    enterOuterAlt(_localctx, 3);
                {
                    setState(29);
                    match(TYPESTRING);
                }
                break;
                case 4:
                    enterOuterAlt(_localctx, 4);
                {
                    setState(30);
                    match(TYPEBOOL);
                }
                break;
                case 5:
                    enterOuterAlt(_localctx, 5);
                {
                    setState(31);
                    match(TYPENAME);
                }
                break;
                case 6:
                    enterOuterAlt(_localctx, 6);
                {
                    setState(32);
                    match(TYPEADDRESS);
                }
                break;
                case 7:
                    enterOuterAlt(_localctx, 7);
                {
                    setState(33);
                    match(TYPEPHONENUMBER);
                }
                break;
                case 8:
                    enterOuterAlt(_localctx, 8);
                {
                    setState(34);
                    match(TYPEPOSTALCODE);
                }
                break;
                case 9:
                    enterOuterAlt(_localctx, 9);
                {
                    setState(35);
                    match(TYPEOPTIONALDATE);
                }
                break;
                case 10:
                    enterOuterAlt(_localctx, 10);
                {
                    setState(36);
                    match(TYPEOPTIONALINT);
                }
                break;
                case 11:
                    enterOuterAlt(_localctx, 11);
                {
                    setState(37);
                    match(TYPEOPTIONALSTRING);
                }
                break;
                case 12:
                    enterOuterAlt(_localctx, 12);
                {
                    setState(38);
                    match(TYPEOPTIONALBOOL);
                }
                break;
                case 13:
                    enterOuterAlt(_localctx, 13);
                {
                    setState(39);
                    match(TYPEOPTIONALPHONENUMBER);
                }
                break;
                case 14:
                    enterOuterAlt(_localctx, 14);
                {
                    setState(40);
                    match(TYPEOPTIONALPOSTALCODE);
                }
                break;
                case 15:
                    enterOuterAlt(_localctx, 15);
                {
                    setState(41);
                    match(TYPENAME);
                }
                break;
                case 16:
                    enterOuterAlt(_localctx, 16);
                {
                    setState(42);
                    match(TYPEOPTIONALADDRESS);
                }
                break;
                case 17:
                    enterOuterAlt(_localctx, 17);
                {
                }
                break;
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

    public static class ParameterLabelContext extends ParserRuleContext {
        public StringPossibilitiesContext stringPossibilities() {
            return getRuleContext(StringPossibilitiesContext.class, 0);
        }

        public ParameterLabelContext parameterLabel() {
            return getRuleContext(ParameterLabelContext.class, 0);
        }

        public ParameterLabelContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_parameterLabel;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof FormBaseCheckerListener)
                ((FormBaseCheckerListener) listener).enterParameterLabel(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof FormBaseCheckerListener)
                ((FormBaseCheckerListener) listener).exitParameterLabel(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof FormBaseCheckerVisitor)
                return ((FormBaseCheckerVisitor<? extends T>) visitor).visitParameterLabel(this);
            else return visitor.visitChildren(this);
        }
    }

    public final ParameterLabelContext parameterLabel() throws RecognitionException {
        ParameterLabelContext _localctx = new ParameterLabelContext(_ctx, getState());
        enterRule(_localctx, 8, RULE_parameterLabel);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(54);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 2, _ctx)) {
                    case 1: {
                        setState(46);
                        stringPossibilities();
                    }
                    break;
                    case 2: {
                        setState(47);
                        stringPossibilities();
                        setState(48);
                        match(T__0);
                        setState(49);
                        parameterLabel();
                    }
                    break;
                    case 3: {
                        setState(51);
                        stringPossibilities();
                        setState(52);
                        parameterLabel();
                    }
                    break;
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

    public static class StringPossibilitiesContext extends ParserRuleContext {
        public TerminalNode STRING() {
            return getToken(FormBaseCheckerParser.STRING, 0);
        }

        public StringPossibilitiesContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_stringPossibilities;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof FormBaseCheckerListener)
                ((FormBaseCheckerListener) listener).enterStringPossibilities(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof FormBaseCheckerListener)
                ((FormBaseCheckerListener) listener).exitStringPossibilities(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof FormBaseCheckerVisitor)
                return ((FormBaseCheckerVisitor<? extends T>) visitor).visitStringPossibilities(this);
            else return visitor.visitChildren(this);
        }
    }

    public final StringPossibilitiesContext stringPossibilities() throws RecognitionException {
        StringPossibilitiesContext _localctx = new StringPossibilitiesContext(_ctx, getState());
        enterRule(_localctx, 10, RULE_stringPossibilities);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(56);
                _la = _input.LA(1);
                if (!((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << STRING))) != 0))) {
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

    public static final String _serializedATN =
            "\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\33=\4\2\t\2\4\3\t" +
                    "\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\3\2\6\2\20\n\2\r\2\16\2\21\3\3\3\3" +
                    "\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3" +
                    "\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5/\n\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3" +
                    "\6\5\69\n\6\3\7\3\7\3\7\2\2\b\2\4\6\b\n\f\2\3\4\2\6\t\32\32\2I\2\17\3" +
                    "\2\2\2\4\23\3\2\2\2\6\26\3\2\2\2\b.\3\2\2\2\n8\3\2\2\2\f:\3\2\2\2\16\20" +
                    "\5\4\3\2\17\16\3\2\2\2\20\21\3\2\2\2\21\17\3\2\2\2\21\22\3\2\2\2\22\3" +
                    "\3\2\2\2\23\24\5\6\4\2\24\25\7\33\2\2\25\5\3\2\2\2\26\27\5\b\5\2\27\30" +
                    "\7\3\2\2\30\31\7\32\2\2\31\32\7\4\2\2\32\33\5\n\6\2\33\34\7\5\2\2\34\7" +
                    "\3\2\2\2\35/\7\n\2\2\36/\7\f\2\2\37/\7\16\2\2 /\7\20\2\2!/\7\26\2\2\"" +
                    "/\7\30\2\2#/\7\22\2\2$/\7\24\2\2%/\7\13\2\2&/\7\r\2\2\'/\7\17\2\2(/\7" +
                    "\21\2\2)/\7\23\2\2*/\7\25\2\2+/\7\26\2\2,/\7\31\2\2-/\3\2\2\2.\35\3\2" +
                    "\2\2.\36\3\2\2\2.\37\3\2\2\2. \3\2\2\2.!\3\2\2\2.\"\3\2\2\2.#\3\2\2\2" +
                    ".$\3\2\2\2.%\3\2\2\2.&\3\2\2\2.\'\3\2\2\2.(\3\2\2\2.)\3\2\2\2.*\3\2\2" +
                    "\2.+\3\2\2\2.,\3\2\2\2.-\3\2\2\2/\t\3\2\2\2\609\5\f\7\2\61\62\5\f\7\2" +
                    "\62\63\7\3\2\2\63\64\5\n\6\2\649\3\2\2\2\65\66\5\f\7\2\66\67\5\n\6\2\67" +
                    "9\3\2\2\28\60\3\2\2\28\61\3\2\2\28\65\3\2\2\29\13\3\2\2\2:;\t\2\2\2;\r" +
                    "\3\2\2\2\5\21.8";
    public static final ATN _ATN =
            new ATNDeserializer().deserialize(_serializedATN.toCharArray());

    static {
        _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
        for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
            _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
        }
    }
}