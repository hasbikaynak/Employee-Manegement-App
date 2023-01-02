package com.ema.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {
    @Size(max = 50)
    @NotBlank(message = "Please provide a first name")
    private String firstName;

    @Size(max = 50)
    @NotBlank(message = "Please provide a last name")
    private String lastName;

    @Email(message = "Please provide a valid email")
    @Size(min = 5,max = 80)
    private String email;
}
