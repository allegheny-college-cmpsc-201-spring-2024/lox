package com.interpreter.lox;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;
import java.net.URL;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BaseTests {

  /*
    Word to the accepted answer at SO, they're a real one.
    https://stackoverflow.com/questions/1119385/junit-test-for-system-out-println
  */

  private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
  private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

  private final PrintStream originalOut = System.out;
  private final PrintStream originalErr = System.err;

  @BeforeAll
  public void setUpStreams() {
    System.setOut(new PrintStream(outContent));
    System.setErr(new PrintStream(errContent));
  }

  static Stream<Arguments> testProgramOutput() throws Exception {
    URL resource = BaseTests.class.getClassLoader().getResource("test.lox");
    File file = Paths.get(resource.toURI()).toFile();
    String absPath = file.getAbsolutePath();
    return Stream.of(
      Arguments.of((Object) new String[]{absPath})
    );
  }

  @MethodSource
  @ParameterizedTest
  void testProgramOutput(String[] args) throws Exception {
    Main.main(args);
    assertEquals(
      "1 2 + 4 3 - *",
      outContent.toString().strip()
    );
  }

  @AfterAll
  public void restoreStreams() {
    System.setOut(originalOut);
    System.setErr(originalErr);
  }

}
