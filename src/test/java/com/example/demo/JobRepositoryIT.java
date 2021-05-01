package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
public class JobRepositoryIT {

    @Autowired
    private JobRepository jobRepository;

    @Test
    void shouldFindAll() {
        List<Job> result = jobRepository.findAll();

        assertNotNull(result);
        assertEquals(2, result.size());
    }

    @Test
    void shouldSaveJobAndFindIt() {
        UUID id = UUID.randomUUID();

        Job job = new Job();
        job.setId(id);
        job.setName("test-name");
        job.setDescription("test-description");

        jobRepository.saveAndFlush(job);

        Job resultJob = jobRepository.findById(id).orElseThrow(() -> new JobNotFoundException(id));

        assertEquals(job.getId(), resultJob.getId());
        assertEquals(job.getName(), resultJob.getName());
        assertEquals(job.getDescription(), resultJob.getDescription());
    }

}
