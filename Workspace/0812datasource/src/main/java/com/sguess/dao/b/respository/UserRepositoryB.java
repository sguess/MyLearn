package com.sguess.dao.b.respository;

import com.sguess.dao.b.entity.UserB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositoryB extends JpaRepository<UserB, Long> {
}
