/**
 * 
 */
package com.promineotech.jeep.service;

import java.util.List;
import com.promineotech.jeep.entity.Jeep;


//WEEK 14: fetchJeeps used in Jeep sales to fetch a list of Jeeps
public interface JeepSalesService {

  List<Jeep> fetchJeeps(String model, String trim);

}
