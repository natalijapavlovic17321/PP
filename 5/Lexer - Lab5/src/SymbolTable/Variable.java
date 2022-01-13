package SymbolTable;

public class Variable extends SymbolNode {
	
	public int last_def;
	public int last_use;
	public boolean field;
	
	public Variable( String name, 
			Type type,
			SymbolNode next )
	{
		super( name, SymbolNode.VARIABLE, type, next );
		last_def = -1;
		last_use = -1;
		field = false;
	}
	
	public Variable( String name,
			Type type,
			boolean field,
			SymbolNode next )
	{
		super( name, SymbolNode.VARIABLE, type, next );
		last_def = -1;
		last_use = -1;
		this.field = field;
	}
	
}
