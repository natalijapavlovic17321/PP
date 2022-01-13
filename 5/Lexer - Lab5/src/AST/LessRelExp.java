package AST;

public class LessRelExp extends RealExpression {
	
    public LessRelExp(Term left, Term right){
        super(right);
        this.right = right;
    }

	protected String relOp(){
        return "Compare_less";
    }	
}