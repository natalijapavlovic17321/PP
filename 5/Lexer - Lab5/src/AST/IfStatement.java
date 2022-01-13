package AST;

import java.io.*;


public class IfStatement extends Statement{
	private Block thenStatement;
	private Statement elseStatement;
	private RealExpression condition;
	
	public IfStatement(RealExpression e, Block thenS, 
			Statement elseS )
	{
		condition = e;
		thenStatement = thenS;
		if(elseS!=null)
		   elseStatement = elseS;
	}
	
	public void translate( BufferedWriter out )
	throws IOException
	{
		condition.translate( out );
		condition.genLoad( "R1", out );
		String elseLabel = ASTNode.genLab();
		String endLabel = ASTNode.genLab();
		out.write( "\tJumpIfZero\tR1, " + elseLabel );
		out.newLine();
		thenStatement.translate( out );
		out.write( "\tJump\t" + endLabel );
		out.newLine();
		out.write( elseLabel + ":" );
		if(elseStatement!=null) {
		out.newLine();
		elseStatement.translate( out );
		out.write( endLabel + ":" );
		out.newLine();
		}
	}
}


