package com.userservice.service.user;

import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    @Bean
    Optional<UserEntity> findByEmail(String email);

    @Bean
    UserDetails findByDisplayName(String displayName);

    @Transactional
    @Modifying
    @Query("UPDATE UserEntity user SET user.enabled = TRUE WHERE user.email = ?1")
    void enableAppUser(String email);
}
