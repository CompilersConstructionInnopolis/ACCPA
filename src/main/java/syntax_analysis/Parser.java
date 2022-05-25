/* A Bison parser, made by GNU Bison 3.8.2.  */

/* Skeleton implementation for Bison LALR(1) parsers in Java

   Copyright (C) 2007-2015, 2018-2021 Free Software Foundation, Inc.

   This program is free software: you can redistribute it and/or modify
   it under the terms of the GNU General Public License as published by
   the Free Software Foundation, either version 3 of the License, or
   (at your option) any later version.

   This program is distributed in the hope that it will be useful,
   but WITHOUT ANY WARRANTY; without even the implied warranty of
   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
   GNU General Public License for more details.

   You should have received a copy of the GNU General Public License
   along with this program.  If not, see <https://www.gnu.org/licenses/>.  */

/* As a special exception, you may create a larger work that contains
   part or all of the Bison parser skeleton and distribute that work
   under terms of your choice, so long as that work isn't itself a
   parser generator using the skeleton or a modified version thereof
   as a parser skeleton.  Alternatively, if you modify or redistribute
   the parser skeleton itself, you may (at your option) remove this
   special exception, which will cause the skeleton and the resulting
   Bison output files to be licensed under the GNU General Public
   License without this special exception.

   This special exception was added by the Free Software Foundation in
   version 2.2 of Bison.  */

/* DO NOT RELY ON FEATURES THAT ARE NOT DOCUMENTED in the manual,
   especially those whose name start with YY_ or yy_.  They are
   private implementation details that can be changed or removed.  */

package syntax_analysis;



import java.text.MessageFormat;
import java.util.ArrayList;
/* "%code imports" blocks.  */
/* "Parser.y":7  */

	import lexical_analysis.tokens.EvalToken;
        import lexical_analysis.tokens.IdentifierToken;
        import lexical_analysis.tokens.arithmetic_function.DivideToken;
        import lexical_analysis.tokens.arithmetic_function.MinusToken;
        import lexical_analysis.tokens.arithmetic_function.PlusToken;
        import lexical_analysis.tokens.arithmetic_function.TimesToken;
        import lexical_analysis.tokens.comparison.*;
        import lexical_analysis.tokens.literal.BooleanLiteralToken;
        import lexical_analysis.tokens.literal.IntegerNumberLiteralToken;
        import lexical_analysis.tokens.literal.RealNumberLiteralToken;
        import lexical_analysis.tokens.literal.StringLiteralToken;
        import lexical_analysis.tokens.logical_operator.AndToken;
        import lexical_analysis.tokens.logical_operator.NotToken;
        import lexical_analysis.tokens.logical_operator.OrToken;
        import lexical_analysis.tokens.logical_operator.XorToken;
        import lexical_analysis.tokens.operation_on_lists.ConsToken;
        import lexical_analysis.tokens.operation_on_lists.HeadToken;
        import lexical_analysis.tokens.operation_on_lists.TailToken;
        import lexical_analysis.tokens.predicate.*;
        import syntax_analysis.node.*;
        import syntax_analysis.node.special_form.*;
        import syntax_analysis.node.type_node.*;

        import java.io.FileReader;
        import java.io.IOException;

/* "Parser.java":73  */

/**
 * A Bison parser, automatically generated from <tt>Parser.y</tt>.
 *
 * @author LALR (1) parser skeleton written by Paolo Bonzini.
 */
public class Parser
{
  /** Version number for the Bison executable that generated this parser.  */
  public static final String bisonVersion = "3.8.2";

  /** Name of the skeleton that generated this parser.  */
  public static final String bisonSkeleton = "lalr1.java";






  public enum SymbolKind
  {
    S_YYEOF(0),                    /* "end of file"  */
    S_YYerror(1),                  /* error  */
    S_YYUNDEF(2),                  /* "invalid token"  */
    S_OpenParenthesisToken(3),     /* OpenParenthesisToken  */
    S_CloseParenthesisToken(4),    /* CloseParenthesisToken  */
    S_IntegerNumberLiteralToken(5), /* IntegerNumberLiteralToken  */
    S_RealNumberLiteralToken(6),   /* RealNumberLiteralToken  */
    S_BooleanLiteralToken(7),      /* BooleanLiteralToken  */
    S_IdentifierToken(8),          /* IdentifierToken  */
    S_QuoteToken(9),               /* QuoteToken  */
    S_QuoteShortToken(10),         /* QuoteShortToken  */
    S_SetQToken(11),               /* SetQToken  */
    S_FuncToken(12),               /* FuncToken  */
    S_LambdaToken(13),             /* LambdaToken  */
    S_ProgToken(14),               /* ProgToken  */
    S_CondToken(15),               /* CondToken  */
    S_PlusToken(16),               /* PlusToken  */
    S_MinusToken(17),              /* MinusToken  */
    S_TimesToken(18),              /* TimesToken  */
    S_DivideToken(19),             /* DivideToken  */
    S_HeadToken(20),               /* HeadToken  */
    S_TailToken(21),               /* TailToken  */
    S_ConsToken(22),               /* ConsToken  */
    S_EqualToken(23),              /* EqualToken  */
    S_NonEqualToken(24),           /* NonEqualToken  */
    S_LessToken(25),               /* LessToken  */
    S_LessEqToken(26),             /* LessEqToken  */
    S_GreaterToken(27),            /* GreaterToken  */
    S_GreaterEqToken(28),          /* GreaterEqToken  */
    S_IsIntToken(29),              /* IsIntToken  */
    S_IsRealToken(30),             /* IsRealToken  */
    S_IsBoolToken(31),             /* IsBoolToken  */
    S_IsAtomToken(32),             /* IsAtomToken  */
    S_IsListToken(33),             /* IsListToken  */
    S_AndToken(34),                /* AndToken  */
    S_OrToken(35),                 /* OrToken  */
    S_XorToken(36),                /* XorToken  */
    S_NotToken(37),                /* NotToken  */
    S_EvalToken(38),               /* EvalToken  */
    S_DefineToken(39),             /* DefineToken  */
    S_FunctypeToken(40),           /* FunctypeToken  */
    S_IntToken(41),                /* IntToken  */
    S_DoubleToken(42),             /* DoubleToken  */
    S_BooleanToken(43),            /* BooleanToken  */
    S_NumToken(44),                /* NumToken  */
    S_StringToken(45),             /* StringToken  */
    S_AnyToken(46),                /* AnyToken  */
    S_UnitToken(47),               /* UnitToken  */
    S_AutoToken(48),               /* AutoToken  */
    S_GetAtToken(49),              /* GetAtToken  */
    S_LetToken(50),                /* LetToken  */
    S_SetAtToken(51),              /* SetAtToken  */
    S_StringLiteralToken(52),      /* StringLiteralToken  */
    S_ArrowToken(53),              /* ArrowToken  */
    S_CommaToken(54),              /* CommaToken  */
    S_YYACCEPT(55),                /* $accept  */
    S_Program(56),                 /* Program  */
    S_Elements(57),                /* Elements  */
    S_TupleElements(58),           /* TupleElements  */
    S_Element(59),                 /* Element  */
    S_List(60),                    /* List  */
    S_SpecialForm(61),             /* SpecialForm  */
    S_Type(62),                    /* Type  */
    S_Types(63),                   /* Types  */
    S_TupleTypes(64),              /* TupleTypes  */
    S_BaseType(65),                /* BaseType  */
    S_FunctionType(66),            /* FunctionType  */
    S_Atom(67),                    /* Atom  */
    S_Literal(68);                 /* Literal  */


    private final int yycode_;

