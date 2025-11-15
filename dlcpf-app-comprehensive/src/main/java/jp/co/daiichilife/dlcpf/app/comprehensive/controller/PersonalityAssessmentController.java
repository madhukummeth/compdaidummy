package jp.co.daiichilife.dlcpf.app.comprehensive.controller;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jp.co.daiichilife.dlcpf.app.comprehensive.payload.AssessmentQuestionDto;
import jp.co.daiichilife.dlcpf.app.comprehensive.service.PersonalityAssessmentService;

import java.util.List;

import org.slf4j.Logger;

@RestController
@RequestMapping("/comp")
@CrossOrigin("http://localhost:3000/")
public class PersonalityAssessmentController {
    private static final Logger log= LoggerFactory.getLogger(PersonalityAssessmentController.class);
    @Autowired
    private PersonalityAssessmentService personalityAssessmentService;
    @PostMapping("/assessmentStatus")
    public ResponseEntity<String> getAssessmentStatus(@RequestBody List<AssessmentQuestionDto> assessmentQuestionDto){ 
        try{
        log.info("Personality Assessment Status in getAssessmentStatus Method");  
        String perStatus = personalityAssessmentService.getPersonalityAssessmentStatus(assessmentQuestionDto);
        log.debug("Personality Assessment Status in getAssessmentStatus Method: {}", perStatus);
        return new ResponseEntity<>(perStatus, HttpStatus.OK); 
        }       
        catch(Exception e){
            log.error("Error in getAssessmentStatus Method: ", e);
            return new ResponseEntity<>("Error retrieving assessment status", HttpStatus.INTERNAL_SERVER_ERROR);
        }   
   }
}
   

