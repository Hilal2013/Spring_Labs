package com.cydeo.stereotype_annotations.model;


import lombok.Data;
import lombok.NonNull;
import org.springframework.stereotype.Component;

@Component
//@AllArgsConstructor
@Data
public class DataStructure {
    @NonNull
private  ExtraHours extraHours;//if you use @Data or put final
    public void getTotalHours(){

        System.out.println("Total hours: " +(20+ extraHours.getHours()) );
    }

}
