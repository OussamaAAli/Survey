package com.example.surveymongedb.Service;
import com.example.surveymongedb.Model.User;
import com.example.surveymongedb.Repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(String userId, User updatedUser) {
        Optional<User> existingUser = userRepository.findById(userId);
        if (existingUser.isPresent()) {
            User user = existingUser.get();
            user.setFirstName(updatedUser.getFirstName());
            user.setLastName(updatedUser.getLastName());
            user.setEmail(updatedUser.getEmail());
            return userRepository.save(user);
        } else {
            return null;
        }
    }


    public void deleteUser(String userId) {
        userRepository.deleteById(userId);
    }


    public Optional<User> getUserById(String userId) {
        return userRepository.findById(userId);
    }

    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }


    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    public List<User>  getUsersByName(String name) {
        return userRepository.findByFirstNameOrLastName(name, name);
    }
}
