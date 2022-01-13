package AST;

public class NotEqualRelExp extends RealExpression {
	
    public NotEqualRelExp(Term left, Term right){
        super(right);
        this.right = right;
    }

	protected String relOp(){
        return "Compare_notEqual";
    }	
}