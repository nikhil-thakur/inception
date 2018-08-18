package interview.repositories;

import interview.domain.StageDetails;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StageDetailsRepository extends CrudRepository<StageDetails, Long> {
}
