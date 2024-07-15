package com.embarkx.first_app.job;

import java.util.List;

public interface JobService {

    String createJob(Job newJob);

    List<Job> getAllJobs();

    Job getJobById(Long id);

    String deleteJob(Long id);

    String updateJob(Job oldjob, Long id);
}
