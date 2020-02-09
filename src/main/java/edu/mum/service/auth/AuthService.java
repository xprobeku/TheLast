package edu.mum.service.auth;

import edu.mum.domain.User;
import edu.mum.exception.CustomException;
import edu.mum.exception.NotFoundException;
import edu.mum.exception.RestrictionException;
import edu.mum.exception.ValidationException;
import edu.mum.repository.UserRepository;
import edu.mum.service.impl.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Service
public class AuthService {

    /**
     * Autowire
     **/

    private UserRepository userRepository;

    private PasswordEncoder passwordEncoder;


    private AuthenticationManager authenticationManager;

    private ValidationService validationService;

    @Autowired
    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager, ValidationService validationService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.validationService = validationService;
    }

    /**
     * do.Login
     **/

    public String doSignIn(String username, String password) {
        System.out.println(validationService.doValidatePassword(password) + " -  " + password);
        if (validationService.doValidatePassword(password)) {
            if (userRepository.findByUserName(username) != null) {
                // make this commend because we can't  make initial data
                // uncomment after test. Populate.sql
//                if (passwordEncoder.matches(password,userRepository.findPasswordByUserName(username)))
                if (password.equals(userRepository.findPasswordByUserName(username)))
                    return "Access";
                else {
                    return ("username or password doesnt match");
                }
            } else {
                return ("User not found");
            }
        } else {
            return ("Password length doesnt match");
        }
    }


    /**
     * do.Sign.Up
     **/

    public String doSignUp(User user) {

        if (validationService.doValidatePassword(user.getPassword())) {
            if (userRepository.findByUserName(user.getUserName()) == null) {
                if (userRepository.findByEmail(user.getEmail()) == null) {
                    // for test data make this line comment. Because have problem with initial data.
                    // Initial data cant encode password
//                    user.setPassword(passwordEncoder.encode(user.getPassword()));

                    userRepository.save(user);
                    return "Saved";
                } else {
                    return ("Email is already in use");
                }
            } else {
                return ("Username is already in use");
            }
        } else {
            return ("password length doesnt match");
        }
    }

    /**
     * do.Logout
     **/

    public void doLogout(HttpSession session) {
        session.invalidate();
    }

    /**
     * do.Generate.Token
     **/


}
