package com.screen.springboot.rest.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.screen.springboot.rest.example.student.App;
import com.screen.springboot.rest.example.student.controller.StudentController;
import com.screen.springboot.rest.example.student.dao.Student;
import com.screen.springboot.rest.example.student.dao.StudentRepository;
import lombok.SneakyThrows;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.ServletContext;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@RunWith(SpringRunner.class)
// @ContextConfiguration(classes = {App.class})
@SpringBootTest(classes = StudentController.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@SpringJUnitConfig({App.class, StudentController.class, StudentRepository.class})
@WebAppConfiguration
public class SpringBootRestExampleStudentTests {

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private TestRestTemplate testRestTemplate;

	@Autowired
    private StudentController studentController;

	@MockBean
	private StudentRepository studentRepository;

	@Autowired
	private WebApplicationContext webApplicationContext;

	private MockMvc mockMvc; // for @WebMvcTest - different test class

	@BeforeEach
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
	}

	@Test
	public void contextLoads() {
		assertThat(studentController).isNotNull();
	}

	@Test
	public void webContextLoads() {
		ServletContext servletContext = webApplicationContext.getServletContext();
		Assertions.assertTrue(servletContext instanceof MockServletContext);
		Assertions.assertNotNull(servletContext);
		Assertions.assertNotNull(webApplicationContext.getBean("studentController"));
	}

	@SneakyThrows
	@Test
	public void testPostStudent() {
		Student testStudent = Student.builder().id(1L).name("Pavel").passportNumber("324").build();
		String postRequestJsonString = objectMapper.writeValueAsString(testStudent);
		this.mockMvc.perform(post("/students").contentType(MediaType.APPLICATION_JSON).content(postRequestJsonString))
				.andExpect(status().isOk());
	}

}
