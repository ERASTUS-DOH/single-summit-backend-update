package com.InspiredLabs.SS_RegistrationApplication.repository;

import com.InspiredLabs.SS_RegistrationApplication.dto.Participant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ParticipantRepository extends JpaRepository<Participant, Long> {

    @Query(value = " SELECT * FROM Participant p WHERE p.verificationCode = :verificationCode", nativeQuery = true)
    Optional<Participant> findByVerificationCode(@Param("verificationCode") String Verification);

    @Query(value = "update Participant p set p.verificationStatus = true where p.verificationCode = :verificationcode", nativeQuery = true)
    void verifyParticipant(@Param("verificationCode") String verificationCode);

   @Query(value = "SELECT * FROM Participant p where p.verificationStatus = true", nativeQuery = true)
    List<Participant> getAllVerifiedParticipants();

   @Query(value = "select * from Participant p where p.memberShipStatus = true", nativeQuery = true)
    List<Participant> getAllMembers();

   @Query(value="select * from Participant p where p.memberShipStatus = false or null", nativeQuery = true)
    List<Participant> getAllNonMembers();

   @Query(value="select  * from Participant p where p.gender = :gender", nativeQuery = true)
    List<Participant> getParticipantByGender(@Param("gender") String gender);
}
