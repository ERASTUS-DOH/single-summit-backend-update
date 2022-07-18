package com.InspiredLabs.SS_RegistrationApplication.controller;

import com.InspiredLabs.SS_RegistrationApplication.dto.request.RegistrationDetails;
import com.InspiredLabs.SS_RegistrationApplication.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("SSRegistration/api/v1")
public class ParticipantController {

    public RegistrationService registrationService;

    @Autowired
    public ParticipantController(RegistrationService registrationService){
        this.registrationService = registrationService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> participantRegistration(@RequestBody @Valid RegistrationDetails registrationPayload){
        registrationService.registerParticipant(registrationPayload);
        return new ResponseEntity<>("Registration Successful",HttpStatus.OK);
    }
}
