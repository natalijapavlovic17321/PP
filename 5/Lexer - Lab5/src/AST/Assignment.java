package AST;

import java.io.BufferedWriter;
import java.io.IOException;

import SymbolTable.Variable;

public class Assignment extends Statement {
	private Variable left;
	private Term right;
	
	public Assignment( Variable var, Term e )
	{
		left = var;
		right = e;
	}
	
	public void translate( BufferedWriter out )
	throws IOException 
	{
		right.translate( out );
		right.genLoad( "R1", out );
		out.write( "\tStore\t\tR1, " + left.name );
		out.newLine();
	}
}
