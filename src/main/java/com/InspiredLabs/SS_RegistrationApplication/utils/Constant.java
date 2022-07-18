package com.InspiredLabs.SS_RegistrationApplication.utils;

import java.util.UUID;
import com.fasterxml.uuid.Generators;

public class Constant {

    public static final String MALE = "male";
    public static final String FEMALE = "female";
    public static final String MEMBERSHIP_COUNT = "membershipCount";
    public static final String NON_MEMBERSHIP_COUNT = "nonMembershipCount";


    public static String uniqueCodeGenerator(){
        UUID timeBaseUID = Generators.timeBasedGenerator().generate();
        return timeBaseUID.toString();
    }
}
