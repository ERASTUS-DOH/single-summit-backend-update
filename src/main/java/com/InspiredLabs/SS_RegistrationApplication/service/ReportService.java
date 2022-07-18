package com.InspiredLabs.SS_RegistrationApplication.service;

import com.InspiredLabs.SS_RegistrationApplication.dto.Participant;
import com.InspiredLabs.SS_RegistrationApplication.repository.ParticipantRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.InspiredLabs.SS_RegistrationApplication.utils.Constant.*;

@Service
public class ReportService {
    private final ParticipantRepository participantRepository;

    public ReportService(ParticipantRepository participantRepository){
        this.participantRepository = participantRepository;
    }

    public List<Participant> getAllRegisteredParticipants(){
        return this.participantRepository.findAll();
    }

    public List<Participant> getAllVerifiedParticipants(){
        return this.participantRepository.getAllVerifiedParticipants();
    }

    public Map<String, Integer> getRatioOfMembersToNonMembers(){
        List<Participant> members = this.participantRepository.getAllMembers();
        List<Participant> nonMembers = this.participantRepository.getAllNonMembers();

        Map<String, Integer> ratio = new HashMap<>();
        ratio.put(MEMBERSHIP_COUNT, members.size());
        ratio.put(NON_MEMBERSHIP_COUNT, nonMembers.size());

        return ratio;
    }


    public List<Participant> getAllMembers(){
        return this.participantRepository.getAllMembers();
    }

    public List<Participant> getAllNonMembers(){
        return this.participantRepository.getAllNonMembers();
    }

    public Map<String, Integer> getRatioOfMaleToFemale(){
        List<Participant> male = this.participantRepository.getParticipantByGender(MALE);
        List<Participant> female = this.participantRepository.getParticipantByGender(FEMALE);
        Map<String, Integer> ratio = new HashMap<>();

        ratio.put(MALE, male.size());
        ratio.put(FEMALE, female.size());
        return ratio;
    }

    public List<Participant> getAllMaleParticipants(){
        return this.participantRepository.getParticipantByGender(MALE);
    }


    public List<Participant> getAllFemaleParticipants(){
        return this.participantRepository.getParticipantByGender(FEMALE);
    }
}
