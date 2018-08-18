package interview.service.impl;

import interview.domain.Interview;
import interview.domain.Interviewer;
import interview.domain.Practice;
import interview.repositories.InterviewRepository;
import interview.repositories.InterviewerRepository;
import interview.repositories.PracticeRepository;
import interview.service.InterviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InterviewServiceImpl implements InterviewService {
    @Autowired
    PracticeRepository practiceRepository;

    @Autowired
    InterviewerRepository interviewerRepository;

    @Autowired
    InterviewRepository interviewRepository;

    @Override
    public Interview persistInterview(Interview interview) {
        Practice practice = practiceRepository.findByName(interview.getPractice().getName());

        Interviewer interviewer = interview.getInterviewer();
        Interviewer interviewerCheck = interviewerRepository.findByFirstNameAndAndLastName(interviewer.getFirstName(), interviewer.getLastName());


        if (practice == null) practiceRepository.save(interview.getPractice());
        else interview.getPractice().setId(practice.getId());

        if (interviewerCheck == null) interviewerRepository.save(interview.getInterviewer());
        else interview.getInterviewer().setId(interviewerCheck.getId());

        return interviewRepository.save(interview);

    }
}
