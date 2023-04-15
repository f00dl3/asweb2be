package asweb2.backend;

import asweb2.backend.jobs.MasterScheduler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {

		SpringApplication.run(BackendApplication.class, args);

		MasterScheduler ms = new MasterScheduler();
		try { ms.runCronJobs(); } catch (Exception e) { e.printStackTrace(); }

	}

}
