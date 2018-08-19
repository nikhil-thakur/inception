package interview.repositories;

import interview.domain.Candidate;
import interview.domain.HiringProcessStage;
import interview.domain.Stage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
@Transactional
public class HiringProcessStageRepositoryTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private  HiringProcessStageRepository  hiringProcessStageRepository;

    @Test
    public void findByCandidate() {
        Candidate candidate = Candidate.builder().firstName("firstName").lastName("lastName").additionalDetails("Can have anything here").phone("999999999").build();
        Candidate persistedCandidate = testEntityManager.persist(candidate);
        Stage sampleStage = Stage.builder().name("sampleStage").build();
        Stage persistedStage = testEntityManager.persist(sampleStage);
        HiringProcessStage build = HiringProcessStage.builder().candidate(persistedCandidate).stage(persistedStage).build();
        HiringProcessStage persistedHiringProcessStage = testEntityManager.persist(build);

        List<HiringProcessStage> byCandidate = hiringProcessStageRepository.findByCandidate(candidate);
        assertEquals("Size of the list should be one because only one stage has been entered for the candidate", byCandidate.size(), 1);
        assertEquals("The id of the retrieved entity should be the same as the id of the id that was persisted through test" +
                "entity manager", build.getId(), persistedHiringProcessStage.getId());
    }
}