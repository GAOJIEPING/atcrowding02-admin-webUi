package com.atguigu.crowd.entity;


import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    private  String province;
    private  String city;
    private  String street;

    @Override
    public String toString() {
        return "Address{" +
                "province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                '}';
    }
}
