package SymbolTable;

public class Variable extends SymbolNode {
	
	public int last_def;
	public int last_use;
	public int scope;
	public boolean field;
	
	public Variable( String name, 
			Type type,
			int scope,
			SymbolNode next )
	{
		super( name, SymbolNode.VARIABLE, type, next );
		last_def = -1;
		last_use = -1;
		this.scope = scope;
		field = false;
	}
	
	public Variable( String name,
			Type type,
			int scope,
			boolean field,
			SymbolNode next )
	{
		super( name, SymbolNode.VARIABLE, type, next );
		last_def = -1;
		last_use = -1;
		this.scope = scope;
		this.field = field;
	}
	
}
