package com.alfredo.nba.NBASports.Controller;

import com.alfredo.nba.NBASports.Models.LoginRequest;
import com.alfredo.nba.NBASports.Models.LoginResponse;
import com.alfredo.nba.NBASports.Service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Access-Control-Allow-Origin", "*");

        LoginResponse loginResponse = authService.login(request);

        return ResponseEntity.status(HttpStatus.OK).headers(responseHeaders).body(loginResponse);
    }
}
