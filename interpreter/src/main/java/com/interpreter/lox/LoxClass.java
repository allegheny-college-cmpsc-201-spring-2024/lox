package com.interpreter.lox;

import java.util.Map;
import java.util.List;

class LoxClass implements LoxCallable {

  final String name;
  final List<LoxClass> superclasses;
  private final Map<String, LoxFunction> methods;

  LoxClass(String name, List<LoxClass> superclasses,
           Map<String, LoxFunction> methods) {
    this.superclasses = superclasses;
    this.name = name;
    this.methods = methods;
  }

  LoxFunction findMethod(String name) {
    if (superclasses != null) {
      for (LoxClass inherited: superclasses) {
        if(inherited.findMethod(name) instanceof LoxFunction) {
          return inherited.findMethod(name);
        }
      }
    }

    if (methods.containsKey(name)) {
      return methods.get(name);
    }

    return null;
  }

  @Override
  public String toString() {
    return name;
  }

  @Override
  public int arity() {
    LoxFunction initializer = findMethod("init");
    if (initializer == null) return 0;
    return initializer.arity();
  }

  @Override
  public Object call(
    Interpreter interpreter,
    List<Object> arguments
  ){
    LoxInstance instance = new LoxInstance(this);
    LoxFunction initializer = findMethod("init");
    if (initializer != null) {
        initializer.bind(instance).call(interpreter, arguments);
    }
    return instance;
  }

}
