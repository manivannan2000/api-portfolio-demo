package com.storepoints.apiportfolio;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.storepoints.apiportfolio.domain.Advisor;
import com.storepoints.apiportfolio.domain.AdvisorRepository;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ApiPortfolioApplication.class)
@WebAppConfiguration
public class ModelsControllerTest {
	
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext wac;
    
    
    @Autowired
	private AdvisorRepository repository;


    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

	@Test
    public void testAcceptValidPutData() throws Exception {
		
//		repository.save(new Advisor("test1","test1"));
		
		Page<Advisor> advisors= repository.findAll(PageRequest.of(0, 1));
		
        this.mockMvc.perform(put("/api/v1/advisor/"+advisors.getContent().get(0).getAdvisorId()+"/model")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(testPayload()))
                .andExpect(status().isOk());
		
	    }
	
	@Test
    public void testInvalidAdvisorInPutData() throws Exception {
		
		
	// passing advisorId value as wrong data (xyz) and testing negative test case.	
      this.mockMvc.perform(put("/api/v1/advisor/xyz/model")
      .contentType(MediaType.APPLICATION_JSON_UTF8)
      .content(testPayload()))
      .andExpect(status().isNotFound());

	}
	
	@Test
    public void testInvalidAllocationTotalPercentage() throws Exception {

		Page<Advisor> advisors= repository.findAll(PageRequest.of(0, 1));
		
		// passing test payload allocations total is 90 instead of 100.	
       this.mockMvc.perform(put("/api/v1/advisor/"+advisors.getContent().get(0).getAdvisorId()+"/model")
      .contentType(MediaType.APPLICATION_JSON_UTF8)
      .content(testPayloadWithInvalidAllocationsTotal()))
      .andExpect(status().isBadRequest());

	}
	
	
	
	private String testPayload(){
		return "{" +
                "\"name\":\"example model 1\","+
                "\"description\":\"example model with tech stocks\","+
                "\"cashHoldingPercentage\":10,"+
                "\"driftPercentage\":5,"+
                "\"createdOn\":\"2017-03-01\","+
                "\"modelType\":\"TAXABLE\","+
                "\"rebalanceFrequency\":\"QUARTERLY\","+
                "\"assetAllocations\":["+
                                    "{"+
                                       "\"symbol\":\"AAPL\","+
                                       "\"percentage\":30"+
                                    "},"+
                                    "{"+
                                       "\"symbol\":\"GOOG\","+
                                       "\"percentage\":20"+
                                    "},"+
                                    "{"+
                                       "\"symbol\":\"IBM\","+
                                       "\"percentage\":15"+
                                    "},"+
                                    "{"+
                                       "\"symbol\":\"FB\","+
                                       "\"percentage\":25"+
                                    "}"+
                                 "]"+
                "}";
	}
	
	private String testPayloadWithInvalidAllocationsTotal(){
		return "{" +
                "\"name\":\"example model 1\","+
                "\"description\":\"example model with tech stocks\","+
                "\"cashHoldingPercentage\":10,"+
                "\"driftPercentage\":5,"+
                "\"createdOn\":\"2017-03-01\","+
                "\"modelType\":\"TAXABLE\","+
                "\"rebalanceFrequency\":\"QUARTERLY\","+
                "\"assetAllocations\":["+
                                    "{"+
                                       "\"symbol\":\"AAPL\","+
                                       "\"percentage\":20"+
                                    "},"+
                                    "{"+
                                       "\"symbol\":\"GOOG\","+
                                       "\"percentage\":20"+
                                    "},"+
                                    "{"+
                                       "\"symbol\":\"IBM\","+
                                       "\"percentage\":15"+
                                    "},"+
                                    "{"+
                                       "\"symbol\":\"FB\","+
                                       "\"percentage\":25"+
                                    "}"+
                                 "]"+
                "}";
	}	
}
