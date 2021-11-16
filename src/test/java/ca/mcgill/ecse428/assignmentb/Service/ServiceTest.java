package ca.mcgill.ecse428.assignmentb.Service;

import static org.junit.jupiter.api.Assertions.*;

import ca.mcgill.ecse428.assignmentb.Controller.PackageEnvelopeController;
import org.junit.jupiter.api.Test;

public class ServiceTest {

    private static final double STANDARD_RATE_30GRAMS = 0.49;
    private static final double STANDARD_RATE_50GRAMS = 0.80;
    private static final double NON_STANDARD_RATE_100GRAMS = 0.98;
    private static final double NON_STANDARD_RATE_500GRAMS = 2.40;

    @Test
    public void weightInvalidUnitParameter() {
        //Dummy dimension variables to enable the GETRequest Using mm
        double width=120; String widthUnit="mm"; double height=200; String heightUnit="iNcHeS";
        //Dummy weight variables to enable the GETRequest Using grams
        double weight=20; String weightUnit="iNvAlId";

        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> PackageEnvelopeController.getRate(width, widthUnit, height, heightUnit, weight, weightUnit),
                "Expected getRate() to throw an \"IllegalArgumentException\", but it didn't."
        );
        System.out.println("Message: "+thrown.getMessage());
        assertEquals(thrown.getMessage(),
                "Invalid weightUnit parameter. Valid weight units (case insensitive): \"grams\" or \"ounces\"");
    }
    @Test
    public void heightInvalidUnitParameter() {
        //Dummy dimension variables to enable the GETRequest Using mm
        double width=120; String widthUnit="MM"; double height=200; String heightUnit="iNvALiD";
        //Dummy weight variables to enable the GETRequest Using grams
        double weight=20; String weightUnit="grams";

        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> PackageEnvelopeController.getRate(width, widthUnit, height, heightUnit, weight, weightUnit),
                "Expected getRate() to throw an \"IllegalArgumentException\", but it didn't."
        );
        System.out.println("Message: "+thrown.getMessage());
        assertEquals(thrown.getMessage(),
                "Invalid heightUnit parameter. Valid height units (case insensitive): \"mm\" or \"inches\"");
    }
    @Test
    public void widthInvalidUnitParameter() {
        //Dummy dimension variables to enable the GETRequest Using mm
        double width=120; String widthUnit="iNvALiD"; double height=200; String heightUnit="mm";
        //Dummy weight variables to enable the GETRequest Using grams
        double weight=20; String weightUnit="grams";

        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> PackageEnvelopeController.getRate(width, widthUnit, height, heightUnit, weight, weightUnit),
                "Expected getRate() to throw an \"IllegalArgumentException\", but it didn't."
        );
        System.out.println("Message: "+thrown.getMessage());
        assertEquals(thrown.getMessage(),
                "Invalid widthUnit parameter. Valid width units (case insensitive): \"mm\" or \"inches\"");
    }
    @Test
    public void weightOuncesToGrams() {
        //Dummy dimension variables to enable the GETRequest Using inches
        double width=120; String widthUnit="mm"; double height=200; String heightUnit="mm";
        //Dummy weight variables to enable the GETRequest Using grams
        double weight=3.17466; String weightUnit="ounces";

        //Expected result of the Rate Calculations using the above defined parameters
        double expected = NON_STANDARD_RATE_100GRAMS;

        //GET Request sent using HTTP URL Query parameters
        double result = PackageEnvelopeController.getRate(width, widthUnit, height, heightUnit, weight, weightUnit);
        System.out.println("Rate expected: "+expected+"$\n" +
                "Rate returned: "+result+"$");
        assertEquals(expected,result);
    }
    @Test
    public void heightInchesToMM() {
        //Dummy dimension variables to enable the GETRequest Using inches
        double width=120; String widthUnit="mm"; double height=7.874015748; String heightUnit="inches";
        //Dummy weight variables to enable the GETRequest Using grams
        double weight=40; String weightUnit="grams";

        //Expected result of the Rate Calculations using the above defined parameters
        double expected = STANDARD_RATE_50GRAMS;

        //GET Request sent using HTTP URL Query parameters
        double result = PackageEnvelopeController.getRate(width, widthUnit, height, heightUnit, weight, weightUnit);
        System.out.println("Rate expected: "+expected+"$\n" +
                "Rate returned: "+result+"$");
        assertEquals(expected,result);
    }
    @Test
    public void widthInchesToMM() {
        //Dummy dimension variables to enable the GETRequest Using inches
        double width=4.7244094488; String widthUnit="inches"; double height=200; String heightUnit="mm";
        //Dummy weight variables to enable the GETRequest Using grams
        double weight=20; String weightUnit="grams";

        //Expected result of the Rate Calculations using the above defined parameters
        double expected = STANDARD_RATE_30GRAMS;

        //GET Request sent using HTTP URL Query parameters
        double result = PackageEnvelopeController.getRate(width, widthUnit, height, heightUnit, weight, weightUnit);
        System.out.println("Rate expected: "+expected+"$\n" +
                "Rate returned: "+result+"$");
        assertEquals(expected,result);
    }
    @Test
    public void checkNonStandardHeight() {
        //Dummy dimension variables to enable the GETRequest Using mm
        double width=120; String widthUnit="mm"; double height=300; String heightUnit="mm";
        //Dummy weight variables to enable the GETRequest Using grams
        double weight=20; String weightUnit="grams";

        //Expected result of the Rate Calculations using the above defined parameters
        double expected = NON_STANDARD_RATE_100GRAMS;

        //GET Request sent using HTTP URL Query parameters
        double result = PackageEnvelopeController.getRate(width, widthUnit, height, heightUnit, weight, weightUnit);
        System.out.println("Rate expected: "+expected+"$\n" +
                "Rate returned: "+result+"$");
        assertEquals(expected,result);
    }
    @Test
    public void checkNonStandardWidth() {
        //Dummy dimension variables to enable the GETRequest Using mm
        double width=200; String widthUnit="mm"; double height=200; String heightUnit="mm";
        //Dummy weight variables to enable the GETRequest Using grams
        double weight=40; String weightUnit="grams";

        //Expected result of the Rate Calculations using the above defined parameters
        double expected = NON_STANDARD_RATE_100GRAMS;

        //GET Request sent using HTTP URL Query parameters
        double result = PackageEnvelopeController.getRate(width, widthUnit, height, heightUnit, weight, weightUnit);
        System.out.println("Rate expected: "+expected+"$\n" +
                "Rate returned: "+result+"$");
        assertEquals(expected,result);
    }
    @Test
    public void heightOutOfMaximumBound() {
        //Dummy dimension variables to enable the GETRequest Using mm
        double width=120; String widthUnit="mm"; double height=450; String heightUnit="mm";
        //Dummy weight variables to enable the GETRequest Using grams
        double weight=20; String weightUnit="grams";

        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> PackageEnvelopeController.getRate(width, widthUnit, height, heightUnit, weight, weightUnit),
                "Expected getRate() to throw an \"IllegalArgumentException\", but it didn't."
        );
        System.out.println("Message: "+thrown.getMessage());
        assertEquals(thrown.getMessage(), "Height parameter cannot be larger than 380mm (or 14.96 inches).");
    }
    @Test
    public void widthOutOfMaximumBound() {
        //Dummy dimension variables to enable the GETRequest Using mm
        double width=300; String widthUnit="mm"; double height=200; String heightUnit="mm";
        //Dummy weight variables to enable the GETRequest Using grams
        double weight=20; String weightUnit="grams";

        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> PackageEnvelopeController.getRate(width, widthUnit, height, heightUnit, weight, weightUnit),
                "Expected getRate() to throw an \"IllegalArgumentException\", but it didn't."
        );
        System.out.println("Message: "+thrown.getMessage());
        assertEquals(thrown.getMessage(), "Width parameter cannot be larger than 270mm (or 10.63 inches).");
    }
    @Test
    public void weightOutOfMaximumBound() {
        //Dummy dimension variables to enable the GETRequest Using mm
        double width=120; String widthUnit="mm"; double height=200; String heightUnit="mm";
        //Dummy weight variables to enable the GETRequest Using grams
        double weight=600; String weightUnit="grams";

        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> PackageEnvelopeController.getRate(width, widthUnit, height, heightUnit, weight, weightUnit),
                "Expected getRate() to throw an \"IllegalArgumentException\", but it didn't."
        );
        System.out.println("Message: "+thrown.getMessage());
        assertEquals(thrown.getMessage(), "Weight parameter cannot be larger than 500grams (or 17.637 ounces).");
    }
    @Test
    public void nonStandardRateUpTo500Grams() {
        //Dummy dimension variables to enable the GETRequest Using mm
        double width=120; String widthUnit="mm"; double height=200; String heightUnit="mm";
        //Dummy weight variables to enable the GETRequest Using grams
        double weight=250; String weightUnit="grams";

        //Expected result of the Rate Calculations using the above defined parameters
        double expected = NON_STANDARD_RATE_500GRAMS;

        //GET Request sent using HTTP URL Query parameters
        double result = PackageEnvelopeController.getRate(width, widthUnit, height, heightUnit, weight, weightUnit);
        System.out.println("Rate expected: "+expected+"$\n" +
                "Rate returned: "+result+"$");
        assertEquals(expected,result);
    }
    @Test
    public void nonStandardRateUpTo100Grams() {
        //Dummy dimension variables to enable the GETRequest Using mm
        double width=120; String widthUnit="mm"; double height=200; String heightUnit="mm";
        //Dummy weight variables to enable the GETRequest Using grams
        double weight=80; String weightUnit="grams";

        //Expected result of the Rate Calculations using the above defined parameters
        double expected = NON_STANDARD_RATE_100GRAMS;

        //GET Request sent using HTTP URL Query parameters
        double result = PackageEnvelopeController.getRate(width, widthUnit, height, heightUnit, weight, weightUnit);
        System.out.println("Rate expected: "+expected+"$\n" +
                "Rate returned: "+result+"$");
        assertEquals(expected,result);
    }
    @Test
    public void weightOutOfMinimumBound() {
        //Dummy dimension variables to enable the GETRequest Using mm
        double width=120; String widthUnit="mm"; double height=200; String heightUnit="mm";
        //Dummy weight variables to enable the GETRequest Using grams
        double weight=2; String weightUnit="grams";

        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> PackageEnvelopeController.getRate(width, widthUnit, height, heightUnit, weight, weightUnit),
                "Expected getRate() to throw an \"IllegalArgumentException\", but it didn't."
        );
        System.out.println("Message: "+thrown.getMessage());
        assertEquals(thrown.getMessage(), "Weight parameter cannot be smaller than 3.0grams (or 0.1058 ounces).");
    }
    @Test
    public void heightOutOfMinimumBound() {
        //Dummy dimension variables to enable the GETRequest Using mm
        double width=120; String widthUnit="mm"; double height=100; String heightUnit="mm";
        //Dummy weight variables to enable the GETRequest Using grams
        double weight=20; String weightUnit="grams";

        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> PackageEnvelopeController.getRate(width, widthUnit, height, heightUnit, weight, weightUnit),
                "Expected getRate() to throw an \"IllegalArgumentException\", but it didn't."
        );
        System.out.println("Message: "+thrown.getMessage());
        assertEquals(thrown.getMessage(), "Height parameter cannot be smaller than 140mm (or 5.51 inches).");
    }
    @Test
    public void widthOutOfMinimumBound() {
        //Dummy dimension variables to enable the GETRequest Using mm
        double width=25; String widthUnit="mm"; double height=200; String heightUnit="mm";
        //Dummy weight variables to enable the GETRequest Using grams
        double weight=20; String weightUnit="grams";

        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> PackageEnvelopeController.getRate(width, widthUnit, height, heightUnit, weight, weightUnit),
                "Expected getRate() to throw an \"IllegalArgumentException\", but it didn't."
        );
        System.out.println("Message: "+thrown.getMessage());
        assertEquals(thrown.getMessage(), "Width parameter cannot be smaller than 90mm (or 3.54 inches).");
    }
    @Test
    public void standardRateUpTo50Grams() {
        //Dummy dimension variables to enable the GETRequest Using mm
        double width=120; String widthUnit="mm"; double height=200; String heightUnit="mm";
        //Dummy weight variables to enable the GETRequest Using grams
        double weight=40; String weightUnit="grams";

        //Expected result of the Rate Calculations using the above defined parameters
        double expected = STANDARD_RATE_50GRAMS;

        //GET Request sent using HTTP URL Query parameters
        double result = PackageEnvelopeController.getRate(width, widthUnit, height, heightUnit, weight, weightUnit);
        System.out.println("Rate expected: "+expected+"$\n" +
                "Rate returned: "+result+"$");
        assertEquals(expected,result);
    }
    @Test
    public void standardRateUpTo30Grams() {
        //Dummy dimension variables to enable the GETRequest Using mm
        double width=120; String widthUnit="mm"; double height=200; String heightUnit="mm";
        //Dummy weight variables to enable the GETRequest Using grams
        double weight=20; String weightUnit="grams";

        //Expected result of the Rate Calculations using the above defined parameters
        double expected = STANDARD_RATE_30GRAMS;

        //GET Request sent using HTTP URL Query parameters
        double result = PackageEnvelopeController.getRate(width, widthUnit, height, heightUnit, weight, weightUnit);
        System.out.println("Rate expected: "+expected+"$\n" +
                "Rate returned: "+result+"$");
        assertEquals(expected,result);
    }
}
