package com.muhammet.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Customer {
    Integer id;
    String first_name;
    String last_name;
    String city;
    Integer age;
    String gender;
    String email;
    String phone;
    Long create_at;
    Long update_at;
    Integer state;
}
