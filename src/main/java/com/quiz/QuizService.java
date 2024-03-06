package com.quiz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class QuizService 
{
	@Autowired
	QuizDao quizDao;
	@Autowired
	QuestionDao questionDao;

	public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
		List<Question> question = questionDao.findRandomQuestionByCategory(category,numQ);
				
		Quiz quiz= new Quiz();
		quiz.setTitle(title);
		quiz.setQuestions(question);
		quizDao.save(quiz);
		return new ResponseEntity<>("Success",HttpStatus.CREATED);
	}
}
