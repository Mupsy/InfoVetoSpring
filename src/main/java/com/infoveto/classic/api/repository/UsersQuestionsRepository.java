package com.infoveto.classic.api.repository;

import com.infoveto.classic.api.entity.UsersQuestions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersQuestionsRepository extends JpaRepository<UsersQuestions, Long> {

}
