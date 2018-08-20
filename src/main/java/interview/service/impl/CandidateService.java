package interview.service.impl;

import interview.domain.Candidate;
import interview.repositories.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CandidateService {
    public static final String STAGE_ONE_NAME = "HR Call";

    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    private HiringProcessService hiringProcessService;


    /**
     * Retrieve a candidate's psi info from the system
     * @param firstName first name of the candidate the the profile needs to be fetched for
     * @param email email of the candidate
     * @return profile of the candidate
     */
    public Candidate getCandidateProfile(String firstName, String email) {
       return candidateRepository.findByFirstNameAndEmail(firstName, email);
    }

    /**
     * Persist a candidate, and at the same time initiate the first interview stage for HR call
     * @param candidate candidate that needs to be added to the system
     * @return the candidate that is added to the system
     */
    public Candidate persistCandidate(Candidate candidate) {
        Candidate savedCandidate = candidateRepository.save(candidate);
        hiringProcessService.initiateInterviewStage(STAGE_ONE_NAME, savedCandidate);

        return savedCandidate;
    }
}
