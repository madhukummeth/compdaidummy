package jp.co.daiichilife.dlcpf.app.comprehensive.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Collections;
import static org.mockito.Mockito.when;
import jp.co.daiichilife.dlcpf.app.comprehensive.payload.AssessmentQuestionDto;
import jp.co.daiichilife.dlcpf.app.comprehensive.service.PersonalityAssessmentService;

public class PersonalityAssessmentStatusTest {
@Mock   
private PersonalityAssessmentService personalityAssessmentService;
@InjectMocks
private PersonalityAssessmentController personalityAssessmentStatus;
@BeforeEach 
public void setUp() {
    MockitoAnnotations.openMocks(this);
}

@Test
void testName() {
    
}

@Test
public void testGetAssessmentStatus_Success() {
    // Add your test implementation here
    List<AssessmentQuestionDto> mockDtoList = Collections.emptyList();
    when(personalityAssessmentService.getPersonalityAssessmentStatus(mockDtoList)).thenReturn("Stable");
    ResponseEntity<String> response = personalityAssessmentStatus.getAssessmentStatus(mockDtoList);
    assertEquals(HttpStatus.OK, response.getStatusCode());
    assertEquals("Stable", response.getBody());
    verify(personalityAssessmentService).getPersonalityAssessmentStatus(mockDtoList);   
}

@Test
public void testGetAssessmentStatus_Failure() {
    // Add your test implementation here
    List<AssessmentQuestionDto> mockDtoList = Collections.emptyList();
    when(personalityAssessmentService.getPersonalityAssessmentStatus(mockDtoList)).thenThrow(new RuntimeException("Service failed"));
    ResponseEntity<String> response = personalityAssessmentStatus.getAssessmentStatus(mockDtoList);
    assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
    assertEquals("Error retrieving assessment status", response.getBody());
    verify(personalityAssessmentService).getPersonalityAssessmentStatus(mockDtoList);   
}

}