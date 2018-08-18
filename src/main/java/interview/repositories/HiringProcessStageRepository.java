package interview.repositories;

import interview.domain.HiringProcessStage;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HiringProcessStageRepository extends CrudRepository<HiringProcessStage, Long> {
}
