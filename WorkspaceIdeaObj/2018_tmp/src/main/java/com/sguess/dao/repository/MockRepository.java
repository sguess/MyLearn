package com.sguess.dao.repository;

import com.sguess.dao.entity.MockEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MockRepository extends JpaRepository<MockEntity,Long> {
}
