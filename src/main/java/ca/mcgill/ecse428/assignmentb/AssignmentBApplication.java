package ca.mcgill.ecse428.assignmentb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@SpringBootApplication
public class AssignmentBApplication {

	public static void main(String[] args) {
		SpringApplication.run(AssignmentBApplication.class, args);
	}

	@RequestMapping("/")
	public String greeting(){
		return "Hello world, nice to meet you :)";
	}

}
