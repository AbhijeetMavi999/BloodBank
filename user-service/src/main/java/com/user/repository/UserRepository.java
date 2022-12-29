package com.user.repository;

import com.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User getByEmailAndPassword(String email, String password);

    List<User> getByStateAndBloodGroup(String state, String bloodGroup);

    Optional<User> findByEmail(String email);
}
