package edu.mum.controller;


import edu.mum.domain.Role;
import edu.mum.domain.User;
import edu.mum.exception.NotFoundException;
import edu.mum.exception.RestrictionException;
import edu.mum.exception.ValidationException;
import edu.mum.service.UserService;
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
import javax.servlet.http.HttpSession;
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
    @Autowired
    UserService userService;

    @RequestMapping(value = "/signin", method = RequestMethod.POST)
    public String doSignIn(@RequestParam(value = "userName") String userName,
                           @RequestParam(value = "password") String password,Model model, HttpSession httpSession) {
            String res = service.doSignIn(userName, password);
            if(res.equals("Access")){
                User loggedUser = userService.getByUserName(userName);
                if(loggedUser == null){
                    model.addAttribute("error", "Login failed enter valid credentials");
                }
                else{
                    if(loggedUser.getRoles().contains(Role.ADMIN)){
                        addUserInSession(loggedUser, httpSession);
                        return "redirect:/dashboard";
                    }
                    else if(loggedUser.getRoles().contains(Role.OWNER) || loggedUser.getRoles().contains(Role.RENTER)){
                        addUserInSession(loggedUser, httpSession);
                        return "redirect:/dashboard";
                    }
                    else{
                        model.addAttribute("error", "Invalid User Role");
                        return "redirect:/index";
                    }
                }
                model.addAttribute("user" , userService.getByUserName(userName));
                return "redirect:/welcome";
            }
            model.addAttribute("error", res);
            return "/login";
    }


    private void addUserInSession(User user, HttpSession httpSession ){
        httpSession.setAttribute("user",user);
        httpSession.setAttribute("userName",user.getUserName());
        httpSession.setAttribute("role",user.getRoles().get(0));
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
    public String doSignUp(@Valid @ModelAttribute("userSignup") User user, BindingResult bindingResult, Model model) {
        user.setCreateDate(LocalDateTime.now());
        List<Role> roles = new ArrayList<>();
        if(bindingResult.hasErrors()){
            return "signup";
        }
           String res =  service.doSignUp(user);
            if(res.equals("Saved")) return "welcome";

            model.addAttribute("error", res);
            return "signup";
    }

    /**
     * do.Logout
     **/

    @RequestMapping(value = "signout", method = RequestMethod.GET)
    public String doLogout(HttpServletRequest req, HttpSession session) {
        service.doLogout(req);
        session.invalidate();
        return "redirect:welcome";
    }

}
