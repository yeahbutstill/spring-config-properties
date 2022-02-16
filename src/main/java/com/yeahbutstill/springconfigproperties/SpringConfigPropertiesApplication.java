package com.yeahbutstill.springconfigproperties;

import com.yeahbutstill.springconfigproperties.converter.StringToDateConverter;
import com.yeahbutstill.springconfigproperties.properties.ApplicationProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.convert.ApplicationConversionService;
import org.springframework.context.annotation.Bean;
import org.springframework.core.convert.ConversionService;

@SpringBootApplication
@EnableConfigurationProperties({ApplicationProperties.class})
public class SpringConfigPropertiesApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringConfigPropertiesApplication.class, args);
  }

  @Bean
  public ConversionService conversionService(StringToDateConverter stringToDateConverter) {

    ApplicationConversionService conversionService = new ApplicationConversionService();
    conversionService.addConverter(stringToDateConverter);
    return conversionService;
  }
}