    SymbolKind (int n) {
      this.yycode_ = n;
    }

    private static final SymbolKind[] values_ = {
      SymbolKind.S_YYEOF,
      SymbolKind.S_YYerror,
      SymbolKind.S_YYUNDEF,
      SymbolKind.S_OpenParenthesisToken,
      SymbolKind.S_CloseParenthesisToken,
      SymbolKind.S_IntegerNumberLiteralToken,
      SymbolKind.S_RealNumberLiteralToken,
      SymbolKind.S_BooleanLiteralToken,
      SymbolKind.S_IdentifierToken,
      SymbolKind.S_QuoteToken,
      SymbolKind.S_QuoteShortToken,
      SymbolKind.S_SetQToken,
      SymbolKind.S_FuncToken,
      SymbolKind.S_LambdaToken,
      SymbolKind.S_ProgToken,
      SymbolKind.S_CondToken,
      SymbolKind.S_PlusToken,
      SymbolKind.S_MinusToken,
      SymbolKind.S_TimesToken,
      SymbolKind.S_DivideToken,
      SymbolKind.S_HeadToken,
      SymbolKind.S_TailToken,
      SymbolKind.S_ConsToken,
      SymbolKind.S_EqualToken,
      SymbolKind.S_NonEqualToken,
      SymbolKind.S_LessToken,
      SymbolKind.S_LessEqToken,
      SymbolKind.S_GreaterToken,
      SymbolKind.S_GreaterEqToken,
      SymbolKind.S_IsIntToken,
      SymbolKind.S_IsRealToken,
      SymbolKind.S_IsBoolToken,
      SymbolKind.S_IsAtomToken,
      SymbolKind.S_IsListToken,
      SymbolKind.S_AndToken,
      SymbolKind.S_OrToken,
      SymbolKind.S_XorToken,
      SymbolKind.S_NotToken,
      SymbolKind.S_EvalToken,
      SymbolKind.S_DefineToken,
      SymbolKind.S_FunctypeToken,
      SymbolKind.S_IntToken,
      SymbolKind.S_DoubleToken,
      SymbolKind.S_BooleanToken,
      SymbolKind.S_NumToken,
      SymbolKind.S_StringToken,
      SymbolKind.S_AnyToken,
      SymbolKind.S_UnitToken,
      SymbolKind.S_AutoToken,
      SymbolKind.S_GetAtToken,
      SymbolKind.S_LetToken,
      SymbolKind.S_SetAtToken,
      SymbolKind.S_StringLiteralToken,
      SymbolKind.S_ArrowToken,
      SymbolKind.S_CommaToken,
      SymbolKind.S_YYACCEPT,
      SymbolKind.S_Program,
      SymbolKind.S_Elements,
      SymbolKind.S_TupleElements,
      SymbolKind.S_Element,
      SymbolKind.S_List,
      SymbolKind.S_SpecialForm,
      SymbolKind.S_Type,
      SymbolKind.S_Types,
      SymbolKind.S_TupleTypes,
      SymbolKind.S_BaseType,
      SymbolKind.S_FunctionType,
      SymbolKind.S_Atom,
      SymbolKind.S_Literal
    };

    static final SymbolKind get(int code) {
      return values_[code];
    }

    public final int getCode() {
      return this.yycode_;
    }

    /* Return YYSTR after stripping away unnecessary quotes and
       backslashes, so that it's suitable for yyerror.  The heuristic is
       that double-quoting is unnecessary unless the string contains an
       apostrophe, a comma, or backslash (other than backslash-backslash).
       YYSTR is taken from yytname.  */
    private static String yytnamerr_(String yystr)
    {
      if (yystr.charAt (0) == '"')
        {
          StringBuffer yyr = new StringBuffer();
          strip_quotes: for (int i = 1; i < yystr.length(); i++)
            switch (yystr.charAt(i))
              {
              case '\'':
              case ',':
                break strip_quotes;

              case '\\':
                if (yystr.charAt(++i) != '\\')
                  break strip_quotes;
                /* Fall through.  */
              default:
                yyr.append(yystr.charAt(i));
                break;

              case '"':
                return yyr.toString();
              }
        }
      return yystr;
    }

    /* YYTNAME[SYMBOL-NUM] -- String name of the symbol SYMBOL-NUM.
       First, the terminals, then, starting at \a YYNTOKENS_, nonterminals.  */
    private static final String[] yytname_ = yytname_init();
  private static final String[] yytname_init()
  {
    return new String[]
    {
  "\"end of file\"", "error", "\"invalid token\"", "OpenParenthesisToken",
  "CloseParenthesisToken", "IntegerNumberLiteralToken",
  "RealNumberLiteralToken", "BooleanLiteralToken", "IdentifierToken",
  "QuoteToken", "QuoteShortToken", "SetQToken", "FuncToken", "LambdaToken",
  "ProgToken", "CondToken", "PlusToken", "MinusToken", "TimesToken",
  "DivideToken", "HeadToken", "TailToken", "ConsToken", "EqualToken",
  "NonEqualToken", "LessToken", "LessEqToken", "GreaterToken",
  "GreaterEqToken", "IsIntToken", "IsRealToken", "IsBoolToken",
  "IsAtomToken", "IsListToken", "AndToken", "OrToken", "XorToken",
  "NotToken", "EvalToken", "DefineToken", "FunctypeToken", "IntToken",
  "DoubleToken", "BooleanToken", "NumToken", "StringToken", "AnyToken",
  "UnitToken", "AutoToken", "GetAtToken", "LetToken", "SetAtToken",
  "StringLiteralToken", "ArrowToken", "CommaToken", "$accept", "Program",
  "Elements", "TupleElements", "Element", "List", "SpecialForm", "Type",
  "Types", "TupleTypes", "BaseType", "FunctionType", "Atom", "Literal", null
    };
  }

    /* The user-facing name of this symbol.  */
    public final String getName() {
      return yytnamerr_(yytname_[yycode_]);
    }

  };


