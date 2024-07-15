package com.embarkx.first_app.job.impl;

import com.embarkx.first_app.job.Job;
import com.embarkx.first_app.job.JobService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobServiceImpl implements JobService {

    private List<Job> jobsList = new ArrayList<>();
    private Long nextId = 10001L;

    @Override
    public String createJob(Job newJob) {
        newJob.setId(nextId++);
        jobsList.add(newJob);
        return "Job created successfully";
    }

    @Override
    public List<Job> getAllJobs() {
        return jobsList;
    }

    @Override
    public Job getJobById(Long id) {
        for (Job job : jobsList) {
            if (job.getId().equals(id)) {
                return job;
            }
        }
        return null;
    }

    @Override
    public String deleteJob(Long id) {
        for (Job job : jobsList) {
            if (job.getId().equals(id)) {
                jobsList.remove(job);
                return "Job deleted successfully";
            }
        }
        return "Job not found";
    }

    @Override
    public String updateJob(Job oldjob, Long id) {
        for (Job job : jobsList) {
            if (job.getId().equals(id)) {
                job.setDescription(oldjob.getDescription());
                job.setTitle(oldjob.getTitle());
                job.setMaxSalary(oldjob.getMaxSalary());
                job.setMinSalary(oldjob.getMinSalary());
                job.setLocation(oldjob.getLocation());
                return "Job updated successfully";
            }
        }
        return "Job not found";
    }
}
