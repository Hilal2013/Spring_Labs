package com.cydeo.dto;

import com.cydeo.enums.Status;
import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ParentDTO {
    @JsonIgnore
    private Long id;

    private String firstName;
    private String lastName;
    private String profession;
    private String phoneNumber;

    private String email;
    private String username;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    private LocalDate birthday;

    private Status status;
    @JsonManagedReference
    private AddressDTO address;

}
