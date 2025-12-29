package com.infoveto.classic.api.repository;

import com.infoveto.classic.api.entity.ArticlesFeedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticlesFeedbackRepository extends JpaRepository<ArticlesFeedback, Long> {
	void deleteByUserId_Id(String userId);
}
