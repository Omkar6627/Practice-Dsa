package com.omkar.usermanagement.usermanage.Service;

import com.omkar.usermanagement.usermanage.Model.User;
import com.omkar.usermanagement.usermanage.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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

    public void registerUser(User user) {
        // Implement user registration logic
        // You can save the user entity directly since the ID will be auto-generated
        userRepository.save(user);
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
}
