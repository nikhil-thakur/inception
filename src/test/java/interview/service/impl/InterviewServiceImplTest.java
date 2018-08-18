package interview.service.impl;

import interview.domain.Interview;
import interview.domain.Interviewer;
import interview.domain.Practice;
import interview.repositories.InterviewRepository;
import interview.repositories.PracticeRepository;
import interview.service.InterviewService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.MockBeans;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.constraints.AssertTrue;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;

@RunWith(SpringRunner.class)
public class InterviewServiceImplTest {

    @TestConfiguration
    static class InterviewServiceImplTestConfig {

        @Bean
        public InterviewService interviewService() {
            return new InterviewServiceImpl();
        }
    }

    @Autowired
    InterviewService interviewService;

    @MockBean
    InterviewRepository interviewRepository;

    @MockBean
    PracticeRepository practiceRepository;


    @Test
    public void testPersistInterview() throws Exception {
        Practice practice = new Practice();
        practice.setName("Java");


        Interview interview = new Interview();
        interview.setInterviewee("Nikhil");
        interview.setInterviewer(Interviewer.builder().firstName("John").lastName("Smith").build());
        interview.setPractice(practice);
        interview.setStatus("Pass");

        practice.setId(1l);


        Mockito.when(interviewRepository.save(any(Interview.class))).thenReturn(interview);
        Mockito.when(practiceRepository.findByName(anyString())).thenReturn(practice);
        interviewService.persistInterview(interview);

        Mockito.verify(practiceRepository, Mockito.never()).save(any(Practice.class));

    }


}

