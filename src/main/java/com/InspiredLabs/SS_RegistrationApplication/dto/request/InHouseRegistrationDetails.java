package com.InspiredLabs.SS_RegistrationApplication.dto.request;

import com.InspiredLabs.SS_RegistrationApplication.dto.PublicationData;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class InHouseRegistrationDetails {
    @NotBlank
    private String firstName;

    private String lastName;

    @NotBlank
    private String gender;

    private String telephone;

    @Email
    private String email;

    private boolean membershipStatus;

    private boolean firstTimerStatus;

    private PublicationData publicationData;

}
