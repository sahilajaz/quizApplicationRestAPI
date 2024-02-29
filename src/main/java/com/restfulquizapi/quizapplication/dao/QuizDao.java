package com.restfulquizapi.quizapplication.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.restfulquizapi.quizapplication.entity.Quiz;

@Component
public interface QuizDao extends JpaRepository<Quiz , Integer> {

}
