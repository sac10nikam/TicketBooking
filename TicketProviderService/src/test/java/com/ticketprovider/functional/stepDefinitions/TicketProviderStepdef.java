package com.ticketprovider.functional.stepDefinitions;

import static com.shazam.shazamcrest.MatcherAssert.assertThat;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.server.LocalServerPort;

import com.ticketprovider.data.TicketDao;
import com.ticketprovider.data.TicketRepository;
import com.ticketprovider.functional.FunctionalSpringTestRunner;
import com.ticketprovider.service.Ticket;
import com.ticketprovider.web.TicketView;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class TicketProviderStepdef extends FunctionalSpringTestRunner {

	@Autowired
	private  TicketRepository ticketRepository;
	
	Response responseGet ;
	Response responsePost ;
	TicketView ticketView;
	Integer  ticketId;
	@LocalServerPort
	protected int port;
	
	@Before
    public void setUp() {
    	String baseUrl="http://localhost:" +port +"/ticketprovider-service";
    	System.out.println("baseurl"+baseUrl);
		RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder().setBaseUri(baseUrl);
    	RestAssured.requestSpecification = requestSpecBuilder.build();
    }
	
	@When("We call TicketProvider findAll resource")
	public void we_call_TicketProvider_findAll_resource() {	  
		responseGet = given().get("/tickets");
	}

	@Then("will get status code {int}")
	public void will_get_status_code(Integer int1) {
	assertThat(responseGet.statusCode(), is(200));
	}
	
	
	
	  @Given("^I create a Ticket with following configuration$") 
	  public void  i_create_a_company_with_following_configuration(DataTable ticketDataTable)
	  throws Throwable {
	  
	  //Need to Normilaze Below Code Like Direct DataTable to Pojo Map
	  List<Map<String, String>> list = ticketDataTable.asMaps(String.class,
	  String.class);
	  
	  System.out.println(Integer.valueOf(list.get(0).get("movieId")));
	  System.out.println(list.get(0).get("ticketConsumerType"));
	  ticketView=TicketView.builder()
	  .movieId(Integer.valueOf(list.get(0).get("movieId")))
	  .theaterId(Integer.valueOf(list.get(0).get("theaterId")))
	  .numberOfTickets(Integer.valueOf(list.get(0).get("numberOfTickets")))
	  .price(Integer.valueOf(list.get(0).get("price")))
	  .ticketConsumerType(list.get(0).get("ticketConsumerType")) .build();
	  
	  System.out.println(ticketView); }
	  
	  @When("^We will Call TicketProvider createTicketResource$") 
	  public void  we_will_Call_TicketProvider_createTicketResource() throws Throwable {
	  responsePost = given() .contentType(ContentType.JSON)
	  .accept(ContentType.JSON) .body(ticketView).when() .post("/tickets");
	  ticketId=Integer.parseInt(responsePost.getBody().asString());
	  
	  }
	  
	  @Then("^we will get status code (\\d+) and will check ticketConsumerType \"([^\"]*)\"$"
	  ) public void we_will_get_status_code_and_will_check_ticketConsumerType(int
	  responseCode, String exceptedTicketConsumerType) throws Throwable {
	    
		   TicketDao savedTicketDao = ticketRepository.findById(ticketId).get();		  
		   assertThat(responsePost.statusCode(), is(200));
		   assertThat(savedTicketDao.getTicketConsumerType(), is(exceptedTicketConsumerType));		  
		   ticketRepository.delete(savedTicketDao);
	  }
	 
	
	
}
