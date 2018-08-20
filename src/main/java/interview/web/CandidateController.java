package interview.web;

import interview.domain.Candidate;
import interview.domain.HiringProcessStage;
import interview.service.impl.CandidateService;
import interview.service.impl.HiringProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController(value = "/candidate")
public class CandidateController {

    @Autowired
    private HiringProcessService hiringProcessService;

    @Autowired
    private CandidateService candidateService;

    @PostMapping
    public Candidate persistCandidate(@RequestBody Candidate candidate){
        return candidateService.persistCandidate(candidate);
    }



    @GetMapping
    public Candidate getCandidateProfile(@RequestParam String firstName, @RequestParam String email){
        return candidateService.getCandidateProfile(firstName, email);
    }

}
