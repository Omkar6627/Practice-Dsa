package com.omkar.usermanagement.usermanage.Controller;

import com.omkar.usermanagement.usermanage.Model.SignInInput;
import com.omkar.usermanagement.usermanage.Model.SignUpOutput;
import com.omkar.usermanagement.usermanage.Model.User;
import com.omkar.usermanagement.usermanage.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    private UserService userService;


    @GetMapping("/home")
      public String homecontroller(){
        return "sucess";
    }


    @PostMapping("signup")
    public ResponseEntity<SignUpOutput> signup(@RequestBody @Validated User user) {


        return ResponseEntity.ok(userService.registerUser(user));
    }

    @PostMapping("/login")
    public ResponseEntity<String> signin(@RequestBody SignInInput signInInput) {

        return ResponseEntity.ok(userService.signInUser(signInInput));
    }

    @GetMapping("user/profile")
    public ResponseEntity<User> getUserProfile() {

        User user = userService.getCurrentUser();
        return ResponseEntity.ok(user);
    }

    @GetMapping("admin/{userId}")
    public ResponseEntity<User> getUser(@PathVariable Long userId) {

        User user = userService.getUserById(userId);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }



    @PatchMapping("admin/{userId}")
    public ResponseEntity<String> updateAttributes(@PathVariable Long userId, @RequestBody User user) {

        userService.updateUserAttributes(userId, user);
        return ResponseEntity.ok("User attributes updated successfully");
    }

    @DeleteMapping("admin/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable Long userId) {

        userService.deleteUser(userId);
        return ResponseEntity.ok("User deleted successfully");
    }
}
