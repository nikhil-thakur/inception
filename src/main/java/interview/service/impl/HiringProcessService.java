package interview.service.impl;

import interview.domain.Candidate;
import interview.domain.HiringProcessLifecycle;
import interview.repositories.CandidateRepository;
import interview.repositories.HiringProcessLifeCycleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HiringProcessService {
    @Autowired
    HiringProcessLifeCycleRepository hiringProcessRepository;

    @Autowired
    CandidateRepository candidateRepository;



    public Iterable<HiringProcessLifecycle> findAll(){
        return hiringProcessRepository.findAll();
    }

    public HiringProcessLifecycle persist(long candidateId){
        Optional<Candidate> byId = candidateRepository.findById(candidateId);
        HiringProcessLifecycle hiringProcessLifecycle = new HiringProcessLifecycle();
        if (byId.isPresent()) hiringProcessLifecycle.setCandidate(byId.get());
        return hiringProcessRepository.save(hiringProcessLifecycle);
    }
}
