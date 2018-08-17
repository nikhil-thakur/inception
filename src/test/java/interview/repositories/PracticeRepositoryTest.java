package interview.repositories;

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
public class PracticeRepositoryTest {

    @Autowired
    TestEntityManager testEntityManager;

    @Autowired
    PracticeRepository practiceRepository;

    @Test
    public void findByName() {
        Practice practice = new Practice();
        practice.setName("Java");
        this.testEntityManager.persist(practice);

        Practice byName = this.practiceRepository.findByName("Java");
        Assert.assertTrue("Record that was stored in the database earlier should be found", byName.getName().equals("Java"));

        Assert.assertNull("When no record is found, a null should be returned back",this.practiceRepository.findByName("JavaScript"));


    }
}