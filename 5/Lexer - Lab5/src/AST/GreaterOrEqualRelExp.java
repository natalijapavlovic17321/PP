package AST;

public class GreaterOrEqualRelExp extends RealExpression {
	
    public GreaterOrEqualRelExp(Term left, Term right){
        super(right);
        this.right = right;
    }

	protected String relOp(){
        return "Compare_greaterOrEqual";
    }	
}
