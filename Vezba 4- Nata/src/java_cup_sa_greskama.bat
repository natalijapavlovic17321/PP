@echo off
REM ********   PODESAVANJA - MENJA STUDENT *********
set JCUP_HOME="C:\java_cup_v10k"
set JAVA_HOME="D:\Program Files\Java\jdk1.8.0_121"
set PARSER_CLASS_NAME="MPParser"
set CUP_SPEC_NAME="MPParser_sa_greskama.cup"


REM ********   POZIV JAVA CUP APLIKACIJE  ***********
echo vrednost : %JCUP_HOME%
%JAVA_HOME%\bin\java -classpath %JCUP_HOME% java_cup.Main -parser %PARSER_CLASS_NAME% -symbols sym < %CUP_SPEC_NAME%

PAUSE
