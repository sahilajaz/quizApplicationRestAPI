package com.restfulquizapi.quizapplication.entity;

import jakarta.persistence.Column;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;



@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "QUESTION_TITLE")
    private String questionTitle;

    @Column(name = "OPTION1")
    private String option1;

    @Column(name = "OPTION2")
    private String option2;

    @Column(name = "OPTION3")
    private String option3;

    @Column(name = "OPTION4")
    private String option4;

    @Column(name = "RIGHT_ANSWER")
    private String rightAnswer; 

    @Column(name = "DIFFICULTY_LEVEL")
    private String difficultyLevel;

	public Integer getId() {
		return id;
	}

	public String getQuestionTitle() {
		return questionTitle;
	}

	public String getOption1() {
		return option1;
	}

	public String getOption2() {
		return option2;
	}

	public String getOption3() {
		return option3;
	}

	public String getOption4() {
		return option4;
	}

	public String getRightAnswer() {
		return rightAnswer;
	}

	public String getDifficultyLevel() {
		return difficultyLevel;
	}
    
    
}
