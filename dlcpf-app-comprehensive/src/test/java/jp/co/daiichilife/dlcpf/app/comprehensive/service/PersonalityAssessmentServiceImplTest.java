package jp.co.daiichilife.dlcpf.app.comprehensive.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import jp.co.daiichilife.dlcpf.app.comprehensive.payload.AssessmentQuestionDto;
import jp.co.daiichilife.dlcpf.app.comprehensive.serviceImpl.PersonalityAssessmentServiceImpl;

public class PersonalityAssessmentServiceImplTest {
 @InjectMocks
    private PersonalityAssessmentServiceImpl serviceImpl;
    @BeforeEach 
    public void setUp() {
        MockitoAnnotations.openMocks(this);
   }   
   @Test
   void testAllQuestionsAnswered_ReturnsStable() {
       List<AssessmentQuestionDto> dtoList = new ArrayList<>();
       AssessmentQuestionDto dto1 = new AssessmentQuestionDto();
       dto1.setQuestionId(1L);
       dto1.setSelectedOption(1L);
       AssessmentQuestionDto dto2 = new AssessmentQuestionDto();
       dto2.setQuestionId(2L);
       dto2.setSelectedOption(2L);
       dtoList.add(dto1 );
       dtoList.add(dto2);
       String result = serviceImpl.getPersonalityAssessmentStatus(dtoList);   
       assertEquals("Stable", result); 
   }  
    @Test
    void testSomeQuestionsNotAnswered_ReturnsMandatoryMessage() {
        List<AssessmentQuestionDto> dtoList = new ArrayList<>();
        AssessmentQuestionDto dto1 = new AssessmentQuestionDto();
        dto1.setQuestionId(1L);
        dto1.setSelectedOption(null);        
        dtoList.add(dto1);    
        String result = serviceImpl.getPersonalityAssessmentStatus(dtoList);   
        assertEquals("Mandatory Questions are not answered", result); 
    }
    
    @Test
    void testQuestionIdIsNull_ReturnsMandatoryMessage() {
        List<AssessmentQuestionDto> dtoList = new ArrayList<>();
        AssessmentQuestionDto dto1 = new AssessmentQuestionDto();
        dto1.setQuestionId(null);
        dto1.setSelectedOption(null);      
        dtoList.add(dto1);    
        String result = serviceImpl.getPersonalityAssessmentStatus(dtoList);   
        assertEquals("Mandatory Questions are not answered", result); 
    }
    
    @Test
    void testListIsNull_ReturnsMandatoryMessage() {
        String result = serviceImpl.getPersonalityAssessmentStatus(null);   
        assertEquals("Mandatory Questions are not answered", result); 
    }
    @Test
    void testEmptyList_ReturnsStable() {    
        List<AssessmentQuestionDto> dtoList = new ArrayList<>();      
        String result = serviceImpl.getPersonalityAssessmentStatus(dtoList);   
        assertEquals("Stable", result); 
    }   
}   