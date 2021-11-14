package ca.mcgill.ecse428.assignmentb.Controller;

import ca.mcgill.ecse428.assignmentb.AssignmentBApplication;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.server.ResponseStatusException;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Tag("IntegrationTest")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class ControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getRequestAcceptsParametersWithUnits() throws Exception {

        //Dummy parameters that need to be dimension variables to enable the GETRequest
        String width="100"; String widthUnit="mm";
        String height="200"; String heightUnit="mm";
        String weight="20"; String weightUnit="grams";

        mockMvc.perform(get("/getrate")
                        .param("width", width).param("widthUnit", widthUnit)
                        .param("height", height).param("heightUnit", heightUnit)
                        .param("weight", weight).param("weightUnit", weightUnit)
                        .contentType(MediaType.APPLICATION_JSON))
                        .andExpect(status().isOk());
    }
    @Test
    public void getRequestMissingParameters() throws Exception {

        //Dummy parameters that need to be dimension variables to enable the GETRequest
        String width="100"; String widthUnit="mm";
        String height="200"; String heightUnit="mm";
        String weight="20";

        mockMvc.perform(get("/getrate")
                        .param("weightUnit", width).param("widthUnit", widthUnit)
                        .param("height", height).param("heightUnit", heightUnit)
                        .param("weight", weight).param("width", width)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(status().reason("Missing Parameters. Usage:  " +
                        "/getrate?width=56&widthUnit=mm&height=12.2&heightUnit=mm&weight=45.0&weightUnit=grams"));
    }
}



//Dummy expected value. It is a double
//double expected = 0.49;

//GET Request sent using HTTP URL Query parameters
//double result = PackageEnvelopeController.getRate(width, widthUnit, height, heightUnit, weight, weightUnit);

//assertEquals(expected,result);