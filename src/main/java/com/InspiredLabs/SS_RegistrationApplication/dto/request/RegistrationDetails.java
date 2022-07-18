package com.InspiredLabs.SS_RegistrationApplication.dto.request;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
public class RegistrationDetails {
    @NotBlank
    public String firstName;

    public String lastName;

    @NotBlank
    public String gender;

    @NotBlank
    public String telephone;

    @Email
    @NotBlank
    public String email;

    public boolean membershipStatus;
    public boolean firstTimerStatus;
    public String publicityAvenue;

   public RegistrationDetails(){

   }

    public RegistrationDetails(String firstName, String lastName, String gender, String telephone, String email, boolean membershipStatus, boolean firstTimerStatus, String publicityAvenue) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.telephone = telephone;
        this.email = email;
        this.membershipStatus = membershipStatus;
        this.firstTimerStatus = firstTimerStatus;
        this.publicityAvenue = publicityAvenue;
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

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public boolean isMembershipStatus() {
        return membershipStatus;
    }

    public void setMembershipStatus(boolean membershipStatus) {
        this.membershipStatus = membershipStatus;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "RegistrationDetails{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender='" + gender + '\'' +
                ", telephone='" + telephone + '\'' +
                ", email='" + email + '\'' +
                ", membershipStatus=" + membershipStatus +
                ", firstTimerStatus=" + firstTimerStatus +
                ", publicityAvenue='" + publicityAvenue + '\'' +
                '}';
    }
}
