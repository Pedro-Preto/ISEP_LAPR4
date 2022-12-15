// Generated from C:/Users/Pedro/Documents/lei20_21_s4_2dh_01/LAPR4_BASE/eapli.base/base.core/src/main/java/eapli/base/form/antlr/formRequest2\FormChecker2.g4 by ANTLR 4.9.1
package eapli.base.form.antlr.formRequest2;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class FormChecker2Lexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, TYPEDATE=3, TYPEINT=4, TYPESTRING=5, TYPEBOOL=6, TYPEPHONENUMBER=7, 
		TYPEPOSTALCODE=8, TYPENAME=9, TYPEADDRESS=10, DASH=11, FSLASH=12, STRING=13, 
		NEWLINE=14;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "TYPEDATE", "TYPEINT", "TYPESTRING", "TYPEBOOL", "TYPEPHONENUMBER", 
			"TYPEPOSTALCODE", "TYPENAME", "TYPEADDRESS", "DASH", "FSLASH", "STRING", 
			"NEWLINE"
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


	public FormChecker2Lexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "FormChecker2.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\20\u00f0\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\3\2\3\2\3\3\3\3\3\3\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4\65\n\4"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\5\5M\n\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6c\n\6\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7u\n\7\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b\u0095\n\b\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\5\t\u00b3\n\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u00c5\n\n\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\5\13\u00dd\n\13\3\f\3\f\3\r\3\r\3\16\6\16\u00e4\n\16\r\16\16"+
		"\16\u00e5\3\17\5\17\u00e9\n\17\3\17\3\17\6\17\u00ed\n\17\r\17\16\17\u00ee"+
		"\2\2\20\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17"+
		"\35\20\3\2\3\5\2\62;C\\c|\2\u00fb\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2"+
		"\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3"+
		"\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2"+
		"\2\3\37\3\2\2\2\5!\3\2\2\2\7\64\3\2\2\2\tL\3\2\2\2\13b\3\2\2\2\rt\3\2"+
		"\2\2\17\u0094\3\2\2\2\21\u00b2\3\2\2\2\23\u00c4\3\2\2\2\25\u00dc\3\2\2"+
		"\2\27\u00de\3\2\2\2\31\u00e0\3\2\2\2\33\u00e3\3\2\2\2\35\u00ec\3\2\2\2"+
		"\37 \7\"\2\2 \4\3\2\2\2!\"\7<\2\2\"#\7\"\2\2#\6\3\2\2\2$%\7F\2\2%&\7c"+
		"\2\2&\'\7v\2\2\'\65\7g\2\2()\7Q\2\2)*\7r\2\2*+\7v\2\2+,\7k\2\2,-\7q\2"+
		"\2-.\7p\2\2./\7c\2\2/\60\7n\2\2\60\61\7F\2\2\61\62\7c\2\2\62\63\7v\2\2"+
		"\63\65\7g\2\2\64$\3\2\2\2\64(\3\2\2\2\65\b\3\2\2\2\66\67\7K\2\2\678\7"+
		"p\2\289\7v\2\29:\7g\2\2:;\7i\2\2;<\7g\2\2<M\7t\2\2=>\7Q\2\2>?\7r\2\2?"+
		"@\7v\2\2@A\7k\2\2AB\7q\2\2BC\7p\2\2CD\7c\2\2DE\7n\2\2EF\7K\2\2FG\7p\2"+
		"\2GH\7v\2\2HI\7g\2\2IJ\7i\2\2JK\7g\2\2KM\7t\2\2L\66\3\2\2\2L=\3\2\2\2"+
		"M\n\3\2\2\2NO\7U\2\2OP\7v\2\2PQ\7t\2\2QR\7k\2\2RS\7p\2\2Sc\7i\2\2TU\7"+
		"Q\2\2UV\7r\2\2VW\7v\2\2WX\7k\2\2XY\7q\2\2YZ\7p\2\2Z[\7c\2\2[\\\7n\2\2"+
		"\\]\7U\2\2]^\7v\2\2^_\7t\2\2_`\7k\2\2`a\7p\2\2ac\7i\2\2bN\3\2\2\2bT\3"+
		"\2\2\2c\f\3\2\2\2de\7D\2\2ef\7q\2\2fg\7q\2\2gu\7n\2\2hi\7Q\2\2ij\7r\2"+
		"\2jk\7v\2\2kl\7k\2\2lm\7q\2\2mn\7p\2\2no\7c\2\2op\7n\2\2pq\7D\2\2qr\7"+
		"q\2\2rs\7q\2\2su\7n\2\2td\3\2\2\2th\3\2\2\2u\16\3\2\2\2vw\7R\2\2wx\7j"+
		"\2\2xy\7q\2\2yz\7p\2\2z{\7g\2\2{|\7P\2\2|}\7w\2\2}~\7o\2\2~\177\7d\2\2"+
		"\177\u0080\7g\2\2\u0080\u0095\7t\2\2\u0081\u0082\7Q\2\2\u0082\u0083\7"+
		"r\2\2\u0083\u0084\7v\2\2\u0084\u0085\7k\2\2\u0085\u0086\7q\2\2\u0086\u0087"+
		"\7p\2\2\u0087\u0088\7c\2\2\u0088\u0089\7n\2\2\u0089\u008a\7R\2\2\u008a"+
		"\u008b\7j\2\2\u008b\u008c\7q\2\2\u008c\u008d\7p\2\2\u008d\u008e\7g\2\2"+
		"\u008e\u008f\7P\2\2\u008f\u0090\7w\2\2\u0090\u0091\7o\2\2\u0091\u0092"+
		"\7d\2\2\u0092\u0093\7g\2\2\u0093\u0095\7t\2\2\u0094v\3\2\2\2\u0094\u0081"+
		"\3\2\2\2\u0095\20\3\2\2\2\u0096\u0097\7R\2\2\u0097\u0098\7q\2\2\u0098"+
		"\u0099\7u\2\2\u0099\u009a\7v\2\2\u009a\u009b\7c\2\2\u009b\u009c\7n\2\2"+
		"\u009c\u009d\7E\2\2\u009d\u009e\7q\2\2\u009e\u009f\7f\2\2\u009f\u00b3"+
		"\7g\2\2\u00a0\u00a1\7Q\2\2\u00a1\u00a2\7r\2\2\u00a2\u00a3\7v\2\2\u00a3"+
		"\u00a4\7k\2\2\u00a4\u00a5\7q\2\2\u00a5\u00a6\7p\2\2\u00a6\u00a7\7c\2\2"+
		"\u00a7\u00a8\7n\2\2\u00a8\u00a9\7R\2\2\u00a9\u00aa\7q\2\2\u00aa\u00ab"+
		"\7u\2\2\u00ab\u00ac\7v\2\2\u00ac\u00ad\7c\2\2\u00ad\u00ae\7n\2\2\u00ae"+
		"\u00af\7E\2\2\u00af\u00b0\7q\2\2\u00b0\u00b1\7f\2\2\u00b1\u00b3\7g\2\2"+
		"\u00b2\u0096\3\2\2\2\u00b2\u00a0\3\2\2\2\u00b3\22\3\2\2\2\u00b4\u00b5"+
		"\7P\2\2\u00b5\u00b6\7c\2\2\u00b6\u00b7\7o\2\2\u00b7\u00c5\7g\2\2\u00b8"+
		"\u00b9\7Q\2\2\u00b9\u00ba\7r\2\2\u00ba\u00bb\7v\2\2\u00bb\u00bc\7k\2\2"+
		"\u00bc\u00bd\7q\2\2\u00bd\u00be\7p\2\2\u00be\u00bf\7c\2\2\u00bf\u00c0"+
		"\7n\2\2\u00c0\u00c1\7P\2\2\u00c1\u00c2\7c\2\2\u00c2\u00c3\7o\2\2\u00c3"+
		"\u00c5\7g\2\2\u00c4\u00b4\3\2\2\2\u00c4\u00b8\3\2\2\2\u00c5\24\3\2\2\2"+
		"\u00c6\u00c7\7C\2\2\u00c7\u00c8\7f\2\2\u00c8\u00c9\7f\2\2\u00c9\u00ca"+
		"\7t\2\2\u00ca\u00cb\7g\2\2\u00cb\u00cc\7u\2\2\u00cc\u00dd\7u\2\2\u00cd"+
		"\u00ce\7Q\2\2\u00ce\u00cf\7r\2\2\u00cf\u00d0\7v\2\2\u00d0\u00d1\7k\2\2"+
		"\u00d1\u00d2\7q\2\2\u00d2\u00d3\7p\2\2\u00d3\u00d4\7c\2\2\u00d4\u00d5"+
		"\7n\2\2\u00d5\u00d6\7C\2\2\u00d6\u00d7\7f\2\2\u00d7\u00d8\7f\2\2\u00d8"+
		"\u00d9\7t\2\2\u00d9\u00da\7g\2\2\u00da\u00db\7u\2\2\u00db\u00dd\7u\2\2"+
		"\u00dc\u00c6\3\2\2\2\u00dc\u00cd\3\2\2\2\u00dd\26\3\2\2\2\u00de\u00df"+
		"\7/\2\2\u00df\30\3\2\2\2\u00e0\u00e1\7\61\2\2\u00e1\32\3\2\2\2\u00e2\u00e4"+
		"\t\2\2\2\u00e3\u00e2\3\2\2\2\u00e4\u00e5\3\2\2\2\u00e5\u00e3\3\2\2\2\u00e5"+
		"\u00e6\3\2\2\2\u00e6\34\3\2\2\2\u00e7\u00e9\7\17\2\2\u00e8\u00e7\3\2\2"+
		"\2\u00e8\u00e9\3\2\2\2\u00e9\u00ea\3\2\2\2\u00ea\u00ed\7\f\2\2\u00eb\u00ed"+
		"\7\17\2\2\u00ec\u00e8\3\2\2\2\u00ec\u00eb\3\2\2\2\u00ed\u00ee\3\2\2\2"+
		"\u00ee\u00ec\3\2\2\2\u00ee\u00ef\3\2\2\2\u00ef\36\3\2\2\2\17\2\64Lbt\u0094"+
		"\u00b2\u00c4\u00dc\u00e5\u00e8\u00ec\u00ee\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}