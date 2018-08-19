package interview.web;

import interview.domain.Candidate;
import interview.domain.HiringProcessStage;
import interview.domain.StageUpdateDTO;
import interview.service.impl.HiringProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/hiring")
public class HiringProcessController {

    @Autowired
    private HiringProcessService hiringProcessService;


    @GetMapping
    public Iterable<HiringProcessStage> getAll() {
        return hiringProcessService.findAll();
    }

    @PostMapping(value="/{id}")
    public HiringProcessStage persist(@PathVariable(value = "id") Long id){
        return hiringProcessService.persist(id);
    }

    @PostMapping(value = "/candidate")
    public Candidate persistCandidate(@RequestBody Candidate candidate){
        return hiringProcessService.persistCandidateAndInitiateInterviewStageOne(candidate);
    }

    @GetMapping(value = "/candidate/stage")
    public Iterable<HiringProcessStage> getAllStagesForACandidate(@RequestParam String firstName, @RequestParam String email){
        return hiringProcessService.getAllStages(firstName, email);
    }

    @PatchMapping
    public HiringProcessStage update(@RequestBody StageUpdateDTO updates){
        return hiringProcessService.updateInterviewStage(updates);
    }
}
