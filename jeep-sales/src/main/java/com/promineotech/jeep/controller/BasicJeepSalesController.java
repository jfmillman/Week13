/**
 * 
 */
package com.promineotech.jeep.controller;

import java.util.List;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.jeep.entity.Jeep;

//Tells spring boot that this controller implements the Jeep controller
@RestController
public class BasicJeepSalesController implements JeepSalesController {

  @Override
  public List<Jeep> fetchJeeps(String model, String trim) {
    // TODO Auto-generated method stub
    return null;
  }

}
