package asweb2.backend.jobs.TestJob;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class TestJob implements Job {

    public void execute(JobExecutionContext context) throws JobExecutionException {

        String jobStatus = "enabled";
        String returnData = "";
        Date tDate = new Date();

        System.out.println("Forced job " + jobStatus + " at " + tDate);
        if(jobStatus.equals(("enabled"))) {
            System.out.println("Test job enabled!");
            try {
                System.out.println("Test job ran successfully!");
            } catch (Exception e) {
                System.out.println("Test job failed!");
                e.printStackTrace();
            }
        } else {
            System.out.println("Test job disabled!");
        }


    }

}
