package com.autoparts.parts.repository;

import com.autoparts.parts.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    boolean existsById(Long id);
    boolean existsByEmail(String email);
}
