/**
 * 
 */
package com.promineotech.jeep.controller;


import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import com.promineotech.jeep.controller.support.fetchJeepTestSupport;
import com.promineotech.jeep.entity.Jeep;
import com.promineotech.jeep.entity.JeepModel;

//this extends the junit framework so the junit is in control of the test, specify to use a web
//environment, and use random port so the tests dont run on top of each other
@SpringBootTest (webEnvironment = WebEnvironment.RANDOM_PORT)
@ActiveProfiles ("test")
//WEEK 14: SQL annotation with 2 scripts and it's going to run a test for us 
@Sql(scripts = {"classpath:flyway/migrations/V1.0__Jeep_Schema.sql", "classpath:flyway/migrations/V1.1__Jeep_Data.sql"},
config = @SqlConfig(encoding = "utf-8"))
class FetchJeepTest extends fetchJeepTestSupport{
  
  
  @Test
  void testThatJeepsAreReturnedWhenAValidModelAndTrimAreSupplied() {
    //Given: a valid model, trim, and URI
    JeepModel model = JeepModel.WRANGLER;
    String trim = "Sport";
    String uri = String.format("%s?model=%s&trim=%s", getBaseUri(), model, trim);
    
    //When: a connection is made to the URI
    //WEEK 14: modified test to return a list of Jeep instead of one Jeep
   ResponseEntity<List<Jeep>> response = getRestTemplate().exchange(uri, HttpMethod.GET, null, new ParameterizedTypeReference<>() {});
 
   
    //Then: a valid success (OK - 200) status code is returned
   assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
   
 
   //WEEK 14: And: the actual list returned is the same as the expected list
   //WEEK 14: buildExpected method is in fetchJeepTestSupport.java
   List<Jeep> expected = buildExpected ();
   assertThat(response.getBody()).isEqualTo(expected);
  }

}
