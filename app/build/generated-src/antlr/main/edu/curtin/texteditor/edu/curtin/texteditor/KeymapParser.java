// Generated from edu/curtin/texteditor/Keymap.g4 by ANTLR 4.13.2
package edu.curtin.texteditor;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class KeymapParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		ALT=1, CTRL=2, SHIFT=3, INSERT=4, DELETE=5, AT=6, START=7, OF=8, LINE=9, 
		CARET=10, PLUS=11, EQUALS=12, LETTER=13, STRING=14, NUMBER=15, UNIT=16, 
		WHITESPACE=17, COMMENT=18;
	public static final int
		RULE_keymap = 0, RULE_shortcut = 1, RULE_modifier = 2, RULE_action = 3, 
		RULE_caretPosition = 4;
	private static String[] makeRuleNames() {
		return new String[] {
			"keymap", "shortcut", "modifier", "action", "caretPosition"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'alt'", "'ctrl'", "'shift'", "'insert'", "'delete'", "'at'", "'start'", 
			"'of'", "'line'", "'caret'", "'+'", "'='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "ALT", "CTRL", "SHIFT", "INSERT", "DELETE", "AT", "START", "OF", 
			"LINE", "CARET", "PLUS", "EQUALS", "LETTER", "STRING", "NUMBER", "UNIT", 
			"WHITESPACE", "COMMENT"
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
	public String getGrammarFileName() { return "Keymap.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public KeymapParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class KeymapContext extends ParserRuleContext {
		public List<ShortcutContext> shortcut() {
			return getRuleContexts(ShortcutContext.class);
		}
		public ShortcutContext shortcut(int i) {
			return getRuleContext(ShortcutContext.class,i);
		}
		public KeymapContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keymap; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KeymapListener ) ((KeymapListener)listener).enterKeymap(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KeymapListener ) ((KeymapListener)listener).exitKeymap(this);
		}
	}

	public final KeymapContext keymap() throws RecognitionException {
		KeymapContext _localctx = new KeymapContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_keymap);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(13);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 14L) != 0)) {
				{
				{
				setState(10);
				shortcut();
				}
				}
				setState(15);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ShortcutContext extends ParserRuleContext {
		public List<ModifierContext> modifier() {
			return getRuleContexts(ModifierContext.class);
		}
		public ModifierContext modifier(int i) {
			return getRuleContext(ModifierContext.class,i);
		}
		public List<TerminalNode> PLUS() { return getTokens(KeymapParser.PLUS); }
		public TerminalNode PLUS(int i) {
			return getToken(KeymapParser.PLUS, i);
		}
		public TerminalNode LETTER() { return getToken(KeymapParser.LETTER, 0); }
		public TerminalNode EQUALS() { return getToken(KeymapParser.EQUALS, 0); }
		public ActionContext action() {
			return getRuleContext(ActionContext.class,0);
		}
		public TerminalNode STRING() { return getToken(KeymapParser.STRING, 0); }
		public CaretPositionContext caretPosition() {
			return getRuleContext(CaretPositionContext.class,0);
		}
		public ShortcutContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_shortcut; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KeymapListener ) ((KeymapListener)listener).enterShortcut(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KeymapListener ) ((KeymapListener)listener).exitShortcut(this);
		}
	}

	public final ShortcutContext shortcut() throws RecognitionException {
		ShortcutContext _localctx = new ShortcutContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_shortcut);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(16);
			modifier();
			setState(21);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(17);
					match(PLUS);
					setState(18);
					modifier();
					}
					} 
				}
				setState(23);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			}
			setState(24);
			match(PLUS);
			setState(25);
			match(LETTER);
			setState(26);
			match(EQUALS);
			setState(27);
			action();
			setState(28);
			match(STRING);
			setState(29);
			caretPosition();
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

	@SuppressWarnings("CheckReturnValue")
	public static class ModifierContext extends ParserRuleContext {
		public TerminalNode ALT() { return getToken(KeymapParser.ALT, 0); }
		public TerminalNode CTRL() { return getToken(KeymapParser.CTRL, 0); }
		public TerminalNode SHIFT() { return getToken(KeymapParser.SHIFT, 0); }
		public ModifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_modifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KeymapListener ) ((KeymapListener)listener).enterModifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KeymapListener ) ((KeymapListener)listener).exitModifier(this);
		}
	}

	public final ModifierContext modifier() throws RecognitionException {
		ModifierContext _localctx = new ModifierContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_modifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(31);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 14L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	@SuppressWarnings("CheckReturnValue")
	public static class ActionContext extends ParserRuleContext {
		public TerminalNode INSERT() { return getToken(KeymapParser.INSERT, 0); }
		public TerminalNode DELETE() { return getToken(KeymapParser.DELETE, 0); }
		public ActionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_action; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KeymapListener ) ((KeymapListener)listener).enterAction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KeymapListener ) ((KeymapListener)listener).exitAction(this);
		}
	}

	public final ActionContext action() throws RecognitionException {
		ActionContext _localctx = new ActionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_action);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(33);
			_la = _input.LA(1);
			if ( !(_la==INSERT || _la==DELETE) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	@SuppressWarnings("CheckReturnValue")
	public static class CaretPositionContext extends ParserRuleContext {
		public TerminalNode AT() { return getToken(KeymapParser.AT, 0); }
		public TerminalNode START() { return getToken(KeymapParser.START, 0); }
		public TerminalNode OF() { return getToken(KeymapParser.OF, 0); }
		public TerminalNode LINE() { return getToken(KeymapParser.LINE, 0); }
		public TerminalNode CARET() { return getToken(KeymapParser.CARET, 0); }
		public CaretPositionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_caretPosition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KeymapListener ) ((KeymapListener)listener).enterCaretPosition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KeymapListener ) ((KeymapListener)listener).exitCaretPosition(this);
		}
	}

	public final CaretPositionContext caretPosition() throws RecognitionException {
		CaretPositionContext _localctx = new CaretPositionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_caretPosition);
		try {
			setState(41);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(35);
				match(AT);
				setState(36);
				match(START);
				setState(37);
				match(OF);
				setState(38);
				match(LINE);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(39);
				match(AT);
				setState(40);
				match(CARET);
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

	public static final String _serializedATN =
		"\u0004\u0001\u0012,\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0001"+
		"\u0000\u0005\u0000\f\b\u0000\n\u0000\f\u0000\u000f\t\u0000\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0005\u0001\u0014\b\u0001\n\u0001\f\u0001\u0017"+
		"\t\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003"+
		"\u0004*\b\u0004\u0001\u0004\u0000\u0000\u0005\u0000\u0002\u0004\u0006"+
		"\b\u0000\u0002\u0001\u0000\u0001\u0003\u0001\u0000\u0004\u0005)\u0000"+
		"\r\u0001\u0000\u0000\u0000\u0002\u0010\u0001\u0000\u0000\u0000\u0004\u001f"+
		"\u0001\u0000\u0000\u0000\u0006!\u0001\u0000\u0000\u0000\b)\u0001\u0000"+
		"\u0000\u0000\n\f\u0003\u0002\u0001\u0000\u000b\n\u0001\u0000\u0000\u0000"+
		"\f\u000f\u0001\u0000\u0000\u0000\r\u000b\u0001\u0000\u0000\u0000\r\u000e"+
		"\u0001\u0000\u0000\u0000\u000e\u0001\u0001\u0000\u0000\u0000\u000f\r\u0001"+
		"\u0000\u0000\u0000\u0010\u0015\u0003\u0004\u0002\u0000\u0011\u0012\u0005"+
		"\u000b\u0000\u0000\u0012\u0014\u0003\u0004\u0002\u0000\u0013\u0011\u0001"+
		"\u0000\u0000\u0000\u0014\u0017\u0001\u0000\u0000\u0000\u0015\u0013\u0001"+
		"\u0000\u0000\u0000\u0015\u0016\u0001\u0000\u0000\u0000\u0016\u0018\u0001"+
		"\u0000\u0000\u0000\u0017\u0015\u0001\u0000\u0000\u0000\u0018\u0019\u0005"+
		"\u000b\u0000\u0000\u0019\u001a\u0005\r\u0000\u0000\u001a\u001b\u0005\f"+
		"\u0000\u0000\u001b\u001c\u0003\u0006\u0003\u0000\u001c\u001d\u0005\u000e"+
		"\u0000\u0000\u001d\u001e\u0003\b\u0004\u0000\u001e\u0003\u0001\u0000\u0000"+
		"\u0000\u001f \u0007\u0000\u0000\u0000 \u0005\u0001\u0000\u0000\u0000!"+
		"\"\u0007\u0001\u0000\u0000\"\u0007\u0001\u0000\u0000\u0000#$\u0005\u0006"+
		"\u0000\u0000$%\u0005\u0007\u0000\u0000%&\u0005\b\u0000\u0000&*\u0005\t"+
		"\u0000\u0000\'(\u0005\u0006\u0000\u0000(*\u0005\n\u0000\u0000)#\u0001"+
		"\u0000\u0000\u0000)\'\u0001\u0000\u0000\u0000*\t\u0001\u0000\u0000\u0000"+
		"\u0003\r\u0015)";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}