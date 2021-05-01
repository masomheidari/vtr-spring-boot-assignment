package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController

public class JobController {

    @Autowired
    private JobRepository jobRepository;

    @GetMapping("/jobs")
    public List<Job> retrieveAllJobs() {
        return jobRepository.findAll();
    }
    @GetMapping("/jobs/{id}")
    public Job retrieveJob(@PathVariable UUID id) {
        Optional<Job> job = jobRepository.findById(id);

        if (!job.isPresent())
            throw new JobNotFoundException(id);

        return job.get();
    }
    @DeleteMapping("/jobs/{id}")
    public void deleteJob(@PathVariable UUID id) {
        jobRepository.deleteById(id);
    }
    @PostMapping("/jobs")
    public ResponseEntity<Object> createJob(@Valid @RequestBody Job job) {
        Job savedJob = jobRepository.save(job);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedJob.getId()).toUri();

        return ResponseEntity.created(location).build();

    }
    @PutMapping("/jobs/{id}")
    public ResponseEntity<Object> updateJob(@RequestBody Job job, @PathVariable UUID id) {

        Optional<Job> jobOptional = jobRepository.findById(id);

        if (!jobOptional.isPresent())
            return ResponseEntity.notFound().build();

        job.setId(id);

        jobRepository.save(job);

        return ResponseEntity.noContent().build();
    }

}