  /**
   * Communication interface between the scanner and the Bison-generated
   * parser <tt>Parser</tt>.
   */
  public interface Lexer {
    /* Token kinds.  */
    /** Token "end of file", to be returned by the scanner.  */
    static final int YYEOF = 0;
    /** Token error, to be returned by the scanner.  */
    static final int YYerror = 256;
    /** Token "invalid token", to be returned by the scanner.  */
    static final int YYUNDEF = 257;
    /** Token OpenParenthesisToken, to be returned by the scanner.  */
    static final int OpenParenthesisToken = 258;
    /** Token CloseParenthesisToken, to be returned by the scanner.  */
    static final int CloseParenthesisToken = 259;
    /** Token IntegerNumberLiteralToken, to be returned by the scanner.  */
    static final int IntegerNumberLiteralToken = 260;
    /** Token RealNumberLiteralToken, to be returned by the scanner.  */
    static final int RealNumberLiteralToken = 261;
    /** Token BooleanLiteralToken, to be returned by the scanner.  */
    static final int BooleanLiteralToken = 262;
    /** Token IdentifierToken, to be returned by the scanner.  */
    static final int IdentifierToken = 263;
    /** Token QuoteToken, to be returned by the scanner.  */
    static final int QuoteToken = 264;
    /** Token QuoteShortToken, to be returned by the scanner.  */
    static final int QuoteShortToken = 265;
    /** Token SetQToken, to be returned by the scanner.  */
    static final int SetQToken = 266;
    /** Token FuncToken, to be returned by the scanner.  */
    static final int FuncToken = 267;
    /** Token LambdaToken, to be returned by the scanner.  */
    static final int LambdaToken = 268;
    /** Token ProgToken, to be returned by the scanner.  */
    static final int ProgToken = 269;
    /** Token CondToken, to be returned by the scanner.  */
    static final int CondToken = 270;
    /** Token PlusToken, to be returned by the scanner.  */
    static final int PlusToken = 271;
    /** Token MinusToken, to be returned by the scanner.  */
    static final int MinusToken = 272;
    /** Token TimesToken, to be returned by the scanner.  */
    static final int TimesToken = 273;
    /** Token DivideToken, to be returned by the scanner.  */
    static final int DivideToken = 274;
    /** Token HeadToken, to be returned by the scanner.  */
    static final int HeadToken = 275;
    /** Token TailToken, to be returned by the scanner.  */
    static final int TailToken = 276;
    /** Token ConsToken, to be returned by the scanner.  */
    static final int ConsToken = 277;
    /** Token EqualToken, to be returned by the scanner.  */
    static final int EqualToken = 278;
    /** Token NonEqualToken, to be returned by the scanner.  */
    static final int NonEqualToken = 279;
    /** Token LessToken, to be returned by the scanner.  */
    static final int LessToken = 280;
    /** Token LessEqToken, to be returned by the scanner.  */
    static final int LessEqToken = 281;
    /** Token GreaterToken, to be returned by the scanner.  */
    static final int GreaterToken = 282;
    /** Token GreaterEqToken, to be returned by the scanner.  */
    static final int GreaterEqToken = 283;
    /** Token IsIntToken, to be returned by the scanner.  */
    static final int IsIntToken = 284;
    /** Token IsRealToken, to be returned by the scanner.  */
    static final int IsRealToken = 285;
    /** Token IsBoolToken, to be returned by the scanner.  */
    static final int IsBoolToken = 286;
    /** Token IsAtomToken, to be returned by the scanner.  */
    static final int IsAtomToken = 287;
    /** Token IsListToken, to be returned by the scanner.  */
    static final int IsListToken = 288;
    /** Token AndToken, to be returned by the scanner.  */
    static final int AndToken = 289;
    /** Token OrToken, to be returned by the scanner.  */
    static final int OrToken = 290;
    /** Token XorToken, to be returned by the scanner.  */
    static final int XorToken = 291;
    /** Token NotToken, to be returned by the scanner.  */
    static final int NotToken = 292;
    /** Token EvalToken, to be returned by the scanner.  */
    static final int EvalToken = 293;
    /** Token DefineToken, to be returned by the scanner.  */
    static final int DefineToken = 294;
    /** Token FunctypeToken, to be returned by the scanner.  */
    static final int FunctypeToken = 295;
    /** Token IntToken, to be returned by the scanner.  */
    static final int IntToken = 296;
    /** Token DoubleToken, to be returned by the scanner.  */
    static final int DoubleToken = 297;
    /** Token BooleanToken, to be returned by the scanner.  */
    static final int BooleanToken = 298;
    /** Token NumToken, to be returned by the scanner.  */
    static final int NumToken = 299;
    /** Token StringToken, to be returned by the scanner.  */
    static final int StringToken = 300;
    /** Token AnyToken, to be returned by the scanner.  */
    static final int AnyToken = 301;
    /** Token UnitToken, to be returned by the scanner.  */
    static final int UnitToken = 302;
    /** Token AutoToken, to be returned by the scanner.  */
    static final int AutoToken = 303;
    /** Token GetAtToken, to be returned by the scanner.  */
    static final int GetAtToken = 304;
    /** Token LetToken, to be returned by the scanner.  */
    static final int LetToken = 305;
    /** Token SetAtToken, to be returned by the scanner.  */
    static final int SetAtToken = 306;
    /** Token StringLiteralToken, to be returned by the scanner.  */
    static final int StringLiteralToken = 307;
    /** Token ArrowToken, to be returned by the scanner.  */
    static final int ArrowToken = 308;
    /** Token CommaToken, to be returned by the scanner.  */
    static final int CommaToken = 309;

    /** Deprecated, use YYEOF instead.  */
    public static final int EOF = YYEOF;


    /**
     * Method to retrieve the semantic value of the last scanned token.
     * @return the semantic value of the last scanned token.
     */
    Object getLVal();

    /**
     * Entry point for the scanner.  Returns the token identifier corresponding
     * to the next token and prepares to return the semantic value
     * of the token.
     * @return the token identifier corresponding to the next token.
     */
    int yylex() throws java.io.IOException;

    /**
     * Emit an errorin a user-defined way.
     *
     *
     * @param msg The string for the error message.
     */
     void yyerror(String msg);


  }


  /**
   * The object doing lexical analysis for us.
   */
  private Lexer yylexer;





  /**
   * Instantiates the Bison-generated parser.
   * @param yylexer The scanner that will supply tokens to the parser.
   */
  public Parser(Lexer yylexer)
  {

    this.yylexer = yylexer;

  }



  private int yynerrs = 0;

  /**
   * The number of syntax errors so far.
   */
  public final int getNumberOfErrors() { return yynerrs; }

  /**
   * Print an error message via the lexer.
   *
   * @param msg The error message.
   */
  public final void yyerror(String msg) {
      yylexer.yyerror(msg);
  }



  private final class YYStack {
    private int[] stateStack = new int[16];
    private Object[] valueStack = new Object[16];

    public int size = 16;
    public int height = -1;

    public final void push(int state, Object value) {
      height++;
      if (size == height) {
        int[] newStateStack = new int[size * 2];
        System.arraycopy(stateStack, 0, newStateStack, 0, height);
        stateStack = newStateStack;

        Object[] newValueStack = new Object[size * 2];
        System.arraycopy(valueStack, 0, newValueStack, 0, height);
        valueStack = newValueStack;

        size *= 2;
      }

      stateStack[height] = state;
      valueStack[height] = value;
    }

    public final void pop() {
      pop(1);
    }

    public final void pop(int num) {
      // Avoid memory leaks... garbage collection is a white lie!
      if (0 < num) {
        java.util.Arrays.fill(valueStack, height - num + 1, height + 1, null);
      }
      height -= num;
    }

    public final int stateAt(int i) {
      return stateStack[height - i];
    }

    public final Object valueAt(int i) {
      return valueStack[height - i];
    }

    // Print the state stack on the debug stream.
    public void print(java.io.PrintStream out) {
      out.print ("Stack now");

      for (int i = 0; i <= height; i++) {
        out.print(' ');
        out.print(stateStack[i]);
      }
      out.println();
    }
  }

  /**
   * Returned by a Bison action in order to stop the parsing process and
   * return success (<tt>true</tt>).
   */
  public static final int YYACCEPT = 0;

  /**
   * Returned by a Bison action in order to stop the parsing process and
   * return failure (<tt>false</tt>).
   */
  public static final int YYABORT = 1;



  /**
   * Returned by a Bison action in order to start error recovery without
   * printing an error message.
   */
  public static final int YYERROR = 2;

  /**
   * Internal return codes that are not supported for user semantic
   * actions.
   */
  private static final int YYERRLAB = 3;
  private static final int YYNEWSTATE = 4;
  private static final int YYDEFAULT = 5;
  private static final int YYREDUCE = 6;
  private static final int YYERRLAB1 = 7;
  private static final int YYRETURN = 8;


  private int yyerrstatus_ = 0;


  /**
   * Whether error recovery is being done.  In this state, the parser
   * reads token until it reaches a known state, and then restarts normal
   * operation.
   */
  public final boolean recovering ()
  {
    return yyerrstatus_ == 0;
  }

