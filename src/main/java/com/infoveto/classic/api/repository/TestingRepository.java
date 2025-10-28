package com.infoveto.classic.api.repository;

import com.infoveto.classic.api.entity.TestingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestingRepository extends JpaRepository<TestingEntity, Long> {

    public List<TestingEntity> findAllByUserNameIgnoreCase(String username);

    public List<TestingEntity> findAllByUserMail(String mail);

}
