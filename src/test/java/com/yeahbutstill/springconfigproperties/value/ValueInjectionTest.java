package com.yeahbutstill.springconfigproperties.value;

import lombok.Getter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;

@SpringBootTest(classes = ValueInjectionTest.TestApplication.class)
class ValueInjectionTest {

  @Autowired private TestApplication.ApplicationProperties properties;

  @Autowired private TestApplication.SystemProperties systemProperties;

  @Test
  void testValue() {
    Assertions.assertEquals("Belajar Spring Boot", properties.getName());
    Assertions.assertEquals(1, properties.getVersion());
    Assertions.assertFalse(properties.isProductionMode());
  }

  @Test
  void testSystemProperties() {
    Assertions.assertEquals(
        "/home/yeahbutstill/.sdkman/candidates/java/current", systemProperties.getJavaHome());
  }

  @SpringBootApplication
  public static class TestApplication {

    @Component
    @Getter
    public static class SystemProperties {

      @Value("/home/yeahbutstill/.sdkman/candidates/java/current")
      private String javaHome;
    }

    @Component
    @Getter
    public static class ApplicationProperties {

      @Value("${spring.application.name}")
      private String name;

      @Value("${application.version}")
      private Integer version;

      @Value("${application.production-mode}")
      private boolean productionMode;
    }
  }
}
