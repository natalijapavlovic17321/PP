
	import java.util.Hashtable;
	public class KWTable {
		private Hashtable mTable;
		public KWTable()
		{
			mTable = new Hashtable();
			mTable.put("main", new Integer(sym.MAIN));
			mTable.put("boolean", new Integer(sym.BOOLEAN));
			mTable.put("int", new Integer(sym.INT));
			mTable.put("real", new Integer(sym.REAL));
			//mTable.put("read", new Integer(sym.READ));
			//mTable.put("write", new Integer(sym.WRITE));
			mTable.put("if", new Integer(sym.IF));
			mTable.put("elif", new Integer(sym.ELIF));
			mTable.put("else", new Integer(sym.ELSE));
		}
		public int find(String keyword)
		{
			Object symbol = mTable.get(keyword);
			if (symbol != null)
				return ((Integer)symbol).intValue();
			return sym.ID;
		}
	}

