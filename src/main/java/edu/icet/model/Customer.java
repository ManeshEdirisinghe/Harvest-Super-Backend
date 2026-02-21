package edu.icet.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    private String id;
    private String title;
    private String name;
    private Date DOB;
    private Double salary;
    private String address;
    private String city;
    private String province;
    private String postalCode;


}
