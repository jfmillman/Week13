/**
 * 
 */
package com.promineotech.jeep.controller.support;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;
import com.promineotech.jeep.entity.Jeep;
import com.promineotech.jeep.entity.JeepModel;

//WEEK 14: the expected list of Jeep
//WEEK 14: built all of the objects for Wrangler from JeepData.sql
public class fetchJeepTestSupport extends BaseTest{
  protected List<Jeep> buildExpected() {
    List<Jeep> list = new LinkedList<>();
    
    list.add(Jeep.builder()
        .modelId(JeepModel.WRANGLER)
        .trimLevel("Sport")
        .numDoors(2)
        .wheelSize(17)
        .basePrice(new BigDecimal("28475.00"))
        .build());
    
    list.add(Jeep.builder()
        .modelId(JeepModel.WRANGLER)
        .trimLevel("Sport")
        .numDoors(4)
        .wheelSize(17)
        .basePrice(new BigDecimal("31975.00"))
        .build());
    
    
    
    return list;
  }
  
}


