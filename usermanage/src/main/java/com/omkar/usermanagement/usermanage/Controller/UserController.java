package com.omkar.usermanagement.usermanage.Controller;

import com.omkar.usermanagement.usermanage.Model.User;
import com.omkar.usermanagement.usermanage.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody @Validated User user) {

        userService.registerUser(user);
        return ResponseEntity.ok("User registered successfully");
    }

    @PostMapping("/signin")
    public ResponseEntity<String> signin(@RequestBody User user) {

        return ResponseEntity.ok("User authenticated successfully");
    }

    @GetMapping("/profile")
    @Secured("ROLE_USER")
    public ResponseEntity<User> getUserProfile() {

        User user = userService.getCurrentUser();
        return ResponseEntity.ok(user);
    }

    @GetMapping("/{userId}")
    @Secured("ROLE_ADMIN")
    public ResponseEntity<User> getUser(@PathVariable Long userId) {

        User user = userService.getUserById(userId);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }



    @PatchMapping("/{userId}")
    @Secured("ROLE_ADMIN")
    public ResponseEntity<String> updateAttributes(@PathVariable Long userId, @RequestBody User user) {

        userService.updateUserAttributes(userId, user);
        return ResponseEntity.ok("User attributes updated successfully");
    }

    @DeleteMapping("/{userId}")
    @Secured("ROLE_ADMIN")
    public ResponseEntity<String> deleteUser(@PathVariable Long userId) {
        // This endpoint is accessible only to users with the ROLE_ADMIN role.
        // If the user is authorized, delete the user record.
        userService.deleteUser(userId);
        return ResponseEntity.ok("User deleted successfully");
    }
}
