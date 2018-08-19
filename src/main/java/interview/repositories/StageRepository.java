package interview.repositories;

import interview.domain.Stage;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StageRepository extends CrudRepository<Stage, Long> {
    Stage findByName(String stageName);
}
