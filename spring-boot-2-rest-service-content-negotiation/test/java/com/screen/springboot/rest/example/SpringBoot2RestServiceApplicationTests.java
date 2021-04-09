package com.screen.springboot.rest.example;

import com.screen.springboot.rest.example.student.StudentResource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = StudentResource.class)
@ContextConfiguration
public class SpringBoot2RestServiceApplicationTests {

	@Autowired
	StudentResource studentResource;

	@Test
	public void contextLoads() {
		assertThat(studentResource).isNotNull();
	}

}
