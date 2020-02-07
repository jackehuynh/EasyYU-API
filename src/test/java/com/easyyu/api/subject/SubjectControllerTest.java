package com.easyyu.api.subject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(SubjectControllerTest.class)
public class SubjectControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private SubjectController subjectController;

    @Test
    public void getSpecificSubjectInfoTestOne() throws Exception {
        Subject sub = new Subject();
        sub.setSubject("BIOL");
        sub.setName("Biology");

        given(subjectController.findBySubject("biol")).willReturn(sub);

        mvc.perform(get("http://localhost:8080/api/v1/subject/biol")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("subject", is(sub.getSubject())));
    }

    @Test
    public void getSpecificSubjectInfoTestTwo() throws Exception {
        Subject test = new Subject();
        test.setSubject("EECS");
        test.setName("Electrical Engineering and Computer Science");

        given(subjectController.findBySubject("eecs")).willReturn(test);

        mvc.perform(get("http://localhost:8080/api/v1/subject/eecs")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("subject", is(test.getSubject())))
                .andExpect(MockMvcResultMatchers.jsonPath("name", is(test.getName())));
    }

    @Test
    public void getAllSubjects() throws Exception {
        List<Subject> subjects = subjectController.getAllSubject();

        given(subjectController.getAllSubject()).willReturn(subjects);

        mvc.perform(get("http://localhost:8080/api/v1/subject")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(subjects.size())));
    }
}
