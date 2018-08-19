package interview.repositories;

import interview.domain.Stage;
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
public class StageRepositoryTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private StageRepository stageRepository;

    @Test
    @Transactional
    public void findByName() {
        Stage stage = Stage.builder().name("decision").build();
        Stage persistedEntity = testEntityManager.persist(stage);
        Stage fetchedStage = stageRepository.findByName("decision");

        Assert.assertEquals("Entity persisted through test entity manager and retrieved through repository " +
                " should have the same id ", persistedEntity.getId(), fetchedStage.getId());

    }
}