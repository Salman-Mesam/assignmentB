package ca.mcgill.ecse428.assignmentb.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@CrossOrigin(origins = "*")
public class PackageEnvelopeController {

	@GetMapping(path = {"/getrate", "/getrate/"}, produces = "application/json")
	public void getPrice(@RequestParam("width") double width, @RequestParam("widthUnit") String widthUnit,
						 @RequestParam("height") double height, @RequestParam("heightUnit") String heightUnit,
						 @RequestParam("weight") double weight, @RequestParam("weightUnit") String weightUnit)
					throws ResponseStatusException {
	}
}







/*
		try {
			//price = PackagingService.obtainPrice(width ,widthUnit ,height ,heightUnit , weight, weightUnit);
		} catch(IllegalArgumentException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
		return rate;

		 */