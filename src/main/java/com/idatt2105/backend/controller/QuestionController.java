package com.idatt2105.backend.controller;

import com.idatt2105.backend.model.AlternativeDTO;
import com.idatt2105.backend.model.Question;
import com.idatt2105.backend.model.QuestionDTO;
import com.idatt2105.backend.service.QuestionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.NotNull;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller for handling questions.
 * This controller provides endpoints for CRUD operations on questions.
 */
@RestController
@RequestMapping("/api/question")
@Tag(name = "Questions", description = "Operations related to questions")
public class QuestionController {
  private final QuestionService questionService;

  /**
   * Constructor for the QuestionController class.
   * It initializes the questionService which will be used to perform operations on questions.
   *
   * @param questionService (QuestionService) Service for handling questions.
   */
  @Autowired
  public QuestionController(QuestionService questionService) {
    this.questionService = questionService;
  }

  /**
   * Adds a question to a quiz.
   * This endpoint accepts a QuestionDTO object and adds it to a quiz.
   *
   * @param question (QuestionDTO) The question to add.
   * @return (ResponseEntity < Question >) The added question.
   */
  @PostMapping("/add")
  @Operation(summary = "Add a question to a quiz")
  public ResponseEntity<Question> addQuestion(@RequestBody @NotNull QuestionDTO question) {
    Question q = questionService.addQuestion(question);
    return new ResponseEntity<>(q, HttpStatus.CREATED);
  }

  /**
   * Gets a question by id.
   * This endpoint returns a question with the given id.
   *
   * @param id (Long) The id of the question to get.
   * @return (ResponseEntity < Question >) The question with the given id.
   */
  @GetMapping("/get/{id}")
  @Operation(summary = "Get a question by id")
  public ResponseEntity<Question> getQuestionById(@PathVariable Long id) {
    Question q = questionService.getQuestionById(id);
    return new ResponseEntity<>(q, HttpStatus.OK);
  }

  /**
   * Deletes a question.
   * This endpoint deletes a question with the given id.
   *
   * @param id (Long) The id of the question to delete.
   * @return (ResponseEntity < Void >) Response entity with status OK.
   */
  @DeleteMapping("/delete/{id}")
  @Operation(summary = "Delete a question")
  public ResponseEntity<Void> deleteQuestion(@PathVariable Long id) {
    questionService.deleteQuestion(id);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  /**
   * Updates a question.
   * This endpoint updates a question with the given id using the provided QuestionDTO object.
   *
   * @param id       (Long) The id of the question to update.
   * @param question (QuestionDTO) The updated question.
   * @return (ResponseEntity < Question >) The updated question.
   */
  @PostMapping("/update/{id}")
  @Operation(summary = "Update a question")
  public ResponseEntity<Question> updateQuestion(@PathVariable Long id,
                                                 @RequestBody QuestionDTO question) {
    Question q = questionService.updateQuestion(id, question);
    return new ResponseEntity<>(q, HttpStatus.OK);
  }

  /**
   * Gets all questions in a quiz.
   * This endpoint returns all questions in a quiz with the given id.
   *
   * @param quizId (Long) The id of the quiz to get questions from.
   * @return (ResponseEntity < List < Question > >) List of questions in the quiz.
   */
  @GetMapping("/get/all/{quizId}")
  @Operation(summary = "Get all questions in a quiz")
  public ResponseEntity<List<Question>> getQuestionsByQuizId(@PathVariable Long quizId) {
    List<Question> questions = questionService.getQuestionsByQuizId(quizId);
    return new ResponseEntity<>(questions, HttpStatus.OK);
  }

  /**
   * Adds an alternative to a question.
   * This endpoint accepts an AlternativeDTO object and adds it as an alternative to a question.
   *
   * @param alternative (AlternativeDTO) The alternative to add.
   * @return (ResponseEntity < Void >) Response entity with status CREATED.
   */
  @PostMapping("/add/alternative")
  @Operation(summary = "Add an alternative to a question")
  public ResponseEntity<Void> addAlternative(@RequestBody @NotNull AlternativeDTO alternative) {
    questionService.addAlternative(alternative);
    return new ResponseEntity<>(HttpStatus.CREATED);
  }

  @DeleteMapping("/delete/alternative/{id}")
  @Operation(summary = "Delete an alternative")
  public ResponseEntity<Void> deleteAlternative(@PathVariable Long id) {
    questionService.deleteAlternative(id);
    return new ResponseEntity<>(HttpStatus.OK);
  }
}