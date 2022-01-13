package SymbolTable;

public class SymbolTable {
	
	/*tabela simbola za "language scope"
	u ovom slucaju tu pripadaju samo tipovi*/
	private SymbolNode types;
	
	/* tabela simbola za oblast vazenja programa */
	private SymbolNode variables;
	
	public SymbolTable( )
	{
		types = new Type( "unknown", Type.UNKNOWN, null);
		//types = new Type( "char", Type.CHARACTER, types );
		//types = new Type( "integer", Type.INTEGER, types );
		types = new Type( "boolean", Type.BOOLEAN, types );
		types = new Type( "int", Type.INTEGER, types );
		types = new Type( "real", Type.DOUBLE, types );
		variables = null;
	}
	
	public boolean addVar( String name, Type type, int scope )
	{
		Variable existing = this.getVar( name, scope );
		if ( existing != null )
		{
			return false;
		}
		variables = new Variable( name, type, scope, variables );
		return true;
	}
	
	public Variable getVar( String name, int scope )
	{
		Variable current = (Variable) variables;
		while ( current != null && 
				(current.name.compareTo( name ) != 0 ||
						current.scope != scope ))
			current = (Variable) current.next;
		return ( Variable ) current;
	}
	
	
	public Type getType(String typeName)
	{
		SymbolNode current = types;
		while ( current != null && 
				current.name.compareTo( typeName ) != 0 )
			current = current.next;
		return ( Type ) current;
	}
	
	public SymbolNode getVariables()
	{
		return variables;
	}

}