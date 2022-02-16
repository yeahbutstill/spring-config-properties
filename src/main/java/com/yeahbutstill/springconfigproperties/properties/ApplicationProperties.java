package com.yeahbutstill.springconfigproperties.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties("application")
public class ApplicationProperties {

  private String name;
  private Integer version;
  private boolean productionMode;
}
