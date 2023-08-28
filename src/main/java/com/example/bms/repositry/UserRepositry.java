package com.example.bms.repositry;

import com.example.bms.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepositry extends JpaRepository<User, Long> {

    @Override
    Optional<User> findById(Long aLong);
}