  /** Compute post-reduction state.
   * @param yystate   the current state
   * @param yysym     the nonterminal to push on the stack
   */
  private int yyLRGotoState(int yystate, int yysym) {
    int yyr = yypgoto_[yysym - YYNTOKENS_] + yystate;
    if (0 <= yyr && yyr <= YYLAST_ && yycheck_[yyr] == yystate)
      return yytable_[yyr];
    else
      return yydefgoto_[yysym - YYNTOKENS_];
  }

  private int yyaction(int yyn, YYStack yystack, int yylen)
  {
    /* If YYLEN is nonzero, implement the default value of the action:
       '$$ = $1'.  Otherwise, use the top of the stack.

       Otherwise, the following line sets YYVAL to garbage.
       This behavior is undocumented and Bison
       users should not rely upon it.  */
    Object yyval = (0 < yylen) ? yystack.valueAt(yylen - 1) : yystack.valueAt(0);

    switch (yyn)
      {
          case 2: /* Program: Element  */
  if (yyn == 2)
    /* "Parser.y":121  */
                  {ast = new AST(new ListNode(((ElementInterface)(yystack.valueAt (0)))));};
  break;


  case 3: /* Program: Element Elements  */
  if (yyn == 3)
    /* "Parser.y":122  */
                           {ast = new AST(new ListNode(((ElementInterface)(yystack.valueAt (1))), ((ListNode)(yystack.valueAt (0))))); };
  break;


  case 4: /* Elements: %empty  */
  if (yyn == 4)
    /* "Parser.y":125  */
                       {yyval = new ListNode();};
  break;


  case 5: /* Elements: Element Elements  */
  if (yyn == 5)
    /* "Parser.y":126  */
                           {yyval = new ListNode(((ElementInterface)(yystack.valueAt (1))), ((ListNode)(yystack.valueAt (0))));};
  break;


  case 6: /* TupleElements: %empty  */
  if (yyn == 6)
    /* "Parser.y":129  */
                       {yyval = new ListNode();};
  break;


  case 7: /* TupleElements: CommaToken Element TupleElements  */
  if (yyn == 7)
    /* "Parser.y":130  */
                                           {yyval = new ListNode(((ElementInterface)(yystack.valueAt (1))), ((ListNode)(yystack.valueAt (0))));};
  break;


  case 8: /* Element: Atom  */
  if (yyn == 8)
    /* "Parser.y":133  */
               {yyval = ((AtomNode)(yystack.valueAt (0)));};
  break;


  case 9: /* Element: Literal  */
  if (yyn == 9)
    /* "Parser.y":134  */
                  {yyval = ((LiteralNode)(yystack.valueAt (0)));};
  break;


  case 10: /* Element: List  */
  if (yyn == 10)
    /* "Parser.y":135  */
               {yyval = ((ElementInterface)(yystack.valueAt (0)));};
  break;


  case 11: /* Element: QuoteShortToken Element  */
  if (yyn == 11)
    /* "Parser.y":136  */
                                  {yyval = new QuoteNode(((ElementInterface)(yystack.valueAt (0))));};
  break;


  case 12: /* Element: OpenParenthesisToken Element CommaToken Element TupleElements CloseParenthesisToken  */
  if (yyn == 12)
    /* "Parser.y":137  */
                                                                                              {yyval = new TupleNode(((ElementInterface)(yystack.valueAt (4))), ((ElementInterface)(yystack.valueAt (2))), ((ListNode)(yystack.valueAt (1))));};
  break;


  case 13: /* List: OpenParenthesisToken Element Elements CloseParenthesisToken  */
  if (yyn == 13)
    /* "Parser.y":140  */
                                                                      {yyval = new ListNode(((ElementInterface)(yystack.valueAt (2))), ((ListNode)(yystack.valueAt (1))));};
  break;


  case 14: /* List: OpenParenthesisToken SpecialForm CloseParenthesisToken  */
  if (yyn == 14)
    /* "Parser.y":141  */
                                                                 {yyval = ((ElementInterface)(yystack.valueAt (1)));};
  break;


  case 15: /* List: OpenParenthesisToken CloseParenthesisToken  */
  if (yyn == 15)
    /* "Parser.y":142  */
                                                     {yyval = new ListNode();};
  break;


  case 16: /* SpecialForm: QuoteToken Element  */
  if (yyn == 16)
    /* "Parser.y":145  */
                             {yyval = new QuoteNode(((ElementInterface)(yystack.valueAt (0))));};
  break;


  case 17: /* SpecialForm: DefineToken Atom Type  */
  if (yyn == 17)
    /* "Parser.y":146  */
                                {yyval = new DefineNode(((AtomNode)(yystack.valueAt (1))), ((NodeType)(yystack.valueAt (0))));};
  break;


  case 18: /* SpecialForm: SetQToken Atom Element  */
  if (yyn == 18)
    /* "Parser.y":147  */
                                 {yyval = new SetQNode(((AtomNode)(yystack.valueAt (1))), ((ElementInterface)(yystack.valueAt (0))));};
  break;


  case 19: /* SpecialForm: FunctypeToken Atom FunctionType  */
  if (yyn == 19)
    /* "Parser.y":148  */
                                          {yyval = new FunctypeNode(((AtomNode)(yystack.valueAt (1))), ((FunctionType)(yystack.valueAt (0))));};
  break;


  case 20: /* SpecialForm: FuncToken Atom List Element  */
  if (yyn == 20)
    /* "Parser.y":149  */
                                      {yyval = new FuncNode(((AtomNode)(yystack.valueAt (2))), ((ElementInterface)(yystack.valueAt (1))), ((ElementInterface)(yystack.valueAt (0))));};
  break;


  case 21: /* SpecialForm: LambdaToken List Element  */
  if (yyn == 21)
    /* "Parser.y":150  */
                                   {yyval = new LambdaNode(((ElementInterface)(yystack.valueAt (1))), ((ElementInterface)(yystack.valueAt (0))));};
  break;


  case 22: /* SpecialForm: ProgToken List Element  */
  if (yyn == 22)
    /* "Parser.y":151  */
                                 {yyval = new ProgNode(((ElementInterface)(yystack.valueAt (1))), ((ElementInterface)(yystack.valueAt (0))));};
  break;


  case 23: /* SpecialForm: CondToken Element Element Element  */
  if (yyn == 23)
    /* "Parser.y":152  */
                                            {yyval = new CondNode(((ElementInterface)(yystack.valueAt (2))), ((ElementInterface)(yystack.valueAt (1))), ((ElementInterface)(yystack.valueAt (0))));};
  break;


  case 24: /* Type: BaseType  */
  if (yyn == 24)
    /* "Parser.y":155  */
                   {yyval = ((NodeType)(yystack.valueAt (0)));};
  break;


  case 25: /* Type: FunctionType  */
  if (yyn == 25)
    /* "Parser.y":156  */
                       {yyval = ((FunctionType)(yystack.valueAt (0)));};
  break;


  case 26: /* Types: %empty  */
  if (yyn == 26)
    /* "Parser.y":159  */
                      {yyval = new ListOfTypes();};
  break;


  case 27: /* Types: Type Types  */
  if (yyn == 27)
    /* "Parser.y":160  */
                     {yyval = new ListOfTypes(((NodeType)(yystack.valueAt (1))), ((ListOfTypes)(yystack.valueAt (0))));};
  break;


  case 28: /* TupleTypes: %empty  */
  if (yyn == 28)
    /* "Parser.y":163  */
                      {yyval = new ListOfTypes();};
  break;


  case 29: /* TupleTypes: CommaToken Type TupleTypes  */
  if (yyn == 29)
    /* "Parser.y":164  */
                                     {yyval = new ListOfTypes(((NodeType)(yystack.valueAt (1))), ((ListOfTypes)(yystack.valueAt (0))));};
  break;


  case 30: /* BaseType: IntToken  */
  if (yyn == 30)
    /* "Parser.y":167  */
                   {yyval = new IntType();};
  break;


  case 31: /* BaseType: DoubleToken  */
  if (yyn == 31)
    /* "Parser.y":168  */
                      {yyval = new DoubleType();};
  break;


  case 32: /* BaseType: BooleanToken  */
  if (yyn == 32)
    /* "Parser.y":169  */
                       {yyval = new BooleanType();};
  break;


  case 33: /* BaseType: StringToken  */
  if (yyn == 33)
    /* "Parser.y":170  */
                      {yyval = new StringType();};
  break;


  case 34: /* BaseType: NumToken  */
  if (yyn == 34)
    /* "Parser.y":171  */
                   {yyval = new NumType();};
  break;


  case 35: /* BaseType: AnyToken  */
  if (yyn == 35)
    /* "Parser.y":172  */
                   {yyval = new AnyType();};
  break;


  case 36: /* BaseType: UnitToken  */
  if (yyn == 36)
    /* "Parser.y":173  */
                    {yyval = new UnitType();};
  break;


  case 37: /* BaseType: AutoToken  */
  if (yyn == 37)
    /* "Parser.y":174  */
                    {yyval = new AutoType();};
  break;


  case 38: /* BaseType: OpenParenthesisToken Type CloseParenthesisToken  */
  if (yyn == 38)
    /* "Parser.y":175  */
                                                          {yyval = new ListType(((NodeType)(yystack.valueAt (1))));};
  break;


  case 39: /* BaseType: OpenParenthesisToken Type CommaToken Type TupleTypes CloseParenthesisToken  */
  if (yyn == 39)
    /* "Parser.y":176  */
                                                                                     {yyval = new TupleType(((NodeType)(yystack.valueAt (4))), ((NodeType)(yystack.valueAt (2))), ((ListOfTypes)(yystack.valueAt (1))));};
  break;


  case 40: /* FunctionType: OpenParenthesisToken Type Types ArrowToken Type CloseParenthesisToken  */
  if (yyn == 40)
    /* "Parser.y":179  */
                                                                                {yyval = new FunctionType(((NodeType)(yystack.valueAt (4))), ((ListOfTypes)(yystack.valueAt (3))), ((NodeType)(yystack.valueAt (1))));};
  break;


  case 41: /* Atom: IdentifierToken  */
  if (yyn == 41)
    /* "Parser.y":182  */
                          {yyval = new AtomNode(((IdentifierToken)(yystack.valueAt (0))));};
  break;


  case 42: /* Atom: PlusToken  */
  if (yyn == 42)
    /* "Parser.y":183  */
                    {yyval = new AtomNode(((PlusToken)(yystack.valueAt (0))));};
  break;


  case 43: /* Atom: MinusToken  */
  if (yyn == 43)
    /* "Parser.y":184  */
                     {yyval = new AtomNode(((MinusToken)(yystack.valueAt (0))));};
  break;


  case 44: /* Atom: TimesToken  */
  if (yyn == 44)
    /* "Parser.y":185  */
                     {yyval = new AtomNode(((TimesToken)(yystack.valueAt (0))));};
  break;


  case 45: /* Atom: DivideToken  */
  if (yyn == 45)
    /* "Parser.y":186  */
                      {yyval = new AtomNode(((DivideToken)(yystack.valueAt (0))));};
  break;


  case 46: /* Atom: HeadToken  */
  if (yyn == 46)
    /* "Parser.y":187  */
                    {yyval = new AtomNode(((HeadToken)(yystack.valueAt (0))));};
  break;


  case 47: /* Atom: TailToken  */
  if (yyn == 47)
    /* "Parser.y":188  */
                    {yyval = new AtomNode(((TailToken)(yystack.valueAt (0))));};
  break;


  case 48: /* Atom: ConsToken  */
  if (yyn == 48)
    /* "Parser.y":189  */
                    {yyval = new AtomNode(((ConsToken)(yystack.valueAt (0))));};
  break;


  case 49: /* Atom: EqualToken  */
  if (yyn == 49)
    /* "Parser.y":190  */
                     {yyval = new AtomNode(((EqualToken)(yystack.valueAt (0))));};
  break;


  case 50: /* Atom: NonEqualToken  */
  if (yyn == 50)
    /* "Parser.y":191  */
                        {yyval = new AtomNode(((NonEqualToken)(yystack.valueAt (0))));};
  break;


  case 51: /* Atom: LessToken  */
  if (yyn == 51)
    /* "Parser.y":192  */
                    {yyval = new AtomNode(((LessToken)(yystack.valueAt (0))));};
  break;


  case 52: /* Atom: LessEqToken  */
  if (yyn == 52)
    /* "Parser.y":193  */
                      {yyval = new AtomNode(((LessEqToken)(yystack.valueAt (0))));};
  break;


  case 53: /* Atom: GreaterToken  */
  if (yyn == 53)
    /* "Parser.y":194  */
                       {yyval = new AtomNode(((GreaterToken)(yystack.valueAt (0))));};
  break;


  case 54: /* Atom: GreaterEqToken  */
  if (yyn == 54)
    /* "Parser.y":195  */
                         {yyval = new AtomNode(((GreaterEqToken)(yystack.valueAt (0))));};
  break;


  case 55: /* Atom: IsIntToken  */
  if (yyn == 55)
    /* "Parser.y":196  */
                     {yyval = new AtomNode(((IsIntToken)(yystack.valueAt (0))));};
  break;


  case 56: /* Atom: IsRealToken  */
  if (yyn == 56)
    /* "Parser.y":197  */
                      {yyval = new AtomNode(((IsRealToken)(yystack.valueAt (0))));};
  break;


  case 57: /* Atom: IsBoolToken  */
  if (yyn == 57)
    /* "Parser.y":198  */
                      {yyval = new AtomNode(((IsBoolToken)(yystack.valueAt (0))));};
  break;


  case 58: /* Atom: IsAtomToken  */
  if (yyn == 58)
    /* "Parser.y":199  */
                      {yyval = new AtomNode(((IsAtomToken)(yystack.valueAt (0))));};
  break;


  case 59: /* Atom: IsListToken  */
  if (yyn == 59)
    /* "Parser.y":200  */
                      {yyval = new AtomNode(((IsListToken)(yystack.valueAt (0))));};
  break;


  case 60: /* Atom: AndToken  */
  if (yyn == 60)
    /* "Parser.y":201  */
                   {yyval = new AtomNode(((AndToken)(yystack.valueAt (0))));};
  break;


  case 61: /* Atom: OrToken  */
  if (yyn == 61)
    /* "Parser.y":202  */
                  {yyval = new AtomNode(((OrToken)(yystack.valueAt (0))));};
  break;


  case 62: /* Atom: XorToken  */
  if (yyn == 62)
    /* "Parser.y":203  */
                   {yyval = new AtomNode(((XorToken)(yystack.valueAt (0))));};
  break;


  case 63: /* Atom: NotToken  */
  if (yyn == 63)
    /* "Parser.y":204  */
                   {yyval = new AtomNode(((NotToken)(yystack.valueAt (0))));};
  break;


  case 64: /* Atom: EvalToken  */
  if (yyn == 64)
    /* "Parser.y":205  */
                    {yyval = new AtomNode(((EvalToken)(yystack.valueAt (0))));};
  break;


  case 65: /* Literal: IntegerNumberLiteralToken  */
  if (yyn == 65)
    /* "Parser.y":208  */
                                    {yyval = new LiteralNode(((IntegerNumberLiteralToken)(yystack.valueAt (0))));};
  break;


  case 66: /* Literal: RealNumberLiteralToken  */
  if (yyn == 66)
    /* "Parser.y":209  */
                                 {yyval = new LiteralNode(((RealNumberLiteralToken)(yystack.valueAt (0))));};
  break;


  case 67: /* Literal: BooleanLiteralToken  */
  if (yyn == 67)
    /* "Parser.y":210  */
                              {yyval = new LiteralNode(((BooleanLiteralToken)(yystack.valueAt (0))));};
  break;


  case 68: /* Literal: StringLiteralToken  */
  if (yyn == 68)
    /* "Parser.y":211  */
                             {yyval = new LiteralNode(((StringLiteralToken)(yystack.valueAt (0))));};
  break;



/* "Parser.java":1100  */

        default: break;
      }

    yystack.pop(yylen);
    yylen = 0;
    /* Shift the result of the reduction.  */
    int yystate = yyLRGotoState(yystack.stateAt(0), yyr1_[yyn]);
    yystack.push(yystate, yyval);
    return YYNEWSTATE;
  }




