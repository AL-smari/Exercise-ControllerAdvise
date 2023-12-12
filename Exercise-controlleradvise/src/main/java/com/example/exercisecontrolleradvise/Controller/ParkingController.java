package com.example.exercisecontrolleradvise.Controller;

import com.example.exercisecontrolleradvise.Model.Parking;
import com.example.exercisecontrolleradvise.Service.ParkingService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/parking")
@RequiredArgsConstructor
public class ParkingController {

    private final ParkingService parkingService;

    Logger logger = LoggerFactory.getLogger(ParkingController.class);

    @GetMapping("/get")
    public ResponseEntity getParking(){
        logger.info("in ParkingController get");
        return ResponseEntity.status(HttpStatus.OK).body(parkingService.getParking());
    }
    @PostMapping("/add")
    public ResponseEntity addParking(@Valid@RequestBody Parking parking){
        logger.info("in ParkingController add");
        parkingService.addParking(parking);
        return ResponseEntity.status(HttpStatus.OK).body("parking added");

    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateParking(@PathVariable Integer id, @Valid@RequestBody Parking parking){

        logger.info("in ParkingController update");
        parkingService.updateParking(id, parking);
        return ResponseEntity.status(HttpStatus.OK).body("parking update");

    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteParking(@PathVariable Integer id){
        logger.info("in ParkingController delete");
        parkingService.deleteParking(id);
        return ResponseEntity.status(HttpStatus.OK).body("parking deleted");


    }

    @GetMapping("/getByPrice/{price}")
    public ResponseEntity getByPrice(@PathVariable double price){
        logger.info("in ParkingController get by price");
        return ResponseEntity.status(HttpStatus.OK).body(parkingService.getByPrice(price));
    }
    @GetMapping("/getByPosition/{position}")
    public ResponseEntity getByPosition(@PathVariable String position){
        logger.info("in ParkingController get by position");
        return ResponseEntity.status(HttpStatus.OK).body(parkingService.getByPosition(position));
    }
    @GetMapping("/getByAvailable")
    public ResponseEntity getByAvailable(){
        logger.info("in ParkingController get by available");
        return ResponseEntity.status(HttpStatus.OK).body(parkingService.getByAvailable());
    }
    @GetMapping("/getByCategory/{category}")
    public ResponseEntity getByCategory(@PathVariable String category){
        logger.info("in ParkingController get by category");
        return ResponseEntity.status(HttpStatus.OK).body(parkingService.getByCategory(category));
    }

}
