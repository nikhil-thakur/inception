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
    public static final String STAGE_ONE_NAME = "HR Call";
    @Autowired
    private HiringProcessStageRepository hiringProcessStageRepository;

    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private StageDetailsRepository stageDetailsRepository;

    @Autowired
    private StageRepository stageRepository;

    public Iterable<HiringProcessStage> findAll(){
        return hiringProcessStageRepository.findAll();
    }

    public HiringProcessStage persist(long candidateId){
        Optional<Candidate> candidate = candidateRepository.findById(candidateId);
        Optional<Employee> employee = employeeRepository.findById(1l);
        Optional<Stage> stage = stageRepository.findById(1005l);

        StageDetail stageDetails = StageDetail.builder().notes("asjbadkjbskdbaskjbd").build();

        HiringProcessStage hiringProcessLifecycle = new HiringProcessStage();

        if (candidate.isPresent()) hiringProcessLifecycle.setCandidate(candidate.get());
        if (employee.isPresent()) hiringProcessLifecycle.setEmployee(employee.get());
        if (stage.isPresent()) hiringProcessLifecycle.setStage(stage.get());

        return hiringProcessStageRepository.save(hiringProcessLifecycle);
    }

    public Candidate persistCandidateAndInitiateInterviewStageOne(Candidate candidate){
        Candidate savedCandidate = candidateRepository.save(candidate);
        initiateAndCompleteInterviewStageOne(savedCandidate);

        return savedCandidate;
    }

    private void initiateAndCompleteInterviewStageOne(Candidate candidate) {
        HiringProcessStage hiringProcessStage = new HiringProcessStage();
        hiringProcessStage.setCandidate(candidate);

        Stage stage = stageRepository.findByName(STAGE_ONE_NAME);
        hiringProcessStage.setStage(stage);

        hiringProcessStage.setComplete(true);

        hiringProcessStageRepository.save(hiringProcessStage);
    }


    /**
     * This method will update a hiring stage record.
     * @param updates
     * @return
     */
    public HiringProcessStage updateInterviewStage(StageUpdateDTO updates) {
        Employee employee = new Employee();
        if(updates.getEmployeeId()!=null){
            Optional<Employee>  optionalEmployee =  employeeRepository.findById(updates.getEmployeeId());
            employee = optionalEmployee.get();
        }

        HiringProcessStage hiringProcessStage = new HiringProcessStage();
        Optional<HiringProcessStage> hiringProcessStageRepositoryById = hiringProcessStageRepository.findById(updates.getHiringProcessStageId());

        // if optinalEmployee is empty and

        if (hiringProcessStageRepositoryById.isPresent()) {
           hiringProcessStage  = hiringProcessStageRepositoryById.get();
            hiringProcessStage.setComplete(updates.isComplete());
            hiringProcessStage.setEmployee(employee);
            hiringProcessStageRepository.save(hiringProcessStage);
        }
        return hiringProcessStage;
    }

    public Iterable<HiringProcessStage> getAllStages(String candidateName, String email) {
        Candidate byFirstNameAndEmail = candidateRepository.findByFirstNameAndEmail(candidateName, email);
        List<HiringProcessStage> byCandidate = hiringProcessStageRepository.findByCandidate(byFirstNameAndEmail);
        return byCandidate;
    }
}
