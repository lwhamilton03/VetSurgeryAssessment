package integration;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.qa.VetSurgery.model.OwnerModel;
import com.qa.VetSurgery.repository.OwnerRepository;
import com.qa.mySpringBootDatabaseApp.model.MySpringBootDataModel;
import com.qa.mySpringBootDatabaseApp.repository.MySpringBootRepository;

@RunWith(SpringRunner.class)
public class IntegrationTest {

	@Autowired
	private MockMvc mvc; 
	
	@Autowired
	private OwnerRepository repository; 
	
	@Before
	public void clearDB()
	{
		repository.deleteAll();
	}
	
	//Testing the Get Requests
	@Test
	public void findingAndRetrievingPersonFromDatabase() throws Exception
		{
			repository.save(new OwnerModel("Mitch", "Narnia", "201"));
			mvc.perform(get("/api/owner").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$[0].name", is("Mitch")));
		}
}
