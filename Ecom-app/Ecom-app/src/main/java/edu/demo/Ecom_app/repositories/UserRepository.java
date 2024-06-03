package edu.demo.Ecom_app.repositories;

import edu.demo.Ecom_app.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    public User findByEmail(String email);
}
