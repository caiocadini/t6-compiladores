// Generated from java-escape by ANTLR 4.11.1
package br.ufscar.dc.compiladores.itinerarioViagem;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link itinerarioViagemParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface itinerarioViagemVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link itinerarioViagemParser#itinerario}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitItinerario(itinerarioViagemParser.ItinerarioContext ctx);
	/**
	 * Visit a parse tree produced by {@link itinerarioViagemParser#data}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitData(itinerarioViagemParser.DataContext ctx);
	/**
	 * Visit a parse tree produced by {@link itinerarioViagemParser#viagem_info}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitViagem_info(itinerarioViagemParser.Viagem_infoContext ctx);
	/**
	 * Visit a parse tree produced by {@link itinerarioViagemParser#hospedagem_info}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHospedagem_info(itinerarioViagemParser.Hospedagem_infoContext ctx);
	/**
	 * Visit a parse tree produced by {@link itinerarioViagemParser#transporte_info}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTransporte_info(itinerarioViagemParser.Transporte_infoContext ctx);
	/**
	 * Visit a parse tree produced by {@link itinerarioViagemParser#atividades_info}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtividades_info(itinerarioViagemParser.Atividades_infoContext ctx);
	/**
	 * Visit a parse tree produced by {@link itinerarioViagemParser#atividade_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtividade_list(itinerarioViagemParser.Atividade_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link itinerarioViagemParser#atividade_item}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtividade_item(itinerarioViagemParser.Atividade_itemContext ctx);
}