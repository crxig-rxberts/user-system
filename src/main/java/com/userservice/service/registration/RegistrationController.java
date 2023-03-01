package com.userservice.service.registration;

import com.userservice.service.response.Response;
import com.userservice.service.registration.token.ConfirmationTokenService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/registration")
@AllArgsConstructor
@Slf4j
public class RegistrationController {

    private final RegistrationService registrationService;
    private final ConfirmationTokenService confirmationTokenService;

    @PostMapping
    public ResponseEntity<Response> register(@RequestBody RegistrationRequest request) {
        return registrationService.register(request);
    }

    @GetMapping(path = "confirm")
    public void confirm(@RequestParam("token") String token) {
        confirmationTokenService.confirmToken(token);
    }
}
