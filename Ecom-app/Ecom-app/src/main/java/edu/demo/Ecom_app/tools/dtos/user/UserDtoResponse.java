package edu.demo.Ecom_app.tools.dtos.user;

import edu.demo.Ecom_app.entities.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatusCode;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDtoResponse {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
   // private Date dateOfBirth;
    private Address address;
}
