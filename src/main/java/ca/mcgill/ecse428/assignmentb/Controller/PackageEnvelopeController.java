package ca.mcgill.ecse428.assignmentb.Controller;

import ca.mcgill.ecse428.assignmentb.Service.PackagingService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;



@RestController
@CrossOrigin(origins = "*")
public class PackageEnvelopeController {
	
	@GetMapping(path = {"/getprice", "/getprice/"}, produces = "application/json")
	public double getPrice(@RequestParam("width") double width,@RequestParam("widthUnit") String widthUnit,@RequestParam("height") double height,@RequestParam("heightUnit") String heightUnit,@RequestParam("weight") double weight,@RequestParam("weight") String weightUnit,@RequestParam("service") String service) {
		double price;
		try {
			price = PackagingService.obtainPrice(width ,widthUnit ,height ,heightUnit , weight, weightUnit, service);
		} catch(IllegalArgumentException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
		return price;
	}

}
