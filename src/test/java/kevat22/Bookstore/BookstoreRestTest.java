package kevat22.Bookstore;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
public class BookstoreRestTest {
	
	@Autowired
	private WebApplicationContext webAppContext;
	
	private MockMvc mockMvc;
	
	@Before
	public void setUp() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(webAppContext).build();
	}
	
	@Test
	public void statusOk() throws Exception {
		mockMvc.perform(get("/books")).andExpect(status().isOk());
	}
	
	@Test
	public void responseTypeApplicationJson() throws Exception {
		mockMvc.perform(get("/books"))
		.andExpect(content().contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk());
	}
	
	@Test
	public void apiStatusOk() throws Exception{
		mockMvc.perform(get("/api/books")).andExpect(status().isOk());
	}

}
