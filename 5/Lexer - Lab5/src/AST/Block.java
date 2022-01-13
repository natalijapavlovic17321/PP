package AST;


import java.io.*;
import java.util.ArrayList;

public class Block extends Statement {
	private ArrayList<Statement> statements;// = new ArrayList<Statement>();
	
	public Block() {
	}
    
	public Block(ArrayList<Statement> statements) {
    	this.statements = new ArrayList(statements);
    }
	public void addStatement( Statement newStatement )
	{
		statements.add( newStatement );
	}
	@Override
	public void translate( BufferedWriter out )
	throws IOException
	{
		/*for ( int i=0; i<statements.size(); i++ )
		{
			Statement current = (Statement) statements.get(i);
			current.translate( out );
		}*/
		statements.forEach(s->{
            try {
                s.translate(out);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
	}
}


