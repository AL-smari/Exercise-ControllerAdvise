package com.example.exercisecontrolleradvise.Controller;

import com.example.exercisecontrolleradvise.Model.User;
import com.example.exercisecontrolleradvise.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserService userService;

    Logger logger = LoggerFactory.getLogger(UserController.class);

    @GetMapping("/get")
    public ResponseEntity getUser(){
        logger.info("in UserController get");
        return ResponseEntity.status(HttpStatus.OK).body(userService.getUser());
    }

    @PostMapping("/add")
    public ResponseEntity addUser(@Valid@RequestBody User user){
        logger.info("in UserController add");
        userService.addUser(user);
        return ResponseEntity.status(HttpStatus.OK).body("user added");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateUser(@PathVariable Integer id,@Valid@RequestBody User user){
        logger.info("in UserController update");
        userService.updateUser(id, user);
        return ResponseEntity.status(HttpStatus.OK).body("user updated");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteUser(@PathVariable Integer id){
        logger.info("in UserController delete");
        userService.deleteUser(id);
        return ResponseEntity.status(HttpStatus.OK).body("user deleted");
    }

    @GetMapping("/login/{username}/{password}")
    public ResponseEntity login(@PathVariable String username , @PathVariable String password){
        logger.info("in UserController login");
        userService.login(username, password);
        return ResponseEntity.status(HttpStatus.OK).body("login done");
    }

    @PutMapping("/addBalance/{id}/{amount}")
    public ResponseEntity addBalance(@PathVariable Integer id,@PathVariable double amount){
        logger.info("in UserController add balance");
        userService.addBalance(id,amount);

        return ResponseEntity.status(HttpStatus.OK).body("balance updated");
    }

    @PostMapping("/rent/{id}/{parking_id}/{hours}")
    public ResponseEntity rentParking(@PathVariable Integer id , @PathVariable Integer parking_id,@PathVariable Integer hours){
        logger.info("in UserController rent parking");
        userService.rentParking(id, parking_id, hours);
        return ResponseEntity.status(HttpStatus.OK).body("Parking rented");
    }

    @PutMapping("/subscribe/{id}")
    public ResponseEntity subscribe(@PathVariable Integer id){
        logger.info("in UserController subscribe");
        userService.subscribe(id);
        return ResponseEntity.status(HttpStatus.OK).body("subscribe completed");
    }

    @PutMapping("/forget-password/{id}/{birthDate}/{password}")
    public ResponseEntity forgetPassword(@PathVariable Integer id , @PathVariable String birthDate, @PathVariable String password){
        logger.info("in UserController forget password");
        userService.forgetPassword(id, birthDate, password);
        return ResponseEntity.status(HttpStatus.OK).body("password updated");
    }

    @GetMapping("/getSubscribed")
    public ResponseEntity getAllSubscribed(){
        logger.info("in UserController get all subscribed");
        return ResponseEntity.status(HttpStatus.OK).body(userService.getAllSubscribed());
    }
}

