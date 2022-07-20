package com.InspiredLabs.SS_RegistrationApplication.service;

import com.InspiredLabs.SS_RegistrationApplication.dto.Participant;
import com.sendgrid.*;
import freemarker.core.ParseException;
import freemarker.template.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import static com.InspiredLabs.SS_RegistrationApplication.utils.Constant.*;

@Service
public class EmailService {
    private static final Logger LOGGER = Logger.getLogger(EmailService.class.getName());

    @Autowired
    private JavaMailSender sender;

    @Qualifier("getFreeMarkerConfiguration")
    @Autowired
    private Configuration fmConfiguration;

    public void sendEmail(Participant participant){
        MimeMessage mimeMessage = sender.createMimeMessage();
        Map<String, Object> variables = new HashMap<>();
        variables.put("firstName", participant.firstName);
        String imagePath = IMAGE_LINK + participant.image_name;
        LOGGER.info(imagePath);
        variables.put("imagePath", imagePath);

        try {

            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED, StandardCharsets.UTF_8.name());
            Template t = fmConfiguration.getTemplate("email-template.ftl");
            String html = FreeMarkerTemplateUtils.processTemplateIntoString(t, variables);

            mimeMessageHelper.setSubject(DEFAULT_SUBJECT);
            mimeMessageHelper.setFrom(SENDER_EMAIL);
            mimeMessageHelper.setTo(participant.email);
            mimeMessageHelper.setText(html, true);

            sender.send(mimeMessage);
            LOGGER.info("Email sent successfully");
        }catch (MessagingException | IOException | TemplateException e) {
            e.printStackTrace();
            LOGGER.info("Mail sending failure......");

        }


    }


}
