package com.example.surveymongedb.Service;

import com.example.surveymongedb.Model.CategoryType;
import com.example.surveymongedb.Model.Survey;
import com.example.surveymongedb.Repository.SurveyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SurveyService {
    private final SurveyRepository surveyRepository;

    public SurveyService(SurveyRepository surveyRepository) {
        this.surveyRepository = surveyRepository;
    }

    public Survey addQuestion(Survey survey) {
        return surveyRepository.save(survey);
    }

    public List<Survey> getAllQuestions() {
        return surveyRepository.findAll();
    }



    public Survey updateQuestion(String questionId, Survey updatedSurvey) {
        Optional<Survey> existingSurvey = surveyRepository.findById(questionId);
        if (existingSurvey.isPresent()) {
            Survey survey = existingSurvey.get();
            survey.setQuestion(updatedSurvey.getQuestion());
            survey.setResponse(updatedSurvey.getResponse());
            survey.setCategoryType(updatedSurvey.getCategoryType());
            return surveyRepository.save(survey);
        } else {
            return null;
        }
    }

    public void deleteQuestion(String questionId) {
        surveyRepository.deleteById(questionId);
    }


    public Optional<Survey> getQuestionById(String questionId) {
        return surveyRepository.findById(questionId);
    }

    public List<Survey> getQuestionsByCategory(CategoryType categoryType) {
        return surveyRepository.findByCategoryType(categoryType);
    }


}