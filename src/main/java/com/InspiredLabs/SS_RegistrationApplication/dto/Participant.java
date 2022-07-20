package com.InspiredLabs.SS_RegistrationApplication.dto;

import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;

@Entity
@Table(name = "participant")
public class Participant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    @Column(name = "verification_Code", nullable = false)
    public String verificationCode;

    @Column(name = "first_name", nullable = false)
    public String firstName;

    @Column(name = "last_name")
    public String lastName;

    @Column(name = "gender", nullable = false)
    public String gender;

    @Column(name = "email", nullable = false)
    public String email;

    @Column(name = "telephone")
    public String telephone;

    @Column(name = "membership_status")
    public boolean memberShipStatus;

    @Column(name = "first_timer_status")
    public boolean firstTimerStatus;

    @Column(name = "publicity_avenue")
    public String publicityAvenue;

    @Column(name = "verification_status")
    public boolean verificationStatus;

    @Column(name = "qr_code", nullable = false)
    public String image_name;

    public Participant() {

    }

    public Participant(String verificationCode, String firstName, String lastName, String gender, String email, String telephone, boolean memberShipStatus, boolean firstTimerStatus, String publicityAvenue, boolean verificationStatus, String image_name) {
        this.verificationCode = verificationCode;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.email = email;
        this.telephone = telephone;
        this.memberShipStatus = memberShipStatus;
        this.firstTimerStatus = firstTimerStatus;
        this.publicityAvenue = publicityAvenue;
        this.verificationStatus = verificationStatus;
        this.image_name = image_name;
    }

    public Long getId() {
        return id;
    }

    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public boolean isMemberShipStatus() {
        return memberShipStatus;
    }

    public void setMemberShipStatus(boolean memberShipStatus) {
        this.memberShipStatus = memberShipStatus;
    }

    public boolean isFirstTimerStatus() {
        return firstTimerStatus;
    }

    public void setFirstTimerStatus(boolean firstTimerStatus) {
        this.firstTimerStatus = firstTimerStatus;
    }

    public String getPublicityAvenue() {
        return publicityAvenue;
    }

    public void setPublicityAvenue(String publicityAvenue) {
        this.publicityAvenue = publicityAvenue;
    }

    public boolean isVerificationStatus() {
        return verificationStatus;
    }

    public void setVerificationStatus(boolean verificationStatus) {
        this.verificationStatus = verificationStatus;
    }

    public String getImage_name() {
        return image_name;
    }

    public void setImage_name(String image_name) {
        this.image_name = image_name;
    }

    @Override
    public String toString() {
        return "Participant{" +
                "id=" + id +
                ", verificationCode='" + verificationCode + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", telephone='" + telephone + '\'' +
                ", memberShipStatus=" + memberShipStatus +
                ", firstTimerStatus=" + firstTimerStatus +
                ", publicityAvenue='" + publicityAvenue + '\'' +
                ", verificationStatus=" + verificationStatus +
                ", image_name='" + image_name + '\'' +
                '}';
    }
}