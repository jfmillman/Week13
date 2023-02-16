/**
 * 
 */
package com.promineotech.jeep.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.promineotech.jeep.controller.support.fetchJeepTestSupport;
import com.promineotech.jeep.entity.Jeep;
import com.promineotech.jeep.entity.JeepModel;

//this extends the junit framework so the junit is in control of the test, specify to use a web
//environment, and use random port so the tests dont run on top of each other
@SpringBootTest (webEnvironment = WebEnvironment.RANDOM_PORT)


class FetchJeepTest extends fetchJeepTestSupport{

  @Test
  void testThatJeepsAreReturnedWhenAValidModelAndTrimAreSupplied() {
    //Given: a valid model, trim, and URI
    JeepModel model = JeepModel.WRANGLER;
    String trim = "Sport";
    String uri = String.format("%s?model=%s&trim=%s", getBaseUri(), model, trim);
    
    //When: a connection is made to the URI
   ResponseEntity<Jeep> response = getRestTemplate().getForEntity(uri,Jeep.class);
    //check getRestTemplate 
 
   
    //Then: a valid success (OK - 200) status code is returned
   assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
   
  }

}