  /**
   * Parse input from the scanner that was specified at object construction
   * time.  Return whether the end of the input was reached successfully.
   *
   * @return <tt>true</tt> if the parsing succeeds.  Note that this does not
   *          imply that there were no syntax errors.
   */
  public boolean parse() throws java.io.IOException

  {


    /* Lookahead token kind.  */
    int yychar = YYEMPTY_;
    /* Lookahead symbol kind.  */
    SymbolKind yytoken = null;

    /* State.  */
    int yyn = 0;
    int yylen = 0;
    int yystate = 0;
    YYStack yystack = new YYStack ();
    int label = YYNEWSTATE;



    /* Semantic value of the lookahead.  */
    Object yylval = null;



    yyerrstatus_ = 0;
    yynerrs = 0;

    /* Initialize the stack.  */
    yystack.push (yystate, yylval);



    for (;;)
      switch (label)
      {
        /* New state.  Unlike in the C/C++ skeletons, the state is already
           pushed when we come here.  */
      case YYNEWSTATE:

        /* Accept?  */
        if (yystate == YYFINAL_)
          return true;

        /* Take a decision.  First try without lookahead.  */
        yyn = yypact_[yystate];
        if (yyPactValueIsDefault (yyn))
          {
            label = YYDEFAULT;
            break;
          }

        /* Read a lookahead token.  */
        if (yychar == YYEMPTY_)
          {

            yychar = yylexer.yylex ();
            yylval = yylexer.getLVal();

          }

        /* Convert token to internal form.  */
        yytoken = yytranslate_ (yychar);

        if (yytoken == SymbolKind.S_YYerror)
          {
            // The scanner already issued an error message, process directly
            // to error recovery.  But do not keep the error token as
            // lookahead, it is too special and may lead us to an endless
            // loop in error recovery. */
            yychar = Lexer.YYUNDEF;
            yytoken = SymbolKind.S_YYUNDEF;
            label = YYERRLAB1;
          }
        else
          {
            /* If the proper action on seeing token YYTOKEN is to reduce or to
               detect an error, take that action.  */
            yyn += yytoken.getCode();
            if (yyn < 0 || YYLAST_ < yyn || yycheck_[yyn] != yytoken.getCode()) {
              label = YYDEFAULT;
            }

            /* <= 0 means reduce or error.  */
            else if ((yyn = yytable_[yyn]) <= 0)
              {
                if (yyTableValueIsError(yyn)) {
                  label = YYERRLAB;
                } else {
                  yyn = -yyn;
                  label = YYREDUCE;
                }
              }

            else
              {
                /* Shift the lookahead token.  */
                /* Discard the token being shifted.  */
                yychar = YYEMPTY_;

                /* Count tokens shifted since error; after three, turn off error
                   status.  */
                if (yyerrstatus_ > 0)
                  --yyerrstatus_;

                yystate = yyn;
                yystack.push(yystate, yylval);
                label = YYNEWSTATE;
              }
          }
        break;

      /*-----------------------------------------------------------.
      | yydefault -- do the default action for the current state.  |
      `-----------------------------------------------------------*/
      case YYDEFAULT:
        yyn = yydefact_[yystate];
        if (yyn == 0)
          label = YYERRLAB;
        else
          label = YYREDUCE;
        break;

      /*-----------------------------.
      | yyreduce -- Do a reduction.  |
      `-----------------------------*/
      case YYREDUCE:
        yylen = yyr2_[yyn];
        label = yyaction(yyn, yystack, yylen);
        yystate = yystack.stateAt(0);
        break;

      /*------------------------------------.
      | yyerrlab -- here on detecting error |
      `------------------------------------*/
      case YYERRLAB:
        /* If not already recovering from an error, report this error.  */
        if (yyerrstatus_ == 0)
          {
            ++yynerrs;
            if (yychar == YYEMPTY_)
              yytoken = null;
            yyreportSyntaxError(new Context(this, yystack, yytoken));
          }

        if (yyerrstatus_ == 3)
          {
            /* If just tried and failed to reuse lookahead token after an
               error, discard it.  */

            if (yychar <= Lexer.YYEOF)
              {
                /* Return failure if at end of input.  */
                if (yychar == Lexer.YYEOF)
                  return false;
              }
            else
              yychar = YYEMPTY_;
          }

        /* Else will try to reuse lookahead token after shifting the error
           token.  */
        label = YYERRLAB1;
        break;

      /*-------------------------------------------------.
      | errorlab -- error raised explicitly by YYERROR.  |
      `-------------------------------------------------*/
      case YYERROR:
        /* Do not reclaim the symbols of the rule which action triggered
           this YYERROR.  */
        yystack.pop (yylen);
        yylen = 0;
        yystate = yystack.stateAt(0);
        label = YYERRLAB1;
        break;

      /*-------------------------------------------------------------.
      | yyerrlab1 -- common code for both syntax error and YYERROR.  |
      `-------------------------------------------------------------*/
      case YYERRLAB1:
        yyerrstatus_ = 3;       /* Each real token shifted decrements this.  */

        // Pop stack until we find a state that shifts the error token.
        for (;;)
          {
            yyn = yypact_[yystate];
            if (!yyPactValueIsDefault (yyn))
              {
                yyn += SymbolKind.S_YYerror.getCode();
                if (0 <= yyn && yyn <= YYLAST_
                    && yycheck_[yyn] == SymbolKind.S_YYerror.getCode())
                  {
                    yyn = yytable_[yyn];
                    if (0 < yyn)
                      break;
                  }
              }

            /* Pop the current state because it cannot handle the
             * error token.  */
            if (yystack.height == 0)
              return false;


            yystack.pop ();
            yystate = yystack.stateAt(0);
          }

        if (label == YYABORT)
          /* Leave the switch.  */
          break;



        /* Shift the error token.  */

        yystate = yyn;
        yystack.push (yyn, yylval);
        label = YYNEWSTATE;
        break;

        /* Accept.  */
      case YYACCEPT:
        return true;

        /* Abort.  */
      case YYABORT:
        return false;
      }
}




