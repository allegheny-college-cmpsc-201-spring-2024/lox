package com.interpreter.lox;

<<<<<<< HEAD
import java.io.*;
import java.net.*;
import java.nio.file.*;
import java.util.Scanner;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.provider.Arguments;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BaseTests {

  private final static Main lox = new Main();

  static Stream<Arguments> testTokenOutput() throws Exception {
    URL resource = BaseTests.class.getClassLoader().getResource("tokens.lox");
=======
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
import static org.hamcrest.CoreMatchers.not;

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

  static Stream<Arguments> testNamedFunctionResolution() throws Exception {
    URL resource = BaseTests.class.getClassLoader().getResource("test.lox");
    File file = Paths.get(resource.toURI()).toFile();
    String absPath = file.getAbsolutePath();
    return Stream.of(
      Arguments.of((Object) new String[]{absPath})
    );
  }

  static Stream<Arguments> testAnonymousFunctionResolution() throws Exception {
    URL resource = BaseTests.class.getClassLoader().getResource("test.lox");
>>>>>>> 9-resolving-binding
    File file = Paths.get(resource.toURI()).toFile();
    String absPath = file.getAbsolutePath();
    return Stream.of(
      Arguments.of((Object) new String[]{absPath})
    );
  }

  @MethodSource
  @ParameterizedTest
<<<<<<< HEAD
  void testTokenOutput(String[] args) throws Exception {
    System.out.println("🖨️\tOUTPUT (mvn exec:java)\r\n");
    lox.main(args);
  }

  @Test
  void testErrorMessage() {
    assertEquals(
      "[line 0] Error: Test Error",
      lox.error(0, "Test Error")
    );
    lox.hadError = false;
=======
  void testNamedFunctionResolution(String[] args) throws Exception {
    Main.main(args);
    assertThat(
        errContent.toString().strip(),
        containsString("Error at 'c': Local variable is never used.")
    );
  }

  @MethodSource
  @ParameterizedTest
  void testAnonymousFunctionResolution(String[] args) throws Exception {
    Main.main(args);
    assertThat(
        errContent.toString().strip(),
        containsString("Error at 'l': Local variable is never used.")
    );
  }

  @AfterAll
  public void restoreStreams() {
    System.setIn(originalIn);
    System.setOut(originalOut);
    System.setErr(originalErr);
>>>>>>> 9-resolving-binding
  }

}
