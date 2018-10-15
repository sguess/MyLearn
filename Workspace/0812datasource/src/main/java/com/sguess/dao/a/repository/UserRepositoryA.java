package com.sguess.dao.a.repository;

import com.sguess.dao.a.entity.UserA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositoryA extends JpaRepository<UserA, Long> {
}
