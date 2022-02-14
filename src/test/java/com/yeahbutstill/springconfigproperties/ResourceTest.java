package com.yeahbutstill.springconfigproperties;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;

class ResourceTest {

  @Test
  void testResource() {
    var resource = new ClassPathResource("text/sample.txt");

    // pernyataan menegaskan kau ini tidak null
    Assertions.assertNotNull(resource);
    Assertions.assertTrue(resource.exists());
    try {
      Assertions.assertNotNull(resource.getFile());
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
