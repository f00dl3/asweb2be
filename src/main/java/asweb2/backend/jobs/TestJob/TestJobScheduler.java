package asweb2.backend.jobs.TestJob;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.TimeZone;

import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

@Component
public class TestJobScheduler {

    public void scheduler() {

        String h2r = "08";
        boolean isDst = false;
        try { isDst = TimeZone.getDefault().inDaylightTime(new Date()); } catch (Exception e) { }
        if(isDst) { h2r = "07"; }

        String schedule = "0 " + h2r + " 16 ? ** MON-FRI";

        try {

            JobDetail job = JobBuilder
                    .newJob(TestJob.class)
                    .withIdentity("testJob", "testJobs")
                    .build();

            Trigger trigger = newTrigger()
                    .withIdentity("cron_testJob", "testJobs")
                    .forJob(job)
                    .withSchedule(cronSchedule(schedule))
                    .build();

            Scheduler scheduler = new StdSchedulerFactory().getScheduler();
            scheduler.start();
            scheduler.scheduleJob(job, trigger);

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

}
