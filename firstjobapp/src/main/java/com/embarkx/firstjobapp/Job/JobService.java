package com.embarkx.firstjobapp.Job;
import java.util.List;
/*
        We have created this interface to provide lose coupling
        in order to have some modularity we have to separate the interface and implementation in the
        separate place.

 */

public interface JobService {
   List<Job> findAll();
    void createJob(Job job);

    Job getJobById(Long id);

    boolean deleteJobById(Long id);
    boolean updateJob(Long id,Job upodatedJob);
}
