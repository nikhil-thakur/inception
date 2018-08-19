package interview.repositories;

import interview.domain.Candidate;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidateRepository extends CrudRepository<Candidate, Long> {
    public Candidate findByFirstNameAndEmail(String name, String email);
}
