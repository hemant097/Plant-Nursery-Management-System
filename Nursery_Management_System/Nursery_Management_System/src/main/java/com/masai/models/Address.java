package com.masai.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Address {
Integer addressId;
String houseNo;
String colony;
String city;
String state;
Integer pinCode;

}
