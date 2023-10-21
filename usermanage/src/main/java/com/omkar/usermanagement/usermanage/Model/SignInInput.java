package com.omkar.usermanagement.usermanage.Model;




import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignInInput {


    private String email;
    private String password;
}
