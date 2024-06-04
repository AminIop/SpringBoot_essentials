package edu.demo.Ecom_app.tools.dtos.user;

import edu.demo.Ecom_app.entities.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDtoRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    //private Date dateOfBirth;
    private Address address;
}
