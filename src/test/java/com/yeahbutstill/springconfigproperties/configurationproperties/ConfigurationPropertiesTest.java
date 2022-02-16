package com.yeahbutstill.springconfigproperties.configurationproperties;

import com.yeahbutstill.springconfigproperties.properties.ApplicationProperties;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = ConfigurationPropertiesTest.TestApplication.class)
class ConfigurationPropertiesTest {

  @Autowired private ApplicationProperties properties;

  @Test
  void testConfigurationProperties() {
    Assertions.assertEquals("Belajar Spring Boot", properties.getName());
    Assertions.assertEquals(1, properties.getVersion());
    Assertions.assertFalse(properties.isProductionMode());
  }

  @SpringBootApplication
  @EnableConfigurationProperties({ApplicationProperties.class})
  public static class TestApplication {}
}
