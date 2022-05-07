package com.sl.cargomail.repository;

import com.sl.cargomail.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsersRepository extends JpaRepository<User, Long> {
    User findUserByUsername(String username);

    User findUserByEmail(String email);

    List<User> findUsersByRoles(String roles);
}
