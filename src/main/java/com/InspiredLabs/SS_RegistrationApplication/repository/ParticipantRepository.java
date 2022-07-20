package com.InspiredLabs.SS_RegistrationApplication.repository;

import com.InspiredLabs.SS_RegistrationApplication.dto.Participant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ParticipantRepository extends JpaRepository<Participant, Long> {

    @Query(value = " SELECT p FROM Participant p WHERE p.verificationCode = :verificationCode")
    Participant findByVerificationCode(@Param("verificationCode") String Verification);

    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE Participant p set p.verificationStatus = :verify where p.verificationCode = :code")
    void verifyParticipant(@Param("verify") boolean verify,  @Param("code") String verificationCode);

   @Query(value = "SELECT p FROM Participant p where p.verificationStatus = true")
    List<Participant> getAllVerifiedParticipants();

   @Query(value = "select p from Participant p where p.memberShipStatus = true")
    List<Participant> getAllMembers();

   @Query(value="select p from Participant p where p.memberShipStatus = false or p.memberShipStatus = null")
    List<Participant> getAllNonMembers();

   @Query(value="select  p from Participant p where p.gender = :gender")
    List<Participant> getParticipantByGender(@Param("gender") String gender);

   @Query(value="select p from Participant p where p.email = :email")
   Optional<Participant> getParticipantByEmail(@Param("email") String email);
}
