package com.example.exercisecontrolleradvise.Service;

import com.example.exercisecontrolleradvise.Api.ApiException;
import com.example.exercisecontrolleradvise.Model.User;
import com.example.exercisecontrolleradvise.Model.Vehicle;
import com.example.exercisecontrolleradvise.Repository.UserRepository;
import com.example.exercisecontrolleradvise.Repository.VehicleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VehicleService {

    private final VehicleRepository vehicleRepository;
    private final UserRepository userRepository;


    public List<Vehicle> getVehicle(){

        return vehicleRepository.findAll();
    }


    public void addVehicle(Vehicle vehicle){
        User user = userRepository.findUserById(vehicle.getUserid());
        if(user==null){
            throw new ApiException("user id not found");
        }
        vehicleRepository.save(vehicle);

    }

    public void updateVehicle(Integer id , Vehicle vehicle){
        Vehicle vehicle1 = vehicleRepository.findVehicleById(id);
        User user = userRepository.findUserById(vehicle.getUserid());
        if(vehicle1==null){
            throw new ApiException("id not found");
        }
        if(user==null){
            throw new ApiException("user id not found");
        }

        vehicle1.setVehicleType(vehicle.getVehicleType());
        vehicle1.setPlate(vehicle.getPlate());
        vehicle1.setUserid(vehicle.getUserid());
        vehicleRepository.save(vehicle1);
    }


    public void deleteVehicle(Integer id){
        Vehicle vehicle1 = vehicleRepository.findVehicleById(id);
        if(vehicle1==null){
            throw new ApiException("id not found");
        }

        vehicleRepository.delete(vehicle1);
    }

    public List<Vehicle> getByUserId(Integer userid){
        List<Vehicle> vehicle = vehicleRepository.findVehicleByUserid(userid);
        if(vehicle.isEmpty()){
            throw new ApiException("this user dont have any vehicle");
        }

        return vehicle;
    }
}

