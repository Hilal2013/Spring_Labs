package com.cydeo.stereotype_annotations.model;

import lombok.Data;
import lombok.NonNull;
import org.springframework.stereotype.Component;

@Component

public class ExtraHours {
  public Integer getHours() {

    return 10;
  }
}

