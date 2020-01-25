package com.casestudy.ecart.Repository;

import com.casestudy.ecart.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
   // Users save(Users user);
    Users findByUid(Long id);
    Optional<Users> findByUsername(String username);
}
