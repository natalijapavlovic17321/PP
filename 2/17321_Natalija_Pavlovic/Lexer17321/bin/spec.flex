import KWTable;
import sym;
%%

%class MPLexer
%function next_token
%line
%column
%debug
%type Yytoken

%eofval{
return new Yytoken( sym.EOF, null, yyline, yycolumn);
%eofval}

%{ 
KWTable kwTable = new KWTable();
Yytoken getKW()
{
	return new Yytoken( kwTable.find( yytext() ),
	yytext(), yyline, yycolumn );
}
%}

%xstate KOMENTAR

slovo = [a-zA-Z]
cifra = [0-9]
bool = (true|false)

%%

// pravila
\/\*\* { yybegin( KOMENTAR ); }
<KOMENTAR>~"*/" { yybegin( YYINITIAL ); }

[\t\n\r ] { ; } 
\{ { return new Yytoken( sym.LEFTBLOCK, yytext(), yyline, yycolumn ); }
\} { return new Yytoken( sym.RIGHTBLOCK, yytext(), yyline, yycolumn ); }

\( { return new Yytoken( sym.LEFTPAR, yytext(), yyline, yycolumn ); }
\) { return new Yytoken( sym.RIGHTPAR, yytext(), yyline, yycolumn ); }

//operatori
\< { return new Yytoken( sym.LESSTHAN,yytext(), yyline, yycolumn ); }
\<\= { return new Yytoken( sym.LESSOREQUAL,yytext(), yyline, yycolumn ); }
\> { return new Yytoken( sym.GREATERTHAN,yytext(), yyline, yycolumn ); }
\>\= { return new Yytoken( sym.GREATEROREQUAL,yytext(), yyline, yycolumn ); }
\=\= { return new Yytoken( sym.EQUAL,yytext(), yyline, yycolumn ); }
\<\> { return new Yytoken( sym.NOTEQUAL,yytext(), yyline, yycolumn ); }
\* { return new Yytoken( sym.MUL,yytext(), yyline, yycolumn ); }

//separatori
; { return new Yytoken( sym.SEMICOLON, yytext(), yyline, yycolumn ); }
: { return new Yytoken( sym.COLON, yytext(), yyline, yycolumn ); }
:= { return new Yytoken( sym.ASSIGN, yytext(), yyline, yycolumn ); }

//kljucne reci
{slovo}+ { return getKW(); }
//identifikatori
{slovo}({slovo}|{cifra})* { return new Yytoken(sym.ID, yytext(),yyline, yycolumn ); }
//konstante

((({cifra}{1,2})?[#]?)({cifra}+)) { return new Yytoken( sym.CONST, yytext(), yyline, yycolumn ); }

(({cifra}+\.({cifra}+)?(E(\+|\-)?{cifra}+)?)|(\.{cifra}+(E(\+|\-)?{cifra}+)?)) { return new Yytoken( sym.CONST,yytext(), yyline, yycolumn ); }

{bool} { return new Yytoken( sym.CONST,yytext(), yyline, yycolumn ); }

//obrada gresaka
. { if (yytext() != null && yytext().length() > 0) System.out.println( "ERROR: " + yytext() ); }

