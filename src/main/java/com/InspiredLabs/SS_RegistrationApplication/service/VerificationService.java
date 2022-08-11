package com.InspiredLabs.SS_RegistrationApplication.service;

import com.InspiredLabs.SS_RegistrationApplication.dto.Participant;
import com.InspiredLabs.SS_RegistrationApplication.exception.InvalidVerificationCodeException;
import com.InspiredLabs.SS_RegistrationApplication.exception.UserAlreadyVerifiedException;
import com.InspiredLabs.SS_RegistrationApplication.repository.ParticipantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VerificationService {

    private final ParticipantRepository participantRepository;

    @Autowired
    public VerificationService(ParticipantRepository participantRepository){
        this.participantRepository = participantRepository;
    }


    public void verify(String verificationCode) throws InvalidVerificationCodeException, UserAlreadyVerifiedException {
        Participant participant = this.participantRepository.findByVerificationCode(verificationCode);
   if(participant != null){
       if(!participant.isVerificationStatus()){
           this.participantRepository.verifyParticipant(true, verificationCode);
           this.participantRepository.findByVerificationCode(verificationCode);
       }
       else throw new UserAlreadyVerifiedException("Participant Already Verified");
   }
   else {
            throw new InvalidVerificationCodeException("VerificationCode does not exist");
        }
    }

    public List<Participant> getAllVerifiedParticipants(){
        return this.participantRepository.getAllVerifiedParticipants();
    }

    public List<Participant> getRegisteredParticipants(){
        return this.participantRepository.findAll();
    }

    public void verifyOnPrem(String verificationCode) {
    }
}
