package ca.mcgill.ecse428.assignmentb.Controller;

import ca.mcgill.ecse428.assignmentb.Service.PackagingService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Objects;
import java.util.stream.Stream;

@RestController
@CrossOrigin(origins = "*")
public class PackageEnvelopeController {

	@GetMapping(path = {"/getrate", "/getrate/"}, produces = "application/json")
	public static double getRate(@RequestParam("width") double width, @RequestParam("widthUnit") String widthUnit,
								 @RequestParam("height") double height, @RequestParam("heightUnit") String heightUnit,
								 @RequestParam("weight") double weight, @RequestParam("weightUnit") String weightUnit)
										throws ResponseStatusException, IllegalArgumentException {

		double rate = PackagingService.calculateRate(width, widthUnit, height, heightUnit, weight, weightUnit);
		return rate;
	}
}