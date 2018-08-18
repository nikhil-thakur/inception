package interview.service.impl;

import interview.domain.Interview;
import interview.domain.Practice;
import interview.repositories.InterviewRepository;
import interview.repositories.PracticeRepository;
import interview.service.InterviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InterviewServiceImpl implements InterviewService {
    @Autowired
    PracticeRepository practiceRepository;

    @Autowired
    InterviewRepository interviewRepository;

    @Override
    public Interview persistInterview(Interview interview) {
        Practice byName = practiceRepository.findByName(interview.getPractice().getName());
        if (byName == null){
            practiceRepository.save(interview.getPractice());
            return interviewRepository.save(interview);
        }
         else {
             interview.getPractice().setId(byName.getId());
             return interviewRepository.save(interview);
        }
    }
}
