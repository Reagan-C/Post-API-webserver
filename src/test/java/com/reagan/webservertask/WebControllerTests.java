package com.reagan.webservertask;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.reagan.webservertask.controller.WebController;
import com.reagan.webservertask.service.CalcServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(WebController.class)
@RunWith(SpringRunner.class)
public class WebControllerTests {

    @Autowired
    MockMvc mvc;

    @MockBean
    CalcServiceImpl calcService = new CalcServiceImpl();

    @Test
    public void postReq() throws Exception{
        String x = "\"operation_type\": \"what is the difference between 80 and 05\", \"x\": 20, \"y\": 5";

        mvc.perform(post("/").contentType(MediaType.APPLICATION_JSON)
                .content(asJson(x))).andExpect(status().isOk()).andExpect(content().contentType(
                "application/json;charset=UTF-8"));

    }

    public static String asJson(String myStr) {
        try {
            return new ObjectMapper().writeValueAsString(myStr);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