  /**
   * Information needed to get the list of expected tokens and to forge
   * a syntax error diagnostic.
   */
  public static final class Context {
    Context(Parser parser, YYStack stack, SymbolKind token) {
      yyparser = parser;
      yystack = stack;
      yytoken = token;
    }

    private Parser yyparser;
    private YYStack yystack;


    /**
     * The symbol kind of the lookahead token.
     */
    public final SymbolKind getToken() {
      return yytoken;
    }

    private SymbolKind yytoken;
    static final int NTOKENS = Parser.YYNTOKENS_;

    /**
     * Put in YYARG at most YYARGN of the expected tokens given the
     * current YYCTX, and return the number of tokens stored in YYARG.  If
     * YYARG is null, return the number of expected tokens (guaranteed to
     * be less than YYNTOKENS).
     */
    int getExpectedTokens(SymbolKind yyarg[], int yyargn) {
      return getExpectedTokens (yyarg, 0, yyargn);
    }

    int getExpectedTokens(SymbolKind yyarg[], int yyoffset, int yyargn) {
      int yycount = yyoffset;
      int yyn = yypact_[this.yystack.stateAt(0)];
      if (!yyPactValueIsDefault(yyn))
        {
          /* Start YYX at -YYN if negative to avoid negative
             indexes in YYCHECK.  In other words, skip the first
             -YYN actions for this state because they are default
             actions.  */
          int yyxbegin = yyn < 0 ? -yyn : 0;
          /* Stay within bounds of both yycheck and yytname.  */
          int yychecklim = YYLAST_ - yyn + 1;
          int yyxend = yychecklim < NTOKENS ? yychecklim : NTOKENS;
          for (int yyx = yyxbegin; yyx < yyxend; ++yyx)
            if (yycheck_[yyx + yyn] == yyx && yyx != SymbolKind.S_YYerror.getCode()
                && !yyTableValueIsError(yytable_[yyx + yyn]))
              {
                if (yyarg == null)
                  yycount += 1;
                else if (yycount == yyargn)
                  return 0; // FIXME: this is incorrect.
                else
                  yyarg[yycount++] = SymbolKind.get(yyx);
              }
        }
      if (yyarg != null && yycount == yyoffset && yyoffset < yyargn)
        yyarg[yycount] = null;
      return yycount - yyoffset;
    }
  }





