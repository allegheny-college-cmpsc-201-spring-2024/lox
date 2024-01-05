package com.interpreter.lox;

import java.util.List;

class ASTPrinter implements Expr.Visitor<String>,
                            Stmt.Visitor<String> {

  String print(Expr expr) {
    return expr.accept(this);
  }

  @Override
  public String visitBinaryExpr(Expr.Binary expr) {
    return parenthesize(expr.operator.lexeme,
                        expr.left, expr.right);
  }

  @Override
  public String visitAssignExpr(Expr.Assign expr) {
    return astParenthesize("=", expr.name.lexeme, expr.value);
  }

  @Override
  public String visitGroupingExpr(Expr.Grouping expr) {
    return parenthesize("group", expr.expression);
  }

  @Override
  public String visitLiteralExpr(Expr.Literal expr) {
    if (expr.value == null) return "nil";
    return expr.value.toString();
  }

  @Override
  public String visitUnaryExpr(Expr.Unary expr) {
    return parenthesize(expr.operator.lexeme, expr.right);
  }

  @Override
  public String visitVariableExpr(Expr.Variable expr) {
    return expr.name.lexeme;
  }

  @Override
  public String visitVarStmt(Stmt.Var stmt) {
    if (stmt.initializer == null) {
      return astParenthesize("var", stmt.name);
    }

    return astParenthesize("var", stmt.name, "=", stmt.initializer);
  }

  @Override
  public String visitPrintStmt(Stmt.Print stmt) {
    return parenthesize("print", stmt.expression);
  }

  @Override
  public String visitExpressionStmt(Stmt.Expression stmt) {
    return parenthesize(";", stmt.expression);
  }

  @Override
  public String visitBlockStmt(Stmt.Block stmt) {
    StringBuilder builder = new StringBuilder();
    builder.append("(block ");

    for (Stmt statement : stmt.statements) {
      builder.append(statement.accept(this));
    }

    builder.append(")");
    return builder.toString();
  }

  @Override
  public String visitLogicalExpr(Expr.Logical expr) {
    return parenthesize(expr.operator.lexeme, expr.right, expr.left);
  }

  @Override
  public String visitIfStmt(Stmt.If stmt) {
    if (stmt.elseBranch == null) {
      return astParenthesize("if", stmt.condition, stmt.thenBranch);
    }
    return astParenthesize("if-else", stmt.condition, stmt.thenBranch,
                           stmt.elseBranch);
  }

  @Override
  public String visitWhileStmt(Stmt.While stmt) {
    return astParenthesize("while", stmt.condition, stmt.body);
  }

  private String parenthesize(String name, Expr... exprs) {
    StringBuilder builder = new StringBuilder();

    builder.append("(").append(name);
    for (Expr expr : exprs) {
      builder.append(" ");
      builder.append(expr.accept(this));
    }
    builder.append(")");

    return builder.toString();
  }

  private String astParenthesize(String name, Object... parts) {
    StringBuilder builder = new StringBuilder();
    builder.append("(").append(name);
    transform(builder, parts);
    return builder.toString();
  }

  private void transform(StringBuilder builder, Object... parts) {
    for (Object part : parts) {
      builder.append(" ");
      if (part instanceof Expr) {
        builder.append(((Expr)part).accept(this));
      } else if (part instanceof Stmt) {
        builder.append(((Stmt)part).accept(this));
      } else if (part instanceof Token) {
        builder.append(((Token) part).lexeme);
      } else if (part instanceof List) {
        transform(builder, ((List) part).toArray());
      } else {
        builder.append(part);
      }
    }
  }

  public static void main(String[] args) {
    Expr expression = new Expr.Binary(
        new Expr.Unary(
            new Token(TokenType.MINUS, "-", null, 1),
            new Expr.Literal(123)),
        new Token(TokenType.STAR, "*", null, 1),
        new Expr.Grouping(
            new Expr.Literal(45.67)));
    System.out.println(new ASTPrinter().print(expression));
  }

}
