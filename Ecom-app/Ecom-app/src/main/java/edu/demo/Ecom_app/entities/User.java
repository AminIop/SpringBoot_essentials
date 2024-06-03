package edu.demo.Ecom_app.entities;



import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "\"user\"")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Date dateOfBirth;
    @OneToOne
    private Address address;

}
