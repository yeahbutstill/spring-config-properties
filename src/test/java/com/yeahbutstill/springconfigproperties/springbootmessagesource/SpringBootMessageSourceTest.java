package com.yeahbutstill.springconfigproperties.springbootmessagesource;

import lombok.Setter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.stereotype.Component;

import java.util.Locale;

@SpringBootTest(classes = SpringBootMessageSourceTest.TestApplication.class)
class SpringBootMessageSourceTest {

  @Autowired private TestApplication.SampleSource sampleSource;

  @Test
  void testHelloDani() {
    // pernyataan menegaskan kalau ini harus sama
    Assertions.assertEquals("Hello Dani", sampleSource.helloDani(Locale.ENGLISH));
    Assertions.assertEquals("Halo Dani", sampleSource.helloDani(new Locale("in", "ID")));
  }

  @SpringBootApplication
  public static class TestApplication {

    @Component
    public static class SampleSource implements MessageSourceAware {

      @Setter private MessageSource messageSource;

      public String helloDani(Locale locale) {
        return messageSource.getMessage("hello", new Object[] {"Dani"}, locale);
      }
    }
  }
}
