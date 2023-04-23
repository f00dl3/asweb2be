package asweb2.backend.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class healthController {

	@RequestMapping(value = "/health", method = RequestMethod.GET)
	public ResponseEntity<Object> getHealth() {
		String healthStatus = "Health is ok!";
		return new ResponseEntity<>(healthStatus, HttpStatus.OK);
	}

}
