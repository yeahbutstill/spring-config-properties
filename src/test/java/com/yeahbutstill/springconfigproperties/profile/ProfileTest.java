package com.yeahbutstill.springconfigproperties.profile;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(classes = ProfileTest.TestApplication.class)
@ActiveProfiles({"production"})
class ProfileTest {

  @Autowired private TestApplication.SayHello sayHello;

  @Test
  void testProfile() {
    Assertions.assertEquals("Hello Dani from production", sayHello.say("Dani"));
  }

  @SpringBootApplication
  public static class TestApplication {

    public interface SayHello {
      String say(String name);
    }

    @Component
    @Profile({"local"})
    public static class SayHelloLocal implements SayHello {

      @Override
      public String say(String name) {
        return "Hello " + name + " from local";
      }
    }

    @Component
    @Profile({"production"})
    public static class SayProduction implements SayHello {

      @Override
      public String say(String name) {
        return "Hello " + name + " from production";
      }
    }
  }
}