  /**
   * Build and emit a "syntax error" message in a user-defined way.
   *
   * @param ctx  The context of the error.
   */
  private void yyreportSyntaxError(Context yyctx) {
      yyerror("syntax error");
  }

  /**
   * Whether the given <code>yypact_</code> value indicates a defaulted state.
   * @param yyvalue   the value to check
   */
  private static boolean yyPactValueIsDefault(int yyvalue) {
    return yyvalue == yypact_ninf_;
  }

  /**
   * Whether the given <code>yytable_</code>
   * value indicates a syntax error.
   * @param yyvalue the value to check
   */
  private static boolean yyTableValueIsError(int yyvalue) {
    return yyvalue == yytable_ninf_;
  }

  private static final short yypact_ninf_ = -80;
  private static final byte yytable_ninf_ = -1;

/* YYPACT[STATE-NUM] -- Index in YYTABLE of the portion describing
   STATE-NUM.  */
  private static final short[] yypact_ = yypact_init();
  private static final short[] yypact_init()
  {
    return new short[]
    {
     201,   163,   -80,   -80,   -80,   -80,   201,   -80,   -80,   -80,
     -80,   -80,   -80,   -80,   -80,   -80,   -80,   -80,   -80,   -80,
     -80,   -80,   -80,   -80,   -80,   -80,   -80,   -80,   -80,   -80,
     -80,     9,   201,   -80,   -80,   -80,   -80,   201,   238,   238,
       7,     7,   201,   238,   238,    75,    10,   -80,   -80,   -80,
     201,   -80,   201,     7,   163,   201,   201,   201,     2,     8,
     201,    11,   -80,   -80,   -80,   201,   201,   -80,   -80,   201,
       2,   -80,   -80,   -80,   -80,   -80,   -80,   -80,   -80,   -80,
     -80,   -80,     2,   -80,   -36,   -80,   -80,   -80,   111,     2,
     201,    13,   -80,     2,     2,   -34,   -36,   -80,   -33,   -80,
       2,   -80,     2,    18,    19,   -33,   -80,   -80,   -80
    };
  }

/* YYDEFACT[STATE-NUM] -- Default reduction number in state STATE-NUM.
   Performed when YYTABLE does not specify something else to do.  Zero
   means the default is an error.  */
  private static final byte[] yydefact_ = yydefact_init();
  private static final byte[] yydefact_init()
  {
    return new byte[]
    {
       0,     0,    65,    66,    67,    41,     0,    42,    43,    44,
      45,    46,    47,    48,    49,    50,    51,    52,    53,    54,
      55,    56,    57,    58,    59,    60,    61,    62,    63,    64,
      68,     0,     2,    10,     8,     9,    15,     0,     0,     0,
       0,     0,     0,     0,     0,     4,     0,    11,     1,     3,
       4,    16,     0,     0,     0,     0,     0,     0,     0,     0,
       0,     0,    14,     5,    18,     0,     4,    21,    22,     0,
       0,    30,    31,    32,    34,    33,    35,    36,    37,    17,
      24,    25,     0,    19,     6,    13,    20,    23,    26,    26,
       0,     0,    38,     0,    26,     0,     6,    12,    28,    27,
       0,     7,     0,     0,     0,    28,    39,    40,    29
    };
  }

/* YYPGOTO[NTERM-NUM].  */
  private static final byte[] yypgoto_ = yypgoto_init();
  private static final byte[] yypgoto_init()
  {
    return new byte[]
    {
     -80,   -80,   -30,   -72,     0,   -37,   -80,   -29,   -69,   -79,
     -80,   -32,   -31,   -80
    };
  }

/* YYDEFGOTO[NTERM-NUM].  */
  private static final byte[] yydefgoto_ = yydefgoto_init();
  private static final byte[] yydefgoto_init()
  {
    return new byte[]
    {
       0,    31,    61,    91,    50,    33,    46,    94,    95,   103,
      80,    81,    34,    35
    };
  }

/* YYTABLE[YYPACT[STATE-NUM]] -- What to do in state STATE-NUM.  If
   positive, shift that token.  If negative, reduce the rule whose
   number is the opposite.  If YYTABLE_NINF, syntax error.  */
  private static final byte[] yytable_ = yytable_init();
  private static final byte[] yytable_init()
  {
    return new byte[]
    {
      32,    45,    49,    55,    56,    70,    47,    52,    53,    48,
      54,    82,    58,    59,    62,    85,    65,    97,    90,   100,
      63,   102,   106,   107,   101,    99,   108,    83,     0,    79,
       0,     0,     0,     0,     0,     0,     0,    51,     0,     0,
       0,    88,    57,    71,    72,    73,    74,    75,    76,    77,
      78,     0,    64,    89,    66,    67,    68,    69,     0,     0,
      84,     0,     0,     0,    98,    86,     0,     0,     0,    87,
       0,   104,     0,   105,     0,     0,     0,     0,     1,     0,
       2,     3,     4,     5,     0,     6,     0,     0,     0,     0,
      96,     7,     8,     9,    10,    11,    12,    13,    14,    15,
      16,    17,    18,    19,    20,    21,    22,    23,    24,    25,
      26,    27,    28,    29,    70,    92,     0,     0,     0,     0,
       0,     0,     0,     0,     0,     0,     0,    30,     0,    60,
       0,     0,     0,     0,     0,     0,     0,     0,     0,     0,
       0,     0,     0,     0,     0,     0,     0,     0,     0,     0,
       0,     0,    71,    72,    73,    74,    75,    76,    77,    78,
       0,     0,     0,     0,     0,    93,     1,    36,     2,     3,
       4,     5,    37,     6,    38,    39,    40,    41,    42,     7,
       8,     9,    10,    11,    12,    13,    14,    15,    16,    17,
      18,    19,    20,    21,    22,    23,    24,    25,    26,    27,
      28,    29,    43,    44,     1,     0,     2,     3,     4,     5,
       0,     6,     0,     0,     0,    30,     0,     7,     8,     9,
      10,    11,    12,    13,    14,    15,    16,    17,    18,    19,
      20,    21,    22,    23,    24,    25,    26,    27,    28,    29,
       0,     0,     0,     0,     0,     0,     5,     0,     0,     0,
       0,     0,     0,    30,     7,     8,     9,    10,    11,    12,
      13,    14,    15,    16,    17,    18,    19,    20,    21,    22,
      23,    24,    25,    26,    27,    28,    29
    };
  }

private static final byte[] yycheck_ = yycheck_init();
  private static final byte[] yycheck_init()
  {
    return new byte[]
    {
       0,     1,    32,    40,    41,     3,     6,    38,    39,     0,
       3,     3,    43,    44,     4,     4,    53,     4,    54,    53,
      50,    54,     4,     4,    96,    94,   105,    59,    -1,    58,
      -1,    -1,    -1,    -1,    -1,    -1,    -1,    37,    -1,    -1,
      -1,    70,    42,    41,    42,    43,    44,    45,    46,    47,
      48,    -1,    52,    82,    54,    55,    56,    57,    -1,    -1,
      60,    -1,    -1,    -1,    93,    65,    -1,    -1,    -1,    69,
      -1,   100,    -1,   102,    -1,    -1,    -1,    -1,     3,    -1,
       5,     6,     7,     8,    -1,    10,    -1,    -1,    -1,    -1,
      90,    16,    17,    18,    19,    20,    21,    22,    23,    24,
      25,    26,    27,    28,    29,    30,    31,    32,    33,    34,
      35,    36,    37,    38,     3,     4,    -1,    -1,    -1,    -1,
      -1,    -1,    -1,    -1,    -1,    -1,    -1,    52,    -1,    54,
      -1,    -1,    -1,    -1,    -1,    -1,    -1,    -1,    -1,    -1,
      -1,    -1,    -1,    -1,    -1,    -1,    -1,    -1,    -1,    -1,
      -1,    -1,    41,    42,    43,    44,    45,    46,    47,    48,
      -1,    -1,    -1,    -1,    -1,    54,     3,     4,     5,     6,
       7,     8,     9,    10,    11,    12,    13,    14,    15,    16,
      17,    18,    19,    20,    21,    22,    23,    24,    25,    26,
      27,    28,    29,    30,    31,    32,    33,    34,    35,    36,
      37,    38,    39,    40,     3,    -1,     5,     6,     7,     8,
      -1,    10,    -1,    -1,    -1,    52,    -1,    16,    17,    18,
      19,    20,    21,    22,    23,    24,    25,    26,    27,    28,
      29,    30,    31,    32,    33,    34,    35,    36,    37,    38,
      -1,    -1,    -1,    -1,    -1,    -1,     8,    -1,    -1,    -1,
      -1,    -1,    -1,    52,    16,    17,    18,    19,    20,    21,
      22,    23,    24,    25,    26,    27,    28,    29,    30,    31,
      32,    33,    34,    35,    36,    37,    38
    };
  }

/* YYSTOS[STATE-NUM] -- The symbol kind of the accessing symbol of
   state STATE-NUM.  */
  private static final byte[] yystos_ = yystos_init();
  private static final byte[] yystos_init()
  {
    return new byte[]
    {
       0,     3,     5,     6,     7,     8,    10,    16,    17,    18,
      19,    20,    21,    22,    23,    24,    25,    26,    27,    28,
      29,    30,    31,    32,    33,    34,    35,    36,    37,    38,
      52,    56,    59,    60,    67,    68,     4,     9,    11,    12,
      13,    14,    15,    39,    40,    59,    61,    59,     0,    57,
      59,    59,    67,    67,     3,    60,    60,    59,    67,    67,
      54,    57,     4,    57,    59,    60,    59,    59,    59,    59,
       3,    41,    42,    43,    44,    45,    46,    47,    48,    62,
      65,    66,     3,    66,    59,     4,    59,    59,    62,    62,
      54,    58,     4,    54,    62,    63,    59,     4,    62,    63,
      53,    58,    54,    64,    62,    62,     4,     4,    64
    };
  }

/* YYR1[RULE-NUM] -- Symbol kind of the left-hand side of rule RULE-NUM.  */
  private static final byte[] yyr1_ = yyr1_init();
  private static final byte[] yyr1_init()
  {
    return new byte[]
    {
       0,    55,    56,    56,    57,    57,    58,    58,    59,    59,
      59,    59,    59,    60,    60,    60,    61,    61,    61,    61,
      61,    61,    61,    61,    62,    62,    63,    63,    64,    64,
      65,    65,    65,    65,    65,    65,    65,    65,    65,    65,
      66,    67,    67,    67,    67,    67,    67,    67,    67,    67,
      67,    67,    67,    67,    67,    67,    67,    67,    67,    67,
      67,    67,    67,    67,    67,    68,    68,    68,    68
    };
  }

/* YYR2[RULE-NUM] -- Number of symbols on the right-hand side of rule RULE-NUM.  */
  private static final byte[] yyr2_ = yyr2_init();
  private static final byte[] yyr2_init()
  {
    return new byte[]
    {
       0,     2,     1,     2,     0,     2,     0,     3,     1,     1,
       1,     2,     6,     4,     3,     2,     2,     3,     3,     3,
       4,     3,     3,     4,     1,     1,     0,     2,     0,     3,
       1,     1,     1,     1,     1,     1,     1,     1,     3,     6,
       6,     1,     1,     1,     1,     1,     1,     1,     1,     1,
       1,     1,     1,     1,     1,     1,     1,     1,     1,     1,
       1,     1,     1,     1,     1,     1,     1,     1,     1
    };
  }




