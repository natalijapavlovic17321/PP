package AST;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ElsePart extends Statement{
    private ArrayList<IfStatement> ifstatements= new ArrayList<IfStatement>();
	private Block block=new Block();
	public ElsePart() {
	}
    
	public ElsePart(ArrayList<IfStatement> statements, Block block) {
		if(statements!=null)
			this.ifstatements = new ArrayList(statements);
		if(block!=null)
			this.block=block;
    }
	public void addElseElif(ArrayList<IfStatement> statements, Block block)
	{
		this.ifstatements = new ArrayList(statements);
		this.block=block;
	}
	public void addElif(ArrayList<IfStatement> statements)
	{
		this.ifstatements = new ArrayList(statements);
	}
	public void addElse( Block block)
	{
		this.block=block;
	}
	
	
	public void translate( BufferedWriter out )
	throws IOException
	{
		if(ifstatements!= null)
		{
		for ( int i=0; i<ifstatements.size(); i++ )
		{
			Statement current = (Statement) ifstatements.get(i);
			current.translate( out );
		}
		}
	}
}
