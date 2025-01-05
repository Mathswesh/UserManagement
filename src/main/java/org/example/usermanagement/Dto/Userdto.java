package org.example.usermanagement.Dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Userdto {
    private int id;
    private String fname;
    private String lname;
    private String email;
    private String password;

}
