package com.restfulquizapi.quizapplication.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.restfulquizapi.quizapplication.entity.Question;

@Repository
@Component
public interface QuestionDao extends JpaRepository<Question , Integer>{
	
	public List<Question> findByDifficultyLevelIgnoreCase(String difficultyLevel); 
	
}
