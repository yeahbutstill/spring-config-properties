package com.yeahbutstill.springconfigproperties.environment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;

@SpringBootTest(classes = EnvironmentTest.TestApplication.class)
class EnvironmentTest {

  @Autowired private Environment environment;

  //  @Test
  //  void testEnvironment() {
  //    String javaHome = environment.getProperty("JAVA_HOME");
  //    Assertions.assertEquals("/home/yeahbutstill/.sdkman/candidates/java/current", javaHome);
  //  }

  @SpringBootApplication
  public static class TestApplication {}
}
