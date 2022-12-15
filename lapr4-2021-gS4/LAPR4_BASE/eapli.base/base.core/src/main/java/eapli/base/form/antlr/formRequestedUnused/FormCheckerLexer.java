// Generated from C:/Users/pedro/OneDrive/Documentos/Eng.Informática_Projects/2ºAno/LAPR/lapr4-2021-gS4/LAPR4_BASE/eapli.base/base.core/src/main/java/eapli/base/form/antlr/formRequested\FormChecker.g4 by ANTLR 4.9.1
package eapli.base.form.antlr.formRequestedUnused;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class FormCheckerLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, TYPEDATE=3, TYPEOPTIONALDATE=4, TYPEINT=5, TYPEOPTIONALINT=6, 
		TYPESTRING=7, TYPEOPTIONALSTRING=8, TYPEBOOL=9, TYPEOPTIONALBOOL=10, TYPEPHONENUMBER=11, 
		TYPEOPTIONALPHONENUMBER=12, TYPEPOSTALCODE=13, TYPEOPTIONALPOSTALCODE=14, 
		TYPENAME=15, TYPEOPTIONALNAME=16, TYPEADDRESS=17, TYPEOPTIONALADDRESS=18, 
		TRUE=19, FALSE=20, NAME=21, PHONENUMBER=22, INT=23, STRING=24, DATE=25, 
		POSTALCODE=26, NEWLINE=27;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "TYPEDATE", "TYPEOPTIONALDATE", "TYPEINT", "TYPEOPTIONALINT", 
			"TYPESTRING", "TYPEOPTIONALSTRING", "TYPEBOOL", "TYPEOPTIONALBOOL", "TYPEPHONENUMBER", 
			"TYPEOPTIONALPHONENUMBER", "TYPEPOSTALCODE", "TYPEOPTIONALPOSTALCODE", 
			"TYPENAME", "TYPEOPTIONALNAME", "TYPEADDRESS", "TYPEOPTIONALADDRESS", 
			"TRUE", "FALSE", "NAME", "PHONENUMBER", "INT", "STRING", "DATE", "POSTALCODE", 
			"NEWLINE"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "' '", "': '", "'Date'", "'OptionalDate'", "'Integer'", "'OptionalInteger'", 
			"'String'", "'OptionalString'", "'Bool'", "'OptionalBool'", "'PhoneNumber'", 
			"'OptionalPhoneNumber'", "'PostalCode'", "'OptionalPostalCode'", "'Name'", 
			"'OptionalName'", "'Address'", "'OptionalAddress'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
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


	public FormCheckerLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "FormChecker.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\35\u0158\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\3\2\3\2\3\3\3\3\3\3\3\4\3\4\3\4\3"+
		"\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\5\24\u0101\n\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\5\25\u010d\n\25\3\26\3\26\6\26\u0111\n\26\r\26\16\26\u0112"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\30\6\30\u0120\n\30"+
		"\r\30\16\30\u0121\3\31\6\31\u0125\n\31\r\31\16\31\u0126\3\32\5\32\u012a"+
		"\n\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\5\32\u0133\n\32\3\32\3\32\5\32"+
		"\u0137\n\32\3\32\3\32\3\32\5\32\u013c\n\32\3\32\3\32\3\32\3\32\3\32\3"+
		"\32\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\34\5\34\u014e\n\34"+
		"\3\34\3\34\6\34\u0152\n\34\r\34\16\34\u0153\3\34\5\34\u0157\n\34\2\2\35"+
		"\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20"+
		"\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\35\3\2\13"+
		"\3\2C\\\3\2c|\4\2\64\64;;\3\2\62;\5\2\62;C\\c|\3\2\63;\3\2\62\63\3\2\62"+
		"\64\3\2\64;\2\u0166\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2"+
		"\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3"+
		"\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2"+
		"\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2"+
		"\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2"+
		"\2\2\39\3\2\2\2\5;\3\2\2\2\7>\3\2\2\2\tC\3\2\2\2\13P\3\2\2\2\rX\3\2\2"+
		"\2\17h\3\2\2\2\21o\3\2\2\2\23~\3\2\2\2\25\u0083\3\2\2\2\27\u0090\3\2\2"+
		"\2\31\u009c\3\2\2\2\33\u00b0\3\2\2\2\35\u00bb\3\2\2\2\37\u00ce\3\2\2\2"+
		"!\u00d3\3\2\2\2#\u00e0\3\2\2\2%\u00e8\3\2\2\2\'\u0100\3\2\2\2)\u010c\3"+
		"\2\2\2+\u010e\3\2\2\2-\u0114\3\2\2\2/\u011f\3\2\2\2\61\u0124\3\2\2\2\63"+
		"\u0132\3\2\2\2\65\u0143\3\2\2\2\67\u0156\3\2\2\29:\7\"\2\2:\4\3\2\2\2"+
		";<\7<\2\2<=\7\"\2\2=\6\3\2\2\2>?\7F\2\2?@\7c\2\2@A\7v\2\2AB\7g\2\2B\b"+
		"\3\2\2\2CD\7Q\2\2DE\7r\2\2EF\7v\2\2FG\7k\2\2GH\7q\2\2HI\7p\2\2IJ\7c\2"+
		"\2JK\7n\2\2KL\7F\2\2LM\7c\2\2MN\7v\2\2NO\7g\2\2O\n\3\2\2\2PQ\7K\2\2QR"+
		"\7p\2\2RS\7v\2\2ST\7g\2\2TU\7i\2\2UV\7g\2\2VW\7t\2\2W\f\3\2\2\2XY\7Q\2"+
		"\2YZ\7r\2\2Z[\7v\2\2[\\\7k\2\2\\]\7q\2\2]^\7p\2\2^_\7c\2\2_`\7n\2\2`a"+
		"\7K\2\2ab\7p\2\2bc\7v\2\2cd\7g\2\2de\7i\2\2ef\7g\2\2fg\7t\2\2g\16\3\2"+
		"\2\2hi\7U\2\2ij\7v\2\2jk\7t\2\2kl\7k\2\2lm\7p\2\2mn\7i\2\2n\20\3\2\2\2"+
		"op\7Q\2\2pq\7r\2\2qr\7v\2\2rs\7k\2\2st\7q\2\2tu\7p\2\2uv\7c\2\2vw\7n\2"+
		"\2wx\7U\2\2xy\7v\2\2yz\7t\2\2z{\7k\2\2{|\7p\2\2|}\7i\2\2}\22\3\2\2\2~"+
		"\177\7D\2\2\177\u0080\7q\2\2\u0080\u0081\7q\2\2\u0081\u0082\7n\2\2\u0082"+
		"\24\3\2\2\2\u0083\u0084\7Q\2\2\u0084\u0085\7r\2\2\u0085\u0086\7v\2\2\u0086"+
		"\u0087\7k\2\2\u0087\u0088\7q\2\2\u0088\u0089\7p\2\2\u0089\u008a\7c\2\2"+
		"\u008a\u008b\7n\2\2\u008b\u008c\7D\2\2\u008c\u008d\7q\2\2\u008d\u008e"+
		"\7q\2\2\u008e\u008f\7n\2\2\u008f\26\3\2\2\2\u0090\u0091\7R\2\2\u0091\u0092"+
		"\7j\2\2\u0092\u0093\7q\2\2\u0093\u0094\7p\2\2\u0094\u0095\7g\2\2\u0095"+
		"\u0096\7P\2\2\u0096\u0097\7w\2\2\u0097\u0098\7o\2\2\u0098\u0099\7d\2\2"+
		"\u0099\u009a\7g\2\2\u009a\u009b\7t\2\2\u009b\30\3\2\2\2\u009c\u009d\7"+
		"Q\2\2\u009d\u009e\7r\2\2\u009e\u009f\7v\2\2\u009f\u00a0\7k\2\2\u00a0\u00a1"+
		"\7q\2\2\u00a1\u00a2\7p\2\2\u00a2\u00a3\7c\2\2\u00a3\u00a4\7n\2\2\u00a4"+
		"\u00a5\7R\2\2\u00a5\u00a6\7j\2\2\u00a6\u00a7\7q\2\2\u00a7\u00a8\7p\2\2"+
		"\u00a8\u00a9\7g\2\2\u00a9\u00aa\7P\2\2\u00aa\u00ab\7w\2\2\u00ab\u00ac"+
		"\7o\2\2\u00ac\u00ad\7d\2\2\u00ad\u00ae\7g\2\2\u00ae\u00af\7t\2\2\u00af"+
		"\32\3\2\2\2\u00b0\u00b1\7R\2\2\u00b1\u00b2\7q\2\2\u00b2\u00b3\7u\2\2\u00b3"+
		"\u00b4\7v\2\2\u00b4\u00b5\7c\2\2\u00b5\u00b6\7n\2\2\u00b6\u00b7\7E\2\2"+
		"\u00b7\u00b8\7q\2\2\u00b8\u00b9\7f\2\2\u00b9\u00ba\7g\2\2\u00ba\34\3\2"+
		"\2\2\u00bb\u00bc\7Q\2\2\u00bc\u00bd\7r\2\2\u00bd\u00be\7v\2\2\u00be\u00bf"+
		"\7k\2\2\u00bf\u00c0\7q\2\2\u00c0\u00c1\7p\2\2\u00c1\u00c2\7c\2\2\u00c2"+
		"\u00c3\7n\2\2\u00c3\u00c4\7R\2\2\u00c4\u00c5\7q\2\2\u00c5\u00c6\7u\2\2"+
		"\u00c6\u00c7\7v\2\2\u00c7\u00c8\7c\2\2\u00c8\u00c9\7n\2\2\u00c9\u00ca"+
		"\7E\2\2\u00ca\u00cb\7q\2\2\u00cb\u00cc\7f\2\2\u00cc\u00cd\7g\2\2\u00cd"+
		"\36\3\2\2\2\u00ce\u00cf\7P\2\2\u00cf\u00d0\7c\2\2\u00d0\u00d1\7o\2\2\u00d1"+
		"\u00d2\7g\2\2\u00d2 \3\2\2\2\u00d3\u00d4\7Q\2\2\u00d4\u00d5\7r\2\2\u00d5"+
		"\u00d6\7v\2\2\u00d6\u00d7\7k\2\2\u00d7\u00d8\7q\2\2\u00d8\u00d9\7p\2\2"+
		"\u00d9\u00da\7c\2\2\u00da\u00db\7n\2\2\u00db\u00dc\7P\2\2\u00dc\u00dd"+
		"\7c\2\2\u00dd\u00de\7o\2\2\u00de\u00df\7g\2\2\u00df\"\3\2\2\2\u00e0\u00e1"+
		"\7C\2\2\u00e1\u00e2\7f\2\2\u00e2\u00e3\7f\2\2\u00e3\u00e4\7t\2\2\u00e4"+
		"\u00e5\7g\2\2\u00e5\u00e6\7u\2\2\u00e6\u00e7\7u\2\2\u00e7$\3\2\2\2\u00e8"+
		"\u00e9\7Q\2\2\u00e9\u00ea\7r\2\2\u00ea\u00eb\7v\2\2\u00eb\u00ec\7k\2\2"+
		"\u00ec\u00ed\7q\2\2\u00ed\u00ee\7p\2\2\u00ee\u00ef\7c\2\2\u00ef\u00f0"+
		"\7n\2\2\u00f0\u00f1\7C\2\2\u00f1\u00f2\7f\2\2\u00f2\u00f3\7f\2\2\u00f3"+
		"\u00f4\7t\2\2\u00f4\u00f5\7g\2\2\u00f5\u00f6\7u\2\2\u00f6\u00f7\7u\2\2"+
		"\u00f7&\3\2\2\2\u00f8\u00f9\7v\2\2\u00f9\u00fa\7t\2\2\u00fa\u00fb\7w\2"+
		"\2\u00fb\u0101\7g\2\2\u00fc\u00fd\7V\2\2\u00fd\u00fe\7T\2\2\u00fe\u00ff"+
		"\7W\2\2\u00ff\u0101\7G\2\2\u0100\u00f8\3\2\2\2\u0100\u00fc\3\2\2\2\u0101"+
		"(\3\2\2\2\u0102\u0103\7h\2\2\u0103\u0104\7c\2\2\u0104\u0105\7n\2\2\u0105"+
		"\u0106\7u\2\2\u0106\u010d\7g\2\2\u0107\u0108\7H\2\2\u0108\u0109\7C\2\2"+
		"\u0109\u010a\7N\2\2\u010a\u010b\7U\2\2\u010b\u010d\7G\2\2\u010c\u0102"+
		"\3\2\2\2\u010c\u0107\3\2\2\2\u010d*\3\2\2\2\u010e\u0110\t\2\2\2\u010f"+
		"\u0111\t\3\2\2\u0110\u010f\3\2\2\2\u0111\u0112\3\2\2\2\u0112\u0110\3\2"+
		"\2\2\u0112\u0113\3\2\2\2\u0113,\3\2\2\2\u0114\u0115\t\4\2\2\u0115\u0116"+
		"\t\5\2\2\u0116\u0117\t\5\2\2\u0117\u0118\t\5\2\2\u0118\u0119\t\5\2\2\u0119"+
		"\u011a\t\5\2\2\u011a\u011b\t\5\2\2\u011b\u011c\t\5\2\2\u011c\u011d\t\5"+
		"\2\2\u011d.\3\2\2\2\u011e\u0120\t\5\2\2\u011f\u011e\3\2\2\2\u0120\u0121"+
		"\3\2\2\2\u0121\u011f\3\2\2\2\u0121\u0122\3\2\2\2\u0122\60\3\2\2\2\u0123"+
		"\u0125\t\6\2\2\u0124\u0123\3\2\2\2\u0125\u0126\3\2\2\2\u0126\u0124\3\2"+
		"\2\2\u0126\u0127\3\2\2\2\u0127\62\3\2\2\2\u0128\u012a\7\62\2\2\u0129\u0128"+
		"\3\2\2\2\u0129\u012a\3\2\2\2\u012a\u012b\3\2\2\2\u012b\u0133\t\7\2\2\u012c"+
		"\u012d\7\63\2\2\u012d\u0133\t\5\2\2\u012e\u012f\7\64\2\2\u012f\u0133\t"+
		"\5\2\2\u0130\u0131\7\65\2\2\u0131\u0133\t\b\2\2\u0132\u0129\3\2\2\2\u0132"+
		"\u012c\3\2\2\2\u0132\u012e\3\2\2\2\u0132\u0130\3\2\2\2\u0133\u0134\3\2"+
		"\2\2\u0134\u013b\7\61\2\2\u0135\u0137\7\62\2\2\u0136\u0135\3\2\2\2\u0136"+
		"\u0137\3\2\2\2\u0137\u0138\3\2\2\2\u0138\u013c\t\7\2\2\u0139\u013a\7\63"+
		"\2\2\u013a\u013c\t\t\2\2\u013b\u0136\3\2\2\2\u013b\u0139\3\2\2\2\u013c"+
		"\u013d\3\2\2\2\u013d\u013e\7\61\2\2\u013e\u013f\t\n\2\2\u013f\u0140\t"+
		"\5\2\2\u0140\u0141\t\5\2\2\u0141\u0142\t\5\2\2\u0142\64\3\2\2\2\u0143"+
		"\u0144\t\5\2\2\u0144\u0145\t\5\2\2\u0145\u0146\t\5\2\2\u0146\u0147\t\5"+
		"\2\2\u0147\u0148\7/\2\2\u0148\u0149\t\5\2\2\u0149\u014a\t\5\2\2\u014a"+
		"\u014b\t\5\2\2\u014b\66\3\2\2\2\u014c\u014e\7\17\2\2\u014d\u014c\3\2\2"+
		"\2\u014d\u014e\3\2\2\2\u014e\u014f\3\2\2\2\u014f\u0152\7\f\2\2\u0150\u0152"+
		"\7\17\2\2\u0151\u014d\3\2\2\2\u0151\u0150\3\2\2\2\u0152\u0153\3\2\2\2"+
		"\u0153\u0151\3\2\2\2\u0153\u0154\3\2\2\2\u0154\u0157\3\2\2\2\u0155\u0157"+
		"\7\2\2\3\u0156\u0151\3\2\2\2\u0156\u0155\3\2\2\2\u01578\3\2\2\2\20\2\u0100"+
		"\u010c\u0112\u0121\u0126\u0129\u0132\u0136\u013b\u014d\u0151\u0153\u0156"+
		"\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}