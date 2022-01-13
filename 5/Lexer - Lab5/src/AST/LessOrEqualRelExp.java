package AST;

public class LessOrEqualRelExp extends RealExpression {
	
    public LessOrEqualRelExp(Term left, Term right){
        super(right);
        this.right = right;
    }

	protected String relOp(){
        return "Compare_lessOrEqual";
    }	
}