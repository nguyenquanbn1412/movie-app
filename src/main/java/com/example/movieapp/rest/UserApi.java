package com.example.movieapp.rest;

import com.example.movieapp.model.request.*;
import com.example.movieapp.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api")
@RequiredArgsConstructor
public class UserApi {
    private final UserService userService;

    @PutMapping("/users/update-profile")
    ResponseEntity<?> updateProfile(@RequestBody UpdateProfileUserRequest request) {
        userService.updateProfile(request);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/users/update-password")
    ResponseEntity<?> updatePassword(@RequestBody UpdatePasswordRequest request) {
        userService.updatePassword(request);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/admin/users")
    ResponseEntity<?> createUser(@Valid @RequestBody CreateUserRequest request) {
        return ResponseEntity.ok(userService.createUser(request));
    }

    ///////////////
    @PutMapping("/admin/users/{id}")
    ResponseEntity<?> updateUser(@Valid @RequestBody UpdateUserRequest request, @PathVariable Integer id) {
        return ResponseEntity.ok(userService.updateUserFromAdmin(id, request));
    }

    @PutMapping("/admin/users/{id}/reset-password")
    ResponseEntity<?> resetPassword(@PathVariable Integer id) {
        userService.resetPasswordUserFromAdmin(id);
        return ResponseEntity.ok().build();
    }
}
