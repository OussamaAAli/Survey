package com.example.surveymongedb.Controller;

import com.example.surveymongedb.Model.CategoryType;
import com.example.surveymongedb.Model.Survey;
import com.example.surveymongedb.Service.SurveyService;
import com.example.surveymongedb.util.ResponseMessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/survey")
public class SurveyController {

    private final SurveyService surveyService;

    public SurveyController(SurveyService surveyService) {
        this.surveyService = surveyService;
    }

    @PostMapping("/add")
    public ResponseEntity<String> addQuestion(@RequestBody Survey survey) {
        try {
            surveyService.addQuestion(survey);
            return ResponseMessageUtil.createSuccessMessage("Question added successfully");
        } catch (Exception e) {
            return ResponseMessageUtil.createFailureMessage("Failed to add question");
        }
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllQuestions() {
        try {
            List<Survey> surveys = surveyService.getAllQuestions();
            if (!surveys.isEmpty()) {
                return ResponseMessageUtil.createSuccessResponse(surveys);
            } else {
                return ResponseMessageUtil.createNotFoundMessage("No questions found");
            }
        } catch (Exception e) {
            return ResponseMessageUtil.createFailureMessage("Failed to retrieve questions");
        }
    }

    @PutMapping("/{questionId}/update")
    public ResponseEntity<String> updateQuestion(@PathVariable String questionId, @RequestBody Survey updatedSurvey) {
        Survey result = surveyService.updateQuestion(questionId, updatedSurvey);
        if (result != null) {
            return ResponseMessageUtil.createSuccessMessage("Question updated successfully");
        } else {
            return ResponseMessageUtil.createNotFoundMessage("Question not found");
        }
    }

    @DeleteMapping("/{questionId}/delete")
    public ResponseEntity<String> deleteQuestion(@PathVariable String questionId) {
        try {
            surveyService.deleteQuestion(questionId);
            return ResponseMessageUtil.createSuccessMessage("Question deleted successfully");
        } catch (Exception e) {
            return ResponseMessageUtil.createFailureMessage("Failed to delete question");
        }
    }

    @GetMapping("/{questionId}")
    public ResponseEntity<?> getQuestionById(@PathVariable String questionId) {
        Optional<Survey> survey = surveyService.getQuestionById(questionId);
        if (survey.isPresent()) {
            return ResponseMessageUtil.createSuccessResponse(survey.get());
        } else {
            return ResponseMessageUtil.createNotFoundMessage("Question not found");
        }
    }

    @GetMapping("/byCategory")
    public ResponseEntity<?> getQuestionsByCategory(@RequestParam CategoryType categoryType) {
        try {
            List<Survey> surveys = surveyService.getQuestionsByCategory(categoryType);
            if (!surveys.isEmpty()) {
                return ResponseMessageUtil.createSuccessResponse(surveys);
            } else {
                return ResponseMessageUtil.createNotFoundMessage("No questions found for the given category");
            }
        } catch (Exception e) {
            return ResponseMessageUtil.createFailureMessage("Failed to retrieve questions");
        }
    }
}
