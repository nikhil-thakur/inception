package interview.repositories;

import interview.domain.Candidate;
import interview.domain.Employee;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class EmployeeRepositoryTest {
    @Autowired
    TestEntityManager testEntityManager;

    @Autowired
    EmployeeRepository employeeRepository;

    @Test
    public void testPersistingCandidate() {
        Employee employee = Employee.builder().firstName("Nikhil").lastName("Thakur").build();
        Employee employee1 = this.testEntityManager.persist(employee);

        Assert.assertNotNull("The persisted object should be retrieved", employeeRepository.findById(employee1.getId()));
    }
}