package com.omkar.usermanagement.usermanage.Service;

import com.omkar.usermanagement.usermanage.Model.SignInInput;
import com.omkar.usermanagement.usermanage.Model.SignUpOutput;
import com.omkar.usermanagement.usermanage.Model.User;
import com.omkar.usermanagement.usermanage.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getCurrentUser() {
 
         UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
         String username = userDetails.getUsername();
         return userRepository.findByUsername(username);
     
    }
    public BCryptPasswordEncoder PasswordEncrypter(){
        return new BCryptPasswordEncoder();
    }


    public User getUserById(Long userId) {
        Optional<User> user = userRepository.findById(userId);
        return user.orElse(null);
    }

    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public SignUpOutput registerUser(User user) {
        boolean signUpStatus = true;
        String signUpStatusMessage = null;

        String newEmail = user.getEmail();

        if(newEmail == null)
        {
            signUpStatusMessage = "Invalid email";
            signUpStatus = false;
            return new SignUpOutput(signUpStatus,signUpStatusMessage);
        }


        User existingUser = userRepository.findFirstByEmail(newEmail);

        if(existingUser != null)
        {
            signUpStatusMessage = "Email already registered!!!";
            signUpStatus = false;
            return new SignUpOutput(signUpStatus,signUpStatusMessage);
        }


        try {
            String encryptedPassword = PasswordEncrypter().encode(user.getPassword());


            user.setPassword(encryptedPassword);
            userRepository.save(user);

            return new SignUpOutput(signUpStatus, "User registered successfully!!!");
        }
        catch(Exception e)
        {
            signUpStatusMessage = "Internal error occurred during sign up";
            signUpStatus = false;
            return new SignUpOutput(signUpStatus,signUpStatusMessage);
        }
    }



    public void deleteUser(Long userId) {
        // Implement logic to delete a user
        userRepository.deleteById(userId);
    }

    public void updateUserAttributes(Long userId, User updatedAttributes) {
        Optional<User> userOptional = userRepository.findById(userId);

        if (userOptional.isPresent()) {
            User user = userOptional.get();

            // Check if updatedAttributes contains a new first name
            if (updatedAttributes.getFirstName() != null) {
                user.setFirstName(updatedAttributes.getFirstName());
            }

            // Check if updatedAttributes contains a new last name
            if (updatedAttributes.getLastName() != null) {
                user.setLastName(updatedAttributes.getLastName());
            }

            // Save the updated user to the database
            userRepository.save(user);
    }
}

    public User findByEmail(String email) {
        return userRepository.findFirstByEmail(email);
    }

    public String signInUser(SignInInput signInInput) {
        String signtusMessage = null;

        String signInEmail = signInInput.getEmail();

        if(signInEmail == null)
        {
            signtusMessage = "Invalid email";
            return signtusMessage;


        }


        User existingUser = userRepository.findFirstByEmail(signInEmail);

        if(existingUser == null)
        {
            signtusMessage = "Email not registered!!!";
            return signtusMessage;

        }


        try {
            String encryptedPassword = PasswordEncrypter().encode(signInInput.getPassword());
            if(existingUser.getPassword().equals(encryptedPassword))
            {



                return "kitne baar sign in krega";
            }
            else {
                signtusMessage = "Invalid credentials!!!";
                return signtusMessage;
            }
        }
        catch(Exception e)
        {
            signtusMessage = "Internal error occurred during sign in";
            return signtusMessage;
        }
    }
}
