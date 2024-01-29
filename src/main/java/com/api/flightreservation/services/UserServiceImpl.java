package com.api.flightreservation.services;

import com.api.flightreservation.entities.LoginDetails;
import com.api.flightreservation.entities.User;
import com.api.flightreservation.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;
    @Override
    public User addUser(User user) {
       return userRepository.save(user);
    }

    @Override
    public String getUserDetails(LoginDetails loginDetails) {

        try {
            User userDetails = userRepository.findByEmail(loginDetails.getEmail());
            if(userDetails.getPassword().equals(loginDetails.getPassword())){
                return "You are Welcome you have logged in successfully";
            }
            return "Incorrect Password Please Provide Correct Password";
        } catch (Exception exception){
            return "Email Does not exist";
        }

    }
}
