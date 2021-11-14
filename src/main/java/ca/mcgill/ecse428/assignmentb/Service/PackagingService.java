package ca.mcgill.ecse428.assignmentb.Service;

import ca.mcgill.ecse428.assignmentb.Model.PackagingEnvelope;

public class PackagingService {






	/*
	private static double inches_To_MM = 25.4;
	private static double ounces_To_Grams = 28.3495;

	 */




	/*
	//standard packege
	private static double standard_30G_Cost = 0.49;
	private static double standard_50G_Cost = 0.80;
	private static double s_min_Width = 90;
	private static double s_max_Width = 156;
	private static double s_min_height = 140;
	private static double s_max_height = 245;
	private static double s_min_weight = 3;
	private static double s_max_weight = 50;

	 */




	//non standard package
	/*
	private static double non_standard_100G_Cost = 0.98;
	private static double non_standard_500G_Cost = 2.40;

	private static double ns_min_Width = 0;
	private static double ns_max_Width = 270;

	private static double ns_min_Height = 0;
	private static double ns_max_Height = 380;

	private static double ns_min_weight = 0;
	private static double ns_max_weight = 500;

	 */



	/*
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
	public static double calculateRate(double width, String widthUnit,
									 double height, String heightUnit,
									 double weight, String weightUnit) throws IllegalArgumentException {


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
		checkDimensions(width ,widthUnit ,height , heightUnit , weight , heightUnit);


		if (packageType =="standard") {
			if (weight <= 30) {
				return standard_30G_Cost;
			} else {
				return standard_50G_Cost;
			}
		} else {
			if (weight <= 100) {
				return non_standard_100G_Cost;
			} else {
				return non_standard_500G_Cost;
			}
		}



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
}
