package interview.repositories;

import interview.domain.Practice;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "practice", path = "practice")
public interface PracticeRepository extends PagingAndSortingRepository<Practice, Long> {
}
