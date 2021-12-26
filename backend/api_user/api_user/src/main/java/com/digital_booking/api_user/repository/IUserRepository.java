package com.digital_booking.api_user.repository;

import com.digital_booking.api_user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<User,Long> {

    @Query("FROM User u WHERE u.email = :email")
    Optional<User> findUserByEmail(@Param("email") String email);
}
