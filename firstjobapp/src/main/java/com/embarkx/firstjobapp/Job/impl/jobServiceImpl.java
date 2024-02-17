package com.embarkx.firstjobapp.Job.impl;
import com.embarkx.firstjobapp.Job.Job;
import com.embarkx.firstjobapp.Job.JobRepository;
import com.embarkx.firstjobapp.Job.JobService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class jobServiceImpl implements JobService{
   // private List<Job> jobs = new ArrayList<>();
    JobRepository jobRepository;

    public jobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }


    @Override
    public List<Job> findAll() {
        return jobRepository.findAll();
    }
    @Override
    public void createJob(Job job) {

        jobRepository.save(job);

    }

    @Override
    public Job getJobById(Long id) {
        return  jobRepository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteJobById(Long id) {
        try {
            jobRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean updateJob(Long id, Job updatedJob) {
        Optional<Job> jobOptional = jobRepository.findById(id);

            if(jobOptional.isPresent()){
                Job job =jobOptional.get();
                job.setTitle(updatedJob.getTitle());
                job.setMinSalary(updatedJob.getMinSalary());
                job.setMaxSalary(updatedJob.getMaxSalary());
                job.setLocation(updatedJob.getLocation());
                jobRepository.save(job);
                return true;

        }
        return false;
    }
}
