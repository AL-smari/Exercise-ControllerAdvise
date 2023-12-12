package com.example.exercisecontrolleradvise.Controller;


import com.example.exercisecontrolleradvise.Model.Pass;
import com.example.exercisecontrolleradvise.Service.PassService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;


@RestController
@RequestMapping("/api/v1/pass")
@RequiredArgsConstructor
public class PassController {

    private final PassService passService;

    Logger logger = LoggerFactory.getLogger(PassController.class);

    @GetMapping("/get")
    public ResponseEntity getPasses(){
        logger.info("in PassController get");
        return ResponseEntity.status(HttpStatus.OK).body(passService.getPasses());
    }


    @PostMapping("/add")
    public ResponseEntity addPass(@Valid @RequestBody Pass pass){

        logger.info("in PassController add");
        passService.addPass(pass);
        return ResponseEntity.status(HttpStatus.OK).body("pass added");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updatePass(@PathVariable Integer id ,@Valid @RequestBody Pass pass){

        logger.info("in PassController update");
        passService.updatePass(id, pass);
        return ResponseEntity.status(HttpStatus.OK).body("pass updated");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deletePass(@PathVariable Integer id){
        logger.info("in PassController delete");
        passService.deletePass(id);

        return ResponseEntity.status(HttpStatus.OK).body("pass deleted");
    }
    @PutMapping("/extend/{id}/{user_id}/{hours}")
    public ResponseEntity extendTime(@PathVariable Integer id , @PathVariable Integer user_id,@PathVariable Integer hours){
        logger.info("in PassController extendTime");
        passService.extend(id, user_id, hours);
        return ResponseEntity.status(HttpStatus.OK).body("pass time extended");
    }


    @GetMapping("/history/{userid}")
    public ResponseEntity getHistory(@PathVariable Integer userid){
        logger.info("in PassController get history");
        return ResponseEntity.status(HttpStatus.OK).body(passService.getHistory(userid));
    }
    @GetMapping("/getByDate/{start}/{end}")
    public ResponseEntity getBetweenDate(@PathVariable  LocalDateTime start, @PathVariable LocalDateTime end){
        logger.info("in PassController get between date");
        return ResponseEntity.status(HttpStatus.OK).body(passService.getBetweenDate(start, end));
    }
    @GetMapping("/getByState/{state}")
    public ResponseEntity getByState(@PathVariable String state){
        logger.info("in PassController get by state");
        return ResponseEntity.status(HttpStatus.OK).body(passService.getByState(state));
    }
}

