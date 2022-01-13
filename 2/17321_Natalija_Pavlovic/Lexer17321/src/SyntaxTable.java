import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;


public class SyntaxTable {

  public final static int IF_STATEMENT = 100;
  public final static int REAL_EXPRESSION = 101;
  public final static int EXPRESSION = 102;
  public final static int ELSE_PART = 103;
  public final static int TERM = 104;

  private static ArrayList<HashMap<Integer, String>> _syntaxTable;
  private static ArrayList<Rule> _rules;

  public SyntaxTable() {
  }

  public static List<HashMap<Integer, String>> getSyntaxTable() {
    if (_syntaxTable == null)
      _syntaxTable = new ArrayList<HashMap<Integer, String>>() {
        {
          // #0
          add(new HashMap<Integer, String>() {
            {
              put(sym.IF, "sk 2");
            }
          });
       // #1
          add(new HashMap<Integer, String>() {
            {
              put(sym.EOF, "acc");
            }
          });
          // #2
          add(new HashMap<Integer, String>() {
            {
              put(sym.LEFTPAR, "sk 3");
            }
          });
          // #3
          add(new HashMap<Integer, String>() {
            {
              put(sym.ID, "sk 21");
              put(sym.CONST, "sk 22");
              put(REAL_EXPRESSION, "4");
              put(TERM, "18");
            }
          });
          // #4
          add(new HashMap<Integer, String>() {
            {
            	 put(sym.RIGHTPAR, "sk 5");
            }
          });
          // #5
          add(new HashMap<Integer, String>() {
            {
              put(sym.COLON, "sk 6");
            }
          });
          // #6
          add(new HashMap<Integer, String>() {
            {
            	put(sym.ID, "sk 21");
                put(sym.CONST, "sk 22");
                put(EXPRESSION, "7");
                put(TERM, "11");
            }
          });
          // #7
          add(new HashMap<Integer, String>() {
            {
                put(sym.ELSE, "sk 12");
                put(REAL_EXPRESSION, "8");
            }
          });
          // #8
          add(new HashMap<Integer, String>() {
            {
              put(sym.EOF, "rk 1");
            }
          });
          // #9
          add(new HashMap<Integer, String>() {
            {
              put(sym.ID, "sk 21");
              put(sym.CONST, "sk 22");
              put(TERM, "10");
            }
          });
          // #10
          add(new HashMap<Integer, String>() {
            {
              put(sym.MUL, "rk 4");
              put(sym.COLON, "rk 4");
              put(sym.EOF, "rk 4");
            }
          });
          // #11
          add(new HashMap<Integer, String>() {
            {
            	put(sym.MUL, "rk 5");
                put(sym.COLON, "rk 5");
                put(sym.EOF, "rk 5");
            }
          });
          // #12
          add(new HashMap<Integer, String>() {
            {
              put(sym.COLON, "sk 13");
            }
          });
          // #13
          add(new HashMap<Integer, String>() {
            {
            	put(sym.ID, "sk 21");
                put(sym.CONST, "sk 22");
                put(EXPRESSION, "14");
                put(TERM, "17");
            }
          });
          // #14
          add(new HashMap<Integer, String>() {
            {
              put(sym.MUL, "sk 15");
              put(sym.EOF, "rk 6");
            }
          });
          // #15
          add(new HashMap<Integer, String>() {
            {
            	put(sym.ID, "sk 21");
                put(sym.CONST, "sk 22");
                put(TERM, "16");
            }
          });
          // #16
          add(new HashMap<Integer, String>() {
            {
            	put(sym.EOF, "rk 1");
            }
          });
          // #17
          add(new HashMap<Integer, String>() {
            {
            	put(sym.EOF, "rk 1");
            }
          });
          // #18
          add(new HashMap<Integer, String>() {
            {
            	put(sym.GREATERTHAN, "sk 19");
                put(sym.RIGHTPAR, "rk 3");
                put(sym.EOF, "rk 3");
            }
          });
          // #19
          add(new HashMap<Integer, String>() {
            {
              put(sym.ID, "sk 21");
              put(sym.CONST, "sk 22");
              put(TERM, "20");
            }
          });
          // #20
          add(new HashMap<Integer, String>() {
            {
            	put(sym.GREATERTHAN, "rk 2");
                put(sym.EOF, "rk 2");
            }
          });
          // #21
          add(new HashMap<Integer, String>() {
            {
              put(sym.GREATERTHAN, "rk 7");
              put(sym.RIGHTPAR, "rk 7");
              put(sym.MUL, "rk 7");
              put(sym.ELSE, "rk 7");
              put(sym.EOF, "rk 7");
            }
          });
       // #22
          add(new HashMap<Integer, String>() {
            {
            	put(sym.GREATERTHAN, "rk 8");
                put(sym.RIGHTPAR, "rk 8");
                put(sym.MUL, "rk 8");
                put(sym.ELSE, "rk 8");
                put(sym.EOF, "rk 8");
            }
          });
        }
      };

    return _syntaxTable;
  }

  public static List<Rule> getRules() {
    if (_rules == null)
      _rules = new ArrayList<Rule>() {
        {
        	add(new Rule(SyntaxTable.IF_STATEMENT, new LinkedList<Integer>() {
            {
              add(sym.IF);
              add(sym.LEFTPAR);
              add(SyntaxTable.REAL_EXPRESSION);
              add(sym.RIGHTPAR);
              add(sym.COLON);
              add(SyntaxTable.EXPRESSION);
              add(SyntaxTable.ELSE_PART);
            }
          }));
          add(new Rule(SyntaxTable.REAL_EXPRESSION, new LinkedList<Integer>() {
            {
              add(SyntaxTable.TERM);
              add(sym.GREATERTHAN);
              add(SyntaxTable.TERM);
            }
          }));
          add(new Rule(SyntaxTable.REAL_EXPRESSION, new LinkedList<Integer>() {
            {
            	add(SyntaxTable.TERM);
            }
          }));
          add(new Rule(SyntaxTable.EXPRESSION, new LinkedList<Integer>() {
            {
              add(SyntaxTable.EXPRESSION);
              add(sym.MUL);
              add(SyntaxTable.TERM);
            }
          }));
          add(new Rule(SyntaxTable.EXPRESSION, new LinkedList<Integer>() {
            {
                add(SyntaxTable.TERM);
            }
          }));
          add(new Rule(SyntaxTable.ELSE_PART, new LinkedList<Integer>() {
            {
              add(sym.ELSE);
              add(sym.COLON);
              add(SyntaxTable.EXPRESSION);
            }
          }));
          add(new Rule(SyntaxTable.TERM, new LinkedList<Integer>() {
            {
              add(sym.ID);
            }
          }));
          add(new Rule(SyntaxTable.TERM, new LinkedList<Integer>() {
            {
              add(sym.CONST);
            }
          }));
        }
      };

    return _rules;
  }
}