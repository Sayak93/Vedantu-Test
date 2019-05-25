package com.example.vedantuBackend.cucumber.glue;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class AvengersStepDefinitions {

    @Autowired
    private TestRestTemplate restTemplate;
    private ResponseEntity<String> responseEntity;

    private static String VALID_AVENGER_REQUEST =
            "{\"avenger\": [{\n" +
                    "\"name\": \"IronMan\",\n" +
                    "\"rank\": \"1\",\n" +
                    "\"power\": \"mellatic robotic suits\"\n" +
                    "},\n" +
                    "{\n" +
                    "\"name\": \"Captain America\",\n" +
                    "\"rank\": \"2\",\n" +
                    "\"power\": \"chutiyapa\"\n" +
                    "},\n" +
                    "{\n" +
                    "\"name\": \"Thor\",\n" +
                    "\"rank\": \"3\",\n" +
                    "\"power\": \"electricity\"\n" +
                    "}\n" +
                    "]\n" +
                    "}" ;


    @Given("I am fury  and I want to add a new avenger")
    public void i_am_fury_and_I_want_to_add_a_new_avenger() {

    }

    @When("I provide name as Gullu and rank as {int} and power GOAT")
    public void i_provide_name_as_Gullu_and_rank_as_and_power_GOAT(Integer int1) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        List<MediaType> mediaTypes = new ArrayList<>();
        mediaTypes.add(MediaType.APPLICATION_JSON);
        headers.setAccept(mediaTypes);
        HttpEntity<String> entity = new HttpEntity<String>(VALID_AVENGER_REQUEST, headers);
        responseEntity = restTemplate.exchange("/avengers",HttpMethod.POST,entity, String.class);
        Assert.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());


    }

    @Then("Gullu becomes member of S.H.I.E.L.D")
    public void gullu_becomes_member_of_S_H_I_E_L_D() {
    }

}
