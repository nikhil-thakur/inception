package interview.repositories;

import interview.domain.Candidate;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
interface CandidateRepository extends CrudRepository<Candidate, Long> {
}
