package org.zerock.controller;

import org.junit.Test;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import lombok.extern.log4j.Log4j;

@Log4j // 로그는 상속이 안된다.
public class TodoControllerTests extends AbstractControllerTests {
	@Test
	public void test1() throws Exception {
		log.info(mockMvc);
		
		mockMvc.perform(MockMvcRequestBuilders.post("/todo/add")
				.param("title", "Sample......")
				.param("complete", "true"));
	}
}
