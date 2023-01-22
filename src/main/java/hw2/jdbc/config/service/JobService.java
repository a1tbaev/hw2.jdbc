package hw2.jdbc.config.service;

import hw2.jdbc.config.models.Job;

import java.util.List;

public interface JobService {
    String createJobTable();
    String addJob(Job job);
    Job getJobById(Long jobId);
    List<Job> sortByExperience(String ascOrDesc);
    Job getJobByEmployeeId(Long employeeId);
    String deleteDescriptionColumn();
}
