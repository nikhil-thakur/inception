package interview.repositories;

import interview.domain.Candidate;
import interview.domain.HiringProcessStage;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface HiringProcessStageRepository extends CrudRepository<HiringProcessStage, Long> {
    List<HiringProcessStage> findByCandidate(Candidate candidate);
}
