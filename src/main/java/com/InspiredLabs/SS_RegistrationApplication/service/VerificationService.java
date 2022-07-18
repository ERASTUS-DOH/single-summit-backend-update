package com.InspiredLabs.SS_RegistrationApplication.service;

import com.InspiredLabs.SS_RegistrationApplication.dto.Participant;
import com.InspiredLabs.SS_RegistrationApplication.exception.InvalidVerificationCodeException;
import com.InspiredLabs.SS_RegistrationApplication.repository.ParticipantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class VerificationService {

    private final ParticipantRepository participantRepository;

    @Autowired
    public VerificationService(ParticipantRepository participantRepository){
        this.participantRepository = participantRepository;
    }

    public Participant verify(String verificationCode) throws InvalidVerificationCodeException {
//        Optional<Participant> participant = this.participantRepository.findByVerificationCode(verificationCode);
   if(this.participantRepository.findByVerificationCode(verificationCode) != null){
       this.participantRepository.verifyParticipant(true, verificationCode);
       return this.participantRepository.findByVerificationCode(verificationCode);
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
}
