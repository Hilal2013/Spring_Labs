package com.cydeo.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Cinema extends BaseEntity{

    private String name;
    private String sponsoredName;

@ManyToOne(fetch=FetchType.LAZY)
private Location location;

}
