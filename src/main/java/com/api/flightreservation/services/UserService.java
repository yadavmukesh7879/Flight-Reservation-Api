package com.api.flightreservation.services;

import com.api.flightreservation.entities.LoginDetails;
import com.api.flightreservation.entities.User;

public interface UserService {
    public User addUser(User user);
    public String getUserDetails(LoginDetails loginDetails);
}
