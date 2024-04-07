package com.alfredo.nba.NBASports.Service;

import com.alfredo.nba.NBASports.Models.User;
import com.alfredo.nba.NBASports.Models.UserRequest;
import com.alfredo.nba.NBASports.Models.UserResponse;
import com.alfredo.nba.NBASports.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

//    private final String demoPass = "Password@123";

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserResponse register(UserRequest request) {
         User user = null;
         var existingUser = userRepository.getByEmail(request.getEmail());

         if(existingUser.isEmpty()) {
             user = User.builder()
                     .name(request.getName())
                     .email(request.getEmail())
                     .phoneNumber(request.getPhoneNumber())
                     .password(request.getPassword())
                     .build();

             userRepository.save(user);

             return UserResponse.builder()
                     .Email(user.getEmail())
                     .ErrorCode(0)
                     .Error_Message("New user has been registered successfully.").build();


         } else {
             return UserResponse.builder()
                     .Email(existingUser.get().getEmail())
                     .ErrorCode(1)
                     .Error_Message("This user is already registered")
                     .build();
         }
    }

    public boolean isPasswordMatch(User user, String password) {
        return user.getPassword().equals(password);
    }
}
