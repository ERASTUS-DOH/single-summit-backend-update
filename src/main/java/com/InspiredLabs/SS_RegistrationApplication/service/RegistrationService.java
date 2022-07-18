package com.InspiredLabs.SS_RegistrationApplication.service;

import com.InspiredLabs.SS_RegistrationApplication.dto.Participant;
import com.InspiredLabs.SS_RegistrationApplication.dto.request.RegistrationDetails;
import com.InspiredLabs.SS_RegistrationApplication.repository.ParticipantRepository;
import com.InspiredLabs.SS_RegistrationApplication.utils.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class RegistrationService {
private static final Logger LOGGER = Logger.getLogger(RegistrationService.class.getName());

    private final QRCodeService qrCodeService;

    private final ParticipantRepository participantRepository;

    @Autowired
    public RegistrationService(QRCodeService qrCodeService, ParticipantRepository participantRepository){
        this.qrCodeService = qrCodeService;
        this.participantRepository = participantRepository;
    }

    public void registerParticipant(RegistrationDetails details) {
        Participant participant = new Participant();
        participant.firstName = details.firstName;
        participant.lastName = details.lastName;
        participant.email = details.email;
        participant.telephone = details.telephone;
        participant.gender = details.gender;
        participant.memberShipStatus = details.membershipStatus;
        participant.firstTimerStatus = details.firstTimerStatus;
        participant.publicityAvenue = details.publicityAvenue;
        participant.verificationCode = Constant.uniqueCodeGenerator();
        participant.verificationStatus = false;

        LOGGER.info(participant.toString());

        try{
            LOGGER.info("Image creation started..........");
            qrCodeService.generateQRCode(participant.verificationCode);
            LOGGER.info("image created successfully");
        }catch (Exception e){
            e.printStackTrace();
        }


    }
}
