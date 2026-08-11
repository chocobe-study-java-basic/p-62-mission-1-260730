package com.github.chocobe.p62mission1260730.domain.question.repository;

import com.github.chocobe.p62mission1260730.domain.question.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface QuestionRepository extends JpaRepository<Question, Integer> {

    Optional<Question> findBySubject(String subject);

    Optional<Question> findBySubjectAndContent(String subject, String content);

    List<Question> findBySubjectLike(String subject);

}
