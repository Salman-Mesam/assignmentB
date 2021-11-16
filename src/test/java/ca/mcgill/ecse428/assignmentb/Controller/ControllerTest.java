package ca.mcgill.ecse428.assignmentb.Controller;

import org.junit.jupiter.api.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

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

/*
    @Test
    public void getRequestInvalidWidthUnitMM() throws Exception {

        //Dummy parameters that need to be dimension variables to enable the GETRequest
        String width="120"; String widthUnit="iNvaLiD";
        String height="200"; String heightUnit="mm";
        String weight="20"; String weightUnit="grams";

         //MockHttpServletResponse response
                 //String error
        /*
        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> mockMvc.perform(get("/getrate")
                                .param("width", width).param("widthUnit", widthUnit)
                                .param("height", height).param("heightUnit", heightUnit)
                                .param("weight", weight).param("weightUnit", weightUnit)
                                .contentType(MediaType.APPLICATION_JSON)),
                "Expected getRate() to throw an \"IllegalArgumentException\", but it didn't."
        );

        MockHttpServletResponse response = mockMvc.perform(get("/getrate")
                        .param("width", width).param("widthUnit", widthUnit)
                        .param("height", height).param("heightUnit", heightUnit)
                        .param("weight", weight).param("weightUnit", weightUnit)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                //.andReturn().getResponse().getContentAsString();
                         .andReturn().getResponse();

                 String error = response.getErrorMessage();
                 //double rate = response.getOutputStream();
        System.out.println(error);
    }*/
/*
    @Test
    public void getRequestInvalidWidthUnitMM() throws Exception {

        //Dummy parameters that need to be dimension variables to enable the GETRequest
        String width="120"; String widthUnit="iNvaLiD";
        String height="200"; String heightUnit="mm";
        String weight="20"; String weightUnit="grams";

        String thrown = mockMvc.perform(get("/getrate")
                        .param("width", width).param("widthUnit", widthUnit)
                        .param("height", height).param("heightUnit", heightUnit)
                        .param("weight", weight).param("weightUnit", weightUnit)
                        .contentType(MediaType.APPLICATION_JSON))
                        .andExpect(status().isOk())
                .andReturn().getResolvedException().getMessage();
        System.out.println(thrown);
    }

 */
    @Test
    public void getRequestMissingParameters() throws Exception {

        //Dummy parameters that need to be dimension variables to enable the GETRequest
        String width="120"; String widthUnit="mm";
        String height="200"; String heightUnit="mm";

        mockMvc.perform(get("/getrate")
                        .param("width", width).param("widthUnit", widthUnit)
                        .param("height", height).param("heightUnit", heightUnit)
                        .contentType(MediaType.APPLICATION_JSON))
                        .andExpect(status().isBadRequest())
                        .andExpect(result -> assertTrue(result.getResolvedException()
                            instanceof MissingServletRequestParameterException));
    }
    @Test
    public void getRequestParameterTypeMismatch() throws Exception {

        //Dummy parameters that need to be dimension variables to enable the GETRequest
        String width="notANumber"; String widthUnit="mm";
        String height="200"; String heightUnit="mm";
        String weight="20"; String weightUnit="grams";

        mockMvc.perform(get("/getrate")
                        .param("width", width).param("widthUnit", widthUnit)
                        .param("height", height).param("heightUnit", heightUnit)
                        .param("weight", weight).param("weightUnit", weightUnit)
                        .contentType(MediaType.APPLICATION_JSON))
                        .andExpect(status().isBadRequest())
                        .andExpect(result -> assertTrue(result.getResolvedException()
                                instanceof MethodArgumentTypeMismatchException));
    }
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