  /* YYTRANSLATE_(TOKEN-NUM) -- Symbol number corresponding to TOKEN-NUM
     as returned by yylex, with out-of-bounds checking.  */
  private static final SymbolKind yytranslate_(int t)
  {
    // Last valid token kind.
    int code_max = 309;
    if (t <= 0)
      return SymbolKind.S_YYEOF;
    else if (t <= code_max)
      return SymbolKind.get(yytranslate_table_[t]);
    else
      return SymbolKind.S_YYUNDEF;
  }
  private static final byte[] yytranslate_table_ = yytranslate_table_init();
  private static final byte[] yytranslate_table_init()
  {
    return new byte[]
    {
       0,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     1,     2,     3,     4,
       5,     6,     7,     8,     9,    10,    11,    12,    13,    14,
      15,    16,    17,    18,    19,    20,    21,    22,    23,    24,
      25,    26,    27,    28,    29,    30,    31,    32,    33,    34,
      35,    36,    37,    38,    39,    40,    41,    42,    43,    44,
      45,    46,    47,    48,    49,    50,    51,    52,    53,    54
    };
  }


  private static final int YYLAST_ = 276;
  private static final int YYEMPTY_ = -2;
  private static final int YYFINAL_ = 48;
  private static final int YYNTOKENS_ = 55;

/* Unqualified %code blocks.  */
/* "Parser.y":35  */

	static AST ast;
        public static AST makeAST(String sourceProgramPath) throws IOException {
		FileReader fileReader = new FileReader(sourceProgramPath);
		LexerAdapter lexerAdapter = new LexerAdapter(fileReader);
		Parser p = new Parser(lexerAdapter);
		p.parse();
		return ast;
	}

/* "Parser.java":1722  */

}
/* "Parser.y":213  */

