package edu.demo.Ecom_app.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Address {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String street;
    private String city;
    private String country;
    /*@OneToOne
    private User user;*/
}
