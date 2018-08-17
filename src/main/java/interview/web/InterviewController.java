package interview.web;

import interview.domain.Interview;
import interview.repositories.InterviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/interview")
public class InterviewController {

    @Autowired
    InterviewRepository interviewRepository;

    @PostMapping
    public Interview addInterviewToSystem(@RequestBody Interview interview) {
        return interviewRepository.save(interview);
    }

    @GetMapping
    public Iterable<?> viewAllInterviews(){
        return interviewRepository.findAll();
    }
}
