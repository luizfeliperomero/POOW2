package com.example.Client.address;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    private int id;
    private String street;
    private String number;
    private String cep;
    private String neighbourhood;
    private String city;
}
