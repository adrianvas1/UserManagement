package com.users.controller;

import java.util.List;

import com.users.domain.User;
import com.users.dto.user.UserPostDto;
import com.users.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping(value = "/users")
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity userDetails() {

        List userDetails = userService.getUserDetails();
        return new ResponseEntity(userDetails, HttpStatus.OK);
    }

    @RequestMapping(value = "/sign-up", method = RequestMethod.POST)
    ResponseEntity create(@RequestBody UserPostDto dto) {
        User user = userService.create(dto);
        return new ResponseEntity(user, HttpStatus.CREATED);
    }

    @RequestMapping(path = "/search", method = RequestMethod.GET)
    ResponseEntity search(@RequestParam(name = "searchQuery") String searchQuery) {
        List<User> user = userService.findBySearchQuery(searchQuery);
        return new ResponseEntity(user, HttpStatus.ACCEPTED);
    }

    @ResponseStatus(value = HttpStatus.CONFLICT, code = HttpStatus.CONFLICT,
            reason = "A user with the same e-mail address is already registered. Please try again.")
    @ExceptionHandler(DataIntegrityViolationException.class)
    public void conflict() {
        LOGGER.error("Duplicate error. Please try again.");
    }
}