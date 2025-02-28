package com.eureka.app.school;

import com.eureka.app.school.controller.SchoolServiceController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.fail;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(SchoolServiceController.class)
@ActiveProfiles("test")
public class SchoolServiceControllerTests {
  @Mock
  private RestTemplate restTemplate;

  @Autowired
  private MockMvc mockMvc;

  @Value("${student.url}")
  String url;
  @Value("${school.name}")
  String schoolname;

  @Before
  public void init() {
    //	ReflectionTestUtils.setField(schoolServiceController, "envelopeFactory", restTemplate);
  }

  @Test
  public void testGetStudents() throws Exception {
    ResponseEntity<String> myEntity = new ResponseEntity<String>(HttpStatus.OK);
    String requestUrl = "http://student-service/getStudentDetailsForSchool/" + schoolname;
    Mockito.when(restTemplate.exchange(Matchers.eq(requestUrl), Matchers.eq(GET),
            Matchers.<HttpEntity<String>>any(), Matchers.<ParameterizedTypeReference<String>>any()))
        .thenReturn(myEntity);
    ResultActions responseEntity = processApiRequest(url, "GET", schoolname);
    responseEntity.andExpect(status().isOk());
  }

  private ResultActions processApiRequest(String api, String method, String content) {
    ResultActions response = null;
    try {
      switch (method) {
        case "GET":
          response = mockMvc.perform(get(api, content));
          break;
        case "POST":
          response = mockMvc.perform(post(api, content));
          break;
        default:
          fail("Method Not supported");
          break;
      }
    } catch (Exception e) {
      e.printStackTrace();
      fail();
    }
    return response;
  }

}
