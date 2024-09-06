// Generated from java-escape by ANTLR 4.11.1
package br.ufscar.dc.compiladores.itinerarioViagem;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link itinerarioViagemParser}.
 */
public interface itinerarioViagemListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link itinerarioViagemParser#itinerario}.
	 * @param ctx the parse tree
	 */
	void enterItinerario(itinerarioViagemParser.ItinerarioContext ctx);
	/**
	 * Exit a parse tree produced by {@link itinerarioViagemParser#itinerario}.
	 * @param ctx the parse tree
	 */
	void exitItinerario(itinerarioViagemParser.ItinerarioContext ctx);
	/**
	 * Enter a parse tree produced by {@link itinerarioViagemParser#data}.
	 * @param ctx the parse tree
	 */
	void enterData(itinerarioViagemParser.DataContext ctx);
	/**
	 * Exit a parse tree produced by {@link itinerarioViagemParser#data}.
	 * @param ctx the parse tree
	 */
	void exitData(itinerarioViagemParser.DataContext ctx);
	/**
	 * Enter a parse tree produced by {@link itinerarioViagemParser#viagem_info}.
	 * @param ctx the parse tree
	 */
	void enterViagem_info(itinerarioViagemParser.Viagem_infoContext ctx);
	/**
	 * Exit a parse tree produced by {@link itinerarioViagemParser#viagem_info}.
	 * @param ctx the parse tree
	 */
	void exitViagem_info(itinerarioViagemParser.Viagem_infoContext ctx);
	/**
	 * Enter a parse tree produced by {@link itinerarioViagemParser#hospedagem_info}.
	 * @param ctx the parse tree
	 */
	void enterHospedagem_info(itinerarioViagemParser.Hospedagem_infoContext ctx);
	/**
	 * Exit a parse tree produced by {@link itinerarioViagemParser#hospedagem_info}.
	 * @param ctx the parse tree
	 */
	void exitHospedagem_info(itinerarioViagemParser.Hospedagem_infoContext ctx);
	/**
	 * Enter a parse tree produced by {@link itinerarioViagemParser#transporte_info}.
	 * @param ctx the parse tree
	 */
	void enterTransporte_info(itinerarioViagemParser.Transporte_infoContext ctx);
	/**
	 * Exit a parse tree produced by {@link itinerarioViagemParser#transporte_info}.
	 * @param ctx the parse tree
	 */
	void exitTransporte_info(itinerarioViagemParser.Transporte_infoContext ctx);
	/**
	 * Enter a parse tree produced by {@link itinerarioViagemParser#atividades_info}.
	 * @param ctx the parse tree
	 */
	void enterAtividades_info(itinerarioViagemParser.Atividades_infoContext ctx);
	/**
	 * Exit a parse tree produced by {@link itinerarioViagemParser#atividades_info}.
	 * @param ctx the parse tree
	 */
	void exitAtividades_info(itinerarioViagemParser.Atividades_infoContext ctx);
	/**
	 * Enter a parse tree produced by {@link itinerarioViagemParser#atividade_list}.
	 * @param ctx the parse tree
	 */
	void enterAtividade_list(itinerarioViagemParser.Atividade_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link itinerarioViagemParser#atividade_list}.
	 * @param ctx the parse tree
	 */
	void exitAtividade_list(itinerarioViagemParser.Atividade_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link itinerarioViagemParser#atividade_item}.
	 * @param ctx the parse tree
	 */
	void enterAtividade_item(itinerarioViagemParser.Atividade_itemContext ctx);
	/**
	 * Exit a parse tree produced by {@link itinerarioViagemParser#atividade_item}.
	 * @param ctx the parse tree
	 */
	void exitAtividade_item(itinerarioViagemParser.Atividade_itemContext ctx);
}