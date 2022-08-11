package com.InspiredLabs.SS_RegistrationApplication.controller;

import com.InspiredLabs.SS_RegistrationApplication.dto.SuccessMessage;
import com.InspiredLabs.SS_RegistrationApplication.dto.VerificationSuccess;
import com.InspiredLabs.SS_RegistrationApplication.dto.request.InHouseRegistrationDetails;
import com.InspiredLabs.SS_RegistrationApplication.dto.request.RegistrationDetails;
import com.InspiredLabs.SS_RegistrationApplication.exception.InvalidUserException;
import com.InspiredLabs.SS_RegistrationApplication.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("SSRegistration/api/v1")
public class RegistrationController {

    public RegistrationService registrationService;

    @Autowired
    public RegistrationController(RegistrationService registrationService){
        this.registrationService = registrationService;
    }

    @PostMapping("/register")
    public ResponseEntity<SuccessMessage> participantRegistration(@RequestBody @Valid RegistrationDetails registrationPayload) throws IOException, InterruptedException, InvalidUserException {
        registrationService.registerParticipant(registrationPayload);
        SuccessMessage successMessage = new SuccessMessage();
        successMessage.setMessage("Registration Successful");
        successMessage.setHttpStatus(HttpStatus.OK);
        return new ResponseEntity<>(successMessage,HttpStatus.OK);
    }


    @PostMapping("/register/inHouse")
    public ResponseEntity<VerificationSuccess> participantInHouseRegistration(@RequestBody @Valid InHouseRegistrationDetails registrationDetails) throws InvalidUserException {
       String verificationPin =  registrationService.inHouseRegistration(registrationDetails);
        VerificationSuccess vSuccess = new VerificationSuccess();
        vSuccess.setHttpStatus(HttpStatus.OK);
        vSuccess.setVerificationCode(verificationPin);
        vSuccess.setMessage("Registration Successful");
        return new ResponseEntity<>(vSuccess, HttpStatus.OK);
    }


}
