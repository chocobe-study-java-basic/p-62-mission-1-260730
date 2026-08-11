package com.github.chocobe.p62mission1260730;

import com.github.chocobe.p62mission1260730.domain.answer.entity.Answer;
import com.github.chocobe.p62mission1260730.domain.answer.repository.AnswerRepository;
import com.github.chocobe.p62mission1260730.domain.question.entity.Question;
import com.github.chocobe.p62mission1260730.domain.question.repository.QuestionRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@ActiveProfiles(profiles = "dev")
class P62Mission1260730ApplicationTests {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private AnswerRepository answerRepository;

    @Test
    @Transactional
    void testJpa() {
        Optional<Question> oq = this.questionRepository.findById(2);
        assertTrue(oq.isPresent());
        Question q = oq.get();

        List<Answer> answerList = q.getAnswerList();
        assertEquals("네 자동으로 생성됩니다.", answerList.getFirst().getContent());
    }

}
