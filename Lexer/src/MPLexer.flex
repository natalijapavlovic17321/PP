import java_cup.runtime.*;

%%

// sekcija deklaracija
%class MPLexer

%cup

%line
%column

%eofval{
	return new Symbol( sym.EOF );
%eofval}

%{
    public int getLine()
    {
        return yyline;
    }
%}

%xstate KOMENTAR

slovo = [a-zA-Z]
cifra = [0-9]

%%

// pravila
\/\*\* { yybegin( KOMENTAR ); }
<KOMENTAR>~"*/" { yybegin( YYINITIAL ); }

[\t\n\r ] { ; } 
\{ { return new Symbol( sym.LEFTBLOCK ); }
\} { return new Symbol( sym.RIGHTBLOCK ); }

\( { return new Symbol( sym.LEFTPAR ); }
\) { return new Symbol( sym.RIGHTPAR ); }

//operatori
\< { return new Symbol( sym.LESSTHAN ); }
\<\= { return new Symbol( sym.LESSOREQUAL ); }
\> { return new Symbol( sym.GREATERTHAN ); }
\>\= { return new Symbol( sym.GREATEROREQUAL ); }
\=\= { return new Symbol( sym.EQUAL ); }
\<\> { return new Symbol( sym.NOTEQUAL); }

//separatori
; { return new Symbol( sym.SEMICOLON ); }
: { return new Symbol( sym.COLON ); }
:= { return new Symbol( sym.ASSIGN ); }

//kljucne reci
"main"		{ return new Symbol( sym.MAIN );	}	
"int"			{ return new Symbol( sym.INT );	}
"boolean"		{ return new Symbol( sym.BOOLEAN );	}
"real"			{ return new Symbol( sym.REAL );	}
"if"			{ return new Symbol( sym.IF );	}
"elif"			{ return new Symbol( sym.ELIF );	}
"else"			{ return new Symbol( sym.ELSE );	}
//"true" {return new Symbol(sym.BOOLEANCONST, Boolean.TRUE); }
//"false" {return new Symbol(sym.BOOLEANCONST, new Boolean.FALSE); }
"true"|"false" {return new Symbol(sym.BOOLEANCONST, new Boolean( yytext() ) ); }

//identifikatori
{slovo}({slovo}|{cifra})* { return new Symbol(sym.ID, yyline, yytext()); }
//konstante

((({cifra}{1,2})?[#]?)({cifra}+)) { return new Symbol( sym.INTCONST, (new Integer( yytext() ) )); }

(({cifra}+\.({cifra}+)?(E(\+|\-)?{cifra}+)?)|(\.{cifra}+(E(\+|\-)?{cifra}+)?)) { return new Symbol( sym.REALCONST, (new Double( yytext()))); }


//obrada gresaka
. {if (yytext() != null && yytext().length() > 0) System.out.println( "Error at ln: " + yyline + ", column: " + yycolumn + " -- " + yytext() );}

