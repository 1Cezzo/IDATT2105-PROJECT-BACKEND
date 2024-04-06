package com.idatt2105.backend.dto;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import com.idatt2105.backend.enumerator.QuestionType;
import com.idatt2105.backend.model.MultipleChoiceQuestion;
import com.idatt2105.backend.model.Tag;
import com.idatt2105.backend.model.TrueOrFalseQuestion;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertTrue;

/** The QuestionDTOTests class is a test class that tests the QuestionDTO class. */
class QuestionDTOTests {
  private List<Tag> tags;

  // Do we need??
  @BeforeEach
  void setUp() {
    tags = new ArrayList<>();
    Tag tag1 = new Tag();
    Tag tag2 = new Tag();
    tag1.setId(1L);
    tag2.setId(2L);
    tags.add(tag1);
    tags.add(null);
    tags.add(tag2);
  }

  /** The Getters class is a test class that tests the getters of the QuestionDTO class. */
  @Nested
  class Getters {
    private QuestionDTO question;

    @BeforeEach
    void setUp() {
      question = new QuestionDTO();
      question.setQuizId(1L);
      question.setQuestionText("Test question");
      question.setType(QuestionType.MULTIPLE_CHOICE);
      question.setQuestionId(2L);
      question.setMediaUrl("test.com");
      question.isCorrect(true);
    }

    /**
     * This method tests the getQuizId method of the QuestionDTO class. It verifies that the method
     * returns the correct quiz id.
     */
    @Test
    void getQuizIdReturnsQuizId() {
      assertEquals(1L, question.getQuizId());
    }

    /**
     * This method tests the getQuestionText method of the QuestionDTO class. It verifies that the
     * method returns the correct question text.
     */
    @Test
    void getQuestionTextReturnsQuestionText() {
      assertEquals("Test question", question.getQuestionText());
    }

    /**
     * This method tests the getType method of the QuestionDTO class. It verifies that the method
     * returns the correct type.
     */
    @Test
    void getTypeReturnsType() {
      assertEquals(QuestionType.MULTIPLE_CHOICE, question.getType());
    }

    /**
     * This method tests the getQuestionId method of the QuestionDTO class. It verifies that the
     * method returns the correct question id.
     */
    @Test
    void getQuestionIdReturnsQuestionId() {
      assertEquals(2L, question.getQuestionId());
    }

    /**
     * This method tests the getMediaUrl method of the QuestionDTO class. It verifies that the
     * method returns the correct media url.
     */
    @Test
    void getMediaUrlReturnsMediaUrl() {
      assertEquals("test.com", question.getMediaUrl());
    }

    /**
     * This method tests the isCorrect method of the QuestionDTO class. It verifies that the method
     * returns the correct boolean value.
     */
    @Test
    void isCorrectReturnsCorrect() {
      assertTrue(question.isCorrect());
    }

    /**
     * This method tests the instantiateQuestion method of the QuestionDTO class with a TrueOrFalse
     * question. It verifies that the method returns the correct question type.
     */
    @Test
    void instantiateQuestionReturnsTrueOrFalseQuestion() {
      QuestionDTO questionDTO = new QuestionDTO();
      questionDTO.setType(QuestionType.TRUE_OR_FALSE);
      assertInstanceOf(TrueOrFalseQuestion.class, questionDTO.instantiateQuestion());
    }

    /**
     * This method tests the instantiateQuestion method of the QuestionDTO class when the type is
     * multiple choice. It verifies that the method returns the correct question type.
     */
    @Test
    void instantiateQuestionReturnsMultipleChoiceQuestion() {
      QuestionDTO questionDTO = new QuestionDTO();
      questionDTO.setType(QuestionType.MULTIPLE_CHOICE);
      assertInstanceOf(MultipleChoiceQuestion.class, questionDTO.instantiateQuestion());
    }
  }

  /** The Setters class is a test class that tests the setters of the QuestionDTO class. */
  @Nested
  class Setters {
    private QuestionDTO question;

    @BeforeEach
    void setUp() {
      question = new QuestionDTO();
    }

    /**
     * This method tests the setQuizId method of the QuestionDTO class. It verifies that the method
     * sets the correct quiz id.
     */
    @Test
    void setQuizIdSetsQuizId() {
      question.setQuizId(1L);
      assertEquals(1L, question.getQuizId());
    }

    /**
     * This method tests the setQuestionText method of the QuestionDTO class. It verifies that the
     * method sets the correct question text.
     */
    @Test
    void setQuestionTextSetsQuestionText() {
      question.setQuestionText("Test question");
      assertEquals("Test question", question.getQuestionText());
    }

    /**
     * This method tests the setType method of the QuestionDTO class. It verifies that the method
     * sets the correct type.
     */
    @Test
    void setTypeSetsType() {
      question.setType(QuestionType.MULTIPLE_CHOICE);
      assertEquals(QuestionType.MULTIPLE_CHOICE, question.getType());
    }

    /**
     * This method tests the setQuestionId method of the QuestionDTO class. It verifies that the
     * method sets the correct question id.
     */
    @Test
    void setQuestionIdSetsQuestionId() {
      question.setQuestionId(2L);
      assertEquals(2L, question.getQuestionId());
    }

    /**
     * This method tests the setMediaUrl method of the QuestionDTO class. It verifies that the
     * method sets the correct media url.
     */
    @Test
    void setMediaUrlSetsMediaUrl() {
      question.setMediaUrl("test.com");
      assertEquals("test.com", question.getMediaUrl());
    }

    /**
     * This method tests the isCorrect method of the QuestionDTO class. It verifies that the method
     * sets the correct boolean value.
     */
    @Test
    void setCorrectSetsCorrect() {
      question.isCorrect(true);
      assertTrue(question.isCorrect());
    }
  }
}
