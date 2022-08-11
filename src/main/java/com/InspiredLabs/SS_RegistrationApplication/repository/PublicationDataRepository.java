package com.InspiredLabs.SS_RegistrationApplication.repository;

import com.InspiredLabs.SS_RegistrationApplication.dto.Participant;
import com.InspiredLabs.SS_RegistrationApplication.dto.PublicationAvenue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PublicationDataRepository extends JpaRepository<PublicationAvenue, Long> {
    @Query(value = " SELECT * FROM publication_avenue WHERE publication_avenue.face_book = true", nativeQuery = true)
    List<PublicationAvenue> facebookData();

    @Query(value = " SELECT * FROM publication_avenue WHERE publication_avenue.twitter = true", nativeQuery = true)
    List<PublicationAvenue> twitterData();

    @Query(value = " SELECT * FROM publication_avenue WHERE publication_avenue.friend = true", nativeQuery = true)
    List<PublicationAvenue> friendData();

    @Query(value = " SELECT * FROM publication_avenue WHERE publication_avenue.television_ad = true", nativeQuery = true)
    List<PublicationAvenue> televisionAdData();

    @Query(value = " SELECT * FROM publication_avenue WHERE publication_avenue.SMS = true",nativeQuery = true)
    List<PublicationAvenue> SMSData();

    @Query(value = " SELECT * FROM publication_avenue  WHERE publication_avenue.billboard = true",nativeQuery = true)
    List<PublicationAvenue> billBoardData();

    @Query(value = " SELECT * FROM publication_avenue  WHERE publication_avenue.sunny_fm = true", nativeQuery = true)
    List<PublicationAvenue> sunnyFmData();

    @Query(value = " SELECT * FROM publication_avenue WHERE publication_avenue.sweet_melodies = true", nativeQuery = true)
    List<PublicationAvenue> sweetMelodiesData();

    @Query(value = " SELECT * FROM publication_avenue WHERE publication_avenue.church_announcement = true", nativeQuery = true)
    List<PublicationAvenue> churchAnnouncementData();
}
