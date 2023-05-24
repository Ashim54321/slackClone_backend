package com.project.workmanagemantSystem.resources;


import com.project.workmanagemantSystem.Responce.ApiResponse;
import com.project.workmanagemantSystem.domain.request.PasswordRequest;
import com.project.workmanagemantSystem.security.AuthenticationRequest;
import com.project.workmanagemantSystem.security.AuthenticationResponce;
import com.project.workmanagemantSystem.security.RegisterRequest;
import com.project.workmanagemantSystem.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthResource {
    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ApiResponse register(@RequestBody RegisterRequest request)  {
        return   authenticationService.register(request);
    }
    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponce> register(@RequestBody AuthenticationRequest request){
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }

    @GetMapping("/verify/{userCode}")
    public ResponseEntity<ApiResponse> verifyUser(@PathVariable UUID userCode){
        return ResponseEntity.ok(authenticationService.getUserVerified(userCode));
    }

    @PostMapping("/user/changePassword")
    public ResponseEntity<ApiResponse> changePassword(@RequestBody PasswordRequest passwordRequest){
        return ResponseEntity.ok(authenticationService.changePassword(passwordRequest));
    }
}
