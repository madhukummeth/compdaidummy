package jp.co.daiichilife.dlcpf.app.comprehensive.serviceImpl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import jp.co.daiichilife.dlcpf.app.comprehensive.payload.AssessmentQuestionDto;
import jp.co.daiichilife.dlcpf.app.comprehensive.service.PersonalityAssessmentService;
@Service
public class PersonalityAssessmentServiceImpl implements PersonalityAssessmentService 
{
    private static final Logger log= LoggerFactory.getLogger(PersonalityAssessmentServiceImpl.class);

    @Override
    public String getPersonalityAssessmentStatus(List<AssessmentQuestionDto> assessmentQuestionDto) {
        log.info("Personality Assessment Status in getPersonalityAssessmentStatus Method");
         boolean allQuestionsAnswered=true;
         if(assessmentQuestionDto!=null){
         for(AssessmentQuestionDto dto: assessmentQuestionDto){
            log.info("Question ID: {}, Selected Option: {}", dto.getQuestionId(), dto.getSelectedOption());
            if(dto.getQuestionId()==null || dto.getSelectedOption()==null || dto.getSelectedOption().toString().isEmpty() ){
                allQuestionsAnswered=false;
                break;
            }
         }  
            if(allQuestionsAnswered){
                return "Stable";
            }
            else{
                return "Mandatory Questions are not answered";
            }
    }
            else{
                log.warn("Assessment Question DTO List is null");
                return "Mandatory Questions are not answered";
            }
        }   

    
}
