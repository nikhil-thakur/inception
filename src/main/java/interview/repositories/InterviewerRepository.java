package interview.repositories;

import interview.domain.Interviewer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterviewerRepository extends CrudRepository<Interviewer, Long> {
    Interviewer findByFirstNameAndAndLastName(String firstName, String lastName);
}
