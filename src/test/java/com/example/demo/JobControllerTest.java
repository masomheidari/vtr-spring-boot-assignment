package com.example.demo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.InjectMocks;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.UUID;

import static org.hamcrest.Matchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)


class JobControllerTest {


    @InjectMocks
    JobController jobController;

    @Mock
    JobRepository jobRepository;

    @Test
    public void testCreateJob()
    {
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        UUID id = UUID.randomUUID();
        Job job = new Job();
        job.setId(id);
        job.setName("test-name");
        job.setDescription("test-description");
        //when(jobRepository.save(any(Job.class))).thenReturn(job);

    }


}
