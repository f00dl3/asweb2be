package asweb2.backend.jobs;

import asweb2.backend.jobs.TestJob.TestJobScheduler;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class MasterScheduler {

    TestJobScheduler tjs = new TestJobScheduler();

    public void runCronJobs() throws Exception {

        Logger log = LoggerFactory.getLogger(Scheduler.class);
        log.info("Initializing cron jobs...");

        SchedulerFactory sf = new StdSchedulerFactory();
        Scheduler scheduler = sf.getScheduler();
        log.info("Initializiation complete!");

        try { tjs.scheduler(); } catch (Exception e) { e.printStackTrace(); }

    }

    public static void main(String[] args) {

        MasterScheduler ms = new MasterScheduler();
        try { ms.runCronJobs(); } catch (Exception e) { e.printStackTrace(); }

    }

}
