/**
 * 
 */
package com.promineotech.jeep.entity;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @author jessicamillman
 *
 */
//WEEK 14: copied this info from the create table method in Jeep Schema
//WEEK 14: @data will give us the getters and setters, the toString to make sure it prints nicely, and the hash code
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Jeep {
  private Long modelPk;
  private JeepModel modelId;
  private String trimLevel;
  private int numDoors;
  private int wheelSize;
  private BigDecimal basePrice;

}


