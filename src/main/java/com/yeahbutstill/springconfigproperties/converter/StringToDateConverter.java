package com.yeahbutstill.springconfigproperties.converter;

import lombok.SneakyThrows;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class StringToDateConverter implements Converter<String, Date> {

  private final SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

  @SneakyThrows
  @Override
  public Date convert(String source) {
    return dateFormat.parse(source);
  }

  @Override
  public <U> Converter<String, U> andThen(Converter<? super Date, ? extends U> after) {
    return Converter.super.andThen(after);
  }
}
