package interview.repositories;

import interview.domain.Practice;
import org.springframework.data.repository.CrudRepository;

public interface PracticeRepository extends CrudRepository<Practice, Long> {
    /**
     * @param nameOfPratice
     * @return
     */
    Practice findByName(String nameOfPratice);
}
