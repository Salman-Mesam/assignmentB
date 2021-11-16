package ca.mcgill.ecse428.assignmentb.Service;

import java.math.BigDecimal;
import java.math.MathContext;

public class PackagingService {

    /*  Class Constants used to implement the method logic.
        Constants are defined as per the RAMP Application Specifications. */

    //Rates
    private static final double STANDARD_RATE_30GRAMS = 0.49;
    private static final double STANDARD_RATE_50GRAMS = 0.80;
    private static final double NON_STANDARD_RATE_100GRAMS = 0.98;
    private static final double NON_STANDARD_RATE_500GRAMS = 2.40;
    //Size and weight Valid Bounds
    private static final double MIN_WIDTH = 90;
    private static final double MAX_WIDTH = 270;
    private static final double MIN_HEIGHT = 140;
    private static final double MAX_HEIGHT = 380;
    private static final double MIN_WEIGHT = 3.0;
    private static final double MAX_WEIGHT = 500;
    //Size bounds for standard packages
    private static final double STANDARD_WIDTH_LIMIT = 156;
    private static final double STANDARD_HEIGHT_LIMIT = 245;
    //Conversion constants
    private static final double INCHES_TO_MM = 25.4;
    private static final double OUNCES_TO_GRAMS = 28.34952;


    public static double calculateRate(double width, String widthUnit,
                                       double height, String heightUnit,
                                       double weight, String weightUnit) throws IllegalArgumentException {

        if(widthUnit.contains("inches")) { width = convertToMM(width); }
        if(heightUnit.contains("inches")) { height = convertToMM(height); }
        if(weightUnit.contains("ounces")) { weight = convertToGrams(weight); }

        validateParameters(width, height, weight);

        boolean isNonStandard = checkIfNonStandardPackage(width, height);

        double rate;
        if(weight <= 30) {
            if(isNonStandard) {
                rate = NON_STANDARD_RATE_100GRAMS;
            } else
                rate = STANDARD_RATE_30GRAMS;
        } else if(weight <= 50) {
            if(isNonStandard) {
                rate = NON_STANDARD_RATE_100GRAMS;
            } else
                rate = STANDARD_RATE_50GRAMS;
        } else if(weight <= 100) {
            rate = NON_STANDARD_RATE_100GRAMS;
        } else {
            rate = NON_STANDARD_RATE_500GRAMS;
        }
        return rate;
    }
    private static double convertToGrams(double weight) {
        return weight*OUNCES_TO_GRAMS;
    }
    private static double convertToMM(double size) {
        return size*INCHES_TO_MM;
    }

    private static boolean checkIfNonStandardPackage(double width, double height) {
        if(width > STANDARD_WIDTH_LIMIT || height > STANDARD_HEIGHT_LIMIT) {
            return true;
        }
        else return false;
    }

    private static void validateParameters(double width, double height, double weight)
            throws IllegalArgumentException {
        if(width < MIN_WIDTH) {
            throw new IllegalArgumentException("Width parameter cannot be smaller than 90mm (or 3.54 inches).");
        } else if(width > MAX_WIDTH) {
            throw new IllegalArgumentException("Width parameter cannot be larger than 270mm (or 10.63 inches).");
        } else if(height < MIN_HEIGHT) {
            throw new IllegalArgumentException("Height parameter cannot be smaller than 140mm (or 5.51 inches).");
        } else if(height > MAX_HEIGHT) {
            throw new IllegalArgumentException("Height parameter cannot be larger than 380mm (or 14.96 inches).");
        } else if(weight < MIN_WEIGHT) {
            throw new IllegalArgumentException("Weight parameter cannot be smaller than 3.0grams (or 0.1058 ounces).");
        } else if(weight > MAX_WEIGHT) {
            throw new IllegalArgumentException("Weight parameter cannot be larger than 500grams (or 17.637 ounces).");
        }
    }
}






/*
    private static double convertToMM(double size) {
        BigDecimal preciseValue = new BigDecimal(size*INCHES_TO_MM);
        return preciseValue.round(new MathContext(6)).doubleValue();
    }
*/


	/*
	private static double ounces_To_Grams = 28.3495;

	public static double convertInchesToMM(double size) {
		double heightInMM = size * inches_To_MM;
		return heightInMM;
	}
	public static double convertOuncesToGrams(double weight) {
		double weightInGrams = weight * ounces_To_Grams;
		return weightInGrams;
	}
	*/
	/*

		if (widthUnit == "inches" || widthUnit == "Inches") {
			width = convertWidthToMM(width);
		}


		if (heightUnit == "inches" || heightUnit == "Inches") {
			height = convertHeightToMM(height);
		}

		if (weightUnit == "ounces" || weightUnit == "Ounces") {
			weight = convertHeightToMM(weight);
		}
	}
	*/
	/*

	}

	public static void checkDimensions(double width ,String widthUnit ,double height ,String heightunit ,double weight,String heightUnit, String PackageType)  throws IllegalArgumentException{
		if (PackageType == "Standard") {
			if (width < s_min_Width) {
				throw new IllegalArgumentException("The minimum width of a standard envelope has to be 90mm or 3.54331 inches");
			} else if (width > s_max_Width) {
				throw new IllegalArgumentException("The maximum width of a standard envelope can be 156mm or 6.14173 inches");
			} else if (height < s_min_height) {
				throw new IllegalArgumentException("The minimum height of a standard envelope has to be 140mm or 5.51181 inches");
			} else if (height > s_max_height) {
				throw new IllegalArgumentException("The maximum height of a standard envelope can be  245mm or 9.64567 inches");
			} else if (weight < s_min_weight) {
				throw new IllegalArgumentException("The minimum weight of a standard envelope has to be 3g or 0.105822 ounce");
			} else if (weight > s_max_weight) {
				throw new IllegalArgumentException("The maximum weight of a standard envelope can be 50g or 1.7637 ounces");
			}
		} else {
			if (width < ns_min_Width) {
				throw new IllegalArgumentException("The envelope must have a width that greater than 0");
			} else if (width > ns_max_Width) {
				throw new IllegalArgumentException(
						"The maximum width of a non standard envelope is 270mm (10.6299 inch)");
			} else if (height < ns_min_Height) {
				throw new IllegalArgumentException("The envelope must have a height greater than 0");
			} else if (height > ns_max_Height) {
				throw new IllegalArgumentException(
						"The maximum height of a non standard envelope can  be  380mm or 14.9606 inches");
			} else if (weight < ns_min_weight) {
				throw new IllegalArgumentException("Non standard envelope must have a weight greater than 0");
			} else if (weight > ns_max_weight) {
				throw new IllegalArgumentException(
						"The maximum weight of a non standard envelope can be  500g or 17.637 ounces ");
			}
		}
	}
*/
