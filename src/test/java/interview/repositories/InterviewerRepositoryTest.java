package interview.repositories;

import interview.domain.Interviewer;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import javax.validation.constraints.AssertTrue;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
@Transactional
public class InterviewerRepositoryTest {

    @Autowired
    TestEntityManager testEntityManager;

    @Autowired
    InterviewerRepository interviewerRepository;

    @Test
    public void findByFirstNameAndAndLastName() {
        Interviewer interviewer = Interviewer.builder().firstName("Nikhil").lastName("Thakur").build();
        Interviewer recordThatGotPersisted = testEntityManager.persist(interviewer);

        Interviewer resultFromRepository = interviewerRepository.findByFirstNameAndAndLastName("Nikhil", "Thakur");
        Assert.assertEquals("Persisted record returned an Interview object that has the id in Database populated, the retrieved object through the repository should have the same id", recordThatGotPersisted.getId(), resultFromRepository.getId());
    }
}