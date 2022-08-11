package com.InspiredLabs.SS_RegistrationApplication.service;

import com.InspiredLabs.SS_RegistrationApplication.dto.Participant;
import com.InspiredLabs.SS_RegistrationApplication.dto.PublicationAvenue;
import com.InspiredLabs.SS_RegistrationApplication.repository.ParticipantRepository;
import com.InspiredLabs.SS_RegistrationApplication.repository.PublicationDataRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.InspiredLabs.SS_RegistrationApplication.utils.Constant.*;

@Service
public class ReportService {
    private final ParticipantRepository participantRepository;
    private final PublicationDataRepository publicationDataRepository;

    public ReportService(ParticipantRepository participantRepository, PublicationDataRepository publicationDataRepository){
        this.participantRepository = participantRepository;
        this.publicationDataRepository = publicationDataRepository;
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

    public Map<String, Integer> getSocialMediaReport() {
        Map<String, Integer> socialMediaReport = new HashMap<>();
        Integer facebookReport = this.publicationDataRepository.facebookData().size();
        Integer twitterReport = this.publicationDataRepository.twitterData().size();
        Integer friendInviteReport = this.publicationDataRepository.friendData().size();
        Integer televisionAdDataReport = this.publicationDataRepository.televisionAdData().size();
        Integer smsDataReport = this.publicationDataRepository.SMSData().size();
        Integer billBoardDataReport = this.publicationDataRepository.billBoardData().size();
        Integer sunnyFmDataReport = this.publicationDataRepository.sunnyFmData().size();
        Integer sweetMelodiesDataReport = this.publicationDataRepository.sweetMelodiesData().size();
        Integer churchAnnouncementDataReport = this.publicationDataRepository.churchAnnouncementData().size();

        socialMediaReport.put("facebookReport", facebookReport);
        socialMediaReport.put("twitterReport", twitterReport);
        socialMediaReport.put("friendInvitationReport", friendInviteReport);
        socialMediaReport.put("televisionAdDataReport", televisionAdDataReport);
        socialMediaReport.put("smsDataReport", smsDataReport);
        socialMediaReport.put("billBoardDataReport", billBoardDataReport);
        socialMediaReport.put("sunnyFmDataReport", sunnyFmDataReport);
        socialMediaReport.put("sweetMelodiesDataReport", sweetMelodiesDataReport);
        socialMediaReport.put("churchAnnouncementDataReport", churchAnnouncementDataReport);

        return socialMediaReport;
    }
}
