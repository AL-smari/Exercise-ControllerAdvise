package com.example.exercisecontrolleradvise.Controller;


import com.example.exercisecontrolleradvise.Model.Vehicle;
import com.example.exercisecontrolleradvise.Service.VehicleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/vehicle")
public class VehicleController {

    private final VehicleService vehicleService;
    Logger logger = LoggerFactory.getLogger(VehicleController.class);

    @GetMapping("/get")
    public ResponseEntity getVehicle(){
        logger.info("in VehicleController get");
        return ResponseEntity.status(HttpStatus.OK).body(vehicleService.getVehicle());
    }

    @PostMapping("/add")
    public ResponseEntity addVehicle(@Valid@RequestBody Vehicle vehicle){
        logger.info("in VehicleController add");
        vehicleService.addVehicle(vehicle);
        return ResponseEntity.status(HttpStatus.OK).body("vehicle added");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity UpdateVehicle(@PathVariable Integer id, @Valid@RequestBody Vehicle vehicle){
        logger.info("in VehicleController update");
        vehicleService.updateVehicle(id, vehicle);
        return ResponseEntity.status(HttpStatus.OK).body("vehicle updated");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteVehicle(@PathVariable Integer id){
        logger.info("in VehicleController delete");

        vehicleService.deleteVehicle(id);
        return ResponseEntity.status(HttpStatus.OK).body("vehicle deletd");
    }
    @GetMapping("/getByUserId/{userid}")
    public ResponseEntity getByUserId(@PathVariable Integer userid){
        logger.info("in VehicleController get by user");

        return ResponseEntity.status(HttpStatus.OK).body(vehicleService.getByUserId(userid));
    }
}

