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
import org.springframework.test.web.servlet.MvcResult;
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

    /*
    @Test
    public void getRequestNoParameters() throws Exception {

        mockMvc.perform(get("/getrate")
                        .contentType(MediaType.APPLICATION_JSON))
                        .andExpect(status().isBadRequest());
    }




    @Test
    public void getRequestNullParameter() throws Exception {

        //Dummy parameters that need to be dimension variables to enable the GETRequest
        String width = null; String widthUnit="mm";
        String height="200"; String heightUnit="mm";
        String weight="20"; String weightUnit="grams";

        mockMvc.perform(get("/getrate")
                        .param("width", width).param("widthUnit", widthUnit)
                        .param("height", height).param("heightUnit", heightUnit)
                        .param("weight", weight).param("weightUnit", weightUnit)
                        .param("extra", "extraParam")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(status().reason("Too many parameters."));
        
        
        MvcResult result = mockMvc.perform(get("/getrate")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andReturn();
    }
    
    @Test
    public void getRequestTooManyParameters() throws Exception {

        //Dummy parameters that need to be dimension variables to enable the GETRequest
        String width="100"; String widthUnit="mm";
        String height="200"; String heightUnit="mm";
        String weight="20"; String weightUnit="grams";

        mockMvc.perform(get("/getrate")
                        .param("width", width).param("widthUnit", widthUnit)
                        .param("height", height).param("heightUnit", heightUnit)
                        .param("weight", weight).param("weightUnit", weightUnit)
                        .param("extra", "extraParam")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(status().reason("Too many parameters."));
    }

     */
}



//Dummy expected value. It is a double
//double expected = 0.49;

//GET Request sent using HTTP URL Query parameters
//double result = PackageEnvelopeController.getRate(width, widthUnit, height, heightUnit, weight, weightUnit);

//assertEquals(expected,result);