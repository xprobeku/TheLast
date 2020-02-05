package edu.mum.service.impl;

import org.springframework.stereotype.Component;

/**
 * Validation Service @author Dios
 */

@Component
public class ValidationService {

    /**
     * do.Validate.Password
     **/

    public boolean doValidatePassword(String password) {
        return !password.isEmpty() && password.length() > 8;
    }

}
