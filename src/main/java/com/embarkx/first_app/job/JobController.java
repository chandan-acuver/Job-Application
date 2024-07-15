package com.embarkx.first_app.job;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jobs")
public class JobController {

    private JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @PostMapping("/createJob")
    public String createJob(@RequestBody Job newJob){
        return jobService.createJob(newJob);
    }

    @GetMapping("/getAllJobs")
    public List<Job> getAllJobs(){
        return jobService.getAllJobs();
    }

    @GetMapping("/getJobById/{id}")
    public Job getJobById(@PathVariable Long id){
        Job job = jobService.getJobById(id);
        if (job != null) {
            return job;
        } else {
            return new Job(0L,"Test", "Test","Test","Test","Test");
        }
    }

    @DeleteMapping("/deleteJob/{id}")
    public String deleteJob(@PathVariable Long id){
        return jobService.deleteJob(id);
    }

    @PutMapping("/updateJob/{id}")
    public String updateJob(@RequestBody Job oldjob,
                            @PathVariable Long id){
        return jobService.updateJob(oldjob, id);
    }

}
