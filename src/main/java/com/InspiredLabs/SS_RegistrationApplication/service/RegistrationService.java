package com.InspiredLabs.SS_RegistrationApplication.service;

import com.InspiredLabs.SS_RegistrationApplication.dto.Participant;
import com.InspiredLabs.SS_RegistrationApplication.dto.PublicationAvenue;
import com.InspiredLabs.SS_RegistrationApplication.dto.PublicationData;
import com.InspiredLabs.SS_RegistrationApplication.dto.request.InHouseRegistrationDetails;
import com.InspiredLabs.SS_RegistrationApplication.dto.request.RegistrationDetails;
import com.InspiredLabs.SS_RegistrationApplication.exception.InvalidUserException;
import com.InspiredLabs.SS_RegistrationApplication.repository.ParticipantRepository;
import com.InspiredLabs.SS_RegistrationApplication.repository.PublicationDataRepository;
import com.InspiredLabs.SS_RegistrationApplication.service.fileUpload.FileUploadService;
import com.InspiredLabs.SS_RegistrationApplication.utils.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.logging.Logger;

import static com.InspiredLabs.SS_RegistrationApplication.utils.Constant.IMAGE_NAME;
import static com.InspiredLabs.SS_RegistrationApplication.utils.Constant.VERIFICATION_CODE;

@Service
public class RegistrationService {
private static final Logger LOGGER = Logger.getLogger(RegistrationService.class.getName());

    private final QRCodeService qrCodeService;

    private final ParticipantRepository participantRepository;

    private final PublicationDataRepository publicationDataRepository;

    private final EmailService emailService;

    private final FileUploadService fileUploadService;

    @Autowired
    public RegistrationService(QRCodeService qrCodeService, ParticipantRepository participantRepository, EmailService emailService, FileUploadService fileUploadService, PublicationDataRepository publicationDataRepository){
        this.qrCodeService = qrCodeService;
        this.participantRepository = participantRepository;
        this.emailService = emailService;
        this.fileUploadService = fileUploadService;
        this.publicationDataRepository = publicationDataRepository;
    }

    public void registerParticipant(RegistrationDetails details) throws IOException, InterruptedException, InvalidUserException {

        Map<String, String> codes = getImageAndVerificationCode();

        Participant participant = new Participant();
        participant.setFirstName(details.getFirstName());
        participant.setLastName(details.getLastName());
        participant.setEmail(details.getEmail());
        participant.setTelephone(details.getTelephone());
        participant.setGender(details.getGender());
        participant.setMemberShipStatus(details.isMembershipStatus());
        participant.setFirstTimerStatus(details.isFirstTimerStatus());
        participant.setVerificationCode(codes.get(VERIFICATION_CODE));
        participant.setVerificationStatus(false);
        participant.setImage_name(codes.get(IMAGE_NAME));

        //verify if user already exist with the same mail:
        Optional<Participant> optionalParticipant = this.participantRepository.getParticipantByEmail(participant.email);
        if(optionalParticipant.isPresent()){
            throw new InvalidUserException("User with email "+ participant.email + " already exist");
        }

        try{
            LOGGER.info("QR-Code generation started..........");
            qrCodeService.generateQRCode(codes);
            LOGGER.info("QR-Code generated successfully");
        }catch (Exception e){
            e.printStackTrace();
        }

        LOGGER.info("fileUpload");
        fileUploadService.upload(participant.image_name);
        LOGGER.info("Upload successful");

        LOGGER.info(participant.toString());
        LOGGER.info("Sending out email");
        emailService.sendEmail(participant);

        this.participantRepository.save(participant);

        PublicationAvenue publicationAvenue = new PublicationAvenue();
        publicationAvenue.setFaceBook(details.getPublicationData().isFaceBook());
        publicationAvenue.setTwitter(details.getPublicationData().isTwitter());
        publicationAvenue.setFriend(details.getPublicationData().isFriend());
        publicationAvenue.setTelevisionAd(details.getPublicationData().isTelevisionAd());
        publicationAvenue.setSMS(details.getPublicationData().isSMS());
        publicationAvenue.setBillboard(details.getPublicationData().isBillboard());
        publicationAvenue.setSunnyFm(details.getPublicationData().isSunnyFm());
        publicationAvenue.setSweetMelodies(details.getPublicationData().isSweetMelodies());
        publicationAvenue.setChurchAnnouncement(details.getPublicationData().isChurchAnnouncement());

        Optional<Participant> participantOptional = this.participantRepository.getParticipantByEmail(participant.email);
        participantOptional.ifPresent(value -> publicationAvenue.setParticipantId(value.getId()));
        publicationDataRepository.save(publicationAvenue);
   }

    public String inHouseRegistration(InHouseRegistrationDetails registrationDetails) throws InvalidUserException {
        String verificationPin = getVerificationPin();
        Participant participant = new Participant();
        participant.setFirstName(registrationDetails.getFirstName());
        participant.setLastName(registrationDetails.getLastName());
        participant.setEmail(registrationDetails.getEmail());
        participant.setTelephone(registrationDetails.getTelephone());
        participant.setGender(registrationDetails.getGender());
        participant.setMemberShipStatus(registrationDetails.isMembershipStatus());
        participant.setFirstTimerStatus(registrationDetails.isFirstTimerStatus());
        participant.setVerificationStatus(false);
        participant.setVerificationCode(verificationPin);

        Optional<Participant> optionalParticipant = this.participantRepository.getParticipantByEmail(participant.email);
        if(optionalParticipant.isPresent()){
            throw new InvalidUserException("User with email "+ participant.email + " already exist");
        }

        this.participantRepository.save(participant);

        PublicationAvenue publicationAvenue = new PublicationAvenue();
        publicationAvenue.setFaceBook(registrationDetails.getPublicationData().isFaceBook());
        publicationAvenue.setTwitter(registrationDetails.getPublicationData().isTwitter());
        publicationAvenue.setFriend(registrationDetails.getPublicationData().isFriend());
        publicationAvenue.setTelevisionAd(registrationDetails.getPublicationData().isTelevisionAd());
        publicationAvenue.setSMS(registrationDetails.getPublicationData().isSMS());
        publicationAvenue.setBillboard(registrationDetails.getPublicationData().isBillboard());
        publicationAvenue.setSunnyFm(registrationDetails.getPublicationData().isSunnyFm());
        publicationAvenue.setSweetMelodies(registrationDetails.getPublicationData().isSweetMelodies());
        publicationAvenue.setChurchAnnouncement(registrationDetails.getPublicationData().isChurchAnnouncement());

        Optional<Participant> participantOptional = this.participantRepository.getParticipantByEmail(participant.email);
        participantOptional.ifPresent(value -> publicationAvenue.setParticipantId(value.getId()));
        publicationDataRepository.save(publicationAvenue);

        return verificationPin;
    }



    public static Map<String,String> getImageAndVerificationCode(){
        String randomCode = Constant.uniqueCodeGenerator();
        String imageCode = randomCode.split("-")[0];
        String imageName = "QR-image-"+imageCode+".png";

        String verificationCode = randomCode.replace("-", "");

        Map<String, String> result = new HashMap<>();
        result.put(IMAGE_NAME, imageName);
        result.put(VERIFICATION_CODE, verificationCode);

        return result;
    }

    public static String getVerificationPin(){
        String verificationPin = Constant.uniqueCodeGenerator().split("-")[4];
        StringBuilder pin = new StringBuilder();
        for(int x = 11; x > 5; x--){
            pin.append(verificationPin.charAt(x));
        }
        return pin.toString();
    }
}
