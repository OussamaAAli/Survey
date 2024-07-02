package com.example.surveymongedb.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class User {
    @Id
    private String id;

    private String firstName;
    private String lastName;
    private String email;
    private int numberOfQuestionsResponded;
    private List<String> listOfHisResponses;

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public int getNumberOfQuestionsResponded() {
        return numberOfQuestionsResponded;
    }

    public List<String> getListOfHisResponses() {
        return listOfHisResponses;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNumberOfQuestionsResponded(int numberOfQuestionsResponded) {
        this.numberOfQuestionsResponded = numberOfQuestionsResponded;
    }

    public void setListOfHisResponses(List<String> listOfHisResponses) {
        this.listOfHisResponses = listOfHisResponses;
    }

}
