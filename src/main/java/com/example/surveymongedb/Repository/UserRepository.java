package com.example.surveymongedb.Repository;

import com.example.surveymongedb.Model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRepository extends MongoRepository<User, String> {
    User findByEmail(String email);

    List<User> findByFirstNameOrLastName(String firstName, String lastName);


}
