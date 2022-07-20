package com.InspiredLabs.SS_RegistrationApplication.utils;

import java.util.UUID;
import com.fasterxml.uuid.Generators;

public class Constant {

    public static final String MALE = "male";
    public static final String FEMALE = "female";
    public static final String MEMBERSHIP_COUNT = "membershipCount";
    public static final String NON_MEMBERSHIP_COUNT = "nonMembershipCount";
    public static final String VERIFICATION_CODE = "verificationCode";
    public static final String IMAGE_NAME= "imageName";
    public static final String SENDER_EMAIL = "singlessummit@kiccghana.com";
    public static final String DEFAULT_SUBJECT = "KICC Single's Summit Invitation";
    public static final String IMAGE_PATH = "/Users/erastus/DEV/Personal_Projects/SS_RegistrationApplication/images/";
    public static final String BUCKET_NAME = "kicc";
    public static final String IMAGE_LINK = "https://kicc.s3.us-east-2.amazonaws.com/";


    public static String uniqueCodeGenerator(){
        UUID timeBaseUID = Generators.timeBasedGenerator().generate();
        return timeBaseUID.toString();
    }
}
