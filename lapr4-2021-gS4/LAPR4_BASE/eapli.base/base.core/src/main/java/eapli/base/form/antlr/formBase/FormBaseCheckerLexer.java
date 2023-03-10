// Generated from C:/Users/pedro/OneDrive/Documentos/Eng.Informática_Projects/2ºAno/LAPR/lapr4-2021-gS4/LAPR4_BASE/eapli.base/base.core/src/main/java/eapli/base/form/antlr/formBase\FormBaseChecker.g4 by ANTLR 4.9.1
package eapli.base.form.antlr.formBase;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class FormBaseCheckerLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, TYPEDATE=8, TYPEOPTIONALDATE=9, 
		TYPEINT=10, TYPEOPTIONALINT=11, TYPESTRING=12, TYPEOPTIONALSTRING=13, 
		TYPEBOOL=14, TYPEOPTIONALBOOL=15, TYPEPHONENUMBER=16, TYPEOPTIONALPHONENUMBER=17, 
		TYPEPOSTALCODE=18, TYPEOPTIONALPOSTALCODE=19, TYPENAME=20, TYPEOPTIONALNAME=21, 
		TYPEADDRESS=22, TYPEOPTIONALADDRESS=23, STRING=24, NEWLINE=25;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "TYPEDATE", "TYPEOPTIONALDATE", 
			"TYPEINT", "TYPEOPTIONALINT", "TYPESTRING", "TYPEOPTIONALSTRING", "TYPEBOOL", 
			"TYPEOPTIONALBOOL", "TYPEPHONENUMBER", "TYPEOPTIONALPHONENUMBER", "TYPEPOSTALCODE", 
			"TYPEOPTIONALPOSTALCODE", "TYPENAME", "TYPEOPTIONALNAME", "TYPEADDRESS", 
			"TYPEOPTIONALADDRESS", "STRING", "NEWLINE"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "' '", "'//'", "':'", "'('", "')'", "'/'", "'\"'", "'Date'", "'OptionalDate'", 
			"'Integer'", "'OptionalInteger'", "'String'", "'OptionalString'", "'Bool'", 
			"'OptionalBool'", "'PhoneNumber'", "'OptionalPhoneNumber'", "'PostalCode'", 
			"'OptionalPostalCode'", "'Name'", "'OptionalName'", "'Address'", "'OptionalAddress'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
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


	public FormBaseCheckerLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "FormBaseChecker.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\33\u010f\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\3\2\3\2\3\3\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3"+
		"\b\3\b\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25"+
		"\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30"+
		"\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\31\6\31\u0100"+
		"\n\31\r\31\16\31\u0101\3\32\5\32\u0105\n\32\3\32\3\32\6\32\u0109\n\32"+
		"\r\32\16\32\u010a\3\32\5\32\u010e\n\32\2\2\33\3\3\5\4\7\5\t\6\13\7\r\b"+
		"\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26"+
		"+\27-\30/\31\61\32\63\33\3\2\3\5\2\62;C\\c|\2\u0113\2\3\3\2\2\2\2\5\3"+
		"\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2"+
		"\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3"+
		"\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'"+
		"\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63"+
		"\3\2\2\2\3\65\3\2\2\2\5\67\3\2\2\2\7:\3\2\2\2\t<\3\2\2\2\13>\3\2\2\2\r"+
		"@\3\2\2\2\17B\3\2\2\2\21D\3\2\2\2\23I\3\2\2\2\25V\3\2\2\2\27^\3\2\2\2"+
		"\31n\3\2\2\2\33u\3\2\2\2\35\u0084\3\2\2\2\37\u0089\3\2\2\2!\u0096\3\2"+
		"\2\2#\u00a2\3\2\2\2%\u00b6\3\2\2\2\'\u00c1\3\2\2\2)\u00d4\3\2\2\2+\u00d9"+
		"\3\2\2\2-\u00e6\3\2\2\2/\u00ee\3\2\2\2\61\u00ff\3\2\2\2\63\u010d\3\2\2"+
		"\2\65\66\7\"\2\2\66\4\3\2\2\2\678\7\61\2\289\7\61\2\29\6\3\2\2\2:;\7<"+
		"\2\2;\b\3\2\2\2<=\7*\2\2=\n\3\2\2\2>?\7+\2\2?\f\3\2\2\2@A\7\61\2\2A\16"+
		"\3\2\2\2BC\7$\2\2C\20\3\2\2\2DE\7F\2\2EF\7c\2\2FG\7v\2\2GH\7g\2\2H\22"+
		"\3\2\2\2IJ\7Q\2\2JK\7r\2\2KL\7v\2\2LM\7k\2\2MN\7q\2\2NO\7p\2\2OP\7c\2"+
		"\2PQ\7n\2\2QR\7F\2\2RS\7c\2\2ST\7v\2\2TU\7g\2\2U\24\3\2\2\2VW\7K\2\2W"+
		"X\7p\2\2XY\7v\2\2YZ\7g\2\2Z[\7i\2\2[\\\7g\2\2\\]\7t\2\2]\26\3\2\2\2^_"+
		"\7Q\2\2_`\7r\2\2`a\7v\2\2ab\7k\2\2bc\7q\2\2cd\7p\2\2de\7c\2\2ef\7n\2\2"+
		"fg\7K\2\2gh\7p\2\2hi\7v\2\2ij\7g\2\2jk\7i\2\2kl\7g\2\2lm\7t\2\2m\30\3"+
		"\2\2\2no\7U\2\2op\7v\2\2pq\7t\2\2qr\7k\2\2rs\7p\2\2st\7i\2\2t\32\3\2\2"+
		"\2uv\7Q\2\2vw\7r\2\2wx\7v\2\2xy\7k\2\2yz\7q\2\2z{\7p\2\2{|\7c\2\2|}\7"+
		"n\2\2}~\7U\2\2~\177\7v\2\2\177\u0080\7t\2\2\u0080\u0081\7k\2\2\u0081\u0082"+
		"\7p\2\2\u0082\u0083\7i\2\2\u0083\34\3\2\2\2\u0084\u0085\7D\2\2\u0085\u0086"+
		"\7q\2\2\u0086\u0087\7q\2\2\u0087\u0088\7n\2\2\u0088\36\3\2\2\2\u0089\u008a"+
		"\7Q\2\2\u008a\u008b\7r\2\2\u008b\u008c\7v\2\2\u008c\u008d\7k\2\2\u008d"+
		"\u008e\7q\2\2\u008e\u008f\7p\2\2\u008f\u0090\7c\2\2\u0090\u0091\7n\2\2"+
		"\u0091\u0092\7D\2\2\u0092\u0093\7q\2\2\u0093\u0094\7q\2\2\u0094\u0095"+
		"\7n\2\2\u0095 \3\2\2\2\u0096\u0097\7R\2\2\u0097\u0098\7j\2\2\u0098\u0099"+
		"\7q\2\2\u0099\u009a\7p\2\2\u009a\u009b\7g\2\2\u009b\u009c\7P\2\2\u009c"+
		"\u009d\7w\2\2\u009d\u009e\7o\2\2\u009e\u009f\7d\2\2\u009f\u00a0\7g\2\2"+
		"\u00a0\u00a1\7t\2\2\u00a1\"\3\2\2\2\u00a2\u00a3\7Q\2\2\u00a3\u00a4\7r"+
		"\2\2\u00a4\u00a5\7v\2\2\u00a5\u00a6\7k\2\2\u00a6\u00a7\7q\2\2\u00a7\u00a8"+
		"\7p\2\2\u00a8\u00a9\7c\2\2\u00a9\u00aa\7n\2\2\u00aa\u00ab\7R\2\2\u00ab"+
		"\u00ac\7j\2\2\u00ac\u00ad\7q\2\2\u00ad\u00ae\7p\2\2\u00ae\u00af\7g\2\2"+
		"\u00af\u00b0\7P\2\2\u00b0\u00b1\7w\2\2\u00b1\u00b2\7o\2\2\u00b2\u00b3"+
		"\7d\2\2\u00b3\u00b4\7g\2\2\u00b4\u00b5\7t\2\2\u00b5$\3\2\2\2\u00b6\u00b7"+
		"\7R\2\2\u00b7\u00b8\7q\2\2\u00b8\u00b9\7u\2\2\u00b9\u00ba\7v\2\2\u00ba"+
		"\u00bb\7c\2\2\u00bb\u00bc\7n\2\2\u00bc\u00bd\7E\2\2\u00bd\u00be\7q\2\2"+
		"\u00be\u00bf\7f\2\2\u00bf\u00c0\7g\2\2\u00c0&\3\2\2\2\u00c1\u00c2\7Q\2"+
		"\2\u00c2\u00c3\7r\2\2\u00c3\u00c4\7v\2\2\u00c4\u00c5\7k\2\2\u00c5\u00c6"+
		"\7q\2\2\u00c6\u00c7\7p\2\2\u00c7\u00c8\7c\2\2\u00c8\u00c9\7n\2\2\u00c9"+
		"\u00ca\7R\2\2\u00ca\u00cb\7q\2\2\u00cb\u00cc\7u\2\2\u00cc\u00cd\7v\2\2"+
		"\u00cd\u00ce\7c\2\2\u00ce\u00cf\7n\2\2\u00cf\u00d0\7E\2\2\u00d0\u00d1"+
		"\7q\2\2\u00d1\u00d2\7f\2\2\u00d2\u00d3\7g\2\2\u00d3(\3\2\2\2\u00d4\u00d5"+
		"\7P\2\2\u00d5\u00d6\7c\2\2\u00d6\u00d7\7o\2\2\u00d7\u00d8\7g\2\2\u00d8"+
		"*\3\2\2\2\u00d9\u00da\7Q\2\2\u00da\u00db\7r\2\2\u00db\u00dc\7v\2\2\u00dc"+
		"\u00dd\7k\2\2\u00dd\u00de\7q\2\2\u00de\u00df\7p\2\2\u00df\u00e0\7c\2\2"+
		"\u00e0\u00e1\7n\2\2\u00e1\u00e2\7P\2\2\u00e2\u00e3\7c\2\2\u00e3\u00e4"+
		"\7o\2\2\u00e4\u00e5\7g\2\2\u00e5,\3\2\2\2\u00e6\u00e7\7C\2\2\u00e7\u00e8"+
		"\7f\2\2\u00e8\u00e9\7f\2\2\u00e9\u00ea\7t\2\2\u00ea\u00eb\7g\2\2\u00eb"+
		"\u00ec\7u\2\2\u00ec\u00ed\7u\2\2\u00ed.\3\2\2\2\u00ee\u00ef\7Q\2\2\u00ef"+
		"\u00f0\7r\2\2\u00f0\u00f1\7v\2\2\u00f1\u00f2\7k\2\2\u00f2\u00f3\7q\2\2"+
		"\u00f3\u00f4\7p\2\2\u00f4\u00f5\7c\2\2\u00f5\u00f6\7n\2\2\u00f6\u00f7"+
		"\7C\2\2\u00f7\u00f8\7f\2\2\u00f8\u00f9\7f\2\2\u00f9\u00fa\7t\2\2\u00fa"+
		"\u00fb\7g\2\2\u00fb\u00fc\7u\2\2\u00fc\u00fd\7u\2\2\u00fd\60\3\2\2\2\u00fe"+
		"\u0100\t\2\2\2\u00ff\u00fe\3\2\2\2\u0100\u0101\3\2\2\2\u0101\u00ff\3\2"+
		"\2\2\u0101\u0102\3\2\2\2\u0102\62\3\2\2\2\u0103\u0105\7\17\2\2\u0104\u0103"+
		"\3\2\2\2\u0104\u0105\3\2\2\2\u0105\u0106\3\2\2\2\u0106\u0109\7\f\2\2\u0107"+
		"\u0109\7\17\2\2\u0108\u0104\3\2\2\2\u0108\u0107\3\2\2\2\u0109\u010a\3"+
		"\2\2\2\u010a\u0108\3\2\2\2\u010a\u010b\3\2\2\2\u010b\u010e\3\2\2\2\u010c"+
		"\u010e\7\2\2\3\u010d\u0108\3\2\2\2\u010d\u010c\3\2\2\2\u010e\64\3\2\2"+
		"\2\b\2\u0101\u0104\u0108\u010a\u010d\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}