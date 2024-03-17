package com.interpreter.lox;

import java.util.List;

class LoxFunction implements LoxCallable {

  @Override
  public int arity() {
    return declaration.parameters.size();
  }

  /* KEEP
  @Override
  public String toString() {
    return "<fn " + declaration.name.lexeme + ">";
  }
  KEEP */

  // KEEP private final Stmt.Function declaration;
  private final Environment closure;

  // REMOVE
  private final String name;
  private final Expr.Function declaration;
  // REMOVE

  // LoxFunction(Stmt.Function declaration, Environment closure) {
  LoxFunction(String name, Expr.Function declaration, Environment closure) {
    // REMOVE
    this.name = name;
    // REMOVE
    this.closure = closure;
    this.declaration = declaration;
  }

  // REMOVE
  @Override
  public String toString() {
    if (name == null) return "<fn>";
    return "<fn " + name + ">";
  }
  // REMOVE

  @Override
  public Object call(Interpreter interpreter,
                     List<Object> arguments) {
    Environment environment = new Environment(closure);
    for (int i = 0; i < declaration.parameters.size(); i++) {
      environment.define(declaration.parameters.get(i).lexeme,
        arguments.get(i));
    }
    try {
      interpreter.executeBlock(declaration.body, environment);
    } catch (Return returnValue) {
      return returnValue.value;
    }

    return null;
  }

}
