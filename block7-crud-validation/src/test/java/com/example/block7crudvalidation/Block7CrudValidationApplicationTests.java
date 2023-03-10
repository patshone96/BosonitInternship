package com.example.block7crudvalidation;

import com.example.block7crudvalidation.person.entity.Person;
import com.example.block7crudvalidation.person.infrastructure.dtos.PersonOutputDTOFull;
import com.example.block7crudvalidation.person.infrastructure.repository.PersonRepo;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.core.type.TypeReference;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class Block7CrudValidationApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private PersonRepo personRepo;


	@BeforeAll
	void insertData(){
		Person person  = new Person();
		person.setName("Patrick");
		person.setUsr("usrPat");

		personRepo.save(person);

	}


	@Test
	void testGetPerson() throws Exception {

		MvcResult result  = this.mockMvc.perform(get("/person/1")).andExpect(status().isOk()).andReturn();
		String content= result.getResponse().getContentAsString();

		PersonOutputDTOFull person = new ObjectMapper().readValue(content, new TypeReference<PersonOutputDTOFull>() {   }); // Use TypeReference to map the List.

		Assertions.assertNotNull(person);
		Assertions.assertEquals(person.getPerson_id(),1);
		Assertions.assertEquals(person.getName(),"Patrick");
		Assertions.assertEquals(person.getUsuario(),"usrPat");

	}

}
