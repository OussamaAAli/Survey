package com.example.surveymongedb.Repository;

import com.example.surveymongedb.Model.CategoryType;
import com.example.surveymongedb.Model.Survey;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface SurveyRepository extends MongoRepository<Survey, String> {
    List<Survey> findByCategoryType(CategoryType categoryType);
}
