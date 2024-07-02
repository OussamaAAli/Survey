package com.example.surveymongedb.Model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Getter
@Setter
public class Survey {
    @Id
    private String id;

    private String question;
    private String response;
    private CategoryType categoryType;


}

