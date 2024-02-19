package com.interpreter.lox;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.containsString;

class BaseTests {

  /*
    Word to the accepted answer at SO, they're a real one.
    https://stackoverflow.com/questions/1119385/junit-test-for-system-out-println
  */

  private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
  private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

  private final PrintStream originalOut = System.out;
  private final PrintStream originalErr = System.err;
  private final InputStream originalIn = System.in;

  @BeforeAll
  public void setUpStreams() {
    System.setOut(new PrintStream(outContent));
    System.setErr(new PrintStream(errContent));
  }

  static Stream<Arguments> testRequireVarInit() throws Exception {
    URL resource = BaseTests.class.getClassLoader().getResource("test.lox");
    File file = Paths.get(resource.toURI()).toFile();
    String absPath = file.getAbsolutePath();
    return Stream.of(
      Arguments.of((Object) new String[]{absPath})
    );
  }

  static Stream<Arguments> testREPLMode() throws Exception {
    return Stream.of(
        Arguments.of((Object) new String[]{})
    );
  }

  @MethodSource
  @ParameterizedTest
  void testRequireVarInit(String[] args) throws Exception {
    assertThrows(
        java.io.IOException.class,
        () -> {Main.main(args);}
    );
  }

  @MethodSource
  @ParameterizedTest
  void testREPLMode(String[] args) throws Exception {
    ByteArrayInputStream in = new ByteArrayInputStream("4 + 2;\n".getBytes());
    System.setIn(in);
    Main.main(args);
    assertEquals(
        outContent.toString().strip(),
        "= 6"
    );
  }

  @AfterAll
  public void restoreStreams() {
    System.setIn(originalIn);
    System.setOut(originalOut);
    System.setErr(originalErr);
  }

}
