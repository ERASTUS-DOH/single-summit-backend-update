package com.InspiredLabs.SS_RegistrationApplication.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PublicationData {
    private boolean faceBook;
    private boolean twitter;
    private boolean friend;
    private boolean televisionAd;
    private boolean SMS;
    private boolean billboard;
    private boolean sunnyFm;
    private boolean sweetMelodies;
    private boolean churchAnnouncement;
}
