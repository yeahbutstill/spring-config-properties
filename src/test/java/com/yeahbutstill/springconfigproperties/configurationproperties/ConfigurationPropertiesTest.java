package com.yeahbutstill.springconfigproperties.configurationproperties;

import com.yeahbutstill.springconfigproperties.properties.ApplicationProperties;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

@SpringBootTest(classes = ConfigurationPropertiesTest.TestApplication.class)
class ConfigurationPropertiesTest {

  @Autowired private ApplicationProperties properties;

  @Test
  void testConfigurationProperties() {
    Assertions.assertEquals("Belajar Spring Boot", properties.getName());
    Assertions.assertEquals(1, properties.getVersion());
    Assertions.assertFalse(properties.isProductionMode());
  }

  @Test
  void testDatabaseProperties() {
    Assertions.assertEquals("dani", properties.getDatabaseProperties().getUsername());
    Assertions.assertEquals("rahasia", properties.getDatabaseProperties().getPassword());
    Assertions.assertEquals("belajar", properties.getDatabaseProperties().getDatabase());
    Assertions.assertEquals("jdbc:belajar", properties.getDatabaseProperties().getUrl());
  }

  @Test
  void testCollectionProperties() {
    Assertions.assertEquals(
        Arrays.asList("products", "customers", "categories"),
        properties.getDatabaseProperties().getWhitelistTable());
    Assertions.assertEquals(
        100, properties.getDatabaseProperties().getMaxTablesSize().get("products"));
    Assertions.assertEquals(
        100, properties.getDatabaseProperties().getMaxTablesSize().get("customers"));
    Assertions.assertEquals(
        100, properties.getDatabaseProperties().getMaxTablesSize().get("categories"));
  }

  @Test
  void testEmbeddedCollection() {
    Assertions.assertEquals("default", properties.getDefaultRoles().get(0).getId());
    Assertions.assertEquals("Default Role", properties.getDefaultRoles().get(0).getName());
    Assertions.assertEquals("guest", properties.getDefaultRoles().get(1).getId());
    Assertions.assertEquals("Guest Role", properties.getDefaultRoles().get(1).getName());
    Assertions.assertEquals("admin", properties.getRoles().get("admin").getId());
    Assertions.assertEquals("Admin Role", properties.getRoles().get("admin").getName());
    Assertions.assertEquals("finance", properties.getRoles().get("finance").getId());
    Assertions.assertEquals("Finance Role", properties.getRoles().get("finance").getName());
  }

  @SpringBootApplication
  @EnableConfigurationProperties({ApplicationProperties.class})
  public static class TestApplication {}
}
