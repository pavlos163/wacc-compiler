package compiler.frontEnd.statements;

import compiler.CodePosition;
import compiler.backEnd.codeGeneration.AbstractSyntaxTreeVisitor;
import compiler.frontEnd.errorHandling.SemanticException;
import compiler.frontEnd.expressions.Expr;
import compiler.frontEnd.types.ArrType;
import compiler.frontEnd.types.PairType;

public class FreeStat extends Stat {

	private final Expr heapItem;

	public FreeStat(Expr heapItem, CodePosition codePos) {
		super(codePos);
		this.heapItem = heapItem;
		checkErrors(heapItem);
	}

	@Override
	public CodePosition getPosition() {
		return codePos;
	}

	private void checkErrors(Expr heapItem) {
		if (!(heapItem.getType().equals(new ArrType(null)) || heapItem.getType().equals(new PairType(null, null)))) {
			throw new SemanticException(
					"At: " + codePos.toString() + " item freed must be heap allocated, therefore it must be a"
							+ " pair or an array. Actual type: " + heapItem.getType());
		}
	}

	@Override
	public <T> T accept(AbstractSyntaxTreeVisitor<T> visitor) {
		return visitor.visit(this);
	}

	public Expr getItem() {
		return heapItem;
	}
}
