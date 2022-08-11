package com.InspiredLabs.SS_RegistrationApplication.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name ="publication_avenue")
public class PublicationAvenue {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;
    public Long participantId;
    public boolean faceBook;
    public boolean twitter;
    public boolean friend;
    public boolean televisionAd;
    public boolean SMS;
    public boolean billboard;
    public boolean sunnyFm;
    public boolean sweetMelodies;
    public boolean churchAnnouncement;
}
