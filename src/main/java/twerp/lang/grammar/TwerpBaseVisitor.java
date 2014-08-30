// Generated from /Users/tobyclemson/Code/twerp/src/main/antlr/Twerp.g4 by ANTLR 4.2.2
package twerp.lang.grammar;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;

/**
 * This class provides an empty implementation of {@link TwerpVisitor},
 * which can be extended to create a visitor which only needs to handle a subset
 * of the available methods.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public class TwerpBaseVisitor<T> extends AbstractParseTreeVisitor<T> implements TwerpVisitor<T> {
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitExpression(@NotNull TwerpParser.ExpressionContext ctx) { return visitChildren(ctx); }
}