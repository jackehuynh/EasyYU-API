package com.easyyu.api.faculty;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(FacultyControllerTest.class)
public class FacultyControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private FacultyController facultyController;

    /*
    @Test
    public void getSpecificFaculty() throws Exception {
        Faculty testFaculty = new Faculty();
        testFaculty.setCode("LE");
        testFaculty.setName("Lassonde School of Engineering");

        given(facultyController.getFaculty("LE")).willReturn(testFaculty);

        mvc.perform(get("http://localhost:8080/api/v1/faculty/LE")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("code", is(testFaculty.getCode())))
                .andExpect(MockMvcResultMatchers.jsonPath("name", is(testFaculty.getName())));
    }

     */

    @Test
    // should return the same list size of all available faculty obtained from repo layer
    public void getAllFaculty(HttpServletRequest req) throws Exception {
        List<Faculty> faculty = facultyController.getAllFaculty(req);

        given(facultyController.getAllFaculty(req)).willReturn(faculty);

        mvc.perform(get("http://localhost:8080/api/v1/faculty")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(faculty.size())));
    }
}
