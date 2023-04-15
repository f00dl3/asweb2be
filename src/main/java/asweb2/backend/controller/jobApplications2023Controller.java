package asweb2.backend.controller;

import asweb2.backend.entity.Core.JobApplications2023;
import asweb2.backend.repository.Core.JobApplications2023Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class jobApplications2023Controller {

	@Autowired
	private JobApplications2023Repository jobApplications2023Repository;

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/jobApplications2023", method = RequestMethod.GET)
	public @ResponseBody Iterable<JobApplications2023> getAllJobApplications2023() {
		return jobApplications2023Repository.findAll();
	}

}
