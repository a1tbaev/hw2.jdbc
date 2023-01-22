package hw2.jdbc.config.service;

import hw2.jdbc.config.doa.JobDaoImpl;
import hw2.jdbc.config.models.Job;

import java.util.List;

public class JobServiceImpl implements JobService{
    JobDaoImpl jobDao = new JobDaoImpl();
    @Override
    public String createJobTable() {
        jobDao.createJobTable();
        return "successfully created!!";
    }

    @Override
    public String addJob(Job job) {
        jobDao.addJob(job);
        return "successfully added!!!";
    }

    @Override
    public Job getJobById(Long jobId) {
        return jobDao.getJobById(jobId);
    }

    @Override
    public List<Job> sortByExperience(String ascOrDesc) {
        return jobDao.sortByExperience(ascOrDesc);
    }

    @Override
    public Job getJobByEmployeeId(Long employeeId) {
        return jobDao.getJobByEmployeeId(employeeId);
    }

    @Override
    public String deleteDescriptionColumn() {
        jobDao.deleteDescriptionColumn();
        return "successfully deleted!!";
    }
}
