// Generated from /Users/tobyclemson/Code/twerp/src/main/antlr/Twerp.g4 by ANTLR 4.2.2
package twerp.lang.grammar;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class TwerpLexer extends Lexer {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		DIGIT=1, BINARYOP=2;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"DIGIT", "'+'"
	};
	public static final String[] ruleNames = {
		"DIGIT", "BINARYOP"
	};


	public TwerpLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Twerp.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\4\16\b\1\4\2\t\2"+
		"\4\3\t\3\3\2\6\2\t\n\2\r\2\16\2\n\3\3\3\3\2\2\4\3\3\5\4\3\2\3\3\2\62;"+
		"\16\2\3\3\2\2\2\2\5\3\2\2\2\3\b\3\2\2\2\5\f\3\2\2\2\7\t\t\2\2\2\b\7\3"+
		"\2\2\2\t\n\3\2\2\2\n\b\3\2\2\2\n\13\3\2\2\2\13\4\3\2\2\2\f\r\7-\2\2\r"+
		"\6\3\2\2\2\4\2\n\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}