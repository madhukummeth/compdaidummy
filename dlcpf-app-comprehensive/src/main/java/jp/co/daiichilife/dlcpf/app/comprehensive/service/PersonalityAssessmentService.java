package jp.co.daiichilife.dlcpf.app.comprehensive.service;

import java.util.List;

import jp.co.daiichilife.dlcpf.app.comprehensive.payload.AssessmentQuestionDto;

public interface PersonalityAssessmentService {
   public String getPersonalityAssessmentStatus(List<AssessmentQuestionDto> assessmentQuestionDto);   
}
