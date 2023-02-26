package com.cydeo.stereotype_annotations.model;

import lombok.Data;
import lombok.NonNull;
import org.springframework.stereotype.Component;

@Component
@Data
public class ExtraHours {
  @NonNull
  public Integer getHours() {

    return 10;
  }
}

