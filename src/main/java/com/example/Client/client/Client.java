package com.example.Client.client;

import com.example.Client.address.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Client {
    private  int id;
    private  String name;
    private Address address;
    private  int age;
}
