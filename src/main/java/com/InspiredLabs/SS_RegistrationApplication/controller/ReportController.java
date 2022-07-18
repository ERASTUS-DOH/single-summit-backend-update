package com.InspiredLabs.SS_RegistrationApplication.controller;

import com.InspiredLabs.SS_RegistrationApplication.dto.Participant;
import com.InspiredLabs.SS_RegistrationApplication.service.ReportService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("SSRegistration/api/v1/report")
public class ReportController {

    private final ReportService reportService;

    public ReportController(ReportService reportService){
        this.reportService = reportService;
    }

    //Get all Registered participants
    @GetMapping("/registered")
    public ResponseEntity<List<Participant>> getAllRegisteredParticipants(){
        return new ResponseEntity<>(this.reportService.getAllRegisteredParticipants(), HttpStatus.OK);
    }

    @GetMapping("/verified")
    public ResponseEntity<List<Participant>> getAllVerifiedParticipants(){
        return new ResponseEntity<>(this.reportService.getAllVerifiedParticipants(), HttpStatus.OK);
    }

    @GetMapping("/registered/members")
    public ResponseEntity<List<Participant>> getAllMembers(){
        return new ResponseEntity<>(this.reportService.getAllMembers(), HttpStatus.OK);
    }

    @GetMapping("/registered/nonMembers")
    public ResponseEntity<List<Participant>> getAllNonMembers(){
        return new ResponseEntity<>(this.reportService.getAllNonMembers(), HttpStatus.OK);
    }

    @GetMapping("/registered/male")
    public ResponseEntity<List<Participant>> getAllMaleParticipants(){
        return new ResponseEntity<>(this.reportService.getAllMaleParticipants(), HttpStatus.OK);
    }

    @GetMapping("/registered/female")
    public ResponseEntity<List<Participant>> getAllFemaleParticipants(){
        return new ResponseEntity<>(this.reportService.getAllFemaleParticipants(), HttpStatus.OK);
    }

    @GetMapping("/registered/ratioMaleFemale")
    public ResponseEntity<Map<String, Integer>> getRatioOfMaleToFemale(){
        return new ResponseEntity<>(this.reportService.getRatioOfMaleToFemale(), HttpStatus.OK);
    }

    @GetMapping("/registered/ratioMemberToNon")
    public  ResponseEntity<Map<String, Integer>> getRatioOfMemberToNonMember(){
        return new ResponseEntity<>(this.reportService.getRatioOfMembersToNonMembers(), HttpStatus.OK);
    }

}
