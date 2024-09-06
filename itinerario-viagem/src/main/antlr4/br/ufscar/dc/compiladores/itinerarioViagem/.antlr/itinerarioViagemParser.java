// Generated from /home/caio/Faculdade/Compiladores/t6/itinerario-viagem/src/main/antlr4/br/ufscar/dc/compiladores/itinerarioViagem/itinerarioViagem.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class itinerarioViagemParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, VIAGEM=2, HOSPEDAGEM=3, TRANSPORTE=4, ATIVIDADES=5, TIPO=6, NOME=7, 
		CHECK_IN=8, CHECK_OUT=9, DATA_INICIO=10, DATA_FIM=11, DESTINO=12, COMPANHIA=13, 
		DIA=14, ATIVIDADE=15, LOCAL=16, HORARIO=17, STRING=18, DIA_MES=19, ANO=20, 
		TEMPO=21, DELIM=22, TRACO=23, ABRECHAVE=24, FECHACHAVE=25, COMMA=26, WS=27, 
		COMMENT=28, STRING_NAO_FECHADA=29, SIMBOLO_NAO_ENCONTRADO=30;
	public static final int
		RULE_itinerario = 0, RULE_data = 1, RULE_viagem_info = 2, RULE_hospedagem_info = 3, 
		RULE_transporte_info = 4, RULE_atividades_info = 5, RULE_atividade_list = 6, 
		RULE_atividade_item = 7;
	private static String[] makeRuleNames() {
		return new String[] {
			"itinerario", "data", "viagem_info", "hospedagem_info", "transporte_info", 
			"atividades_info", "atividade_list", "atividade_item"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'/'", "'viagem'", "'hospedagem'", "'transporte'", "'atividades'", 
			"'tipo'", "'nome'", "'check_in'", "'check_out'", "'data_inicio'", "'data_fim'", 
			"'destino'", "'companhia'", "'dia'", "'atividade'", "'local'", "'horario'", 
			null, null, null, null, "':'", "'-'", "'{'", "'}'", "','"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, "VIAGEM", "HOSPEDAGEM", "TRANSPORTE", "ATIVIDADES", "TIPO", 
			"NOME", "CHECK_IN", "CHECK_OUT", "DATA_INICIO", "DATA_FIM", "DESTINO", 
			"COMPANHIA", "DIA", "ATIVIDADE", "LOCAL", "HORARIO", "STRING", "DIA_MES", 
			"ANO", "TEMPO", "DELIM", "TRACO", "ABRECHAVE", "FECHACHAVE", "COMMA", 
			"WS", "COMMENT", "STRING_NAO_FECHADA", "SIMBOLO_NAO_ENCONTRADO"
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
	public String getGrammarFileName() { return "itinerarioViagem.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public itinerarioViagemParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ItinerarioContext extends ParserRuleContext {
		public TerminalNode VIAGEM() { return getToken(itinerarioViagemParser.VIAGEM, 0); }
		public TerminalNode STRING() { return getToken(itinerarioViagemParser.STRING, 0); }
		public TerminalNode ABRECHAVE() { return getToken(itinerarioViagemParser.ABRECHAVE, 0); }
		public Viagem_infoContext viagem_info() {
			return getRuleContext(Viagem_infoContext.class,0);
		}
		public Hospedagem_infoContext hospedagem_info() {
			return getRuleContext(Hospedagem_infoContext.class,0);
		}
		public Transporte_infoContext transporte_info() {
			return getRuleContext(Transporte_infoContext.class,0);
		}
		public Atividades_infoContext atividades_info() {
			return getRuleContext(Atividades_infoContext.class,0);
		}
		public TerminalNode FECHACHAVE() { return getToken(itinerarioViagemParser.FECHACHAVE, 0); }
		public ItinerarioContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_itinerario; }
	}

	public final ItinerarioContext itinerario() throws RecognitionException {
		ItinerarioContext _localctx = new ItinerarioContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_itinerario);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(16);
			match(VIAGEM);
			setState(17);
			match(STRING);
			setState(18);
			match(ABRECHAVE);
			setState(19);
			viagem_info();
			setState(20);
			hospedagem_info();
			setState(21);
			transporte_info();
			setState(22);
			atividades_info();
			setState(23);
			match(FECHACHAVE);
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
	public static class DataContext extends ParserRuleContext {
		public List<TerminalNode> DIA_MES() { return getTokens(itinerarioViagemParser.DIA_MES); }
		public TerminalNode DIA_MES(int i) {
			return getToken(itinerarioViagemParser.DIA_MES, i);
		}
		public TerminalNode ANO() { return getToken(itinerarioViagemParser.ANO, 0); }
		public DataContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_data; }
	}

	public final DataContext data() throws RecognitionException {
		DataContext _localctx = new DataContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_data);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(25);
			match(DIA_MES);
			setState(26);
			match(T__0);
			setState(27);
			match(DIA_MES);
			setState(28);
			match(T__0);
			setState(29);
			match(ANO);
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
	public static class Viagem_infoContext extends ParserRuleContext {
		public TerminalNode DATA_INICIO() { return getToken(itinerarioViagemParser.DATA_INICIO, 0); }
		public List<TerminalNode> DELIM() { return getTokens(itinerarioViagemParser.DELIM); }
		public TerminalNode DELIM(int i) {
			return getToken(itinerarioViagemParser.DELIM, i);
		}
		public List<DataContext> data() {
			return getRuleContexts(DataContext.class);
		}
		public DataContext data(int i) {
			return getRuleContext(DataContext.class,i);
		}
		public TerminalNode DATA_FIM() { return getToken(itinerarioViagemParser.DATA_FIM, 0); }
		public TerminalNode DESTINO() { return getToken(itinerarioViagemParser.DESTINO, 0); }
		public TerminalNode STRING() { return getToken(itinerarioViagemParser.STRING, 0); }
		public Viagem_infoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_viagem_info; }
	}

	public final Viagem_infoContext viagem_info() throws RecognitionException {
		Viagem_infoContext _localctx = new Viagem_infoContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_viagem_info);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(31);
			match(DATA_INICIO);
			setState(32);
			match(DELIM);
			setState(33);
			data();
			setState(34);
			match(DATA_FIM);
			setState(35);
			match(DELIM);
			setState(36);
			data();
			setState(37);
			match(DESTINO);
			setState(38);
			match(DELIM);
			setState(39);
			match(STRING);
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
	public static class Hospedagem_infoContext extends ParserRuleContext {
		public TerminalNode HOSPEDAGEM() { return getToken(itinerarioViagemParser.HOSPEDAGEM, 0); }
		public TerminalNode ABRECHAVE() { return getToken(itinerarioViagemParser.ABRECHAVE, 0); }
		public TerminalNode TIPO() { return getToken(itinerarioViagemParser.TIPO, 0); }
		public List<TerminalNode> DELIM() { return getTokens(itinerarioViagemParser.DELIM); }
		public TerminalNode DELIM(int i) {
			return getToken(itinerarioViagemParser.DELIM, i);
		}
		public List<TerminalNode> STRING() { return getTokens(itinerarioViagemParser.STRING); }
		public TerminalNode STRING(int i) {
			return getToken(itinerarioViagemParser.STRING, i);
		}
		public TerminalNode NOME() { return getToken(itinerarioViagemParser.NOME, 0); }
		public TerminalNode CHECK_IN() { return getToken(itinerarioViagemParser.CHECK_IN, 0); }
		public List<DataContext> data() {
			return getRuleContexts(DataContext.class);
		}
		public DataContext data(int i) {
			return getRuleContext(DataContext.class,i);
		}
		public TerminalNode CHECK_OUT() { return getToken(itinerarioViagemParser.CHECK_OUT, 0); }
		public TerminalNode FECHACHAVE() { return getToken(itinerarioViagemParser.FECHACHAVE, 0); }
		public Hospedagem_infoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_hospedagem_info; }
	}

	public final Hospedagem_infoContext hospedagem_info() throws RecognitionException {
		Hospedagem_infoContext _localctx = new Hospedagem_infoContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_hospedagem_info);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(41);
			match(HOSPEDAGEM);
			setState(42);
			match(ABRECHAVE);
			setState(43);
			match(TIPO);
			setState(44);
			match(DELIM);
			setState(45);
			match(STRING);
			setState(46);
			match(NOME);
			setState(47);
			match(DELIM);
			setState(48);
			match(STRING);
			setState(49);
			match(CHECK_IN);
			setState(50);
			match(DELIM);
			setState(51);
			data();
			setState(52);
			match(CHECK_OUT);
			setState(53);
			match(DELIM);
			setState(54);
			data();
			setState(55);
			match(FECHACHAVE);
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
	public static class Transporte_infoContext extends ParserRuleContext {
		public TerminalNode TRANSPORTE() { return getToken(itinerarioViagemParser.TRANSPORTE, 0); }
		public TerminalNode ABRECHAVE() { return getToken(itinerarioViagemParser.ABRECHAVE, 0); }
		public TerminalNode TIPO() { return getToken(itinerarioViagemParser.TIPO, 0); }
		public List<TerminalNode> DELIM() { return getTokens(itinerarioViagemParser.DELIM); }
		public TerminalNode DELIM(int i) {
			return getToken(itinerarioViagemParser.DELIM, i);
		}
		public List<TerminalNode> STRING() { return getTokens(itinerarioViagemParser.STRING); }
		public TerminalNode STRING(int i) {
			return getToken(itinerarioViagemParser.STRING, i);
		}
		public TerminalNode COMPANHIA() { return getToken(itinerarioViagemParser.COMPANHIA, 0); }
		public TerminalNode FECHACHAVE() { return getToken(itinerarioViagemParser.FECHACHAVE, 0); }
		public Transporte_infoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_transporte_info; }
	}

	public final Transporte_infoContext transporte_info() throws RecognitionException {
		Transporte_infoContext _localctx = new Transporte_infoContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_transporte_info);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(57);
			match(TRANSPORTE);
			setState(58);
			match(ABRECHAVE);
			setState(59);
			match(TIPO);
			setState(60);
			match(DELIM);
			setState(61);
			match(STRING);
			setState(62);
			match(COMPANHIA);
			setState(63);
			match(DELIM);
			setState(64);
			match(STRING);
			setState(65);
			match(FECHACHAVE);
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
	public static class Atividades_infoContext extends ParserRuleContext {
		public TerminalNode ATIVIDADES() { return getToken(itinerarioViagemParser.ATIVIDADES, 0); }
		public TerminalNode ABRECHAVE() { return getToken(itinerarioViagemParser.ABRECHAVE, 0); }
		public Atividade_listContext atividade_list() {
			return getRuleContext(Atividade_listContext.class,0);
		}
		public TerminalNode FECHACHAVE() { return getToken(itinerarioViagemParser.FECHACHAVE, 0); }
		public Atividades_infoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atividades_info; }
	}

	public final Atividades_infoContext atividades_info() throws RecognitionException {
		Atividades_infoContext _localctx = new Atividades_infoContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_atividades_info);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(67);
			match(ATIVIDADES);
			setState(68);
			match(ABRECHAVE);
			setState(69);
			atividade_list();
			setState(70);
			match(FECHACHAVE);
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
	public static class Atividade_listContext extends ParserRuleContext {
		public List<Atividade_itemContext> atividade_item() {
			return getRuleContexts(Atividade_itemContext.class);
		}
		public Atividade_itemContext atividade_item(int i) {
			return getRuleContext(Atividade_itemContext.class,i);
		}
		public Atividade_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atividade_list; }
	}

	public final Atividade_listContext atividade_list() throws RecognitionException {
		Atividade_listContext _localctx = new Atividade_listContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_atividade_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(73); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(72);
				atividade_item();
				}
				}
				setState(75); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==ABRECHAVE );
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
	public static class Atividade_itemContext extends ParserRuleContext {
		public TerminalNode ABRECHAVE() { return getToken(itinerarioViagemParser.ABRECHAVE, 0); }
		public TerminalNode DIA() { return getToken(itinerarioViagemParser.DIA, 0); }
		public List<TerminalNode> DELIM() { return getTokens(itinerarioViagemParser.DELIM); }
		public TerminalNode DELIM(int i) {
			return getToken(itinerarioViagemParser.DELIM, i);
		}
		public DataContext data() {
			return getRuleContext(DataContext.class,0);
		}
		public TerminalNode ATIVIDADE() { return getToken(itinerarioViagemParser.ATIVIDADE, 0); }
		public List<TerminalNode> STRING() { return getTokens(itinerarioViagemParser.STRING); }
		public TerminalNode STRING(int i) {
			return getToken(itinerarioViagemParser.STRING, i);
		}
		public TerminalNode LOCAL() { return getToken(itinerarioViagemParser.LOCAL, 0); }
		public TerminalNode HORARIO() { return getToken(itinerarioViagemParser.HORARIO, 0); }
		public TerminalNode TEMPO() { return getToken(itinerarioViagemParser.TEMPO, 0); }
		public TerminalNode FECHACHAVE() { return getToken(itinerarioViagemParser.FECHACHAVE, 0); }
		public Atividade_itemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atividade_item; }
	}

	public final Atividade_itemContext atividade_item() throws RecognitionException {
		Atividade_itemContext _localctx = new Atividade_itemContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_atividade_item);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(77);
			match(ABRECHAVE);
			setState(78);
			match(DIA);
			setState(79);
			match(DELIM);
			setState(80);
			data();
			setState(81);
			match(ATIVIDADE);
			setState(82);
			match(DELIM);
			setState(83);
			match(STRING);
			setState(84);
			match(LOCAL);
			setState(85);
			match(DELIM);
			setState(86);
			match(STRING);
			setState(87);
			match(HORARIO);
			setState(88);
			match(DELIM);
			setState(89);
			match(TEMPO);
			setState(90);
			match(FECHACHAVE);
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
		"\u0004\u0001\u001e]\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0006\u0004\u0006J\b\u0006\u000b\u0006\f\u0006"+
		"K\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0000\u0000\b\u0000\u0002"+
		"\u0004\u0006\b\n\f\u000e\u0000\u0000U\u0000\u0010\u0001\u0000\u0000\u0000"+
		"\u0002\u0019\u0001\u0000\u0000\u0000\u0004\u001f\u0001\u0000\u0000\u0000"+
		"\u0006)\u0001\u0000\u0000\u0000\b9\u0001\u0000\u0000\u0000\nC\u0001\u0000"+
		"\u0000\u0000\fI\u0001\u0000\u0000\u0000\u000eM\u0001\u0000\u0000\u0000"+
		"\u0010\u0011\u0005\u0002\u0000\u0000\u0011\u0012\u0005\u0012\u0000\u0000"+
		"\u0012\u0013\u0005\u0018\u0000\u0000\u0013\u0014\u0003\u0004\u0002\u0000"+
		"\u0014\u0015\u0003\u0006\u0003\u0000\u0015\u0016\u0003\b\u0004\u0000\u0016"+
		"\u0017\u0003\n\u0005\u0000\u0017\u0018\u0005\u0019\u0000\u0000\u0018\u0001"+
		"\u0001\u0000\u0000\u0000\u0019\u001a\u0005\u0013\u0000\u0000\u001a\u001b"+
		"\u0005\u0001\u0000\u0000\u001b\u001c\u0005\u0013\u0000\u0000\u001c\u001d"+
		"\u0005\u0001\u0000\u0000\u001d\u001e\u0005\u0014\u0000\u0000\u001e\u0003"+
		"\u0001\u0000\u0000\u0000\u001f \u0005\n\u0000\u0000 !\u0005\u0016\u0000"+
		"\u0000!\"\u0003\u0002\u0001\u0000\"#\u0005\u000b\u0000\u0000#$\u0005\u0016"+
		"\u0000\u0000$%\u0003\u0002\u0001\u0000%&\u0005\f\u0000\u0000&\'\u0005"+
		"\u0016\u0000\u0000\'(\u0005\u0012\u0000\u0000(\u0005\u0001\u0000\u0000"+
		"\u0000)*\u0005\u0003\u0000\u0000*+\u0005\u0018\u0000\u0000+,\u0005\u0006"+
		"\u0000\u0000,-\u0005\u0016\u0000\u0000-.\u0005\u0012\u0000\u0000./\u0005"+
		"\u0007\u0000\u0000/0\u0005\u0016\u0000\u000001\u0005\u0012\u0000\u0000"+
		"12\u0005\b\u0000\u000023\u0005\u0016\u0000\u000034\u0003\u0002\u0001\u0000"+
		"45\u0005\t\u0000\u000056\u0005\u0016\u0000\u000067\u0003\u0002\u0001\u0000"+
		"78\u0005\u0019\u0000\u00008\u0007\u0001\u0000\u0000\u00009:\u0005\u0004"+
		"\u0000\u0000:;\u0005\u0018\u0000\u0000;<\u0005\u0006\u0000\u0000<=\u0005"+
		"\u0016\u0000\u0000=>\u0005\u0012\u0000\u0000>?\u0005\r\u0000\u0000?@\u0005"+
		"\u0016\u0000\u0000@A\u0005\u0012\u0000\u0000AB\u0005\u0019\u0000\u0000"+
		"B\t\u0001\u0000\u0000\u0000CD\u0005\u0005\u0000\u0000DE\u0005\u0018\u0000"+
		"\u0000EF\u0003\f\u0006\u0000FG\u0005\u0019\u0000\u0000G\u000b\u0001\u0000"+
		"\u0000\u0000HJ\u0003\u000e\u0007\u0000IH\u0001\u0000\u0000\u0000JK\u0001"+
		"\u0000\u0000\u0000KI\u0001\u0000\u0000\u0000KL\u0001\u0000\u0000\u0000"+
		"L\r\u0001\u0000\u0000\u0000MN\u0005\u0018\u0000\u0000NO\u0005\u000e\u0000"+
		"\u0000OP\u0005\u0016\u0000\u0000PQ\u0003\u0002\u0001\u0000QR\u0005\u000f"+
		"\u0000\u0000RS\u0005\u0016\u0000\u0000ST\u0005\u0012\u0000\u0000TU\u0005"+
		"\u0010\u0000\u0000UV\u0005\u0016\u0000\u0000VW\u0005\u0012\u0000\u0000"+
		"WX\u0005\u0011\u0000\u0000XY\u0005\u0016\u0000\u0000YZ\u0005\u0015\u0000"+
		"\u0000Z[\u0005\u0019\u0000\u0000[\u000f\u0001\u0000\u0000\u0000\u0001"+
		"K";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}