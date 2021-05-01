package com.example.demo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.assertj.core.api.Assertions.assertThat;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.UUID;



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
        ResponseEntity<Object> responseEntity =jobController.createJob(job);
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(201);
        assertThat(responseEntity.getHeaders().getLocation().getPath()).isEqualTo("/1");

    }
}
