// Generated from edu/curtin/texteditor/Keymap.g4 by ANTLR 4.13.2
package edu.curtin.texteditor;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link KeymapParser}.
 */
public interface KeymapListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link KeymapParser#keymap}.
	 * @param ctx the parse tree
	 */
	void enterKeymap(KeymapParser.KeymapContext ctx);
	/**
	 * Exit a parse tree produced by {@link KeymapParser#keymap}.
	 * @param ctx the parse tree
	 */
	void exitKeymap(KeymapParser.KeymapContext ctx);
	/**
	 * Enter a parse tree produced by {@link KeymapParser#shortcut}.
	 * @param ctx the parse tree
	 */
	void enterShortcut(KeymapParser.ShortcutContext ctx);
	/**
	 * Exit a parse tree produced by {@link KeymapParser#shortcut}.
	 * @param ctx the parse tree
	 */
	void exitShortcut(KeymapParser.ShortcutContext ctx);
	/**
	 * Enter a parse tree produced by {@link KeymapParser#modifier}.
	 * @param ctx the parse tree
	 */
	void enterModifier(KeymapParser.ModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link KeymapParser#modifier}.
	 * @param ctx the parse tree
	 */
	void exitModifier(KeymapParser.ModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link KeymapParser#action}.
	 * @param ctx the parse tree
	 */
	void enterAction(KeymapParser.ActionContext ctx);
	/**
	 * Exit a parse tree produced by {@link KeymapParser#action}.
	 * @param ctx the parse tree
	 */
	void exitAction(KeymapParser.ActionContext ctx);
	/**
	 * Enter a parse tree produced by {@link KeymapParser#caretPosition}.
	 * @param ctx the parse tree
	 */
	void enterCaretPosition(KeymapParser.CaretPositionContext ctx);
	/**
	 * Exit a parse tree produced by {@link KeymapParser#caretPosition}.
	 * @param ctx the parse tree
	 */
	void exitCaretPosition(KeymapParser.CaretPositionContext ctx);
}