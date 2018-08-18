package interview.repositories;

import interview.domain.Interview;
import interview.domain.Practice;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
@Transactional
public class InterviewRepositoryTest {

    @Autowired
    TestEntityManager testEntityManager;

    @Autowired
    InterviewRepository interviewRepository;

    @Test
    public void testDifferentSaveScenarios() throws Exception{
        Interview interview = new Interview();
        Practice practice = new Practice();
        practice.setName("Java");
        interview.setPractice(practice);
        Interview interview1 = interviewRepository.save(interview);
        Long practiceIDSaved = interview1.getPractice().getId();

        practice.setId(practiceIDSaved);
        interview.setPractice(practice);

        Assert.assertEquals("A new record for practice should not be created", practiceIDSaved, interviewRepository.save(interview).getPractice().getId());

        Long id = 20l;
        practice.setId(id);
        interview.setPractice(practice);
        Assert.assertEquals("A new record for practice should not be created with 20 as id", id, interviewRepository.save(interview).getPractice().getId());
    }


}