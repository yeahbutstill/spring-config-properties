package com.yeahbutstill.springconfigproperties.messagesource;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;

import java.util.Locale;

@SpringBootTest
class MessageSourceTest {

  @Autowired private ApplicationContext applicationContext;

  private MessageSource messageSource;

  @BeforeEach
  void setUp() {
    applicationContext = new AnnotationConfigApplicationContext(TestApplication.class);
    messageSource = applicationContext.getBean(MessageSource.class);
  }

  @Test
  void testDefaultLocale() {
    String message = messageSource.getMessage("hello", new Object[] {"Dani"}, Locale.ENGLISH);
    Assertions.assertEquals("Hello Dani", message);
  }

  @Test
  void testIndonesiaLocale() {
    String message =
        messageSource.getMessage("hello", new Object[] {"Dani"}, new Locale("in", "ID"));
    Assertions.assertEquals("Halo Dani", message);
  }

  @SpringBootApplication
  public static class TestApplication {

    @Bean
    public MessageSource messageSource() {
      ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
      messageSource.setBasenames("my");
      return messageSource;
    }
  }
}
