package interview.web;

import interview.domain.Candidate;
import interview.domain.HiringProcessStage;
import interview.domain.StageInitiateDTO;
import interview.domain.StageUpdateDTO;
import interview.service.impl.HiringProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/interview")
public class HiringProcessController {

    @Autowired
    private HiringProcessService hiringProcessService;

    @GetMapping
    public Iterable<HiringProcessStage> getAllStagesForACandidate(@RequestParam String firstName, @RequestParam String email){
        return hiringProcessService.getAllStages(firstName, email);
    }

    @PatchMapping
    public HiringProcessStage update(@RequestBody StageUpdateDTO updates){
        return hiringProcessService.updateInterviewStage(updates);
    }

    @PostMapping
    public HiringProcessStage initiateInterviewStage(@RequestBody StageInitiateDTO stageInitiateDTO){
        return hiringProcessService.initiateInterviewStage(stageInitiateDTO.interviewStage, stageInitiateDTO.firstName, stageInitiateDTO.email);
    }
}
