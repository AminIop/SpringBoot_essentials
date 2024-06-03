package edu.demo.Ecom_app.repositories;

import edu.demo.Ecom_app.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {

}
