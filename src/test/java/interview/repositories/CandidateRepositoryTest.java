package interview.repositories;

import interview.domain.Candidate;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CandidateRepositoryTest {

    @Autowired
    TestEntityManager testEntityManager;

    @Autowired
    CandidateRepository candidateRepository;

    @Test
    public void testPersistingCandidate() {
        Candidate build = Candidate.builder().firstName("Nikhil").lastName("Thakur").build();
        Candidate candidate = this.testEntityManager.persist(build);

        Assert.assertNotNull("The persisted object should be retrieved", candidateRepository.findById(candidate.getId()));
    }
}