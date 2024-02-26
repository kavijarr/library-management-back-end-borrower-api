package edu.icet.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    Long id;
    String firstName;
    String lastName;
    String userName;
    String email;
    String address;
    String address2;
    String country;
    String phoneNumber;
}
