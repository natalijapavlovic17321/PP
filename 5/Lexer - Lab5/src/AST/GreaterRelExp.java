package AST;
public class GreaterRelExp extends RealExpression {
	
    public GreaterRelExp(Term left, Term right){
        super(right);
        this.right = right;
    }

	protected String relOp(){
        return "Compare_greater";
    }	
}