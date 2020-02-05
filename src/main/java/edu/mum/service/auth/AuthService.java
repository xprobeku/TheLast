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

    public User doSignIn(String username, String password) throws ValidationException, NotFoundException, RestrictionException {
        if (validationService.doValidatePassword(password)) {
            if (userRepository.findByUserNameIs(username)) {
                try {
                    if (userRepository.findPasswordByUserName(password).equals(password))
                        return this.doGenerate(username);
                    else {
                        throw new RestrictionException("username or password doesnt match");
                    }
                } catch (BadCredentialsException ex) {
                    throw new RestrictionException("password doesnt match");
                }
            } else {
                throw new NotFoundException("User not found");
            }
        } else {
            throw new ValidationException("Password length doesnt match");
        }
    }


    /**
     * do.Sign.Up
     **/

    public void doSignUp(User user) throws CustomException, ValidationException {
        userRepository.save(user);
        //        try {
//            System.out.println("1");
//            if (validationService.doValidatePassword(user.getPassword())) {
//                System.out.println("1");
//                if (!userRepository.findByUserNameIs(user.getUserName())) {
//                    System.out.println("1");
//                    if (!userRepository.findByEmailIs(user.getEmail())) {
//                        System.out.println("ORSNU");
//                        user.setPassword(passwordEncoder.encode(user.getPassword()));
//                        userRepository.save(user);
//                        return true;
//                    } else {
//                        System.out.println("Email is already in use");
//
//                        throw new CustomException("Email is already in use", HttpStatus.UNPROCESSABLE_ENTITY);
//                    }
//                } else {
//                    System.out.println("Username is already in use");
//
//                    throw new CustomException("Username is already in use", HttpStatus.UNPROCESSABLE_ENTITY);
//                }
//            } else {
//                System.out.println("Uassword length doesnt match");
//                throw new ValidationException("password length doesnt match");
//            }
//        } catch (ValidationException ex) {
//            System.out.println(ex.getMessage());
//            throw ex;
//        } catch (CustomException ex) {
//            System.out.println(ex.getMessage());
//            throw ex;
//        } catch (Exception ex) {
//            System.out.println("Shaaa shaa gg end reporrt me " + ex.getMessage() + " " + ex.toString());
//            throw ex;
//        }
    }

    /**
     * do.Logout
     **/

    public void doLogout(HttpServletRequest req) {
    }

    /**
     * do.Generate.Token
     **/

    private User doGenerate(String username) {
        try {
            //removing password from returning user object
//            user.setPassword(null);
            return userRepository.findByUserName(username);
        } catch (Exception ex) {
            throw ex;
        }
    }

}
