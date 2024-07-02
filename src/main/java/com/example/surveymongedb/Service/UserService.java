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

    // Create User
    public User createUser(User user) {
        return userRepository.save(user);
    }

    // Update User
    public User updateUser(String userId, User updatedUser) {
        Optional<User> existingUser = userRepository.findById(userId);
        if (existingUser.isPresent()) {
            User user = existingUser.get();
            user.setFirstName(updatedUser.getFirstName());
            user.setLastName(updatedUser.getLastName());
            user.setEmail(updatedUser.getEmail());
            // Set other properties as needed
            return userRepository.save(user);
        } else {
            // Handle user not found
            return null;
        }
    }

    // Delete User
    public void deleteUser(String userId) {
        userRepository.deleteById(userId);
    }

    // Get User by ID
    public Optional<User> getUserById(String userId) {
        return userRepository.findById(userId);
    }

    // Get User by Email
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    // Get All Users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    public List<User>  getUsersByName(String name) {
        return userRepository.findByFirstNameOrLastName(name, name);
    }
}
