package edu.mum.controller;


import edu.mum.domain.Role;
import edu.mum.domain.User;
import edu.mum.exception.NotFoundException;
import edu.mum.exception.RestrictionException;
import edu.mum.exception.ValidationException;
import edu.mum.service.auth.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.lang.model.type.ErrorType;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Controller
public class AuthController {


    @Autowired
    AuthService service;
    /**
     * do.Login
     **/

    @RequestMapping(value = "/signin", method = RequestMethod.POST)
    public String doSignIn(@RequestParam(value = "userName") String userName,
                           @RequestParam(value = "password") String password,Model model) {
        try {
            model.addAttribute(service.doSignIn(userName, password));
            return "/welcome";
        }catch (Exception ex) {
            model.addAttribute("error", ex.getMessage());
            return "/login";
        }
    }

//    /**
//     * do.Refresh
//     **/
//    @RequestMapping(value = "refresh", method = RequestMethod.GET)
//    @PreAuthorize("hasAuthority('Admin') or  hasAuthority('CarOwner')  or  hasAuthority('CarRenter')")
//    public ResponseDTO doRefresh(HttpServletRequest req) {
//        try {
//            LogUtilities.info(this.getClass().getName(), "[ctrl][auth][refresh][ini][" + req.getRemoteUser() + "][" + jwtTokenProvider.resolveToken(req) + "]");
//
//            ResponseDTO responseDTO = service.doRefresh(req);
//
//            LogUtilities.info(this.getClass().getName(), "[ctrl][auth][refresh][end][" + req.getRemoteUser() + "][" + jwtTokenProvider.resolveToken(req) + "]");
//
//            return responseDTO;
//
//        } catch (NotFoundException ex) {
//            LogUtilities.warn(this.getClass().getName(), "[ctrl][auth][refresh][not.found][ " + ex.getMessage() + "]");
//            return new ResponseService(HttpStatus.NOT_FOUND.value(), null, new ErrorDTO(null, ex.getMessage(), ErrorType.NOT_FOUND)).getError();
//        } catch (Exception ex) {
//            LogUtilities.fatal(this.getClass().getName(), "[ctrl][auth][refresh][unknown][ " + ex.getMessage() + "]", ex);
//            return new ResponseService(HttpStatus.INTERNAL_SERVER_ERROR.value(), null, new ErrorDTO(null, ex.getMessage(), ErrorType.UNKNOWN)).getError();
//        }
//    }

    /**
     * do.Check.Who.Am.I
     **/
//
//    @RequestMapping(value = "check", method = RequestMethod.GET)
//    @PreAuthorize("hasAuthority('Admin') or  hasAuthority('CarOwner')  or  hasAuthority('CarRenter')")
//    public ResponseDTO doCheckWhoAmI(HttpServletRequest req) {
//        try {
//            LogUtilities.info(this.getClass().getName(), "[ctrl][auth][who.am.i][ini][" + req.getRemoteUser() + "][" + jwtTokenProvider.resolveToken(req) + "]");
//
//            ResponseDTO responseDTO = service.doCheckWhoAmI(req);
//
//            LogUtilities.info(this.getClass().getName(), "[ctrl][auth][who.am.i][end][" + req.getRemoteUser() + "][" + jwtTokenProvider.resolveToken(req) + "]");
//
//            return responseDTO;
//
//        } catch (NotFoundException ex) {
//            LogUtilities.warn(this.getClass().getName(), "[ctrl][auth][who.am.i][not.found][ " + ex.getMessage() + "]");
//            return new ResponseService(HttpStatus.NOT_FOUND.value(), null, new ErrorDTO(null, ex.getMessage(), ErrorType.NOT_FOUND)).getError();
//        } catch (Exception ex) {
//            LogUtilities.fatal(this.getClass().getName(), "[ctrl][auth][who.am.i][unknown][ " + ex.getMessage() + "]", ex);
//            return new ResponseService(HttpStatus.INTERNAL_SERVER_ERROR.value(), null, new ErrorDTO(null, ex.getMessage(), ErrorType.UNKNOWN)).getError();
//        }
//    }

    /**
     * do.Signup
     **/

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String doSignUp(@Valid @ModelAttribute("userSignup") User user, BindingResult bindingResult) {
        user.setCreateDate(LocalDateTime.now());
        List<Role> roles = new ArrayList<>();
        if(bindingResult.hasErrors()){
            System.out.println("HAS ERROR");
            return "signup";
        }
        try {
            System.out.println("signUP");

            service.doSignUp(user);
            return "welcome";
        } catch (Exception ex) {
            System.out.println("EXCEPTION " + ex.getMessage());


            return "signup";
        }
    }

    /**
     * do.Logout
     **/

    @RequestMapping(value = "signout", method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('Admin') or  hasAuthority('CarOwner')  or  hasAuthority('CarRenter')")
    public void doLogout(HttpServletRequest req) {
        service.doLogout(req);
    }

}
