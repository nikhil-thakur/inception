package interview.service.impl;

import interview.domain.*;
import interview.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class HiringProcessService {

    @Autowired
    private HiringProcessStageRepository hiringProcessStageRepository;

    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private StageRepository stageRepository;

    /**
     * This will initiate a new interview stage. Example Hr Call, Remote peer programing etc
     * @param stageName name of the stage that is needed to be initiated
     * @param candidate Candidate whose interview stage needs to be initiated
     * @return record of the hiring process stage that gets created
     */
    public HiringProcessStage initiateInterviewStage(String stageName, Candidate candidate) {
        HiringProcessStage hiringProcessStage = new HiringProcessStage();

        hiringProcessStage.setCandidate(candidate);
        Stage stage = stageRepository.findByName(stageName);
        hiringProcessStage.setStage(stage);

        return hiringProcessStageRepository.save(hiringProcessStage);
    }

    /**
     * This will initiate a new interview stage. Example Hr Call, Remote peer programing etc. Will find the candidate
     * for the given credentials and then call the method initiateInterviewStage(String stageName, Candidate candidate)
     * @param stageName name of the stage that is needed to be initiated
     * @param firstName Candidate's first name
     * @param email Candidate's email
     * @return record of the hiring process stage that gets created
     */
    public HiringProcessStage initiateInterviewStage(String stageName, String firstName, String email) {
        return initiateInterviewStage(stageName, candidateRepository.findByFirstNameAndEmail(firstName, email));
    }


    /**
     * This method will update a hiring stage record. Only Employee details and stage completeness can be updated
     * @param updates updates for the record
     * @return Hiring Process stage after the update is done
     */
    public HiringProcessStage updateInterviewStage(StageUpdateDTO updates) {
        HiringProcessStage hiringProcessStage = new HiringProcessStage();
        Optional<HiringProcessStage> hiringProcessStageRepositoryById = hiringProcessStageRepository.findById(updates.getHiringProcessStageId());

        if (hiringProcessStageRepositoryById.isPresent()) {
           hiringProcessStage  = hiringProcessStageRepositoryById.get();
            hiringProcessStage.setComplete(updates.isComplete());
            hiringProcessStage.setEmployee(employeeRepository.findById(updates.getEmployeeId()).get());
            hiringProcessStageRepository.save(hiringProcessStage);
        }
        return hiringProcessStage;
    }

    /**
     * Fetch all the interviews conducted for a Candidate. Taking the first name and email, makes the candidate unique
     * @param firstName firstNameOfTheCandidate
     * @param email email address of the candidate
     * @return List of all the interviews conducted for a candidate
     */
    public Iterable<HiringProcessStage> getAllStages(String firstName, String email) {
        Candidate byFirstNameAndEmail = candidateRepository.findByFirstNameAndEmail(firstName, email);
        List<HiringProcessStage> byCandidate = hiringProcessStageRepository.findByCandidate(byFirstNameAndEmail);
        return byCandidate;
    }
}
